package com.som.home.datamodel.subtypes.parkingSpot;

import com.som.home.Constants.ParkingSpotType;
import com.som.home.datamodel.ParkingSpot;

public class LargeSpot extends ParkingSpot{

	public LargeSpot(ParkingSpotType type) {
		super(type.LARGE);
	}

}
