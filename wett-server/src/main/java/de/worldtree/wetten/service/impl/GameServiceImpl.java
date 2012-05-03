/**
 * 
 */
package de.worldtree.wetten.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.worldtree.wetten.dao.GameDao;
import de.worldtree.wetten.dao.TipDao;
import de.worldtree.wetten.model.Account;
import de.worldtree.wetten.model.Event;
import de.worldtree.wetten.model.Game;
import de.worldtree.wetten.model.Tip;
import de.worldtree.wetten.service.GameService;

/**
 * @author pascal
 *
 */
@Component(value="gameService")
public class GameServiceImpl implements GameService {
	
	private static final Log log = LogFactory.getLog(GameServiceImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private GameDao gameDao;
	@Autowired
	private TipDao tipDao;
	
	
	@Override
	public List<Game> getAll() {
		List<Game> list = new ArrayList<Game>();
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			list = gameDao.findAll();
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		return list;
	}
	@Override
	public Game getGame(int gameId) {
		Game game = null;
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			game = gameDao.findById(gameId);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		return game;
	}
	@Override
	public List<Game> getGamesNotFinished(Date closingTime) {
		List<Game> list = new ArrayList<Game>();
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			list = gameDao.findByClosingTimeNotGone(closingTime);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		return list;
	}
	@Override
	public List<Game> getGamesFinished(Date closingTime) {
		List<Game> list = new ArrayList<Game>();
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			list = gameDao.findByClosingTimeGone(closingTime);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		return list;
	}
	@Override
	public List<Tip> getAllTipsForGame(int gameId) {
		List<Tip> list = new ArrayList<Tip>();
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			list = tipDao.findByGameId(gameId);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		return list;
	}
	@Override
	public List<Tip> getAllTipsForGame(Game game) {
		List<Tip> list = new ArrayList<Tip>();
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			sessionFactory.getCurrentSession().update(game);
			list = tipDao.findByGameId(game.getId());
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		return list;
	}
	@Override
	public List<Tip> getAllTipsForPlayer(int playerId) {
		List<Tip> list = new ArrayList<Tip>();
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			list = tipDao.findByPlayerId(playerId);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		return list;
	}
	@Override
	public List<Tip> getAllTipsForPlayer(Account player) {
		List<Tip> list = new ArrayList<Tip>();
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			sessionFactory.getCurrentSession().update(player);
			list = tipDao.findByPlayerId(player.getId());
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		return list;
	}
	@Override
	public Tip getTip(int gameId, int playerId) {
		Tip tip = null;
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			tip = tipDao.findByPlayerIdAndGameId(playerId, gameId);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		return tip;
	}
	@Override
	public Tip getTip(Game game, int playerId) {
		Tip tip = null;
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			sessionFactory.getCurrentSession().update(game);
			tip = tipDao.findByPlayerIdAndGameId(playerId, game.getId());
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		return tip;
	}
	@Override
	public Tip getTip(int gameId, Account player) {
		Tip tip = null;
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			sessionFactory.getCurrentSession().update(player);
			tip = tipDao.findByPlayerIdAndGameId(player.getId(), gameId);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		return tip;
	}
	@Override
	public Tip getTip(Game game, Account player) {
		Tip tip = null;
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			sessionFactory.getCurrentSession().update(player);
			sessionFactory.getCurrentSession().update(game);
			tip = tipDao.findByPlayerIdAndGameId(player.getId(), game.getId());
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		return tip;
	}
	@Override
	public List<Game> getGamesForEvent(int eventId) {
		List<Game> list = new ArrayList<Game>();
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			list = gameDao.findByEventId(eventId);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		return list;
	}
	@Override
	public List<Game> getGamesForEvent(Event event) {
		List<Game> list = new ArrayList<Game>();
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			sessionFactory.getCurrentSession().update(event);
			list = gameDao.findByEventId(event.getId());
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		return list;
	}
	@Override
	public List<Game> getGamesNotFinished(int eventId, Date closingTime) {
		List<Game> list = new ArrayList<Game>();
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			list = gameDao.findByEventIdAndClosedTimeNotGone(eventId, closingTime);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		return list;
	}
	@Override
	public List<Game> getGamesFinished(int eventId, Date closingTime) {
		List<Game> list = new ArrayList<Game>();
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			list = gameDao.findByEventIdAndClosedTimeGone(eventId, closingTime);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		return list;
	}
	@Override
	public List<Tip> getAllTips() {
		List<Tip> list = new ArrayList<Tip>();
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			list = tipDao.findAll();
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (Exception ex) {
			log.error("DatabaseError:", ex);
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		return list;
	}
	

}
