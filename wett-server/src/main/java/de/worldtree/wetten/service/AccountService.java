package de.worldtree.wetten.service;

import java.util.List;

import de.worldtree.wetten.model.Account;
import de.worldtree.wetten.model.Event;

public interface AccountService {
	
	public List<Account> getAll();
	public Account getAccount(int accountId);
	public Account getAccount(String accountName);
	public List<Event> getAccountEvents(int accountId);
	public List<Event> getAccountEvents(String accountName);
	public List<Event> getAccountEvents(Account account);
}
