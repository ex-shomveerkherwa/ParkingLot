package com.som.home.datamodel.subtypes.vehicle;

import com.som.home.Constants.VehicleType;
import com.som.home.datamodel.Vehicle;

public class Electric extends Vehicle{

	public Electric(VehicleType type) {
		super(type.ELECTRIC);
	}

}
