package com.irad.dar.pedestrian;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.irad.dar.familydetails.Familydetails;
import com.irad.dar.familydetails.FamilydetailsEntity;
import com.irad.dar.familydetails.FamilydetailsService;
import com.irad.dar.utils.Losses;
import com.irad.dar.utils.LossesEntity;


@RestController
public class PedestrianController {
	@Autowired
	PedestrianService pedestrianService;
	
	@Autowired 
	FamilydetailsService familydetailsService;

	@Autowired
	PedestrianRepo pedestrianRepo;
	
	@RequestMapping(value = "/dar/pedestrian", method = RequestMethod.POST)
	public String saveData(@RequestBody Pedestrian pedestrian) throws Exception {
		System.out.println("Check" + pedestrian.getPedestrian());
		System.out.println("Update" +pedestrian.getPedestrian().get("updateData"));
		int updatecheck=(int) pedestrian.getPedestrian().get("updateData");
		PedestrianEntity pedestrianEntity=new PedestrianEntity();
		String vehicleno=pedestrian.getVehicleno();
		System.out.println("vehicle no "+vehicleno);
		String ped_name=pedestrian.getPedname();
		String accid=(String)pedestrian.getPedestrian().get("accid");
		String patientDisposition=(String)pedestrian.getPedestrian().get("victimdisposition");
		boolean victimOrNot=Boolean.parseBoolean((String) pedestrian.getPedestriandoc().get("victiomornot"));		
		boolean submitCheck=(boolean) pedestrian.getPedestrian().get("submitCheck");
		String maritalStatus=(String)pedestrian.getPedestrian().get("maritalStatus");
		String occupationName=(String)pedestrian.getPedestrian().get("occupationName");
		boolean employedOrnot=(boolean)pedestrian.getPedestrian().get("employedOrnot");
		String nameAddressemployer=(String)pedestrian.getPedestrian().get("nameAddressemployer");
		String income=(String)pedestrian.getPedestrian().get("income");
		boolean assessedToincometax=(boolean)pedestrian.getPedestrian().get("assessedToincometax");
		boolean reimbursementMedicalexpense=(boolean)pedestrian.getPedestrian().get("reimbursementMedicalexpense");
		boolean cashlessTreatment=(boolean)pedestrian.getPedestrian().get("cashlessTreatment");
		String lossToproperty=(String)pedestrian.getPedestrian().get("lossToproperty");
		String valueOfloss=(String)pedestrian.getPedestrian().get("valueOfloss");
		String additionalInfo=(String)pedestrian.getPedestrian().get("additionalInfo");
		String reliefAmount=(String)pedestrian.getPedestrian().get("reliefAmount");
		int intpedestrianrefId=(int)pedestrian.getPedestrian().get("pedestrianrefId");
		String pedestrianrefId=String.valueOf(intpedestrianrefId);
		String victim_remainder_date=(String)pedestrian.getPedestrian().get("victim_remainder_date");
		String soleEarningmember=(String)pedestrian.getPedestrian().get("soleEarningmember");
		String treatmentDetailsofdeceased=(String)pedestrian.getPedestrian().get("treatmentDetailsofdeceased");
		String expenseDetailsofdeceased=(String)pedestrian.getPedestrian().get("expenseDetailsofdeceased");
		String schoolName=(String)pedestrian.getPedestrian().get("schoolName");
		String permanentDisability=(String)pedestrian.getPedestrian().get("permanentDisability");
		String permanentDisabilitydetails=(String)pedestrian.getPedestrian().get("permanentDisabilitydetails");
		String estimateExpenditure=(String)pedestrian.getPedestrian().get("estimateExpenditure");
		String expenditureConveyance=(String)pedestrian.getPedestrian().get("expenditureConveyance");
		String victimType=(String)pedestrian.getPedestrian().get("victimType");
		String fatherName=(String)pedestrian.getPedestrian().get("fatherName");
		String dob=(String)pedestrian.getPedestrian().get("dob");
		if(updatecheck==0) {
			System.out.println("SAVE");
		pedestrianEntity.setAccId(accid);
		pedestrianEntity.setPatientDisposition(patientDisposition);
		pedestrianEntity.setVictimOrNot(victimOrNot);
		pedestrianEntity.setSubmitCheck(submitCheck);
		pedestrianEntity.setMartialStatus(maritalStatus);
		pedestrianEntity.setOccupationName(occupationName);
		pedestrianEntity.setEmployedOrnot(employedOrnot);
		pedestrianEntity.setNameAddressemployer(nameAddressemployer);
		pedestrianEntity.setIncome(income);
		pedestrianEntity.setAssessedToincometax(assessedToincometax);
		pedestrianEntity.setReimbursementMedicalexpense(reimbursementMedicalexpense);
		pedestrianEntity.setCashlessTreatment(cashlessTreatment);
		pedestrianEntity.setLossToproperty(lossToproperty);
		pedestrianEntity.setValueOfloss(valueOfloss);
		pedestrianEntity.setAdditionalInfo(additionalInfo);
		pedestrianEntity.setReliefAmount(reliefAmount);
		pedestrianEntity.setVehNo(vehicleno);
		pedestrianEntity.setPedestrianName(ped_name);
		pedestrianEntity.setSubmitCheck(submitCheck);
		pedestrianEntity.setPedestrianId(pedestrianrefId);
		pedestrianEntity.setVictimRemainderdate(victim_remainder_date);
		pedestrianEntity.setSoleEarningmember(soleEarningmember);
		pedestrianEntity.setTreatmentDetailsofdeceased(treatmentDetailsofdeceased);
		pedestrianEntity.setExpenseDetailsofdeceased(expenseDetailsofdeceased);
		pedestrianEntity.setSchoolName(schoolName);
		pedestrianEntity.setPermanentDisability(permanentDisability);
		pedestrianEntity.setPermanentDisabilitydetails(permanentDisabilitydetails);
		pedestrianEntity.setEstimateExpenditure(estimateExpenditure);
		pedestrianEntity.setExpenditureConveyance(expenditureConveyance);
		pedestrianEntity.setVictimType(victimType);
		pedestrianEntity.setFatherName(fatherName);
		pedestrianEntity.setDob(dob);
		}else if(updatecheck==1) {
			System.out.println("UPDATE");
		    pedestrianEntity=pedestrianRepo.findByPedestrianId(pedestrianrefId);
		    pedestrianEntity.setAccId(accid);
			pedestrianEntity.setPatientDisposition(patientDisposition);
			pedestrianEntity.setVictimOrNot(victimOrNot);
			pedestrianEntity.setSubmitCheck(submitCheck);
			pedestrianEntity.setMartialStatus(maritalStatus);
			pedestrianEntity.setOccupationName(occupationName);
			pedestrianEntity.setEmployedOrnot(employedOrnot);
			pedestrianEntity.setNameAddressemployer(nameAddressemployer);
			pedestrianEntity.setIncome(income);
			pedestrianEntity.setAssessedToincometax(assessedToincometax);
			pedestrianEntity.setReimbursementMedicalexpense(reimbursementMedicalexpense);
			pedestrianEntity.setCashlessTreatment(cashlessTreatment);
			pedestrianEntity.setLossToproperty(lossToproperty);
			pedestrianEntity.setValueOfloss(valueOfloss);
			pedestrianEntity.setAdditionalInfo(additionalInfo);
			pedestrianEntity.setReliefAmount(reliefAmount);
			pedestrianEntity.setVehNo(vehicleno);
			pedestrianEntity.setPedestrianName(ped_name);
			pedestrianEntity.setVictimRemainderdate(victim_remainder_date);
			pedestrianEntity.setSoleEarningmember(soleEarningmember);
			pedestrianEntity.setTreatmentDetailsofdeceased(treatmentDetailsofdeceased);
			pedestrianEntity.setExpenseDetailsofdeceased(expenseDetailsofdeceased);
			pedestrianEntity.setSchoolName(schoolName);
			pedestrianEntity.setPermanentDisability(permanentDisability);
			pedestrianEntity.setPermanentDisabilitydetails(permanentDisabilitydetails);
			pedestrianEntity.setEstimateExpenditure(estimateExpenditure);
			pedestrianEntity.setExpenditureConveyance(expenditureConveyance);
			pedestrianEntity.setVictimType(victimType);
			pedestrianEntity.setFatherName(fatherName);
			pedestrianEntity.setDob(dob);
			pedestrianEntity.setSubmitCheck(submitCheck);
		}
	    String result = pedestrianService.savePedestriandata(pedestrianEntity);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/dar/insertPedestrian", method = RequestMethod.POST)
	public JSONObject insertPedestrian(@RequestBody PedestrianNewEntity pedestrianNewEntity) throws Exception {
		String result;
		JSONObject response = new JSONObject();
		System.out.println("emailid"+pedestrianNewEntity.getEmailid());
		System.out.println("emailid"+pedestrianNewEntity.getMarital_status());
		result = pedestrianService.insertPedestrianDetails(pedestrianNewEntity);
		if(result.equals("0")&& !result.isEmpty()) {
			response.put("ErrorCode", result);
			response.put("Message", "Not Inserted");
		}else if(result.equals("1")&&!result.isEmpty()) {
			response.put("ErrorCode", result);
			response.put("Message", "Inserted Successfully");
		}
		return response;
	}
	
	
	
	
	@RequestMapping(value = "/dar/getpedestrian", method = RequestMethod.POST)
	public PedestrianEntity getPedestrianData(@RequestBody Pedestrian pedestrian) throws Exception {
		//String ref_id=(String) pedestrian.getPedestrian().get("ref_id");
		int intref_id=(int) pedestrian.getPedestrian().get("ref_id");
		String ref_id=String.valueOf(intref_id);
		String acc_id=(String) pedestrian.getPedestrian().get("acc_id");

		System.out.println("Passenger-"+ref_id);
		System.out.println("Passenger-"+acc_id);
		
		PedestrianEntity pedestrianEntity=pedestrianService.getPedestriandata(ref_id);
		return pedestrianEntity;
	
	}
	
	//karthiga
	
		@RequestMapping(value = "/dar/getPedestrianDetails", method = RequestMethod.POST)
		public PedestrianIradEntity getPedestrianDetails(@RequestBody Pedestrian pedestrian) throws Exception {
			String vehicleId=String.valueOf(pedestrian.getVehicleId());
			String accidentId=String.valueOf(pedestrian.getAccidentId());
			System.out.println("Pedestrian accidentId-"+accidentId);
			System.out.println("Pedestrian vehicleId-"+vehicleId);
			PedestrianIradEntity pedestrianIradEntity=pedestrianService.getPedestrianDetails(accidentId,vehicleId);
			
			return pedestrianIradEntity;
		}
		
	
	
	
	
	@RequestMapping(value = "/dar/familydetails", method = RequestMethod.POST)
	public String savingFamilyData(@RequestBody Familydetails familydetails) throws Exception {
		System.out.println("Check" + familydetails);
		
		FamilydetailsEntity familydetailsEntity=new FamilydetailsEntity();
		
		String accid=(String) familydetails.getFamilydetails().get("accid");
		System.out.println("Accid"+accid);
		String user_type=(String)familydetails.getType();
		String ref_id=(String)familydetails.getRef_id();
		
//		Random rnd = new Random();
//	    int number = rnd.nextInt(999999);
//
//	    // this will convert any number sequence into 6 character.
//	    String reference_id= String.format("%06d", number);
		
		String famName=(String)familydetails.getFamilydetails().get("famName");
		String famAge=(String)familydetails.getFamilydetails().get("famAge");
		String famGender=(String)familydetails.getFamilydetails().get("famGender");
		String famRelation=(String)familydetails.getFamilydetails().get("famRelation");
		String famAddress=(String)familydetails.getFamilydetails().get("famAddress");
		String famContact=(String)familydetails.getFamilydetails().get("famContact");
				
		familydetailsEntity.setAccId(accid);
		familydetailsEntity.setPedestrianId(ref_id);
		familydetailsEntity.setUserType(user_type);
		familydetailsEntity.setFamName(famName);
		familydetailsEntity.setFamAge(famAge);
		familydetailsEntity.setFamGender(famGender);
		familydetailsEntity.setFamRelation(famRelation);
		familydetailsEntity.setFamAddress(famAddress);
		familydetailsEntity.setFamContact(famContact);	
		
		
	    String result = familydetailsService.savefamilydetailsdata(familydetailsEntity);
		return result;
	}

	@RequestMapping(value = "/dar/familylosses", method = RequestMethod.POST)
	public String savingLosses(@RequestBody Losses losses) throws Exception {
		System.out.println("Check Loss" + losses);
		String result = null;
		//LossesEntity lossesEntity=new LossesEntity();
		
		System.out.println(losses.getLoss_description().get(0).get("title"));
		//System.out.println("Accid"+accid);
		
				
		
		for(int i=0;i<losses.getLoss_description().size();i++) {
			LossesEntity lossesEntity=new LossesEntity();
			String ref_id=(String)losses.getRef_id();
			String accid=(String) losses.getAccid();
			String whoseloss=losses.getWhoseloss();
			
			lossesEntity.setAccId(accid);
			lossesEntity.setRefId(ref_id);
			lossesEntity.setWhoseLoss(whoseloss);
			

			String losstitle=(String) losses.getLoss_description().get(i).get("title");
			String lossdesc=(String) losses.getLoss_description().get(i).get("desc");
			
			lossesEntity.setLossDescription(lossdesc);
			lossesEntity.setLossTitle(losstitle);
			if(!lossdesc.isEmpty()) {
			    result = pedestrianService.savefamilylossesdata(lossesEntity);
			}
			
		}
	    //String result = pedestrianService.savefamilylossesdata(lossesEntity);
		return result;
	}
}

