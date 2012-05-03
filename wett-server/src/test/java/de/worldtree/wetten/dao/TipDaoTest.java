package de.worldtree.wetten.dao;

import static org.junit.Assert.*;

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

import de.worldtree.wetten.model.Tip;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-wett-server.cml.xml")
public class TipDaoTest {

	private static final Log log = LogFactory.getLog(AccountDaoTest.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private TipDao dao;
	
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
	public void test_findByPlayerIdAndGameId() {
		List<Tip> tips = null;
		tips = dao.findAll();
		
		assertNotNull("List is null", tips);
		assertFalse("List is empty", tips.isEmpty());
		
		Tip testTip = tips.get(0);
		
		Tip tip = dao.findByPlayerIdAndGameId(testTip.getPlayerId(), testTip.getGameId());
		
		assertNotNull("Tip is null", tip);
		assertEquals("PlayerId's do not match", tip.getPlayerId(), testTip.getPlayerId());
		assertEquals("GameId's do not match", tip.getGameId(), testTip.getGameId());
		LogFactory.getLog(getClass()).debug(tip);
	}
	
	@Test
	public void test_findByPlayerId() {
		List<Tip> list = null;
		list = dao.findAll();
		
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		
		Tip testTip = list.get(0);
		int playerId = testTip.getPlayerId();
		
		List<Tip> tips = dao.findByPlayerId(playerId);
		assertNotNull("Tips is null", tips);
		assertFalse("Tips is empty", tips.isEmpty());
		for(Tip t : tips)
			assertEquals("Player Id's do not match, got playerId=" + t.getPlayerId() + " but expected playerId=" + playerId, playerId, t.getPlayerId());
	}
	
	@Test
	public void test_findByGameId() {
		List<Tip> list = null;
		list = dao.findAll();
		
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		
		Tip testTip = list.get(0);
		int gameId = testTip.getPlayerId();
		
		List<Tip> tips = dao.findByGameId(gameId);
		assertNotNull("Tips is null", tips);
		assertFalse("Tips is empty", tips.isEmpty());
		for(Tip t : tips)
			assertEquals("Game Id's do not match, got gameId=" + t.getGameId() + " but expected gameId=" + gameId, gameId, t.getGameId());
	}

}
