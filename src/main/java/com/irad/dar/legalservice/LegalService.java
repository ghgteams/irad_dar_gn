package com.irad.dar.legalservice;

import java.util.ArrayList;


public interface LegalService {

	public ArrayList<LegalServiceEntity> getDistrictLegalServiceList(String district, String state, String typeofcourt);

	public ArrayList<LegalServiceEntity> getTalukLegalServiceList(String district, String state, String typeofcourt);

	public String saveLegalServicedata(LegalDarRequestEntity legalDarRequestEntity);

	public String updateDarRequestLegal(LegalDarRequestEntity legalDarRequestEntity);

	public String insertDarRequestLegal(DarLegalRequest darLegalRequest);

}
