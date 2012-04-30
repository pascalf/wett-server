/**
 * 
 */
package de.worldtree.wetten.dao;

import java.util.List;

import de.worldtree.wetten.model.EventPlayer;

/**
 * @author pascal
 *
 */
public abstract class EventPlayerDao extends AbstractDao {

	public abstract List<EventPlayer> findAll();
	public abstract List<EventPlayer> findByEventId(int eventId);
	public abstract List<EventPlayer> findByPlayerId(int playerId);
}
