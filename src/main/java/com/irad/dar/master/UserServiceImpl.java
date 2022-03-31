package com.irad.dar.master;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService{
	
	/*
	 * @Autowired UserMapper userMapper;
	 */
	
	@Autowired
	UserRepo userRepo;
	
	
	/*
	 * @Autowired UserValidator userValidator;
	 */


	@Override
	public  ArrayList<JSONObject> getUser(String tableArrayName, String lang) {
		
		//userRepo.getPostDetail(5l);
		//userRepo.getPostUrls(4l);
		ArrayList<JSONObject> dfvd = userRepo.getPostDetail(tableArrayName,lang);
	   
	 
//		UserDetailResponse userDetail = new UserDetailResponse();
//		userDetail.setTime(userRepo.getUser(token));
		return dfvd;
	}

//	@Override
//	public AccidentDetailsResponse insertAccidentDetails(AccidentDetailsResponse accidentDetailsResponse) {
//		userRepo.getAccList();
//		return null;
//	}

//	@Override
//	public AccDetailList getAccList() {
//		// TODO Auto-generated method stub
//		return null;
//	}


//	@Override
//	public PassengerDetailsRequest insertPassengerDetails(PassengerDetailsRequest passengerDetailsRequest  ) {
//		userRepo.insertPassengerDetails(passengerDetailsRequest);
//		PassengerDetailsRequest passengerDetail = new PassengerDetailsRequest();
//
//		return passengerDetail;
//	}

	@Override
	public MasterDetailsResponse getMasterDetails(String language) {
		userRepo.getMasterDetails(language);
		return null;
	}

//	@Override
//	public void getUser(AccidentDetailsRequest accidentDetailsRequest) {
//		userRepo.insertAccidentDetails(accidentDetailsRequest);
//		
//	}
	
	@Override
	public ArrayList<JSONObject> getAccList(String state, String district, String station, String mode, String type,
			int dept, int offset, int limit) {
		ArrayList<JSONObject> acclis = userRepo.getPostDetail(state, district, station, mode, type, dept, offset,
				limit);

		return acclis;
	}

	@Override
	public List<JSONObject> getAccView(String state, String district, String station, String id, String ln,
			String mode) {
		List<JSONObject> acclis = userRepo.getAccViewDetail(state,district,station,id, ln, mode);
		return acclis;
	}

	

	

	
	



}
