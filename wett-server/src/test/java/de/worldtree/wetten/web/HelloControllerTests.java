/**
 * 
 */
package de.worldtree.wetten.web;

import static org.junit.Assert.*;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import de.worldtree.wetten.service.AccountService;

/**
 * @author pascal
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-wett-server.cml.xml")
public class HelloControllerTests {
	
	private final static Log log = LogFactory.getLog(HelloControllerTests.class);
	
	@Autowired
    HelloController controller;	

	@Test
    public void testHandleRequestView() throws Exception{		
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        Map modelMap = (Map)modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
        assertNotNull(modelMap.get("accounts"));
    }
}
