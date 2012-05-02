/**
 * 
 */
package de.worldtree.wetten.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import de.worldtree.wetten.service.AccountService;

/**
 * @author pascal
 *
 */
@org.springframework.stereotype.Controller(value="helloController")
public class HelloController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    AccountService accountService;
    /**
	 * @return the accountService
	 */
	public AccountService getAccountService() {
		return accountService;
	}

	/**
	 * @param accountService the accountService to set
	 */
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping("/")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	 String now = (new Date()).toString();
         logger.info("Returning hello view with " + now);
         
         Map<String, Object> modelMap = new HashMap<String, Object>();
         modelMap.put("now", now);
         
         modelMap.put("accounts", accountService.getAll());

         return new ModelAndView("hello", "model", modelMap);
    }

}