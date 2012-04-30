/**
 * 
 */
package de.worldtree.wetten.service.model;

import de.worldtree.wetten.model.Account;
import de.worldtree.wetten.model.Tip;

/**
 * @author pascal
 *
 */
public class PlayerTip {
	
	private Account player;
	/**
	 * @return the player
	 */
	public Account getPlayer() {
		return player;
	}
	/**
	 * @param player the player to set
	 */
	public void setPlayer(Account player) {
		this.player = player;
	}
	/**
	 * @return the tip
	 */
	public Tip getTip() {
		return tip;
	}
	/**
	 * @param tip the tip to set
	 */
	public void setTip(Tip tip) {
		this.tip = tip;
	}
	private Tip tip;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlayerTip [player=" + player + ", tip=" + tip + "]";
	}
	
	

}
