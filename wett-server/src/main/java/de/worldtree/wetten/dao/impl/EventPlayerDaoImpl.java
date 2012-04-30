/**
 * 
 */
package de.worldtree.wetten.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import de.worldtree.wetten.dao.EventPlayerDao;
import de.worldtree.wetten.model.EventPlayer;
import de.worldtree.wetten.model.Tip;

/**
 * @author pascal
 *
 */
public class EventPlayerDaoImpl extends EventPlayerDao {

	private static final Log log = LogFactory.getLog(EventPlayerDaoImpl.class);
	@Override
	public List<EventPlayer> findAll() {
		log.debug(String.format("Call findAll() []"));
		Session session = getSessionFactory().openSession();
		session.getTransaction().begin();
		List<EventPlayer> list = session.createQuery("From EventPlayer").list();
		session.getTransaction().commit();
		session.close();
		log.debug(String.format("found %d items", list != null ? list.size() : 0));
		return list; 
	}

	@Override
	public List<EventPlayer> findByEventId(int eventId) {
		log.debug(String.format("Call findByEventId(eventId) [eventId=%d]", eventId));
		Session session = getSessionFactory().openSession();
		session.getTransaction().begin();
		List<EventPlayer> list = session.createCriteria(EventPlayer.class)
				.add(Restrictions.eq("eventId", eventId))
				.list();
		session.getTransaction().commit();
		session.close();
		log.debug(String.format("found %d items", list != null ? list.size() : 0));
		return list;
	}

	@Override
	public List<EventPlayer> findByPlayerId(int playerId) {
		log.debug(String.format("Call findByPlayerId(playerId) [playerId=%d]", playerId));
		Session session = getSessionFactory().openSession();
		session.getTransaction().begin();
		List<EventPlayer> list = session.createCriteria(EventPlayer.class)
				.add(Restrictions.eq("playerId", playerId))
				.list();
		session.getTransaction().commit();
		session.close();
		log.debug(String.format("found %d items", list != null ? list.size() : 0));
		return list;
	}

}
