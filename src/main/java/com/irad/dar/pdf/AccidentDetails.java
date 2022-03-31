package com.irad.dar.pdf;

import java.util.List;

//@Data
public class AccidentDetails {
	private String accidentId;
    private String grievousCount;
    private String simpleInjury;
    private String firNumber;
	private String dateTime;
	private String timeOfTheDay;
	private String psName;
	private String state;
	private String district;
	private String month;
	private String year;
	private String dayOfWeek;
	private String collisionType;
	private String collisionNature;
	private String landmarks;
    private String investigatingOfficer;
    private String investigatingOfficerAddress;
    private String investigatingOfficerPhoneNo;
    private String investigatingOfficerPisnumber;
    private String pedestrianCount;
    private String vehiclesCount;
    private String totalDead;
    private String totalInjured;
    private String gps;
    private String roadDetails;
    private String sourceOfInformation;
    
	//witness
    private String witnessName;
    private int age;
    private String gender;
    private String guaridan_type;
    private String gurardian_name;
    private String residence;
    private String mobile;
    
    
   //vehicle
    private String vehicle_reg_no;
    private String vehicleColor;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleYearOfManufacture;
    private String vehicleChassisNo;
	private String vehicleEngineNo;
    private String vehicleType;
    private String vehicleSubType;
    private String vehicleUseType;
    
	private String vehicleLoadCondition;
    private String vehicle_owner_name;
	private String insuranceDetails;
	private String insurancePolicyno;
    private String insuranceValidity;
    private String insuranceCompanyaddr;
	private String owneraddr;
    
    //driver
    private String ser_name;
	private String ser_permadd1;
    private String ser_permadd2;
    private String ser_permadd3;
    private String ser_tempadd1;
    private String ser_tempadd2;
    private String ser_tempadd3;
    private String ser_dateofbirth;
    private String ser_gender;
    private String ser_age;
    private String driver_occupation; 
    private String dname;
	private String injury_severity;
	private String driver_residence;
	private String driver_mobileNo;
    private String license_number;
    private String mobile_no;
    private String cellphonedriving;
    private String drunk;
    private String driver_mobileno;
    
    
    
    
    
    
    
    
    //dar_general
    private String reportedAccident;
	private String victimToHospital;
    private String accidentDescription;
    private String sitePlanDescription;
    private String cctvFootage;
    private String cctvAvailability;
    private String ownerContactNumber;
    private String vehicleDrivenBy;
    private String driverWithoutSupervision;
    private String driverLapsedLearnerLic;
    private String driverMobileUsage;
    private String driverAlcoholUsage;
    private String sitePlanDate;
    
    //road
    private String roadDirection;
    private String noOfLanes;
    private String permissibleSpeedLimit;
    private String roadJunction;
    private String roadName;
    private String roadNumber;
    private String trafficMovement;
    private String vehiclewidth;
    private String vehicleLocationOnRoad;
    
       
    //pedestrian
    private String whoTookVictimHsptl;
    private String acc_id; 
    private String driver_alcohol_usage; 
    private String driver_district; 
    private String driver_education;
    private String driver_firno; 
    private String driver_imei; 
    private String driver_income; 
    private String driver_involved_inacc; 
    private String driver_lapsed_learner_lic; 
    private String driver_make_model; 
    private String driver_mobile_no; 
    private String driver_mobile_usage; 
    private String driver_policestation; 
    private String driver_scientific_report; 
    private String driver_victim_disposition; 
    private String driver_without_supervision; 
    private String owner_claimants_settlement;
    private String owner_details_pre_ins; 
    private String owner_driver_ran_ownerproduce; 
    private String owner_emergencybtn_works; 
    private String owner_ins_claims; 
    private String owner_mact; 
    private String owner_relevant_details_provided; 
    private String owner_report_acc; 
    private String owner_report_dt; 
    private String owner_veh_emergencybtn; 
    private String owner_veh_gps; 
    private String owner_veh_type; 
    private String owner_mobile_no; 
    private String veh_airbag_reason; 
    private String veh_airbags_deployed; 
    private String veh_brake_lights_functional; 
    private String veh_change_veh_body; 
    private String veh_cng_kit; 
    private String veh_color_paint_transfer; 
    private String veh_cond_of_vehicle_extra; 
    private String veh_description_damage; 
    private String veh_faulty_no_plate; 
    private String veh_fitted_airbags; 
    private String veh_horn_installed; 
    private String veh_inspection_report;
    private String veh_inspection_vehicle; 
    private String veh_location_inspection; 
    private String veh_location_paint_transfer1; 
    private String veh_location_paint_transfer2; 
    private String veh_mirror_cond; 
    private String veh_paint_transfer; 
    private String veh_rear_parkingsensor; 
    private String veh_rear_parkingsensor_works; 
    private String veh_speed_limiter; 
    private String veh_speed_limiter_functional; 
    private String veh_steer_cond; 
    private String veh_tinted_glass; 
    private String veh_tracking_devices; 
    private String veh_tracking_devices_works; 
    private String veh_type_scratch; 
    private String veh_tyre_condition; 
    private String veh_wheel_cond; 
    private String veh_window_cond; 
    private String veh_wiper_cond; 
    private String vehicle_driven_by; 
    private String veh_rear_parkingsensor_reason; 
    private String witness_check; 
    private String submit_check; 
    private String vehicle_no; 
	private String bankName; 
    private String bankAddress; 
    private String accHolderName; 
    private String accNumber; 
    private String ifscCode; 
    private String licenseNumber; 
    private String driver_license_suspended;
    private String driverAge; 
    private String serDateOfBirth; 
    private String occupation; 
    private String driverVehNumber; 
    private String vehOwner; 
    private String ownerAddr; 
    private String driverResidence; 
    private String serRegistrationAuthority; 
    private String serMobileNumber; 
    private String driverage;
    private String driverName;
	private String driverDOB;
    private String driverOccupation;
    private String serRegAuthority;
	private String contactNumberOfOwner;
	private String nameOfTheDriver;
	private String driverMobileno;
	private String addressOfDriver;
    private String driverContactNumber;
    private String insurancePolicyNumber;
    
    public String getVehicleUseType() {
		return vehicleUseType;
	}
	public void setVehicleUseType(String vehicleUseType) {
		this.vehicleUseType = vehicleUseType;
	}
	
	private String periodOfInsurancePolicy;
	private String nameOfInsuranceCompany;
	private String addressOfInsuranceCompany;
	
	private String serGender; 
    
    
    
    
    
    //vehicle transport
    private String officer_name;
    private String trans_vehicle_reg_no;
    private String regno_status;
    private String regno_type;
    private String regno;
    private String temp_regno_validity;
    private String vclass;
    private String vtype;
    private String vowneraddr;
    private String make;
    private String makeclass;
    private String yearofmanfac;
    private String vage;
    private String engineno;
    private String chassisno;
    private String color;
    private String max_speed;
    private String vdescription;
    private String permitcat;
    private String permitno;
    private String permitvalidity;
    private String permitissuedby;
    private String fitcertstatus;
    private String fitcertval;
    private String regcrtval;
    private String polctrlcertval;
    private String insComAddr;
    private String ownerOccupation;
    private String ownerFatherName;
    private String driverFatherName;
    private String driverLicenceValidity;
    private String driverLicensingAuthority;
    private String ownerInsNo;
    private String ownerInsVal;
    private String ownerInsDetails;
    
    
    private String mvi_name;
    private String mvi_req_dt;
    private String skidmark;
    private String trackmark;
    private String ownername;
    private String regnoValidity;
    //mvi
    private String reqDateTime;
    private String resDateTime;
    private String resOfficer;
    
    
    
//    private String vehicleRegNo6;
//	private String vehicleModel6;
//	private String vehicleMake6;
//	private String nameOfTheOwner6;
//	private String addressOfOwner6;
//	private String age6;
//	private String driverDOB6;
//    private String driverOccupation6;
//    private String serRegAuthority6;
//	private String contactNumberOfOwner6;
//	private String nameOfTheDriver6;
//	private String addressOfDriver6;
//    private String driverContactNumber6;
//    private String insurancePolicyNumber6;
//	private String periodOfInsurancePolicy6;
//	private String nameOfInsuranceCompany6;
//	private String addressOfInsuranceCompany6;
//	private String gender6;
    
    //--------------------------------------------------------------------------------
    private String detailsOfSurgeries;
	private String anyPermanentDisability;
	private String injuredGotReimbursement;
	//family details
	private String familyName;
	private String familyAge;
	private String familyGender;
	private String relation;
	private String address;
	private String contactNumber;	
	private String cashlessTreatment;
	private String cashlessTreatmentDetails;
	private String amntOfReliefClaimed;
	private String futureProspects;
	private String medicalExpenses;
	private String funeralExpenses;
	private String otherPecuniaryLossForDeath;
	private String lossOfConsortium;
	private String lossOfLoveAndAffection;
	private String lossOfEstate;
	private String otherNonPecuniaryLoss;
	
	//injuredCase
		private String nameOfInjured;
		private String injFatherName;
		private String injAddress;
		private String injContactNumber;
		private String injAge;
		private String injDob;
		private String injGender;
		private String injMaritalStatus;
		private String injOccupation;
		private String injEmployed;
		
		private String injEmployerNameAndAddr;
		private String injIncome;
		private String injIncomeTax;
		//private String injIncomeTax3Years;
		private String injNatureDescription;
		private String injmedicalTrtmnt;
		private String injnameOfHospital;
		private String injhospitalizationPeriod;
		private String injdoctorName;
		private String injdetailsOfSurgery;
		private String injpermanentDiability;
		private String injDiabilityDetails;
		private String lossOfEarningCapacity;
		
	
		//details of losses
		private String expenditureOnTreatment;
		private String treatmentStillContinuing;
		private String expenditureOnConveyance;
		private String lossOfIncome;
		private String lossOfearningCapacity;
		private String otherPecuniaryLoss;
		private String injuredReimbursement;
		private String injuredReimbursementDetails;
		private String lossDamageToProperty;
		private String additionalInfo;
		private String valueOfLoss;
		private String briefDescriptionOfAccident;
		private String compensationClaimed;
		
		private String otherLossSpclTrmnt;
		private String percentageOfDisability;
		private String painAndSuffering;
		private String lossOfAmenties;
		private String disfiguration;
		private String lossOfMargProspects;
		private String lossOfReputation;
		private String nonPecuniaryLoss;
		private String totalLossSuffered;
	//child
	private String nameOfChild;
	private String detailsOfSchool;
	private String detailsOfClass;
	private String annualSchoolFee;
	private String approxExpenditure;
	
	
	//legal representatives of deceased
	private String laName;
	private String laAgeDob;
	private String laGender;
	private String laRelation;
	private String laStatus;
	private String laAddress;
	private String laContact;
	
	
	private String natureOfCase;
	private String offRegNo;
	private String offVehType;
	private String offOwnNAme;
	private String offOwnAdd;
	private String offOwnNumber;
	private String offdriName;
	private String offDriAdd;
	private String offDriNumber;
	private String offInsName;
	private String offInsAdd;
	private String offInsNumber;
	private String offInsPolNumber;
	private String offInsPolType;
	private String offInsPolExpDate;
	
	
	private String vehRegNo;
	private String vehType;
	private String nameOfDriver;
	private String addrOfDriver;
	private String nameOfOwner;
	private String addOfOwner;
	private String nameOfInsComp;
	private String addOfInsComp;
	
	
	private String involvedInAccident;
	private String involvedInAccidentName;
	private String placeOfStartingJourney;
	private String destination;
	private String briefDesAccident;
	
