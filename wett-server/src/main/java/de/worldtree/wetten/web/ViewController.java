///**
// * 
// */
//package de.worldtree.wetten.web;
//
//import java.io.IOException;
//import java.util.Date;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import de.worldtree.wetten.model.Event;
//import de.worldtree.wetten.model.Game;
//import de.worldtree.wetten.model.Tip;
//import de.worldtree.wetten.service.AccountService;
//import de.worldtree.wetten.service.EventService;
//import de.worldtree.wetten.service.GameService;
//
///**
// * @author pascal
// *
// */
//@Controller
//public class ViewController {
//	
//	private static final Log log = LogFactory.getLog(ViewController.class);
//	
//	@Autowired
//	private AccountService accountService;
//	@Autowired
//	private EventService eventService;
//	@Autowired
//	private GameService gameService;
//	
//	@RequestMapping("/")
//	public ModelAndView helloView(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//    	 String now = (new Date()).toString();
//         log.info("Returning hello view with " + now);
//         
//         Map<String, Object> modelMap = new HashMap<String, Object>();
//         modelMap.put("now", now);
//         
//         modelMap.put("accounts", accountService.getAll());
//
//         return new ModelAndView("hello", "model", modelMap);
//    }
//	
//	@RequestMapping("/events/list")
//	public ModelAndView eventListView(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		 Map<String, Object> modelMap = new HashMap<String, Object>();
//        
//        modelMap.put("events", eventService.getAll());
//
//        return new ModelAndView("eventlist", "model", modelMap);
//	}
//	
//	@RequestMapping("/event/overview")
//	public ModelAndView eventOverviewView(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//		
//		Enumeration<String> e = request.getParameterNames();
//		while(e.hasMoreElements()) {
//			String paramName = e.nextElement();
//			log.debug(String.format("ParamName=%s  ParamValue=%s",paramName, request.getParameter(paramName)));
//		}
//		
//		if(request.getParameter("eid") == null) {
//			return null;
//		}
//		
//		
//		Map<String, Object> modelMap = new HashMap<String, Object>();
//        
//		Event event = eventService.getEvent(Integer.parseInt(request.getParameter("eid")));
//		
//		modelMap.put("event", event);
//		if(event != null) {
//			List<Game> games = eventService.getEventGames(event);
//			for(Game g :games) {
//				LogFactory.getLog(getClass()).debug(g.toString());
//			}
//			modelMap.put("games", games);
//		}
//		else
//			modelMap.put("games", null);
//		
//        return new ModelAndView("eventoverview", "model", modelMap);
//	}
//	
//	@RequestMapping("/event/tip/overview")
//	public ModelAndView eventTipOverviewView(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		
//		if(request.getParameter("eid") == null) {
//			return null;
//		}
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		int eventId = Integer.parseInt(request.getParameter("eid"));
//		
//		Event event = eventService.getEvent(eventId);
//		map.put("event", event);
//		
//		List<Game> games = gameService.getGamesForEvent(event);
//		map.put("games", games);
//		
//		
//        return new ModelAndView("eventtipoverview", "model", map);
//	}
//
//	@RequestMapping("/game/tip/overview")
//	public ModelAndView gameTipOverviewView(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		
//		if(request.getParameter("gid") == null) {
//			return null;
//		}
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		int gameId = Integer.parseInt(request.getParameter("gid"));
//		
//		Game game = gameService.getGame(gameId);
//		map.put("game", game);
//		
//		List<Tip> tips = gameService.getAllTipsForGame(game);
//		map.put("tips", tips);
//		
//		
//        return new ModelAndView("gametipoverview", "model", map);
//	}
//
//}
