/**
 * 
 */
package de.worldtree.wetten.util;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author pascal
 *
 */
public class Utilities {
	
	public static String collectionToString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext()
				&& i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}

}
