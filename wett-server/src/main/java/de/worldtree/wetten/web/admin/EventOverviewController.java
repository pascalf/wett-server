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

import de.worldtree.wetten.dao.EventDao;
import de.worldtree.wetten.model.Event;

/**
 * @author pascal
 *
 */
public class EventOverviewController implements Controller {

	private EventDao eventDao;
	
	/**
	 * @return the eventDao
	 */
	public EventDao getEventDao() {
		return eventDao;
	}

	/**
	 * @param eventDao the eventDao to set
	 */
	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		List<Event> events = eventDao.findAll();
		
		modelMap.put("events", events);
		
		return new ModelAndView("admin/eventoverview", "model", modelMap);
	}

}
