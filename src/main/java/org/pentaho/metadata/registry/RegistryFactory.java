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
 * A factory for providing an implementation of the metadata registry
 * 
 * @author jamesdixon
 * 
 */
public class RegistryFactory {

  private static RegistryFactory instance;

  private IMetadataRegistry metadataRegistry;

  /**
   * Returns the instance of the registry factory
   * 
   * @return
   */
  public static RegistryFactory getInstance() {
    return instance;
  }

  /**
   * Returns the metadata registry
   * 
   * @return
   */
  public IMetadataRegistry getMetadataRegistry() {
    return metadataRegistry;
  }

  /**
   * Sets the metadata registry
   * 
   * @param metadataRegistry
   */
  public void setMetadataRegistry( IMetadataRegistry metadataRegistry ) {
    this.metadataRegistry = metadataRegistry;
  }

  static {
    instance = new RegistryFactory();
  }

}
