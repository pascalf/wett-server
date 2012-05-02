/**
 * 
 */
package de.worldtree.wetten.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.worldtree.wetten.dao.AccountDao;
import de.worldtree.wetten.model.Account;
import de.worldtree.wetten.service.AccountService;
import de.worldtree.wetten.util.Utilities;

/**
 * @author pascal
 *
 */
@Component(value="accountService")
public class AccountServiceImpl implements AccountService {
	
	private final static Log log = LogFactory.getLog(AccountServiceImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private AccountDao accountDao;
//	/**
//	 * @return the sessionFactory
//	 */
//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//	/**
//	 * @param sessionFactory the sessionFactory to set
//	 */
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
//	/**
//	 * @return the accountDao
//	 */
//	public AccountDao getAccountDao() {
//		return accountDao;
//	}
//	/**
//	 * @param accountDao the accountDao to set
//	 */
//	public void setAccountDao(AccountDao accountDao) {
//		this.accountDao = accountDao;
//	}
	
	@Override
	public List<Account> getAll() {
		List<Account> list = new ArrayList<Account>();
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			 list = accountDao.findAll();
			 
			 sessionFactory.getCurrentSession().getTransaction().commit();
		} catch(Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		log.debug("Accounts: " + Utilities.collectionToString(list, 5));
		return list;
	}
	@Override
	public Account getAccount(int accountId) {
		Account account = null;
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			account = accountDao.findById(accountId);
			 
			 sessionFactory.getCurrentSession().getTransaction().commit();
		} catch(Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		log.debug(account);
		return account;
	}
	@Override
	public Account getAccount(String accountName) {
		Account account = null;
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			account = accountDao.findByName(accountName);
			 
			 sessionFactory.getCurrentSession().getTransaction().commit();
		} catch(Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		log.debug(account);
		return account;
	}
	
	
}
