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

import de.worldtree.wetten.dao.TipDao;
import de.worldtree.wetten.model.Tip;

/**
 * @author pascal
 *
 */
@Component(value="tipDao")
public class TipDaoImpl implements TipDao {

	private static final Log log = LogFactory.getLog(TipDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory = null;

	public List<Tip> findAll() {
		log.debug(String.format("Call findAll() []"));
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		@SuppressWarnings("unchecked")
		List<Tip> list = session.createQuery("From Tip").list();
		
		session.getTransaction().commit();
		session.close();
		log.debug(String.format("found %d items", list != null ? list.size() : 0));
		return list; 
	}

	public Tip findByPlayerIdAndGameId(int playerId, int gameId) {
		log.debug(String.format("Call findByPlayerIdAndGameId(playerId, gameId) [playerId=%d | gameId=%d]", playerId, gameId));
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Tip tip = (Tip)session.createCriteria(Tip.class)
				.add(Restrictions.eq("playerId", playerId))
				.add(Restrictions.eq("gameId", gameId))
				.uniqueResult();
		session.getTransaction().commit();
		session.close();
		log.debug(String.format("found %d items", tip != null ? 1 : 0));
		return tip;
	}

	@Override
	public List<Tip> findByPlayerId(int playerId) {
		log.debug(String.format("Call findByPlayerId(playerId) [playerId=%d]", playerId));
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		List<Tip> tips = (List<Tip>)session.createCriteria(Tip.class)
				.add(Restrictions.eq("playerId", playerId))
				.list();
		session.getTransaction().commit();
		session.close();
		log.debug(String.format("found %d items", tips != null ? tips.size() : 0));
		return tips;
	}

	@Override
	public List<Tip> findByGameId(int gameId) {
		log.debug(String.format("Call findByGameId(gameId) [gameId=%d]", gameId));
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		List<Tip> tips = (List<Tip>)session.createCriteria(Tip.class)
				.add(Restrictions.eq("gameId", gameId))
				.list();
		session.getTransaction().commit();
		session.close();
		log.debug(String.format("found %d items", tips != null ? tips.size() : 0));
		return tips;
	}

}
