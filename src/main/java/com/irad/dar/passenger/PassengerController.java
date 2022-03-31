package com.irad.dar.passenger;

import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.irad.dar.utils.MinorChildrenDetails;
import com.irad.dar.utils.MinorChildrenDetailsEntity;
import com.irad.dar.utils.MinorChildrenDetailsService;

@RestController
public class PassengerController {
	@Autowired
	PassengerService passengerService;
	
	@Autowired
	MinorChildrenDetailsService minorChildrenDetailsService;
	
	@Autowired
	PassengerRepo passengerRepo;
	
	
	
	@RequestMapping(value = "/dar/passenger", method = RequestMethod.POST)
	public String saveData(@RequestBody Passenger passenger) throws Exception {
		System.out.println("Check" + passenger.getPassenger());
		
		System.out.println("Update" + passenger.getPassenger().get("updateData"));
		
		int updatecheck=(int) passenger.getPassenger().get("updateData");
		int intpassengerrefId=(int)passenger.getPassenger().get("passengerrefId");
		String passengerrefId=String.valueOf(intpassengerrefId);
		
		String vehicleno=passenger.getVehicleno();
		String pass_name=passenger.getPassname();
		String accid=(String)passenger.getPassenger().get("accid");
		String patientDisposition=(String)passenger.getPassenger().get("victimdisposition");
		boolean victimOrNot=Boolean.parseBoolean((String) passenger.getPedestriandoc().get("victimornot"));
		boolean submitCheck=(boolean) passenger.getPassenger().get("submitCheck");
		String maritalStatus=(String)passenger.getPassenger().get("maritalStatus");
		String occupationName=(String)passenger.getPassenger().get("occupationName");
		boolean employedOrnot=(boolean)passenger.getPassenger().get("employedOrnot");
		String nameAddressemployer=(String)passenger.getPassenger().get("nameAddressemployer");
		String income=(String)passenger.getPassenger().get("income");
		boolean assessedToincometax=(boolean)passenger.getPassenger().get("assessedToincometax");
		boolean reimbursementMedicalexpense=(boolean)passenger.getPassenger().get("reimbursementMedicalexpense");
		boolean cashlessTreatment=(boolean)passenger.getPassenger().get("cashlessTreatment");
		String lossToproperty=(String)passenger.getPassenger().get("lossToproperty");
		String valueOfloss=(String)passenger.getPassenger().get("valueOfloss");
		String additionalInfo=(String)passenger.getPassenger().get("additionalInfo");
		String reliefAmount=(String)passenger.getPassenger().get("reliefAmount");
		
		///////////
		String victim_remainder_date=(String)passenger.getPassenger().get("victim_remainder_date");
		String soleEarningmember=(String)passenger.getPassenger().get("soleEarningmember");
		String treatmentDetailsofdeceased=(String)passenger.getPassenger().get("treatmentDetailsofdeceased");
		String expenseDetailsofdeceased=(String)passenger.getPassenger().get("expenseDetailsofdeceased");
		String schoolName=(String)passenger.getPassenger().get("schoolName");
		String permanentDisability=(String)passenger.getPassenger().get("permanentDisability");
		String permanentDisabilitydetails=(String)passenger.getPassenger().get("permanentDisabilitydetails");
		String estimateExpenditure=(String)passenger.getPassenger().get("estimateExpenditure");
		String expenditureConveyance=(String)passenger.getPassenger().get("expenditureConveyance");
		String victimType=(String)passenger.getPassenger().get("victimType");
		String fatherName=(String)passenger.getPassenger().get("fatherName");
		String dob=(String)passenger.getPassenger().get("dob");
		String hospitalization = (String) passenger.getPassenger().get("period_hospitlization");
		String medicalTreatment = (String) passenger.getPassenger().get("treatment_details");
		
		PassengerEntity passengerEntity=new PassengerEntity();

		if(updatecheck==0) {
			System.out.println("SAVE");

				
		passengerEntity.setAccId(accid);
		passengerEntity.setPatientDisposition(patientDisposition);
		passengerEntity.setVictimOrNot(victimOrNot);
		passengerEntity.setSubmitCheck(submitCheck);
		passengerEntity.setMaritalStatus(maritalStatus);
		passengerEntity.setOccupationName(occupationName);
		passengerEntity.setEmployedOrnot(employedOrnot);
		passengerEntity.setNameAddressemployer(nameAddressemployer);
		passengerEntity.setIncome(income);
		passengerEntity.setAssessedToincometax(assessedToincometax);
		passengerEntity.setReimbursementMedicalexpense(reimbursementMedicalexpense);
		passengerEntity.setCashlessTreatment(cashlessTreatment);
		passengerEntity.setLossToproperty(lossToproperty);
		passengerEntity.setValueOfloss(valueOfloss);
		passengerEntity.setAdditionalInfo(additionalInfo);
		passengerEntity.setReliefAmount(reliefAmount);
		passengerEntity.setVehNo(vehicleno);
		passengerEntity.setPassengerName(pass_name);
		passengerEntity.setPassengerId(passengerrefId);
		
		passengerEntity.setVictimRemainderdate(victim_remainder_date);
		passengerEntity.setSoleEarningmember(soleEarningmember);
		passengerEntity.setTreatmentDetailsofdeceased(treatmentDetailsofdeceased);
		passengerEntity.setExpenseDetailsofdeceased(expenseDetailsofdeceased);
		passengerEntity.setSchoolName(schoolName);
		passengerEntity.setPermanentDisability(permanentDisability);
		passengerEntity.setPermanentDisabilitydetails(permanentDisabilitydetails);
		passengerEntity.setEstimateExpenditure(estimateExpenditure);
		passengerEntity.setExpenditureConveyance(expenditureConveyance);

		passengerEntity.setVictimType(victimType);
		passengerEntity.setFatherName(fatherName);
		passengerEntity.setDob(dob);
		passengerEntity.setPeriodHospitlization(hospitalization);
		passengerEntity.setTreatmentDetails(medicalTreatment);
		
		}
		else if(updatecheck==1) {
			System.out.println("UPDATE");
		    passengerEntity=passengerRepo.findByPassengerId(passengerrefId);
		    passengerEntity.setAccId(accid);
		    passengerEntity.setPatientDisposition(patientDisposition);
		    passengerEntity.setVictimOrNot(victimOrNot);
		    passengerEntity.setSubmitCheck(submitCheck);
		    passengerEntity.setMaritalStatus(maritalStatus);
		    passengerEntity.setOccupationName(occupationName);
		    passengerEntity.setEmployedOrnot(employedOrnot);
		    passengerEntity.setNameAddressemployer(nameAddressemployer);
		    passengerEntity.setIncome(income);
		    passengerEntity.setAssessedToincometax(assessedToincometax);
		    passengerEntity.setReimbursementMedicalexpense(reimbursementMedicalexpense);
		    passengerEntity.setCashlessTreatment(cashlessTreatment);
		    passengerEntity.setLossToproperty(lossToproperty);
		    passengerEntity.setValueOfloss(valueOfloss);
		    passengerEntity.setAdditionalInfo(additionalInfo);
		    passengerEntity.setReliefAmount(reliefAmount);
		    passengerEntity.setVehNo(vehicleno);
		    passengerEntity.setPassengerName(pass_name);
		    
		    passengerEntity.setVictimRemainderdate(victim_remainder_date);
			passengerEntity.setSoleEarningmember(soleEarningmember);
			passengerEntity.setTreatmentDetailsofdeceased(treatmentDetailsofdeceased);
			passengerEntity.setExpenseDetailsofdeceased(expenseDetailsofdeceased);
			passengerEntity.setSchoolName(schoolName);
			passengerEntity.setPermanentDisability(permanentDisability);
			passengerEntity.setPermanentDisabilitydetails(permanentDisabilitydetails);
			passengerEntity.setEstimateExpenditure(estimateExpenditure);
			passengerEntity.setExpenditureConveyance(expenditureConveyance);

			passengerEntity.setVictimType(victimType);
			passengerEntity.setFatherName(fatherName);
			passengerEntity.setDob(dob);
			passengerEntity.setPeriodHospitlization(hospitalization);
			passengerEntity.setTreatmentDetails(medicalTreatment);

		}
	    String result = passengerService.savePassengerdata(passengerEntity);

		return result;
	}
	
