package com.irad.dar.vehicle;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dar_vehicle", schema = "public")
public class VehicleEntity {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;	
	
	@Column(name = "acc_id")
	private String accId;
	@Column(name = "owner_veh_type")
	private String ownerVehtype;
	@Column(name = "owner_report_acc")
	private boolean ownerReportacc;
	@Column(name = "owner_report_dt")
	private String ownerReportdt;
	@Column(name = "owner_details_pre_ins")
	private String ownerDetailspreins;
	@Column(name = "owner_ins_claims")
	private String ownerInsclaims;
	@Column(name = "owner_veh_gps")
	private boolean ownerVehgps;
	@Column(name = "owner_relevant_details_provided")
	private boolean ownerRelevantdetailsprovided;
	@Column(name = "owner_veh_emergencybtn")
	private boolean ownerVehemergencybtn;
	@Column(name = "owner_emergencybtn_works")
	private boolean ownerEmergencybtnworks;
	@Column(name = "owner_driver_ran_ownerproduce")
	private boolean ownerDriverranownerproduce;
	@Column(name = "owner_claimants_settlement")
	private boolean ownerClaimantssettlement;
	@Column(name = "owner_mact")
	private boolean ownerMact;

	@Column(name = "owner_mobile_no")
	private String ownermobileno;

	@Column(name = "driver_without_supervision")
	private String driverWithoutsupervision;
	@Column(name = "driver_lapsed_learner_lic")
	private String driverLapsedlearnerlic;
	@Column(name = "driver_alcohol_usage")
	private boolean driverAlcoholusage;
	@Column(name = "driver_scientific_report")
	private boolean driverScientificreport;
	@Column(name = "driver_mobile_usage")
	private boolean driverMobileusage;
	@Column(name = "driver_mobile_no")
	private String driverMobileno;
	@Column(name = "driver_imei")
	private String driverImei;
	@Column(name = "driver_make_model")
	private String driverMakemodel;
	@Column(name = "driver_involved_inacc")
	private boolean driverInvolved_inacc;
	@Column(name = "driver_firno")
	private String driverFirno;
	@Column(name = "driver_district")
	private String driverDistrict;
	@Column(name = "driver_policestation")
	private String driverPolicestation;
	@Column(name = "driver_education")
	private String driverEducation;
	@Column(name = "driver_income")
	private String driverIncome;
	@Column(name = "driver_license_suspended")
	private boolean driverLicensesuspended;
	@Column(name = "driver_victim_disposition")
	private String driverVictimdisposition;


	@Column(name = "witness_check")
	private boolean witnessCheck;

	@Column(name = "vehicle_driven_by")
	private String vehicleDrivenby;
	@Column(name = "veh_inspection_vehicle")
	private String vehInspectionvehicle;
	@Column(name = "veh_inspection_report")
	private String vehInspectionreport;
	@Column(name = "veh_location_inspection")
	private String vehLocationinspection;
	@Column(name = "veh_paint_transfer")
	private String vehPainttransfer;
	@Column(name = "veh_color_paint_transfer")
	private String vehColorpainttransfer;
	@Column(name = "veh_location_paint_transfer1")
	private String vehLocationpainttransfer1;
	@Column(name = "veh_type_scratch")
	private String vehTypescratch;
	@Column(name = "veh_location_paint_transfer2")
	private String vehLocationpainttransfer2;
	@Column(name = "veh_cng_kit")
	private String vehCngkit;
	@Column(name = "veh_change_veh_body")
	private String vehChangevehbody;
	@Column(name = "veh_tyre_condition")
	private String vehTyrecondition;
	@Column(name = "veh_horn_installed")
	private String vehHorninstalled;
	@Column(name = "veh_brake_lights_functional")
	private String vehBrakelightsfunctional;
	@Column(name = "veh_faulty_no_plate")
	private String vehFaultynoplate;
	@Column(name = "veh_fitted_airbags")
	private String vehFittedairbags;
	@Column(name = "veh_airbags_deployed")
	private String vehAirbagsdeployed;
	@Column(name = "veh_airbag_reason")
	private String vehAirbagreason;
	@Column(name = "veh_tinted_glass")
	private String vehTintedglass;
	@Column(name = "veh_speed_limiter")
	private String vehSpeedlimiter;
	@Column(name = "veh_speed_limiter_functional")
	private String vehSpeedlimiterfunctional;
	@Column(name = "veh_rear_parkingsensor")
	private String vehRearparkingsensor;
	@Column(name = "veh_rear_parkingsensor_works")
	private String vehRearparkingsensorworks;
	@Column(name = "veh_rear_parkingsensor_reason")
	private String vehrearparkingsensorreason;
	@Column(name = "veh_tracking_devices")
	private String vehTrackingdevices;
	@Column(name = "veh_tracking_devices_works")
	private String vehTrackingdevicesworks;
	@Column(name = "veh_description_damage")
	private String vehDescriptiondamage;
	@Column(name = "veh_steer_cond")
	private String vehSteercond;
	@Column(name = "veh_wheel_cond")
	private String vehWheelcond;
	@Column(name = "veh_wiper_cond")
	private String vehWipercond;
	@Column(name = "veh_window_cond")
	private String vehWindowcond;
	@Column(name = "veh_mirror_cond")
	private String vehMirrorcond;
	@Column(name = "veh_cond_of_vehicle_extra")
	private String vehCondofvehicleextra;
	@Column(name="submit_check")
	private boolean submitCheck;
	
	@Column(name="vehicle_no")
	private String vehicleNo;
	
	@Column(name="bank_name")
	private String bankName;
	@Column(name="acc_holdername")
	private String accHoldername;
	@Column(name="acc_number")
	private String accNumber;
	@Column(name="ifsc_code")
	private String ifscCode;
	@Column(name="bank_address")
	private String bankAddress;
	
