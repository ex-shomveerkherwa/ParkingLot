package com.som.home.datamodel;

import com.som.home.Constants.VehicleType;

public class ParkingRate {

	private int numberOfHours;
	private double rate;
	
	public int getNumberOfHours() {
		return numberOfHours;
	}
	public void setNumberOfHours(int numberOfHours) {
		this.numberOfHours = numberOfHours;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public double getRate(VehicleType type) {
		if(type.equals(VehicleType.MOTORBIKE))
			return 10;
		if(type.equals(VehicleType.CAR))
			return 20;
		if(type.equals(VehicleType.VAN) || type.equals(VehicleType.ELECTRIC))
			return 25;
		if(type.equals(VehicleType.TRUCK))
			return 30;
		
		return 15;
	}
}
