/**
 * 
 */
package de.worldtree.wetten.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author pascal
 *
 */
@Entity
@Table(name="EVENT")
public class Event {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	
	@ManyToMany(mappedBy="events")
	private Set<Account> users;
	
	@OneToMany
	@JoinColumn(name="EVENTID", unique = true)           
	private Set<Game> games;
	
	
	/**
	 * @return the users
	 */
	public Set<Account> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<Account> users) {
		this.users = users;
	}
	/**
	 * @return the games
	 */
	public Set<Game> getGames() {
		return games;
	}
	/**
	 * @param games the games to set
	 */
	public void setGames(Set<Game> games) {
		this.games = games;
	}
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + "]";
	}
	
}
