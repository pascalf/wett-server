/**
 * 
 */
package de.worldtree.wetten.util;

import java.text.SimpleDateFormat;

/**
 * @author pascal
 *
 */
public class DateUtils {

	private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss z Z");
	
	public static SimpleDateFormat getSimpleDateFormat() {
		return simpleDateFormat;
	}
}
