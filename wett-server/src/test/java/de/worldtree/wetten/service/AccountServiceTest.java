/**
 * 
 */
package de.worldtree.wetten.service;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.worldtree.wetten.model.Account;

/**
 * @author pascal
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-wett-server.cml.xml")
public class AccountServiceTest {
	
	private final static Log log = LogFactory.getLog(AccountServiceTest.class);
	
	@Autowired
	AccountService service;

	@Test
	public void test_getAll() {
		List<Account> list = service.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
	}
	
	@Test
	public void test_getAccountById() {
		List<Account> list = service.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		
		Account testAccount = list.get(0);
		int accountId = testAccount.getId();
		
		
		Account account = service.getAccount(accountId);
		assertNotNull("Account is null", account);
		assertEquals("Account Id's do not match", accountId, account.getId());
	}
	
	@Test
	public void test_getAccountByName() {
		List<Account> list = service.getAll();
		assertNotNull("List is null", list);
		assertFalse("List is empty", list.isEmpty());
		
		Account testAccount = list.get(0);
		String accountName = testAccount.getName();
		
		
		Account account = service.getAccount(accountName);
		assertNotNull("Account is null", account);
		assertEquals("Account Name's do not match", accountName, account.getName());
	}

}
