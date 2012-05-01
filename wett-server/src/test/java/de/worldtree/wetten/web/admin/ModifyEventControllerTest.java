/**
 * 
 */
package de.worldtree.wetten.web.admin;

import static org.junit.Assert.*;

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

/**
 * @author pascal
 *
 */
public class ModifyEventControllerTest {

private static ApplicationContext ctx;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext-wett-server.cml.xml");
	}

	private ModifyEventController controller;
	private MockHttpServletRequest mockRequest;
	private MockHttpServletResponse mockResponse;
	
	@Before
	public void setUp() throws Exception {
		mockRequest = new MockHttpServletRequest();
		mockResponse = new MockHttpServletResponse();
		
		controller = new ModifyEventController();
		
	}

	@Test
	public void test_handleRequest() throws Exception {
		
		ModelAndView modelAndView = controller.handleRequest(mockRequest, mockResponse);
		
		assertNotNull("ModelAndView is null", modelAndView);
		assertEquals("ViewName's do not match", "admin/modifyevent", modelAndView.getViewName());
		assertNotNull("Model is null", modelAndView.getModel());
		assertNotNull("Model data is null", modelAndView.getModel().get("model"));
		Map modelMap = (Map)modelAndView.getModel().get("model");
		
		
	}

}
