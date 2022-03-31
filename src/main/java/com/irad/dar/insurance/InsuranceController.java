package com.irad.dar.insurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irad.dar.general.General;
import com.irad.dar.jwt.CaptchaController;
import com.irad.dar.master.MasterEntity;
import com.irad.dar.vehicle.VehicleEntity;

@RestController
public class InsuranceController {
	

	
	
	
	@Autowired 
	private ObjectMapper objectMapper;
	@Autowired
	CaptchaController captchaController;
	
	@Autowired
	InsuranceService insuranceService;
	
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/loadInsuranceDetails")
	public JSONObject getInsuranceDetails(@RequestBody MasterEntity masterEntity)throws Exception {
	List<InsuranceEntity> out = null;
	List<Map<String,Object>> resObject = new ArrayList<Map<String,Object>>();

	JSONObject temp = new JSONObject();
	
	if(masterEntity.getMode().equals("loadinsurance")) {
		 out =insuranceService.getinsuranceDetails();
		temp.put("data", out);
	}
	return temp; 
	}
	//insuranceforward
	@PostMapping(value = "/InsuranceForward")
	public JSONObject insuranceForward(@RequestBody Insurance insurance)throws Exception {
		InsuranceRegisterEntity insuranceRegisterEntity= new InsuranceRegisterEntity();
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
		
		System.out.println(reqOfficer);
		insuranceRegisterEntity.setAccidentId(insurance.getAccidentId());
		insuranceRegisterEntity.setStatus(Integer.parseInt(insurance.getStatus()));
		insuranceRegisterEntity.setReqOfficer(reqOfficer);
		insuranceRegisterEntity.setPsId(psId);
		insuranceRegisterEntity.setInsurance_id(insurance.getInsuranceId());
		String result;
		result = insuranceService.saveInsuranceDetails(insuranceRegisterEntity);
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
	@PostMapping(value = "/insuranceCompany")
	public JSONObject insuranceCompanyDetails()throws Exception {
		InsuranceRegisterEntity insuranceRegisterEntity= new InsuranceRegisterEntity();
		JSONObject response = new JSONObject();
		ArrayList<InsuranceCompany> out = insuranceService.getInsuranceCompany();	
		response.put("Data", out);
		System.out.println(out);
		return response;	 
	}
	
	@SuppressWarnings("unchecked")
	//@PostMapping(value = "/addInsurance")
	@RequestMapping(value = "/addInsurance", method = RequestMethod.POST)
	public JSONObject addInsuranceDetails(@RequestBody DarInsurancePojo darInsurancePojo)throws Exception {
		
	  
	   // Date date1=formatter6.parse(sDate1);  
		DarInsuranceEntity darInsuranceEntity= new DarInsuranceEntity();
		darInsuranceEntity.setAccidentId(darInsurancePojo.getAccident_id());
		darInsuranceEntity.setVehicleId(darInsurancePojo.getVehicle_id());
		
		darInsuranceEntity.setDesigOfficerByInsApptDate(darInsurancePojo.getDateof_appt_designated_officer_by_ins());
		darInsuranceEntity.setIntimationReceivedDateTimeInsured(darInsurancePojo.getIntimation_received_date_time_insured());
		darInsuranceEntity.setOfficerResidence(darInsurancePojo.getDesignated_officer_residence());
		darInsuranceEntity.setOfficerName(darInsurancePojo.getDesignated_officer_name());
		darInsuranceEntity.setSurveyorAppointmntDate(darInsurancePojo.getSurveyor_appointment_date());
		darInsuranceEntity.setInvestigatorName(darInsurancePojo.getSurveyor_investigator_name());
		darInsuranceEntity.setInvestigatorResidence(darInsurancePojo.getSurveyor_investigator_residence());
		
		darInsuranceEntity.setSurveyorReportDate(darInsurancePojo.getDateof_surveyor_investigator_report());
		
		darInsuranceEntity.setDesigOfficerReportDate(darInsurancePojo.getDateof_designated_officer_report()); 
		darInsuranceEntity.setFilledWithin30(darInsurancePojo.getForm_filled_within_30());
		darInsuranceEntity.setVehicleMake(darInsurancePojo.getVehicle_make());
		darInsuranceEntity.setVehicleModel(darInsurancePojo.getVehicle_model());
		darInsuranceEntity.setInsPolicyNo(darInsurancePojo.getInsurance_policyno());
		darInsuranceEntity.setInsValidity(darInsurancePojo.getInsurance_validity());
		darInsuranceEntity.setInsuranceDetails(darInsurancePojo.getInsurance_details());
		darInsuranceEntity.setCompNotLiability(darInsurancePojo.getIf_ins_company_not_liability());
		darInsuranceEntity.setNatureOfPolicy(darInsurancePojo.getNature_of_policy());
		darInsuranceEntity.setReceiptDarDate(darInsurancePojo.getDate_of_receipt_dar());
		darInsuranceEntity.setReceiptFarDate(darInsurancePojo.getDate_of_receipt_far());
		darInsuranceEntity.setReceiptIarDate(darInsurancePojo.getDate_of_receipt_iar());
		darInsuranceEntity.setName(darInsurancePojo.getName());
		darInsuranceEntity.setResidence(darInsurancePojo.getResidence());
		
		
		String result;
		JSONObject response = new JSONObject();
		result = insuranceService.insertInsuranceDetails(darInsuranceEntity);
		if(result.equals("0")&& !result.isEmpty()) {
			response.put("ErrorCode", result);
			response.put("Message", "Not Inserted");
		}else if(result.equals("1")&&!result.isEmpty()) {
			response.put("ErrorCode", result);
			response.put("Message", "Inserted Successfully");
		}
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/saveInsuranceDeceased", method = RequestMethod.POST)
	public JSONObject saveInsuranceDeceased(@RequestBody InsuranceDeceasedPojo insuranceDeceasedPojo)throws Exception {
		String result;
		JSONObject response = new JSONObject();
		InsuranceDeceasedEntity insuranceDeceasedEntity = new InsuranceDeceasedEntity();
		//insuranceDeceasedEntity.setInsuranceId(Integer.parseInt(insuranceDeceasedPojo.getId_insurance()));
		insuranceDeceasedEntity.setVehicleId(insuranceDeceasedPojo.getVehicle_id());
		insuranceDeceasedEntity.setAccidentId(insuranceDeceasedPojo.getAccident_id());
		insuranceDeceasedEntity.setPersonId(insuranceDeceasedPojo.getPerson_id());
		insuranceDeceasedEntity.setPersonType(insuranceDeceasedPojo.getPerson_type());
		insuranceDeceasedEntity.setDeathIncome(insuranceDeceasedPojo.getDeath_income());
		insuranceDeceasedEntity.setDeathFutureProspects(insuranceDeceasedPojo.getDeath_future_prospects());
		insuranceDeceasedEntity.setDeathLessPersonalExpenses(insuranceDeceasedPojo.getDeath_less_personal_expenses());
		insuranceDeceasedEntity.setDeathMonthlyLoss(insuranceDeceasedPojo.getDeath_monthly_loss_depedency());
		insuranceDeceasedEntity.setDeathAnnualLoss(insuranceDeceasedPojo.getDeath_anual_loss_depedency());
		insuranceDeceasedEntity.setDeathMultiplier(insuranceDeceasedPojo.getDeath_mulltiplier());
		insuranceDeceasedEntity.setDeathTotalLoss(insuranceDeceasedPojo.getDeath_total_loss_dependency());
		insuranceDeceasedEntity.setDeathMedicalExpenses(insuranceDeceasedPojo.getDeath_medical_expenses());
		insuranceDeceasedEntity.setDeathLossConsortium(insuranceDeceasedPojo.getDeath_loss_consortium());
		insuranceDeceasedEntity.setDeathLossForLove(insuranceDeceasedPojo.getDeath_loss_for_love_affection());
		insuranceDeceasedEntity.setDeathLossEstate(insuranceDeceasedPojo.getDeath_loss_estate());
		insuranceDeceasedEntity.setDeathLossFuneralExpenses(insuranceDeceasedPojo.getDeath_loss_funeral_expenses());
		insuranceDeceasedEntity.setDeathTotalCompensation(insuranceDeceasedPojo.getDeath_total_compensation());
		insuranceDeceasedEntity.setDeathInterest(insuranceDeceasedPojo.getDeath_interest());
		insuranceDeceasedEntity.setInsuranceId(insuranceDeceasedPojo.getId_insurance());
		
		result = insuranceService.saveInsuranceDeceased(insuranceDeceasedEntity);
		if(result.equals("0")&& !result.isEmpty()) {
			response.put("ErrorCode", result);
			response.put("Message", "Not Inserted");
		}else if(result.equals("1")&&!result.isEmpty()) {
			response.put("ErrorCode", result);
			response.put("Message", "Inserted Successfully");
		}
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/saveInsuranceInjured", method = RequestMethod.POST)
	public JSONObject saveInsuranceInjured(@RequestBody InsuranceInjuredPojo insuranceInjuredPojo)throws Exception {
		String result;
		JSONObject response = new JSONObject();
		InsuranceInjuredEntity insuranceInjuredEntity = new InsuranceInjuredEntity();
		//insuranceInjuredEntity.setInsuranceId(Integer.parseInt(insuranceInjuredPojo.getId_insurance()));
		insuranceInjuredEntity.setInsuranceId(insuranceInjuredPojo.getId_insurance());
		insuranceInjuredEntity.setVehicleId(insuranceInjuredPojo.getVehicle_id());
		insuranceInjuredEntity.setAccidentId(insuranceInjuredPojo.getAccident_id());
		insuranceInjuredEntity.setPersonId(insuranceInjuredPojo.getPerson_id());
		insuranceInjuredEntity.setPersonType(insuranceInjuredPojo.getPerson_type());
		insuranceInjuredEntity.setPermanentDisabilityInj(insuranceInjuredPojo.getInj_permenant_disablity());	
		insuranceInjuredEntity.setPermanantDisabilityDetails(insuranceInjuredPojo.getInj_permenant_disablity_details());
		insuranceInjuredEntity.setLossOfEarningInj(insuranceInjuredPojo.getInj_loss_erning_capacity());
		
		insuranceInjuredEntity.setIncomeInj(insuranceInjuredPojo.getInj_income());
		insuranceInjuredEntity.setTypeOfinjuryInj(insuranceInjuredPojo.getInj_typeofinjury());
		insuranceInjuredEntity.setNatureOfInjuryInj(insuranceInjuredPojo.getInj_natureofinjury());
		
		insuranceInjuredEntity.setInj_medical_treatment(insuranceInjuredPojo.getInj_medical_treatment());
		insuranceInjuredEntity.setTreatmentInj(insuranceInjuredPojo.getInj_treatment());
		insuranceInjuredEntity.setConvenanceInj(insuranceInjuredPojo.getInj_convenance());
		insuranceInjuredEntity.setSpecialDietInj(insuranceInjuredPojo.getInj_special_diet());
		insuranceInjuredEntity.setCostOfNursingInj(insuranceInjuredPojo.getInj_cost_nursing_attendant());
		insuranceInjuredEntity.setLossIncomeInj(insuranceInjuredPojo.getInj_loss_income());	
		insuranceInjuredEntity.setCostOfArtificialInj(insuranceInjuredPojo.getInj_cost_artificial_limp());
		insuranceInjuredEntity.setAnyOtherLossInj(insuranceInjuredPojo.getInj_any_other_loss());
		insuranceInjuredEntity.setMentalShockInj(insuranceInjuredPojo.getInj_com_mental_phy_shock());
		insuranceInjuredEntity.setPainSufferingInj(insuranceInjuredPojo.getInj_pain_suffering());
		insuranceInjuredEntity.setLossAmenitiesInj(insuranceInjuredPojo.getInj_loss_amenities());
		insuranceInjuredEntity.setDisfigurationInj(insuranceInjuredPojo.getInj_disfiguration());
		insuranceInjuredEntity.setLossOfMarriageInj(insuranceInjuredPojo.getInj_loss_of_marriage());
		 
		insuranceInjuredEntity.setLossEarningInj(insuranceInjuredPojo.getInj_loss_ear_inc_har_dis());
		insuranceInjuredEntity.setDisabilityPercentage(insuranceInjuredPojo.getInj_disablity_percentage());
		insuranceInjuredEntity.setAmenitiesLifespan(insuranceInjuredPojo.getInj_amenities_lifespan());
		insuranceInjuredEntity.setPercentageEarningCapacity(insuranceInjuredPojo.getInj_percentage_earning_capacity());
		insuranceInjuredEntity.setLossFutureIncome(insuranceInjuredPojo.getInj_loss_future_income());
		insuranceInjuredEntity.setMultiplier(insuranceInjuredPojo.getMultiplier());
		insuranceInjuredEntity.setTotalCompensationInj(insuranceInjuredPojo.getInj_total_copensation());

		insuranceInjuredEntity.setTotalCompensationRespondent(insuranceInjuredPojo.getInj_total_compensation_respondent());
		insuranceInjuredEntity.setPermanentOrtempDisability(insuranceInjuredPojo.getPermanent_or_temporary_disablity());
		insuranceInjuredEntity.setInjInterest(insuranceInjuredPojo.getInj_intrest());
		
		result = insuranceService.saveInsuranceInjured(insuranceInjuredEntity);
		if(result.equals("0")&& !result.isEmpty()) {
			response.put("ErrorCode", result);
			response.put("Message", "Not Inserted");
		}else if(result.equals("1")&&!result.isEmpty()) {
			response.put("ErrorCode", result);
			response.put("Message", "Inserted Successfully");
		}
		return response;
		
		
	}
	
	
	@RequestMapping(value = "/dar/getInsurance", method = RequestMethod.POST)
	public DarInsuranceEntity getData(@RequestBody InsuranceData insuranceData) throws Exception {
			
		DarInsuranceEntity darInsuranceEntity = insuranceService.getinsurance(insuranceData.getAccid());
	
		return darInsuranceEntity;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

