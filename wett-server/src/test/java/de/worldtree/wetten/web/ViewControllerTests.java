///**
// * 
// */
//package de.worldtree.wetten.web;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.web.servlet.ModelAndView;
//
//import de.worldtree.wetten.model.Event;
//import de.worldtree.wetten.model.Game;
//import de.worldtree.wetten.service.AccountService;
//import de.worldtree.wetten.service.EventService;
//import de.worldtree.wetten.service.GameService;
//import de.worldtree.wetten.service.model.GameTip;
//import de.worldtree.wetten.service.model.PlayerTip;
//
///**
// * @author pascal
// *
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:applicationContext-wett-server.cml.xml")
//public class ViewControllerTests {
//
//	private final static Log log = LogFactory.getLog(ViewControllerTests.class);
//
//	@Autowired
//	private AccountService accountService;
//	@Autowired
//	private EventService eventService;
//	@Autowired
//	private GameService gameService;
//	
//	@Autowired
//	private ViewController controller;	
//
//	@Test
//	public void test_helloView() throws Exception {		
//		ModelAndView modelAndView = controller.helloView(null, null);		
//		assertEquals("hello", modelAndView.getViewName());
//		assertNotNull(modelAndView.getModel());
//		Map modelMap = (Map)modelAndView.getModel().get("model");
//		String nowValue = (String) modelMap.get("now");
//		assertNotNull(nowValue);
//		assertNotNull(modelMap.get("accounts"));
//	}
//
//	@Test
//	public void test_eventListView() throws Exception {
//		ModelAndView modelAndView = controller.eventListView(null, null);
//		assertNotNull("ModelAndView is null", modelAndView);
//
//		assertEquals("ViewNames do not match", "eventlist", modelAndView.getViewName());
//		assertNotNull("modelAndView.getModel() is null", modelAndView.getModel());
//		Map modelMap = (Map)modelAndView.getModel().get("model");
//		assertNotNull("modelMap.get(\"events\") is null", modelMap.get("events"));
//	}
//
//	@Test
//	public void test_eventOverviewView_withParams() throws Exception {
//		int eventId = eventService.getAll().get(0).getId();
//
//		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
//		mockRequest.addParameter("eid", Integer.toString(eventId));
//
//		MockHttpServletResponse mockResponse = new MockHttpServletResponse();
//
//		ModelAndView modelAndView = controller.eventOverviewView(mockRequest, mockResponse);
//
//		assertNotNull("Response is null", mockResponse);
//
//		assertNotNull("ModelAndView is null", modelAndView);
//
//		assertEquals("ViewNames do not match", "eventoverview", modelAndView.getViewName());
//		assertNotNull("modelAndView.getModel() is null", modelAndView.getModel());
//		Map modelMap = (Map)modelAndView.getModel().get("model");
//		assertNotNull("modelMap.get(\"event\") is null", modelMap.get("event"));
//		Event event = (Event)modelMap.get("event");
//		assertEquals("Event Id's do not match", eventId, event.getId());
//		assertNotNull("modelMap.get(\"games\") is null", modelMap.get("games"));
//	}
//	@Test
//	public void test_eventOverviewView_withoutParams() throws Exception {
//		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
//		MockHttpServletResponse mockResponse = new MockHttpServletResponse();
//
//		ModelAndView modelAndView = controller.eventOverviewView(mockRequest, mockResponse);
//
//		assertNotNull("Response is null", mockResponse);
//
//		assertNull("ModelAndView is null", modelAndView);
//	}
//	@Test
//	public void test_eventTipOverview_withParam() throws Exception{
//		int eventId = 1;
//		
//		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
//		mockRequest.addParameter("eid", Integer.toString(eventId));
//		
//		MockHttpServletResponse mockResponse = new MockHttpServletResponse();
//		
//		ModelAndView modelAndView = controller.eventTipOverviewView(mockRequest, mockResponse);
//		
//		assertNotNull("Response is null", mockResponse);
//		
//		assertNotNull("ModelAndView is null", modelAndView);
//		
//        assertEquals("ViewNames do not match", "eventtipoverview", modelAndView.getViewName());
//        assertNotNull("modelAndView.getModel() is null", modelAndView.getModel());
//        Map modelMap = (Map)modelAndView.getModel().get("model");
//        assertNotNull("modelMap.get(\"event\") is null", modelMap.get("event"));
//        Event event = (Event)modelMap.get("event");
//        assertEquals("Event Id's do not match", eventId, event.getId());
//	}
//	@Test
//	public void test_gameTipOverviewView() throws Exception{
//		int gameId = 1;
//		
//		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
//		mockRequest.addParameter("gid", Integer.toString(gameId));
//		
//		MockHttpServletResponse mockResponse = new MockHttpServletResponse();
//		
//		ModelAndView modelAndView = controller.gameTipOverviewView(mockRequest, mockResponse);
//		
//		assertNotNull("Response is null", mockResponse);
//		
//		assertNotNull("ModelAndView is null", modelAndView);
//		
//        assertEquals("ViewNames do not match", "gametipoverview", modelAndView.getViewName());
//        assertNotNull("modelAndView.getModel() is null", modelAndView.getModel());
//        Map modelMap = (Map)modelAndView.getModel().get("model");
//        assertNotNull("modelMap.get(\"game\") is null", modelMap.get("game"));
//        Game game = (Game)modelMap.get("game");
//        assertEquals("Event Id's do not match", gameId, game.getId());
//        assertNotNull("modelMap.get(\"playerTips\") is null", modelMap.get("playerTips"));
//        List<PlayerTip> playerTips = (List<PlayerTip>)modelMap.get("playerTips");
//        assertFalse("PlayerTips is empty", playerTips.isEmpty());
//	}
//}
