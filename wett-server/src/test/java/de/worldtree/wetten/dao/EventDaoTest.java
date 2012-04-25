/**
 * 
 */
package de.worldtree.wetten.dao;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.worldtree.wetten.model.Event;

/**
 * @author pascal
 *
 */
public class EventDaoTest {

	private static EventDao dao;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-wett-server.cml.xml");
		
		dao = (EventDao)ctx.getBean("eventDao");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test_findAll() {
		List<Event> events = null;
		events = dao.findAll();
		
		assertNotNull("List is null", events);
		assertFalse("List is empty", events.isEmpty());
	}
	
	@Test
	public void test_findById() {
		List<Event> events = null;
		events = dao.findAll();
		
		assertNotNull("List is null", events);
		assertFalse("List is empty", events.isEmpty());
		
		Event testEvent = events.get(0);
		
		Event event = dao.findById(testEvent.getId());
		assertNotNull("Event is null", event);
		assertEquals("EventId's do not match", event.getId(), testEvent.getId());
	}
	
	@Test
	public void test_findByName() {
		List<Event> events = null;
		events = dao.findAll();
		
		assertNotNull("List is null", events);
		assertFalse("List is empty", events.isEmpty());
		
		Event testEvent = events.get(0);
		
		Event event = dao.findByName(testEvent.getName());
		assertNotNull("Event is null", event);
		assertEquals("EventId's do not match", event.getName(), testEvent.getName());
	}

}
