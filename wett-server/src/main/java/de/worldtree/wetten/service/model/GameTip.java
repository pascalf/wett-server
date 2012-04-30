/**
 * 
 */
package de.worldtree.wetten.service.model;

import java.util.List;

import de.worldtree.wetten.model.Game;

/**
 * @author pascal
 *
 */
public class GameTip {
	
	private Game game;
	private List<PlayerTip> playerTips;
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
	 * @return the playerTips
	 */
	public List<PlayerTip> getPlayerTips() {
		return playerTips;
	}
	/**
	 * @param playerTips the playerTips to set
	 */
	public void setPlayerTips(List<PlayerTip> playerTips) {
		this.playerTips = playerTips;
	}

}
