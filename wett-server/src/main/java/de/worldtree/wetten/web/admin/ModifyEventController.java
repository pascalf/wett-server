/**
 * 
 */
package de.worldtree.wetten.web.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;

import de.worldtree.wetten.model.Event;

/**
 * @author pascal
 *
 */
public class ModifyEventController extends SimpleFormController {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		
		return new ModelAndView("admin/modifyevent", "model", modelMap);
	}

}
