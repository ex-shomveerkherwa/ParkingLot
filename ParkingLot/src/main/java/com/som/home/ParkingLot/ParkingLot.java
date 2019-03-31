package com.som.home.ParkingLot;

import java.util.HashMap;
import java.util.Map;

import com.som.home.Constants.VehicleType;
import com.som.home.Utility.DummyData;
import com.som.home.datamodel.Address;
import com.som.home.datamodel.EntrancePanel;
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
	
	private final int maxCompactSpotCount = 10;
	private final int maxElectricSpotCount = 10;
	private final int maxLargeSpotCount = 10;
	private final int maxMotorbikeSpotCount = 10;
	
	
	private HashMap<String, EntrancePanel> entrancePanel;
	private HashMap<String, Panel> exitPanel;
	private Map<String, ParkingFloor> parkingFloorMap;
	private HashMap<String, ParkingTicket> activeTickets;

	private static ParkingLot parkingLot = null;

	private ParkingLot() {
		// initialize the attributes from db , 
		DummyData dummy = new DummyData();
		parkingFloorMap.put("1", dummy.getParkingFloor());
		
		
	}

	public static ParkingLot getInstance() {
		if (parkingLot == null) {
			parkingLot = new ParkingLot();
		}
		return parkingLot;
	}

	public ParkingTicket getNewParkingTicket(Vehicle vehicle) throws Exception {
		
		VehicleType type = vehicle.getType();
		
		if(isFull(type)) {
			throw new Exception("No available spots ");
		}
		
		ParkingTicket ticket = new ParkingTicket();
		vehicle.assignTicket(ticket);
		//TODO : save the ticket to db , after saving perform the below steps 
		incrementSpotCount(type);
		this.activeTickets.put(ticket.getId(),ticket);
		return ticket;
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

	public void addParkingFloor(ParkingFloor floor) {
	}

	public void addEntrancePanel(Panel entrancePanel) {
	}

	public void addExitPanel(Panel exitPanel) {
	}

}
