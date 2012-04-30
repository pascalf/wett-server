/**
 * 
 */
package de.worldtree.wetten.model;

import java.io.Serializable;

/**
 * @author pascal
 *
 */
public class EventPlayer implements Serializable{

	private int eventId;
	private int playerId;
	/**
	 * @return the eventId
	 */
	public int getEventId() {
		return eventId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eventId;
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
		if (getClass() != obj.getClass())
			return false;
		EventPlayer other = (EventPlayer) obj;
		if (eventId != other.eventId)
			return false;
		if (playerId != other.playerId)
			return false;
		return true;
	}
	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EventPlayer [eventId=" + eventId + ", playerId=" + playerId
				+ "]";
	}
	
}
