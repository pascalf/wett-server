package de.worldtree.wetten.web.admin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;
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
import de.worldtree.wetten.model.Event;

public class EventOverviewControllerTest {

	private static ApplicationContext ctx;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext-wett-server.cml.xml");
	}

	private EventOverviewController controller;
	private MockHttpServletRequest mockRequest;
	private MockHttpServletResponse mockResponse;
	private EventDao eventDao;
	
	@Before
	public void setUp() throws Exception {
		mockRequest = new MockHttpServletRequest();
		mockResponse = new MockHttpServletResponse();
		
		eventDao = (EventDao)ctx.getBean("eventDao");
		
		controller = new EventOverviewController();
		controller.setEventDao(eventDao);
		
	}

	@Test
	public void test_handleRequest() throws Exception {
		
		ModelAndView modelAndView = controller.handleRequest(mockRequest, mockResponse);
		
		assertNotNull("ModelAndView is null", modelAndView);
		assertEquals("ViewName's do not match", "admin/eventoverview", modelAndView.getViewName());
		assertNotNull("Model is null", modelAndView.getModel());
		assertNotNull("Model data is null", modelAndView.getModel().get("model"));
		Map modelMap = (Map)modelAndView.getModel().get("model");
		assertNotNull("Events is null", modelMap.get("events"));
		List events = (List)modelMap.get("events");
		assertFalse("Events is empty", events.isEmpty());
		
		
	}

}
