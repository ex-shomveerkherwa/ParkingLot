package com.som.home.datamodel;

import java.util.HashMap;

import com.som.home.datamodel.subtypes.parkingSpot.CompactSpot;
import com.som.home.datamodel.subtypes.parkingSpot.ElectricSpot;
import com.som.home.datamodel.subtypes.parkingSpot.HandicappedSpot;
import com.som.home.datamodel.subtypes.parkingSpot.LargeSpot;

public class ParkingFloor {

	private String id;
	private HashMap<String,HandicappedSpot> hanidcappedSpot;
	private HashMap<String,LargeSpot> largeSpot;
	private HashMap<String,ElectricSpot> electricSpot;
	private HashMap<String,CompactSpot> compactSpot;
	private ParkingDisplayBoard parkingDisplayBoard;
	
	
	public ParkingFloor(String id) {
		this.id=id;
	}
	
	public void addParkingSpot(ParkingSpot spot) {
		
	}
	
	public void assignVehicleToSpot(Vehicle vehicle,ParkingSpot spot) {
		
	}
	
	public void updateDisplayBoard() {
		
	}
	
	public void freeSpot(ParkingSpot spot) {
		
	}
	
}
