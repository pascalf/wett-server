/**
 * 
 */
package de.worldtree.wetten.model;

/**
 * @author pascal
 *
 */
public class Tip {

	private int gameId;
	private int playerId;
	private int tipHome;
	private int tipAway;
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
	/**
	 * @return the tipHome
	 */
	public int getTipHome() {
		return tipHome;
	}
	/**
	 * @param tipHome the tipHome to set
	 */
	public void setTipHome(int tipHome) {
		this.tipHome = tipHome;
	}
	/**
	 * @return the tipAway
	 */
	public int getTipAway() {
		return tipAway;
	}
	/**
	 * @param tipAway the tipAway to set
	 */
	public void setTipAway(int tipAway) {
		this.tipAway = tipAway;
	}
	@Override
	public String toString() {
		return "Tip [gameId=" + gameId + ", playerId=" + playerId
				+ ", tipHome=" + tipHome + ", tipAway=" + tipAway + "]";
	}
	
}
