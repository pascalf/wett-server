/**
 * 
 */
package de.worldtree.wetten.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import de.worldtree.wetten.dao.AbstractDao;
import de.worldtree.wetten.dao.TipDao;
import de.worldtree.wetten.model.Account;
import de.worldtree.wetten.model.Event;
import de.worldtree.wetten.model.Tip;

/**
 * @author pascal
 *
 */
public class TipDaoImpl extends TipDao {

	private static final Log log = LogFactory.getLog(TipDaoImpl.class);
	
	/* (non-Javadoc)
	 * @see de.worldtree.wetten.dao.TipDao#findAll()
	 */
	@Override
	public List<Tip> findAll() {
		log.debug(String.format("Call findAll() []"));
		Session session = getSessionFactory().openSession();
		session.getTransaction().begin();
		List<Tip> list = session.createQuery("From Tip").list();
		session.getTransaction().commit();
		session.close();
		log.debug(String.format("found %d items", list != null ? list.size() : 0));
		return list; 
	}

	/* (non-Javadoc)
	 * @see de.worldtree.wetten.dao.TipDao#findByPlayerIdAndGameId(int, int)
	 */
	@Override
	public Tip findByPlayerIdAndGameId(int playerId, int gameId) {
		log.debug(String.format("Call findByPlayerIdAndGameId(playerId, gameId) [playerId=%d | gameId=%d]", playerId, gameId));
		Session session = getSessionFactory().openSession();
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

}
