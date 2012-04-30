/**
 * 
 */
package de.worldtree.wetten.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.worldtree.wetten.model.EventPlayer;
import de.worldtree.wetten.model.Game;

/**
 * @author pascal
 *
 */
public class EventPlayerDaoTest {

	static ApplicationContext ctx;
	EventPlayerDao dao;
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
		dao = (EventPlayerDao)ctx.getBean("eventPlayerDao");
	}

	@Test
	public void test_findAll() {
		List<EventPlayer> list = dao.findAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
	}
	
	@Test
	public void test_findByEventId() {
		List<EventPlayer> list = dao.findAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		EventPlayer testEventPlayer = list.get(0);
		
		list.clear();
		list = dao.findByEventId(testEventPlayer.getEventId());
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
	}
	
	@Test
	public void test_findByPlayerId() {
		List<EventPlayer> list = dao.findAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		EventPlayer testEventPlayer = list.get(0);
		
		list.clear();
		list = dao.findByPlayerId(testEventPlayer.getPlayerId());
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
	}

}
