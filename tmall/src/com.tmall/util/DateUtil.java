package com.tmall.util;

/**
 * @author Jaye
 *
 * @description
 * <p>When it is stored in the database, it can receive the type of java.util.Date
 * 	and then use the getTime() method to get the long value that represents the Date object,
 * 	and then construct a Timestamp object with this long value into the database.</p>
 *
 * 	<p>When fetching from the stored database, you can firstly get the Timestamp
 * 	to get the long value using its getTime() method, and then construct a java.util.Date
 * 	object with this long value, so that you can operate on this Date object.</p>
 *
 */
public class DateUtil {

	public static java.sql.Timestamp d2t(java.util.Date d) {
		if (null == d)
			return null;
		return new java.sql.Timestamp(d.getTime());
	}

	public static java.util.Date t2d(java.sql.Timestamp t) {
		if (null == t)
			return null;
		return new java.util.Date(t.getTime());
	}
}
