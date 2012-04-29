/**
 * 
 */
package de.worldtree.wetten.web;

import java.util.Map;

import junit.framework.TestCase;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import de.worldtree.wetten.dao.AccountDao;

/**
 * @author pascal
 *
 */
public class HelloControllerTests extends TestCase {
	
	AccountDao dao;
	
	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-wett-server.cml.xml");
		
		dao = (AccountDao)ctx.getBean("accountDao");
	}

    public void testHandleRequestView() throws Exception{		
        HelloController controller = new HelloController();
        controller.setAccountDao(dao);
        
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        Map modelMap = (Map)modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
        assertNotNull(modelMap.get("accounts"));
    }
}
