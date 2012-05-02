/**
 * 
 */
package de.worldtree.wetten.dao;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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

import de.worldtree.wetten.model.Event;

/**
 * @author pascal
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-wett-server.cml.xml")
public class EventDaoTest {

	private static final Log log = LogFactory.getLog(AccountDaoTest.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private EventDao dao;
	
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
