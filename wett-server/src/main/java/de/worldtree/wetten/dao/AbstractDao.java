/**
 * 
 */
package de.worldtree.wetten.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

/**
 * @author pascal
 *
 */
public class AbstractDao {

	private static Log log;
	
	public static void setLog(Class c) {
		log = LogFactory.getLog(c);
	}
	
	public static Log getLog() {
		return log;
	}
	
	private SessionFactory sessionFactory = null;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
