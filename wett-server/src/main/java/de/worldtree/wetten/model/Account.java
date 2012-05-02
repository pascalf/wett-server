/**
 * 
 */
package de.worldtree.wetten.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author pascal
 *
 */
@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME", unique=true)
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="ACCOUNTRIGHTS", 
		joinColumns= {
			@JoinColumn(name="PLAYERID")
		},
		inverseJoinColumns= {
			@JoinColumn(name="ROLEID")
		}
	)
	private Set<AccountRole> roles;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="EVENTPLAYER", 
		joinColumns= {
			@JoinColumn(name="PLAYERID")
		},
		inverseJoinColumns= {
			@JoinColumn(name="EVENTID")
		}
	)
	private Set<Event> events;
	
	/**
	 * @return the events
	 */
	public Set<Event> getEvents() {
		return events;
	}
	/**
	 * @param events the events to set
	 */
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
	public void addEvent(Event event) {
		getEvents().add(event);
		event.getUsers().add(this);
	}
	
	public void removeEvent(Event event) {
		getEvents().remove(event);
		event.getUsers().remove(this);
	}
	
	
	/**
	 * @return the roles
	 */
	public Set<AccountRole> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<AccountRole> roles) {
		this.roles = roles;
	}
	
	public void addRole(AccountRole role) {
		getRoles().add(role);
		role.getAccounts().add(this);
	}
	
	public void removeRole(AccountRole role) {
		getRoles().remove(role);
		role.getAccounts().remove(this);
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
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", email=" + email
				+ ", password=" + password + "]";
	}	
}
