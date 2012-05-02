/**
 * 
 */
package de.worldtree.wetten.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
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
public class AccountDaoTest {
	
	private static final Log log = LogFactory.getLog(AccountDaoTest.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private AccountDao dao;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		sessionFactory.getCurrentSession().beginTransaction();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		boolean commitFailed = false;
		try {
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			commitFailed = true;
			log.error("Transaction.commit() failed", e);
			throw e;
		} 
		if(commitFailed)
			fail("Something threw exception, see log");
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
