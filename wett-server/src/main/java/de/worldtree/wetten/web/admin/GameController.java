/**
 * 
 */
package de.worldtree.wetten.web.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author pascal
 *
 */
public class GameController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String now = (new Date()).toString();
        
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("now", now);        
        
        return new ModelAndView("admin/games", "model", modelMap);
	}

}
