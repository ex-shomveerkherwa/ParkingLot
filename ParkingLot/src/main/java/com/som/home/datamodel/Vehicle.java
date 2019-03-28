package com.som.home.datamodel;

import com.som.home.Constants.VehicleType;

public abstract class Vehicle {

	private String liceseNumber;
	private final VehicleType type;
	private ParkingTicket ticket;
	
	public String getLiceseNumber() {
		return liceseNumber;
	}

	public void setLiceseNumber(String liceseNumber) {
		this.liceseNumber = liceseNumber;
	}

	public ParkingTicket getTicket() {
		return ticket;
	}

	public VehicleType getType() {
		return type;
	}
	
	public Vehicle(VehicleType type) {
		this.type=type;
	}
	
	public void assignTicket(ParkingTicket ticket) {
		this.ticket=ticket;
	}
	
}
