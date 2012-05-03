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

import de.worldtree.wetten.dao.EventDao;
import de.worldtree.wetten.model.Account;
import de.worldtree.wetten.model.Event;
import de.worldtree.wetten.model.Game;
import de.worldtree.wetten.service.EventService;
import de.worldtree.wetten.util.Utilities;

/**
 * @author pascal
 *
 */
@Component(value="eventService")
public class EventServiceImpl implements EventService {

	private static final Log log = LogFactory.getLog(EventServiceImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private EventDao eventDao;

	@Override
	public List<Event> getAll() {
		List<Event> list = new ArrayList<Event>();
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			list = eventDao.findAll();

			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch(Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		log.debug("Events: " + Utilities.collectionToString(list, 5));
		return list;
	}

	@Override
	public Event getEvent(int eventId) {
		Event event = null;
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			event = eventDao.findById(eventId);

			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch(Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		log.debug(event);
		return event;
	}

	@Override
	public Event getEvent(String eventName) {
		Event event = null;
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			event = eventDao.findByName(eventName);

			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch(Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		log.debug(event);
		return event;
	}

	@Override
	public List<Game> getEventGames(int eventId) {
		List<Game> list = new ArrayList<Game>();
		Event event = null;
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			event = eventDao.findById(eventId);

			for(Game game : event.getGames())
				list.add(game);

			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		log.debug("Games for Event "+ event + ": " + Utilities.collectionToString(list, 5));
		return list;
	}

	@Override
	public List<Game> getEventGames(String eventName) {
		List<Game> list = new ArrayList<Game>();
		Event event = null;
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			event = eventDao.findByName(eventName);

			for(Game game : event.getGames())
				list.add(game);

			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		log.debug("Games for Event "+ event + ": " + Utilities.collectionToString(list, 5));
		return list;
	}

	@Override
	public List<Game> getEventGames(Event event) {
		List<Game> list = new ArrayList<Game>();
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			sessionFactory.getCurrentSession().update(event);

			for(Game game : event.getGames())
				list.add(game);

			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		log.debug("Games for Event "+ event + ": " + Utilities.collectionToString(list, 5));
		return list;
	}

	@Override
	public List<Account> getEventUsers(int eventId) {
		List<Account> list = new ArrayList<Account>();
		Event event = null;
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			event = eventDao.findById(eventId);

			for(Account account : event.getUsers())
				list.add(account);

			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		log.debug("Users for Event "+ event + ": " + Utilities.collectionToString(list, 5));
		return list;
	}

	@Override
	public List<Account> getEventUsers(String eventName) {
		List<Account> list = new ArrayList<Account>();
		Event event = null;
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			event = eventDao.findByName(eventName);

			for(Account account : event.getUsers())
				list.add(account);

			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		log.debug("Users for Event "+ event + ": " + Utilities.collectionToString(list, 5));
		return list;
	}

	@Override
	public List<Account> getEventUsers(Event event) {
		List<Account> list = new ArrayList<Account>();
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			sessionFactory.getCurrentSession().update(event);

			for(Account account : event.getUsers())
				list.add(account);

			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		log.debug("Users for Event "+ event + ": " + Utilities.collectionToString(list, 5));
		return list;
	}

}
