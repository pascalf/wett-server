/**
 * 
 */
package de.worldtree.wetten.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import de.worldtree.wetten.dao.AbstractDao;
import de.worldtree.wetten.dao.EventDao;
import de.worldtree.wetten.model.Account;
import de.worldtree.wetten.model.Event;

/**
 * @author pascal
 *
 */
public class EventDaoImpl extends EventDao {

	static {
		setLog(EventDaoImpl.class);
	}
	/* (non-Javadoc)
	 * @see de.worldtree.wetten.dao.EventDao#findAll()
	 */
	@Override
	public List<Event> findAll() {
		getLog().debug(String.format("Call findAll() []"));
		Session session = getSessionFactory().openSession();
		session.getTransaction().begin();
		List<Event> list = session.createQuery("From Event").list();
		session.getTransaction().commit();
		getLog().debug(String.format("found %d items", list != null ? list.size() : 0));
		return list; 
	}

	/* (non-Javadoc)
	 * @see de.worldtree.wetten.dao.EventDao#findById(int)
	 */
	@Override
	public Event findById(int id) {
		getLog().debug(String.format("Call findById(id) [id=%d]", id));
		Session session = getSessionFactory().openSession();
		session.getTransaction().begin();
		Event event = (Event)session.createCriteria(Event.class).add(Restrictions.eq("id", id)).uniqueResult();
		session.getTransaction().commit();
		getLog().debug(String.format("found %d items", event != null ? 1 : 0));
		return event;
	}

	/* (non-Javadoc)
	 * @see de.worldtree.wetten.dao.EventDao#findByName(java.lang.String)
	 */
	@Override
	public Event findByName(String name) {
		getLog().debug(String.format("Call findByName(name) [name=%s]", name));
		Session session = getSessionFactory().openSession();
		session.getTransaction().begin();
		Event event = (Event)session.createCriteria(Event.class).add(Restrictions.eq("name", name)).uniqueResult();
		session.getTransaction().commit();
		getLog().debug(String.format("found %d items", event != null ? 1 : 0));
		return event;	
	}

}
