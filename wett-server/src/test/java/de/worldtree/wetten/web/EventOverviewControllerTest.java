/**
 * 
 */
package de.worldtree.wetten.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import de.worldtree.wetten.dao.EventDao;
import de.worldtree.wetten.dao.GameDao;
import de.worldtree.wetten.model.Event;

/**
 * @author pascal
 *
 */
public class EventOverviewControllerTest {

	static ApplicationContext ctx;
	
	EventDao eventDao;
	GameDao gameDao;
	
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
		eventDao = (EventDao)ctx.getBean("eventDao");
		gameDao = (GameDao)ctx.getBean("gameDao");
	}

	@Test
	public void testHandleRequestView() throws Exception{
		EventOverviewController controller = new EventOverviewController();
		
		controller.setEventDao(eventDao);
		controller.setGameDao(gameDao);
		
		int eventId = eventDao.findById(1).getId();
		
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		mockRequest.addParameter("eid", Integer.toString(eventId));
		
		MockHttpServletResponse mockResponse = new MockHttpServletResponse();
		
		ModelAndView modelAndView = controller.handleRequest(mockRequest, mockResponse);
		
		assertNotNull("Response is null", mockResponse);
		
		assertNotNull("ModelAndView is null", modelAndView);
		
        assertEquals("ViewNames do not match", "eventoverview", modelAndView.getViewName());
        assertNotNull("modelAndView.getModel() is null", modelAndView.getModel());
        Map modelMap = (Map)modelAndView.getModel().get("model");
        assertNotNull("modelMap.get(\"event\") is null", modelMap.get("event"));
        Event event = (Event)modelMap.get("event");
        assertEquals("Event Id's do not match", eventId, event.getId());
        assertNotNull("modelMap.get(\"games\") is null", modelMap.get("games"));
	}

	@Test
	public void testHandleRequestViewWithoutParameter() throws Exception{
		EventOverviewController controller = new EventOverviewController();
		
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		//mockRequest.addParameter("eid", Integer.toString(eventDao.findById(1).getId()));
		
		MockHttpServletResponse mockResponse = new MockHttpServletResponse();
		
		ModelAndView modelAndView = controller.handleRequest(mockRequest, mockResponse);
		
		assertNotNull("Response is null", mockResponse);
		
		assertNull("ModelAndView is null", modelAndView);
	}
}
