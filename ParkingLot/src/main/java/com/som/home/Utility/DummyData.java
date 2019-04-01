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
		
		String one ="A1";
		String two = "A2";
		
		LargeSpot lSpot1 = new LargeSpot(one);
		LargeSpot lSpot2 = new LargeSpot(two);
		
		HandicappedSpot hSpot1 = new HandicappedSpot(one);
		HandicappedSpot hSpot2 = new HandicappedSpot(two);
		
		ElectricSpot eSpot1 = new ElectricSpot(one);
		ElectricSpot eSpot2 = new ElectricSpot(two);
		
		CompactSpot cSpot1 = new CompactSpot(one);
		CompactSpot cSpot2 = new CompactSpot(two);
		
		Map<String , LargeSpot> lSpotMap = new HashMap<String,LargeSpot>();
		Map<String , HandicappedSpot> hSpotMap = new HashMap<String,HandicappedSpot>();
		Map<String , ElectricSpot> eSpotMap = new HashMap<String,ElectricSpot>();
		Map<String , CompactSpot> cSpotMap = new HashMap<String,CompactSpot>();
		
		//Add slots to the floor
		lSpotMap.put(lSpot1.getNumber(), lSpot1);
		lSpotMap.put(lSpot2.getNumber(), lSpot2);
		
		hSpotMap.put(hSpot1.getNumber(), hSpot1);
		hSpotMap.put(hSpot2.getNumber(), hSpot2);
		
		eSpotMap.put(eSpot2.getNumber(), eSpot2);
		eSpotMap.put(eSpot1.getNumber(), eSpot1);
		
		cSpotMap.put(cSpot1.getNumber(), cSpot1);
		cSpotMap.put(cSpot2.getNumber(), cSpot2);
		
		
		floor.setLargeSpot(lSpotMap);
		floor.setHanidcappedSpot(hSpotMap);
		floor.setCompactSpot(cSpotMap);
		floor.setElectricSpot(eSpotMap);
		
		return floor;
	}
	
}
