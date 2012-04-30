/**
 * 
 */
package de.worldtree.wetten.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

import de.worldtree.wetten.model.Event;
import de.worldtree.wetten.service.GameTipService;
import de.worldtree.wetten.service.model.GameTip;

/**
 * @author pascal
 *
 */
public class EventTipOverviewControllerTest {
	
	static ApplicationContext ctx;
	GameTipService service;

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
		service = (GameTipService)ctx.getBean("gameTipService");
	}

	@Test
	public void testHandleRequestView() throws Exception{
		EventTipOverviewController controller = new EventTipOverviewController();
		controller.setGameTipService(service);
		
		int eventId = 1;
		
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		mockRequest.addParameter("eid", Integer.toString(eventId));
		
		MockHttpServletResponse mockResponse = new MockHttpServletResponse();
		
		ModelAndView modelAndView = controller.handleRequest(mockRequest, mockResponse);
		
		assertNotNull("Response is null", mockResponse);
		
		assertNotNull("ModelAndView is null", modelAndView);
		
        assertEquals("ViewNames do not match", "eventtipoverview", modelAndView.getViewName());
        assertNotNull("modelAndView.getModel() is null", modelAndView.getModel());
        Map modelMap = (Map)modelAndView.getModel().get("model");
        assertNotNull("modelMap.get(\"event\") is null", modelMap.get("event"));
        Event event = (Event)modelMap.get("event");
        assertEquals("Event Id's do not match", eventId, event.getId());
        assertNotNull("modelMap.get(\"gameTips\") is null", modelMap.get("gameTips"));
        List<GameTip> gameTips = (List<GameTip>)modelMap.get("gameTips");
        assertFalse("GameTips is empty", gameTips.isEmpty());
	}

	@Test
	public void testHandleRequestViewWithoutParameter() throws Exception{
		EventTipOverviewController controller = new EventTipOverviewController();
		controller.setGameTipService(service);
		
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		//mockRequest.addParameter("eid", Integer.toString(eventDao.findById(1).getId()));
		
		MockHttpServletResponse mockResponse = new MockHttpServletResponse();
		
		ModelAndView modelAndView = controller.handleRequest(mockRequest, mockResponse);
		
		assertNotNull("Response is null", mockResponse);
		
		assertNull("ModelAndView is null", modelAndView);
	}

}
