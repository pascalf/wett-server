/**
 * 
 */
package de.worldtree.wetten.dao;

import java.util.Date;
import java.util.List;

import de.worldtree.wetten.model.Game;

/**
 * @author pascal
 *
 */
public abstract class GameDao extends AbstractDao {

	public abstract List<Game> findAll();
	public abstract Game findById(int id);
	public abstract List<Game> findByEventId(int id);
	public abstract List<Game> findByEventIdAndClosedTimeGone(int id, Date time);
	public abstract List<Game> findByEventIdAndClosedTimeNotGone(int id, Date time);
}
