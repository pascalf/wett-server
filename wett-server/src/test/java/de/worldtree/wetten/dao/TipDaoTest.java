package de.worldtree.wetten.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.worldtree.wetten.model.Tip;

public class TipDaoTest {

	private static TipDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-wett-server.cml.xml");
		
		dao = (TipDao)ctx.getBean("tipDao");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void test_findAll() {
		List<Tip> tips = null;
		tips = dao.findAll();
		
		assertNotNull("List is null", tips);
		assertFalse("List is empty", tips.isEmpty());
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
	}

}
