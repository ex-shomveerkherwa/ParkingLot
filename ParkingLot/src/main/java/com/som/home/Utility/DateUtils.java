package com.som.home.Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
	
	public static Date getCurrentDate() {
		return new Date();
	}
	
	
	//Currently supporting only hours and days
	public static int getTimeElapsed(Date start , Date end) {
		
		Long startTime = start.getTime();
		Long endTime = end.getTime();
		
		Long duration = endTime-startTime;
		
		int hours = (int) (duration/ (1000*60*60)%24);
		int days = (int) (duration / (1000*60*60*24));
		
		if(days > 0) {
			return days;
		}
		
		return hours;
	}
}