	//deceased
	private String deceasedName;
	private String deceasedFatherOrSpouseName;
	private String deceasedAge;
	private String deceasedDob;
	private String deceasedGender;
	private String deceasedStatus;
	private String deceasedOccupation;
	private String deceasedEmployed;
	private String deceasedEmployerNameAndAddr;
	private String deceasedIncome;
	private String deceasedIncomeTax;
	private String deceasedIncomeTax3Years;
	
	private String dtFilingFar;
	private String dtUploadingFar;
	private String dtDeliveryFirFarToInscompany;
	private String dtDeliveryFirForm2FarToVictim;
	private String dtReceiptForm3FromDriver;
	private String dtReceiptForm4From_owner;
	private String dtDeliveryForm3Form4ToInscompany;
	private String dtDeliveryForm3Form4ToVictim;
	private String docOfDriverOrOwner;
	private String docOfDriverOrOwnerVerified;
	
	private String driverLicenseType;
	private String driverInjuredOrNot;
	private String permitFitnessVerified;
	private String permitFitnessVerifiedReasons;
	private String ownerReportedAccInsDate;
	private String victimType;
	private String ownerVehicleType;
//	private String ownerVehicleType;
	
	//deceased death case
	private String id;
	private String injurySeverity;
	private String nameOfDeceased;
	private String ageOfDeceased;
	private String occupationOfDeceased;
	
	private String fatherNameOfDeceased;
	private String genderOfDeceased;
	private String maritalstatusOfDeceased;
	private String nameAndAddressOfDeceased;
	private String incomeOfDeceased;
	private String assesedToIncomeTaxDeceased;
	private String soleEarningMember;
	private String medicalExpensesIncurred;
	private String reimbursement;
//	private String assesedToIncomeTaxDeceased;
//	private String soleEarningMember;
	
	
	private String vehicle_id;
	private String ref_id;	
	private String deceasedLegalRepName;
	private String deceasedLegalRepRelation;         
	private String deceasedLegalRepAge;
	private String deceasedLegalRepGender;
	private String deceasedLegalRepMaritalStatus;
	private String deceasedLegalRepContactNumber;
	private String deceasedLegalRepAddress;	
	private String injLegalRepName;
	private String injLegalRepRelation;
	private String injLegalRepAge;
	private String injLegalRepGender;
	private String injLegalRepMaritalStatus;
	private String injLegalRepContactNumber;
	private String injLegalRepAddress;
	//Informant Details
	private String informantName;
	private String informerContactNumber;
	private String informerContactAddress;
	//
	private String natureOfAccident;
	private String vehImpoundedPolice;
	private String offendingVehSpotted;
	private String regnstatus;
	
	private String hpname;
	private String hpaddress;
	private String doctor_name;
	
	
	//Claims tribunal
	private String driRemainderDate;	
	private String OwnRemainderDate;
	private String victimRemainderDate;
	private String regAuthRemainderDate;
	private String hospitalRemainderDate;
	private String section;
	private String drivinglicencetype;
	private String currentDate;
	private List<WitnessDetails> witness; 
	private List<DeceasedDetails> deceasedDetails;
	private List<VehicleAndDriverDetails> vehicleAndDriver; 
    private List<InjuredAndDeseasedDetails> injuredAndDeseased;
   
