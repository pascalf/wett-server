/**
 * 
 */
package de.worldtree.wetten.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author pascal
 *
 */
@Entity
@Table(name="ACCOUNTROLE")
public class AccountRole {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private Set<Account> accounts;
	
	/**
	 * @return the accounts
	 */
	public Set<Account> getAccounts() {
		return accounts;
	}
	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void addAccount(Account account) {
		getAccounts().add(account);
		account.getRoles().add(this);
	}
	
	public void removeAccount(Account account) {
		getAccounts().remove(account);
		account.getRoles().remove(this);
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
		return "AccountRole [id=" + id + ", name=" + name + "]";
	}
}