	@RequestMapping(value = "/dar/getpassenger", method = RequestMethod.POST)
	public PassengerEntity getPassengerData(@RequestBody Passenger passenger) throws Exception {
		int intref_id=(int) passenger.getPassenger().get("ref_id");
		String ref_id=String.valueOf(intref_id);
//		String ref_id=(String) passenger.getPassenger().get("ref_id");
		String acc_id=(String) passenger.getPassenger().get("acc_id");

		System.out.println("Passenger-"+ref_id);
		System.out.println("Passenger-"+acc_id);


		PassengerEntity passengerEntity=passengerService.getPassengerdata(ref_id);
				
		return passengerEntity;
	
	}
	
	@RequestMapping(value = "/dar/getminorchildren", method = RequestMethod.POST)
	public List<MinorChildrenDetailsEntity> getMinorChildrendata(@RequestBody MinorChildrenDetails minorChildrenDetails) throws Exception {
		String victimid=(String) minorChildrenDetails.getVictimid();
		String accid=(String) minorChildrenDetails.getAccid();

		System.out.println("victimid-"+victimid);
		System.out.println("acc_id-"+accid);


		List<MinorChildrenDetailsEntity> minorChildrenDetailsEntity=minorChildrenDetailsService.getMinorChildrendata(victimid);
		if(minorChildrenDetailsEntity.size()!=0) {
			
		}
		
		return minorChildrenDetailsEntity;
	
	}
	
	

