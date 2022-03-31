package com.irad.dar.insurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.irad.dar.court.TalukEntity;

@Service
public class InsuranceServiceImpl implements InsuranceService{
	@Autowired
	InsuranceRepo insuranceRepo;
	
	@Autowired
	InsuranceRegisterRepo InsuranceRegisterRepo;
	
	@Autowired
	InsuranceCompanyRepo insuranceCompanyRepo;
	
	@Autowired
	DarInsuranceRepo darInsuranceRepo;
	
	@Autowired
	InsuranceDeceasedRepo insuranceDeceasedRepo;
	
	@Autowired
	InsuranceInjuredRepo insuranceInjuredRepo;
	
	@Autowired
	InsuranceViewRepo insuranceViewRepo;
	
	@Override
	public List<InsuranceEntity> getinsuranceDetails() {
		List<InsuranceEntity> insuranceEntity = insuranceRepo.findAll();
		return insuranceEntity;
	}

	@Override
	public String saveInsuranceDetails(InsuranceRegisterEntity insuranceRegisterEntity) {
		if(!Objects.isNull(insuranceRegisterEntity)) {
			try {
				InsuranceRegisterRepo.save(insuranceRegisterEntity);
				return "1";
			} catch (DataIntegrityViolationException e) {
			    System.out.println("Already exist");
			    return "0";
			}
			
		}
		return "0";
	}

	@Override
	public ArrayList<InsuranceCompany> getInsuranceCompany() {
		ArrayList<InsuranceCompany> insuranceCompany = insuranceCompanyRepo.getInsuranceCompany();
		return insuranceCompany;
	}

	@Override
	public String insertInsuranceDetails(DarInsuranceEntity darInsuranceEntity) {
		if(!Objects.isNull(darInsuranceEntity)) {
			try {
				darInsuranceRepo.save(darInsuranceEntity);
				return "1";
			} catch (DataIntegrityViolationException e) {
			    System.out.println("Already exist");
			    return "0";
			}
			
		}
		return "0";
	}

	@Override
	public String saveInsuranceDeceased(InsuranceDeceasedEntity insuranceDeceasedEntity) {
		
		if(!Objects.isNull(insuranceDeceasedEntity)) {
			try {
				insuranceDeceasedRepo.save(insuranceDeceasedEntity);
				return "1";
			} catch (DataIntegrityViolationException e) {
			    System.out.println("Already exist");
			    return "0";
			}
			
		}
		return "0";
	}

	@Override
	public String saveInsuranceInjured(InsuranceInjuredEntity insuranceInjuredEntity) {
		if(!Objects.isNull(insuranceInjuredEntity)) {
			try {
				insuranceInjuredRepo.save(insuranceInjuredEntity);
				return "1";
			} catch (DataIntegrityViolationException e) {
			    System.out.println("Already exist");
			    return "0";
			}
			
		}
		return "0";
	}

	@Override
	public DarInsuranceEntity getinsurance(String accidentId) {
		
		return insuranceViewRepo.getInsuranceDetails(accidentId);
	}

}
