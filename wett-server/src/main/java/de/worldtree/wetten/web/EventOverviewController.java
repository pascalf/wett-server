/**
 * 
 */
package de.worldtree.wetten.web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import de.worldtree.wetten.dao.EventDao;
import de.worldtree.wetten.dao.GameDao;
import de.worldtree.wetten.model.Event;
import de.worldtree.wetten.model.Game;

/**
 * @author pascal
 *
 */
public class EventOverviewController implements Controller {
	
	private static final Log log = LogFactory.getLog(EventOverviewController.class);

	private EventDao eventDao;
	public EventDao getEventDao() {
		return eventDao;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	public GameDao getGameDao() {
		return gameDao;
	}

	public void setGameDao(GameDao gameDao) {
		this.gameDao = gameDao;
	}

	private GameDao gameDao;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Enumeration<String> e = request.getParameterNames();
		while(e.hasMoreElements()) {
			String paramName = e.nextElement();
			log.debug(String.format("ParamName=%s  ParamValue=%s",paramName, request.getParameter(paramName)));
		}
		
		if(request.getParameter("eid") == null) {
			return null;
		}
		
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
        
		Event event = eventDao.findById(Integer.parseInt(request.getParameter("eid")));
		
		modelMap.put("event", event);
		if(event != null) {
			List<Game> games = gameDao.findByEventId(event.getId());
			for(Game g :games) {
				LogFactory.getLog(getClass()).debug(g.toString());
			}
			modelMap.put("games", games);
		}
		else
			modelMap.put("games", null);
		
        return new ModelAndView("eventoverview", "model", modelMap);
	}

}
