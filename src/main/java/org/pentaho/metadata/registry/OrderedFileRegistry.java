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

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringEscapeUtils;
import org.owasp.encoder.Encode;

/**
 * A subclass of the simple registry that persists the registry in an XML document on the file system
 * 
 * @author jamesdixon
 * 
 */
public class OrderedFileRegistry extends SimpleFileRegistry {

  public OrderedFileRegistry() throws Exception {
    super();
  }

  /**
   * @see org.pentaho.metadata.registry.IMetadataRegistry#commit()
   */
  @Override
  public void commit() throws Exception {

    int idx = 0;
    Map<String, Map<String, Entity>> entities = getEntities();
    List<Entity> entityList = new ArrayList<Entity>();
    for ( Entry<String, Map<String, Entity>> entry : entities.entrySet() ) {
      Map<String, Entity> typeMap = entry.getValue();
      Set<Entry<String, Entity>> typeSet = typeMap.entrySet();
      for ( Entry<String, Entity> typeEntry : typeSet ) {
        Entity entity = typeEntry.getValue();
        entityList.add( entity );
      }
    }

    Collections.sort( entityList );

    File file = new File( getFilePath() );
    OutputStream out = new FileOutputStream( file );
    try {

      StringBuffer buffer = new StringBuffer();
      buffer.append( "" );

      buffer.append( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" );
      buffer.append( "<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">\n" );
      buffer.append( "<properties>\n" );

      idx = 0;
      for ( Entity entity : entityList ) {
        addToBuffer( entity, buffer, idx );
        idx++;
      }

      // save the links
      List<Link> links = getLinks();

      idx = 0;
      for ( Link link : links ) {
        addToBuffer( link, buffer, idx );
        idx++;
      }

      buffer.append( "</properties>" );
      out.write( buffer.toString().getBytes() );

    } finally {
      out.close();
    }
  }

  protected void addToBuffer( Entity entity, StringBuffer buffer, int idx ) {
    addToBuffer( "entity-" + idx + "-id", entity.getId(), buffer );
    addToBuffer( "entity-" + idx + "-type", entity.getTypeId(), buffer );
    if ( entity.getTitle() != null ) {
      addToBuffer( "entity-" + idx + "-title", entity.getTitle(), buffer );
    } else {
      addToBuffer( "entity-" + idx + "-title", entity.getId(), buffer );
    }
    Map<String, String> attrMap = entity.getAttributes();
    int idx2 = 0;
    for ( Entry<String, String> attrEntry : attrMap.entrySet() ) {
      String key = attrEntry.getKey();
      String value = attrEntry.getValue();
      addToBuffer( "entity-" + idx + "-attrkey-" + idx2, key, buffer );
      addToBuffer( "entity-" + idx + "-attrvalue-" + idx2, StringEscapeUtils.escapeJava( value ), buffer );
      idx2++;
    }

  }

  protected void addToBuffer( Link link, StringBuffer buffer, int idx ) {
    addToBuffer( "link-" + idx + "-subId", link.getSubjectId(), buffer );
    addToBuffer( "link-" + idx + "-subType", link.getSubjectTypeId(), buffer );
    addToBuffer( "link-" + idx + "-verb", link.getVerbId(), buffer );
    addToBuffer( "link-" + idx + "-objId", link.getObjectId(), buffer );
    addToBuffer( "link-" + idx + "-objType", link.getObjectTypeId(), buffer );
  }

  protected void addToBuffer( String id, String value, StringBuffer buffer ) {
    buffer.append( "<entry key=\"" ).append( Encode.forXmlAttribute( id ) ).append( "\">" ).append(
        Encode.forXml( value ) ).append( "</entry>\n" );
  }

}
