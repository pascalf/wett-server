/**
 * 
 */
package de.worldtree.wetten.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import de.worldtree.wetten.dao.EventDao;

/**
 * @author pascal
 *
 */
public class EventListController implements Controller {

	private EventDao eventDao;
	
	public EventDao getEventDao() {
		return eventDao;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		 Map<String, Object> modelMap = new HashMap<String, Object>();
         
         modelMap.put("events", eventDao.findAll());

         return new ModelAndView("eventlist", "model", modelMap);	}

}
