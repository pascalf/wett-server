/**
 * 
 */
package de.worldtree.wetten.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author pascal
 *
 */
@Entity
@IdClass(TipCompoundKey.class)
public class Tip {

	@Id
	private int gameId;
	@Id
	private int playerId;
	@Column(name="TIPHOME")
	private int tipHome;
	@Column(name="TIPAWAY")
	private int tipAway;
	
	@OneToOne
	@JoinColumn(name="GAMEID")
	private Game game;
	@OneToOne
	@JoinColumn(name="PLAYERID")
	private Account user;
	
	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}
	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}
	/**
	 * @return the user
	 */
	public Account getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(Account user) {
		this.user = user;
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
				+ ", tipHome=" + tipHome + ", tipAway=" + tipAway + ", user.name=" + user.getName() + ", game=" + game + "]";
	}
	
}
