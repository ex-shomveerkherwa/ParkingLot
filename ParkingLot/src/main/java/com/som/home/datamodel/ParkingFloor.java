package com.som.home.datamodel;

import java.util.Map;

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
	
	public void updateDisplayBoard() {
		
	}
	
	public void freeSpot(ParkingSpot spot) {
		
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
