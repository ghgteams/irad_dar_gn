package com.irad.dar.general;

import java.util.ArrayList;
import java.util.List;

public interface GeneralService {

	public String saveGeneraldata(GeneralEntity generalEntity);
	
	public GeneralEntity getGeneraldata(String accid);

	public String formSubmission(String accidentId);

	public List<VehicleDetails> getVehicleInsuranceDetails(String accidentId);
}