	@Column(name="dri_marital_status")
	private String driMaritalstatus;	
	@Column(name="dri_occupation_name")
	private String driOccupationname;
	@Column(name="dri_employed_or_not")
	private boolean driEmployedornot;
	@Column(name="dri_name_add_employer")
	private String driNameaddressemployer;
	@Column(name="dri_assessed_to_income_tax")
	private boolean driAssessedtoincometax;
	@Column(name="dri_reimbursement_medical_expense")
	private boolean driReimbursementmedicalexpense;
	@Column(name="dri_cashless_treatment")
	private boolean driCashlesstreatment;	
	@Column(name="dri_loss_to_property")
	private String driLosstoproperty;
	@Column(name="dri_value_of_loss")
	private String driValueofloss;
	@Column(name="dri_additional_info")
	private String driAdditionalinfo;
	@Column(name="dri_relief_amount")
	private String driReliefamount;
	
	@Column(name="veh_ref_id")
	private String vehrefId;

	@Column(name="victim_or_not")
	private boolean victimOrNot; 
	

	@Column(name="offending_vehicle_spotted")
	private String offendingVehiclespotted;
	@Column(name="vehicle_impounded_police")
	private String vehicleImpoundedpolice;
	@Column(name="driver_license_type")
	private String driverLicensetype;

	@Column(name="owner_father_name")
	private String ownerFathername;
	@Column(name="driver_father_name")
	private String driverFathername;
	
	@Column(name="dri_license_validity")
	private String driLicensevalidity;
	@Column(name="dri_license_authority")
	private String driLicenseauthority;
	@Column(name="owner_occupation")
	private String ownerOccupation;
	
	@Column(name="driver_remainder_date")
	private String driverRemainderdate;
	@Column(name="owner_remainder_date")
	private String ownerRemainderdate;	
	@Column(name="victim_remainder_date")
	private String victimRemainderdate;
	
	@Column(name="sole_earning_member")
	private boolean soleEarningmember;
	@Column(name="treatment_details_of_deceased")
	private String treatmentDetailsofdeceased;	
	@Column(name="expense_details_of_deceased")
	private String expenseDetailsofdeceased;
	@Column(name="dri_injured_or_not")
	private boolean driInjuredornot;
	@Column(name="permit_fitness_verified")
	private boolean permitfitnessVerified;	
	@Column(name="permit_fitness_verified_reasons")
	private String permitfitnessVerifiedreasons;
	@Column(name="ownerReportedacctoInsdt")
	private String ownerReportedacctoInsdt;
	@Column(name="victimType")
	private String victimType;	
	@Column(name="km_driven")
	private String kmDriven;	
	
	@Column(name="vehicle_reg_no")
	private String vehicleRegno;
	@Column(name="permanent_disability")
	private String permanentDisability;	
	@Column(name="permanent_disability_details")
	private String permanentDisabilitydetails;	
	
	
	@Column(name="period_hospitlization")
	private String periodHospitlization;
	
	@Column(name="treatment_details")
	private String treatmentDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public String getOwnerVehtype() {
		return ownerVehtype;
	}

	public void setOwnerVehtype(String ownerVehtype) {
		this.ownerVehtype = ownerVehtype;
	}

	public boolean isOwnerReportacc() {
		return ownerReportacc;
	}

	public void setOwnerReportacc(boolean ownerReportacc) {
		this.ownerReportacc = ownerReportacc;
	}

	public String getOwnerReportdt() {
		return ownerReportdt;
	}

	public void setOwnerReportdt(String ownerReportdt) {
		this.ownerReportdt = ownerReportdt;
	}

	public String getOwnerDetailspreins() {
		return ownerDetailspreins;
	}

	public void setOwnerDetailspreins(String ownerDetailspreins) {
		this.ownerDetailspreins = ownerDetailspreins;
	}

	public String getOwnerInsclaims() {
		return ownerInsclaims;
	}

	public void setOwnerInsclaims(String ownerInsclaims) {
		this.ownerInsclaims = ownerInsclaims;
	}

	public boolean isOwnerVehgps() {
		return ownerVehgps;
	}

	public void setOwnerVehgps(boolean ownerVehgps) {
		this.ownerVehgps = ownerVehgps;
	}

	public boolean isOwnerRelevantdetailsprovided() {
		return ownerRelevantdetailsprovided;
	}

	public void setOwnerRelevantdetailsprovided(boolean ownerRelevantdetailsprovided) {
		this.ownerRelevantdetailsprovided = ownerRelevantdetailsprovided;
	}

	public boolean isOwnerVehemergencybtn() {
		return ownerVehemergencybtn;
	}

	public void setOwnerVehemergencybtn(boolean ownerVehemergencybtn) {
		this.ownerVehemergencybtn = ownerVehemergencybtn;
	}

	public boolean isOwnerEmergencybtnworks() {
		return ownerEmergencybtnworks;
	}

	public void setOwnerEmergencybtnworks(boolean ownerEmergencybtnworks) {
		this.ownerEmergencybtnworks = ownerEmergencybtnworks;
	}

	public boolean isOwnerDriverranownerproduce() {
		return ownerDriverranownerproduce;
	}

	public void setOwnerDriverranownerproduce(boolean ownerDriverranownerproduce) {
		this.ownerDriverranownerproduce = ownerDriverranownerproduce;
	}

	public boolean isOwnerClaimantssettlement() {
		return ownerClaimantssettlement;
	}

	public void setOwnerClaimantssettlement(boolean ownerClaimantssettlement) {
		this.ownerClaimantssettlement = ownerClaimantssettlement;
	}

	public boolean isOwnerMact() {
		return ownerMact;
	}

	public void setOwnerMact(boolean ownerMact) {
		this.ownerMact = ownerMact;
	}

