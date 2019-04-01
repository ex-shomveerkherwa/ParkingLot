package com.som.home.datamodel.subtypes.vehicle;

import com.som.home.Constants.VehicleType;
import com.som.home.datamodel.Vehicle;

public class Van extends Vehicle{
	
	public Van(String licenseNumber) {
		super(VehicleType.VAN,licenseNumber);
	}
	
}
