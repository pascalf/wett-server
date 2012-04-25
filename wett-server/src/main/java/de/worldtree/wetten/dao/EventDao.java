/**
 * 
 */
package de.worldtree.wetten.dao;

import java.util.List;

import de.worldtree.wetten.model.Event;

/**
 * @author pascal
 *
 */
public abstract class EventDao extends AbstractDao {

	public abstract List<Event> findAll();
	public abstract Event findById(int id);
	public abstract Event findByName(String name);
}
