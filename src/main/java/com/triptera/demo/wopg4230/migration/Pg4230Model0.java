package com.triptera.demo.wopg4230.migration;

import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;

public class Pg4230Model0 extends ERXMigrationDatabase.Migration {

  @Override
  public void downgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
    // DO NOTHING
  }

  @Override
  public void upgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
    ERXMigrationTable tblPerson = database.newTableNamed("tbl_person");
    tblPerson.newBigDecimalColumn("dollar_amount", 38, 4, ALLOWS_NULL);
    tblPerson.newIntegerColumn("id_person", NOT_NULL);
    tblPerson.create();
    tblPerson.setPrimaryKey("id_person");
  }

}
