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
 * Defines a link between two existing entities. Links are defined between a subject and an bject using a verb.
 * 
 * @author jamesdixon
 * 
 */
public class Link {

  private String subjectId;
  private String subjectTypeId;
  private String verbId;
  private String objectId;
  private String objectTypeId;

  public Link() {
  }

  public Link( Entity subject, Verb verb, Entity object ) {
    this( subject.getId(), subject.getTypeId(), verb.getId(), object.getId(), object.getTypeId() );
  }

  public Link( String subjectId, String subjectTypeId, String verbId, String objectId, String objectTypeId ) {
    this.subjectId = subjectId;
    this.subjectTypeId = subjectTypeId;
    this.verbId = verbId;
    this.objectId = objectId;
    this.objectTypeId = objectTypeId;
  }

  /**
   * Returns the type id of the subject entity
   * 
   * @return
   */
  public String getSubjectTypeId() {
    return subjectTypeId;
  }

  /**
   * Sets the type of the subject entity
   * 
   * @param subjectTypeId
   */
  public void setSubjectTypeId( String subjectTypeId ) {
    this.subjectTypeId = subjectTypeId;
  }

  /**
   * Returns the type id of the object entity
   * 
   * @return
   */
  public String getObjectTypeId() {
    return objectTypeId;
  }

  /**
   * Sets the type of the object entity
   * 
   * @param objectTypeId
   */
  public void setObjectTypeId( String objectTypeId ) {
    this.objectTypeId = objectTypeId;
  }

  /**
   * Returns the id of the subject entity
   * 
   * @return
   */
  public String getSubjectId() {
    return subjectId;
  }

  /**
   * Sets the id of the subject entity
   * 
   * @param subjectId
   */
  public void setSubjectId( String subjectId ) {
    this.subjectId = subjectId;
  }

  /**
   * Returns the id of the object entity
   * 
   * @return
   */
  public String getObjectId() {
    return objectId;
  }

  /**
   * Sets the id of the object entity
   * 
   * @param objectId
   */
  public void setObjectId( String objectId ) {
    this.objectId = objectId;
  }

  /**
   * Returns the id of the verb
   * 
   * @return
   */
  public String getVerbId() {
    return verbId;
  }

  /**
   * Sets the id of the verb
   * 
   * @param verbId
   */
  public void setVerbId( String verbId ) {
    this.verbId = verbId;
  }

}
