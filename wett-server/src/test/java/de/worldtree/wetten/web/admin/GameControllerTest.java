/**
 * 
 */
package de.worldtree.wetten.web.admin;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author pascal
 *
 */
public class GameControllerTest {

	private static ApplicationContext ctx;
	
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
	}

	@Test
	public void test() throws Exception {
		GameController controller = new GameController();
		
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		MockHttpServletResponse mockResponse = new MockHttpServletResponse();
		
		ModelAndView modelAndView = controller.handleRequest(mockRequest, mockResponse);
		assertEquals("admin/games", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        Map modelMap = (Map)modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
	}

}
