/*
 * This file is generated by jOOQ.
 */
package app.cash.backfila.client.jooq.gen.tables

import app.cash.backfila.client.jooq.gen.Jooq
import app.cash.backfila.client.jooq.gen.keys.KEY_MENU_PRIMARY
import app.cash.backfila.client.jooq.gen.tables.records.MenuRecord
import kotlin.collections.List
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row2
import org.jooq.Schema
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Menu(
  alias: Name,
  child: Table<out Record>?,
  path: ForeignKey<out Record, MenuRecord>?,
  aliased: Table<MenuRecord>?,
  parameters: Array<Field<*>?>?,
) : TableImpl<MenuRecord>(
  alias,
  Jooq.JOOQ,
  child,
  path,
  aliased,
  parameters,
  DSL.comment(""),
  TableOptions.table(),
) {
  companion object {

    /**
     * The reference instance of <code>jooq.menu</code>
     */
    val MENU = Menu()
  }

  /**
   * The class holding records for this type
   */
  override fun getRecordType(): Class<MenuRecord> = MenuRecord::class.java

  /**
   * The column <code>jooq.menu.id</code>.
   */
  val ID: TableField<MenuRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

  /**
   * The column <code>jooq.menu.name</code>.
   */
  val NAME: TableField<MenuRecord, String?> = createField(DSL.name("name"), SQLDataType.VARCHAR(128).nullable(false), this, "")

  private constructor(alias: Name, aliased: Table<MenuRecord>?) : this(alias, null, null, aliased, null)
  private constructor(alias: Name, aliased: Table<MenuRecord>?, parameters: Array<Field<*>?>?) : this(alias, null, null, aliased, parameters)

  /**
   * Create an aliased <code>jooq.menu</code> table reference
   */
  constructor(alias: String) : this(DSL.name(alias))

  /**
   * Create an aliased <code>jooq.menu</code> table reference
   */
  constructor(alias: Name) : this(alias, null)

  /**
   * Create a <code>jooq.menu</code> table reference
   */
  constructor() : this(DSL.name("menu"), null)

  constructor(child: Table<out Record>, key: ForeignKey<out Record, MenuRecord>) : this(Internal.createPathAlias(child, key), child, key, MENU, null)
  override fun getSchema(): Schema = Jooq.JOOQ
  override fun getIdentity(): Identity<MenuRecord, Long?> = super.getIdentity() as Identity<MenuRecord, Long?>
  override fun getPrimaryKey(): UniqueKey<MenuRecord> = KEY_MENU_PRIMARY
  override fun getKeys(): List<UniqueKey<MenuRecord>> = listOf(KEY_MENU_PRIMARY)
  override fun `as`(alias: String): Menu = Menu(DSL.name(alias), this)
  override fun `as`(alias: Name): Menu = Menu(alias, this)

  /**
   * Rename this table
   */
  override fun rename(name: String): Menu = Menu(DSL.name(name), null)

  /**
   * Rename this table
   */
  override fun rename(name: Name): Menu = Menu(name, null)

  // -------------------------------------------------------------------------
  // Row2 type methods
  // -------------------------------------------------------------------------
  override fun fieldsRow(): Row2<Long?, String?> = super.fieldsRow() as Row2<Long?, String?>
}
