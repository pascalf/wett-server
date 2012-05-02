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

import de.worldtree.wetten.dao.EventDao;
import de.worldtree.wetten.model.Event;

/**
 * @author pascal
 *
 */
@Component(value="eventDao")
public class EventDaoImpl implements EventDao {

	private static final Log log = LogFactory.getLog(EventDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory = null;

	public List<Event> findAll() {
		log.debug(String.format("Call findAll() []"));
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Event> list = session.createQuery("From Event").list();
		
		log.debug(String.format("found %d items", list != null ? list.size() : 0));
		return list; 
	}

	public Event findById(int id) {
		log.debug(String.format("Call findById(id) [id=%d]", id));
		Session session = sessionFactory.getCurrentSession();
		Event event = (Event)session.createCriteria(Event.class).add(Restrictions.eq("id", id)).uniqueResult();
		log.debug(String.format("found %d items", event != null ? 1 : 0));
		return event;
	}

	public Event findByName(String name) {
		log.debug(String.format("Call findByName(name) [name=%s]", name));
		Session session = sessionFactory.getCurrentSession();
		Event event = (Event)session.createCriteria(Event.class).add(Restrictions.eq("name", name)).uniqueResult();
		log.debug(String.format("found %d items", event != null ? 1 : 0));
		return event;	
	}

}
