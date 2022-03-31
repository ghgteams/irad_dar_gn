package com.irad.dar.formsubmission;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.irad.dar.insurance.InsuranceEntity;
import com.irad.dar.master.MasterEntity;

@RestController
public class FormSubmissionController {
//	@SuppressWarnings("unchecked")
//	@PostMapping(value = "/loadInsuranceDetails")
//	public JSONObject getInsuranceDetails(@RequestBody MasterEntity masterEntity)throws Exception {
//	List<InsuranceEntity> out = null;
//	List<Map<String,Object>> resObject = new ArrayList<Map<String,Object>>();
//	JSONObject temp = new JSONObject();
//	
//	if(masterEntity.getMode().equals("loadinsurance")) {
//		 out =insuranceService.getinsuranceDetails();
//		temp.put("data", out);
//	}
//	return temp; 
//	}
}
