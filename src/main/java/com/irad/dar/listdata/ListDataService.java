package com.irad.dar.listdata;

public interface ListDataService {

	public VehicleRespModel getResult(String id);

	public VehicleRespModel getAccidentResult(ReqModel reqModel, String reqOfficer);
}