    private List<MinorChildrenDetailsEntity1> childrenDetails;
    private InjuredDetails injuryDetails;
    private String victimDetails;
	public String getAccidentId() {
		return accidentId;
	}
	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}
	public String getGrievousCount() {
		return grievousCount;
	}
	public void setGrievousCount(String grievousCount) {
		this.grievousCount = grievousCount;
	}
	public String getSimpleInjury() {
		return simpleInjury;
	}
	public void setSimpleInjury(String simpleInjury) {
		this.simpleInjury = simpleInjury;
	}
	public String getFirNumber() {
		return firNumber;
	}
	public void setFirNumber(String firNumber) {
		this.firNumber = firNumber;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getTimeOfTheDay() {
		return timeOfTheDay;
	}
	public void setTimeOfTheDay(String timeOfTheDay) {
		this.timeOfTheDay = timeOfTheDay;
	}
	public String getPsName() {
		return psName;
	}
	public void setPsName(String psName) {
		this.psName = psName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getCollisionType() {
		return collisionType;
	}
	public void setCollisionType(String collisionType) {
		this.collisionType = collisionType;
	}
	public String getCollisionNature() {
		return collisionNature;
	}
	public void setCollisionNature(String collisionNature) {
		this.collisionNature = collisionNature;
	}
	public String getLandmarks() {
		return landmarks;
	}
	public void setLandmarks(String landmarks) {
		this.landmarks = landmarks;
	}
	public String getInvestigatingOfficer() {
		return investigatingOfficer;
	}
	public void setInvestigatingOfficer(String investigatingOfficer) {
		this.investigatingOfficer = investigatingOfficer;
	}
	public String getInvestigatingOfficerAddress() {
		return investigatingOfficerAddress;
	}
	public void setInvestigatingOfficerAddress(String investigatingOfficerAddress) {
		this.investigatingOfficerAddress = investigatingOfficerAddress;
	}
	public String getInvestigatingOfficerPhoneNo() {
		return investigatingOfficerPhoneNo;
	}
	public void setInvestigatingOfficerPhoneNo(String investigatingOfficerPhoneNo) {
		this.investigatingOfficerPhoneNo = investigatingOfficerPhoneNo;
	}
	public String getInvestigatingOfficerPisnumber() {
		return investigatingOfficerPisnumber;
	}
	public void setInvestigatingOfficerPisnumber(String investigatingOfficerPisnumber) {
		this.investigatingOfficerPisnumber = investigatingOfficerPisnumber;
	}
	public String getPedestrianCount() {
		return pedestrianCount;
	}
	public void setPedestrianCount(String pedestrianCount) {
		this.pedestrianCount = pedestrianCount;
	}
	public String getVehiclesCount() {
		return vehiclesCount;
	}
	public void setVehiclesCount(String vehiclesCount) {
		this.vehiclesCount = vehiclesCount;
	}
	public String getTotalDead() {
		return totalDead;
	}
	public void setTotalDead(String totalDead) {
		this.totalDead = totalDead;
	}
	public String getTotalInjured() {
		return totalInjured;
	}
	public void setTotalInjured(String totalInjured) {
		this.totalInjured = totalInjured;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
	public String getRoadDetails() {
		return roadDetails;
	}
	public void setRoadDetails(String roadDetails) {
		this.roadDetails = roadDetails;
	}
	public String getSourceOfInformation() {
		return sourceOfInformation;
	}
	public void setSourceOfInformation(String sourceOfInformation) {
		this.sourceOfInformation = sourceOfInformation;
	}
	public String getWitnessName() {
		return witnessName;
	}
	public void setWitnessName(String witnessName) {
		this.witnessName = witnessName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGuaridan_type() {
		return guaridan_type;
	}
	public void setGuaridan_type(String guaridan_type) {
		this.guaridan_type = guaridan_type;
	}
	public String getGurardian_name() {
		return gurardian_name;
	}
	public void setGurardian_name(String gurardian_name) {
		this.gurardian_name = gurardian_name;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getVehicle_reg_no() {
		return vehicle_reg_no;
	}
	public void setVehicle_reg_no(String vehicle_reg_no) {
		this.vehicle_reg_no = vehicle_reg_no;
	}
	public String getVehicleColor() {
		return vehicleColor;
	}
	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}
	public String getVehicleMake() {
		return vehicleMake;
	}
	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getVehicleYearOfManufacture() {
		return vehicleYearOfManufacture;
	}
	public void setVehicleYearOfManufacture(String vehicleYearOfManufacture) {
		this.vehicleYearOfManufacture = vehicleYearOfManufacture;
	}
	public String getVehicleChassisNo() {
		return vehicleChassisNo;
	}
	public void setVehicleChassisNo(String vehicleChassisNo) {
		this.vehicleChassisNo = vehicleChassisNo;
	}
	public String getVehicleEngineNo() {
		return vehicleEngineNo;
	}
	public void setVehicleEngineNo(String vehicleEngineNo) {
		this.vehicleEngineNo = vehicleEngineNo;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleSubType() {
		return vehicleSubType;
	}
	public void setVehicleSubType(String vehicleSubType) {
		this.vehicleSubType = vehicleSubType;
	}
	public String getVehicleLoadCondition() {
		return vehicleLoadCondition;
	}
	public void setVehicleLoadCondition(String vehicleLoadCondition) {
		this.vehicleLoadCondition = vehicleLoadCondition;
	}
	public String getVehicle_owner_name() {
		return vehicle_owner_name;
	}
	public void setVehicle_owner_name(String vehicle_owner_name) {
		this.vehicle_owner_name = vehicle_owner_name;
	}
	public String getInsuranceDetails() {
		return insuranceDetails;
	}
	public void setInsuranceDetails(String insuranceDetails) {
		this.insuranceDetails = insuranceDetails;
	}
	public String getInsurancePolicyno() {
		return insurancePolicyno;
	}
	public void setInsurancePolicyno(String insurancePolicyno) {
		this.insurancePolicyno = insurancePolicyno;
	}
	public String getInsuranceValidity() {
		return insuranceValidity;
	}
	public void setInsuranceValidity(String insuranceValidity) {
		this.insuranceValidity = insuranceValidity;
	}
	public String getInsuranceCompanyaddr() {
		return insuranceCompanyaddr;
	}
	public void setInsuranceCompanyaddr(String insuranceCompanyaddr) {
		this.insuranceCompanyaddr = insuranceCompanyaddr;
	}
	public String getOwneraddr() {
		return owneraddr;
	}
	public void setOwneraddr(String owneraddr) {
		this.owneraddr = owneraddr;
	}
	public String getSer_name() {
		return ser_name;
	}
	public void setSer_name(String ser_name) {
		this.ser_name = ser_name;
	}
	public String getSer_permadd1() {
		return ser_permadd1;
	}
	public void setSer_permadd1(String ser_permadd1) {
		this.ser_permadd1 = ser_permadd1;
	}
	public String getSer_permadd2() {
		return ser_permadd2;
	}
	public void setSer_permadd2(String ser_permadd2) {
		this.ser_permadd2 = ser_permadd2;
	}
	public String getSer_permadd3() {
		return ser_permadd3;
	}
	public void setSer_permadd3(String ser_permadd3) {
		this.ser_permadd3 = ser_permadd3;
	}
	public String getSer_tempadd1() {
		return ser_tempadd1;
	}
	public void setSer_tempadd1(String ser_tempadd1) {
		this.ser_tempadd1 = ser_tempadd1;
	}
	public String getSer_tempadd2() {
		return ser_tempadd2;
	}
	public void setSer_tempadd2(String ser_tempadd2) {
		this.ser_tempadd2 = ser_tempadd2;
	}
	public String getSer_tempadd3() {
		return ser_tempadd3;
	}
	public void setSer_tempadd3(String ser_tempadd3) {
		this.ser_tempadd3 = ser_tempadd3;
	}
	public String getSer_dateofbirth() {
		return ser_dateofbirth;
	}
	public void setSer_dateofbirth(String ser_dateofbirth) {
		this.ser_dateofbirth = ser_dateofbirth;
	}
	public String getSer_gender() {
		return ser_gender;
	}
	public void setSer_gender(String ser_gender) {
		this.ser_gender = ser_gender;
	}
	public String getSer_age() {
		return ser_age;
	}
	public void setSer_age(String ser_age) {
		this.ser_age = ser_age;
	}
	public String getDriver_occupation() {
		return driver_occupation;
	}
	public void setDriver_occupation(String driver_occupation) {
		this.driver_occupation = driver_occupation;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getInjury_severity() {
		return injury_severity;
	}
	public void setInjury_severity(String injury_severity) {
		this.injury_severity = injury_severity;
	}
	public String getDriver_residence() {
		return driver_residence;
	}
	public void setDriver_residence(String driver_residence) {
		this.driver_residence = driver_residence;
	}
	public String getDriver_mobileNo() {
		return driver_mobileNo;
	}
	public void setDriver_mobileNo(String driver_mobileNo) {
		this.driver_mobileNo = driver_mobileNo;
	}
	public String getLicense_number() {
		return license_number;
	}
	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getCellphonedriving() {
		return cellphonedriving;
	}
	public void setCellphonedriving(String cellphonedriving) {
		this.cellphonedriving = cellphonedriving;
	}
	public String getDrunk() {
		return drunk;
	}
	public void setDrunk(String drunk) {
		this.drunk = drunk;
	}
	public String getDriver_mobileno() {
		return driver_mobileno;
	}
	public void setDriver_mobileno(String driver_mobileno) {
		this.driver_mobileno = driver_mobileno;
	}
	public String getReportedAccident() {
		return reportedAccident;
	}
	public void setReportedAccident(String reportedAccident) {
		this.reportedAccident = reportedAccident;
	}
	public String getVictimToHospital() {
		return victimToHospital;
	}
	public void setVictimToHospital(String victimToHospital) {
		this.victimToHospital = victimToHospital;
	}
	public String getAccidentDescription() {
		return accidentDescription;
	}
	public void setAccidentDescription(String accidentDescription) {
		this.accidentDescription = accidentDescription;
	}
	public String getSitePlanDescription() {
		return sitePlanDescription;
	}
	public void setSitePlanDescription(String sitePlanDescription) {
		this.sitePlanDescription = sitePlanDescription;
	}
	public String getCctvFootage() {
		return cctvFootage;
	}
	public void setCctvFootage(String cctvFootage) {
		this.cctvFootage = cctvFootage;
	}
	public String getCctvAvailability() {
		return cctvAvailability;
	}
	public void setCctvAvailability(String cctvAvailability) {
		this.cctvAvailability = cctvAvailability;
	}
	public String getOwnerContactNumber() {
		return ownerContactNumber;
	}
	public void setOwnerContactNumber(String ownerContactNumber) {
		this.ownerContactNumber = ownerContactNumber;
	}
	public String getVehicleDrivenBy() {
		return vehicleDrivenBy;
	}
	public void setVehicleDrivenBy(String vehicleDrivenBy) {
		this.vehicleDrivenBy = vehicleDrivenBy;
	}
	public String getDriverWithoutSupervision() {
		return driverWithoutSupervision;
	}
	public void setDriverWithoutSupervision(String driverWithoutSupervision) {
		this.driverWithoutSupervision = driverWithoutSupervision;
	}
	public String getDriverLapsedLearnerLic() {
		return driverLapsedLearnerLic;
	}
	public void setDriverLapsedLearnerLic(String driverLapsedLearnerLic) {
		this.driverLapsedLearnerLic = driverLapsedLearnerLic;
	}
	public String getDriverMobileUsage() {
		return driverMobileUsage;
	}
	public void setDriverMobileUsage(String driverMobileUsage) {
		this.driverMobileUsage = driverMobileUsage;
	}
	public String getDriverAlcoholUsage() {
		return driverAlcoholUsage;
	}
	public void setDriverAlcoholUsage(String driverAlcoholUsage) {
		this.driverAlcoholUsage = driverAlcoholUsage;
	}
	public String getSitePlanDate() {
		return sitePlanDate;
	}
	public void setSitePlanDate(String sitePlanDate) {
		this.sitePlanDate = sitePlanDate;
	}
	public String getRoadDirection() {
		return roadDirection;
	}
	public void setRoadDirection(String roadDirection) {
		this.roadDirection = roadDirection;
	}
	public String getNoOfLanes() {
		return noOfLanes;
	}
	public void setNoOfLanes(String noOfLanes) {
		this.noOfLanes = noOfLanes;
	}
	public String getPermissibleSpeedLimit() {
		return permissibleSpeedLimit;
	}
	public void setPermissibleSpeedLimit(String permissibleSpeedLimit) {
		this.permissibleSpeedLimit = permissibleSpeedLimit;
	}
	public String getRoadJunction() {
		return roadJunction;
	}
	public void setRoadJunction(String roadJunction) {
		this.roadJunction = roadJunction;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	public String getRoadNumber() {
		return roadNumber;
	}
	public void setRoadNumber(String roadNumber) {
		this.roadNumber = roadNumber;
	}
	public String getTrafficMovement() {
		return trafficMovement;
	}
	public void setTrafficMovement(String trafficMovement) {
		this.trafficMovement = trafficMovement;
	}
	public String getVehiclewidth() {
		return vehiclewidth;
	}
	public void setVehiclewidth(String vehiclewidth) {
		this.vehiclewidth = vehiclewidth;
	}
	public String getVehicleLocationOnRoad() {
		return vehicleLocationOnRoad;
	}
	public void setVehicleLocationOnRoad(String vehicleLocationOnRoad) {
		this.vehicleLocationOnRoad = vehicleLocationOnRoad;
	}
	public String getWhoTookVictimHsptl() {
		return whoTookVictimHsptl;
	}
	public void setWhoTookVictimHsptl(String whoTookVictimHsptl) {
		this.whoTookVictimHsptl = whoTookVictimHsptl;
	}
	public String getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}
	public String getDriver_alcohol_usage() {
		return driver_alcohol_usage;
	}
	public void setDriver_alcohol_usage(String driver_alcohol_usage) {
		this.driver_alcohol_usage = driver_alcohol_usage;
	}
	public String getDriver_district() {
		return driver_district;
	}
	public void setDriver_district(String driver_district) {
		this.driver_district = driver_district;
	}
	public String getDriver_education() {
		return driver_education;
	}
	public void setDriver_education(String driver_education) {
		this.driver_education = driver_education;
	}
	public String getDriver_firno() {
		return driver_firno;
	}
	public void setDriver_firno(String driver_firno) {
		this.driver_firno = driver_firno;
	}
	public String getDriver_imei() {
		return driver_imei;
	}
	public void setDriver_imei(String driver_imei) {
		this.driver_imei = driver_imei;
	}
	public String getDriver_income() {
		return driver_income;
	}
	public void setDriver_income(String driver_income) {
		this.driver_income = driver_income;
	}
	public String getDriver_involved_inacc() {
		return driver_involved_inacc;
	}
	public void setDriver_involved_inacc(String driver_involved_inacc) {
		this.driver_involved_inacc = driver_involved_inacc;
	}
	public String getDriver_lapsed_learner_lic() {
		return driver_lapsed_learner_lic;
	}
	public void setDriver_lapsed_learner_lic(String driver_lapsed_learner_lic) {
		this.driver_lapsed_learner_lic = driver_lapsed_learner_lic;
	}
	public String getDriver_make_model() {
		return driver_make_model;
	}
	public void setDriver_make_model(String driver_make_model) {
		this.driver_make_model = driver_make_model;
	}
	public String getDriver_mobile_no() {
		return driver_mobile_no;
	}
	public void setDriver_mobile_no(String driver_mobile_no) {
		this.driver_mobile_no = driver_mobile_no;
	}
	public String getDriver_mobile_usage() {
		return driver_mobile_usage;
	}
	public void setDriver_mobile_usage(String driver_mobile_usage) {
		this.driver_mobile_usage = driver_mobile_usage;
	}
	public String getDriver_policestation() {
		return driver_policestation;
	}
	public void setDriver_policestation(String driver_policestation) {
		this.driver_policestation = driver_policestation;
	}
	public String getDriver_scientific_report() {
		return driver_scientific_report;
	}
	public void setDriver_scientific_report(String driver_scientific_report) {
		this.driver_scientific_report = driver_scientific_report;
	}
	public String getDriver_victim_disposition() {
		return driver_victim_disposition;
	}
	public void setDriver_victim_disposition(String driver_victim_disposition) {
		this.driver_victim_disposition = driver_victim_disposition;
	}
	public String getDriver_without_supervision() {
		return driver_without_supervision;
	}
	public void setDriver_without_supervision(String driver_without_supervision) {
		this.driver_without_supervision = driver_without_supervision;
	}
	public String getOwner_claimants_settlement() {
		return owner_claimants_settlement;
	}
	public void setOwner_claimants_settlement(String owner_claimants_settlement) {
		this.owner_claimants_settlement = owner_claimants_settlement;
	}
	public String getOwner_details_pre_ins() {
		return owner_details_pre_ins;
	}
	public void setOwner_details_pre_ins(String owner_details_pre_ins) {
		this.owner_details_pre_ins = owner_details_pre_ins;
	}
	public String getOwner_driver_ran_ownerproduce() {
		return owner_driver_ran_ownerproduce;
	}
	public void setOwner_driver_ran_ownerproduce(String owner_driver_ran_ownerproduce) {
		this.owner_driver_ran_ownerproduce = owner_driver_ran_ownerproduce;
	}
	public String getOwner_emergencybtn_works() {
		return owner_emergencybtn_works;
	}
	public void setOwner_emergencybtn_works(String owner_emergencybtn_works) {
		this.owner_emergencybtn_works = owner_emergencybtn_works;
	}
	public String getOwner_ins_claims() {
		return owner_ins_claims;
	}
	public void setOwner_ins_claims(String owner_ins_claims) {
		this.owner_ins_claims = owner_ins_claims;
	}
	public String getOwner_mact() {
		return owner_mact;
	}
	public void setOwner_mact(String owner_mact) {
		this.owner_mact = owner_mact;
	}
	public String getOwner_relevant_details_provided() {
		return owner_relevant_details_provided;
	}
	public void setOwner_relevant_details_provided(String owner_relevant_details_provided) {
		this.owner_relevant_details_provided = owner_relevant_details_provided;
	}
	public String getOwner_report_acc() {
		return owner_report_acc;
	}
	public void setOwner_report_acc(String owner_report_acc) {
		this.owner_report_acc = owner_report_acc;
	}
	public String getOwner_report_dt() {
		return owner_report_dt;
	}
	public void setOwner_report_dt(String owner_report_dt) {
		this.owner_report_dt = owner_report_dt;
	}
	public String getOwner_veh_emergencybtn() {
		return owner_veh_emergencybtn;
	}
	public void setOwner_veh_emergencybtn(String owner_veh_emergencybtn) {
		this.owner_veh_emergencybtn = owner_veh_emergencybtn;
	}
	public String getOwner_veh_gps() {
		return owner_veh_gps;
	}
	public void setOwner_veh_gps(String owner_veh_gps) {
		this.owner_veh_gps = owner_veh_gps;
	}
	public String getOwner_veh_type() {
		return owner_veh_type;
	}
	public void setOwner_veh_type(String owner_veh_type) {
		this.owner_veh_type = owner_veh_type;
	}
	public String getOwner_mobile_no() {
		return owner_mobile_no;
	}
	public void setOwner_mobile_no(String owner_mobile_no) {
		this.owner_mobile_no = owner_mobile_no;
	}
	public String getVeh_airbag_reason() {
		return veh_airbag_reason;
	}
	public void setVeh_airbag_reason(String veh_airbag_reason) {
		this.veh_airbag_reason = veh_airbag_reason;
	}
	public String getVeh_airbags_deployed() {
		return veh_airbags_deployed;
	}
	public void setVeh_airbags_deployed(String veh_airbags_deployed) {
		this.veh_airbags_deployed = veh_airbags_deployed;
	}
	public String getVeh_brake_lights_functional() {
		return veh_brake_lights_functional;
	}
	public void setVeh_brake_lights_functional(String veh_brake_lights_functional) {
		this.veh_brake_lights_functional = veh_brake_lights_functional;
	}
	public String getVeh_change_veh_body() {
		return veh_change_veh_body;
	}
	public void setVeh_change_veh_body(String veh_change_veh_body) {
		this.veh_change_veh_body = veh_change_veh_body;
	}
	public String getVeh_cng_kit() {
		return veh_cng_kit;
	}
	public void setVeh_cng_kit(String veh_cng_kit) {
		this.veh_cng_kit = veh_cng_kit;
	}
	public String getVeh_color_paint_transfer() {
		return veh_color_paint_transfer;
	}
	public void setVeh_color_paint_transfer(String veh_color_paint_transfer) {
		this.veh_color_paint_transfer = veh_color_paint_transfer;
	}
	public String getVeh_cond_of_vehicle_extra() {
		return veh_cond_of_vehicle_extra;
	}
	public void setVeh_cond_of_vehicle_extra(String veh_cond_of_vehicle_extra) {
		this.veh_cond_of_vehicle_extra = veh_cond_of_vehicle_extra;
	}
	public String getVeh_description_damage() {
		return veh_description_damage;
	}
	public void setVeh_description_damage(String veh_description_damage) {
		this.veh_description_damage = veh_description_damage;
	}
	public String getVeh_faulty_no_plate() {
		return veh_faulty_no_plate;
	}
	public void setVeh_faulty_no_plate(String veh_faulty_no_plate) {
		this.veh_faulty_no_plate = veh_faulty_no_plate;
	}
	public String getVeh_fitted_airbags() {
		return veh_fitted_airbags;
	}
	public void setVeh_fitted_airbags(String veh_fitted_airbags) {
		this.veh_fitted_airbags = veh_fitted_airbags;
	}
	public String getVeh_horn_installed() {
		return veh_horn_installed;
	}
	public void setVeh_horn_installed(String veh_horn_installed) {
		this.veh_horn_installed = veh_horn_installed;
	}
	public String getVeh_inspection_report() {
		return veh_inspection_report;
	}
	public void setVeh_inspection_report(String veh_inspection_report) {
		this.veh_inspection_report = veh_inspection_report;
	}
	public String getVeh_inspection_vehicle() {
		return veh_inspection_vehicle;
	}
	public void setVeh_inspection_vehicle(String veh_inspection_vehicle) {
		this.veh_inspection_vehicle = veh_inspection_vehicle;
	}
	public String getVeh_location_inspection() {
		return veh_location_inspection;
	}
	public void setVeh_location_inspection(String veh_location_inspection) {
		this.veh_location_inspection = veh_location_inspection;
	}
	public String getVeh_location_paint_transfer1() {
		return veh_location_paint_transfer1;
	}
	public void setVeh_location_paint_transfer1(String veh_location_paint_transfer1) {
		this.veh_location_paint_transfer1 = veh_location_paint_transfer1;
	}
	public String getVeh_location_paint_transfer2() {
		return veh_location_paint_transfer2;
	}
	public void setVeh_location_paint_transfer2(String veh_location_paint_transfer2) {
		this.veh_location_paint_transfer2 = veh_location_paint_transfer2;
	}
	public String getVeh_mirror_cond() {
		return veh_mirror_cond;
	}
	public void setVeh_mirror_cond(String veh_mirror_cond) {
		this.veh_mirror_cond = veh_mirror_cond;
	}
	public String getVeh_paint_transfer() {
		return veh_paint_transfer;
	}
	public void setVeh_paint_transfer(String veh_paint_transfer) {
		this.veh_paint_transfer = veh_paint_transfer;
	}
	public String getVeh_rear_parkingsensor() {
		return veh_rear_parkingsensor;
	}
	public void setVeh_rear_parkingsensor(String veh_rear_parkingsensor) {
		this.veh_rear_parkingsensor = veh_rear_parkingsensor;
	}
	public String getVeh_rear_parkingsensor_works() {
		return veh_rear_parkingsensor_works;
	}
	public void setVeh_rear_parkingsensor_works(String veh_rear_parkingsensor_works) {
		this.veh_rear_parkingsensor_works = veh_rear_parkingsensor_works;
	}
	public String getVeh_speed_limiter() {
		return veh_speed_limiter;
	}
	public void setVeh_speed_limiter(String veh_speed_limiter) {
		this.veh_speed_limiter = veh_speed_limiter;
	}
	public String getVeh_speed_limiter_functional() {
		return veh_speed_limiter_functional;
	}
	public void setVeh_speed_limiter_functional(String veh_speed_limiter_functional) {
		this.veh_speed_limiter_functional = veh_speed_limiter_functional;
	}
	public String getVeh_steer_cond() {
		return veh_steer_cond;
	}
	public void setVeh_steer_cond(String veh_steer_cond) {
		this.veh_steer_cond = veh_steer_cond;
	}
	public String getVeh_tinted_glass() {
		return veh_tinted_glass;
	}
	public void setVeh_tinted_glass(String veh_tinted_glass) {
		this.veh_tinted_glass = veh_tinted_glass;
	}
	public String getVeh_tracking_devices() {
		return veh_tracking_devices;
	}
	public void setVeh_tracking_devices(String veh_tracking_devices) {
		this.veh_tracking_devices = veh_tracking_devices;
	}
	public String getVeh_tracking_devices_works() {
		return veh_tracking_devices_works;
	}
	public void setVeh_tracking_devices_works(String veh_tracking_devices_works) {
		this.veh_tracking_devices_works = veh_tracking_devices_works;
	}
	public String getVeh_type_scratch() {
		return veh_type_scratch;
	}
	public void setVeh_type_scratch(String veh_type_scratch) {
		this.veh_type_scratch = veh_type_scratch;
	}
	public String getVeh_tyre_condition() {
		return veh_tyre_condition;
	}
	public void setVeh_tyre_condition(String veh_tyre_condition) {
		this.veh_tyre_condition = veh_tyre_condition;
	}
	public String getVeh_wheel_cond() {
		return veh_wheel_cond;
	}
	public void setVeh_wheel_cond(String veh_wheel_cond) {
		this.veh_wheel_cond = veh_wheel_cond;
	}
	public String getVeh_window_cond() {
		return veh_window_cond;
	}
	public void setVeh_window_cond(String veh_window_cond) {
		this.veh_window_cond = veh_window_cond;
	}
	public String getVeh_wiper_cond() {
		return veh_wiper_cond;
	}
	public void setVeh_wiper_cond(String veh_wiper_cond) {
		this.veh_wiper_cond = veh_wiper_cond;
	}
	public String getVehicle_driven_by() {
		return vehicle_driven_by;
	}
	public void setVehicle_driven_by(String vehicle_driven_by) {
		this.vehicle_driven_by = vehicle_driven_by;
	}
	public String getVeh_rear_parkingsensor_reason() {
		return veh_rear_parkingsensor_reason;
	}
	public void setVeh_rear_parkingsensor_reason(String veh_rear_parkingsensor_reason) {
		this.veh_rear_parkingsensor_reason = veh_rear_parkingsensor_reason;
	}
	public String getWitness_check() {
		return witness_check;
	}
	public void setWitness_check(String witness_check) {
		this.witness_check = witness_check;
	}
	public String getSubmit_check() {
		return submit_check;
	}
	public void setSubmit_check(String submit_check) {
		this.submit_check = submit_check;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
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
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getDriver_license_suspended() {
		return driver_license_suspended;
	}
	public void setDriver_license_suspended(String driver_license_suspended) {
		this.driver_license_suspended = driver_license_suspended;
	}
	public String getDriverAge() {
		return driverAge;
	}
	public void setDriverAge(String driverAge) {
		this.driverAge = driverAge;
	}
	public String getSerDateOfBirth() {
		return serDateOfBirth;
	}
	public void setSerDateOfBirth(String serDateOfBirth) {
		this.serDateOfBirth = serDateOfBirth;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getDriverVehNumber() {
		return driverVehNumber;
	}
	public void setDriverVehNumber(String driverVehNumber) {
		this.driverVehNumber = driverVehNumber;
	}
	public String getVehOwner() {
		return vehOwner;
	}
	public void setVehOwner(String vehOwner) {
		this.vehOwner = vehOwner;
	}
	public String getOwnerAddr() {
		return ownerAddr;
	}
	public void setOwnerAddr(String ownerAddr) {
		this.ownerAddr = ownerAddr;
	}
	public String getDriverResidence() {
		return driverResidence;
	}
	public void setDriverResidence(String driverResidence) {
		this.driverResidence = driverResidence;
	}
	public String getSerRegistrationAuthority() {
		return serRegistrationAuthority;
	}
	public void setSerRegistrationAuthority(String serRegistrationAuthority) {
		this.serRegistrationAuthority = serRegistrationAuthority;
	}
	public String getSerMobileNumber() {
		return serMobileNumber;
	}
	public void setSerMobileNumber(String serMobileNumber) {
		this.serMobileNumber = serMobileNumber;
	}
	public String getDriverage() {
		return driverage;
	}
	public void setDriverage(String driverage) {
		this.driverage = driverage;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverDOB() {
		return driverDOB;
	}
	public void setDriverDOB(String driverDOB) {
		this.driverDOB = driverDOB;
	}
	public String getDriverOccupation() {
		return driverOccupation;
	}
	public void setDriverOccupation(String driverOccupation) {
		this.driverOccupation = driverOccupation;
	}
	public String getSerRegAuthority() {
		return serRegAuthority;
	}
	public void setSerRegAuthority(String serRegAuthority) {
		this.serRegAuthority = serRegAuthority;
	}
	public String getContactNumberOfOwner() {
		return contactNumberOfOwner;
	}
	public void setContactNumberOfOwner(String contactNumberOfOwner) {
		this.contactNumberOfOwner = contactNumberOfOwner;
	}
	public String getNameOfTheDriver() {
		return nameOfTheDriver;
	}
	public void setNameOfTheDriver(String nameOfTheDriver) {
		this.nameOfTheDriver = nameOfTheDriver;
	}
	public String getDriverMobileno() {
		return driverMobileno;
	}
	public void setDriverMobileno(String driverMobileno) {
		this.driverMobileno = driverMobileno;
	}
	public String getAddressOfDriver() {
		return addressOfDriver;
	}
	public void setAddressOfDriver(String addressOfDriver) {
		this.addressOfDriver = addressOfDriver;
	}
	public String getDriverContactNumber() {
		return driverContactNumber;
	}
	public void setDriverContactNumber(String driverContactNumber) {
		this.driverContactNumber = driverContactNumber;
	}
	public String getInsurancePolicyNumber() {
		return insurancePolicyNumber;
	}
	public void setInsurancePolicyNumber(String insurancePolicyNumber) {
		this.insurancePolicyNumber = insurancePolicyNumber;
	}
	public String getPeriodOfInsurancePolicy() {
		return periodOfInsurancePolicy;
	}
	public void setPeriodOfInsurancePolicy(String periodOfInsurancePolicy) {
		this.periodOfInsurancePolicy = periodOfInsurancePolicy;
	}
	public String getNameOfInsuranceCompany() {
		return nameOfInsuranceCompany;
	}
	public void setNameOfInsuranceCompany(String nameOfInsuranceCompany) {
		this.nameOfInsuranceCompany = nameOfInsuranceCompany;
	}
	public String getAddressOfInsuranceCompany() {
		return addressOfInsuranceCompany;
	}
	public void setAddressOfInsuranceCompany(String addressOfInsuranceCompany) {
		this.addressOfInsuranceCompany = addressOfInsuranceCompany;
	}
	public String getSerGender() {
		return serGender;
	}
	public void setSerGender(String serGender) {
		this.serGender = serGender;
	}
	public String getOfficer_name() {
		return officer_name;
	}
	public void setOfficer_name(String officer_name) {
		this.officer_name = officer_name;
	}
	public String getTrans_vehicle_reg_no() {
		return trans_vehicle_reg_no;
	}
	public void setTrans_vehicle_reg_no(String trans_vehicle_reg_no) {
		this.trans_vehicle_reg_no = trans_vehicle_reg_no;
	}
	public String getRegno_status() {
		return regno_status;
	}
	public void setRegno_status(String regno_status) {
		this.regno_status = regno_status;
	}
	public String getRegno_type() {
		return regno_type;
	}
	public void setRegno_type(String regno_type) {
		this.regno_type = regno_type;
	}
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getTemp_regno_validity() {
		return temp_regno_validity;
	}
	public void setTemp_regno_validity(String temp_regno_validity) {
		this.temp_regno_validity = temp_regno_validity;
	}
	public String getVclass() {
		return vclass;
	}
	public void setVclass(String vclass) {
		this.vclass = vclass;
	}
	public String getVtype() {
		return vtype;
	}
	public void setVtype(String vtype) {
		this.vtype = vtype;
	}
	public String getVowneraddr() {
		return vowneraddr;
	}
	public void setVowneraddr(String vowneraddr) {
		this.vowneraddr = vowneraddr;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getMakeclass() {
		return makeclass;
	}
	public void setMakeclass(String makeclass) {
		this.makeclass = makeclass;
	}
	public String getYearofmanfac() {
		return yearofmanfac;
	}
	public void setYearofmanfac(String yearofmanfac) {
		this.yearofmanfac = yearofmanfac;
	}
	public String getVage() {
		return vage;
	}
	public void setVage(String vage) {
		this.vage = vage;
	}
	public String getEngineno() {
		return engineno;
	}
	public void setEngineno(String engineno) {
		this.engineno = engineno;
	}
	public String getChassisno() {
		return chassisno;
	}
	public void setChassisno(String chassisno) {
		this.chassisno = chassisno;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMax_speed() {
		return max_speed;
	}
	public void setMax_speed(String max_speed) {
		this.max_speed = max_speed;
	}
	public String getVdescription() {
		return vdescription;
	}
	public void setVdescription(String vdescription) {
		this.vdescription = vdescription;
	}
	public String getPermitcat() {
		return permitcat;
	}
	public void setPermitcat(String permitcat) {
		this.permitcat = permitcat;
	}
	public String getPermitno() {
		return permitno;
	}
	public void setPermitno(String permitno) {
		this.permitno = permitno;
	}
	public String getPermitvalidity() {
		return permitvalidity;
	}
	public void setPermitvalidity(String permitvalidity) {
		this.permitvalidity = permitvalidity;
	}
	public String getPermitissuedby() {
		return permitissuedby;
	}
	public void setPermitissuedby(String permitissuedby) {
		this.permitissuedby = permitissuedby;
	}
	public String getFitcertstatus() {
		return fitcertstatus;
	}
	public void setFitcertstatus(String fitcertstatus) {
		this.fitcertstatus = fitcertstatus;
	}
	public String getFitcertval() {
		return fitcertval;
	}
	public void setFitcertval(String fitcertval) {
		this.fitcertval = fitcertval;
	}
	public String getRegcrtval() {
		return regcrtval;
	}
	public void setRegcrtval(String regcrtval) {
		this.regcrtval = regcrtval;
	}
	public String getPolctrlcertval() {
		return polctrlcertval;
	}
	public void setPolctrlcertval(String polctrlcertval) {
		this.polctrlcertval = polctrlcertval;
	}
	public String getInsComAddr() {
		return insComAddr;
	}
	public void setInsComAddr(String insComAddr) {
		this.insComAddr = insComAddr;
	}
	public String getOwnerOccupation() {
		return ownerOccupation;
	}
	public void setOwnerOccupation(String ownerOccupation) {
		this.ownerOccupation = ownerOccupation;
	}
	public String getOwnerFatherName() {
		return ownerFatherName;
	}
	public void setOwnerFatherName(String ownerFatherName) {
		this.ownerFatherName = ownerFatherName;
	}
	public String getDriverFatherName() {
		return driverFatherName;
	}
	public void setDriverFatherName(String driverFatherName) {
		this.driverFatherName = driverFatherName;
	}
	public String getDriverLicenceValidity() {
		return driverLicenceValidity;
	}
	public void setDriverLicenceValidity(String driverLicenceValidity) {
		this.driverLicenceValidity = driverLicenceValidity;
	}
	public String getDriverLicensingAuthority() {
		return driverLicensingAuthority;
	}
	public void setDriverLicensingAuthority(String driverLicensingAuthority) {
		this.driverLicensingAuthority = driverLicensingAuthority;
	}
	public String getOwnerInsNo() {
		return ownerInsNo;
	}
	public void setOwnerInsNo(String ownerInsNo) {
		this.ownerInsNo = ownerInsNo;
	}
	public String getOwnerInsVal() {
		return ownerInsVal;
	}
	public void setOwnerInsVal(String ownerInsVal) {
		this.ownerInsVal = ownerInsVal;
	}
	public String getOwnerInsDetails() {
		return ownerInsDetails;
	}
	public void setOwnerInsDetails(String ownerInsDetails) {
		this.ownerInsDetails = ownerInsDetails;
	}
	public String getMvi_name() {
		return mvi_name;
	}
	public void setMvi_name(String mvi_name) {
		this.mvi_name = mvi_name;
	}
	public String getMvi_req_dt() {
		return mvi_req_dt;
	}
	public void setMvi_req_dt(String mvi_req_dt) {
		this.mvi_req_dt = mvi_req_dt;
	}
	public String getSkidmark() {
		return skidmark;
	}
	public void setSkidmark(String skidmark) {
		this.skidmark = skidmark;
	}
	public String getTrackmark() {
		return trackmark;
	}
	public void setTrackmark(String trackmark) {
		this.trackmark = trackmark;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getRegnoValidity() {
		return regnoValidity;
	}
	public void setRegnoValidity(String regnoValidity) {
		this.regnoValidity = regnoValidity;
	}
	public String getReqDateTime() {
		return reqDateTime;
	}
	public void setReqDateTime(String reqDateTime) {
		this.reqDateTime = reqDateTime;
	}
	public String getResDateTime() {
		return resDateTime;
	}
	public void setResDateTime(String resDateTime) {
		this.resDateTime = resDateTime;
	}
	public String getResOfficer() {
		return resOfficer;
	}
	public void setResOfficer(String resOfficer) {
		this.resOfficer = resOfficer;
	}
	public String getDetailsOfSurgeries() {
		return detailsOfSurgeries;
	}
	public void setDetailsOfSurgeries(String detailsOfSurgeries) {
		this.detailsOfSurgeries = detailsOfSurgeries;
	}
	public String getAnyPermanentDisability() {
		return anyPermanentDisability;
	}
	public void setAnyPermanentDisability(String anyPermanentDisability) {
		this.anyPermanentDisability = anyPermanentDisability;
	}
	public String getInjuredGotReimbursement() {
		return injuredGotReimbursement;
	}
	public void setInjuredGotReimbursement(String injuredGotReimbursement) {
		this.injuredGotReimbursement = injuredGotReimbursement;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFamilyAge() {
		return familyAge;
	}
	public void setFamilyAge(String familyAge) {
		this.familyAge = familyAge;
	}
	public String getFamilyGender() {
		return familyGender;
	}
	public void setFamilyGender(String familyGender) {
		this.familyGender = familyGender;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getCashlessTreatment() {
		return cashlessTreatment;
	}
	public void setCashlessTreatment(String cashlessTreatment) {
		this.cashlessTreatment = cashlessTreatment;
	}
	public String getCashlessTreatmentDetails() {
		return cashlessTreatmentDetails;
	}
	public void setCashlessTreatmentDetails(String cashlessTreatmentDetails) {
		this.cashlessTreatmentDetails = cashlessTreatmentDetails;
	}
	public String getAmntOfReliefClaimed() {
		return amntOfReliefClaimed;
	}
	public void setAmntOfReliefClaimed(String amntOfReliefClaimed) {
		this.amntOfReliefClaimed = amntOfReliefClaimed;
	}
	public String getFutureProspects() {
		return futureProspects;
	}
	public void setFutureProspects(String futureProspects) {
		this.futureProspects = futureProspects;
	}
	public String getMedicalExpenses() {
		return medicalExpenses;
	}
	public void setMedicalExpenses(String medicalExpenses) {
		this.medicalExpenses = medicalExpenses;
	}
	public String getFuneralExpenses() {
		return funeralExpenses;
	}
	public void setFuneralExpenses(String funeralExpenses) {
		this.funeralExpenses = funeralExpenses;
	}
	public String getOtherPecuniaryLossForDeath() {
		return otherPecuniaryLossForDeath;
	}
	public void setOtherPecuniaryLossForDeath(String otherPecuniaryLossForDeath) {
		this.otherPecuniaryLossForDeath = otherPecuniaryLossForDeath;
	}
	public String getLossOfConsortium() {
		return lossOfConsortium;
	}
	public void setLossOfConsortium(String lossOfConsortium) {
		this.lossOfConsortium = lossOfConsortium;
	}
	public String getLossOfLoveAndAffection() {
		return lossOfLoveAndAffection;
	}
	public void setLossOfLoveAndAffection(String lossOfLoveAndAffection) {
		this.lossOfLoveAndAffection = lossOfLoveAndAffection;
	}
	public String getLossOfEstate() {
		return lossOfEstate;
	}
	public void setLossOfEstate(String lossOfEstate) {
		this.lossOfEstate = lossOfEstate;
	}
	public String getOtherNonPecuniaryLoss() {
		return otherNonPecuniaryLoss;
	}
	public void setOtherNonPecuniaryLoss(String otherNonPecuniaryLoss) {
		this.otherNonPecuniaryLoss = otherNonPecuniaryLoss;
	}
	public String getNameOfInjured() {
		return nameOfInjured;
	}
	public void setNameOfInjured(String nameOfInjured) {
		this.nameOfInjured = nameOfInjured;
	}
	public String getInjFatherName() {
		return injFatherName;
	}
	public void setInjFatherName(String injFatherName) {
		this.injFatherName = injFatherName;
	}
	public String getInjAddress() {
		return injAddress;
	}
	public void setInjAddress(String injAddress) {
		this.injAddress = injAddress;
	}
	public String getInjContactNumber() {
		return injContactNumber;
	}
	public void setInjContactNumber(String injContactNumber) {
		this.injContactNumber = injContactNumber;
	}
	public String getInjAge() {
		return injAge;
	}
	public void setInjAge(String injAge) {
		this.injAge = injAge;
	}
	public String getInjDob() {
		return injDob;
	}
	public void setInjDob(String injDob) {
		this.injDob = injDob;
	}
	public String getInjGender() {
		return injGender;
	}
	public void setInjGender(String injGender) {
		this.injGender = injGender;
	}
	public String getInjMaritalStatus() {
		return injMaritalStatus;
	}
	public void setInjMaritalStatus(String injMaritalStatus) {
		this.injMaritalStatus = injMaritalStatus;
	}
	public String getInjOccupation() {
		return injOccupation;
	}
	public void setInjOccupation(String injOccupation) {
		this.injOccupation = injOccupation;
	}
	public String getInjEmployed() {
		return injEmployed;
	}
	public void setInjEmployed(String injEmployed) {
		this.injEmployed = injEmployed;
	}
	public String getInjEmployerNameAndAddr() {
		return injEmployerNameAndAddr;
	}
	public void setInjEmployerNameAndAddr(String injEmployerNameAndAddr) {
		this.injEmployerNameAndAddr = injEmployerNameAndAddr;
	}
	public String getInjIncome() {
		return injIncome;
	}
	public void setInjIncome(String injIncome) {
		this.injIncome = injIncome;
	}
	public String getInjIncomeTax() {
		return injIncomeTax;
	}
	public void setInjIncomeTax(String injIncomeTax) {
		this.injIncomeTax = injIncomeTax;
	}
	public String getInjNatureDescription() {
		return injNatureDescription;
	}
	public void setInjNatureDescription(String injNatureDescription) {
		this.injNatureDescription = injNatureDescription;
	}
	public String getInjmedicalTrtmnt() {
		return injmedicalTrtmnt;
	}
	public void setInjmedicalTrtmnt(String injmedicalTrtmnt) {
		this.injmedicalTrtmnt = injmedicalTrtmnt;
	}
	public String getInjnameOfHospital() {
		return injnameOfHospital;
	}
	public void setInjnameOfHospital(String injnameOfHospital) {
		this.injnameOfHospital = injnameOfHospital;
	}
	public String getInjhospitalizationPeriod() {
		return injhospitalizationPeriod;
	}
	public void setInjhospitalizationPeriod(String injhospitalizationPeriod) {
		this.injhospitalizationPeriod = injhospitalizationPeriod;
	}
	public String getInjdoctorName() {
		return injdoctorName;
	}
	public void setInjdoctorName(String injdoctorName) {
		this.injdoctorName = injdoctorName;
	}
	public String getInjdetailsOfSurgery() {
		return injdetailsOfSurgery;
	}
	public void setInjdetailsOfSurgery(String injdetailsOfSurgery) {
		this.injdetailsOfSurgery = injdetailsOfSurgery;
	}
	public String getInjpermanentDiability() {
		return injpermanentDiability;
	}
	public void setInjpermanentDiability(String injpermanentDiability) {
		this.injpermanentDiability = injpermanentDiability;
	}
	public String getInjDiabilityDetails() {
		return injDiabilityDetails;
	}
	public void setInjDiabilityDetails(String injDiabilityDetails) {
		this.injDiabilityDetails = injDiabilityDetails;
	}
	public String getLossOfEarningCapacity() {
		return lossOfEarningCapacity;
	}
	public void setLossOfEarningCapacity(String lossOfEarningCapacity) {
		this.lossOfEarningCapacity = lossOfEarningCapacity;
	}
	public String getExpenditureOnTreatment() {
		return expenditureOnTreatment;
	}
	public void setExpenditureOnTreatment(String expenditureOnTreatment) {
		this.expenditureOnTreatment = expenditureOnTreatment;
	}
	public String getTreatmentStillContinuing() {
		return treatmentStillContinuing;
	}
	public void setTreatmentStillContinuing(String treatmentStillContinuing) {
		this.treatmentStillContinuing = treatmentStillContinuing;
	}
	public String getExpenditureOnConveyance() {
		return expenditureOnConveyance;
	}
	public void setExpenditureOnConveyance(String expenditureOnConveyance) {
		this.expenditureOnConveyance = expenditureOnConveyance;
	}
	public String getLossOfIncome() {
		return lossOfIncome;
	}
	public void setLossOfIncome(String lossOfIncome) {
		this.lossOfIncome = lossOfIncome;
	}
	public String getLossOfearningCapacity() {
		return lossOfearningCapacity;
	}
	public void setLossOfearningCapacity(String lossOfearningCapacity) {
		this.lossOfearningCapacity = lossOfearningCapacity;
	}
	public String getOtherPecuniaryLoss() {
		return otherPecuniaryLoss;
	}
	public void setOtherPecuniaryLoss(String otherPecuniaryLoss) {
		this.otherPecuniaryLoss = otherPecuniaryLoss;
	}
	public String getInjuredReimbursement() {
		return injuredReimbursement;
	}
	public void setInjuredReimbursement(String injuredReimbursement) {
		this.injuredReimbursement = injuredReimbursement;
	}
	public String getInjuredReimbursementDetails() {
		return injuredReimbursementDetails;
	}
	public void setInjuredReimbursementDetails(String injuredReimbursementDetails) {
		this.injuredReimbursementDetails = injuredReimbursementDetails;
	}
	public String getLossDamageToProperty() {
		return lossDamageToProperty;
	}
	public void setLossDamageToProperty(String lossDamageToProperty) {
		this.lossDamageToProperty = lossDamageToProperty;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public String getValueOfLoss() {
		return valueOfLoss;
	}
	public void setValueOfLoss(String valueOfLoss) {
		this.valueOfLoss = valueOfLoss;
	}
	public String getBriefDescriptionOfAccident() {
		return briefDescriptionOfAccident;
	}
	public void setBriefDescriptionOfAccident(String briefDescriptionOfAccident) {
		this.briefDescriptionOfAccident = briefDescriptionOfAccident;
	}
	public String getCompensationClaimed() {
		return compensationClaimed;
	}
	public void setCompensationClaimed(String compensationClaimed) {
		this.compensationClaimed = compensationClaimed;
	}
	public String getOtherLossSpclTrmnt() {
		return otherLossSpclTrmnt;
	}
	public void setOtherLossSpclTrmnt(String otherLossSpclTrmnt) {
		this.otherLossSpclTrmnt = otherLossSpclTrmnt;
	}
	public String getPercentageOfDisability() {
		return percentageOfDisability;
	}
	public void setPercentageOfDisability(String percentageOfDisability) {
		this.percentageOfDisability = percentageOfDisability;
	}
	public String getPainAndSuffering() {
		return painAndSuffering;
	}
	public void setPainAndSuffering(String painAndSuffering) {
		this.painAndSuffering = painAndSuffering;
	}
	public String getLossOfAmenties() {
		return lossOfAmenties;
	}
	public void setLossOfAmenties(String lossOfAmenties) {
		this.lossOfAmenties = lossOfAmenties;
	}
	public String getDisfiguration() {
		return disfiguration;
	}
	public void setDisfiguration(String disfiguration) {
		this.disfiguration = disfiguration;
	}
	public String getLossOfMargProspects() {
		return lossOfMargProspects;
	}
	public void setLossOfMargProspects(String lossOfMargProspects) {
		this.lossOfMargProspects = lossOfMargProspects;
	}
	public String getLossOfReputation() {
		return lossOfReputation;
	}
	public void setLossOfReputation(String lossOfReputation) {
		this.lossOfReputation = lossOfReputation;
	}
	public String getNonPecuniaryLoss() {
		return nonPecuniaryLoss;
	}
	public void setNonPecuniaryLoss(String nonPecuniaryLoss) {
		this.nonPecuniaryLoss = nonPecuniaryLoss;
	}
	public String getTotalLossSuffered() {
		return totalLossSuffered;
	}
	public void setTotalLossSuffered(String totalLossSuffered) {
		this.totalLossSuffered = totalLossSuffered;
	}
	public String getNameOfChild() {
		return nameOfChild;
	}
	public void setNameOfChild(String nameOfChild) {
		this.nameOfChild = nameOfChild;
	}
	public String getDetailsOfSchool() {
		return detailsOfSchool;
	}
	public void setDetailsOfSchool(String detailsOfSchool) {
		this.detailsOfSchool = detailsOfSchool;
	}
	public String getDetailsOfClass() {
		return detailsOfClass;
	}
	public void setDetailsOfClass(String detailsOfClass) {
		this.detailsOfClass = detailsOfClass;
	}
	public String getAnnualSchoolFee() {
		return annualSchoolFee;
	}
	public void setAnnualSchoolFee(String annualSchoolFee) {
		this.annualSchoolFee = annualSchoolFee;
	}
	public String getApproxExpenditure() {
		return approxExpenditure;
	}
	public void setApproxExpenditure(String approxExpenditure) {
		this.approxExpenditure = approxExpenditure;
	}
	public String getLaName() {
		return laName;
	}
	public void setLaName(String laName) {
		this.laName = laName;
	}
	public String getLaAgeDob() {
		return laAgeDob;
	}
	public void setLaAgeDob(String laAgeDob) {
		this.laAgeDob = laAgeDob;
	}
	public String getLaGender() {
		return laGender;
	}
	public void setLaGender(String laGender) {
		this.laGender = laGender;
	}
	public String getLaRelation() {
		return laRelation;
	}
	public void setLaRelation(String laRelation) {
		this.laRelation = laRelation;
	}
	public String getLaStatus() {
		return laStatus;
	}
	public void setLaStatus(String laStatus) {
		this.laStatus = laStatus;
	}
	public String getLaAddress() {
		return laAddress;
	}
	public void setLaAddress(String laAddress) {
		this.laAddress = laAddress;
	}
	public String getLaContact() {
		return laContact;
	}
	public void setLaContact(String laContact) {
		this.laContact = laContact;
	}
	public String getNatureOfCase() {
		return natureOfCase;
	}
	public void setNatureOfCase(String natureOfCase) {
		this.natureOfCase = natureOfCase;
	}
	public String getOffRegNo() {
		return offRegNo;
	}
	public void setOffRegNo(String offRegNo) {
		this.offRegNo = offRegNo;
	}
	public String getOffVehType() {
		return offVehType;
	}
	public void setOffVehType(String offVehType) {
		this.offVehType = offVehType;
	}
	public String getOffOwnNAme() {
		return offOwnNAme;
	}
	public void setOffOwnNAme(String offOwnNAme) {
		this.offOwnNAme = offOwnNAme;
	}
	public String getOffOwnAdd() {
		return offOwnAdd;
	}
	public void setOffOwnAdd(String offOwnAdd) {
		this.offOwnAdd = offOwnAdd;
	}
	public String getOffOwnNumber() {
		return offOwnNumber;
	}
	public void setOffOwnNumber(String offOwnNumber) {
		this.offOwnNumber = offOwnNumber;
	}
	public String getOffdriName() {
		return offdriName;
	}
	public void setOffdriName(String offdriName) {
		this.offdriName = offdriName;
	}
	public String getOffDriAdd() {
		return offDriAdd;
	}
	public void setOffDriAdd(String offDriAdd) {
		this.offDriAdd = offDriAdd;
	}
	public String getOffDriNumber() {
		return offDriNumber;
	}
	public void setOffDriNumber(String offDriNumber) {
		this.offDriNumber = offDriNumber;
	}
	public String getOffInsName() {
		return offInsName;
	}
	public void setOffInsName(String offInsName) {
		this.offInsName = offInsName;
	}
	public String getOffInsAdd() {
		return offInsAdd;
	}
	public void setOffInsAdd(String offInsAdd) {
		this.offInsAdd = offInsAdd;
	}
	public String getOffInsNumber() {
		return offInsNumber;
	}
	public void setOffInsNumber(String offInsNumber) {
		this.offInsNumber = offInsNumber;
	}
	public String getOffInsPolNumber() {
		return offInsPolNumber;
	}
	public void setOffInsPolNumber(String offInsPolNumber) {
		this.offInsPolNumber = offInsPolNumber;
	}
	public String getOffInsPolType() {
		return offInsPolType;
	}
	public void setOffInsPolType(String offInsPolType) {
		this.offInsPolType = offInsPolType;
	}
	public String getOffInsPolExpDate() {
		return offInsPolExpDate;
	}
	public void setOffInsPolExpDate(String offInsPolExpDate) {
		this.offInsPolExpDate = offInsPolExpDate;
	}
	public String getVehRegNo() {
		return vehRegNo;
	}
	public void setVehRegNo(String vehRegNo) {
		this.vehRegNo = vehRegNo;
	}
	public String getVehType() {
		return vehType;
	}
	public void setVehType(String vehType) {
		this.vehType = vehType;
	}
	public String getNameOfDriver() {
		return nameOfDriver;
	}
	public void setNameOfDriver(String nameOfDriver) {
		this.nameOfDriver = nameOfDriver;
	}
	public String getAddrOfDriver() {
		return addrOfDriver;
	}
	public void setAddrOfDriver(String addrOfDriver) {
		this.addrOfDriver = addrOfDriver;
	}
	public String getNameOfOwner() {
		return nameOfOwner;
	}
	public void setNameOfOwner(String nameOfOwner) {
		this.nameOfOwner = nameOfOwner;
	}
	public String getAddOfOwner() {
		return addOfOwner;
	}
	public void setAddOfOwner(String addOfOwner) {
		this.addOfOwner = addOfOwner;
	}
	public String getNameOfInsComp() {
		return nameOfInsComp;
	}
	public void setNameOfInsComp(String nameOfInsComp) {
		this.nameOfInsComp = nameOfInsComp;
	}
	public String getAddOfInsComp() {
		return addOfInsComp;
	}
	public void setAddOfInsComp(String addOfInsComp) {
		this.addOfInsComp = addOfInsComp;
	}
	public String getInvolvedInAccident() {
		return involvedInAccident;
	}
	public void setInvolvedInAccident(String involvedInAccident) {
		this.involvedInAccident = involvedInAccident;
	}
	public String getInvolvedInAccidentName() {
		return involvedInAccidentName;
	}
	public void setInvolvedInAccidentName(String involvedInAccidentName) {
		this.involvedInAccidentName = involvedInAccidentName;
	}
	public String getPlaceOfStartingJourney() {
		return placeOfStartingJourney;
	}
	public void setPlaceOfStartingJourney(String placeOfStartingJourney) {
		this.placeOfStartingJourney = placeOfStartingJourney;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getBriefDesAccident() {
		return briefDesAccident;
	}
	public void setBriefDesAccident(String briefDesAccident) {
		this.briefDesAccident = briefDesAccident;
	}
	public String getDeceasedName() {
		return deceasedName;
	}
	public void setDeceasedName(String deceasedName) {
		this.deceasedName = deceasedName;
	}
	public String getDeceasedFatherOrSpouseName() {
		return deceasedFatherOrSpouseName;
	}
	public void setDeceasedFatherOrSpouseName(String deceasedFatherOrSpouseName) {
		this.deceasedFatherOrSpouseName = deceasedFatherOrSpouseName;
	}
	public String getDeceasedAge() {
		return deceasedAge;
	}
	public void setDeceasedAge(String deceasedAge) {
		this.deceasedAge = deceasedAge;
	}
	public String getDeceasedDob() {
		return deceasedDob;
	}
	public void setDeceasedDob(String deceasedDob) {
		this.deceasedDob = deceasedDob;
	}
	public String getDeceasedGender() {
		return deceasedGender;
	}
	public void setDeceasedGender(String deceasedGender) {
		this.deceasedGender = deceasedGender;
	}
	public String getDeceasedStatus() {
		return deceasedStatus;
	}
	public void setDeceasedStatus(String deceasedStatus) {
		this.deceasedStatus = deceasedStatus;
	}
	public String getDeceasedOccupation() {
		return deceasedOccupation;
	}
	public void setDeceasedOccupation(String deceasedOccupation) {
		this.deceasedOccupation = deceasedOccupation;
	}
	public String getDeceasedEmployed() {
		return deceasedEmployed;
	}
	public void setDeceasedEmployed(String deceasedEmployed) {
		this.deceasedEmployed = deceasedEmployed;
	}
	public String getDeceasedEmployerNameAndAddr() {
		return deceasedEmployerNameAndAddr;
	}
	public void setDeceasedEmployerNameAndAddr(String deceasedEmployerNameAndAddr) {
		this.deceasedEmployerNameAndAddr = deceasedEmployerNameAndAddr;
	}
	public String getDeceasedIncome() {
		return deceasedIncome;
	}
	public void setDeceasedIncome(String deceasedIncome) {
		this.deceasedIncome = deceasedIncome;
	}
	public String getDeceasedIncomeTax() {
		return deceasedIncomeTax;
	}
	public void setDeceasedIncomeTax(String deceasedIncomeTax) {
		this.deceasedIncomeTax = deceasedIncomeTax;
	}
	public String getDeceasedIncomeTax3Years() {
		return deceasedIncomeTax3Years;
	}
	public void setDeceasedIncomeTax3Years(String deceasedIncomeTax3Years) {
		this.deceasedIncomeTax3Years = deceasedIncomeTax3Years;
	}
	public String getDtFilingFar() {
		return dtFilingFar;
	}
	public void setDtFilingFar(String dtFilingFar) {
		this.dtFilingFar = dtFilingFar;
	}
	public String getDtUploadingFar() {
		return dtUploadingFar;
	}
	public void setDtUploadingFar(String dtUploadingFar) {
		this.dtUploadingFar = dtUploadingFar;
	}
	public String getDtDeliveryFirFarToInscompany() {
		return dtDeliveryFirFarToInscompany;
	}
	public void setDtDeliveryFirFarToInscompany(String dtDeliveryFirFarToInscompany) {
		this.dtDeliveryFirFarToInscompany = dtDeliveryFirFarToInscompany;
	}
	public String getDtDeliveryFirForm2FarToVictim() {
		return dtDeliveryFirForm2FarToVictim;
	}
	public void setDtDeliveryFirForm2FarToVictim(String dtDeliveryFirForm2FarToVictim) {
		this.dtDeliveryFirForm2FarToVictim = dtDeliveryFirForm2FarToVictim;
	}
	public String getDtReceiptForm3FromDriver() {
		return dtReceiptForm3FromDriver;
	}
	public void setDtReceiptForm3FromDriver(String dtReceiptForm3FromDriver) {
		this.dtReceiptForm3FromDriver = dtReceiptForm3FromDriver;
	}
	public String getDtReceiptForm4From_owner() {
		return dtReceiptForm4From_owner;
	}
	public void setDtReceiptForm4From_owner(String dtReceiptForm4From_owner) {
		this.dtReceiptForm4From_owner = dtReceiptForm4From_owner;
	}
	public String getDtDeliveryForm3Form4ToInscompany() {
		return dtDeliveryForm3Form4ToInscompany;
	}
	public void setDtDeliveryForm3Form4ToInscompany(String dtDeliveryForm3Form4ToInscompany) {
		this.dtDeliveryForm3Form4ToInscompany = dtDeliveryForm3Form4ToInscompany;
	}
	public String getDtDeliveryForm3Form4ToVictim() {
		return dtDeliveryForm3Form4ToVictim;
	}
	public void setDtDeliveryForm3Form4ToVictim(String dtDeliveryForm3Form4ToVictim) {
		this.dtDeliveryForm3Form4ToVictim = dtDeliveryForm3Form4ToVictim;
	}
	public String getDocOfDriverOrOwner() {
		return docOfDriverOrOwner;
	}
	public void setDocOfDriverOrOwner(String docOfDriverOrOwner) {
		this.docOfDriverOrOwner = docOfDriverOrOwner;
	}
	public String getDocOfDriverOrOwnerVerified() {
		return docOfDriverOrOwnerVerified;
	}
	public void setDocOfDriverOrOwnerVerified(String docOfDriverOrOwnerVerified) {
		this.docOfDriverOrOwnerVerified = docOfDriverOrOwnerVerified;
	}
	public String getDriverLicenseType() {
		return driverLicenseType;
	}
	public void setDriverLicenseType(String driverLicenseType) {
		this.driverLicenseType = driverLicenseType;
	}
	public String getDriverInjuredOrNot() {
		return driverInjuredOrNot;
	}
	public void setDriverInjuredOrNot(String driverInjuredOrNot) {
		this.driverInjuredOrNot = driverInjuredOrNot;
	}
	public String getPermitFitnessVerified() {
		return permitFitnessVerified;
	}
	public void setPermitFitnessVerified(String permitFitnessVerified) {
		this.permitFitnessVerified = permitFitnessVerified;
	}
	public String getPermitFitnessVerifiedReasons() {
		return permitFitnessVerifiedReasons;
	}
	public void setPermitFitnessVerifiedReasons(String permitFitnessVerifiedReasons) {
		this.permitFitnessVerifiedReasons = permitFitnessVerifiedReasons;
	}
	public String getOwnerReportedAccInsDate() {
		return ownerReportedAccInsDate;
	}
	public void setOwnerReportedAccInsDate(String ownerReportedAccInsDate) {
		this.ownerReportedAccInsDate = ownerReportedAccInsDate;
	}
	public String getVictimType() {
		return victimType;
	}
	public void setVictimType(String victimType) {
		this.victimType = victimType;
	}
	public String getOwnerVehicleType() {
		return ownerVehicleType;
	}
	public void setOwnerVehicleType(String ownerVehicleType) {
		this.ownerVehicleType = ownerVehicleType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInjurySeverity() {
		return injurySeverity;
	}
	public void setInjurySeverity(String injurySeverity) {
		this.injurySeverity = injurySeverity;
	}
	public String getNameOfDeceased() {
		return nameOfDeceased;
	}
	public void setNameOfDeceased(String nameOfDeceased) {
		this.nameOfDeceased = nameOfDeceased;
	}
	public String getAgeOfDeceased() {
		return ageOfDeceased;
	}
	public void setAgeOfDeceased(String ageOfDeceased) {
		this.ageOfDeceased = ageOfDeceased;
	}
	public String getOccupationOfDeceased() {
		return occupationOfDeceased;
	}
	public void setOccupationOfDeceased(String occupationOfDeceased) {
		this.occupationOfDeceased = occupationOfDeceased;
	}
	public String getFatherNameOfDeceased() {
		return fatherNameOfDeceased;
	}
	public void setFatherNameOfDeceased(String fatherNameOfDeceased) {
		this.fatherNameOfDeceased = fatherNameOfDeceased;
	}
	public String getGenderOfDeceased() {
		return genderOfDeceased;
	}
	public void setGenderOfDeceased(String genderOfDeceased) {
		this.genderOfDeceased = genderOfDeceased;
	}
	public String getMaritalstatusOfDeceased() {
		return maritalstatusOfDeceased;
	}
	public void setMaritalstatusOfDeceased(String maritalstatusOfDeceased) {
		this.maritalstatusOfDeceased = maritalstatusOfDeceased;
	}
	public String getNameAndAddressOfDeceased() {
		return nameAndAddressOfDeceased;
	}
	public void setNameAndAddressOfDeceased(String nameAndAddressOfDeceased) {
		this.nameAndAddressOfDeceased = nameAndAddressOfDeceased;
	}
	public String getIncomeOfDeceased() {
		return incomeOfDeceased;
	}
	public void setIncomeOfDeceased(String incomeOfDeceased) {
		this.incomeOfDeceased = incomeOfDeceased;
	}
	public String getAssesedToIncomeTaxDeceased() {
		return assesedToIncomeTaxDeceased;
	}
	public void setAssesedToIncomeTaxDeceased(String assesedToIncomeTaxDeceased) {
		this.assesedToIncomeTaxDeceased = assesedToIncomeTaxDeceased;
	}
	public String getSoleEarningMember() {
		return soleEarningMember;
	}
	public void setSoleEarningMember(String soleEarningMember) {
		this.soleEarningMember = soleEarningMember;
	}
	public String getMedicalExpensesIncurred() {
		return medicalExpensesIncurred;
	}
	public void setMedicalExpensesIncurred(String medicalExpensesIncurred) {
		this.medicalExpensesIncurred = medicalExpensesIncurred;
	}
	public String getReimbursement() {
		return reimbursement;
	}
	public void setReimbursement(String reimbursement) {
		this.reimbursement = reimbursement;
	}
	public String getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getRef_id() {
		return ref_id;
	}
	public void setRef_id(String ref_id) {
		this.ref_id = ref_id;
	}
	public String getDeceasedLegalRepName() {
		return deceasedLegalRepName;
	}
	public void setDeceasedLegalRepName(String deceasedLegalRepName) {
		this.deceasedLegalRepName = deceasedLegalRepName;
	}
	public String getDeceasedLegalRepRelation() {
		return deceasedLegalRepRelation;
	}
	public void setDeceasedLegalRepRelation(String deceasedLegalRepRelation) {
		this.deceasedLegalRepRelation = deceasedLegalRepRelation;
	}
	public String getDeceasedLegalRepAge() {
		return deceasedLegalRepAge;
	}
	public void setDeceasedLegalRepAge(String deceasedLegalRepAge) {
		this.deceasedLegalRepAge = deceasedLegalRepAge;
	}
	public String getDeceasedLegalRepGender() {
		return deceasedLegalRepGender;
	}
	public void setDeceasedLegalRepGender(String deceasedLegalRepGender) {
		this.deceasedLegalRepGender = deceasedLegalRepGender;
	}
	public String getDeceasedLegalRepMaritalStatus() {
		return deceasedLegalRepMaritalStatus;
	}
	public void setDeceasedLegalRepMaritalStatus(String deceasedLegalRepMaritalStatus) {
		this.deceasedLegalRepMaritalStatus = deceasedLegalRepMaritalStatus;
	}
	public String getDeceasedLegalRepContactNumber() {
		return deceasedLegalRepContactNumber;
	}
	public void setDeceasedLegalRepContactNumber(String deceasedLegalRepContactNumber) {
		this.deceasedLegalRepContactNumber = deceasedLegalRepContactNumber;
	}
	public String getDeceasedLegalRepAddress() {
		return deceasedLegalRepAddress;
	}
	public void setDeceasedLegalRepAddress(String deceasedLegalRepAddress) {
		this.deceasedLegalRepAddress = deceasedLegalRepAddress;
	}
	public String getInjLegalRepName() {
		return injLegalRepName;
	}
	public void setInjLegalRepName(String injLegalRepName) {
		this.injLegalRepName = injLegalRepName;
	}
	public String getInjLegalRepRelation() {
		return injLegalRepRelation;
	}
	public void setInjLegalRepRelation(String injLegalRepRelation) {
		this.injLegalRepRelation = injLegalRepRelation;
	}
	public String getInjLegalRepAge() {
		return injLegalRepAge;
	}
	public void setInjLegalRepAge(String injLegalRepAge) {
		this.injLegalRepAge = injLegalRepAge;
	}
	public String getInjLegalRepGender() {
		return injLegalRepGender;
	}
	public void setInjLegalRepGender(String injLegalRepGender) {
		this.injLegalRepGender = injLegalRepGender;
	}
	public String getInjLegalRepMaritalStatus() {
		return injLegalRepMaritalStatus;
	}
	public void setInjLegalRepMaritalStatus(String injLegalRepMaritalStatus) {
		this.injLegalRepMaritalStatus = injLegalRepMaritalStatus;
	}
	public String getInjLegalRepContactNumber() {
		return injLegalRepContactNumber;
	}
	public void setInjLegalRepContactNumber(String injLegalRepContactNumber) {
		this.injLegalRepContactNumber = injLegalRepContactNumber;
	}
	public String getInjLegalRepAddress() {
		return injLegalRepAddress;
	}
	public void setInjLegalRepAddress(String injLegalRepAddress) {
		this.injLegalRepAddress = injLegalRepAddress;
	}
	public String getInformantName() {
		return informantName;
	}
	public void setInformantName(String informantName) {
		this.informantName = informantName;
	}
	public String getInformerContactNumber() {
		return informerContactNumber;
	}
	public void setInformerContactNumber(String informerContactNumber) {
		this.informerContactNumber = informerContactNumber;
	}
	public String getInformerContactAddress() {
		return informerContactAddress;
	}
	public void setInformerContactAddress(String informerContactAddress) {
		this.informerContactAddress = informerContactAddress;
	}
	public String getNatureOfAccident() {
		return natureOfAccident;
	}
	public void setNatureOfAccident(String natureOfAccident) {
		this.natureOfAccident = natureOfAccident;
	}
	public String getVehImpoundedPolice() {
		return vehImpoundedPolice;
	}
	public void setVehImpoundedPolice(String vehImpoundedPolice) {
		this.vehImpoundedPolice = vehImpoundedPolice;
	}
	public String getOffendingVehSpotted() {
		return offendingVehSpotted;
	}
	public void setOffendingVehSpotted(String offendingVehSpotted) {
		this.offendingVehSpotted = offendingVehSpotted;
	}
	public String getRegnstatus() {
		return regnstatus;
	}
	public void setRegnstatus(String regnstatus) {
		this.regnstatus = regnstatus;
	}
	public String getHpname() {
		return hpname;
	}
	public void setHpname(String hpname) {
		this.hpname = hpname;
	}
	public String getHpaddress() {
		return hpaddress;
	}
	public void setHpaddress(String hpaddress) {
		this.hpaddress = hpaddress;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getDriRemainderDate() {
		return driRemainderDate;
	}
	public void setDriRemainderDate(String driRemainderDate) {
		this.driRemainderDate = driRemainderDate;
	}
	public String getOwnRemainderDate() {
		return OwnRemainderDate;
	}
	public void setOwnRemainderDate(String ownRemainderDate) {
		OwnRemainderDate = ownRemainderDate;
	}
	public String getVictimRemainderDate() {
		return victimRemainderDate;
	}
	public void setVictimRemainderDate(String victimRemainderDate) {
		this.victimRemainderDate = victimRemainderDate;
	}
	public String getRegAuthRemainderDate() {
		return regAuthRemainderDate;
	}
	public void setRegAuthRemainderDate(String regAuthRemainderDate) {
		this.regAuthRemainderDate = regAuthRemainderDate;
	}
	public String getHospitalRemainderDate() {
		return hospitalRemainderDate;
	}
	public void setHospitalRemainderDate(String hospitalRemainderDate) {
		this.hospitalRemainderDate = hospitalRemainderDate;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getDrivinglicencetype() {
		return drivinglicencetype;
	}
	public void setDrivinglicencetype(String drivinglicencetype) {
		this.drivinglicencetype = drivinglicencetype;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public List<WitnessDetails> getWitness() {
		return witness;
	}
	public void setWitness(List<WitnessDetails> witness) {
		this.witness = witness;
	}
	public List<DeceasedDetails> getDeceasedDetails() {
		return deceasedDetails;
	}
	public void setDeceasedDetails(List<DeceasedDetails> deceasedDetails) {
		this.deceasedDetails = deceasedDetails;
	}
	public List<VehicleAndDriverDetails> getVehicleAndDriver() {
		return vehicleAndDriver;
	}
	public void setVehicleAndDriver(List<VehicleAndDriverDetails> vehicleAndDriver) {
		this.vehicleAndDriver = vehicleAndDriver;
	}
	public List<InjuredAndDeseasedDetails> getInjuredAndDeseased() {
		return injuredAndDeseased;
	}
	public void setInjuredAndDeseased(List<InjuredAndDeseasedDetails> injuredAndDeseased) {
		this.injuredAndDeseased = injuredAndDeseased;
	}

	public List<MinorChildrenDetailsEntity1> getChildrenDetails() {
		return childrenDetails;
	}
	public void setChildrenDetails(List<MinorChildrenDetailsEntity1> childrenDetails) {
		this.childrenDetails = childrenDetails;
	}
	public InjuredDetails getInjuryDetails() {
		return injuryDetails;
	}
	public void setInjuryDetails(InjuredDetails injuryDetails) {
		this.injuryDetails = injuryDetails;
	}
	public String getVictimDetails() {
		return victimDetails;
	}
	public void setVictimDetails(String victimDetails) {
		this.victimDetails = victimDetails;
	}
	public AccidentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

	
    
}
