/**
 * 
 */
package de.worldtree.wetten.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pascal
 *
 */
public class ApplicationSecurityManager {

	public static final String USER = "user";
	
	public Object getAccount(HttpServletRequest request) {
		return request.getSession(true).getAttribute(USER);
	}
	
	public void setAccount(HttpServletRequest request, Object account) {
		request.getSession(true).setAttribute(USER, account);
	}
	
	public void removeAccount(HttpServletRequest request) {
		request.getSession(true).removeAttribute(USER);
	}
	
}
