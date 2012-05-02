/**
 * 
 */
package de.worldtree.wetten.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.worldtree.wetten.dao.GameDao;
import de.worldtree.wetten.model.Game;
import de.worldtree.wetten.util.DateUtils;

/**
 * @author pascal
 *
 */
@Component(value="gameDao")
public class GameDaoImpl implements GameDao {	
	
	private static final Log log = LogFactory.getLog(GameDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory = null;

	public List<Game> findAll() {
		log.debug(String.format("Call findAll() []"));
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Game> list = session.createQuery("From Game").list(); 
		
		log.debug(String.format("found %d items", list != null ? list.size() : 0));
		return list; 
	}

	public Game findById(int id) {
		log.debug(String.format("Call findById(id) [id=%d]", id));
		Session session = sessionFactory.getCurrentSession();
		Game game = (Game)session.createCriteria(Game.class).add(Restrictions.eq("id", id)).uniqueResult(); 
		log.debug(String.format("found %d items", game != null ? 1 : 0));
		return game; 
	}

	public List<Game> findByEventId(int id) {
		log.debug(String.format("Call findByEventId(id) [id=%d]", id));
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Game> games = session.createCriteria(Game.class).add(Restrictions.eq("eventId", id)).list(); 
		
		log.debug(String.format("found %d items", games != null ? games.size() : 0));
		return games; 
	}

	public List<Game> findByEventIdAndClosedTimeGone(int id, Date time) {
		log.debug(String.format("Call findByEventIdAndClosedTimeGone(id,time) [id=%d | time=%s]", id, DateUtils.getSimpleDateFormat().format(time)));
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Game> games = session.createCriteria(Game.class)
				.add(Restrictions.eq("eventId", id))
				.add(Restrictions.le("closingTime", time))
				.list(); 
		
		log.debug(String.format("found %d items", games != null ? games.size() : 0));
		return games; 
	}

	public List<Game> findByEventIdAndClosedTimeNotGone(int id, Date time) {
		log.debug(String.format("Call findByEventIdAndClosedTimeNotGone(id,time) [id=%d | time=%s]", id, DateUtils.getSimpleDateFormat().format(time)));
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Game> games = session.createCriteria(Game.class)
				.add(Restrictions.eq("eventId", id))
				.add(Restrictions.gt("closingTime", time))
				.list(); 
		
		log.debug(String.format("found %d items", games != null ? games.size() : 0));
		return games; 
	}

}
