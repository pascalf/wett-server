package de.worldtree.wetten.service;

import java.util.List;

import de.worldtree.wetten.model.Account;
import de.worldtree.wetten.model.Event;
import de.worldtree.wetten.model.Game;

public interface EventService {
	public List<Event> getAll();
	public Event getEvent(int eventId);
	public Event getEvent(String eventName);
	public List<Game> getEventGames(int eventId);
	public List<Game> getEventGames(String eventName);
	public List<Game> getEventGames(Event event);
	public List<Account> getEventUsers(int eventId);
	public List<Account> getEventUsers(String eventName);
	public List<Account> getEventUsers(Event event);
}
