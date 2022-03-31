package com.irad.dar.court;


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
import com.irad.dar.master.UserDao;


@RestController
@SuppressWarnings("unchecked")
public class CourtController {
	@Autowired
	CaptchaController captchaController;
	
	@Autowired
	CourtService courtService;
	
	@Autowired
	CourtListDataRepo courtListDataRepo;
	
	@PostMapping(value = "/loaddistrict")
	public JSONObject getUser(@RequestBody MasterEntity masterEntity)throws Exception {
		
		ArrayList<CourtEntity> out = null;
		List<Map<String,Object>> resObject = new ArrayList<Map<String,Object>>();
		String value = captchaController.decrypt();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(value);
		JSONObject request = (JSONObject) obj;
		JSONObject request1 = (JSONObject) request.get("data");	
		String stateCode = String.valueOf(request1.get("state_code"));
		JSONObject temp = new JSONObject();
		
		if(masterEntity.getMode().equals("loaddistrict")) {
			if(!stateCode.equals("null")) {
			 out =courtService.getdistrict(stateCode);
			 for (int i = 0; i < out.size(); i++) {
				 Map<String,Object> mm = new HashMap<>();
				 mm.put("id", out.get(i).getDtcode11());
				 mm.put("name", out.get(i).getDtname());
				 resObject.add(mm);
		    }	
		  }
			temp.put("district", resObject);
			return temp;
		} else if(masterEntity.getMode().equals("loadcourtlist")) {
			
		} else if(masterEntity.getMode().equals("loadtaluk")) {
			
		}
		return temp;
		
	}
	@PostMapping(value = "/loadtaluk")
	public JSONObject gettaluk(@RequestBody MasterEntity masterEntity)throws Exception {
		
		ArrayList<TalukEntity> out = null;
		List<Map<String,Object>> resObject = new ArrayList<Map<String,Object>>();
		String value = captchaController.decrypt();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(value);
		JSONObject request = (JSONObject) obj;
		JSONObject request1 = (JSONObject) request.get("data");	
		String stateCode = String.valueOf(request1.get("state_code"));
		JSONObject temp = new JSONObject();
		System.out.println(masterEntity.getMode());
		if(masterEntity.getMode().equals("loadtaluk_court")) {
			if(!masterEntity.getDistrict().equals("null")) {
			 out =courtService.getTaluk(masterEntity.getDistrict());
			 for (int i = 0; i < out.size(); i++) {
				 Map<String,Object> mm = new HashMap<>();
				 mm.put("id", out.get(i).getEd_tlkcode());
				 mm.put("name", out.get(i).getTalukname());
				 resObject.add(mm);
		    }	
		  }
			temp.put("taluk", resObject);
			return temp;
		} else if(masterEntity.getMode().equals("loadcourtlist")) {
			
		} else if(masterEntity.getMode().equals("loadtaluk")) {
			
		}
		return temp;
		
	}
	@PostMapping(value = "/courtlist")
	public JSONObject getcourtlist(@RequestBody MasterEntity masterEntity)throws Exception {
		
		ArrayList<CourtListEntity> out = null;
		List<Map<String,Object>> resObject = new ArrayList<Map<String,Object>>();
		String value = captchaController.decrypt();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(value);
		JSONObject request = (JSONObject) obj;
		JSONObject request1 = (JSONObject) request.get("data");	
		String stateCode = String.valueOf(request1.get("state_code"));
		JSONObject temp = new JSONObject();
		System.out.println(masterEntity.getMode());
		
//		
//		if(masterEntity.getMode().equals("loadDistrictCourtList")) {
//			//if(!masterEntity.getDistrict().equals("null")) {
//			System.out.println("working");
//			System.out.println(masterEntity.getDistrict());
//			String state="29";
//			String courtType="3";
//			 out =courtService.getCourtList(masterEntity.getDistrict(),state,courtType);
//			 System.out.println(out.get(0));
//			 for (int i = 0; i < out.size(); i++) {
//				 Map<String,Object> mm = new HashMap<>();
//				 mm.put("id", out.get(i).getRev_district());
//				 mm.put("name", out.get(i).getCourtname());
//				 System.out.println("working------"+out.get(i).getCourtname());
//				 resObject.add(mm);
//		   // }	
//		  }
//			temp.put("courtList", resObject);
//			return temp;
//		} 
		
		if(masterEntity.getMode().equals("loadDistrictCourtList")) {
			//if(!masterEntity.getDistrict().equals("null")) {
			System.out.println("working");
			System.out.println(masterEntity.getDistrict());
			String state="29";
			String courtType="3";
			 out =courtService.getDistrictCourtTaluk(masterEntity.getDistrict(),state,masterEntity.getTypeofcourt());
			 System.out.println(out.get(0));
			 if(!out.isEmpty()) {
			   for (int i = 0; i < out.size(); i++) {
				 Map<String,Object> mm = new HashMap<>();
				 mm.put("id", out.get(i).getId());
				 mm.put("name", out.get(i).getCourtname());
				 System.out.println("working------"+out.get(i).getCourtname());
				 resObject.add(mm);
		       }
			 } else {
				 temp.put("Message", "No Courts Found");
			 }
			temp.put("courtList", resObject);
			return temp;
		} else if(masterEntity.getMode().equals("loadSubordinateCourtList")) {
			String state="29";
			out =courtService.getSubordinateCourtTaluk(masterEntity.getDistrict(),masterEntity.getTaluk(),masterEntity.getTypeofcourt());
			 System.out.println(out.get(0));
			 if(!out.isEmpty()) {
				 for (int i = 0; i < out.size(); i++) {
					 Map<String,Object> mm = new HashMap<>();
					 mm.put("id", out.get(i).getId());
					 mm.put("name", out.get(i).getCourtname());
					 System.out.println("working------"+out.get(i).getCourtname());
					 resObject.add(mm);
			  } 
			 } else {
				 temp.put("Message", "No Courts Found");
			 }
			 temp.put("courtList", resObject);
			 
		}
//		if(!resObject.isEmpty()) {
//			temp.put("courtList", resObject);
//			temp.put("Message", "Success");
//		} else {
//			temp.put("Message", "No Courts Found");
//		}
		
		return temp;
		
	}
	@PostMapping(value = "/darforward")
	public JSONObject insertCourtDetails(@RequestBody Claims claims)throws Exception {
		ClaimsEntity claimsEntity= new ClaimsEntity();
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
		System.out.println(claims.getAccidentId());
		System.out.println(claims.getCourtId());
		System.out.println(claims.getStatus());
		System.out.println(reqOfficer);
		claimsEntity.setAccidentId(claims.getAccidentId());
		claimsEntity.setStatus(claims.getStatus());
		claimsEntity.setReqOfficer(reqOfficer);
		claimsEntity.setPsId(psId);
		claimsEntity.setCourtId(claims.getCourtId());
		String result;
		result = courtService.saveCourtdata(claimsEntity);
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
	@PostMapping(value = "/darupdate")
	public JSONObject insertCourtDetail(@RequestBody CourtListPojo courtListPojo)throws Exception {
		//CourtListEntity courtListEntity= new CourtListEntity();
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
		int officeId = Integer.valueOf((String) request1.get("office_id"));
		System.out.println(officeId);
		CourtListData courtListEntity = courtListDataRepo.findById(officeId);
		
		//setCourtname(courtListPojo.getCourtname());
		
		courtListEntity.setCourt_type(courtListPojo.getCourt_type());
		courtListEntity.setAddress(courtListPojo.getAddress());
		courtListEntity.setEmailid(courtListPojo.getEmailid());
		courtListEntity.setLandline(courtListPojo.getLandline());
		courtListEntity.setPincode(courtListPojo.getPincode());
		courtListEntity.setProfile_update_by(courtListPojo.getProfile_update_by());
		courtListEntity.setProfile_update_date(courtListPojo.getProfile_update_date());
		courtListEntity.setProfile_update_flag(courtListPojo.getProfile_update_flag());
		courtListEntity.setRev_district(courtListPojo.getRev_district());
		courtListEntity.setRev_state(courtListPojo.getRev_state());
		courtListEntity.setRev_taluk(courtListPojo.getRev_taluk());
		
		
		String result;
		result = courtService.updateCourtdetails(courtListEntity);
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
	@PostMapping(value = "/loadDistrictCourtUsers")
	public JSONObject loadDistrictCourtUsers(@RequestBody MasterEntity masterEntity)throws Exception {
		String value = captchaController.decrypt();
		ArrayList<UserDao> out = null;
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(value);
		JSONObject request = (JSONObject) obj;
		JSONObject request1 = (JSONObject) request.get("data");	
		String stateCode = String.valueOf(request1.get("state_code"));
		String districtCode = String.valueOf(request1.get("district_code"));
		String stationCode = String.valueOf(request1.get("station_code"));
		String psId = stateCode.concat(districtCode).concat(stationCode);
		String reqOfficer = String.valueOf(request1.get("username"));
		String officeId = String.valueOf(request1.get("office_id"));
		String role = String.valueOf(request1.get("role"));
		System.out.println(masterEntity.getMode());
//		System.out.println(claims.getCourtId());
//		System.out.println(claims.getStatus());
		System.out.println(officeId);
		String result = null;
//		result = courtService.saveCourtdata(claimsEntity);
        if(masterEntity.getMode().equals("loaddistrictcourtusers")) {
		if(role.equals("60")) {
			String roleId="64";
			out = courtService.getDistrictCourtUsers(officeId,roleId);
		}else if(role.equals("61")) {
			String roleId="65";
			out = courtService.getDistrictCourtUsers(officeId,roleId);
		} else if(role.equals("63")) {
			String roleId="66";
			out = courtService.getDistrictCourtUsers(officeId,roleId);
		}
        }
		 System.out.println(out.get(0));

		 JSONObject response = new JSONObject();;
		 response.put("userdatalist", out);
		return response;	
		
	}
	@PostMapping(value = "/loadcourtprofile")
	public JSONObject loadCourtDetails(@RequestBody MasterEntity masterEntity)throws Exception {
		String value = captchaController.decrypt();
		 JSONObject response = new JSONObject();
		ArrayList<CourtListEntity> out = null;
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(value);
		JSONObject request = (JSONObject) obj;
		JSONObject request1 = (JSONObject) request.get("data");	
		String stateCode = String.valueOf(request1.get("state_code"));
		String districtCode = String.valueOf(request1.get("district_code"));
		String stationCode = String.valueOf(request1.get("station_code"));
		String psId = stateCode.concat(districtCode).concat(stationCode);
		String reqOfficer = String.valueOf(request1.get("username"));
		System.out.println("Id       ");
		int officeId = Integer.valueOf((String) request1.get("office_id"));
		String role = String.valueOf(request1.get("role"));
		System.out.println(masterEntity.getMode());

		System.out.println("OfficeId       "+officeId);
		String result = null;
//		result = courtService.saveCourtdata(claimsEntity);
        if(masterEntity.getMode().equals("courtdetails")) {
			out = courtService.getCourtDetails(stateCode,officeId);
			//select *,spatial_layer.dtname(rev_state,rev_district),spatial_layer.stname(rev_state),master.get_courttype(court_type,'en') from court.courtregister where ps_state='29' and id='".$office_id."
			 if(!out.isEmpty()) {
				// for (int i = 0; i < out.size(); i++) {
//					 Map<String,Object> mm = new HashMap<>();
//					 mm.put("id", out.get(1));
//					 mm.put("name", out.get(1));
					 //System.out.println("working------"+out.get(i));
					// resObject.add(mm);
			 // } 		
        }
		 System.out.println(out);
		
		 response.put("userdatalist", out);
			
        }
		return response;
	}
}

