/**
 * 
 */
package de.worldtree.wetten.service;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.worldtree.wetten.model.Account;
import de.worldtree.wetten.model.Event;
import de.worldtree.wetten.model.Game;
import de.worldtree.wetten.model.Tip;
import de.worldtree.wetten.util.DateUtils;

/**
 * @author pascal
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-wett-server.cml.xml")
public class GameServiceTest {

	private static final Log log = LogFactory.getLog(GameServiceTest.class);

	@Autowired
	private GameService gameService;
	@Autowired
	private EventService eventService;
	@Autowired
	private AccountService accountService;

	@Test
	public void test_getAll() {
		List<Game> list = gameService.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
	}
	@Test
	public void test_getGameById() {
		List<Game> list = gameService.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		Game testGame = list.get(0);

		int gameId = testGame.getId();

		Game game = gameService.getGame(gameId);
		assertNotNull("Game is null", game);
		assertEquals("Game Id's do not match", gameId, game.getId());
	}
	@Test
	public void test_getGamesForEventByEventId() {
		List<Game> list = gameService.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		Game testGame = list.get(0);
		int eventId = testGame.getEventId();

		List<Game> eventGames = gameService.getGamesForEvent(eventId);
		assertNotNull("EventGames is null", eventGames);
		assertFalse("EventGames is empty", eventGames.isEmpty());
		for(Game g : eventGames)
			assertEquals("EventId's do not match for Game=" + g + " should have eventId=" + eventId, eventId, g.getEventId());
	}
	@Test
	public void test_getGamesForEventByEvent() {
		List<Game> list = gameService.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		Game testGame = list.get(0);
		Event event = eventService.getEvent(testGame.getId());

		List<Game> eventGames = gameService.getGamesForEvent(event);
		assertNotNull("EventGames is null", eventGames);
		assertFalse("EventGames is empty", eventGames.isEmpty());
		for(Game g : eventGames)
			assertEquals("EventId's do not match for Game=" + g + " should have eventId=" + event.getId(), event.getId(), g.getEventId());
	}
	@Test
	public void test_getGamesNotFinishedByClosingTime() {
		List<Game> list = gameService.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		Game testGame = list.get(0);

		Calendar c = Calendar.getInstance();
		c.setTime(testGame.getClosingTime());		
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - 1);
		Date newDate = c.getTime();

		List<Game> games = gameService.getGamesNotFinished(newDate);
		assertNotNull("Games is null", games);
		assertFalse("Games is empty", games.isEmpty());
		for(Game g : games)
			assertTrue("NewDate=" + DateUtils.getSimpleDateFormat().format(newDate) + " was not before/equal to closingTime of game=" + g, newDate.compareTo(g.getClosingTime()) < 0);

	}
	@Test
	public void test_getGamesNotFinishedByEventIdAndClosingTime() {
		List<Game> list = gameService.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		Game testGame = list.get(0);
		
		int eventId = testGame.getEventId();

		Calendar c = Calendar.getInstance();
		c.setTime(testGame.getClosingTime());		
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - 1);
		Date newDate = c.getTime();

		List<Game> games = gameService.getGamesNotFinished(eventId, newDate);
		assertNotNull("Games is null", games);
		assertFalse("Games is empty", games.isEmpty());
		for(Game g : games) {
			assertEquals("EventId's do not match for Game=" + g + " should have eventId=" + eventId, eventId, g.getEventId());
			assertTrue("NewDate=" + DateUtils.getSimpleDateFormat().format(newDate) + " was not before/equal to closingTime of game=" + g, newDate.compareTo(g.getClosingTime()) < 0);
		}

	}
	@Test
	public void test_getGamesFinishedByClosingTime() {
		List<Game> list = gameService.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		Game testGame = list.get(0);

		Calendar c = Calendar.getInstance();
		c.setTime(testGame.getClosingTime());		
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
		Date newDate = c.getTime();

		List<Game> games = gameService.getGamesFinished(newDate);
		assertNotNull("Games is null", games);
		assertFalse("Games is empty", games.isEmpty());
		for(Game g : games)
			assertTrue("NewDate=" + DateUtils.getSimpleDateFormat().format(newDate) + " was not after/equal to closingTime of game=" + g, newDate.compareTo(g.getClosingTime()) >= 0);

		newDate = testGame.getClosingTime();

		games.clear();
		games = gameService.getGamesFinished(newDate);
		assertNotNull("Games is null", games);
		assertFalse("Games is empty", games.isEmpty());
		for(Game g : games)
			assertTrue("NewDate=" + DateUtils.getSimpleDateFormat().format(newDate) + " was not after/equal to closingTime of game=" + g, newDate.compareTo(g.getClosingTime()) >= 0);
		
	}
	@Test
	public void test_getGamesFinishedByEventIdAndClosingTime() {
		List<Game> list = gameService.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		Game testGame = list.get(0);
		
		int eventId = testGame.getEventId();

		Calendar c = Calendar.getInstance();
		c.setTime(testGame.getClosingTime());		
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
		Date newDate = c.getTime();

		List<Game> games = gameService.getGamesFinished(eventId, newDate);
		assertNotNull("Games is null", games);
		assertFalse("Games is empty", games.isEmpty());
		for(Game g : games) {
			assertEquals("EventId's do not match for Game=" + g + " should have eventId=" + eventId, eventId, g.getEventId());
			assertTrue("NewDate=" + DateUtils.getSimpleDateFormat().format(newDate) + " was not after/equal to closingTime of game=" + g, newDate.compareTo(g.getClosingTime()) >= 0);
		}

		newDate = testGame.getClosingTime();

		games.clear();
		games = gameService.getGamesFinished(eventId, newDate);
		assertNotNull("Games is null", games);
		assertFalse("Games is empty", games.isEmpty());
		for(Game g : games) {
			assertEquals("EventId's do not match for Game=" + g + " should have eventId=" + eventId, eventId, g.getEventId());
			assertTrue("NewDate=" + DateUtils.getSimpleDateFormat().format(newDate) + " was not after/equal to closingTime of game=" + g, newDate.compareTo(g.getClosingTime()) >= 0);
		}
	}
	@Test
	public void test_getAllTips() {
		List<Tip> list = gameService.getAllTips();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
	}
	@Test
	public void test_getAllTipsForGameById() {
		List<Tip> list = gameService.getAllTips();
		assertNotNull("list is null", list);
		assertFalse("list is empty", list.isEmpty());
		Tip testTip = list.get(0);
		
		int gameId = testTip.getGameId();
		
		List<Tip> tips = gameService.getAllTipsForGame(gameId);
		assertNotNull("Tips is null", tips);
		assertFalse("Tips is empty", tips.isEmpty());
		for(Tip t : tips)
			assertEquals("Game Id's do not match, got tip=" + t + " but expected gameId=" + gameId, gameId, t.getGameId());
	}
	@Test
	public void test_getAllTipsForGameByGame() {
		List<Tip> list = gameService.getAllTips();
		assertNotNull("list is null", list);
		assertFalse("list is empty", list.isEmpty());
		Tip testTip = list.get(0);
		
		Game testGame = gameService.getGame(testTip.getGameId());
		
		List<Tip> tips = gameService.getAllTipsForGame(testGame);
		assertNotNull("Tips is null", tips);
		assertFalse("Tips is empty", tips.isEmpty());
		for(Tip t : tips)
			assertEquals("Game Id's do not match, got tip=" + t + " but expected gameId=" + testGame.getId(), testGame.getId(), t.getGameId());
	}
	@Test
	public void test_getAllTipsForPlayerById() {
		List<Tip> list = gameService.getAllTips();
		assertNotNull("list is null", list);
		assertFalse("list is empty", list.isEmpty());
		Tip testTip = list.get(0);
		
		int playerId = testTip.getPlayerId();
		
		List<Tip> tips = gameService.getAllTipsForPlayer(playerId);
		assertNotNull("Tips is null", tips);
		assertFalse("Tips is empty", tips.isEmpty());
		for(Tip t : tips)
			assertEquals("Player Id's do not match, got tip=" + t + " but expected playerId=" + playerId, playerId, t.getGameId());
		
	}
	@Test
	public void test_getAllTipsForPlayerByPlayer() {
		List<Tip> list = gameService.getAllTips();
		assertNotNull("list is null", list);
		assertFalse("list is empty", list.isEmpty());
		Tip testTip = list.get(0);
		
		Account testPlayer = accountService.getAccount(testTip.getPlayerId());
		
		List<Tip> tips = gameService.getAllTipsForPlayer(testPlayer);
		assertNotNull("Tips is null", tips);
		assertFalse("Tips is empty", tips.isEmpty());
		for(Tip t : tips)
			assertEquals("Player Id's do not match, got tip=" + t + " but expected playerId=" + testPlayer.getId(), testPlayer.getId(), t.getGameId());
		
	}
	@Test
	public void test_getTipByGameIdAndPlayerId() {
		List<Tip> list = gameService.getAllTips();
		assertNotNull("list is null", list);
		assertFalse("list is empty", list.isEmpty());
		Tip testTip = list.get(0);
		
		int playerId = testTip.getPlayerId();
		int gameId = testTip.getGameId();
		
		Tip tip = gameService.getTip(gameId, playerId);
		assertNotNull("Tip is null", tip);
		assertEquals("Player Id's do not match", playerId, tip.getPlayerId());
		assertEquals("Game Id's do not match", gameId, tip.getGameId());
	}
	@Test
	public void test_getTipByGameAndPlayerId() {
		List<Tip> list = gameService.getAllTips();
		assertNotNull("list is null", list);
		assertFalse("list is empty", list.isEmpty());
		Tip testTip = list.get(0);
		
		int playerId = testTip.getPlayerId();
		Game testGame = gameService.getGame(testTip.getGameId());
		
		Tip tip = gameService.getTip(testGame, playerId);
		assertNotNull("Tip is null", tip);
		assertEquals("Player Id's do not match", playerId, tip.getPlayerId());
		assertEquals("Game Id's do not match", testGame.getId(), tip.getGameId());
	}
	@Test
	public void test_getTipByGameIdAndPlayer() {
		List<Tip> list = gameService.getAllTips();
		assertNotNull("list is null", list);
		assertFalse("list is empty", list.isEmpty());
		Tip testTip = list.get(0);
		
		Account testAccount = accountService.getAccount(testTip.getPlayerId());
		int gameId = testTip.getGameId();
		
		Tip tip = gameService.getTip(gameId, testAccount);
		assertNotNull("Tip is null", tip);
		assertEquals("Player Id's do not match", testAccount.getId(), tip.getPlayerId());
		assertEquals("Game Id's do not match", gameId, tip.getGameId());
	}
	@Test
	public void test_getTipByGameAndPlayer() {
		List<Tip> list = gameService.getAllTips();
		assertNotNull("list is null", list);
		assertFalse("list is empty", list.isEmpty());
		Tip testTip = list.get(0);
		
		Account testAccount = accountService.getAccount(testTip.getPlayerId());
		Game testGame = gameService.getGame(testTip.getGameId());
		
		Tip tip = gameService.getTip(testGame, testAccount);
		assertNotNull("Tip is null", tip);
		assertEquals("Player Id's do not match", testAccount.getId(), tip.getPlayerId());
		assertEquals("Game Id's do not match", testGame.getId(), tip.getGameId());
	}	

}
