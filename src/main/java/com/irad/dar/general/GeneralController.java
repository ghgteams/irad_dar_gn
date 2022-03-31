package com.irad.dar.general;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irad.dar.insurance.InsuranceCompany;
import com.irad.dar.jwt.CaptchaController;

//@CrossOrigin(origins = "http://10.163.30.214:8089/irad_dar", maxAge = 3600)
@RestController
public class GeneralController {

		@Autowired
		GeneralService generalService;

		@Autowired
		GeneralRepo generalRepo;
		@Autowired
		CaptchaController captchaController;
		
		@GetMapping(value="/hello")
		public String gethello() throws Exception{
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("hh mm ss");
			String time = dateFormat.format(now);
			File dir = new File(time);
			dir.mkdir();
			return "hello";
			
		}
		

		
		@PostMapping(value = "/dar/general")
		public JSONObject saveData(@RequestBody General general) throws Exception {
			JSONObject response = new JSONObject();
			//String value = captchaController.decrypt(general.getToken());
			String value = captchaController.decrypt();
			System.out.println("In General");
			System.out.println(value);
			if(!value.isEmpty()) {
				System.out.println("Check" + general);
				System.out.println("Update" + general.getGeneral().get("updateData"));
				int updatecheck=(int) general.getGeneral().get("updateData");
				GeneralEntity ge=new GeneralEntity();
				String accid=(String) general.getGeneral().get("accident_id");
				System.out.println("Accid"+accid);
				String officer_name=(String)general.getGeneral().get("investofficername");
				String officer_address=(String)general.getGeneral().get("investofficeraddress");
				String officer_number=(String)general.getGeneral().get("investofficernumber");
				String under_section=(String)general.getGeneral().get("underSection");
				String who_report_acc=(String)general.getGeneral().get("reportaccperson");
				String acc_description=(String)general.getGeneral().get("descriptionacc");
				String lossOfproperty=(String)general.getGeneral().get("lossOfproperty");
				String otherLoss=(String)general.getGeneral().get("otherLoss");
				String cctv_availability_str=(String) general.getGeneral().get("cctv");
				boolean cctv_availability=Boolean.parseBoolean(cctv_availability_str);
				//String dt_siteplan=(String)general.getGeneral().get("dtsiteplan");
				//Date dtSiteplan=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z").parse(dt_siteplan);
				String description_siteplan=(String)general.getGeneral().get("siteplandescription");
				String natureAcc=(String)general.getGeneral().get("natureAcc");
				String reporting_person_name=(String)general.getGeneral().get("reporting_person_name");
				String reporting_person_mobile=(String)general.getGeneral().get("reporting_person_mobile");
				String reporting_person_address=(String)general.getGeneral().get("reporting_person_address");
				String hospitalRemainderdate=(String)general.getGeneral().get("hospitalRemainderdate");
				String regAuthorityremainderdate=(String)general.getGeneral().get("regAuthorityremainderdate");
				String briefDescription=(String)general.getGeneral().get("brief_description_acc");
				boolean witnesscheck=Boolean.parseBoolean((String)general.getGeneraldoc().get("witnesscheck"));
				boolean submitCheck=(boolean) general.getGeneral().get("submitCheck");
				String sitePlandt=(String)general.getGeneral().get("dtsiteplan");
				if(updatecheck==0) {
					System.out.println("SAVE");
				ge.setAccId(accid);
				ge.setOfficerName(officer_name);
				ge.setOfficerNumber(officer_number);
				ge.setOfficerAddress(officer_address);
				ge.setWhoreportAcc(who_report_acc);
				ge.setAccDescription(acc_description);
				ge.setCctvAvailability(cctv_availability);
				ge.setDtSiteplan(sitePlandt);
				ge.setDescriptionSiteplan(description_siteplan);
				ge.setWitnessCheck(witnesscheck);
				ge.setSubmitCheck(submitCheck);
				ge.setUnderSection(under_section);
				ge.setLossOfproperty(lossOfproperty);
				ge.setOtherLoss(otherLoss);
				ge.setNatureAcc(natureAcc);
				ge.setReportingPersonname(reporting_person_name);
				ge.setReportingPersonmobile(reporting_person_mobile);
				ge.setReportingPersonaddress(reporting_person_address);
				ge.setHospitalRemainderdate(hospitalRemainderdate);
				ge.setRegAuthorityremainderdate(regAuthorityremainderdate);
				ge.setBriefDescriptionaccident(briefDescription);
				ge.setDtSiteplan(sitePlandt);
				
				}else if(updatecheck==1) {
					System.out.println("UPDATE");
				    ge=generalRepo.findByAccId(accid);
				    
				    ge.setOfficerName(officer_name);
					ge.setOfficerNumber(officer_number);
					ge.setOfficerAddress(officer_address);
					ge.setWhoreportAcc(who_report_acc);
					ge.setAccDescription(acc_description);
					ge.setCctvAvailability(cctv_availability);
					//ge.setDtSiteplan((java.sql.Date) dtSiteplan);
					//ge.setDtSiteplan((java.sql.Date) new Date());
					ge.setDescriptionSiteplan(description_siteplan);								
					ge.setWitnessCheck(witnesscheck);
					ge.setSubmitCheck(submitCheck);
					ge.setUnderSection(under_section);
					ge.setLossOfproperty(lossOfproperty);
					ge.setOtherLoss(otherLoss);
					ge.setNatureAcc(natureAcc);
					ge.setReportingPersonname(reporting_person_name);
					ge.setReportingPersonmobile(reporting_person_mobile);
					ge.setReportingPersonaddress(reporting_person_address);
					ge.setHospitalRemainderdate(hospitalRemainderdate);
					ge.setRegAuthorityremainderdate(regAuthorityremainderdate);
					ge.setBriefDescriptionaccident(briefDescription);
					ge.setDtSiteplan(sitePlandt);

				}
				
			    String result = generalService.saveGeneraldata(ge);	
			    System.out.println(result);
			    response.put("Message", result.toString());
			   
			} else {
				 response.put("Message", "token is invalid");
				
			}
			return response;
		}
		
		 
		
