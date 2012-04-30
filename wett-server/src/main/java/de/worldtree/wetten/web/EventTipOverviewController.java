/**
 * 
 */
package de.worldtree.wetten.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import de.worldtree.wetten.service.GameTipService;

/**
 * @author pascal
 *
 */
public class EventTipOverviewController implements Controller {

	private GameTipService gameTipService;

	/**
	 * @return the gameTipService
	 */
	public GameTipService getGameTipService() {
		return gameTipService;
	}

	/**
	 * @param gameTipService the gameTipService to set
	 */
	public void setGameTipService(GameTipService gameTipService) {
		this.gameTipService = gameTipService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(request.getParameter("eid") == null) {
			return null;
		}
		
		
		Map modelMap = gameTipService.findTipsForEvent(Integer.parseInt(request.getParameter("eid")));
		
		
        return new ModelAndView("eventtipoverview", "model", modelMap);
	}

}
