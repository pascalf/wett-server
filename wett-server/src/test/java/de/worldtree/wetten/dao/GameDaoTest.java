/**
 * 
 */
package de.worldtree.wetten.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.worldtree.wetten.model.Game;

/**
 * @author pascal
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-wett-server.cml.xml")
public class GameDaoTest {

	private static final Log log = LogFactory.getLog(AccountDaoTest.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private GameDao dao;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		sessionFactory.getCurrentSession().beginTransaction();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		boolean commitFailed = false;
		try {
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			commitFailed = true;
			log.error("Transaction.commit() failed", e);
			throw e;
		} 
		if(commitFailed)
			fail("Something threw exception, see log");
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
