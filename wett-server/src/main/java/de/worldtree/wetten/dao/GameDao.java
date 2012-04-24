/**
 * 
 */
package de.worldtree.wetten.dao;

import java.util.List;

import de.worldtree.wetten.model.Game;

/**
 * @author pascal
 *
 */
public interface GameDao {

	public abstract List<Game> findAll();
}
