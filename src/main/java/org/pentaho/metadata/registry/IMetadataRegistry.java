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

import java.util.List;
import java.util.Set;

/**
 * Interface for a metadata registry
 * 
 * @author jamesdixon
 * 
 */
public interface IMetadataRegistry {

  /**
   * Initializes the metadata registry
   * 
   * @throws Exception
   */
  public void init() throws Exception;

  /**
   * Returns true if the metadata registry has initialized successfully
   * 
   * @return
   */
  public boolean isInitialized();

  /**
   * Resets the registry to an empty state
   */
  public void clear();

  /**
   * Adds an entity to the registry
   * 
   * @param entity
   */
  public void addEntity( Entity entity );

  /**
   * Returns an specific entity of a specific type from the registry. Returns null if the entity cannot be found.
   * 
   * @param name
   * @param typeId
   * @return
   */
  public Entity getEntity( String id, String typeId );

  /**
   * Returns all entities with the specified id
   * 
   * @param name
   * @return
   */
  public List<Entity> getEntities( String id );

  /**
   * Deletes an entity from the registry
   * 
   * @param id
   * @return true if the operation succeeded
   */
  public boolean removeEntity( Entity entity );

  /**
   * Adds a namespace to the registry
   * 
   * @param namespace
   */
  public void addNamespace( Namespace namespace );

  /**
   * Returns a list of all known namespaces
   * 
   * @return
   */
  public List<Namespace> getNamespaces();

  /**
   * Returns a list of all known entity types
   * 
   * @return
   */
  public List<Type> getTypes();

  /**
   * Sets the known entity types
   * 
   * @param types
   */
  public void setTypes( List<Type> types );

  /**
   * Sets the known namespaces
   * 
   * @param namespaces
   */
  public void setNamespaces( List<Namespace> namespaces );

  /**
   * Adds a entity type to the registry
   * 
   * @param type
   */
  public void addType( Type type );

  /**
   * Adds a new verb to the registry
   * 
   * @param verb
   */
  public void addVerb( Verb verb );

  /**
   * Returns a list of known verbs
   * 
   * @return
   */
  public List<Verb> getVerbs();

  /**
   * Sets the collection of known verbs
   * 
   * @param verbs
   */
  public void setVerbs( List<Verb> verbs );

  /**
   * Adds a new link to the registry
   * 
   * @param link
   */
  public void addLink( Link link );

  /**
   * Returns a list of all known links in the registry
   * 
   * @return
   */
  public List<Link> getLinks();

  /**
   * Deletes a link from the registry
   * 
   * @param id
   * @return
   */
  public boolean removeLink( Link link );

  /**
   * Adds a new link type
   * 
   * @param link
   */
  public void addTypeLink( TypeLink link );

  /**
   * Returns a list of link types
   * 
   * @return
   */
  public List<TypeLink> getTypeLinks();

  /**
   * Returns a list of all the entities with the specified type
   * 
   * @param typeId
   * @param match
   *          Optional. Will be used to match on the id of the entity
   * @param exactMatch
   *          Optional. If true the match on the id must be exact
   * @return
   */
  public List<Entity> getEntitiesOfType( String typeId, String match, boolean exactMatch );

  /**
   * Returns a list of links to an entity that match the verb and type specified. For example given a specified physical
   * table find links to objects of type transformation that populate (verb) the table.
   * 
   * @param subjectId
   *          The id of the source entity
   * @param verbId
   *          The type of link to return
   * @param typeId
   *          The type of linked objects to return
   * @return
   */
  public List<Link> findObjectLinks( String subjectId, String verbId, String typeId );

  /**
   * Returns a list of links to an entity that match the verbs and types specified.
   * 
   * @param subjectId
   * @param verbIds
   * @param typeIds
   * @return
   */
  public List<Link> findObjectLinks( String subjectId, Set<String> verbIds, Set<String> typeIds );

  /**
   * Returns a list of links to an entity that match the verb and type specified. For example given a specified model
   * find links to objects of type view that use (verb) the model.
   * 
   * @param objectId
   *          The id of the source entity
   * @param verbId
   *          The type of link to return
   * @param typeId
   *          The type of linked objects to return
   * @return
   */
  public List<Link> findSubjectLinks( String objectId, String verbId, String typeId );

  /**
   * Returns a list of links to an entity that match the verbs and types specified. For example given a specified model
   * find links to objects of type view or report that use (verb) the model.
   * 
   * @param objectId
   *          The id of the source entity
   * @param verbId
   *          The type of link to return
   * @param typeIds
   *          The types of linked objects to return
   * @return
   */
  public List<Link> findSubjectLinks( String objectId, Set<String> verbIds, Set<String> typeIds );

  /**
   * Returns a list of links between the specified entity and entities of a specific type.
   * 
   * @param entityId
   * @param typeId
   * @return
   */
  public List<Link> findDirectLinks( String entityId, String typeId );

  /**
   * Returns a list of links between the specified entity and entities of a specific types.
   * 
   * @param entityId
   * @param typeIds
   * @return
   */
  public List<Link> findDirectLinks( String entityId, Set<String> typeIds );

  /**
   * Returns a list of all entities of the specified type that are linked in any way to the specified entity
   * 
   * @param entityId
   * @param typeId
   * @return
   */
  public List<Entity> findAllLinkedEntities( String entityId, String typeId );

  /**
   * Returns a list of all entities of the specified types that are linked in any way to the specified entity
   * 
   * @param entityId
   * @param typeIds
   * @return
   */
  public List<Entity> findAllLinkedEntities( String entityId, Set<String> typeIds );

  /**
   * Flushes the state of the registry to its storage
   * 
   * @throws Exception
   */
  public void commit() throws Exception;

}