	public String getOwnermobileno() {
		return ownermobileno;
	}

	public void setOwnermobileno(String ownermobileno) {
		this.ownermobileno = ownermobileno;
	}

	public String getDriverWithoutsupervision() {
		return driverWithoutsupervision;
	}

	public void setDriverWithoutsupervision(String driverWithoutsupervision) {
		this.driverWithoutsupervision = driverWithoutsupervision;
	}

	public String getDriverLapsedlearnerlic() {
		return driverLapsedlearnerlic;
	}

	public void setDriverLapsedlearnerlic(String driverLapsedlearnerlic) {
		this.driverLapsedlearnerlic = driverLapsedlearnerlic;
	}

	public boolean isDriverAlcoholusage() {
		return driverAlcoholusage;
	}

	public void setDriverAlcoholusage(boolean driverAlcoholusage) {
		this.driverAlcoholusage = driverAlcoholusage;
	}

	public boolean isDriverScientificreport() {
		return driverScientificreport;
	}

	public void setDriverScientificreport(boolean driverScientificreport) {
		this.driverScientificreport = driverScientificreport;
	}

	public boolean isDriverMobileusage() {
		return driverMobileusage;
	}

	public void setDriverMobileusage(boolean driverMobileusage) {
		this.driverMobileusage = driverMobileusage;
	}

	public String getDriverMobileno() {
		return driverMobileno;
	}

	public void setDriverMobileno(String driverMobileno) {
		this.driverMobileno = driverMobileno;
	}

	public String getDriverImei() {
		return driverImei;
	}

	public void setDriverImei(String driverImei) {
		this.driverImei = driverImei;
	}

	public String getDriverMakemodel() {
		return driverMakemodel;
	}

	public void setDriverMakemodel(String driverMakemodel) {
		this.driverMakemodel = driverMakemodel;
	}

	public boolean isDriverInvolved_inacc() {
		return driverInvolved_inacc;
	}

	public void setDriverInvolved_inacc(boolean driverInvolved_inacc) {
		this.driverInvolved_inacc = driverInvolved_inacc;
	}

	public String getDriverFirno() {
		return driverFirno;
	}

	public void setDriverFirno(String driverFirno) {
		this.driverFirno = driverFirno;
	}

	public String getDriverDistrict() {
		return driverDistrict;
	}

	public void setDriverDistrict(String driverDistrict) {
		this.driverDistrict = driverDistrict;
	}

	public String getDriverPolicestation() {
		return driverPolicestation;
	}

	public void setDriverPolicestation(String driverPolicestation) {
		this.driverPolicestation = driverPolicestation;
	}

	public String getDriverEducation() {
		return driverEducation;
	}

	public void setDriverEducation(String driverEducation) {
		this.driverEducation = driverEducation;
	}

	public String getDriverIncome() {
		return driverIncome;
	}

	public void setDriverIncome(String driverIncome) {
		this.driverIncome = driverIncome;
	}

	public boolean isDriverLicensesuspended() {
		return driverLicensesuspended;
	}

	public void setDriverLicensesuspended(boolean driverLicensesuspended) {
		this.driverLicensesuspended = driverLicensesuspended;
	}

	public String getDriverVictimdisposition() {
		return driverVictimdisposition;
	}

	public void setDriverVictimdisposition(String driverVictimdisposition) {
		this.driverVictimdisposition = driverVictimdisposition;
	}

	public boolean isWitnessCheck() {
		return witnessCheck;
	}

	public void setWitnessCheck(boolean witnessCheck) {
		this.witnessCheck = witnessCheck;
	}

	public String getVehicleDrivenby() {
		return vehicleDrivenby;
	}

	public void setVehicleDrivenby(String vehicleDrivenby) {
		this.vehicleDrivenby = vehicleDrivenby;
	}

	public String getVehInspectionvehicle() {
		return vehInspectionvehicle;
	}

	public void setVehInspectionvehicle(String vehInspectionvehicle) {
		this.vehInspectionvehicle = vehInspectionvehicle;
	}

	public String getVehInspectionreport() {
		return vehInspectionreport;
	}

	public void setVehInspectionreport(String vehInspectionreport) {
		this.vehInspectionreport = vehInspectionreport;
	}

	public String getVehLocationinspection() {
		return vehLocationinspection;
	}

	public void setVehLocationinspection(String vehLocationinspection) {
		this.vehLocationinspection = vehLocationinspection;
	}

	public String getVehPainttransfer() {
		return vehPainttransfer;
	}

	public void setVehPainttransfer(String vehPainttransfer) {
		this.vehPainttransfer = vehPainttransfer;
	}

	public String getVehColorpainttransfer() {
		return vehColorpainttransfer;
	}

	public void setVehColorpainttransfer(String vehColorpainttransfer) {
		this.vehColorpainttransfer = vehColorpainttransfer;
	}

	public String getVehLocationpainttransfer1() {
		return vehLocationpainttransfer1;
	}

	public void setVehLocationpainttransfer1(String vehLocationpainttransfer1) {
		this.vehLocationpainttransfer1 = vehLocationpainttransfer1;
	}

	public String getVehTypescratch() {
		return vehTypescratch;
	}

	public void setVehTypescratch(String vehTypescratch) {
		this.vehTypescratch = vehTypescratch;
	}

	public String getVehLocationpainttransfer2() {
		return vehLocationpainttransfer2;
	}

	public void setVehLocationpainttransfer2(String vehLocationpainttransfer2) {
		this.vehLocationpainttransfer2 = vehLocationpainttransfer2;
	}

	public String getVehCngkit() {
		return vehCngkit;
	}

	public void setVehCngkit(String vehCngkit) {
		this.vehCngkit = vehCngkit;
	}

	public String getVehChangevehbody() {
		return vehChangevehbody;
	}

