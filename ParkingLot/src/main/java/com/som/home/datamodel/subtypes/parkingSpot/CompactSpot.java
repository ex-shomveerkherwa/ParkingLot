package com.som.home.datamodel.subtypes.parkingSpot;

import com.som.home.Constants.ParkingSpotType;
import com.som.home.datamodel.ParkingSpot;

public class CompactSpot extends ParkingSpot{

	public CompactSpot(String number) {
		super(ParkingSpotType.COMPACT,number);
	}
}
