package com.som.home.Utility;

import java.util.HashMap;
import java.util.Map;

import com.som.home.datamodel.ParkingFloor;
import com.som.home.datamodel.ParkingSpot;
import com.som.home.datamodel.subtypes.parkingSpot.CompactSpot;
import com.som.home.datamodel.subtypes.parkingSpot.ElectricSpot;
import com.som.home.datamodel.subtypes.parkingSpot.HandicappedSpot;
import com.som.home.datamodel.subtypes.parkingSpot.LargeSpot;

public class DummyData {

	public ParkingFloor getParkingFloor(){
		
		ParkingFloor floor = new ParkingFloor("111");
		
		ParkingSpot lSpot = new LargeSpot();
		ParkingSpot hSpot = new HandicappedSpot();
		ParkingSpot eSpot = new ElectricSpot();
		ParkingSpot cSpot = new CompactSpot();
		
		Map<String , LargeSpot> lSpotMap = new HashMap<String,LargeSpot>();
		Map<String , HandicappedSpot> hSpotMap = new HashMap<String,HandicappedSpot>();
		Map<String , ElectricSpot> eSpotMap = new HashMap<String,ElectricSpot>();
		Map<String , CompactSpot> cSpotMap = new HashMap<String,CompactSpot>();
		
		floor.setLargeSpot(lSpotMap);
		floor.setHanidcappedSpot(hSpotMap);
		floor.setCompactSpot(cSpotMap);
		floor.setElectricSpot(eSpotMap);
		
		return floor;
	}
	
}
