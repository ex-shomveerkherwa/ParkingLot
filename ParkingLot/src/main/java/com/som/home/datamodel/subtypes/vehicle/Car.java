package com.som.home.datamodel.subtypes.vehicle;

import com.som.home.Constants.VehicleType;
import com.som.home.datamodel.Vehicle;

public class Car extends Vehicle{
	
	public Car(String licenseNumber) {
		super(VehicleType.CAR,licenseNumber);
	}

}
