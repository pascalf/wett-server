/**
 * 
 */
package de.worldtree.wetten.dao;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.worldtree.wetten.model.Account;

/**
 * @author pascal
 *
 */
public class AccountDaoTest {

	private static AccountDao dao;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-wett-server.cml.xml");
		
		dao = (AccountDao)ctx.getBean("accountDao");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDown() throws Exception {
	}	
	
	@Test
	public void test_findAll() {
		List<Account> accounts = null;
		
		accounts = dao.findAll();
		
		assertNotNull("List is null", accounts);
		assertTrue("List is empty", !accounts.isEmpty());
	}
	
	@Test
	public void test_findById() {
		List<Account> accounts = null;
		accounts = dao.findAll();
		assertNotNull("List is null", accounts);
		assertTrue("List is empty", !accounts.isEmpty());
		Account testAccount = accounts.get(0);
		
		Account account = null;
		
		account = dao.findById(testAccount.getId());
		
		assertNotNull("Account is null", account);
		assertEquals("Account Id's do not match", account.getId(), testAccount.getId());
	}
	
	@Test
	public void test_findByName() {
		List<Account> accounts = null;
		accounts = dao.findAll();
		assertNotNull("List is null", accounts);
		assertTrue("List is empty", !accounts.isEmpty());
		Account testAccount = accounts.get(0);
		
		Account account = null;
		
		account = dao.findByName(testAccount.getName());
		
		assertNotNull("Account is null", account);
		assertEquals("Account Name's do not match", account.getName(), testAccount.getName());
	}
}