	@RequestMapping(value = "/dar/minorchild", method = RequestMethod.POST)
	public String savingMinorchilddetails(@RequestBody MinorChildrenDetails minorChildrenDetails) throws Exception {
		System.out.println("Check minorChildrenDetails" + minorChildrenDetails);
		String result = null;
		
		
		MinorChildrenDetailsEntity minorChildrenDetailsEntity=new MinorChildrenDetailsEntity();
		
		minorChildrenDetailsEntity.setAccId(minorChildrenDetails.getAccid());
		minorChildrenDetailsEntity.setVictimId(minorChildrenDetails.getVictimid());
		minorChildrenDetailsEntity.setWhoseChild(minorChildrenDetails.getWhoseChild());
		
		String name=(String) minorChildrenDetails.getMinorchilddetails().get("name");
		String age=(String) minorChildrenDetails.getMinorchilddetails().get("age");
		String sex=(String) minorChildrenDetails.getMinorchilddetails().get("sex");
		String caste=(String) minorChildrenDetails.getMinorchilddetails().get("caste");
		String father_name=(String) minorChildrenDetails.getMinorchilddetails().get("father_name");
		String mother_name=(String) minorChildrenDetails.getMinorchilddetails().get("mother_name");
		String guardian_name=(String) minorChildrenDetails.getMinorchilddetails().get("guardian_name");
		String family_income=(String) minorChildrenDetails.getMinorchilddetails().get("family_income");
		String permanent_address=(String) minorChildrenDetails.getMinorchilddetails().get("permanent_address");
		String present_address=(String) minorChildrenDetails.getMinorchilddetails().get("present_address");
		String contact_no=(String) minorChildrenDetails.getMinorchilddetails().get("contact_no");
		String child_disabled=(String) minorChildrenDetails.getMinorchilddetails().get("child_disabled");
		String child_disabled_details=(String) minorChildrenDetails.getMinorchilddetails().get("child_disabled_details");

		
		String economic_condition=(String) minorChildrenDetails.getMinorchilddetails().get("economic_condition");
		String level_of_education=(String) minorChildrenDetails.getMinorchilddetails().get("level_of_education");
		String ews_quota=(String) minorChildrenDetails.getMinorchilddetails().get("ews_quota");
		String going_to_school_or_not=(String) minorChildrenDetails.getMinorchilddetails().get("going_to_school_or_not");
		String school_region=(String) minorChildrenDetails.getMinorchilddetails().get("school_region");
		String school_syllabus=(String) minorChildrenDetails.getMinorchilddetails().get("school_syllabus");
		String private_management=(String) minorChildrenDetails.getMinorchilddetails().get("private_management");
		String monthly_school_fee=(String) minorChildrenDetails.getMinorchilddetails().get("monthly_school_fee");		
		String annual_school_fee=(String) minorChildrenDetails.getMinorchilddetails().get("annual_school_fee");
		String pvt_tution_fee=(String) minorChildrenDetails.getMinorchilddetails().get("pvt_tution_fee");
		String other_fee=(String) minorChildrenDetails.getMinorchilddetails().get("other_fee");
		String type_of_skill_development=(String) minorChildrenDetails.getMinorchilddetails().get("type_of_skill_development");
		String cost_of_skill_development=(String) minorChildrenDetails.getMinorchilddetails().get("cost_of_skill_development");
		String any_injury=(String) minorChildrenDetails.getMinorchilddetails().get("any_injury");
		String injury_details=(String) minorChildrenDetails.getMinorchilddetails().get("injury_details");
		String loss_of_body_part=(String) minorChildrenDetails.getMinorchilddetails().get("loss_of_body_part");		
		String psychological_counselling_required=(String) minorChildrenDetails.getMinorchilddetails().get("psychological_counselling_required");
		String cost_immediate_treatment=(String) minorChildrenDetails.getMinorchilddetails().get("cost_immediate_treatment");
		String cost_longterm_treatment=(String) minorChildrenDetails.getMinorchilddetails().get("cost_longterm_treatment");
		String diet_nutrition_expenses=(String) minorChildrenDetails.getMinorchilddetails().get("diet_nutrition_expenses");
		
		minorChildrenDetailsEntity.setName(name);
		minorChildrenDetailsEntity.setAge(age);
		minorChildrenDetailsEntity.setSex(sex);
		minorChildrenDetailsEntity.setCaste(caste);
		minorChildrenDetailsEntity.setFatherName(father_name);
		minorChildrenDetailsEntity.setMotherName(mother_name);
		minorChildrenDetailsEntity.setGuardianName(guardian_name);
		minorChildrenDetailsEntity.setFamilyIncome(family_income);
		minorChildrenDetailsEntity.setPermanentAddress(permanent_address);
		minorChildrenDetailsEntity.setPresentAddress(present_address);
		minorChildrenDetailsEntity.setContactNo(contact_no);
		minorChildrenDetailsEntity.setChildDisabled(child_disabled);
		minorChildrenDetailsEntity.setChildDisableddetails(child_disabled_details);
		minorChildrenDetailsEntity.setEconomicCondition(economic_condition);
		minorChildrenDetailsEntity.setLevelOfeducation(level_of_education);
		minorChildrenDetailsEntity.setEwsQuota(ews_quota);
		minorChildrenDetailsEntity.setGoingToschoolornot(going_to_school_or_not);
		minorChildrenDetailsEntity.setSchoolRegion(school_region);
		minorChildrenDetailsEntity.setSchoolSyllabus(school_syllabus);
		minorChildrenDetailsEntity.setPrivateManagement(private_management);
		minorChildrenDetailsEntity.setMonthlySchoolfee(monthly_school_fee);
		minorChildrenDetailsEntity.setAnnualSchoolfee(annual_school_fee);
		minorChildrenDetailsEntity.setPvtTutionfee(pvt_tution_fee);
		minorChildrenDetailsEntity.setOtherFee(other_fee);
		minorChildrenDetailsEntity.setTypeOfskilldevelopment(type_of_skill_development);
		minorChildrenDetailsEntity.setCostOfskilldevelopment(cost_of_skill_development);
		minorChildrenDetailsEntity.setAnyInjury(any_injury);
		minorChildrenDetailsEntity.setInjuryDetails(injury_details);
		minorChildrenDetailsEntity.setLossOfbodypart(loss_of_body_part);
		minorChildrenDetailsEntity.setPsychologicalCounsellingrequired(psychological_counselling_required);
		minorChildrenDetailsEntity.setCostImmediatetreatment(cost_immediate_treatment);
		minorChildrenDetailsEntity.setCostLongtermtreatment(cost_longterm_treatment);
		minorChildrenDetailsEntity.setDietNutritionexpenses(diet_nutrition_expenses);		
		result=minorChildrenDetailsService.saveMinorchilddata(minorChildrenDetailsEntity);	
	    //String result = pedestrianService.savefamilylossesdata(lossesEntity);
		return result;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/dar/insertPassenger", method = RequestMethod.POST)
	public JSONObject insertPassenger(@RequestBody PassengerNewEntity passengerNewEntity) throws Exception {
		String result;
		JSONObject response = new JSONObject();
		System.out.println("emailid"+passengerNewEntity.getEmailid());
		System.out.println("income"+passengerNewEntity.getIncome());
		result = passengerService.insertPassengerDetails(passengerNewEntity);
		if(result.equals("0")&& !result.isEmpty()) {
			response.put("ErrorCode", result);
			response.put("Message", "Not Inserted");
		}else if(result.equals("1")&&!result.isEmpty()) {
			response.put("ErrorCode", result);
			response.put("Message", "Inserted Successfully");
		}
		return response;
	}
	
	
}

