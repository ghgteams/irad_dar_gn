package com.irad.dar.vehicle;

import java.util.List;

import com.irad.dar.familydetails.FamilydetailsEntity;
import com.irad.dar.general.GeneralEntity;

public interface VehicleService {
	public String saveVehicledata(VehicleEntity vehicleEntity);
	
	public String saveDriverFamilydata(DriverFamilyEntity driverFamilyEntity);

	public VehicleEntity getVehicledata(String accid);
	
	public List<FamilydetailsEntity> getFamilydata(String accid);


}
