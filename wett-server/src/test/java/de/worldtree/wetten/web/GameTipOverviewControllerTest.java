/**
 * 
 */
package de.worldtree.wetten.web;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
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

import de.worldtree.wetten.model.Game;
import de.worldtree.wetten.service.GameTipService;
import de.worldtree.wetten.service.model.PlayerTip;

/**
 * @author pascal
 *
 */
public class GameTipOverviewControllerTest {
	
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
		GameTipOverviewController controller = new GameTipOverviewController();
		controller.setGameTipService(service);
		
		int gameId = 1;
		
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		mockRequest.addParameter("gid", Integer.toString(gameId));
		
		MockHttpServletResponse mockResponse = new MockHttpServletResponse();
		
		ModelAndView modelAndView = controller.handleRequest(mockRequest, mockResponse);
		
		assertNotNull("Response is null", mockResponse);
		
		assertNotNull("ModelAndView is null", modelAndView);
		
        assertEquals("ViewNames do not match", "gametipoverview", modelAndView.getViewName());
        assertNotNull("modelAndView.getModel() is null", modelAndView.getModel());
        Map modelMap = (Map)modelAndView.getModel().get("model");
        assertNotNull("modelMap.get(\"game\") is null", modelMap.get("game"));
        Game game = (Game)modelMap.get("game");
        assertEquals("Event Id's do not match", gameId, game.getId());
        assertNotNull("modelMap.get(\"playerTips\") is null", modelMap.get("playerTips"));
        List<PlayerTip> playerTips = (List<PlayerTip>)modelMap.get("playerTips");
        assertFalse("PlayerTips is empty", playerTips.isEmpty());
	}

	@Test
	public void testHandleRequestViewWithoutParameter() throws Exception{
		GameTipOverviewController controller = new GameTipOverviewController();
		controller.setGameTipService(service);
		
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		//mockRequest.addParameter("eid", Integer.toString(eventDao.findById(1).getId()));
		
		MockHttpServletResponse mockResponse = new MockHttpServletResponse();
		
		ModelAndView modelAndView = controller.handleRequest(mockRequest, mockResponse);
		
		assertNotNull("Response is null", mockResponse);
		
		assertNull("ModelAndView is null", modelAndView);
	}

}