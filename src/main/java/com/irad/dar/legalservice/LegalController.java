package com.irad.dar.legalservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.irad.dar.jwt.CaptchaController;
import com.irad.dar.master.MasterEntity;

@RestController
public class LegalController {
	@Autowired
	LegalService legalService;
	
	@Autowired
	CaptchaController captchaController;
	
	@PostMapping(value = "/legalServiceList")
	public JSONObject getlegalServiceList(@RequestBody MasterEntity masterEntity)throws Exception {
		ArrayList<LegalServiceEntity> out = null;
		List<Map<String,Object>> resObject = new ArrayList<Map<String,Object>>();
		String value = captchaController.decrypt();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(value);
		JSONObject request = (JSONObject) obj;
		JSONObject request1 = (JSONObject) request.get("data");	
		String stateCode = String.valueOf(request1.get("state_code"));
		JSONObject temp = new JSONObject();
		System.out.println(masterEntity.getMode());
		if(masterEntity.getMode().equals("loadDistrictLegalList")) {
			//if(!masterEntity.getDistrict().equals("null")) {
			System.out.println("working");
			System.out.println(masterEntity.getDistrict());
			String state="29";
			String courtType="3";
			 out =legalService.getDistrictLegalServiceList(masterEntity.getDistrict(),state,masterEntity.getTypeofcourt());
			 System.out.println(out.get(0));
			 if(!out.isEmpty()) {
			   for (int i = 0; i < out.size(); i++) {
				 Map<String,Object> mm = new HashMap<>();
				 mm.put("id", out.get(i).getId());
				 mm.put("name", out.get(i).getNameoflegalservice());
				 System.out.println("working------"+out.get(i).getNameoflegalservice());
				 resObject.add(mm);
		       }
			 } else {
				 temp.put("Message", "No Legal Service Found");
			 }
			temp.put("legalServiceList", resObject);
			
		}else if(masterEntity.getMode().equals("loadTalukLegalList")) {
			String state="29";
			out =legalService.getTalukLegalServiceList(masterEntity.getDistrict(),masterEntity.getTaluk(),masterEntity.getTypeofcourt());
			 System.out.println(out.get(0));
			 if(!out.isEmpty()) {
				 for (int i = 0; i < out.size(); i++) {
					 Map<String,Object> mm = new HashMap<>();
					 mm.put("id", out.get(i).getId());
					 mm.put("name", out.get(i).getNameoflegalservice());
					 System.out.println("working------"+out.get(i).getNameoflegalservice());
					 resObject.add(mm);
			  } 
			 } else {
				 temp.put("Message", "No Courts Found");
			 }
			 temp.put("legalServiceList", resObject);
			 
		}
		return temp;
	}
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/darLegalForward")
	public JSONObject insertLegalServiceList(@RequestBody Legal legal)throws Exception {
		LegalDarRequestEntity legalDarRequestEntity= new LegalDarRequestEntity();
		JSONObject response = new JSONObject();
		String value = captchaController.decrypt();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(value);
		JSONObject request = (JSONObject) obj;
		JSONObject request1 = (JSONObject) request.get("data");	
		String stateCode = String.valueOf(request1.get("state_code"));
		String districtCode = String.valueOf(request1.get("district_code"));
		String stationCode = String.valueOf(request1.get("station_code"));
		String psId = stateCode.concat(districtCode).concat(stationCode);
		String reqOfficer = String.valueOf(request1.get("username"));
		
		System.out.println(legal.getAccidentId());
		System.out.println(legal.getLegalId());
		System.out.println(legal.getStatus());
		System.out.println(reqOfficer);
		
		legalDarRequestEntity.setAccidentId(legal.getAccidentId());
		legalDarRequestEntity.setStatus(legal.getStatus());
		legalDarRequestEntity.setReqOfficer(reqOfficer);
		legalDarRequestEntity.setPsId(psId);
		legalDarRequestEntity.setLegal_id(legal.getLegalId());
		String result;
		result = legalService.saveLegalServicedata(legalDarRequestEntity);
		System.out.println(result);
		if(result.equals("0")) {
			response.put("ErrorCode", result);
			response.put("Message", "Already Exists");
		}else if(result.equals("1")) {
			response.put("ErrorCode", result);
			response.put("Message", "Success");
		}
		 
		return response;	
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/darRequestLegal")
	public String darRequestLegal(@RequestBody DarLegalRequest darLegalRequest)throws Exception {
		LegalDarRequestEntity legalDarRequestEntity = new LegalDarRequestEntity();
		String value = captchaController.decrypt();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(value);
		JSONObject request = (JSONObject) obj;
		JSONObject request1 = (JSONObject) request.get("data");	
		String stateCode = String.valueOf(request1.get("state_code"));
		String districtCode = String.valueOf(request1.get("district_code"));
		String stationCode = String.valueOf(request1.get("station_code"));
		String psId = stateCode.concat(districtCode).concat(stationCode);
		String reqOfficer = String.valueOf(request1.get("username"));
		
		legalDarRequestEntity.setAccidentId(darLegalRequest.getAccidentId());
		legalDarRequestEntity.setLegal_id(darLegalRequest.getLegalId());
		legalDarRequestEntity.setStatus(darLegalRequest.getStatus());
		legalDarRequestEntity.setReqOfficer(reqOfficer);
		legalDarRequestEntity.setPsId(psId);
		System.out.println("1");
		String result = null;
			result =legalService.updateDarRequestLegal(legalDarRequestEntity);
		 
		return result;	
	}
}
