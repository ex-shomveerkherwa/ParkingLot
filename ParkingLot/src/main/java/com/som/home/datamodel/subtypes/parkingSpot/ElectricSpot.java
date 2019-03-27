package com.som.home.datamodel.subtypes.parkingSpot;

import com.som.home.Constants.ParkingSpotType;
import com.som.home.datamodel.ParkingSpot;

public class ElectricSpot extends ParkingSpot{

	public ElectricSpot(ParkingSpotType type) {
		super(type.ELECTRIC);
	}
}
