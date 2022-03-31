package com.irad.dar.master;

import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private VictimFamilyDetailsService victimFamilyDetailsService;

	@SuppressWarnings("unchecked")
	@PostMapping(value = "/master")
	public JSONObject getUser(@RequestBody MasterEntity masterEntity)throws Exception {
		String name = "master.mst_";
		// String[] tableArrayName = {"accident_severity","areatype"};
		int length = masterEntity.tableArrayName.length;
		String[] strArray3 = new String[length];
		ArrayList<JSONObject> userDetail = new ArrayList<JSONObject>();
		JSONObject resObject1 = new JSONObject();
		for (int i = 0; i < length; i++) {
			strArray3[i] = name + masterEntity.tableArrayName[i];
		}
		for (int i = 0; i < strArray3.length; i++) {
			userDetail = service.getUser(strArray3[i], masterEntity.lang);
			resObject1.put(masterEntity.tableArrayName[i], userDetail);
		}
		return resObject1;
	}
	
	
	
	
    ///////////////////////////////////////////////////////////////////////insert family details///////////////////////////////////////////////////////////////////////
	@PostMapping(value = "/insertVictimFamilyDetails")
	public String insertVictimFamilyDetails(@RequestBody VictimFamilyDetailsEntity victimFamilyDetailsEntity) throws Exception {
		String result;
		System.out.println("skdf");
		System.out.println(victimFamilyDetailsEntity.getAcc_id());
		
		result = victimFamilyDetailsService.saveVictimFamilyDetails(victimFamilyDetailsEntity);
		
		System.out.println(result);
		return result;

	}
	///////////////////////////////////////////////////////////////////////insert child details///////////////////////////////////////////////////////////////////////
	@PostMapping(value = "/insertVictimChildDetails")
	public String insertVictimChildDetails(@RequestBody VictimChildDetailsEntity victimChildDetailsEntity) throws Exception {
		String result;
		System.out.println("skdf");
		System.out.println(victimChildDetailsEntity.getAcc_id());
		
		result = victimFamilyDetailsService.saveVictimChildDetailsEntity(victimChildDetailsEntity);
		
		System.out.println(result);
		return result;

	}

	
	
	
	
//	@RequestMapping(value = "/insertAccidentDetails", method = RequestMethod.POST)
//	public ResponseEntity<?> accidentLists(AccidentDetailsResponse accidentDetailsResponse ) throws Exception {
//		AccidentDetailsResponse accidentDetails = service.insertAccidentDetails(accidentDetailsResponse);
//		return ResponseEntity.ok(accidentDetails);			
//	}
//
//	@PostMapping(value = "/insertPassengerDetails")
//	public ResponseEntity<?> accidentLists(PassengerDetailsRequest passengerDetailsRequest) throws Exception {
//		PassengerDetailsRequest passengerDetailsObject = service.insertPassengerDetails(passengerDetailsRequest);
//		return ResponseEntity.ok(passengerDetailsObject);
//	}

	@PostMapping(value = "/accidentSeverity")
	public String accidentList(String language) throws Exception {
		MasterDetailsResponse masterDetailsResponse = service.getMasterDetails(language);
		return null;
//		try {
//			String lang = "en";
//			List<MstAccidentSeveritySchema> accidentList = mstAccidentSeverityRepository.findAllByIdNotNull(lang);
//			System.out.println("hii");
//			return "done";
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
	}

}
