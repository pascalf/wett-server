package de.worldtree.wetten.dao;

import java.util.List;

import de.worldtree.wetten.model.Tip;

/**
 * @author pascal
 *
 */
public abstract class TipDao extends AbstractDao {

	public abstract List<Tip> findAll();
	public abstract Tip findByPlayerIdAndGameId(int playerId, int gameId);
}
