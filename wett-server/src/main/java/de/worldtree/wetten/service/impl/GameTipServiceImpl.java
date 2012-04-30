/**
 * 
 */
package de.worldtree.wetten.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.worldtree.wetten.dao.AccountDao;
import de.worldtree.wetten.dao.EventDao;
import de.worldtree.wetten.dao.EventPlayerDao;
import de.worldtree.wetten.dao.GameDao;
import de.worldtree.wetten.dao.TipDao;
import de.worldtree.wetten.model.Event;
import de.worldtree.wetten.model.EventPlayer;
import de.worldtree.wetten.model.Game;
import de.worldtree.wetten.model.Tip;
import de.worldtree.wetten.service.GameTipService;
import de.worldtree.wetten.service.model.GameTip;
import de.worldtree.wetten.service.model.PlayerTip;

/**
 * @author pascal
 *
 */
public class GameTipServiceImpl implements GameTipService {
	
	private final static Log log = LogFactory.getLog(GameTipServiceImpl.class);

	private AccountDao accountDao;
	private GameDao gameDao;
	private TipDao tipDao;
	private EventDao eventDao;
	private EventPlayerDao eventPlayerDao;
	

	/**
	 * @return the eventPlayerDao
	 */
	public EventPlayerDao getEventPlayerDao() {
		return eventPlayerDao;
	}

	/**
	 * @param eventPlayerDao the eventPlayerDao to set
	 */
	public void setEventPlayerDao(EventPlayerDao eventPlayerDao) {
		this.eventPlayerDao = eventPlayerDao;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public GameDao getGameDao() {
		return gameDao;
	}

	public void setGameDao(GameDao gameDao) {
		this.gameDao = gameDao;
	}

	public TipDao getTipDao() {
		return tipDao;
	}

	public void setTipDao(TipDao tipDao) {
		this.tipDao = tipDao;
	}

	public EventDao getEventDao() {
		return eventDao;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	@Override
	public Map findTipsForGame(int gameId) {
		Game game = gameDao.findById(gameId);
		
		List<EventPlayer> eventPlayerList = eventPlayerDao.findByEventId(game.getEventId());
		
		List<PlayerTip> playerTips = new ArrayList<PlayerTip>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("game", game);
		
		int tipCount = 0;
		
		for(EventPlayer eventPlayer : eventPlayerList) {
			PlayerTip playerTip = new PlayerTip();
			playerTip.setPlayer(accountDao.findById(eventPlayer.getPlayerId()));
			Tip t = tipDao.findByPlayerIdAndGameId(eventPlayer.getPlayerId(), gameId);
			if ( t != null)
				tipCount++;
			playerTip.setTip(t);
			playerTips.add(playerTip);
		}
		
		log.debug(String.format("Found %d individual players with %d given tips for game %s",playerTips.size(), tipCount, game.getId()));
		
		map.put("playerTips", playerTips);
		
		return map;
	}

	@Override
	public Map findTipsForEvent(int eventId) {
		Event event = eventDao.findById(eventId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("event", event);
		
		List<GameTip> gameTips = new ArrayList<GameTip>();
		
		List<Game> games = gameDao.findByEventId(eventId);
		
		for(Game game : games) {
			GameTip gameTip = new GameTip();
			gameTip.setGame(game);
			Map playerTipMap = findTipsForGame(game.getId());
			gameTip.setPlayerTips((List<PlayerTip>)playerTipMap.get("playerTips"));
			gameTips.add(gameTip);
		}
		
		map.put("gameTips", gameTips);
		
		log.debug(String.format("Found %d games with tips", gameTips.size()));
		
		return map;
	}

}
