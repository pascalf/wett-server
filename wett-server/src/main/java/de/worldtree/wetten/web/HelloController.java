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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import de.worldtree.wetten.dao.AccountDao;

/**
 * @author pascal
 *
 */
public class HelloController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());
    
    private AccountDao accountDao;

    public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	 String now = (new Date()).toString();
         logger.info("Returning hello view with " + now);
         
         Map<String, Object> modelMap = new HashMap<String, Object>();
         modelMap.put("now", now);
         
         modelMap.put("accounts", accountDao.findAll());

         return new ModelAndView("hello", "model", modelMap);
    }

}