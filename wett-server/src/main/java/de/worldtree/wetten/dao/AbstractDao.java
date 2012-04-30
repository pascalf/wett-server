/**
 * 
 */
package de.worldtree.wetten.dao;

import org.hibernate.SessionFactory;

/**
 * @author pascal
 *
 */
public class AbstractDao {
	
	private SessionFactory sessionFactory = null;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
