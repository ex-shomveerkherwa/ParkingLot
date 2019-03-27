package com.som.home.ParkingLot;

import java.util.HashMap;

import com.som.home.datamodel.Address;
import com.som.home.datamodel.Panel;
import com.som.home.datamodel.ParkingFloor;
import com.som.home.datamodel.ParkingRate;
import com.som.home.datamodel.ParkingTicket;
import com.som.home.datamodel.Vehicle;

public class ParkingLot {
	
	private String name;
	private Address address;
	private ParkingRate parkingRate;
	private int compactSpotCount;
	private int electricSpotCount;
	private int largeSpotCount;
	private int motorbikeSpotCount;
	/*private final int maxCount;
*/	
	private HashMap<String,Panel> entryPanel;
	private HashMap<String,Panel> exitPanel;
	private HashMap<String,ParkingFloor> parkingFloor;
	private HashMap<String,ParkingTicket> activeTickets;
	
	private static ParkingLot parkingLot= null;
	
	private ParkingLot() {
		
	}
	
	public static ParkingLot getInstance() {
		if(parkingLot == null) {
			parkingLot = new ParkingLot();
		}
		return parkingLot;
	}
	
	public ParkingTicket getNewParkingTicket(Vehicle vehicle) {
		return null;
	}

	public boolean isFull() {
		return false;
	}
	
	public void addParkingFloor(ParkingFloor floor) {}

	public void addEntrancePanel(Panel entrancePanel) {}

	public void addExitPanel(Panel exitPanel) {}

}
