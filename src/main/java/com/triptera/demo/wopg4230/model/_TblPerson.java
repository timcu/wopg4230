// $LastChangedRevision$ DO NOT EDIT.  Make changes to TblPerson.java instead.
package com.triptera.demo.wopg4230.model;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

import er.extensions.eof.ERXGenericRecord;

import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public abstract class _TblPerson extends  ERXGenericRecord {
	public static final String ENTITY_NAME = "TblPerson";

	// Attributes
	public static final String DOLLAR_AMOUNT_KEY = "dollarAmount";
	public static final String ID_PERSON_KEY = "idPerson";

	// Relationships

  private static Logger LOG = Logger.getLogger(_TblPerson.class);

  public TblPerson localInstanceIn(EOEditingContext editingContext) {
    TblPerson localInstance = (TblPerson)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public java.math.BigDecimal dollarAmount() {
    return (java.math.BigDecimal) storedValueForKey("dollarAmount");
  }

  public void setDollarAmount(java.math.BigDecimal value) {
    if (_TblPerson.LOG.isDebugEnabled()) {
    	_TblPerson.LOG.debug( "updating dollarAmount from " + dollarAmount() + " to " + value);
    }
    takeStoredValueForKey(value, "dollarAmount");
  }

  public Integer idPerson() {
    return (Integer) storedValueForKey("idPerson");
  }

  public void setIdPerson(Integer value) {
    if (_TblPerson.LOG.isDebugEnabled()) {
    	_TblPerson.LOG.debug( "updating idPerson from " + idPerson() + " to " + value);
    }
    takeStoredValueForKey(value, "idPerson");
  }


  public static TblPerson createTblPerson(EOEditingContext editingContext, Integer idPerson
) {
    TblPerson eo = (TblPerson) EOUtilities.createAndInsertInstance(editingContext, _TblPerson.ENTITY_NAME);    
		eo.setIdPerson(idPerson);
    return eo;
  }

  public static NSArray<TblPerson> fetchAllTblPersons(EOEditingContext editingContext) {
    return _TblPerson.fetchAllTblPersons(editingContext, null);
  }

  public static NSArray<TblPerson> fetchAllTblPersons(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _TblPerson.fetchTblPersons(editingContext, null, sortOrderings);
  }

  public static NSArray<TblPerson> fetchTblPersons(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_TblPerson.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<TblPerson> eoObjects = (NSArray<TblPerson>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static TblPerson fetchTblPerson(EOEditingContext editingContext, String keyName, Object value) {
    return _TblPerson.fetchTblPerson(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static TblPerson fetchTblPerson(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<TblPerson> eoObjects = _TblPerson.fetchTblPersons(editingContext, qualifier, null);
    TblPerson eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (TblPerson)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one TblPerson that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static TblPerson fetchRequiredTblPerson(EOEditingContext editingContext, String keyName, Object value) {
    return _TblPerson.fetchRequiredTblPerson(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static TblPerson fetchRequiredTblPerson(EOEditingContext editingContext, EOQualifier qualifier) {
    TblPerson eoObject = _TblPerson.fetchTblPerson(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no TblPerson that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static TblPerson localInstanceIn(EOEditingContext editingContext, TblPerson eo) {
    TblPerson localInstance = (eo == null) ? null : (TblPerson)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
