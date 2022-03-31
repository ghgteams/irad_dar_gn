package com.irad.dar.pdf;

public class Pdf2Entity {
	private String accidentId;
	private String currentDate;
	private String victimDetails;
	private String form2DocAttached;
	private String psName;
	private String investigatingOfficerName;
	private String investigatingOfficerPis;
	private String investigatingOfficerMobile;
	
	private String shoName;
	private String shoDesignation;
	
	private String stateCode;

	public String getAccidentId() {
		return accidentId;
	}

	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public String getVictimDetails() {
		return victimDetails;
	}

	public void setVictimDetails(String victimDetails) {
		this.victimDetails = victimDetails;
	}

	public String getForm2DocAttached() {
		return form2DocAttached;
	}

	public void setForm2DocAttached(String form2DocAttached) {
		this.form2DocAttached = form2DocAttached;
	}

	public String getPsName() {
		return psName;
	}

	public void setPsName(String psName) {
		this.psName = psName;
	}

	public String getInvestigatingOfficerName() {
		return investigatingOfficerName;
	}

	public void setInvestigatingOfficerName(String investigatingOfficerName) {
		this.investigatingOfficerName = investigatingOfficerName;
	}

	public String getInvestigatingOfficerPis() {
		return investigatingOfficerPis;
	}

	public void setInvestigatingOfficerPis(String investigatingOfficerPis) {
		this.investigatingOfficerPis = investigatingOfficerPis;
	}

	public String getInvestigatingOfficerMobile() {
		return investigatingOfficerMobile;
	}

	public void setInvestigatingOfficerMobile(String investigatingOfficerMobile) {
		this.investigatingOfficerMobile = investigatingOfficerMobile;
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

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public Pdf2Entity(String accidentId, String currentDate, String victimDetails, String form2DocAttached,
			String psName, String investigatingOfficerName, String investigatingOfficerPis,
			String investigatingOfficerMobile, String shoName, String shoDesignation, String stateCode) {
		super();
		this.accidentId = accidentId;
		this.currentDate = currentDate;
		this.victimDetails = victimDetails;
		this.form2DocAttached = form2DocAttached;
		this.psName = psName;
		this.investigatingOfficerName = investigatingOfficerName;
		this.investigatingOfficerPis = investigatingOfficerPis;
		this.investigatingOfficerMobile = investigatingOfficerMobile;
		this.shoName = shoName;
		this.shoDesignation = shoDesignation;
		this.stateCode = stateCode;
	}

	@Override
	public String toString() {
		return "Pdf2Entity [accidentId=" + accidentId + ", currentDate=" + currentDate + ", victimDetails="
				+ victimDetails + ", form2DocAttached=" + form2DocAttached + ", psName=" + psName
				+ ", investigatingOfficerName=" + investigatingOfficerName + ", investigatingOfficerPis="
				+ investigatingOfficerPis + ", investigatingOfficerMobile=" + investigatingOfficerMobile + ", shoName="
				+ shoName + ", shoDesignation=" + shoDesignation + ", stateCode=" + stateCode + "]";
	}

	public Pdf2Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
