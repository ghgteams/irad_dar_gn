package com.irad.dar.listdata;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irad.dar.jwt.CaptchaController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ListDataController {

	@Autowired
	ListDataService listDataService;
	
	@Autowired
	CaptchaController captchaController;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/dar/getvehicle1")
	public JSONObject getData(String accid) throws Exception {

		VehicleRespModel finalResult = listDataService.getResult(accid);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", finalResult.getListMop());

		System.out.println("------------------><----------------------- " + jsonObject);

		return jsonObject;

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/dar/getaccident")
	public JSONObject getSAccidents(@RequestBody ReqModel reqModel)
			throws Exception {
		String value = captchaController.decrypt();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(value);
		JSONObject request = (JSONObject) obj;
		JSONObject request1 = (JSONObject) request.get("data");	
		String reqOfficer = String.valueOf(request1.get("username"));
		System.out.println(reqOfficer);
		VehicleRespModel finalAccidentResult = listDataService.getAccidentResult(reqModel,reqOfficer);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", finalAccidentResult.getListMop());
		
		System.out.println("------------------><----------------------- " + jsonObject);

		return jsonObject;

	}
}
