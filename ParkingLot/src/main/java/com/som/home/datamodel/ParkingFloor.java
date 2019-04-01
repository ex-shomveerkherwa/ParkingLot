package com.som.home.datamodel;

import java.util.Map;
import java.util.Map.Entry;

import com.som.home.Constants.ParkingSpotType;
import com.som.home.Constants.VehicleType;
import com.som.home.datamodel.subtypes.parkingSpot.CompactSpot;
import com.som.home.datamodel.subtypes.parkingSpot.ElectricSpot;
import com.som.home.datamodel.subtypes.parkingSpot.HandicappedSpot;
import com.som.home.datamodel.subtypes.parkingSpot.LargeSpot;

public class ParkingFloor {

	private String id;
	private Map<String,HandicappedSpot> hanidcappedSpot;
	private Map<String,LargeSpot> largeSpot;
	private Map<String,ElectricSpot> electricSpot;
	private Map<String,CompactSpot> compactSpot;
	private ParkingDisplayBoard parkingDisplayBoard;
	
	
	public ParkingFloor(String id) {
		this.id=id;
	}
	
	public void addParkingSpot(ParkingSpot spot) {
		
	}
	
	public void assignVehicleToSpot(Vehicle vehicle,ParkingSpot spot) {
		
	}
	
	public boolean findAvailableSpot(VehicleType type,ParkingTicket ticket) {
		if(type.equals(VehicleType.TRUCK) || type.equals(VehicleType.VAN)) {
			ticket.setSpotType(ParkingSpotType.LARGE);
			return checkSpots(largeSpot);
		}
		if(type.equals(VehicleType.CAR)) {
			{
				boolean compactSpotAvailability = checkSpots(compactSpot);
				if(!compactSpotAvailability) {
					ticket.setSpotType(ParkingSpotType.LARGE);
					return checkSpots(largeSpot);
				}
				ticket.setSpotType(ParkingSpotType.COMPACT);
				return compactSpotAvailability;
			}
		}
		/*if(type.equals(VehicleType.ELECTRIC)) {
			if(electricSpotCount < maxElectricSpotCount) {
				electricSpotCount++;
			} else if(compactSpotCount <= maxCompactSpotCount) {
				compactSpotCount++;
			}else {
				largeSpotCount++;
			}
		}*/
		return false;
	}
	
	private boolean checkSpots(Map<String,? extends ParkingSpot> input) {
			for(Entry<String, ? extends ParkingSpot> entry :input.entrySet()) {
				ParkingSpot spot = entry.getValue();
				if(spot.isFree())
					return true;
			}
		return false;
	}
	
	private ParkingSpot getFreeSpot(Map<String,? extends ParkingSpot> input) {
		for(Entry<String, ? extends ParkingSpot> entry :input.entrySet()) {
			ParkingSpot spot = entry.getValue();
			if(spot.isFree())
				return spot;
		}
	return null;
}

	
	public void parkAtSpot(ParkingTicket ticket) {
		
		//based on the type of spot , get a spot from the map , assign its id to ticket and return 
		ParkingSpotType spotType = ticket.getSpotType();
		ParkingSpot	parkingSpot = null;
		switch(spotType) {
		case LARGE : 
			parkingSpot = getFreeSpot(largeSpot);
			ticket.setParkingSpotId(parkingSpot.getNumber());
			break;
			
		case COMPACT :
			parkingSpot = getFreeSpot(compactSpot);
			ticket.setParkingSpotId(parkingSpot.getNumber());
			break;
		}
	}
	
	public void updateDisplayBoard() {
		
	}
	
	public void freeSpot(String spotId , ParkingSpotType type) throws Exception {
		switch(type) {
		case LARGE:
			getLargeSpot().get(spotId).removeVehicle();
			break;
		case COMPACT:
			getCompactSpot().get(spotId).removeVehicle();
			break;
		default:
			throw new Exception("No spot found with spot it "+spotId);
		}
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, HandicappedSpot> getHanidcappedSpot() {
		return hanidcappedSpot;
	}

	public void setHanidcappedSpot(Map<String, HandicappedSpot> hanidcappedSpot) {
		this.hanidcappedSpot = hanidcappedSpot;
	}

	public Map<String, LargeSpot> getLargeSpot() {
		return largeSpot;
	}

	public void setLargeSpot(Map<String, LargeSpot> largeSpot) {
		this.largeSpot = largeSpot;
	}

	public Map<String, ElectricSpot> getElectricSpot() {
		return electricSpot;
	}

	public void setElectricSpot(Map<String, ElectricSpot> electricSpot) {
		this.electricSpot = electricSpot;
	}

	public Map<String, CompactSpot> getCompactSpot() {
		return compactSpot;
	}

	public void setCompactSpot(Map<String, CompactSpot> compactSpot) {
		this.compactSpot = compactSpot;
	}

	public ParkingDisplayBoard getParkingDisplayBoard() {
		return parkingDisplayBoard;
	}

	public void setParkingDisplayBoard(ParkingDisplayBoard parkingDisplayBoard) {
		this.parkingDisplayBoard = parkingDisplayBoard;
	}

}
