/**
 * 
 */
package de.worldtree.wetten.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author pascal
 *
 */
@Embeddable
public class TipCompoundKey implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int gameId;
	private int playerId;
	
	public TipCompoundKey() {}
	
	/**
	 * @param gameId
	 * @param playerId
	 */
	public TipCompoundKey(int gameId, int playerId) {
		this.gameId = gameId;
		this.playerId = playerId;
	}

	/**
	 * @return the gameId
	 */
	public int getGameId() {
		return gameId;
	}

	/**
	 * @param gameId the gameId to set
	 */
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	/**
	 * @return the playerId
	 */
	public int getPlayerId() {
		return playerId;
	}

	/**
	 * @param playerId the playerId to set
	 */
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gameId;
		result = prime * result + playerId;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TipCompoundKey))
			return false;
		TipCompoundKey other = (TipCompoundKey) obj;
		if (gameId != other.gameId)
			return false;
		if (playerId != other.playerId)
			return false;
		return true;
	}
	
	
	
	

}
