package de.worldtree.wetten.service;

import java.util.Date;
import java.util.List;

import de.worldtree.wetten.model.Account;
import de.worldtree.wetten.model.Event;
import de.worldtree.wetten.model.Game;
import de.worldtree.wetten.model.Tip;

public interface GameService {
	public List<Game> getAll();
	public Game getGame(int gameId);
	public List<Game> getGamesForEvent(int eventId);
	public List<Game> getGamesForEvent(Event event);
	public List<Game> getGamesNotFinished(Date closingTime);
	public List<Game> getGamesNotFinished(int eventId, Date closingTime);
	public List<Game> getGamesFinished(Date closingTime);
	public List<Game> getGamesFinished(int eventId, Date closingTime);
	
	public List<Tip> getAllTips();
	
	public List<Tip> getAllTipsForGame(int gameId);
	public List<Tip> getAllTipsForGame(Game game);
	
	public List<Tip> getAllTipsForPlayer(int playerId);
	public List<Tip> getAllTipsForPlayer(Account player);
	
	public Tip getTip(int gameId, int playerId);
	public Tip getTip(Game game, int playerId);
	public Tip getTip(int gameId, Account player);
	public Tip getTip(Game game, Account player);
}
