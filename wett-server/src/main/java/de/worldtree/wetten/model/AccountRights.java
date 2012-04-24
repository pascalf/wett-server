/**
 * 
 */
package de.worldtree.wetten.model;

/**
 * @author pascal
 *
 */
public class AccountRights {

	private int playerId;
	private int roleId;
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
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "AccountRights [playerId=" + playerId + ", roleId=" + roleId
				+ "]";
	}
	
}
