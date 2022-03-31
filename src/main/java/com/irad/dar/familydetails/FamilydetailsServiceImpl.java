package com.irad.dar.familydetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilydetailsServiceImpl implements FamilydetailsService {

	@Autowired 
	FamilyDetailsRepo FamilyDetailsRepo;
	
	@Override
	public String savefamilydetailsdata(FamilydetailsEntity familydetailsEntity) {
		// TODO Auto-generated method stub
		System.out.println("generalEntity.getAcc_id"+familydetailsEntity.getAccId());
		if(familydetailsEntity.getAccId()!=null) {
			FamilyDetailsRepo.save(familydetailsEntity);
			return "Success";
		}
		return "Failed";
	}

}
