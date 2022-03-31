package com.irad.dar.pdf;

import java.util.List;

public class Pdf6aEntity {
	
	private String accidentId;
	private String firNumber;
	private String dateTime;
	private String psName;
	private String landmarks;
	private String section;
	private String state;
	private String district;
	private String act;
	private String firDateTime;
	private String shoName;
	private String shoDesignation;
	private List<MinorChildrenDetailsEntity1> childrenDetails;
	private String currentDate;
	private String stateCode;
	
	private String institutionId;
	private String aadharCard;
	private String educationFee;
	private String otherExpenses;
	private String medicalDoc;
	private String disabilityCertificate;
	private String casteCertificate;
	private String incomeCertificate;
	public String getAccidentId() {
		return accidentId;
	}
	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
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
	public String getPsName() {
		return psName;
	}
	public void setPsName(String psName) {
		this.psName = psName;
	}
	public String getLandmarks() {
		return landmarks;
	}
	public void setLandmarks(String landmarks) {
		this.landmarks = landmarks;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
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
	public String getAct() {
		return act;
	}
	public void setAct(String act) {
		this.act = act;
	}
	public String getFirDateTime() {
		return firDateTime;
	}
	public void setFirDateTime(String firDateTime) {
		this.firDateTime = firDateTime;
	}
	public String getShoName() {
		return shoName;
	}
	public void setShoName(String shoName) {
		this.shoName = shoName;
	}
	public String getShoDesignation() {
		return shoDesignation;
	}
	public void setShoDesignation(String shoDesignation) {
		this.shoDesignation = shoDesignation;
	}
	public List<MinorChildrenDetailsEntity1> getChildrenDetails() {
		return childrenDetails;
	}
	public void setChildrenDetails(List<MinorChildrenDetailsEntity1> childrenDetails) {
		this.childrenDetails = childrenDetails;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	public String getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}
	public String getEducationFee() {
		return educationFee;
	}
	public void setEducationFee(String educationFee) {
		this.educationFee = educationFee;
	}
	public String getOtherExpenses() {
		return otherExpenses;
	}
	public void setOtherExpenses(String otherExpenses) {
		this.otherExpenses = otherExpenses;
	}
	public String getMedicalDoc() {
		return medicalDoc;
	}
	public void setMedicalDoc(String medicalDoc) {
		this.medicalDoc = medicalDoc;
	}
	public String getDisabilityCertificate() {
		return disabilityCertificate;
	}
	public void setDisabilityCertificate(String disabilityCertificate) {
		this.disabilityCertificate = disabilityCertificate;
	}
	public String getCasteCertificate() {
		return casteCertificate;
	}
	public void setCasteCertificate(String casteCertificate) {
		this.casteCertificate = casteCertificate;
	}
	public String getIncomeCertificate() {
		return incomeCertificate;
	}
	public void setIncomeCertificate(String incomeCertificate) {
		this.incomeCertificate = incomeCertificate;
	}
	public Pdf6aEntity(String accidentId, String firNumber, String dateTime, String psName, String landmarks,
			String section, String state, String district, String act, String firDateTime, String shoName,
			String shoDesignation, List<MinorChildrenDetailsEntity1> childrenDetails, String currentDate,
			String stateCode, String institutionId, String aadharCard, String educationFee, String otherExpenses,
			String medicalDoc, String disabilityCertificate, String casteCertificate, String incomeCertificate) {
		super();
		this.accidentId = accidentId;
		this.firNumber = firNumber;
		this.dateTime = dateTime;
		this.psName = psName;
		this.landmarks = landmarks;
		this.section = section;
		this.state = state;
		this.district = district;
		this.act = act;
		this.firDateTime = firDateTime;
		this.shoName = shoName;
		this.shoDesignation = shoDesignation;
		this.childrenDetails = childrenDetails;
		this.currentDate = currentDate;
		this.stateCode = stateCode;
		this.institutionId = institutionId;
		this.aadharCard = aadharCard;
		this.educationFee = educationFee;
		this.otherExpenses = otherExpenses;
		this.medicalDoc = medicalDoc;
		this.disabilityCertificate = disabilityCertificate;
		this.casteCertificate = casteCertificate;
		this.incomeCertificate = incomeCertificate;
	}
	@Override
	public String toString() {
		return "Pdf6aEntity [accidentId=" + accidentId + ", firNumber=" + firNumber + ", dateTime=" + dateTime
				+ ", psName=" + psName + ", landmarks=" + landmarks + ", section=" + section + ", state=" + state
				+ ", district=" + district + ", act=" + act + ", firDateTime=" + firDateTime + ", shoName=" + shoName
				+ ", shoDesignation=" + shoDesignation + ", childrenDetails=" + childrenDetails + ", currentDate="
				+ currentDate + ", stateCode=" + stateCode + ", institutionId=" + institutionId + ", aadharCard="
				+ aadharCard + ", educationFee=" + educationFee + ", otherExpenses=" + otherExpenses + ", medicalDoc="
				+ medicalDoc + ", disabilityCertificate=" + disabilityCertificate + ", casteCertificate="
				+ casteCertificate + ", incomeCertificate=" + incomeCertificate + "]";
	}
	public Pdf6aEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
