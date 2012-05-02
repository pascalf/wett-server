/**
 * 
 */
package de.worldtree.wetten.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import de.worldtree.wetten.util.DateUtils;

/**
 * @author pascal
 *
 */
@Entity
public class Game {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private int id;
	private int eventId;
	private String homeTeam;
	private String awayTeam;
	private Integer resultHome;
	private Integer resultAway;
	@Temporal(TemporalType.TIMESTAMP)
	private Date closingTime;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the eventId
	 */
	public int getEventId() {
		return eventId;
	}
	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	/**
	 * @return the homeTeam
	 */
	public String getHomeTeam() {
		return homeTeam;
	}
	/**
	 * @param homeTeam the homeTeam to set
	 */
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	/**
	 * @return the awayTeam
	 */
	public String getAwayTeam() {
		return awayTeam;
	}
	/**
	 * @param awayTeam the awayTeam to set
	 */
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	/**
	 * @param resultHome the resultHome to set
	 */
	public void setResultHome(Integer resultHome) {
		this.resultHome = resultHome;
	}
	/**
	 * @param resultAway the resultAway to set
	 */
	public void setResultAway(Integer resultAway) {
		this.resultAway = resultAway;
	}
	/**
	 * @return the resultHome
	 */
	public Integer getResultHome() {
		return resultHome;
	}
	/**
	 * @return the resultAway
	 */
	public Integer getResultAway() {
		return resultAway;
	}
	/**
	 * @return the closingTime
	 */
	public Date getClosingTime() {
		return closingTime;
	}
	/**
	 * @param closingTime the closingTime to set
	 */
	public void setClosingTime(Date closingTime) {
		this.closingTime = closingTime;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", eventId=" + eventId + ", homeTeam="
				+ homeTeam + ", awayTeam=" + awayTeam + ", resultHome="
				+ resultHome + ", resultAway=" + resultAway + ", closingTime="
				+ DateUtils.getSimpleDateFormat().format(closingTime) + "]";
	}
	
}
