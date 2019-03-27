package com.som.home.datamodel;

import java.util.Date;

import com.som.home.Constants.ParkingSpotType;
import com.som.home.Constants.ParkingTicketStatus;

public class ParkingTicket {
	
	String id;
	Date startTime;
	ParkingSpotType spotType;
	ParkingTicketStatus status;
	String vehicleRegistrationNumber;
	Date endTime;

}
