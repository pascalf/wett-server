/**
 * 
 */
package de.worldtree.wetten.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import de.worldtree.wetten.dao.AbstractDao;
import de.worldtree.wetten.dao.AccountDao;
import de.worldtree.wetten.model.Account;

/**
 * @author pascal
 *
 */
public class AccountDaoImpl extends AccountDao {
	
	private static final Log log = LogFactory.getLog(AccountDaoImpl.class);

	public void create(List<Account> listAccounts) { 
		Session session = getSessionFactory().openSession(); 
		session.getTransaction().begin(); 
		for (Account account : listAccounts) { 
			session.save(account); 
		} 
		session.getTransaction().commit(); 
	} 
	public List<Account> findAll() {
		log.debug(String.format("Call findAll() []"));
		Session session = getSessionFactory().openSession();
		session.getTransaction().begin();
		List<Account> list = session.createQuery("From Account").list();
		session.getTransaction().commit();
		session.close();
		log.debug(String.format("found %d items", list != null ? list.size() : 0));
		return list; 
	}
	public Account findById(int id) {
		log.debug(String.format("Call findById(id) [id=%d]", id));
		Session session = getSessionFactory().openSession();
		session.getTransaction().begin();
		Account account = (Account)session.createCriteria(Account.class).add(Restrictions.eq("id", id)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		log.debug(String.format("found %d items", account != null ? 1 : 0));
		return account;
	}
	public Account findByName(String name) {
		log.debug(String.format("Call findByName(name) [name=%s]", name));
		Session session = getSessionFactory().openSession();
		session.getTransaction().begin();
		Account account = (Account)session.createCriteria(Account.class).add(Restrictions.eq("name", name)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		log.debug(String.format("found %d items", account != null ? 1 : 0));
		return account;	
	}
	
	
}
