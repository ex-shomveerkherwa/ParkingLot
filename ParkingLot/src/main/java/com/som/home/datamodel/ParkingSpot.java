package com.som.home.datamodel;

import com.som.home.Constants.ParkingSpotType;

public class ParkingSpot {

	private String number;
	private Vehicle vehicle;
	private ParkingSpotType type;
	private boolean free;
	
	public ParkingSpot(ParkingSpotType type) {
		this.type=type;
	}
	
	public boolean assignVehicle(Vehicle vehicle) {
		this.vehicle=vehicle;
		free = false;
		return true;
	}
	
	public boolean removeVehicle() {
		this.vehicle = null;
		free = true;
		return true;
	}
	
	
}
