package com.irad.dar.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GeneralServiceImpl implements GeneralService {

	
	@Autowired
	GeneralRepo generalDao;
	
	@Autowired
	VehicleInsuranceDetailsRepo vehicleInsuranceDetailsRepo;
	
	@Override
	public String saveGeneraldata(GeneralEntity generalEntity) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		System.out.println("generalEntity.getAcc_id"+generalEntity.getAccId());
		if(generalEntity.getAccId()!=null) {
			generalDao.save(generalEntity);
			return "Success";
		}
		return "Failed";
	}

	@Override
	public GeneralEntity getGeneraldata(String accid) {
		// TODO Auto-generated method stub
		System.out.println("Accid"+accid);
		GeneralEntity generalEntity=generalDao.findByAccId(accid);
		//general
		return generalEntity;
	}

	@Override
	public String formSubmission(String accidentId) {
		String formSubmission = generalDao.formSubmission(accidentId);
		return formSubmission;
		
	}

	@Override
	public List<VehicleDetails> getVehicleInsuranceDetails(String accidentId) {
		List<VehicleDetails> vehicleInsuranceDetails = vehicleInsuranceDetailsRepo.getVehicleInsuranceDetails(accidentId);
		
		return vehicleInsuranceDetails;
	}

	
}
