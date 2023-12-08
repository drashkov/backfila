package app.cash.backfila.ui.pages

import app.cash.backfila.dashboard.GetBackfillRunsAction
import app.cash.backfila.ui.SLACK_CHANNEL_NAME
import app.cash.backfila.ui.SLACK_CHANNEL_URL
import app.cash.backfila.ui.components.AlertInfoHighlight
import app.cash.backfila.ui.components.AlertSlackHelp
import app.cash.backfila.ui.components.BackfillsTable
import app.cash.backfila.ui.components.DashboardLayout
import app.cash.backfila.ui.components.PageTitle
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.html.role
import kotlinx.html.ul
import misk.hotwire.buildHtmlResponseBody
import misk.security.authz.Unauthenticated
import misk.web.Get
import misk.web.QueryParam
import misk.web.Response
import misk.web.ResponseBody
import misk.web.ResponseContentType
import misk.web.actions.WebAction
import misk.web.mediatype.MediaTypes

@Singleton
class ServiceShowAction @Inject constructor(
  private val getBackfillRunsAction: GetBackfillRunsAction,
) : WebAction {
  @Get(PATH)
  @ResponseContentType(MediaTypes.TEXT_HTML)
  @Unauthenticated
  fun checkService(
    @QueryParam s: String,
    @QueryParam("experimental") experimental: Boolean? = false,
  ): Response<ResponseBody> {
    val serviceName = s.split("/").first()
    val variant = s.split("/").last()

    val backfillRuns = getBackfillRunsAction.backfillRuns(serviceName, variant)

    val htmlResponseBody = buildHtmlResponseBody {
      // TODO show default if other variants and probably link to a switcher
      val label = if (variant == "default") serviceName else "$serviceName ($variant)"
      DashboardLayout(
        title = "$label | Backfila",
        path = PATH,
      ) {
        PageTitle("Service", label)

        // TODO Add completed table
        // TODO Add deleted support?
        BackfillsTable(true, backfillRuns.running_backfills)
        BackfillsTable(false, backfillRuns.paused_backfills)

        ul("space-y-3") {
          role = "list"
        }

        AlertSlackHelp()
      }
    }

    return Response(htmlResponseBody)
  }

  companion object {
    const val PATH = "/services/"
  }
}
