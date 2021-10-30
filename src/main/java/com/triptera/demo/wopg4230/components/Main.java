// Generated by the Maven Archetype Plug-in
package com.triptera.demo.wopg4230.components;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.triptera.demo.wopg4230.model.TblPerson;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.eof.ERXEC;

public class Main extends WOComponent {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Main.class);

	public Main(WOContext context) {
		super(context);
	}
	
	private static EOEditingContext ec; 
	public EOEditingContext ec() {
	  if (ec == null) {
	    ec = ERXEC.newEditingContext();
	  }
	  return ec;
	}
	
	private TblPerson thePerson;
	public TblPerson thePerson() {
	  if (thePerson == null) {
	    // Find the first record in database
	    thePerson = TblPerson.fetchTblPerson(ec(), null);
	    if (thePerson == null) {
	      thePerson = new TblPerson();
	      ec().insertObject(thePerson);
	      thePerson.setDollarAmount(BigDecimal.valueOf(1500000000, 4));
	      ec().saveChanges();
	    }
	  }
	  return thePerson;
	}
	
	public WOActionResults doSave() {
	  ec().saveChanges();
	  tfEdit = false;
	  return null;
	}
	
	public WOActionResults doEdit() {
	  tfEdit = true;
	  return null;
	}
	
	public boolean tfEdit;
	public final String fmt = "$#,##0; ($#,##0)"; 
	
	public void doRepeatSave() {
	  EOEditingContext ec = ERXEC.newEditingContext();
	  // fetch the first record from database table tbl_person
	  TblPerson p = TblPerson.fetchTblPerson(ec, null);
	  BigDecimal bd150k = BigDecimal.valueOf(1500000000, 4);
	  for (int i=0; i < 10; i++) {
	    p.setDollarAmount(bd150k);
	    ec.saveChanges();
	    logger.info("Count " + i + " p.dollarAmount=" + p.dollarAmount() );
	  }
	}
}
