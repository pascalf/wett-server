package de.worldtree.wetten.dao;

import java.util.List;

import de.worldtree.wetten.model.Tip;

/**
 * @author pascal
 *
 */
public interface TipDao {

	public abstract List<Tip> findAll();
	public abstract Tip findByPlayerIdAndGameId(int playerId, int gameId);
}
