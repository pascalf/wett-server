/**
 * 
 */
package de.worldtree.wetten.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.worldtree.wetten.model.Game;

/**
 * @author pascal
 *
 */
public class GameDaoTest {

	private static GameDao dao;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-wett-server.cml.xml");

		dao = (GameDao)ctx.getBean("gameDao");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDown() throws Exception {
	}	

	@Test
	public void test_findAll() {
		List<Game> games = dao.findAll();
		assertNotNull("List is null", games);
		assertFalse("List is empty", games.isEmpty());
	}
	
	@Test
	public void test_findById() {
		List<Game> games = dao.findAll();
		assertNotNull("List is null", games);
		assertFalse("List is empty", games.isEmpty());
		Game testGame = games.get(0);
		
		Game game = dao.findById(testGame.getId());
		assertNotNull("Game is null", game);
		assertEquals("Id's do not match", game.getId(), testGame.getId());		
	}
	
	@Test
	public void test_findByEventId() {
		List<Game> games = dao.findAll();
		assertNotNull("List is null", games);
		assertFalse("List is empty", games.isEmpty());
		Game testGame = games.get(0);
		
		games.clear();
		games = dao.findByEventId(testGame.getEventId());
		assertNotNull("List is null", games);
		assertFalse("List is empty", games.isEmpty());
	}
	
	@Test
	public void test_findByEventIdAndClosedTimeGone() {
		List<Game> games = dao.findAll();
		assertNotNull("List is null", games);
		assertFalse("List is empty", games.isEmpty());
		Game testGame = games.get(0);
		
		games.clear();
		Calendar c = Calendar.getInstance();
		c.setTime(testGame.getClosingTime());		
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
		Date newDate = c.getTime();
		games = dao.findByEventIdAndClosedTimeGone(testGame.getEventId(), newDate);
		assertNotNull("List is null", games);
		assertFalse("List is empty", games.isEmpty());
		
		games = dao.findByEventIdAndClosedTimeGone(testGame.getEventId(), testGame.getClosingTime());
		assertNotNull("List is null", games);
		assertFalse("List is empty", games.isEmpty());
	}
	
	@Test
	public void test_findByEventIdAndClosedTimeNotGone() {
		List<Game> games = dao.findAll();
		assertNotNull("List is null", games);
		assertFalse("List is empty", games.isEmpty());
		Game testGame = games.get(0);

		games.clear();
		Calendar c = Calendar.getInstance();
		c.setTime(testGame.getClosingTime());		
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - 1);
		Date newDate = c.getTime();
		games = dao.findByEventIdAndClosedTimeNotGone(testGame.getEventId(), newDate);
		assertNotNull("List is null", games);
		assertFalse("List is empty", games.isEmpty());
	}
}
