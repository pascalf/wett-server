/**
 * 
 */
package de.worldtree.wetten.service;

import java.util.Map;

import de.worldtree.wetten.dao.AccountDao;
import de.worldtree.wetten.dao.EventDao;
import de.worldtree.wetten.dao.GameDao;
import de.worldtree.wetten.dao.TipDao;

/**
 * @author pascal
 *
 */
public interface GameTipService {
	
	public void setAccountDao(AccountDao dao);
	public AccountDao getAccountDao();
	public void setTipDao(TipDao dao);
	public TipDao getTipDao();
	public void setGameDao(GameDao dao);
	public GameDao getGameDao();
	public void setEventDao(EventDao dao);
	public EventDao getEventDao();
	
	public Map findTipsForGame(int gameId);
	public Map findTipsForEvent(int eventId);

}
