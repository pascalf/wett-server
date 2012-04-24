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

import de.worldtree.wetten.dao.GameDao;
import de.worldtree.wetten.model.Account;
import de.worldtree.wetten.model.Game;

/**
 * @author pascal
 *
 */
public class GameDaoImpl implements GameDao {

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
	
	/* (non-Javadoc)
	 * @see de.worldtree.wetten.dao.GameDao#findAll()
	 */
	@Override
	public List<Game> findAll() {
		Session session = sessionFactory.openSession(); 
		List<Game> list = session.createQuery("From Game").list(); 
		return list; 
	}

}
