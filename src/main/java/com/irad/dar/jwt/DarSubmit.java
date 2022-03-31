package com.irad.dar.jwt;

import org.h2.util.json.JSONString;
import org.json.JSONArray;
import org.json.JSONTokener;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DarSubmit {
	@Autowired
	CaptchaController captchaController;
	
	@SuppressWarnings("unchecked")
	@PostMapping({ "/darsubmit" })
	public JSONObject insertDistrict(@RequestBody DistrictModel districtModel) {
		return null;
		
//		org.json.JSONObject value = captchaController.decrypt();
//		System.out.println("value"+value.replace("\"",""));
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("token", value);
////		if(value.equals("true")) {
////			
////		}
//		//String escape = value.replaceAll("\\", "");
//		
//		
//		String jsonFormattedString = new JSONTokener(value).nextValue().toString();
//		System.out.println("value"+jsonFormattedString);
//		//JSONArray resultArray = new JSONArray(new JSONString(jsonFormattedString));
//		//System.out.println(escape);
//		JSONObject json = new JSONObject();
//		  json.put("code", 200);
//		  json.put("message", "Success");
//		  json.put("subject", jsonObject.get("token").toString());
//		return json;
		}
			
}



