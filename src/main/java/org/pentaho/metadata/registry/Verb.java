/*! ******************************************************************************
 *
 * Pentaho
 *
 * Copyright (C) 2024 by Hitachi Vantara, LLC : http://www.pentaho.com
 *
 * Use of this software is governed by the Business Source License included
 * in the LICENSE.TXT file.
 *
 * Change Date: 2029-07-20
 ******************************************************************************/


package org.pentaho.metadata.registry;

/**
 * Defines a verb that is used to link entities in the metadata registry. Also defines static common verbs
 * 
 * @author jamesdixon
 * 
 */
public class Verb {

  public static final Verb VERB_POPULATES = new Verb( "POPULATES", "GLOBAL", "POPULATES" );
  public static final Verb VERB_READS = new Verb( "READS", "GLOBAL", "READS" );
  public static final Verb VERB_DEFINES = new Verb( "DEFINES", "GLOBAL", "DEFINES" );
  public static final Verb VERB_USES = new Verb( "USES", "GLOBAL", "USES" );
  public static final Verb VERB_EXECUTES = new Verb( "EXECUTES", "GLOBAL", "EXECUTES" );
  public static final Verb VERB_CREATED = new Verb( "CREATED", "GLOBAL", "CREATED" );

  private String id;

  private String namespaceId;

  private String verbId;

  public Verb() {
  }

  public Verb( String id, String namespaceId, String verbId ) {
    this.id = id;
    this.namespaceId = namespaceId;
    this.verbId = verbId;
  }

  /**
   * Returns the id of the verb
   * 
   * @return
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the id of the verb
   * 
   * @param id
   */
  public void setId( String id ) {
    this.id = id;
  }

  /**
   * Returns the id of the namespace of the verb
   * 
   * @return
   */
  public String getNamespaceId() {
    return namespaceId;
  }

  /**
   * Sets the id of the namespace of the verb
   * 
   * @param namespaceId
   */
  public void setNamespaceId( String namespaceId ) {
    this.namespaceId = namespaceId;
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
   * Sets the verb id
   * 
   * @param verbId
   */
  public void setVerbId( String verbId ) {
    this.verbId = verbId;
  }

}
