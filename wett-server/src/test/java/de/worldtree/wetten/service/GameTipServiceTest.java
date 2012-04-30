/**
 * 
 */
package de.worldtree.wetten.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.worldtree.wetten.model.Event;
import de.worldtree.wetten.model.Game;
import de.worldtree.wetten.service.model.GameTip;
import de.worldtree.wetten.service.model.PlayerTip;

/**
 * @author pascal
 *
 */
public class GameTipServiceTest {

	static ApplicationContext ctx;
	GameTipService service;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext-wett-server.cml.xml");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		service = (GameTipService)ctx.getBean("gameTipService");
	}

	@Test
	public void test_findTipsForGame() {
		int gameId = 1;
		Map map = service.findTipsForGame(gameId);
		assertNotNull("Map is null", map);
		Game game = (Game)map.get("game");
		assertNotNull("Game is null", game);
		assertEquals("Game Id's do not match", gameId, game.getId());
		List<PlayerTip> playerTips = (List<PlayerTip>)map.get("playerTips");
		assertNotNull("PlayerTips is null", playerTips);
		assertFalse("PlayerTips is empty", playerTips.isEmpty());
		
		gameId = 2;
		map = service.findTipsForGame(gameId);
		assertNotNull("Map is null", map);
		game = (Game)map.get("game");
		assertNotNull("Game is null", game);
		assertEquals("Game Id's do not match", gameId, game.getId());
		playerTips = (List<PlayerTip>)map.get("playerTips");
		assertNotNull("PlayerTips is null", playerTips);
		assertFalse("PlayerTips is empty", playerTips.isEmpty());
		
	}
	
	@Test
	public void test_findTipsForEvent() {
		int eventId = 1;
		
		Map map = service.findTipsForEvent(eventId);
		assertNotNull("Map is null", map);
		Event event = (Event) map.get("event");
		assertNotNull("Event is null", event);
		assertEquals("Event Id's do not match", eventId, event.getId());
		List<GameTip> gameTips = (List<GameTip>)map.get("gameTips");
		assertNotNull("GameTips is null", gameTips);
		assertFalse("GameTips is empty", gameTips.isEmpty());
	}

}
