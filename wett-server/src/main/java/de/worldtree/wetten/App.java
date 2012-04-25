/**
 * 
 */
package de.worldtree.wetten;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.worldtree.wetten.dao.AccountDao;
import de.worldtree.wetten.dao.GameDao;
import de.worldtree.wetten.model.Account;
import de.worldtree.wetten.model.Game;

/**
 * @author pascal
 *
 */
public class App {

	private static Log log = LogFactory.getLog(App.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx =  
				  new ClassPathXmlApplicationContext("applicationContext-wett-server.cml.xml");
		
		AccountDao accDao = (AccountDao)ctx.getBean("accountDao");
		
		List<Account> result = accDao.findAll();
		
		for(Account acc : result)
			log.info(acc.toString());
		
		GameDao gdao =(GameDao) ctx.getBean("gameDao");
		
		List<Game> games = gdao.findAll();
		
		for(Game g : games)
			log.info(g.toString());
		
		
		
	}

}
