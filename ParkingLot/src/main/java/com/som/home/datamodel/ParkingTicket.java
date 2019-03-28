package com.som.home.datamodel;

import java.util.Date;

import com.som.home.Constants.ParkingSpotType;
import com.som.home.Constants.ParkingTicketStatus;

public class ParkingTicket {

	String id;
	Date startTime;
	ParkingSpotType spotType;
	ParkingTicketStatus status;
	String vehicleRegistrationNumber;
	Date endTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public ParkingSpotType getSpotType() {
		return spotType;
	}

	public void setSpotType(ParkingSpotType spotType) {
		this.spotType = spotType;
	}

	public ParkingTicketStatus getStatus() {
		return status;
	}

	public void setStatus(ParkingTicketStatus status) {
		this.status = status;
	}

	public String getVehicleRegistrationNumber() {
		return vehicleRegistrationNumber;
	}

	public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
