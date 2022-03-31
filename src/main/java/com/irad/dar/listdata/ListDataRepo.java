package com.irad.dar.listdata;

public interface ListDataRepo {
	VehicleRespModel dataResult(String id);

	VehicleRespModel dataAccidentResult(ReqModel reqModel, String reqOfficer);
}
