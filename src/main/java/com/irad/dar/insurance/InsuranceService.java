package com.irad.dar.insurance;

import java.util.ArrayList;
import java.util.List;


public interface InsuranceService {

	public List<InsuranceEntity> getinsuranceDetails();

	public String saveInsuranceDetails(InsuranceRegisterEntity insuranceRegisterEntity);

	public ArrayList<InsuranceCompany> getInsuranceCompany();

	public String insertInsuranceDetails(DarInsuranceEntity darInsuranceEntity);

	public String saveInsuranceDeceased(InsuranceDeceasedEntity insuranceDeceasedEntity);

	public String saveInsuranceInjured(InsuranceInjuredEntity insuranceInjuredEntity);

	public DarInsuranceEntity getinsurance(String accidentId);


}
