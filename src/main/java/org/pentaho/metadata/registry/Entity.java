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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Defines a metadata entity. Id, type, and title must be provided. Attributes are optional. This is a lightweight,
 * serializable class
 * 
 * @author jamesdixon
 * 
 */
public class Entity implements Serializable, Comparable<Entity> {

  private static final long serialVersionUID = -3474839958774808729L;

  private String id;

  private String typeId;

  private String title;

  private Map<String, String> attributes = new HashMap<String, String>();

  public Entity() {

  }

  public Entity( String id, String title, String typeId ) {
    this.id = id;
    this.typeId = typeId;
    this.title = title;
  }

  /**
   * Returns the type id of the entity
   * 
   * @return
   */
  public String getTypeId() {
    return typeId;
  }

  /**
   * Returns the title of the entity
   * 
   * @return
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets the title of the entity
   * 
   * @param title
   */
  public void setTitle( String title ) {
    this.title = title;
  }

  /**
   * Sets the type id of the entity
   * 
   * @param typeId
   */
  public void setTypeId( String typeId ) {
    this.typeId = typeId;
  }

  /**
   * Gets the id of the entity
   * 
   * @return
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the id of the entity
   * 
   * @param id
   */
  public void setId( String id ) {
    this.id = id;
  }

  /**
   * Returns the attribute map of the entity
   * 
   * @return
   */
  public Map<String, String> getAttributes() {
    return attributes;
  }

  /**
   * Sets the attribute map of the entity. Arrtibute valuse should be serializable
   * 
   * @param attributes
   */
  public void setAttributes( Map<String, String> attributes ) {
    this.attributes = attributes;
  }

  /**
   * Returns an attribute of the entity
   * 
   * @param name
   * @return
   */
  public String getAttribute( String name ) {
    return attributes.get( name );
  }

  /**
   * Sets an attribute of the entity
   * 
   * @param name
   * @param object
   */
  public void setAttribute( String name, String object ) {
    attributes.put( name, object );
  }

  @Override
  public int compareTo( Entity arg0 ) {
    return id.compareTo( arg0.getId() );
  }

}
