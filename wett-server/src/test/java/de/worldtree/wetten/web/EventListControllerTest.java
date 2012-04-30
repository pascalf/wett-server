/**
 * 
 */
package de.worldtree.wetten.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import de.worldtree.wetten.dao.EventDao;

/**
 * @author pascal
 *
 */
public class EventListControllerTest {

	static ApplicationContext ctx;
	
	EventDao eventDao;
	
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
	}

	@Test
	public void testHandleRequestView() throws Exception{
		EventListController controller = new EventListController();
		controller.setEventDao(eventDao);
		
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertNotNull("ModelAndView is null", modelAndView);
		
        assertEquals("ViewNames do not match", "eventlist", modelAndView.getViewName());
        assertNotNull("modelAndView.getModel() is null", modelAndView.getModel());
        Map modelMap = (Map)modelAndView.getModel().get("model");
        assertNotNull("modelMap.get(\"events\") is null", modelMap.get("events"));
	}

}
