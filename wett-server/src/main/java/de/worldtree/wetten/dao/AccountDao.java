/**
 * 
 */
package de.worldtree.wetten.dao;

import java.util.List;

import de.worldtree.wetten.model.Account;

/**
 * @author pascal
 *
 */
public abstract class AccountDao extends AbstractDao {

	public abstract void create(List<Account> listAccounts);
	public abstract List<Account> findAll();
	public abstract Account findById(int id);
	public abstract Account findByName(String name);
	
}
