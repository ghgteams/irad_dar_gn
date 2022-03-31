package com.irad.dar.master;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;



public interface UserService {

	/**
	 * 
	 * @param token
	 * @return
	 */
	// UserDetailResponse getUser(String token);

	// PassengerDetailsRequest insertPassengerDetails(PassengerDetailsRequest
	// passengerDetailsRequest);

	MasterDetailsResponse getMasterDetails(String language);

	ArrayList<JSONObject> getUser(String tableName, String lang);

	//void getUser(AccidentDetailsRequest accidentDetailsRequest);

	ArrayList<JSONObject> getAccList(String state, String district, String station, String mode, String type, int dept,
			int offset, int limit);

	List<JSONObject> getAccView(String state, String district, String station, String id, String ln, String mode);

	// AccDetailList getAccList();

	// AccidentDetailsResponse insertAccidentDetails(AccidentDetailsResponse
	// accidentDetailsRe@Override
	// sponse);
}
