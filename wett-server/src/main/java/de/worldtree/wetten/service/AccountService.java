package de.worldtree.wetten.service;

import java.util.List;

import org.springframework.stereotype.Component;

import de.worldtree.wetten.model.Account;

public interface AccountService {
	
	public List<Account> getAll();
	public Account getAccount(int accountId);
	public Account getAccount(String accountName);

}
