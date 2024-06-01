package cn.estore.util;

import java.util.Date;
import java.text.DateFormat;

public class CountTime {
	public String currentlyTime() {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		return dateFormat.format(date);
	}
}
