package com.som.home.ParkingLot;

import java.util.HashMap;
import java.util.Map;

import com.som.home.Constants.ParkingSpotType;
import com.som.home.Constants.VehicleType;
import com.som.home.Utility.DummyData;
import com.som.home.datamodel.Address;
import com.som.home.datamodel.EntrancePanel;
import com.som.home.datamodel.ExitPanel;
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
	
	private final int maxCompactSpotCount = 2;
	private final int maxElectricSpotCount = 2;
	private final int maxLargeSpotCount = 2;
	private final int maxMotorbikeSpotCount = 2;
	
	
	EntrancePanel entrancePanel;
	ExitPanel exitPanel;
	private Map<String, ParkingFloor> parkingFloorMap;
	private HashMap<String, ParkingTicket> activeTickets;

	private static ParkingLot parkingLot = null;

	private ParkingLot() {
		// initialize the attributes from db , 
		DummyData dummy = new DummyData();
		parkingFloorMap = new HashMap<String,ParkingFloor>();
		parkingFloorMap.put("111", dummy.getParkingFloor());
		
		//Based on total number of floors , initialize the maxCount variables , dummy data has 2 .
		
		activeTickets = new HashMap<String, ParkingTicket>();
		entrancePanel = new EntrancePanel();
		exitPanel = new ExitPanel();
	}

	public static ParkingLot getInstance() {
		if (parkingLot == null) {
			parkingLot = new ParkingLot();
		}
		return parkingLot;
	}

	public ParkingTicket getNewParkingTicket(Vehicle vehicle) throws Exception {
		
		VehicleType type = vehicle.getType();
		
		//check availability of slots
		if(isFull(type)) {
			throw new Exception("No available spots ");
		}
		
		ParkingTicket ticket = new ParkingTicket("Jan"+System.currentTimeMillis());
		
		//park the vehicle at the floor based on availablility 
		for(Map.Entry<String, ParkingFloor> entry : parkingFloorMap.entrySet()) {
			ParkingFloor floor = entry.getValue();
			if(floor.findAvailableSpot(type,ticket)) {
				ticket.setVehicleRegistrationNumber(vehicle.getLiceseNumber());
				floor.parkAtSpot(ticket);
			}
		}
		vehicle.assignTicket(ticket);
		//TODO : save the ticket to db , after saving perform the below steps 
		incrementSpotCount(type);
		this.activeTickets.put(ticket.getId(),ticket);
		
		printTicket(ticket);
		
		return ticket;
	}

	private void printTicket(ParkingTicket ticket) {
		entrancePanel.PrintTicket(ticket);
	}

	public void incrementSpotCount(VehicleType type) {
		
		if(type.equals(VehicleType.TRUCK) || type.equals(VehicleType.VAN)) {
			largeSpotCount++;
		}
		if(type.equals(VehicleType.MOTORBIKE)) {
			motorbikeSpotCount++;
		}
		if(type.equals(VehicleType.CAR)) {
			{
				if(compactSpotCount < maxCompactSpotCount) {
					compactSpotCount++;
				}
				else {
					largeSpotCount++;
				}
			}
		}
		if(type.equals(VehicleType.ELECTRIC)) {
			if(electricSpotCount < maxElectricSpotCount) {
				electricSpotCount++;
			} else if(compactSpotCount <= maxCompactSpotCount) {
				compactSpotCount++;
			}else {
				largeSpotCount++;
			}
		}
	}

	//TODO: decrement spots counts for other types too.
	public void decrementSpotCount(ParkingSpotType type) {
		
		if(type.equals(ParkingSpotType.LARGE)) {
			largeSpotCount--;
		}
		else if(type.equals(ParkingSpotType.COMPACT)) {
			compactSpotCount--;
		}
	}
	
	public boolean isFull(VehicleType type) {
		if(type.equals(VehicleType.TRUCK) || type.equals(VehicleType.VAN)) {
			return (largeSpotCount >= maxLargeSpotCount);
		}
		
		if(type.equals(VehicleType.MOTORBIKE)) {
			return (motorbikeSpotCount >= maxMotorbikeSpotCount);
		}
		
		if(type.equals(VehicleType.CAR)) {
			return((compactSpotCount+largeSpotCount) >= (maxCompactSpotCount + maxLargeSpotCount));
		}
		
		if(type.equals(VehicleType.ELECTRIC)) {
			return ((electricSpotCount+largeSpotCount+compactSpotCount) >= (maxCompactSpotCount+maxElectricSpotCount+maxLargeSpotCount));
		}
		return false;
	}

	
	public void removeVehicle(ParkingTicket ticket,String floorId) throws Exception {
		//exit panel must scan the ticket and generate the amount and process for payment before freeing up the vehicle from the system
		//exitPanel.processTicket(ticket);
		
		ParkingFloor floor = parkingFloorMap.get(floorId);
		
		if(null != floor) {
			floor.freeSpot(ticket.getParkingSpotId(),ticket.getSpotType());
		}else {
			throw new Exception("Invalid floor id");
		}
		decrementSpotCount(ticket.getSpotType());
		
	}
	
	public void addParkingFloor(ParkingFloor floor) {
	}

	public void addEntrancePanel(Panel entrancePanel) {
	}

	public void addExitPanel(Panel exitPanel) {
	}

}
