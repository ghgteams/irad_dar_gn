package com.irad.dar.pdf;

import java.util.List;

public class Pdf12Entity {
   	
 private String accidentId;	
 private String firNo;
 private String accidentDate;
 private String section;
 private String policeStationName;
 private String dateAndTime;
 private String offencePlace;
 private String natureOfInjurySufferedByVictim;
 private String offenceDescription;
 private String victimName;
 private String fatherOrSpouseName;
 private String age;
 private String gender;
 private String maritalStatus;
 private String permanentAddress;
 private String presentAddress;
 private String mobileNumber;
 private String emailId;
 private String state;
 private String district;
 private String injurySeverity;
 
 //deathcase
 private String deceasedName;
 private String deceasedFatherOrSpouseName;
 private String deceasedAge;
 private String deceasedGender;
 private String deceasedMaritalStatus;
 private String deceasedOccupation;
 private String deceasedIncome;
 
 private List<DeceasedLeagalRepresentatives> deceasedLegalRepresentatives;
 
 private String deceasedAddFutureProspects;
 private String deceasedLessPersonalExpenses;
 private String deceasedMonthlyLossDependency;
 private String AnnualLossDependency;
 private String deceasedMultiplier;
 private String deceasedTotalLossDependency;
 private String deceasedMedicalExpenses;
 private String deceasedFuneralExpenses;
 private String deceasedPecuniaryLossDamage;
 private String deceasedLossOfConsortium;
 private String deceasedLossOfLoveAffection;
 private String deceasedLossOfEstate;
 private String deceasedEmotionalHarmTaruma;
 private String deceasedPostTraumaticDisorder;
 private String deceasedOtherNonPecuniaryLoss;
 private String deceasedTotalLossSuffered;
 
 //injury case
 private String injuredName;
 private String injuredFatherOrSpouseName;
 private String injuredAge;
 private String injuredGender;
 private String injuredMaritalStatus;
 private String injuredOccupation;
 private String injuredIncome;
 private String injuryNatureAndDescription;
 private String injuredMedicalTreatment;
 private String hospitalNameAndHospitalizationPeriod;
 private String surgeriesDetails;
 private String permanentDisability;
 private String reimbursementOfMedicalExpenses;
 private List<InjuredLegalRepresentatives> injuredLegalRepresentatives;
 
 //pecuniary losses
 private String injuredExpenditureOnTreatment;
 private String injuredExpenditureOnConveyance;
 private String injuredExpenditureOnSpecialDiet;
 private String injuredExpenditureOnAttendant;
 private String injuredTreatmentExpenditureEstimation;
 private String injuredLossOfIncome;
 private String injuredSpecialTreatment;
 private String ijuredNatureOfDisability;
 private String injuredLossOfEarningCapacity;
 private String injuredLossOfFutureIncome;
 private String injuredPecuniaryLoss;

 //non-pecuniary losses
 private String injuredPainAndSuffering;
 private String injuredLossOfAmenities;
 private String injuredPostTraumaticDisorder;
 private String injuredEmotionalHarmTaruma;
 private String injuredDisfiguration;
 private String injuredLossOfMarriageProspects;
 private String injuredLossOfReputation;
 private String injuredOtherNonPecuniaryLoss;
 private String injuredTotalLossSuffered;
 
 //damagelossto the property
 private String propertyDamageDescription;
 private String lossSufferedValue;
 
 //Conduct of the accused
 private String accusedFledFromSpot;
 private String accusedReportedAccidentToPolice;
 private String accusedProvidedAssistanceToVictim;
 private String accusedTookVictimToHospital;
 private String accusedVisitedVictimAtHospital;
 private String accusedRemainedAtspot;
 private String accusedCooperatedInvestigation;
 private String accusedRemovedVehicleFromSpot;
 private String accusedPaidCompensation;
 private String accusedPreviousConvictions;
 private String accusedCloseRelative;
 private String accusedAge;
 private String accusedGender;
 private String accusedSufferedInjuries;
 private String accusedDischargedDuties;
 private String motorAccidentCase;
 private String firNumber;
 private String accusedPoliceStationName;
 private String driverFledFromSpot;
 private String accusedOtherConductInformation;
 
 //Apparent contributing circumstances
  private String apparentContributingCircumstances;
  private String aggressiveDriving;
  private String irresponsibleBehaviour;
  
  private String currentDate;
  private String psName;
  private String dateTime;
  
  private String firDateTime;
  private String act;
  private String roadDetails;
  
  private String accusedVictim;
  private String hospitalPeriod;
  
  private String landmarks;
  private String accidentDatetime;
  
  private String deceasedcapannualincome;
  private String deceasedmovableasset;
  private String deceasedimmovableasset;
  private String deceasedrecommendation;
  
  
  private String injuredcapannualincome;
  private String injuredmovableasset;
  private String injuredimmovableasset;
  private String injuredrecommendation;
  private String stateCode;
  
  private String emotionalHarm;
  private String damageLossProperty;
  private String anyOtherLoss;
  private String physicalHarm;
  
