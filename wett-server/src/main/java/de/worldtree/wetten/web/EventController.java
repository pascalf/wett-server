/**
 * 
 */
package de.worldtree.wetten.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.worldtree.wetten.model.Account;
import de.worldtree.wetten.model.Event;
import de.worldtree.wetten.model.Game;
import de.worldtree.wetten.service.EventService;

/**
 * @author pascal
 *
 */
@Controller
@RequestMapping("/event/*")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getEvents(Model model) {
		List<Event> events = eventService.getAll();
		
		model.addAttribute("events", events);
		return "event/list";
	}
	
	@RequestMapping(value="/{eventId}", method=RequestMethod.GET)
	public String getEventDetails(@PathVariable int eventId, Model model) {
		Event event = eventService.getEvent(eventId);
		List<Account> users = eventService.getEventUsers(event);
		List<Game> games = eventService.getEventGames(event);
		
		model.addAttribute("event", event);
		model.addAttribute("users", users);
		model.addAttribute("games", games);
		return "event/details";
	}

}
