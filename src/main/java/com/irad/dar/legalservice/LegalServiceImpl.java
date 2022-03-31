package com.irad.dar.legalservice;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class LegalServiceImpl implements LegalService{
	@Autowired
	LegalServiceRepo legalServiceRepo;
	
	@Autowired
	LegalDarRequestRepo legalDarRequestRepo;
	
	@Override
	public ArrayList<LegalServiceEntity> getDistrictLegalServiceList(String district, String state, String typeofcourt) {
		ArrayList<LegalServiceEntity> legalServiceEntity = legalServiceRepo.findByDistrictCode(district, state, typeofcourt);
		return legalServiceEntity;
	}

	@Override
	public ArrayList<LegalServiceEntity> getTalukLegalServiceList(String district, String state, String typeofcourt) {
		ArrayList<LegalServiceEntity> legalServiceEntity = legalServiceRepo.findByDistrictTalukCode(district, state, typeofcourt);
		return legalServiceEntity;
	}

	@Override
	public String saveLegalServicedata(LegalDarRequestEntity legalDarRequestEntity) {
		if(!Objects.isNull(legalDarRequestEntity)) {
			try {
				legalDarRequestRepo.save(legalDarRequestEntity);
				return "1";
			} catch (DataIntegrityViolationException e) {
			    System.out.println("Already exist");
			    return "0";
			}
			
		}
		return "0";
	}

	@Override
	public String updateDarRequestLegal(LegalDarRequestEntity legalDarRequestEntity) {
		System.out.println("2");
		System.out.println(legalDarRequestEntity.getAccidentId());
		LegalDarRequestEntity flag;
		String updateFlag;
		String accidentId=legalDarRequestEntity.getAccidentId();
		String legalId=legalDarRequestEntity.getLegal_id();
		System.out.println(accidentId);
		
		LegalDarRequestEntity insertFlag;
		String insertStatus = null;
		if(!Objects.isNull(legalDarRequestEntity)) {
			System.out.println("3");
			flag=legalDarRequestRepo.findByAccidentId(accidentId);
				System.out.println(flag);
				if(Objects.isNull(flag)) {
					System.out.println("4");
				  insertFlag=legalDarRequestRepo.save(legalDarRequestEntity);
				  System.out.println(insertFlag);
				  if(!Objects.isNull(insertFlag)) {
					  System.out.println("5");
					  insertStatus="Inserted Successfully";
					  return insertStatus;
				  }
				 
				} else {
					System.out.println("6");
					updateFlag=String.valueOf(legalDarRequestRepo.updateDarRequest(accidentId,legalId));
					System.out.println(updateFlag);
					insertStatus="Updated Successfully";
					 return insertStatus;
				}
		}
		return insertStatus;
		
	}

	@Override
	public String insertDarRequestLegal(DarLegalRequest darLegalRequest) {
		return null;
		
		
	}

}
