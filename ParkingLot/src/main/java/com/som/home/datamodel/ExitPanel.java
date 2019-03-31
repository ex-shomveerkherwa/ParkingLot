package com.som.home.datamodel;

import java.util.Date;

import com.som.home.Utility.DateUtils;

public class ExitPanel {

	
	private void processTicket(ParkingTicket ticket) {
		
		int duration = DateUtils.getTimeElapsed(ticket.startTime, ticket.endTime);
		
	}
}
