package com.irad.dar.vehicle;


import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.irad.dar.familydetails.FamilydetailsEntity;
import com.irad.dar.general.General;

@RestController
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	VehicleDao vehicleRepo;
	
	
	
	@PostMapping(value = "/dar/vehicle")
	public String saveData(@RequestBody Vehicle vehicle) throws Exception {
		JSONObject response = new JSONObject();
		System.out.println("Check" + vehicle);
		
		System.out.println("Update" + vehicle.getVehicle().get("updateData"));
		
		int updatecheck=(int) vehicle.getVehicle().get("updateData");
		
		VehicleEntity ve=new VehicleEntity();
		
		String accid=(String) vehicle.getVehicle().get("accid");
		String owner_mob_no=(String) vehicle.getVehicle().get("owner_mobile_no");
		String owner_veh_type=(String) vehicle.getVehicle().get("vehusetype");
		boolean owner_report_acc= (boolean) vehicle.getVehicle().get("vehinsuranceinform");
//		boolean owner_report_acc=Boolean.parseBoolean(val);
		String owner_report_dt=(String)vehicle.getVehicle().get("vehinsuranceinformdate");
		String owner_details_pre_ins=(String)vehicle.getVehicle().get("vehinsurancepolicy");
		String owner_ins_claims=(String)vehicle.getVehicle().get("vehclaimsmade");
		String vehicleno=vehicle.getVehicleno();
		boolean victimOrNot=Boolean.parseBoolean((String) vehicle.getVehicle().get("victiomornot"));		
		System.out.println("Vehicle no"+vehicleno);
//		String val2=(String) general.getVehicle().get("owner_veh_gps");
//		boolean owner_veh_gps=Boolean.parseBoolean(val2);
		boolean owner_veh_gps=(boolean)vehicle.getVehicle().get("vehwithgps");
//		String val3=(String) general.getGeneral().get("owner_relevant_details_provided");
//		boolean owner_relevant_details_provided=Boolean.parseBoolean(val3);
		boolean owner_relevant_details_provided=(boolean)vehicle.getVehicle().get("vehwithgpsinformedpolice");
//
//		String val4=(String) vehicle.getVehicle().get("owner_veh_emergencybtn");
//		boolean owner_veh_emergencybtn=Boolean.parseBoolean(val4);
		boolean owner_veh_emergencybtn=(boolean)vehicle.getVehicle().get("vehemergencybtn");

//		
//		String val5=(String) vehicle.getGeneral().get("owner_emergencybtn_works");
//		boolean owner_emergencybtn_works=Boolean.parseBoolean(val5);
		boolean owner_emergencybtn_works=(boolean)vehicle.getVehicle().get("vehemergencybtnworking");
//
//		String val6=(String) vehicle.getVehicle().get("owner_driver_ran_ownerproduce");
//		boolean owner_driver_ran_ownerproduce=Boolean.parseBoolean(val6);
		boolean owner_driver_ran_ownerproduce=(boolean)vehicle.getVehicle().get("ownerproducedriver");

//		
//		String val7=(String) vehicle.getVehicle().get("owner_claimants_settlement");
//		boolean owner_claimants_settlement=Boolean.parseBoolean(val7);
		boolean owner_claimants_settlement=(boolean)vehicle.getVehicle().get("vehamountpaidcompensation");
//
//		String val8=(String) vehicle.getVehicle().get("owner_mact");
//		boolean owner_mact=Boolean.parseBoolean(val8);
		boolean owner_mact=(boolean)vehicle.getVehicle().get("vehmactcase");


		String driver_without_supervision=(String)vehicle.getVehicle().get("llrsupervision");
		String driver_lapsed_learner_lic=(String)vehicle.getVehicle().get("lapsedlicense");
		boolean driver_alcohol_usage=(boolean)vehicle.getVehicle().get("driveralocohol");
		boolean driver_scientific_report=(boolean) vehicle.getVehicle().get("scientificreport");
		boolean driver_mobile_usage=(boolean)vehicle.getVehicle().get("mobileatacc");
		String driver_mobile_no=(String)vehicle.getVehicle().get("drimobile");
		String driver_imei=(String)vehicle.getVehicle().get("drimobileimei");
		String driver_make_model=(String)vehicle.getVehicle().get("drimobilemake");
		boolean driver_involved_inacc=(boolean)vehicle.getVehicle().get("previousacc");
		String driver_firno=(String) vehicle.getVehicle().get("previousaccfir");
		String driver_district=(String)vehicle.getVehicle().get("previousaccdistrict");
		String driver_policestation=(String)vehicle.getVehicle().get("previousaccps");
		String driver_education=(String)vehicle.getVehicle().get("drivereducation");
		String driver_income=(String) vehicle.getVehicle().get("driverincome");
		boolean driver_license_suspended=(boolean)vehicle.getVehicle().get("licensesuspended");
		String driver_victim_disposition=(String)vehicle.getVehicle().get("victimdisposition");
		
		boolean witnesscheck=(boolean)vehicle.getVehicledoc().get("witnesscheck");

//		boolean witnesscheck=Boolean.parseBoolean((String)vehicle.getVehicledoc().get("witnesscheck"));

		String vehicle_driven_by=(String) vehicle.getVehicle().get("vehdrivenby");
		String vehinspectionvehicle=(String) vehicle.getVehicle().get("vehinspectionvehicle");
		String vehinspectionreport=(String) vehicle.getVehicle().get("vehinspectionreport");
		String vehlocationinspection=(String) vehicle.getVehicle().get("vehlocationinspection");
		String vehpainttransfer=(String) vehicle.getVehicle().get("vehpainttransfer");
		String vehcolorpainttransfer=(String) vehicle.getVehicle().get("vehcolorpainttransfer");
		String vehlocationpainttransfer1=(String) vehicle.getVehicle().get("vehlocationpainttransfer1");
		String vehtypescratch=(String) vehicle.getVehicle().get("vehtypescratch");
		String vehlocationpainttransfer2=(String) vehicle.getVehicle().get("vehlocationpainttransfer2");
		String vehcngkit=(String) vehicle.getVehicle().get("vehcngkit");
		String vehchangevehbody=(String) vehicle.getVehicle().get("vehchangevehbody");
		String vehtyrecondition=(String) vehicle.getVehicle().get("vehtyrecondition");
		String vehhorninstalled=(String) vehicle.getVehicle().get("vehhorninstalled");
		String vehbrakelightsfunctional=(String) vehicle.getVehicle().get("vehbrakelightsfunctional");
		String vehfaultynoplate=(String) vehicle.getVehicle().get("vehfaultynoplate");
		String vehfittedairbags=(String) vehicle.getVehicle().get("vehfittedairbags");
		String vehairbagsdeployed=(String) vehicle.getVehicle().get("vehairbagsdeployed");
		String vehairbagreason=(String) vehicle.getVehicle().get("vehairbagreason");
		String vehtintedglass=(String) vehicle.getVehicle().get("vehtintedglass");
		String vehspeedlimiter=(String) vehicle.getVehicle().get("vehspeedlimiter");
		String vehspeedlimiterfunctional=(String) vehicle.getVehicle().get("vehspeedlimiterfunctional");
		String vehrearparkingsensor=(String) vehicle.getVehicle().get("vehrearparkingsensor");
		
		String vehrearparkingsensorworks=(String) vehicle.getVehicle().get("vehrearparkingsensorworks");
		String vehrearparkingsensorreason=(String) vehicle.getVehicle().get("vehrearparkingsensorreason");
		String vehtrackingdevices=(String) vehicle.getVehicle().get("vehtrackingdevices");
		String vehtrackingdevicesworks=(String) vehicle.getVehicle().get("vehtrackingdevicesworks");
		String vehdescriptiondamage=(String) vehicle.getVehicle().get("vehdescriptiondamage");
		String vehsteercond=(String) vehicle.getVehicle().get("vehsteercond");
		String vehwheelcond=(String) vehicle.getVehicle().get("vehwheelcond");
		String vehwipercond=(String) vehicle.getVehicle().get("vehwipercond");
		String vehwindowcond=(String) vehicle.getVehicle().get("vehwindowcond");
		String vehmirrorcond=(String) vehicle.getVehicle().get("vehmirrorcond");
		String vehcondofvehicleextra=(String) vehicle.getVehicle().get("vehcondofvehicleextra");
		
		String bankname=(String) vehicle.getVehicle().get("bankName");
		String accholdername=(String) vehicle.getVehicle().get("accHoldername");
		String bankaddress=(String) vehicle.getVehicle().get("bankAddress");
		String ifsccode=(String) vehicle.getVehicle().get("ifscCode");
		String accnumber=(String) vehicle.getVehicle().get("accNumber");
		
		boolean submitCheck=(boolean) vehicle.getVehicle().get("submitCheck");
		
		String maritalStatus=(String)vehicle.getVehicle().get("drimaritalStatus");
		String occupationName=(String)vehicle.getVehicle().get("drioccupationName");
		boolean employedOrnot=(boolean)vehicle.getVehicle().get("driemployedOrnot");
		String nameAddressemployer=(String)vehicle.getVehicle().get("drinameAddressemployer");
		boolean assessedToincometax=(boolean)vehicle.getVehicle().get("driassessedToincometax");
		boolean reimbursementMedicalexpense=(boolean)vehicle.getVehicle().get("drireimbursementMedicalexpense");
		boolean cashlessTreatment=(boolean)vehicle.getVehicle().get("dricashlessTreatment");
		String lossToproperty=(String)vehicle.getVehicle().get("drilossToproperty");
		String valueOfloss=(String)vehicle.getVehicle().get("drivalueOfloss");
		String additionalInfo=(String)vehicle.getVehicle().get("driadditionalInfo");
		String reliefAmount=(String)vehicle.getVehicle().get("drireliefAmount");
		
		int intrefId=(int) vehicle.getVehicle().get("driverrefId");
		String refId=String.valueOf(intrefId);
		System.out.println("RefID Vehicle"+refId);
		
		String offending_vehicle_spotted=(String)vehicle.getVehicle().get("offending_vehicle_spotted");
		String vehicle_impounded_police=(String)vehicle.getVehicle().get("vehicle_impounded_police");
		String driverlicensetype=(String)vehicle.getVehicle().get("license");

		String driverFathername=(String)vehicle.getVehicle().get("driverfather");
		String ownerFathername=(String)vehicle.getVehicle().get("ownerfather");

		String ownerOccupation=(String)vehicle.getVehicle().get("ownerOccupation");
		String driLicenseauthority=(String)vehicle.getVehicle().get("driLicenseauthority");
		String driLicensevalidity=(String)vehicle.getVehicle().get("driLicensevalidity");
		
//////////////////////////////
		
		String driver_remainder_date=(String)vehicle.getVehicle().get("driver_remainder_date");
		String owner_remainder_date=(String)vehicle.getVehicle().get("owner_remainder_date");
		String victim_remainder_date=(String)vehicle.getVehicle().get("victim_remainder_date");

		boolean soleEarningmember=(boolean)vehicle.getVehicle().get("soleEarningmember");
		String treatmentDetailsofdeceased=(String)vehicle.getVehicle().get("treatmentDetailsofdeceased");

		String expenseDetailsofdeceased=(String)vehicle.getVehicle().get("expenseDetailsofdeceased");
		boolean driInjuredornot=(boolean)vehicle.getVehicle().get("driInjuredornot");
		boolean permitfitnessVerified=(boolean)vehicle.getVehicle().get("permitfitnessVerified");
		String permitfitnessVerifiedreasons=(String)vehicle.getVehicle().get("permitfitnessVerifiedreasons");
		String ownerReportedacctoInsdt=(String)vehicle.getVehicle().get("ownerReportedacctoInsdt");
		String victimType=(String)vehicle.getVehicle().get("victimType");
		String drivername=(String)vehicle.getVehicle().get("drivername");
		String kmdriven=(String)vehicle.getVehicle().get("kmDriven");
		
		String permanentDisabilitydetails=(String)vehicle.getVehicle().get("permanentDisabilitydetails");
		String permanentDisability=(String)vehicle.getVehicle().get("permanentDisability");
		String vehRegNo=(String)vehicle.getVehicle().get("vehRegNo");
		
		System.out.println("updatecheck    "+updatecheck);
		
		if(updatecheck==0) {
			System.out.println("SAVE");
		ve.setVehrefId(refId);
		ve.setAccId(accid);
		ve.setOwnerVehtype(owner_veh_type);
		ve.setOwnerReportacc(owner_report_acc);
		ve.setOwnerReportdt(owner_report_dt);
		ve.setOwnerDetailspreins(owner_details_pre_ins);
		ve.setOwnerInsclaims(owner_ins_claims);
		ve.setOwnerVehgps(owner_veh_gps);
		ve.setOwnerRelevantdetailsprovided(owner_relevant_details_provided);
		ve.setOwnerVehemergencybtn(owner_veh_emergencybtn);
		ve.setOwnerEmergencybtnworks(owner_emergencybtn_works);
		ve.setOwnerDriverranownerproduce(owner_driver_ran_ownerproduce);
		ve.setOwnerClaimantssettlement(owner_claimants_settlement);
		ve.setOwnerMact(owner_mact);	
		
		ve.setOwnermobileno(owner_mob_no);
		ve.setVehicleNo(vehicleno);
		
		ve.setDriverWithoutsupervision(driver_without_supervision);
		ve.setDriverLapsedlearnerlic(driver_lapsed_learner_lic);		
		ve.setDriverAlcoholusage(driver_alcohol_usage);
		ve.setDriverScientificreport(driver_scientific_report);
		ve.setDriverMobileusage(driver_mobile_usage);
		ve.setDriverMobileno(driver_mobile_no);
		ve.setDriverImei(driver_imei);
		ve.setDriverMakemodel(driver_make_model);
		ve.setDriverInvolved_inacc(driver_involved_inacc);
		ve.setDriverFirno(driver_firno);
		ve.setDriverDistrict(driver_district);
		ve.setDriverPolicestation(driver_policestation);
		ve.setDriverEducation(driver_education);
		ve.setDriverIncome(driver_income);
		ve.setDriverLicensesuspended(driver_license_suspended);
		ve.setDriverVictimdisposition(driver_victim_disposition);	
		
		ve.setWitnessCheck(witnesscheck);		
		
		ve.setVehicleDrivenby(vehicle_driven_by);
		ve.setVehInspectionvehicle(vehinspectionvehicle);
		ve.setVehInspectionreport(vehinspectionreport);
		ve.setVehLocationinspection(vehlocationinspection);
		ve.setVehPainttransfer(vehpainttransfer);
		ve.setVehColorpainttransfer(vehcolorpainttransfer);
		ve.setVehLocationpainttransfer1(vehlocationpainttransfer1);
		ve.setVehTypescratch(vehtypescratch);
		ve.setVehLocationpainttransfer2(vehlocationpainttransfer2);
		ve.setVehCngkit(vehcngkit);
		ve.setVehChangevehbody(vehchangevehbody);
		ve.setVehTyrecondition(vehtyrecondition);
		ve.setVehHorninstalled(vehhorninstalled);
		ve.setVehBrakelightsfunctional(vehbrakelightsfunctional);
		ve.setVehFaultynoplate(vehfaultynoplate);
		ve.setVehFittedairbags(vehfittedairbags);
		ve.setVehAirbagsdeployed(vehairbagsdeployed);
		ve.setVehAirbagreason(vehairbagreason);
		ve.setVehTintedglass(vehtintedglass);
		ve.setVehSpeedlimiter(vehspeedlimiter);
		ve.setVehSpeedlimiterfunctional(vehspeedlimiterfunctional);
		ve.setVehRearparkingsensor(vehrearparkingsensor);
		ve.setVehRearparkingsensorworks(vehrearparkingsensorworks);
		ve.setVehrearparkingsensorreason(vehrearparkingsensorreason);
		ve.setVehTrackingdevices(vehtrackingdevices);
		ve.setVehTrackingdevicesworks(vehtrackingdevicesworks);
		ve.setVehDescriptiondamage(vehdescriptiondamage);
		ve.setVehSteercond(vehsteercond);
		ve.setVehWheelcond(vehwheelcond);
		ve.setVehWipercond(vehwipercond);
		ve.setVehWindowcond(vehwindowcond);
		ve.setVehMirrorcond(vehmirrorcond);
		ve.setVehCondofvehicleextra(vehcondofvehicleextra);	
		
		ve.setSubmitCheck(submitCheck);
		
		ve.setBankName(bankname);
		ve.setAccHoldername(accholdername);
		ve.setAccNumber(accnumber);
		ve.setIfscCode(ifsccode);
		ve.setBankAddress(bankaddress);
		
		ve.setDriMaritalstatus(maritalStatus);
		ve.setDriOccupationname(occupationName);		
		ve.setDriEmployedornot(employedOrnot);
		ve.setDriNameaddressemployer(nameAddressemployer);
		ve.setDriAssessedtoincometax(assessedToincometax);
		ve.setDriReimbursementmedicalexpense(reimbursementMedicalexpense);
		ve.setDriCashlesstreatment(cashlessTreatment);
		ve.setDriLosstoproperty(lossToproperty);
		ve.setDriValueofloss(valueOfloss);
		ve.setDriAdditionalinfo(additionalInfo);
		ve.setDriReliefamount(reliefAmount);
		ve.setVictimOrNot(victimOrNot);
		ve.setOffendingVehiclespotted(offending_vehicle_spotted);
		ve.setVehicleImpoundedpolice(vehicle_impounded_police);
		ve.setDriverLicensetype(driverlicensetype);
		ve.setOwnerFathername(ownerFathername);
		ve.setDriverFathername(driverFathername);		
		ve.setOwnerOccupation(ownerOccupation);
		ve.setDriLicenseauthority(driLicenseauthority);
		ve.setDriLicensevalidity(driLicensevalidity);
		
		/////////
		ve.setDriverRemainderdate(driver_remainder_date);
		ve.setOwnerRemainderdate(owner_remainder_date);
		ve.setVictimRemainderdate(victim_remainder_date);
		
		ve.setSoleEarningmember(soleEarningmember);
		ve.setTreatmentDetailsofdeceased(treatmentDetailsofdeceased);
		ve.setExpenseDetailsofdeceased(expenseDetailsofdeceased);
		ve.setDriInjuredornot(driInjuredornot);
		ve.setPermitfitnessVerified(permitfitnessVerified);
		ve.setPermitfitnessVerifiedreasons(permitfitnessVerifiedreasons);
		ve.setOwnerReportedacctoInsdt(ownerReportedacctoInsdt);
		ve.setVictimType(victimType);
		ve.setKmDriven(kmdriven);
		
		ve.setPermanentDisability(permanentDisability);
		ve.setPermanentDisabilitydetails(permanentDisabilitydetails);
		ve.setVehicleRegno(vehRegNo);
		
		}else if(updatecheck==1) {
			System.out.println("UPDATE");
			System.out.println(accid);
		    ve=vehicleRepo.findByAccId(accid);
		    System.out.println("Hello");
		    ve.setVehrefId(refId);
			ve.setOwnerVehtype(owner_veh_type);
			ve.setOwnerReportacc(owner_report_acc);
			ve.setOwnerReportdt(owner_report_dt);
			ve.setOwnerDetailspreins(owner_details_pre_ins);
			ve.setOwnerInsclaims(owner_ins_claims);
			ve.setOwnerVehgps(owner_veh_gps);
			ve.setOwnerRelevantdetailsprovided(owner_relevant_details_provided);
			ve.setOwnerVehemergencybtn(owner_veh_emergencybtn);
			ve.setOwnerEmergencybtnworks(owner_emergencybtn_works);
			ve.setOwnerDriverranownerproduce(owner_driver_ran_ownerproduce);
			ve.setOwnerClaimantssettlement(owner_claimants_settlement);
			ve.setOwnerMact(owner_mact);	
			
			ve.setOwnermobileno(owner_mob_no);
			ve.setVehicleNo(vehicleno);
			
			ve.setDriverWithoutsupervision(driver_without_supervision);
			ve.setDriverLapsedlearnerlic(driver_lapsed_learner_lic);		
			ve.setDriverAlcoholusage(driver_alcohol_usage);
			ve.setDriverScientificreport(driver_scientific_report);
			ve.setDriverMobileusage(driver_mobile_usage);
			ve.setDriverMobileno(driver_mobile_no);
			ve.setDriverImei(driver_imei);
			ve.setDriverMakemodel(driver_make_model);
			ve.setDriverInvolved_inacc(driver_involved_inacc);
			ve.setDriverFirno(driver_firno);
			ve.setDriverDistrict(driver_district);
			ve.setDriverPolicestation(driver_policestation);
			ve.setDriverEducation(driver_education);
			ve.setDriverIncome(driver_income);
			ve.setDriverLicensesuspended(driver_license_suspended);
			ve.setDriverVictimdisposition(driver_victim_disposition);	
			
			ve.setWitnessCheck(witnesscheck);		
			
			ve.setVehicleDrivenby(vehicle_driven_by);
			ve.setVehInspectionvehicle(vehinspectionvehicle);
			ve.setVehInspectionreport(vehinspectionreport);
			ve.setVehLocationinspection(vehlocationinspection);
			ve.setVehPainttransfer(vehpainttransfer);
			ve.setVehColorpainttransfer(vehcolorpainttransfer);
			ve.setVehLocationpainttransfer1(vehlocationpainttransfer1);
			ve.setVehTypescratch(vehtypescratch);
			ve.setVehLocationpainttransfer2(vehlocationpainttransfer2);
			ve.setVehCngkit(vehcngkit);
			ve.setVehChangevehbody(vehchangevehbody);
			ve.setVehTyrecondition(vehtyrecondition);
			ve.setVehHorninstalled(vehhorninstalled);
			ve.setVehBrakelightsfunctional(vehbrakelightsfunctional);
			ve.setVehFaultynoplate(vehfaultynoplate);
			ve.setVehFittedairbags(vehfittedairbags);
			ve.setVehAirbagsdeployed(vehairbagsdeployed);
			ve.setVehAirbagreason(vehairbagreason);
			ve.setVehTintedglass(vehtintedglass);
			ve.setVehSpeedlimiter(vehspeedlimiter);
			ve.setVehSpeedlimiterfunctional(vehspeedlimiterfunctional);
			ve.setVehRearparkingsensor(vehrearparkingsensor);
			ve.setVehRearparkingsensorworks(vehrearparkingsensorworks);
			ve.setVehrearparkingsensorreason(vehrearparkingsensorreason);
			ve.setVehTrackingdevices(vehtrackingdevices);
			ve.setVehTrackingdevicesworks(vehtrackingdevicesworks);
			ve.setVehDescriptiondamage(vehdescriptiondamage);
			ve.setVehSteercond(vehsteercond);
			ve.setVehWheelcond(vehwheelcond);
			ve.setVehWipercond(vehwipercond);
			ve.setVehWindowcond(vehwindowcond);
			ve.setVehMirrorcond(vehmirrorcond);
			ve.setVehCondofvehicleextra(vehcondofvehicleextra);	
			
			ve.setSubmitCheck(submitCheck);
			
			ve.setBankName(bankname);
			ve.setAccHoldername(accholdername);
			ve.setAccNumber(accnumber);
			ve.setIfscCode(ifsccode);
			ve.setBankAddress(bankaddress);
			
			ve.setDriMaritalstatus(maritalStatus);
			ve.setDriOccupationname(occupationName);		
			ve.setDriEmployedornot(employedOrnot);
			ve.setDriNameaddressemployer(nameAddressemployer);
			ve.setDriAssessedtoincometax(assessedToincometax);
			ve.setDriReimbursementmedicalexpense(reimbursementMedicalexpense);
			ve.setDriCashlesstreatment(cashlessTreatment);
			ve.setDriLosstoproperty(lossToproperty);
			ve.setDriValueofloss(valueOfloss);
			ve.setDriAdditionalinfo(additionalInfo);
			ve.setDriReliefamount(reliefAmount);
			ve.setVictimOrNot(victimOrNot);
			ve.setOffendingVehiclespotted(offending_vehicle_spotted);
			ve.setVehicleImpoundedpolice(vehicle_impounded_police);
			ve.setDriverLicensetype(driverlicensetype);
			ve.setOwnerFathername(ownerFathername);
			ve.setDriverFathername(driverFathername);
			ve.setOwnerOccupation(ownerOccupation);
			ve.setDriLicenseauthority(driLicenseauthority);
			ve.setDriLicensevalidity(driLicensevalidity);
			
			ve.setDriverRemainderdate(driver_remainder_date);
			ve.setOwnerRemainderdate(owner_remainder_date);
			ve.setVictimRemainderdate(victim_remainder_date);
			
			ve.setSoleEarningmember(soleEarningmember);
			ve.setTreatmentDetailsofdeceased(treatmentDetailsofdeceased);
			ve.setExpenseDetailsofdeceased(expenseDetailsofdeceased);
			ve.setDriInjuredornot(driInjuredornot);
			ve.setPermitfitnessVerified(permitfitnessVerified);
			ve.setPermitfitnessVerifiedreasons(permitfitnessVerifiedreasons);
			ve.setOwnerReportedacctoInsdt(ownerReportedacctoInsdt);
			ve.setVictimType(victimType);
			ve.setKmDriven(kmdriven);
			ve.setPermanentDisability(permanentDisability);
			ve.setPermanentDisabilitydetails(permanentDisabilitydetails);
			ve.setVehicleRegno(vehRegNo);
		}
		System.out.println("Hello");
		String result = vehicleService.saveVehicledata(ve);
		System.out.println(result.toString());
//		response.put("Message", result.toString());
		return result;
	}
	
	@RequestMapping(value = "/dar/driverfamily", method = RequestMethod.POST)
	public String saveDriverFamily(@RequestBody Vehicle vehicle) throws Exception {
		//System.out.println("Accid RX"+general.getGeneral());
		String accid=(String) vehicle.getVehicle().get("accid");
		String famName=(String) vehicle.getVehicle().get("famName");
		String famRelationship=(String) vehicle.getVehicle().get("famRelationship");
		String famAddress=(String) vehicle.getVehicle().get("famAddress");
		
		DriverFamilyEntity driverFamilyEntity=new DriverFamilyEntity();
		driverFamilyEntity.setAccId(accid);
		driverFamilyEntity.setName(famName);
		driverFamilyEntity.setRelationship(famRelationship);
		driverFamilyEntity.setAddress(famAddress);
		
		String result = vehicleService.saveDriverFamilydata(driverFamilyEntity);
		
		return result;
	
	}
	
	
	@RequestMapping(value = "/dar/getvehicle", method = RequestMethod.POST)
	public VehicleEntity getData(@RequestBody General general) throws Exception {
		//System.out.println("Accid RX"+general.getGeneral());
		String id=(String) general.getGeneral().get("acc_id");
		//String driver_ref_id=(String) general.getGeneral().get("ref_id");
		int intref_id=(int) general.getGeneral().get("ref_id");
		String driver_ref_id=String.valueOf(intref_id);
		
		System.out.println("Driver Ref ID-"+driver_ref_id);

		VehicleEntity vehicleEntity=vehicleService.getVehicledata(driver_ref_id);
				
		//System.out.println(generalEntity.getOfficerName()+generalEntity.getOfficerAddress()+generalEntity.getOfficerNumber());
		return vehicleEntity;
	
	}
	
	@RequestMapping(value = "/dar/getfamily", method = RequestMethod.POST)
	public List<FamilydetailsEntity> getDriverFamily(@RequestBody General general) throws Exception {
		//System.out.println("Accid RX"+general.getGeneral());
		String id=(String) general.getGeneral().get("acc_id");
		String type=(String) general.getGeneral().get("type");

		List<FamilydetailsEntity> driverFamilyEntities=vehicleService.getFamilydata(type);
				
		//System.out.println(generalEntity.getOfficerName()+generalEntity.getOfficerAddress()+generalEntity.getOfficerNumber());
		return driverFamilyEntities;
	
	}

}
