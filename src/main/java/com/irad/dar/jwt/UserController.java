package com.irad.dar.jwt;
//package com.irad.controller;
//
//import java.util.ArrayList;
//import org.json.simple.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.irad.dto.response.MasterDetailsResponse;
//import com.irad.services.UserService;
//
//@RestController
//@RequestMapping(value = "/user")
//public class UserController {
//	@Autowired
//	UserService service;
//
//	@SuppressWarnings("unchecked")
//	@GetMapping(value = "/master")
//	public JSONObject getUser(String token, String lang,String[] tableArrayName) {
//		String name = "master.mst_";
//		// String[] tableArrayName = {"accident_severity","areatype"};
//		int length = tableArrayName.length;
//		String[] strArray3 = new String[length];
//		ArrayList<JSONObject> userDetail = new ArrayList<JSONObject>();
//		JSONObject resObject1 = new JSONObject();
//		for (int i = 0; i < length; i++) {
//			strArray3[i] = name + tableArrayName[i];
//		}
//		for (int i = 0; i < strArray3.length; i++) {
//			userDetail = service.getUser(strArray3[i], lang);
//			resObject1.put(tableArrayName[i], userDetail);
//		}
//		return resObject1;
//	}
//
////	@RequestMapping(value = "/insertAccidentDetails", method = RequestMethod.POST)
////	public ResponseEntity<?> accidentLists(AccidentDetailsResponse accidentDetailsResponse ) throws Exception {
////		AccidentDetailsResponse accidentDetails = service.insertAccidentDetails(accidentDetailsResponse);
////		return ResponseEntity.ok(accidentDetails);			
////	}
//
////	@PostMapping(value = "/insertPassengerDetails")
////	public ResponseEntity<?> accidentLists(PassengerDetailsRequest passengerDetailsRequest) throws Exception {
////		PassengerDetailsRequest passengerDetailsObject = service.insertPassengerDetails(passengerDetailsRequest);
////		return ResponseEntity.ok(passengerDetailsObject);
////	}
//
//	@PostMapping(value = "/accidentSeverity")
//	public String accidentList(String language) throws Exception {
//		MasterDetailsResponse masterDetailsResponse = service.getMasterDetails(language);
//		return null;
////		try {
////			String lang = "en";
////			List<MstAccidentSeveritySchema> accidentList = mstAccidentSeverityRepository.findAllByIdNotNull(lang);
////			System.out.println("hii");
////			return "done";
////		} catch (Exception e) {
////			e.printStackTrace();
////			throw e;
////		}
//	}
//
//}
