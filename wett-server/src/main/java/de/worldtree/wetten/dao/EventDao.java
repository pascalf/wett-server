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
public interface EventDao {

	public abstract List<Event> findAll();
	public abstract Event findById(int id);
	public abstract Event findByName(String name);
}