	public void setVehChangevehbody(String vehChangevehbody) {
		this.vehChangevehbody = vehChangevehbody;
	}

	public String getVehTyrecondition() {
		return vehTyrecondition;
	}

	public void setVehTyrecondition(String vehTyrecondition) {
		this.vehTyrecondition = vehTyrecondition;
	}

	public String getVehHorninstalled() {
		return vehHorninstalled;
	}

	public void setVehHorninstalled(String vehHorninstalled) {
		this.vehHorninstalled = vehHorninstalled;
	}

	public String getVehBrakelightsfunctional() {
		return vehBrakelightsfunctional;
	}

	public void setVehBrakelightsfunctional(String vehBrakelightsfunctional) {
		this.vehBrakelightsfunctional = vehBrakelightsfunctional;
	}

	public String getVehFaultynoplate() {
		return vehFaultynoplate;
	}

	public void setVehFaultynoplate(String vehFaultynoplate) {
		this.vehFaultynoplate = vehFaultynoplate;
	}

	public String getVehFittedairbags() {
		return vehFittedairbags;
	}

	public void setVehFittedairbags(String vehFittedairbags) {
		this.vehFittedairbags = vehFittedairbags;
	}

	public String getVehAirbagsdeployed() {
		return vehAirbagsdeployed;
	}

	public void setVehAirbagsdeployed(String vehAirbagsdeployed) {
		this.vehAirbagsdeployed = vehAirbagsdeployed;
	}

	public String getVehAirbagreason() {
		return vehAirbagreason;
	}

	public void setVehAirbagreason(String vehAirbagreason) {
		this.vehAirbagreason = vehAirbagreason;
	}

	public String getVehTintedglass() {
		return vehTintedglass;
	}

	public void setVehTintedglass(String vehTintedglass) {
		this.vehTintedglass = vehTintedglass;
	}

	public String getVehSpeedlimiter() {
		return vehSpeedlimiter;
	}

	public void setVehSpeedlimiter(String vehSpeedlimiter) {
		this.vehSpeedlimiter = vehSpeedlimiter;
	}

	public String getVehSpeedlimiterfunctional() {
		return vehSpeedlimiterfunctional;
	}

	public void setVehSpeedlimiterfunctional(String vehSpeedlimiterfunctional) {
		this.vehSpeedlimiterfunctional = vehSpeedlimiterfunctional;
	}

	public String getVehRearparkingsensor() {
		return vehRearparkingsensor;
	}

	public void setVehRearparkingsensor(String vehRearparkingsensor) {
		this.vehRearparkingsensor = vehRearparkingsensor;
	}

	public String getVehRearparkingsensorworks() {
		return vehRearparkingsensorworks;
	}

	public void setVehRearparkingsensorworks(String vehRearparkingsensorworks) {
		this.vehRearparkingsensorworks = vehRearparkingsensorworks;
	}

	public String getVehrearparkingsensorreason() {
		return vehrearparkingsensorreason;
	}

	public void setVehrearparkingsensorreason(String vehrearparkingsensorreason) {
		this.vehrearparkingsensorreason = vehrearparkingsensorreason;
	}

	public String getVehTrackingdevices() {
		return vehTrackingdevices;
	}

	public void setVehTrackingdevices(String vehTrackingdevices) {
		this.vehTrackingdevices = vehTrackingdevices;
	}

	public String getVehTrackingdevicesworks() {
		return vehTrackingdevicesworks;
	}

	public void setVehTrackingdevicesworks(String vehTrackingdevicesworks) {
		this.vehTrackingdevicesworks = vehTrackingdevicesworks;
	}

	public String getVehDescriptiondamage() {
		return vehDescriptiondamage;
	}

	public void setVehDescriptiondamage(String vehDescriptiondamage) {
		this.vehDescriptiondamage = vehDescriptiondamage;
	}

	public String getVehSteercond() {
		return vehSteercond;
	}

	public void setVehSteercond(String vehSteercond) {
		this.vehSteercond = vehSteercond;
	}

	public String getVehWheelcond() {
		return vehWheelcond;
	}

	public void setVehWheelcond(String vehWheelcond) {
		this.vehWheelcond = vehWheelcond;
	}

	public String getVehWipercond() {
		return vehWipercond;
	}

	public void setVehWipercond(String vehWipercond) {
		this.vehWipercond = vehWipercond;
	}

	public String getVehWindowcond() {
		return vehWindowcond;
	}

	public void setVehWindowcond(String vehWindowcond) {
		this.vehWindowcond = vehWindowcond;
	}

	public String getVehMirrorcond() {
		return vehMirrorcond;
	}

	public void setVehMirrorcond(String vehMirrorcond) {
		this.vehMirrorcond = vehMirrorcond;
	}

	public String getVehCondofvehicleextra() {
		return vehCondofvehicleextra;
	}

	public void setVehCondofvehicleextra(String vehCondofvehicleextra) {
		this.vehCondofvehicleextra = vehCondofvehicleextra;
	}

	public boolean isSubmitCheck() {
		return submitCheck;
	}

