package com.irad.dar.listdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListDataServiceImp implements ListDataService {

	@Autowired
	ListDataRepo listDataRepo;
	
	@Override
	public VehicleRespModel getResult(String id) {

		VehicleRespModel getQueryResult = listDataRepo.dataResult(id);

		return getQueryResult;
	}

	@Override
	public VehicleRespModel getAccidentResult(ReqModel reqModel, String reqOfficer) {
		
		VehicleRespModel getAccidentQueryResult = listDataRepo.dataAccidentResult(reqModel,reqOfficer);

		return getAccidentQueryResult;
	}

}
