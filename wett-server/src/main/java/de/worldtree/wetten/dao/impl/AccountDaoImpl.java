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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.worldtree.wetten.dao.AccountDao;
import de.worldtree.wetten.model.Account;

/**
 * @author pascal
 *
 */
@Component(value="accountDao")
public class AccountDaoImpl implements AccountDao {
	
	private static final Log log = LogFactory.getLog(AccountDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory = null;

	public List<Account> findAll() {
		log.debug(String.format("Call findAll() []"));
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Account> list = session.createQuery("From Account").list();
		
		log.debug(String.format("found %d items", list != null ? list.size() : 0));
		return list; 
	}
	public Account findById(int id) {
		log.debug(String.format("Call findById(id) [id=%d]", id));
		Session session = sessionFactory.getCurrentSession();
		Account account = (Account)session.createCriteria(Account.class).add(Restrictions.eq("id", id)).uniqueResult();
		log.debug(String.format("found %d items", account != null ? 1 : 0));
		return account;
	}
	public Account findByName(String name) {
		log.debug(String.format("Call findByName(name) [name=%s]", name));
		Session session = sessionFactory.getCurrentSession();
		Account account = (Account)session.createCriteria(Account.class).add(Restrictions.eq("name", name)).uniqueResult();
		log.debug(String.format("found %d items", account != null ? 1 : 0));
		return account;	
	}
	
	
}
