package com.irad.dar.cctns;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.irad.dar.general.General;
import com.irad.dar.general.GeneralEntity;

@RestController
public class CctnsController {
	private static RestTemplate restTemplate = new RestTemplate();
	 private static final String baseURL = "https://eservices.tnpolice.gov.in/irad_tncctns/iradmappingdetails";
	 
	@RequestMapping(value = "/cctns", method = RequestMethod.POST)
	public ResponseEntity<String> getData(@RequestParam String id) throws Exception {
		HttpHeaders headers = new HttpHeaders();
	      
	      // set `content-type` header
	      headers.setContentType(MediaType.APPLICATION_JSON);
	      // set `accept` header
	      headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

	      // request body parameters
	      Map<String, Object> map = new HashMap<>();
	      map.put("iradid", id);
	      
	      // build the request
	      HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

	      // send POST request
	      ResponseEntity<String> response = restTemplate.postForEntity(baseURL, entity, String.class);
	      
	      
	      JSONArray jsonArray = new JSONArray(response.getBody());
	      System.out.println("Return response"+jsonArray.length());
	      
	      Root rootval=new Root();
	      
	      for(int i=0;i<jsonArray.length();i++) {
	    	  org.json.JSONObject fir_reg = jsonArray.getJSONObject(i).getJSONObject("AtTheTime_of_FIRRegistration");
	    	  org.json.JSONObject invest = jsonArray.getJSONObject(i).getJSONObject("AtTheTime_of_Investigation");
	    	  System.out.println("Fir_Reg data "+fir_reg);
	    	  System.out.println("Invest data  "+invest);
	    	 
	    	  
	      }

	   // check response
	      if (response.getStatusCode() == HttpStatus.CREATED) {
	          System.out.println("Request Successful");
	          System.out.println(response.getBody());
	      } else {
	          System.out.println("Request Failed");
	          System.out.println(response.getStatusCode());
	          System.out.println(response.getBody());
	      }
	      
	      //String jsonObject=response.getBody();
	      //JSONObject jsonObj = new JSONObject(jsonObject.toString());
//	      
//	      Root root=new Root();
//	      root.setAtTheTime_of_FIRRegistration(null);
	    		  
		return response;
	
	}
}
