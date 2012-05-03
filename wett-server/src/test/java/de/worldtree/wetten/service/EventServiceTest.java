/**
 * 
 */
package de.worldtree.wetten.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

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

/**
 * @author pascal
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-wett-server.cml.xml")
public class EventServiceTest {

	private static final Log log = LogFactory.getLog(EventServiceTest.class);
	
	@Autowired
	private EventService service;
	
	@Test
	public void test_getAll() {
		List<Event> list = service.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
	}
	
	@Test
	public void test_getEventById() {
		List<Event> list = service.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		
		Event testEvent = list.get(0);
		int eventId = testEvent.getId();
		
		Event event = service.getEvent(eventId);
		assertNotNull("Event is null", event);
		assertEquals("Event Id's do not match", eventId, event.getId());
	}
	
	@Test
	public void test_getEventByName() {
		List<Event> list = service.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		
		Event testEvent = list.get(0);
		String eventName = testEvent.getName();
		
		Event event = service.getEvent(eventName);
		assertNotNull("Event is null", event);
		assertEquals("Event Name's do not match", eventName, event.getName());
	}
	
	@Test
	public void test_getEventGamesById() {
		List<Event> list = service.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		
		Event testEvent = list.get(0);
		int eventId = testEvent.getId();
		
		
		Event event = service.getEvent(eventId);
		assertNotNull("Event is null", event);
		assertEquals("Event Id's do not match", eventId, event.getId());
		
		List<Game> eventGames = service.getEventGames(eventId);
		assertNotNull("List of eventGames is null", eventGames);
		assertFalse("List of eventGames is empty", eventGames.isEmpty());
	}
	
	@Test
	public void test_getEventGamesByName() {
		List<Event> list = service.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		
		Event testEvent = list.get(0);
		String eventName = testEvent.getName();
		
		Event event = service.getEvent(eventName);
		assertNotNull("Event is null", event);
		assertEquals("Event Id's do not match", eventName, event.getName());
		
		List<Game> eventGames = service.getEventGames(eventName);
		assertNotNull("List of eventGames is null", eventGames);
		assertFalse("List of eventGames is empty", eventGames.isEmpty());
	}
	
	@Test
	public void test_getEventGamesByEvent() {
		List<Event> list = service.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		
		Event testEvent = list.get(0);
		
		List<Game> eventGames = service.getEventGames(testEvent);
		assertNotNull("List of eventGames is null", eventGames);
		assertFalse("List of eventGames is empty", eventGames.isEmpty());
	}

	@Test
	public void test_getEventUsersById() {
		List<Event> list = service.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		
		Event testEvent = list.get(0);
		int eventId = testEvent.getId();
		
		
		Event event = service.getEvent(eventId);
		assertNotNull("Event is null", event);
		assertEquals("Event Id's do not match", eventId, event.getId());
		
		List<Account> eventUsers = service.getEventUsers(eventId);
		assertNotNull("List of eventUsers is null", eventUsers);
		assertFalse("List of eventUsers is empty", eventUsers.isEmpty());
	}
	
	@Test
	public void test_getEventUsersByName() {
		List<Event> list = service.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		
		Event testEvent = list.get(0);
		String eventName = testEvent.getName();
		
		Event event = service.getEvent(eventName);
		assertNotNull("Event is null", event);
		assertEquals("Event Id's do not match", eventName, event.getName());
		
		List<Account> eventUsers = service.getEventUsers(eventName);
		assertNotNull("List of eventUsers is null", eventUsers);
		assertFalse("List of eventUsers is empty", eventUsers.isEmpty());
	}
	
	@Test
	public void test_getEventUsersByEvent() {
		List<Event> list = service.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		
		Event testEvent = list.get(0);
		
		List<Account> eventUsers = service.getEventUsers(testEvent);
		assertNotNull("List of eventUsers is null", eventUsers);
		assertFalse("List of eventUsers is empty", eventUsers.isEmpty());
	}
}