		@RequestMapping(value = "/dar/getgeneral", method = RequestMethod.POST)
		public GeneralEntity getData(@RequestBody General general) throws Exception {
			System.out.println((String) general.getGeneral().get("acc_id"));
			String id=(String) general.getGeneral().get("acc_id");

			GeneralEntity generalEntity=generalService.getGeneraldata(id);
					
			return generalEntity;
		
		}

		@RequestMapping(value = "/dar/whoreportacc", method = RequestMethod.POST)
		public String getWhoreportacc(@RequestBody General general) throws Exception {
			System.out.println("Tablenames = "+general.getGeneral().get("name"));
			String table_name=(String) general.getGeneral().get("name");
			final String FIND_PROJECTS = "SELECT id, en FROM :table_name";

					
			return null;
		
		}
		
		@RequestMapping(value = "/dar/formSubmission", method = RequestMethod.POST)
		public String formSubmission(@RequestParam String accidentId) throws Exception {
			FormSubmission formSubmission = new FormSubmission();
			JSONObject response = new JSONObject();
			String out=generalService.formSubmission(accidentId);		
			return out;
		
		}
		
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/getvehicleInsuranceDetails", method = RequestMethod.POST)
		public JSONObject vehicleInsuranceDetails(@RequestBody VehicleInsuranceRequest vehicleInsuranceRequest) throws Exception {
			
			List<VehicleDetails> resObject = new ArrayList<VehicleDetails>();
			JSONObject response = new JSONObject();
//			System.out.println(accidentId.get(accidentId));
//			String accId=(String) accidentId.get(accidentId);
//			System.out.println(accId);
			resObject=generalService.getVehicleInsuranceDetails(vehicleInsuranceRequest.getAccidentId());
			response.put("data", resObject);
			response.put("count", resObject.size());
			System.out.println(resObject.size());
			return response;
		
		}
		
		
	


}
