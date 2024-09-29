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
 * Defines a namespace for the registry
 * 
 * @author jamesdixon
 * 
 */
public class Namespace {

  // define static global namespaces
  public static final Namespace NAMESPACE_GLOBAL = new Namespace( "GLOBAL" );
  public static final Namespace NAMESPACE_PDI = new Namespace( "PDI" );
  public static final Namespace NAMESPACE_MODELING = new Namespace( "MODELING" );
  public static final Namespace NAMESPACE_ANALYZER = new Namespace( "ANALYZER" );
  public static final Namespace NAMESPACE_REPORTING = new Namespace( "REPORTING" );

  private String id;

  private String tool;

  public Namespace() {
  }

  public Namespace( String id ) {
    this.id = id;
  }

  /**
   * Returns the id of this namespace
   * 
   * @return
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the id of this namespace
   * 
   * @param id
   */
  public void setId( String id ) {
    this.id = id;
  }

  /**
   * Returns the default tool for this namespace
   * 
   * @return
   */
  public String getTool() {
    return tool;
  }

  /**
   * Sets the default tool for this namespace
   * 
   * @param tool
   */
  public void setTool( String tool ) {
    this.tool = tool;
  }

}
