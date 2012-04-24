/**
 * 
 */
package de.worldtree.wetten.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import de.worldtree.wetten.dao.AccountDao;
import de.worldtree.wetten.model.Account;

/**
 * @author pascal
 *
 */
public class AccountDaoImpl implements AccountDao {

	private static final SessionFactory sessionFactory; 
	private static final ServiceRegistry serviceRegistry;
	static { 
		try { 
			// Create the SessionFactory from hibernate.cfg.xml 
			Configuration configuration = new Configuration();
		    configuration.configure();
		    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		} catch (Throwable ex) { 
			// Make sure you log the exception, as it might be swallowed 
			System.err.println("Initial SessionFactory creation failed." + ex); 
			throw new ExceptionInInitializerError(ex); 
		} 
	} 
	public void create(List<Account> listAccounts) { 
		Session session = sessionFactory.openSession(); 
		session.getTransaction().begin(); 
		for (Account account : listAccounts) { 
			session.save(account); 
		} 
		session.getTransaction().commit(); 
	} 
	public List<Account> findAll() { 
		Session session = sessionFactory.openSession(); 
		List<Account> list = session.createQuery("From Account").list(); 
		return list; 
	}
	
	@Override
	public Account findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Account findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