  private String propertyLossDamage;
  private String lossSuffered;
public String getAccidentId() {
	return accidentId;
}
public void setAccidentId(String accidentId) {
	this.accidentId = accidentId;
}
public String getFirNo() {
	return firNo;
}
public void setFirNo(String firNo) {
	this.firNo = firNo;
}
public String getAccidentDate() {
	return accidentDate;
}
public void setAccidentDate(String accidentDate) {
	this.accidentDate = accidentDate;
}
public String getSection() {
	return section;
}
public void setSection(String section) {
	this.section = section;
}
public String getPoliceStationName() {
	return policeStationName;
}
public void setPoliceStationName(String policeStationName) {
	this.policeStationName = policeStationName;
}
public String getDateAndTime() {
	return dateAndTime;
}
public void setDateAndTime(String dateAndTime) {
	this.dateAndTime = dateAndTime;
}
public String getOffencePlace() {
	return offencePlace;
}
public void setOffencePlace(String offencePlace) {
	this.offencePlace = offencePlace;
}
public String getNatureOfInjurySufferedByVictim() {
	return natureOfInjurySufferedByVictim;
}
public void setNatureOfInjurySufferedByVictim(String natureOfInjurySufferedByVictim) {
	this.natureOfInjurySufferedByVictim = natureOfInjurySufferedByVictim;
}
public String getOffenceDescription() {
	return offenceDescription;
}
public void setOffenceDescription(String offenceDescription) {
	this.offenceDescription = offenceDescription;
}
public String getVictimName() {
	return victimName;
}
public void setVictimName(String victimName) {
	this.victimName = victimName;
}
public String getFatherOrSpouseName() {
	return fatherOrSpouseName;
}
public void setFatherOrSpouseName(String fatherOrSpouseName) {
	this.fatherOrSpouseName = fatherOrSpouseName;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getMaritalStatus() {
	return maritalStatus;
}
public void setMaritalStatus(String maritalStatus) {
	this.maritalStatus = maritalStatus;
}
public String getPermanentAddress() {
	return permanentAddress;
}
public void setPermanentAddress(String permanentAddress) {
	this.permanentAddress = permanentAddress;
}
public String getPresentAddress() {
	return presentAddress;
}
public void setPresentAddress(String presentAddress) {
	this.presentAddress = presentAddress;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
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
public String getInjurySeverity() {
	return injurySeverity;
}
public void setInjurySeverity(String injurySeverity) {
	this.injurySeverity = injurySeverity;
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
public String getDeceasedGender() {
	return deceasedGender;
}
public void setDeceasedGender(String deceasedGender) {
	this.deceasedGender = deceasedGender;
}
public String getDeceasedMaritalStatus() {
	return deceasedMaritalStatus;
}
public void setDeceasedMaritalStatus(String deceasedMaritalStatus) {
	this.deceasedMaritalStatus = deceasedMaritalStatus;
}
public String getDeceasedOccupation() {
	return deceasedOccupation;
}
public void setDeceasedOccupation(String deceasedOccupation) {
	this.deceasedOccupation = deceasedOccupation;
}
public String getDeceasedIncome() {
	return deceasedIncome;
}
public void setDeceasedIncome(String deceasedIncome) {
	this.deceasedIncome = deceasedIncome;
}
public List<DeceasedLeagalRepresentatives> getDeceasedLegalRepresentatives() {
	return deceasedLegalRepresentatives;
}
public void setDeceasedLegalRepresentatives(List<DeceasedLeagalRepresentatives> deceasedLegalRepresentatives) {
	this.deceasedLegalRepresentatives = deceasedLegalRepresentatives;
}
public String getDeceasedAddFutureProspects() {
	return deceasedAddFutureProspects;
}
public void setDeceasedAddFutureProspects(String deceasedAddFutureProspects) {
	this.deceasedAddFutureProspects = deceasedAddFutureProspects;
}
public String getDeceasedLessPersonalExpenses() {
	return deceasedLessPersonalExpenses;
}
public void setDeceasedLessPersonalExpenses(String deceasedLessPersonalExpenses) {
	this.deceasedLessPersonalExpenses = deceasedLessPersonalExpenses;
}
public String getDeceasedMonthlyLossDependency() {
	return deceasedMonthlyLossDependency;
}
public void setDeceasedMonthlyLossDependency(String deceasedMonthlyLossDependency) {
	this.deceasedMonthlyLossDependency = deceasedMonthlyLossDependency;
}
public String getAnnualLossDependency() {
	return AnnualLossDependency;
}
public void setAnnualLossDependency(String annualLossDependency) {
	AnnualLossDependency = annualLossDependency;
}
public String getDeceasedMultiplier() {
	return deceasedMultiplier;
}
public void setDeceasedMultiplier(String deceasedMultiplier) {
	this.deceasedMultiplier = deceasedMultiplier;
}
public String getDeceasedTotalLossDependency() {
	return deceasedTotalLossDependency;
}
public void setDeceasedTotalLossDependency(String deceasedTotalLossDependency) {
	this.deceasedTotalLossDependency = deceasedTotalLossDependency;
}
public String getDeceasedMedicalExpenses() {
	return deceasedMedicalExpenses;
}
public void setDeceasedMedicalExpenses(String deceasedMedicalExpenses) {
	this.deceasedMedicalExpenses = deceasedMedicalExpenses;
}
public String getDeceasedFuneralExpenses() {
	return deceasedFuneralExpenses;
}
public void setDeceasedFuneralExpenses(String deceasedFuneralExpenses) {
	this.deceasedFuneralExpenses = deceasedFuneralExpenses;
}
public String getDeceasedPecuniaryLossDamage() {
	return deceasedPecuniaryLossDamage;
}
public void setDeceasedPecuniaryLossDamage(String deceasedPecuniaryLossDamage) {
	this.deceasedPecuniaryLossDamage = deceasedPecuniaryLossDamage;
}
public String getDeceasedLossOfConsortium() {
	return deceasedLossOfConsortium;
}
public void setDeceasedLossOfConsortium(String deceasedLossOfConsortium) {
	this.deceasedLossOfConsortium = deceasedLossOfConsortium;
}
public String getDeceasedLossOfLoveAffection() {
	return deceasedLossOfLoveAffection;
}
public void setDeceasedLossOfLoveAffection(String deceasedLossOfLoveAffection) {
	this.deceasedLossOfLoveAffection = deceasedLossOfLoveAffection;
}
public String getDeceasedLossOfEstate() {
	return deceasedLossOfEstate;
}
public void setDeceasedLossOfEstate(String deceasedLossOfEstate) {
	this.deceasedLossOfEstate = deceasedLossOfEstate;
}
public String getDeceasedEmotionalHarmTaruma() {
	return deceasedEmotionalHarmTaruma;
}
public void setDeceasedEmotionalHarmTaruma(String deceasedEmotionalHarmTaruma) {
	this.deceasedEmotionalHarmTaruma = deceasedEmotionalHarmTaruma;
}
public String getDeceasedPostTraumaticDisorder() {
	return deceasedPostTraumaticDisorder;
}
public void setDeceasedPostTraumaticDisorder(String deceasedPostTraumaticDisorder) {
	this.deceasedPostTraumaticDisorder = deceasedPostTraumaticDisorder;
}
public String getDeceasedOtherNonPecuniaryLoss() {
	return deceasedOtherNonPecuniaryLoss;
}
public void setDeceasedOtherNonPecuniaryLoss(String deceasedOtherNonPecuniaryLoss) {
	this.deceasedOtherNonPecuniaryLoss = deceasedOtherNonPecuniaryLoss;
}
public String getDeceasedTotalLossSuffered() {
	return deceasedTotalLossSuffered;
}
public void setDeceasedTotalLossSuffered(String deceasedTotalLossSuffered) {
	this.deceasedTotalLossSuffered = deceasedTotalLossSuffered;
}
public String getInjuredName() {
	return injuredName;
}
public void setInjuredName(String injuredName) {
	this.injuredName = injuredName;
}
public String getInjuredFatherOrSpouseName() {
	return injuredFatherOrSpouseName;
}
public void setInjuredFatherOrSpouseName(String injuredFatherOrSpouseName) {
	this.injuredFatherOrSpouseName = injuredFatherOrSpouseName;
}
public String getInjuredAge() {
	return injuredAge;
}
public void setInjuredAge(String injuredAge) {
	this.injuredAge = injuredAge;
}
public String getInjuredGender() {
	return injuredGender;
}
public void setInjuredGender(String injuredGender) {
	this.injuredGender = injuredGender;
}
public String getInjuredMaritalStatus() {
	return injuredMaritalStatus;
}
public void setInjuredMaritalStatus(String injuredMaritalStatus) {
	this.injuredMaritalStatus = injuredMaritalStatus;
}
public String getInjuredOccupation() {
	return injuredOccupation;
}
public void setInjuredOccupation(String injuredOccupation) {
	this.injuredOccupation = injuredOccupation;
}
public String getInjuredIncome() {
	return injuredIncome;
}
public void setInjuredIncome(String injuredIncome) {
	this.injuredIncome = injuredIncome;
}
public String getInjuryNatureAndDescription() {
	return injuryNatureAndDescription;
}
public void setInjuryNatureAndDescription(String injuryNatureAndDescription) {
	this.injuryNatureAndDescription = injuryNatureAndDescription;
}
public String getInjuredMedicalTreatment() {
	return injuredMedicalTreatment;
}
public void setInjuredMedicalTreatment(String injuredMedicalTreatment) {
	this.injuredMedicalTreatment = injuredMedicalTreatment;
}
public String getHospitalNameAndHospitalizationPeriod() {
	return hospitalNameAndHospitalizationPeriod;
}
public void setHospitalNameAndHospitalizationPeriod(String hospitalNameAndHospitalizationPeriod) {
	this.hospitalNameAndHospitalizationPeriod = hospitalNameAndHospitalizationPeriod;
}
public String getSurgeriesDetails() {
	return surgeriesDetails;
}
public void setSurgeriesDetails(String surgeriesDetails) {
	this.surgeriesDetails = surgeriesDetails;
}
public String getPermanentDisability() {
	return permanentDisability;
}
public void setPermanentDisability(String permanentDisability) {
	this.permanentDisability = permanentDisability;
}
public String getReimbursementOfMedicalExpenses() {
	return reimbursementOfMedicalExpenses;
}
public void setReimbursementOfMedicalExpenses(String reimbursementOfMedicalExpenses) {
	this.reimbursementOfMedicalExpenses = reimbursementOfMedicalExpenses;
}
public List<InjuredLegalRepresentatives> getInjuredLegalRepresentatives() {
	return injuredLegalRepresentatives;
}
public void setInjuredLegalRepresentatives(List<InjuredLegalRepresentatives> injuredLegalRepresentatives) {
	this.injuredLegalRepresentatives = injuredLegalRepresentatives;
}
public String getInjuredExpenditureOnTreatment() {
	return injuredExpenditureOnTreatment;
}
public void setInjuredExpenditureOnTreatment(String injuredExpenditureOnTreatment) {
	this.injuredExpenditureOnTreatment = injuredExpenditureOnTreatment;
}
public String getInjuredExpenditureOnConveyance() {
	return injuredExpenditureOnConveyance;
}
public void setInjuredExpenditureOnConveyance(String injuredExpenditureOnConveyance) {
	this.injuredExpenditureOnConveyance = injuredExpenditureOnConveyance;
}
public String getInjuredExpenditureOnSpecialDiet() {
	return injuredExpenditureOnSpecialDiet;
}
public void setInjuredExpenditureOnSpecialDiet(String injuredExpenditureOnSpecialDiet) {
	this.injuredExpenditureOnSpecialDiet = injuredExpenditureOnSpecialDiet;
}
public String getInjuredExpenditureOnAttendant() {
	return injuredExpenditureOnAttendant;
}
public void setInjuredExpenditureOnAttendant(String injuredExpenditureOnAttendant) {
	this.injuredExpenditureOnAttendant = injuredExpenditureOnAttendant;
}
public String getInjuredTreatmentExpenditureEstimation() {
	return injuredTreatmentExpenditureEstimation;
}
public void setInjuredTreatmentExpenditureEstimation(String injuredTreatmentExpenditureEstimation) {
	this.injuredTreatmentExpenditureEstimation = injuredTreatmentExpenditureEstimation;
}
public String getInjuredLossOfIncome() {
	return injuredLossOfIncome;
}
public void setInjuredLossOfIncome(String injuredLossOfIncome) {
	this.injuredLossOfIncome = injuredLossOfIncome;
}
public String getInjuredSpecialTreatment() {
	return injuredSpecialTreatment;
}
public void setInjuredSpecialTreatment(String injuredSpecialTreatment) {
	this.injuredSpecialTreatment = injuredSpecialTreatment;
}
public String getIjuredNatureOfDisability() {
	return ijuredNatureOfDisability;
}
public void setIjuredNatureOfDisability(String ijuredNatureOfDisability) {
	this.ijuredNatureOfDisability = ijuredNatureOfDisability;
}
public String getInjuredLossOfEarningCapacity() {
	return injuredLossOfEarningCapacity;
}
public void setInjuredLossOfEarningCapacity(String injuredLossOfEarningCapacity) {
	this.injuredLossOfEarningCapacity = injuredLossOfEarningCapacity;
}
public String getInjuredLossOfFutureIncome() {
	return injuredLossOfFutureIncome;
}
public void setInjuredLossOfFutureIncome(String injuredLossOfFutureIncome) {
	this.injuredLossOfFutureIncome = injuredLossOfFutureIncome;
}
public String getInjuredPecuniaryLoss() {
	return injuredPecuniaryLoss;
}
public void setInjuredPecuniaryLoss(String injuredPecuniaryLoss) {
	this.injuredPecuniaryLoss = injuredPecuniaryLoss;
}
public String getInjuredPainAndSuffering() {
	return injuredPainAndSuffering;
}
public void setInjuredPainAndSuffering(String injuredPainAndSuffering) {
	this.injuredPainAndSuffering = injuredPainAndSuffering;
}
public String getInjuredLossOfAmenities() {
	return injuredLossOfAmenities;
}
public void setInjuredLossOfAmenities(String injuredLossOfAmenities) {
	this.injuredLossOfAmenities = injuredLossOfAmenities;
}
public String getInjuredPostTraumaticDisorder() {
	return injuredPostTraumaticDisorder;
}
public void setInjuredPostTraumaticDisorder(String injuredPostTraumaticDisorder) {
	this.injuredPostTraumaticDisorder = injuredPostTraumaticDisorder;
}
public String getInjuredEmotionalHarmTaruma() {
	return injuredEmotionalHarmTaruma;
}
public void setInjuredEmotionalHarmTaruma(String injuredEmotionalHarmTaruma) {
	this.injuredEmotionalHarmTaruma = injuredEmotionalHarmTaruma;
}
public String getInjuredDisfiguration() {
	return injuredDisfiguration;
}
public void setInjuredDisfiguration(String injuredDisfiguration) {
	this.injuredDisfiguration = injuredDisfiguration;
}
public String getInjuredLossOfMarriageProspects() {
	return injuredLossOfMarriageProspects;
}
public void setInjuredLossOfMarriageProspects(String injuredLossOfMarriageProspects) {
	this.injuredLossOfMarriageProspects = injuredLossOfMarriageProspects;
}
public String getInjuredLossOfReputation() {
	return injuredLossOfReputation;
}
public void setInjuredLossOfReputation(String injuredLossOfReputation) {
	this.injuredLossOfReputation = injuredLossOfReputation;
}
public String getInjuredOtherNonPecuniaryLoss() {
	return injuredOtherNonPecuniaryLoss;
}
public void setInjuredOtherNonPecuniaryLoss(String injuredOtherNonPecuniaryLoss) {
	this.injuredOtherNonPecuniaryLoss = injuredOtherNonPecuniaryLoss;
}
public String getInjuredTotalLossSuffered() {
	return injuredTotalLossSuffered;
}
public void setInjuredTotalLossSuffered(String injuredTotalLossSuffered) {
	this.injuredTotalLossSuffered = injuredTotalLossSuffered;
}
public String getPropertyDamageDescription() {
	return propertyDamageDescription;
}
public void setPropertyDamageDescription(String propertyDamageDescription) {
	this.propertyDamageDescription = propertyDamageDescription;
}
public String getLossSufferedValue() {
	return lossSufferedValue;
}
public void setLossSufferedValue(String lossSufferedValue) {
	this.lossSufferedValue = lossSufferedValue;
}
public String getAccusedFledFromSpot() {
	return accusedFledFromSpot;
}
public void setAccusedFledFromSpot(String accusedFledFromSpot) {
	this.accusedFledFromSpot = accusedFledFromSpot;
}
public String getAccusedReportedAccidentToPolice() {
	return accusedReportedAccidentToPolice;
}
public void setAccusedReportedAccidentToPolice(String accusedReportedAccidentToPolice) {
	this.accusedReportedAccidentToPolice = accusedReportedAccidentToPolice;
}
public String getAccusedProvidedAssistanceToVictim() {
	return accusedProvidedAssistanceToVictim;
}
public void setAccusedProvidedAssistanceToVictim(String accusedProvidedAssistanceToVictim) {
	this.accusedProvidedAssistanceToVictim = accusedProvidedAssistanceToVictim;
}
public String getAccusedTookVictimToHospital() {
	return accusedTookVictimToHospital;
}
public void setAccusedTookVictimToHospital(String accusedTookVictimToHospital) {
	this.accusedTookVictimToHospital = accusedTookVictimToHospital;
}
public String getAccusedVisitedVictimAtHospital() {
	return accusedVisitedVictimAtHospital;
}
public void setAccusedVisitedVictimAtHospital(String accusedVisitedVictimAtHospital) {
	this.accusedVisitedVictimAtHospital = accusedVisitedVictimAtHospital;
}
public String getAccusedRemainedAtspot() {
	return accusedRemainedAtspot;
}
public void setAccusedRemainedAtspot(String accusedRemainedAtspot) {
	this.accusedRemainedAtspot = accusedRemainedAtspot;
}
public String getAccusedCooperatedInvestigation() {
	return accusedCooperatedInvestigation;
}
public void setAccusedCooperatedInvestigation(String accusedCooperatedInvestigation) {
	this.accusedCooperatedInvestigation = accusedCooperatedInvestigation;
}
public String getAccusedRemovedVehicleFromSpot() {
	return accusedRemovedVehicleFromSpot;
}
public void setAccusedRemovedVehicleFromSpot(String accusedRemovedVehicleFromSpot) {
	this.accusedRemovedVehicleFromSpot = accusedRemovedVehicleFromSpot;
}
public String getAccusedPaidCompensation() {
	return accusedPaidCompensation;
}
public void setAccusedPaidCompensation(String accusedPaidCompensation) {
	this.accusedPaidCompensation = accusedPaidCompensation;
}
public String getAccusedPreviousConvictions() {
	return accusedPreviousConvictions;
}
public void setAccusedPreviousConvictions(String accusedPreviousConvictions) {
	this.accusedPreviousConvictions = accusedPreviousConvictions;
}
public String getAccusedCloseRelative() {
	return accusedCloseRelative;
}
public void setAccusedCloseRelative(String accusedCloseRelative) {
	this.accusedCloseRelative = accusedCloseRelative;
}
public String getAccusedAge() {
	return accusedAge;
}
public void setAccusedAge(String accusedAge) {
	this.accusedAge = accusedAge;
}
public String getAccusedGender() {
	return accusedGender;
}
public void setAccusedGender(String accusedGender) {
	this.accusedGender = accusedGender;
}
public String getAccusedSufferedInjuries() {
	return accusedSufferedInjuries;
}
public void setAccusedSufferedInjuries(String accusedSufferedInjuries) {
	this.accusedSufferedInjuries = accusedSufferedInjuries;
}
public String getAccusedDischargedDuties() {
	return accusedDischargedDuties;
}
public void setAccusedDischargedDuties(String accusedDischargedDuties) {
	this.accusedDischargedDuties = accusedDischargedDuties;
}
public String getMotorAccidentCase() {
	return motorAccidentCase;
}
public void setMotorAccidentCase(String motorAccidentCase) {
	this.motorAccidentCase = motorAccidentCase;
}
public String getFirNumber() {
	return firNumber;
}
public void setFirNumber(String firNumber) {
	this.firNumber = firNumber;
}
public String getAccusedPoliceStationName() {
	return accusedPoliceStationName;
}
public void setAccusedPoliceStationName(String accusedPoliceStationName) {
	this.accusedPoliceStationName = accusedPoliceStationName;
}
public String getDriverFledFromSpot() {
	return driverFledFromSpot;
}
public void setDriverFledFromSpot(String driverFledFromSpot) {
	this.driverFledFromSpot = driverFledFromSpot;
}
public String getAccusedOtherConductInformation() {
	return accusedOtherConductInformation;
}
public void setAccusedOtherConductInformation(String accusedOtherConductInformation) {
	this.accusedOtherConductInformation = accusedOtherConductInformation;
}
public String getApparentContributingCircumstances() {
	return apparentContributingCircumstances;
}
public void setApparentContributingCircumstances(String apparentContributingCircumstances) {
	this.apparentContributingCircumstances = apparentContributingCircumstances;
}
public String getAggressiveDriving() {
	return aggressiveDriving;
}
public void setAggressiveDriving(String aggressiveDriving) {
	this.aggressiveDriving = aggressiveDriving;
}
public String getIrresponsibleBehaviour() {
	return irresponsibleBehaviour;
}
public void setIrresponsibleBehaviour(String irresponsibleBehaviour) {
	this.irresponsibleBehaviour = irresponsibleBehaviour;
}
public String getCurrentDate() {
	return currentDate;
}
public void setCurrentDate(String currentDate) {
	this.currentDate = currentDate;
}
public String getPsName() {
	return psName;
}
public void setPsName(String psName) {
	this.psName = psName;
}
public String getDateTime() {
	return dateTime;
}
public void setDateTime(String dateTime) {
	this.dateTime = dateTime;
}
public String getFirDateTime() {
	return firDateTime;
}
public void setFirDateTime(String firDateTime) {
	this.firDateTime = firDateTime;
}
public String getAct() {
	return act;
}
public void setAct(String act) {
	this.act = act;
}
public String getRoadDetails() {
	return roadDetails;
}
public void setRoadDetails(String roadDetails) {
	this.roadDetails = roadDetails;
}
public String getAccusedVictim() {
	return accusedVictim;
}
public void setAccusedVictim(String accusedVictim) {
	this.accusedVictim = accusedVictim;
}
public String getHospitalPeriod() {
	return hospitalPeriod;
}
public void setHospitalPeriod(String hospitalPeriod) {
	this.hospitalPeriod = hospitalPeriod;
}
public String getLandmarks() {
	return landmarks;
}
public void setLandmarks(String landmarks) {
	this.landmarks = landmarks;
}
public String getAccidentDatetime() {
	return accidentDatetime;
}
public void setAccidentDatetime(String accidentDatetime) {
	this.accidentDatetime = accidentDatetime;
}
public String getDeceasedcapannualincome() {
	return deceasedcapannualincome;
}
public void setDeceasedcapannualincome(String deceasedcapannualincome) {
	this.deceasedcapannualincome = deceasedcapannualincome;
}
public String getDeceasedmovableasset() {
	return deceasedmovableasset;
}
public void setDeceasedmovableasset(String deceasedmovableasset) {
	this.deceasedmovableasset = deceasedmovableasset;
}
public String getDeceasedimmovableasset() {
	return deceasedimmovableasset;
}
public void setDeceasedimmovableasset(String deceasedimmovableasset) {
	this.deceasedimmovableasset = deceasedimmovableasset;
}
public String getDeceasedrecommendation() {
	return deceasedrecommendation;
}
public void setDeceasedrecommendation(String deceasedrecommendation) {
	this.deceasedrecommendation = deceasedrecommendation;
}
public String getInjuredcapannualincome() {
	return injuredcapannualincome;
}
public void setInjuredcapannualincome(String injuredcapannualincome) {
	this.injuredcapannualincome = injuredcapannualincome;
}
public String getInjuredmovableasset() {
	return injuredmovableasset;
}
public void setInjuredmovableasset(String injuredmovableasset) {
	this.injuredmovableasset = injuredmovableasset;
}
public String getInjuredimmovableasset() {
	return injuredimmovableasset;
}
public void setInjuredimmovableasset(String injuredimmovableasset) {
	this.injuredimmovableasset = injuredimmovableasset;
}
public String getInjuredrecommendation() {
	return injuredrecommendation;
}
public void setInjuredrecommendation(String injuredrecommendation) {
	this.injuredrecommendation = injuredrecommendation;
}
public String getStateCode() {
	return stateCode;
}
public void setStateCode(String stateCode) {
	this.stateCode = stateCode;
}
public String getEmotionalHarm() {
	return emotionalHarm;
}
public void setEmotionalHarm(String emotionalHarm) {
	this.emotionalHarm = emotionalHarm;
}
public String getDamageLossProperty() {
	return damageLossProperty;
}
public void setDamageLossProperty(String damageLossProperty) {
	this.damageLossProperty = damageLossProperty;
}
public String getAnyOtherLoss() {
	return anyOtherLoss;
}
public void setAnyOtherLoss(String anyOtherLoss) {
	this.anyOtherLoss = anyOtherLoss;
}
public String getPhysicalHarm() {
	return physicalHarm;
}
public void setPhysicalHarm(String physicalHarm) {
	this.physicalHarm = physicalHarm;
}
public String getPropertyLossDamage() {
	return propertyLossDamage;
}
public void setPropertyLossDamage(String propertyLossDamage) {
	this.propertyLossDamage = propertyLossDamage;
}
public String getLossSuffered() {
	return lossSuffered;
}
public void setLossSuffered(String lossSuffered) {
	this.lossSuffered = lossSuffered;
}
@Override
public String toString() {
	return "Pdf12Entity [accidentId=" + accidentId + ", firNo=" + firNo + ", accidentDate=" + accidentDate
			+ ", section=" + section + ", policeStationName=" + policeStationName + ", dateAndTime=" + dateAndTime
			+ ", offencePlace=" + offencePlace + ", natureOfInjurySufferedByVictim=" + natureOfInjurySufferedByVictim
			+ ", offenceDescription=" + offenceDescription + ", victimName=" + victimName + ", fatherOrSpouseName="
			+ fatherOrSpouseName + ", age=" + age + ", gender=" + gender + ", maritalStatus=" + maritalStatus
			+ ", permanentAddress=" + permanentAddress + ", presentAddress=" + presentAddress + ", mobileNumber="
			+ mobileNumber + ", emailId=" + emailId + ", state=" + state + ", district=" + district
			+ ", injurySeverity=" + injurySeverity + ", deceasedName=" + deceasedName + ", deceasedFatherOrSpouseName="
			+ deceasedFatherOrSpouseName + ", deceasedAge=" + deceasedAge + ", deceasedGender=" + deceasedGender
			+ ", deceasedMaritalStatus=" + deceasedMaritalStatus + ", deceasedOccupation=" + deceasedOccupation
			+ ", deceasedIncome=" + deceasedIncome + ", deceasedLegalRepresentatives=" + deceasedLegalRepresentatives
			+ ", deceasedAddFutureProspects=" + deceasedAddFutureProspects + ", deceasedLessPersonalExpenses="
			+ deceasedLessPersonalExpenses + ", deceasedMonthlyLossDependency=" + deceasedMonthlyLossDependency
			+ ", AnnualLossDependency=" + AnnualLossDependency + ", deceasedMultiplier=" + deceasedMultiplier
			+ ", deceasedTotalLossDependency=" + deceasedTotalLossDependency + ", deceasedMedicalExpenses="
			+ deceasedMedicalExpenses + ", deceasedFuneralExpenses=" + deceasedFuneralExpenses
			+ ", deceasedPecuniaryLossDamage=" + deceasedPecuniaryLossDamage + ", deceasedLossOfConsortium="
			+ deceasedLossOfConsortium + ", deceasedLossOfLoveAffection=" + deceasedLossOfLoveAffection
			+ ", deceasedLossOfEstate=" + deceasedLossOfEstate + ", deceasedEmotionalHarmTaruma="
			+ deceasedEmotionalHarmTaruma + ", deceasedPostTraumaticDisorder=" + deceasedPostTraumaticDisorder
			+ ", deceasedOtherNonPecuniaryLoss=" + deceasedOtherNonPecuniaryLoss + ", deceasedTotalLossSuffered="
			+ deceasedTotalLossSuffered + ", injuredName=" + injuredName + ", injuredFatherOrSpouseName="
			+ injuredFatherOrSpouseName + ", injuredAge=" + injuredAge + ", injuredGender=" + injuredGender
			+ ", injuredMaritalStatus=" + injuredMaritalStatus + ", injuredOccupation=" + injuredOccupation
			+ ", injuredIncome=" + injuredIncome + ", injuryNatureAndDescription=" + injuryNatureAndDescription
			+ ", injuredMedicalTreatment=" + injuredMedicalTreatment + ", hospitalNameAndHospitalizationPeriod="
			+ hospitalNameAndHospitalizationPeriod + ", surgeriesDetails=" + surgeriesDetails + ", permanentDisability="
			+ permanentDisability + ", reimbursementOfMedicalExpenses=" + reimbursementOfMedicalExpenses
			+ ", injuredLegalRepresentatives=" + injuredLegalRepresentatives + ", injuredExpenditureOnTreatment="
			+ injuredExpenditureOnTreatment + ", injuredExpenditureOnConveyance=" + injuredExpenditureOnConveyance
			+ ", injuredExpenditureOnSpecialDiet=" + injuredExpenditureOnSpecialDiet
			+ ", injuredExpenditureOnAttendant=" + injuredExpenditureOnAttendant
			+ ", injuredTreatmentExpenditureEstimation=" + injuredTreatmentExpenditureEstimation
			+ ", injuredLossOfIncome=" + injuredLossOfIncome + ", injuredSpecialTreatment=" + injuredSpecialTreatment
			+ ", ijuredNatureOfDisability=" + ijuredNatureOfDisability + ", injuredLossOfEarningCapacity="
			+ injuredLossOfEarningCapacity + ", injuredLossOfFutureIncome=" + injuredLossOfFutureIncome
			+ ", injuredPecuniaryLoss=" + injuredPecuniaryLoss + ", injuredPainAndSuffering=" + injuredPainAndSuffering
			+ ", injuredLossOfAmenities=" + injuredLossOfAmenities + ", injuredPostTraumaticDisorder="
			+ injuredPostTraumaticDisorder + ", injuredEmotionalHarmTaruma=" + injuredEmotionalHarmTaruma
			+ ", injuredDisfiguration=" + injuredDisfiguration + ", injuredLossOfMarriageProspects="
			+ injuredLossOfMarriageProspects + ", injuredLossOfReputation=" + injuredLossOfReputation
			+ ", injuredOtherNonPecuniaryLoss=" + injuredOtherNonPecuniaryLoss + ", injuredTotalLossSuffered="
			+ injuredTotalLossSuffered + ", propertyDamageDescription=" + propertyDamageDescription
			+ ", lossSufferedValue=" + lossSufferedValue + ", accusedFledFromSpot=" + accusedFledFromSpot
			+ ", accusedReportedAccidentToPolice=" + accusedReportedAccidentToPolice
			+ ", accusedProvidedAssistanceToVictim=" + accusedProvidedAssistanceToVictim
			+ ", accusedTookVictimToHospital=" + accusedTookVictimToHospital + ", accusedVisitedVictimAtHospital="
			+ accusedVisitedVictimAtHospital + ", accusedRemainedAtspot=" + accusedRemainedAtspot
			+ ", accusedCooperatedInvestigation=" + accusedCooperatedInvestigation + ", accusedRemovedVehicleFromSpot="
			+ accusedRemovedVehicleFromSpot + ", accusedPaidCompensation=" + accusedPaidCompensation
			+ ", accusedPreviousConvictions=" + accusedPreviousConvictions + ", accusedCloseRelative="
			+ accusedCloseRelative + ", accusedAge=" + accusedAge + ", accusedGender=" + accusedGender
			+ ", accusedSufferedInjuries=" + accusedSufferedInjuries + ", accusedDischargedDuties="
			+ accusedDischargedDuties + ", motorAccidentCase=" + motorAccidentCase + ", firNumber=" + firNumber
			+ ", accusedPoliceStationName=" + accusedPoliceStationName + ", driverFledFromSpot=" + driverFledFromSpot
			+ ", accusedOtherConductInformation=" + accusedOtherConductInformation
			+ ", apparentContributingCircumstances=" + apparentContributingCircumstances + ", aggressiveDriving="
			+ aggressiveDriving + ", irresponsibleBehaviour=" + irresponsibleBehaviour + ", currentDate=" + currentDate
			+ ", psName=" + psName + ", dateTime=" + dateTime + ", firDateTime=" + firDateTime + ", act=" + act
			+ ", roadDetails=" + roadDetails + ", accusedVictim=" + accusedVictim + ", hospitalPeriod=" + hospitalPeriod
			+ ", landmarks=" + landmarks + ", accidentDatetime=" + accidentDatetime + ", deceasedcapannualincome="
			+ deceasedcapannualincome + ", deceasedmovableasset=" + deceasedmovableasset + ", deceasedimmovableasset="
			+ deceasedimmovableasset + ", deceasedrecommendation=" + deceasedrecommendation
			+ ", injuredcapannualincome=" + injuredcapannualincome + ", injuredmovableasset=" + injuredmovableasset
			+ ", injuredimmovableasset=" + injuredimmovableasset + ", injuredrecommendation=" + injuredrecommendation
			+ ", stateCode=" + stateCode + ", emotionalHarm=" + emotionalHarm + ", damageLossProperty="
			+ damageLossProperty + ", anyOtherLoss=" + anyOtherLoss + ", physicalHarm=" + physicalHarm
			+ ", propertyLossDamage=" + propertyLossDamage + ", lossSuffered=" + lossSuffered + "]";
}
public Pdf12Entity(String accidentId, String firNo, String accidentDate, String section, String policeStationName,
		String dateAndTime, String offencePlace, String natureOfInjurySufferedByVictim, String offenceDescription,
		String victimName, String fatherOrSpouseName, String age, String gender, String maritalStatus,
		String permanentAddress, String presentAddress, String mobileNumber, String emailId, String state,
		String district, String injurySeverity, String deceasedName, String deceasedFatherOrSpouseName,
		String deceasedAge, String deceasedGender, String deceasedMaritalStatus, String deceasedOccupation,
		String deceasedIncome, List<DeceasedLeagalRepresentatives> deceasedLegalRepresentatives,
		String deceasedAddFutureProspects, String deceasedLessPersonalExpenses, String deceasedMonthlyLossDependency,
		String annualLossDependency, String deceasedMultiplier, String deceasedTotalLossDependency,
		String deceasedMedicalExpenses, String deceasedFuneralExpenses, String deceasedPecuniaryLossDamage,
		String deceasedLossOfConsortium, String deceasedLossOfLoveAffection, String deceasedLossOfEstate,
		String deceasedEmotionalHarmTaruma, String deceasedPostTraumaticDisorder, String deceasedOtherNonPecuniaryLoss,
		String deceasedTotalLossSuffered, String injuredName, String injuredFatherOrSpouseName, String injuredAge,
		String injuredGender, String injuredMaritalStatus, String injuredOccupation, String injuredIncome,
		String injuryNatureAndDescription, String injuredMedicalTreatment, String hospitalNameAndHospitalizationPeriod,
		String surgeriesDetails, String permanentDisability, String reimbursementOfMedicalExpenses,
		List<InjuredLegalRepresentatives> injuredLegalRepresentatives, String injuredExpenditureOnTreatment,
		String injuredExpenditureOnConveyance, String injuredExpenditureOnSpecialDiet,
		String injuredExpenditureOnAttendant, String injuredTreatmentExpenditureEstimation, String injuredLossOfIncome,
		String injuredSpecialTreatment, String ijuredNatureOfDisability, String injuredLossOfEarningCapacity,
		String injuredLossOfFutureIncome, String injuredPecuniaryLoss, String injuredPainAndSuffering,
		String injuredLossOfAmenities, String injuredPostTraumaticDisorder, String injuredEmotionalHarmTaruma,
		String injuredDisfiguration, String injuredLossOfMarriageProspects, String injuredLossOfReputation,
		String injuredOtherNonPecuniaryLoss, String injuredTotalLossSuffered, String propertyDamageDescription,
		String lossSufferedValue, String accusedFledFromSpot, String accusedReportedAccidentToPolice,
		String accusedProvidedAssistanceToVictim, String accusedTookVictimToHospital,
		String accusedVisitedVictimAtHospital, String accusedRemainedAtspot, String accusedCooperatedInvestigation,
		String accusedRemovedVehicleFromSpot, String accusedPaidCompensation, String accusedPreviousConvictions,
		String accusedCloseRelative, String accusedAge, String accusedGender, String accusedSufferedInjuries,
		String accusedDischargedDuties, String motorAccidentCase, String firNumber, String accusedPoliceStationName,
		String driverFledFromSpot, String accusedOtherConductInformation, String apparentContributingCircumstances,
		String aggressiveDriving, String irresponsibleBehaviour, String currentDate, String psName, String dateTime,
		String firDateTime, String act, String roadDetails, String accusedVictim, String hospitalPeriod,
		String landmarks, String accidentDatetime, String deceasedcapannualincome, String deceasedmovableasset,
		String deceasedimmovableasset, String deceasedrecommendation, String injuredcapannualincome,
		String injuredmovableasset, String injuredimmovableasset, String injuredrecommendation, String stateCode,
		String emotionalHarm, String damageLossProperty, String anyOtherLoss, String physicalHarm,
		String propertyLossDamage, String lossSuffered) {
	super();
	this.accidentId = accidentId;
	this.firNo = firNo;
	this.accidentDate = accidentDate;
	this.section = section;
	this.policeStationName = policeStationName;
	this.dateAndTime = dateAndTime;
	this.offencePlace = offencePlace;
	this.natureOfInjurySufferedByVictim = natureOfInjurySufferedByVictim;
	this.offenceDescription = offenceDescription;
	this.victimName = victimName;
	this.fatherOrSpouseName = fatherOrSpouseName;
	this.age = age;
	this.gender = gender;
	this.maritalStatus = maritalStatus;
	this.permanentAddress = permanentAddress;
	this.presentAddress = presentAddress;
	this.mobileNumber = mobileNumber;
	this.emailId = emailId;
	this.state = state;
	this.district = district;
	this.injurySeverity = injurySeverity;
	this.deceasedName = deceasedName;
	this.deceasedFatherOrSpouseName = deceasedFatherOrSpouseName;
	this.deceasedAge = deceasedAge;
	this.deceasedGender = deceasedGender;
	this.deceasedMaritalStatus = deceasedMaritalStatus;
	this.deceasedOccupation = deceasedOccupation;
	this.deceasedIncome = deceasedIncome;
	this.deceasedLegalRepresentatives = deceasedLegalRepresentatives;
	this.deceasedAddFutureProspects = deceasedAddFutureProspects;
	this.deceasedLessPersonalExpenses = deceasedLessPersonalExpenses;
	this.deceasedMonthlyLossDependency = deceasedMonthlyLossDependency;
	AnnualLossDependency = annualLossDependency;
	this.deceasedMultiplier = deceasedMultiplier;
	this.deceasedTotalLossDependency = deceasedTotalLossDependency;
	this.deceasedMedicalExpenses = deceasedMedicalExpenses;
	this.deceasedFuneralExpenses = deceasedFuneralExpenses;
	this.deceasedPecuniaryLossDamage = deceasedPecuniaryLossDamage;
	this.deceasedLossOfConsortium = deceasedLossOfConsortium;
	this.deceasedLossOfLoveAffection = deceasedLossOfLoveAffection;
	this.deceasedLossOfEstate = deceasedLossOfEstate;
	this.deceasedEmotionalHarmTaruma = deceasedEmotionalHarmTaruma;
	this.deceasedPostTraumaticDisorder = deceasedPostTraumaticDisorder;
	this.deceasedOtherNonPecuniaryLoss = deceasedOtherNonPecuniaryLoss;
	this.deceasedTotalLossSuffered = deceasedTotalLossSuffered;
	this.injuredName = injuredName;
	this.injuredFatherOrSpouseName = injuredFatherOrSpouseName;
	this.injuredAge = injuredAge;
	this.injuredGender = injuredGender;
	this.injuredMaritalStatus = injuredMaritalStatus;
	this.injuredOccupation = injuredOccupation;
	this.injuredIncome = injuredIncome;
	this.injuryNatureAndDescription = injuryNatureAndDescription;
	this.injuredMedicalTreatment = injuredMedicalTreatment;
	this.hospitalNameAndHospitalizationPeriod = hospitalNameAndHospitalizationPeriod;
	this.surgeriesDetails = surgeriesDetails;
	this.permanentDisability = permanentDisability;
	this.reimbursementOfMedicalExpenses = reimbursementOfMedicalExpenses;
	this.injuredLegalRepresentatives = injuredLegalRepresentatives;
	this.injuredExpenditureOnTreatment = injuredExpenditureOnTreatment;
	this.injuredExpenditureOnConveyance = injuredExpenditureOnConveyance;
	this.injuredExpenditureOnSpecialDiet = injuredExpenditureOnSpecialDiet;
	this.injuredExpenditureOnAttendant = injuredExpenditureOnAttendant;
	this.injuredTreatmentExpenditureEstimation = injuredTreatmentExpenditureEstimation;
	this.injuredLossOfIncome = injuredLossOfIncome;
	this.injuredSpecialTreatment = injuredSpecialTreatment;
	this.ijuredNatureOfDisability = ijuredNatureOfDisability;
	this.injuredLossOfEarningCapacity = injuredLossOfEarningCapacity;
	this.injuredLossOfFutureIncome = injuredLossOfFutureIncome;
	this.injuredPecuniaryLoss = injuredPecuniaryLoss;
	this.injuredPainAndSuffering = injuredPainAndSuffering;
	this.injuredLossOfAmenities = injuredLossOfAmenities;
	this.injuredPostTraumaticDisorder = injuredPostTraumaticDisorder;
	this.injuredEmotionalHarmTaruma = injuredEmotionalHarmTaruma;
	this.injuredDisfiguration = injuredDisfiguration;
	this.injuredLossOfMarriageProspects = injuredLossOfMarriageProspects;
	this.injuredLossOfReputation = injuredLossOfReputation;
	this.injuredOtherNonPecuniaryLoss = injuredOtherNonPecuniaryLoss;
	this.injuredTotalLossSuffered = injuredTotalLossSuffered;
	this.propertyDamageDescription = propertyDamageDescription;
	this.lossSufferedValue = lossSufferedValue;
	this.accusedFledFromSpot = accusedFledFromSpot;
	this.accusedReportedAccidentToPolice = accusedReportedAccidentToPolice;
	this.accusedProvidedAssistanceToVictim = accusedProvidedAssistanceToVictim;
	this.accusedTookVictimToHospital = accusedTookVictimToHospital;
	this.accusedVisitedVictimAtHospital = accusedVisitedVictimAtHospital;
	this.accusedRemainedAtspot = accusedRemainedAtspot;
	this.accusedCooperatedInvestigation = accusedCooperatedInvestigation;
	this.accusedRemovedVehicleFromSpot = accusedRemovedVehicleFromSpot;
	this.accusedPaidCompensation = accusedPaidCompensation;
	this.accusedPreviousConvictions = accusedPreviousConvictions;
	this.accusedCloseRelative = accusedCloseRelative;
	this.accusedAge = accusedAge;
	this.accusedGender = accusedGender;
	this.accusedSufferedInjuries = accusedSufferedInjuries;
	this.accusedDischargedDuties = accusedDischargedDuties;
	this.motorAccidentCase = motorAccidentCase;
	this.firNumber = firNumber;
	this.accusedPoliceStationName = accusedPoliceStationName;
	this.driverFledFromSpot = driverFledFromSpot;
	this.accusedOtherConductInformation = accusedOtherConductInformation;
	this.apparentContributingCircumstances = apparentContributingCircumstances;
	this.aggressiveDriving = aggressiveDriving;
	this.irresponsibleBehaviour = irresponsibleBehaviour;
	this.currentDate = currentDate;
	this.psName = psName;
	this.dateTime = dateTime;
	this.firDateTime = firDateTime;
	this.act = act;
	this.roadDetails = roadDetails;
	this.accusedVictim = accusedVictim;
	this.hospitalPeriod = hospitalPeriod;
	this.landmarks = landmarks;
	this.accidentDatetime = accidentDatetime;
	this.deceasedcapannualincome = deceasedcapannualincome;
	this.deceasedmovableasset = deceasedmovableasset;
	this.deceasedimmovableasset = deceasedimmovableasset;
	this.deceasedrecommendation = deceasedrecommendation;
	this.injuredcapannualincome = injuredcapannualincome;
	this.injuredmovableasset = injuredmovableasset;
	this.injuredimmovableasset = injuredimmovableasset;
	this.injuredrecommendation = injuredrecommendation;
	this.stateCode = stateCode;
	this.emotionalHarm = emotionalHarm;
	this.damageLossProperty = damageLossProperty;
	this.anyOtherLoss = anyOtherLoss;
	this.physicalHarm = physicalHarm;
	this.propertyLossDamage = propertyLossDamage;
	this.lossSuffered = lossSuffered;
}
public Pdf12Entity() {
	super();
	// TODO Auto-generated constructor stub
}
  
  

  

}