	public void setSubmitCheck(boolean submitCheck) {
		this.submitCheck = submitCheck;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccHoldername() {
		return accHoldername;
	}

	public void setAccHoldername(String accHoldername) {
		this.accHoldername = accHoldername;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getDriMaritalstatus() {
		return driMaritalstatus;
	}

	public void setDriMaritalstatus(String driMaritalstatus) {
		this.driMaritalstatus = driMaritalstatus;
	}

	public String getDriOccupationname() {
		return driOccupationname;
	}

	public void setDriOccupationname(String driOccupationname) {
		this.driOccupationname = driOccupationname;
	}

	public boolean isDriEmployedornot() {
		return driEmployedornot;
	}

	public void setDriEmployedornot(boolean driEmployedornot) {
		this.driEmployedornot = driEmployedornot;
	}

	public String getDriNameaddressemployer() {
		return driNameaddressemployer;
	}

	public void setDriNameaddressemployer(String driNameaddressemployer) {
		this.driNameaddressemployer = driNameaddressemployer;
	}

	public boolean isDriAssessedtoincometax() {
		return driAssessedtoincometax;
	}

	public void setDriAssessedtoincometax(boolean driAssessedtoincometax) {
		this.driAssessedtoincometax = driAssessedtoincometax;
	}

	public boolean isDriReimbursementmedicalexpense() {
		return driReimbursementmedicalexpense;
	}

	public void setDriReimbursementmedicalexpense(boolean driReimbursementmedicalexpense) {
		this.driReimbursementmedicalexpense = driReimbursementmedicalexpense;
	}

	public boolean isDriCashlesstreatment() {
		return driCashlesstreatment;
	}

	public void setDriCashlesstreatment(boolean driCashlesstreatment) {
		this.driCashlesstreatment = driCashlesstreatment;
	}

	public String getDriLosstoproperty() {
		return driLosstoproperty;
	}

	public void setDriLosstoproperty(String driLosstoproperty) {
		this.driLosstoproperty = driLosstoproperty;
	}

	public String getDriValueofloss() {
		return driValueofloss;
	}

	public void setDriValueofloss(String driValueofloss) {
		this.driValueofloss = driValueofloss;
	}

	public String getDriAdditionalinfo() {
		return driAdditionalinfo;
	}

	public void setDriAdditionalinfo(String driAdditionalinfo) {
		this.driAdditionalinfo = driAdditionalinfo;
	}

	public String getDriReliefamount() {
		return driReliefamount;
	}

	public void setDriReliefamount(String driReliefamount) {
		this.driReliefamount = driReliefamount;
	}

	public String getVehrefId() {
		return vehrefId;
	}

	public void setVehrefId(String vehrefId) {
		this.vehrefId = vehrefId;
	}

	public boolean isVictimOrNot() {
		return victimOrNot;
	}

	public void setVictimOrNot(boolean victimOrNot) {
		this.victimOrNot = victimOrNot;
	}

	public String getOffendingVehiclespotted() {
		return offendingVehiclespotted;
	}

	public void setOffendingVehiclespotted(String offendingVehiclespotted) {
		this.offendingVehiclespotted = offendingVehiclespotted;
	}

	public String getVehicleImpoundedpolice() {
		return vehicleImpoundedpolice;
	}

	public void setVehicleImpoundedpolice(String vehicleImpoundedpolice) {
		this.vehicleImpoundedpolice = vehicleImpoundedpolice;
	}

	public String getDriverLicensetype() {
		return driverLicensetype;
	}

	public void setDriverLicensetype(String driverLicensetype) {
		this.driverLicensetype = driverLicensetype;
	}

	public String getOwnerFathername() {
		return ownerFathername;
	}

	public void setOwnerFathername(String ownerFathername) {
		this.ownerFathername = ownerFathername;
	}

	public String getDriverFathername() {
		return driverFathername;
	}

	public void setDriverFathername(String driverFathername) {
		this.driverFathername = driverFathername;
	}

	public String getDriLicensevalidity() {
		return driLicensevalidity;
	}

	public void setDriLicensevalidity(String driLicensevalidity) {
		this.driLicensevalidity = driLicensevalidity;
	}

	public String getDriLicenseauthority() {
		return driLicenseauthority;
	}

	public void setDriLicenseauthority(String driLicenseauthority) {
		this.driLicenseauthority = driLicenseauthority;
	}

	public String getOwnerOccupation() {
		return ownerOccupation;
	}

	public void setOwnerOccupation(String ownerOccupation) {
		this.ownerOccupation = ownerOccupation;
	}

	public String getDriverRemainderdate() {
		return driverRemainderdate;
	}

	public void setDriverRemainderdate(String driverRemainderdate) {
		this.driverRemainderdate = driverRemainderdate;
	}

	public String getOwnerRemainderdate() {
		return ownerRemainderdate;
	}

	public void setOwnerRemainderdate(String ownerRemainderdate) {
		this.ownerRemainderdate = ownerRemainderdate;
	}

	public String getVictimRemainderdate() {
		return victimRemainderdate;
	}

	public void setVictimRemainderdate(String victimRemainderdate) {
		this.victimRemainderdate = victimRemainderdate;
	}

	public boolean isSoleEarningmember() {
		return soleEarningmember;
	}

	public void setSoleEarningmember(boolean soleEarningmember) {
		this.soleEarningmember = soleEarningmember;
	}

	public String getTreatmentDetailsofdeceased() {
		return treatmentDetailsofdeceased;
	}

	public void setTreatmentDetailsofdeceased(String treatmentDetailsofdeceased) {
		this.treatmentDetailsofdeceased = treatmentDetailsofdeceased;
	}

	public String getExpenseDetailsofdeceased() {
		return expenseDetailsofdeceased;
	}

	public void setExpenseDetailsofdeceased(String expenseDetailsofdeceased) {
		this.expenseDetailsofdeceased = expenseDetailsofdeceased;
	}

	public boolean isDriInjuredornot() {
		return driInjuredornot;
	}

	public void setDriInjuredornot(boolean driInjuredornot) {
		this.driInjuredornot = driInjuredornot;
	}

	public boolean isPermitfitnessVerified() {
		return permitfitnessVerified;
	}

	public void setPermitfitnessVerified(boolean permitfitnessVerified) {
		this.permitfitnessVerified = permitfitnessVerified;
	}

	public String getPermitfitnessVerifiedreasons() {
		return permitfitnessVerifiedreasons;
	}

	public void setPermitfitnessVerifiedreasons(String permitfitnessVerifiedreasons) {
		this.permitfitnessVerifiedreasons = permitfitnessVerifiedreasons;
	}

	public String getOwnerReportedacctoInsdt() {
		return ownerReportedacctoInsdt;
	}

	public void setOwnerReportedacctoInsdt(String ownerReportedacctoInsdt) {
		this.ownerReportedacctoInsdt = ownerReportedacctoInsdt;
	}

	public String getVictimType() {
		return victimType;
	}

	public void setVictimType(String victimType) {
		this.victimType = victimType;
	}

	public String getKmDriven() {
		return kmDriven;
	}

	public void setKmDriven(String kmDriven) {
		this.kmDriven = kmDriven;
	}

	public String getVehicleRegno() {
		return vehicleRegno;
	}

	public void setVehicleRegno(String vehicleRegno) {
		this.vehicleRegno = vehicleRegno;
	}

	public String getPermanentDisability() {
		return permanentDisability;
	}

	public void setPermanentDisability(String permanentDisability) {
		this.permanentDisability = permanentDisability;
	}

	public String getPermanentDisabilitydetails() {
		return permanentDisabilitydetails;
	}

	public void setPermanentDisabilitydetails(String permanentDisabilitydetails) {
		this.permanentDisabilitydetails = permanentDisabilitydetails;
	}

	public String getPeriodHospitlization() {
		return periodHospitlization;
	}

	public void setPeriodHospitlization(String periodHospitlization) {
		this.periodHospitlization = periodHospitlization;
	}

	public String getTreatmentDetails() {
		return treatmentDetails;
	}

	public void setTreatmentDetails(String treatmentDetails) {
		this.treatmentDetails = treatmentDetails;
	}

	public VehicleEntity(long id, String accId, String ownerVehtype, boolean ownerReportacc, String ownerReportdt,
			String ownerDetailspreins, String ownerInsclaims, boolean ownerVehgps, boolean ownerRelevantdetailsprovided,
			boolean ownerVehemergencybtn, boolean ownerEmergencybtnworks, boolean ownerDriverranownerproduce,
			boolean ownerClaimantssettlement, boolean ownerMact, String ownermobileno, String driverWithoutsupervision,
			String driverLapsedlearnerlic, boolean driverAlcoholusage, boolean driverScientificreport,
			boolean driverMobileusage, String driverMobileno, String driverImei, String driverMakemodel,
			boolean driverInvolved_inacc, String driverFirno, String driverDistrict, String driverPolicestation,
			String driverEducation, String driverIncome, boolean driverLicensesuspended, String driverVictimdisposition,
			boolean witnessCheck, String vehicleDrivenby, String vehInspectionvehicle, String vehInspectionreport,
			String vehLocationinspection, String vehPainttransfer, String vehColorpainttransfer,
			String vehLocationpainttransfer1, String vehTypescratch, String vehLocationpainttransfer2, String vehCngkit,
			String vehChangevehbody, String vehTyrecondition, String vehHorninstalled, String vehBrakelightsfunctional,
			String vehFaultynoplate, String vehFittedairbags, String vehAirbagsdeployed, String vehAirbagreason,
			String vehTintedglass, String vehSpeedlimiter, String vehSpeedlimiterfunctional,
			String vehRearparkingsensor, String vehRearparkingsensorworks, String vehrearparkingsensorreason,
			String vehTrackingdevices, String vehTrackingdevicesworks, String vehDescriptiondamage, String vehSteercond,
			String vehWheelcond, String vehWipercond, String vehWindowcond, String vehMirrorcond,
			String vehCondofvehicleextra, boolean submitCheck, String vehicleNo, String bankName, String accHoldername,
			String accNumber, String ifscCode, String bankAddress, String driMaritalstatus, String driOccupationname,
			boolean driEmployedornot, String driNameaddressemployer, boolean driAssessedtoincometax,
			boolean driReimbursementmedicalexpense, boolean driCashlesstreatment, String driLosstoproperty,
			String driValueofloss, String driAdditionalinfo, String driReliefamount, String vehrefId,
			boolean victimOrNot, String offendingVehiclespotted, String vehicleImpoundedpolice,
			String driverLicensetype, String ownerFathername, String driverFathername, String driLicensevalidity,
			String driLicenseauthority, String ownerOccupation, String driverRemainderdate, String ownerRemainderdate,
			String victimRemainderdate, boolean soleEarningmember, String treatmentDetailsofdeceased,
			String expenseDetailsofdeceased, boolean driInjuredornot, boolean permitfitnessVerified,
			String permitfitnessVerifiedreasons, String ownerReportedacctoInsdt, String victimType, String kmDriven,
			String vehicleRegno, String permanentDisability, String permanentDisabilitydetails,
			String periodHospitlization, String treatmentDetails) {
		super();
		this.id = id;
		this.accId = accId;
		this.ownerVehtype = ownerVehtype;
		this.ownerReportacc = ownerReportacc;
		this.ownerReportdt = ownerReportdt;
		this.ownerDetailspreins = ownerDetailspreins;
		this.ownerInsclaims = ownerInsclaims;
		this.ownerVehgps = ownerVehgps;
		this.ownerRelevantdetailsprovided = ownerRelevantdetailsprovided;
		this.ownerVehemergencybtn = ownerVehemergencybtn;
		this.ownerEmergencybtnworks = ownerEmergencybtnworks;
		this.ownerDriverranownerproduce = ownerDriverranownerproduce;
		this.ownerClaimantssettlement = ownerClaimantssettlement;
		this.ownerMact = ownerMact;
		this.ownermobileno = ownermobileno;
		this.driverWithoutsupervision = driverWithoutsupervision;
		this.driverLapsedlearnerlic = driverLapsedlearnerlic;
		this.driverAlcoholusage = driverAlcoholusage;
		this.driverScientificreport = driverScientificreport;
		this.driverMobileusage = driverMobileusage;
		this.driverMobileno = driverMobileno;
		this.driverImei = driverImei;
		this.driverMakemodel = driverMakemodel;
		this.driverInvolved_inacc = driverInvolved_inacc;
		this.driverFirno = driverFirno;
		this.driverDistrict = driverDistrict;
		this.driverPolicestation = driverPolicestation;
		this.driverEducation = driverEducation;
		this.driverIncome = driverIncome;
		this.driverLicensesuspended = driverLicensesuspended;
		this.driverVictimdisposition = driverVictimdisposition;
		this.witnessCheck = witnessCheck;
		this.vehicleDrivenby = vehicleDrivenby;
		this.vehInspectionvehicle = vehInspectionvehicle;
		this.vehInspectionreport = vehInspectionreport;
		this.vehLocationinspection = vehLocationinspection;
		this.vehPainttransfer = vehPainttransfer;
		this.vehColorpainttransfer = vehColorpainttransfer;
		this.vehLocationpainttransfer1 = vehLocationpainttransfer1;
		this.vehTypescratch = vehTypescratch;
		this.vehLocationpainttransfer2 = vehLocationpainttransfer2;
		this.vehCngkit = vehCngkit;
		this.vehChangevehbody = vehChangevehbody;
		this.vehTyrecondition = vehTyrecondition;
		this.vehHorninstalled = vehHorninstalled;
		this.vehBrakelightsfunctional = vehBrakelightsfunctional;
		this.vehFaultynoplate = vehFaultynoplate;
		this.vehFittedairbags = vehFittedairbags;
		this.vehAirbagsdeployed = vehAirbagsdeployed;
		this.vehAirbagreason = vehAirbagreason;
		this.vehTintedglass = vehTintedglass;
		this.vehSpeedlimiter = vehSpeedlimiter;
		this.vehSpeedlimiterfunctional = vehSpeedlimiterfunctional;
		this.vehRearparkingsensor = vehRearparkingsensor;
		this.vehRearparkingsensorworks = vehRearparkingsensorworks;
		this.vehrearparkingsensorreason = vehrearparkingsensorreason;
		this.vehTrackingdevices = vehTrackingdevices;
		this.vehTrackingdevicesworks = vehTrackingdevicesworks;
		this.vehDescriptiondamage = vehDescriptiondamage;
		this.vehSteercond = vehSteercond;
		this.vehWheelcond = vehWheelcond;
		this.vehWipercond = vehWipercond;
		this.vehWindowcond = vehWindowcond;
		this.vehMirrorcond = vehMirrorcond;
		this.vehCondofvehicleextra = vehCondofvehicleextra;
		this.submitCheck = submitCheck;
		this.vehicleNo = vehicleNo;
		this.bankName = bankName;
		this.accHoldername = accHoldername;
		this.accNumber = accNumber;
		this.ifscCode = ifscCode;
		this.bankAddress = bankAddress;
		this.driMaritalstatus = driMaritalstatus;
		this.driOccupationname = driOccupationname;
		this.driEmployedornot = driEmployedornot;
		this.driNameaddressemployer = driNameaddressemployer;
		this.driAssessedtoincometax = driAssessedtoincometax;
		this.driReimbursementmedicalexpense = driReimbursementmedicalexpense;
		this.driCashlesstreatment = driCashlesstreatment;
		this.driLosstoproperty = driLosstoproperty;
		this.driValueofloss = driValueofloss;
		this.driAdditionalinfo = driAdditionalinfo;
		this.driReliefamount = driReliefamount;
		this.vehrefId = vehrefId;
		this.victimOrNot = victimOrNot;
		this.offendingVehiclespotted = offendingVehiclespotted;
		this.vehicleImpoundedpolice = vehicleImpoundedpolice;
		this.driverLicensetype = driverLicensetype;
		this.ownerFathername = ownerFathername;
		this.driverFathername = driverFathername;
		this.driLicensevalidity = driLicensevalidity;
		this.driLicenseauthority = driLicenseauthority;
		this.ownerOccupation = ownerOccupation;
		this.driverRemainderdate = driverRemainderdate;
		this.ownerRemainderdate = ownerRemainderdate;
		this.victimRemainderdate = victimRemainderdate;
		this.soleEarningmember = soleEarningmember;
		this.treatmentDetailsofdeceased = treatmentDetailsofdeceased;
		this.expenseDetailsofdeceased = expenseDetailsofdeceased;
		this.driInjuredornot = driInjuredornot;
		this.permitfitnessVerified = permitfitnessVerified;
		this.permitfitnessVerifiedreasons = permitfitnessVerifiedreasons;
		this.ownerReportedacctoInsdt = ownerReportedacctoInsdt;
		this.victimType = victimType;
		this.kmDriven = kmDriven;
		this.vehicleRegno = vehicleRegno;
		this.permanentDisability = permanentDisability;
		this.permanentDisabilitydetails = permanentDisabilitydetails;
		this.periodHospitlization = periodHospitlization;
		this.treatmentDetails = treatmentDetails;
	}

	@Override
	public String toString() {
		return "VehicleEntity [id=" + id + ", accId=" + accId + ", ownerVehtype=" + ownerVehtype + ", ownerReportacc="
				+ ownerReportacc + ", ownerReportdt=" + ownerReportdt + ", ownerDetailspreins=" + ownerDetailspreins
				+ ", ownerInsclaims=" + ownerInsclaims + ", ownerVehgps=" + ownerVehgps
				+ ", ownerRelevantdetailsprovided=" + ownerRelevantdetailsprovided + ", ownerVehemergencybtn="
				+ ownerVehemergencybtn + ", ownerEmergencybtnworks=" + ownerEmergencybtnworks
				+ ", ownerDriverranownerproduce=" + ownerDriverranownerproduce + ", ownerClaimantssettlement="
				+ ownerClaimantssettlement + ", ownerMact=" + ownerMact + ", ownermobileno=" + ownermobileno
				+ ", driverWithoutsupervision=" + driverWithoutsupervision + ", driverLapsedlearnerlic="
				+ driverLapsedlearnerlic + ", driverAlcoholusage=" + driverAlcoholusage + ", driverScientificreport="
				+ driverScientificreport + ", driverMobileusage=" + driverMobileusage + ", driverMobileno="
				+ driverMobileno + ", driverImei=" + driverImei + ", driverMakemodel=" + driverMakemodel
				+ ", driverInvolved_inacc=" + driverInvolved_inacc + ", driverFirno=" + driverFirno
				+ ", driverDistrict=" + driverDistrict + ", driverPolicestation=" + driverPolicestation
				+ ", driverEducation=" + driverEducation + ", driverIncome=" + driverIncome
				+ ", driverLicensesuspended=" + driverLicensesuspended + ", driverVictimdisposition="
				+ driverVictimdisposition + ", witnessCheck=" + witnessCheck + ", vehicleDrivenby=" + vehicleDrivenby
				+ ", vehInspectionvehicle=" + vehInspectionvehicle + ", vehInspectionreport=" + vehInspectionreport
				+ ", vehLocationinspection=" + vehLocationinspection + ", vehPainttransfer=" + vehPainttransfer
				+ ", vehColorpainttransfer=" + vehColorpainttransfer + ", vehLocationpainttransfer1="
				+ vehLocationpainttransfer1 + ", vehTypescratch=" + vehTypescratch + ", vehLocationpainttransfer2="
				+ vehLocationpainttransfer2 + ", vehCngkit=" + vehCngkit + ", vehChangevehbody=" + vehChangevehbody
				+ ", vehTyrecondition=" + vehTyrecondition + ", vehHorninstalled=" + vehHorninstalled
				+ ", vehBrakelightsfunctional=" + vehBrakelightsfunctional + ", vehFaultynoplate=" + vehFaultynoplate
				+ ", vehFittedairbags=" + vehFittedairbags + ", vehAirbagsdeployed=" + vehAirbagsdeployed
				+ ", vehAirbagreason=" + vehAirbagreason + ", vehTintedglass=" + vehTintedglass + ", vehSpeedlimiter="
				+ vehSpeedlimiter + ", vehSpeedlimiterfunctional=" + vehSpeedlimiterfunctional
				+ ", vehRearparkingsensor=" + vehRearparkingsensor + ", vehRearparkingsensorworks="
				+ vehRearparkingsensorworks + ", vehrearparkingsensorreason=" + vehrearparkingsensorreason
				+ ", vehTrackingdevices=" + vehTrackingdevices + ", vehTrackingdevicesworks=" + vehTrackingdevicesworks
				+ ", vehDescriptiondamage=" + vehDescriptiondamage + ", vehSteercond=" + vehSteercond
				+ ", vehWheelcond=" + vehWheelcond + ", vehWipercond=" + vehWipercond + ", vehWindowcond="
				+ vehWindowcond + ", vehMirrorcond=" + vehMirrorcond + ", vehCondofvehicleextra="
				+ vehCondofvehicleextra + ", submitCheck=" + submitCheck + ", vehicleNo=" + vehicleNo + ", bankName="
				+ bankName + ", accHoldername=" + accHoldername + ", accNumber=" + accNumber + ", ifscCode=" + ifscCode
				+ ", bankAddress=" + bankAddress + ", driMaritalstatus=" + driMaritalstatus + ", driOccupationname="
				+ driOccupationname + ", driEmployedornot=" + driEmployedornot + ", driNameaddressemployer="
				+ driNameaddressemployer + ", driAssessedtoincometax=" + driAssessedtoincometax
				+ ", driReimbursementmedicalexpense=" + driReimbursementmedicalexpense + ", driCashlesstreatment="
				+ driCashlesstreatment + ", driLosstoproperty=" + driLosstoproperty + ", driValueofloss="
				+ driValueofloss + ", driAdditionalinfo=" + driAdditionalinfo + ", driReliefamount=" + driReliefamount
				+ ", vehrefId=" + vehrefId + ", victimOrNot=" + victimOrNot + ", offendingVehiclespotted="
				+ offendingVehiclespotted + ", vehicleImpoundedpolice=" + vehicleImpoundedpolice
				+ ", driverLicensetype=" + driverLicensetype + ", ownerFathername=" + ownerFathername
				+ ", driverFathername=" + driverFathername + ", driLicensevalidity=" + driLicensevalidity
				+ ", driLicenseauthority=" + driLicenseauthority + ", ownerOccupation=" + ownerOccupation
				+ ", driverRemainderdate=" + driverRemainderdate + ", ownerRemainderdate=" + ownerRemainderdate
				+ ", victimRemainderdate=" + victimRemainderdate + ", soleEarningmember=" + soleEarningmember
				+ ", treatmentDetailsofdeceased=" + treatmentDetailsofdeceased + ", expenseDetailsofdeceased="
				+ expenseDetailsofdeceased + ", driInjuredornot=" + driInjuredornot + ", permitfitnessVerified="
				+ permitfitnessVerified + ", permitfitnessVerifiedreasons=" + permitfitnessVerifiedreasons
				+ ", ownerReportedacctoInsdt=" + ownerReportedacctoInsdt + ", victimType=" + victimType + ", kmDriven="
				+ kmDriven + ", vehicleRegno=" + vehicleRegno + ", permanentDisability=" + permanentDisability
				+ ", permanentDisabilitydetails=" + permanentDisabilitydetails + ", periodHospitlization="
				+ periodHospitlization + ", treatmentDetails=" + treatmentDetails + "]";
	}

	public VehicleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	

	
}
