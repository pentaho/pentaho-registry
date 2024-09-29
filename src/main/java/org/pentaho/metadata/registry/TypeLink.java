/*! ******************************************************************************
 *
 * Pentaho
 *
 * Copyright (C) 2024 by Hitachi Vantara, LLC : http://www.pentaho.com
 *
 * Use of this software is governed by the Business Source License included
 * in the LICENSE.TXT file.
 *
 * Change Date: 2028-08-13
 ******************************************************************************/


package org.pentaho.metadata.registry;

/**
 * Defines a common link between two types. For example type "TRANSFORMATION" "POPULATES" "PHYSICAL TABLE"
 * 
 * @author jamesdixon
 * 
 */
public class TypeLink {

  private String subjectTypeId;
  private String verbId;
  private String objectTypeId;

  public TypeLink() {

  }

  public TypeLink( String subjectTypeId, String verbId, String objectTypeId ) {
    this.subjectTypeId = subjectTypeId;
    this.verbId = verbId;
    this.objectTypeId = objectTypeId;
  }

  /**
   * Returns the type id of the subject
   * 
   * @return
   */
  public String getSubjectTypeId() {
    return subjectTypeId;
  }

  /**
   * Sets the type id of the subject
   * 
   * @param subjectTypeId
   */
  public void setSubjectTypeId( String subjectTypeId ) {
    this.subjectTypeId = subjectTypeId;
  }

  /**
   * Returns the type id of the object
   * 
   * @return
   */
  public String getObjectTypeId() {
    return objectTypeId;
  }

  /**
   * Sets the type id of the object
   * 
   * @param objectTypeId
   */
  public void setObjectTypeId( String objectTypeId ) {
    this.objectTypeId = objectTypeId;
  }

  /**
   * Returns the id of the verb that connects the subject and the object
   * 
   * @return
   */
  public String getVerbId() {
    return verbId;
  }

  /**
   * Sets the id of the verb that connects the subject and the object
   * 
   * @param verbId
   */
  public void setVerbId( String verbId ) {
    this.verbId = verbId;
  }

}
