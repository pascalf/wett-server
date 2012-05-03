/**
 * 
 */
package de.worldtree.wetten.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.worldtree.wetten.model.Account;
import de.worldtree.wetten.service.AccountService;

/**
 * @author pascal
 *
 */
@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Autowired
	private AccountService accountService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getMain(Model model) {
		return "admin/main";
	}
	
	@RequestMapping(value="/account/", method=RequestMethod.GET)
	public String getAccountManager(Model model) {
		List<Account> accounts = accountService.getAll();
		
		model.addAttribute("accounts", accounts);
		return "admin/accounts";
	}
}
