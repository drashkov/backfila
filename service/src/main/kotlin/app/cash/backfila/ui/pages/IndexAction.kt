package app.cash.backfila.ui.pages

import app.cash.backfila.ui.components.AlertError
import app.cash.backfila.ui.components.DashboardLayout
import app.cash.backfila.ui.components.PageTitle
import app.cash.backfila.ui.components.ServiceAutocompleteWrapper
import javax.inject.Inject
import misk.hotwire.buildHtml
import misk.security.authz.Unauthenticated
import misk.web.Get
import misk.web.QueryParam
import misk.web.ResponseContentType
import misk.web.actions.WebAction
import misk.web.mediatype.MediaTypes

class IndexAction @Inject constructor() : WebAction {
  @Get(PATH)
  @ResponseContentType(MediaTypes.TEXT_HTML)
  @Unauthenticated
  fun get(
    @QueryParam s: String?,
    @QueryParam e: String?,
  ): String {
    return buildHtml {
      DashboardLayout(
        title = "Backfila",
        path = PATH,
      ) {
        PageTitle("Backfila", s)
        e?.let { AlertError(it) }
        ServiceAutocompleteWrapper(s, "/service")
      }
    }
  }

  companion object {
    const val PATH = "/"
  }
}
