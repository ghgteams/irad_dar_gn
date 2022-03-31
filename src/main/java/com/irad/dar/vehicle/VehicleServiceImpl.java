package com.irad.dar.vehicle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irad.dar.familydetails.FamilyDetailsRepo;
import com.irad.dar.familydetails.FamilydetailsEntity;
import com.irad.dar.general.GeneralEntity;
import com.irad.dar.general.GeneralRepo;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleDao vehicleRepo;


	@Autowired
	DriverFamilyRepo driverFamRepo;

	@Autowired
	FamilyDetailsRepo familydetailsRepo;
	
	@Override
	public String saveVehicledata(VehicleEntity vehicleEntity) {
		
		System.out.println("Hello2");
		System.out.println("generalEntity.getAcc_id"+vehicleEntity.getAccId());
		if(vehicleEntity.getAccId()!=null) {
			vehicleRepo.save(vehicleEntity);
			return "Success";
		}
		return "Failed";
	}

	@Override
	public VehicleEntity getVehicledata(String accid) {
		// TODO Auto-generated method stub
		System.out.println("Accid"+accid);
		VehicleEntity vehicleEntity=vehicleRepo.findByVehrefId(accid);
		//general
		return vehicleEntity;
	}

	@Override
	public String saveDriverFamilydata(DriverFamilyEntity driverFamilyEntity) {
		System.out.println("driverFamilyEntity.getAcc_id"+driverFamilyEntity.getAccId());
		if(driverFamilyEntity.getAccId()!=null) {
			driverFamRepo.save(driverFamilyEntity);
			return "Success";
		}
		return "Failed";
	}

	@Override
	public List<FamilydetailsEntity> getFamilydata(String type) {
		System.out.println("Family Acc type"+type);
		List<FamilydetailsEntity> familydetailsEntities=familydetailsRepo.findByUserType(type);
		//general
		return familydetailsEntities;	
	}

	


}
