package com.irad.dar.pdf;

public class DeceasedDetails {
	
	private String id;
	private String injurySeverity;
	private String nameOfDeceased;
	private String ageOfDeceased;
	private String occupationOfDeceased;
	private String ser_name;
	private String vehicle_id;
	private String ref_id;
	private String legalRepName;
	private String legalRepRelation;
	private String legalRepAge;
	
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

	public String getSer_name() {
		return ser_name;
	}

	public void setSer_name(String ser_name) {
		this.ser_name = ser_name;
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

	public String getLegalRepName() {
		return legalRepName;
	}

	public void setLegalRepName(String legalRepName) {
		this.legalRepName = legalRepName;
	}

	public String getLegalRepRelation() {
		return legalRepRelation;
	}

	public void setLegalRepRelation(String legalRepRelation) {
		this.legalRepRelation = legalRepRelation;
	}

	public String getLegalRepAge() {
		return legalRepAge;
	}

	public void setLegalRepAge(String legalRepAge) {
		this.legalRepAge = legalRepAge;
	}

	@Override
	public String toString() {
		return "DeceasedDetails [nameOfDeceased=" + nameOfDeceased + ", ageOfDeceased=" + ageOfDeceased
				+ ", occupationOfDeceased=" + occupationOfDeceased + ", legalRepName=" + legalRepName
				+ ", legalRepRelation=" + legalRepRelation + ", legalRepAge=" + legalRepAge + ", injurySeverity="
				+ injurySeverity + "]";
	}
	
}
