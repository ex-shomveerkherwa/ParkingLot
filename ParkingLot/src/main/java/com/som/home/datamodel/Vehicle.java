package com.som.home.datamodel;

import com.som.home.Constants.VehicleType;

public abstract class Vehicle {

	private String liceseNumber;
	private final VehicleType type;
	private ParkingTicket ticket;
	
	public Vehicle(VehicleType type) {
		this.type=type;
	}
	
	public void assignTicket(ParkingTicket ticket) {
		this.ticket=ticket;
	}
	
}
