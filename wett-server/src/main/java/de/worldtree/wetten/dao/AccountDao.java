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
public interface AccountDao {

	public abstract List<Account> findAll();
	public abstract Account findById(int id);
	public abstract Account findByName(String name);
	
}
