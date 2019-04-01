package com.som.home.datamodel.subtypes.vehicle;

import com.som.home.Constants.VehicleType;
import com.som.home.datamodel.Vehicle;

public class MotorCycle extends Vehicle{
	
	public MotorCycle(String licenseNumber) {
		super(VehicleType.MOTORBIKE ,licenseNumber);
	}
}
