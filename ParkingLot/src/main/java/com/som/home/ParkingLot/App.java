package com.som.home.ParkingLot;

import com.som.home.datamodel.ParkingTicket;
import com.som.home.datamodel.subtypes.vehicle.Car;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    
    	ParkingLot parkingLot = ParkingLot.getInstance();
    	
    	Car c1 = new Car("123");
    	Car c2 = new Car("456");
    	Car c3 = new Car("789");
    	Car c4 = new Car("888");
    	Car c5 = new Car("999");
    	try {
			parkingLot.getNewParkingTicket(c1);
			Thread.sleep(1000);
			parkingLot.getNewParkingTicket(c2);
			Thread.sleep(1000);
			parkingLot.getNewParkingTicket(c3);
			Thread.sleep(1000);
			ParkingTicket t1 = parkingLot.getNewParkingTicket(c4);
			Thread.sleep(1000);
			parkingLot.removeVehicle(t1, "111");
			Thread.sleep(1000);
			parkingLot.getNewParkingTicket(c5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
