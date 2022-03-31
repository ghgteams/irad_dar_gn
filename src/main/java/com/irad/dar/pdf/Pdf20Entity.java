package com.irad.dar.pdf;

public class Pdf20Entity {
	private String accident_id;
	private String firNumber;
	private String dateOfAccident;
	private String placeOfAccident;
	private String psName;
	private String district;
	private String state;
	private String pincode;
	private String currentDate;
	private String landMark;
	private String stateCode;
	public String getAccident_id() {
		return accident_id;
	}
	public void setAccident_id(String accident_id) {
		this.accident_id = accident_id;
	}
	public String getFirNumber() {
		return firNumber;
	}
	public void setFirNumber(String firNumber) {
		this.firNumber = firNumber;
	}
	public String getDateOfAccident() {
		return dateOfAccident;
	}
	public void setDateOfAccident(String dateOfAccident) {
		this.dateOfAccident = dateOfAccident;
	}
	public String getPlaceOfAccident() {
		return placeOfAccident;
	}
	public void setPlaceOfAccident(String placeOfAccident) {
		this.placeOfAccident = placeOfAccident;
	}
	public String getPsName() {
		return psName;
	}
	public void setPsName(String psName) {
		this.psName = psName;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public Pdf20Entity(String accident_id, String firNumber, String dateOfAccident, String placeOfAccident,
			String psName, String district, String state, String pincode, String currentDate, String landMark,
			String stateCode) {
		super();
		this.accident_id = accident_id;
		this.firNumber = firNumber;
		this.dateOfAccident = dateOfAccident;
		this.placeOfAccident = placeOfAccident;
		this.psName = psName;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
		this.currentDate = currentDate;
		this.landMark = landMark;
		this.stateCode = stateCode;
	}
	@Override
	public String toString() {
		return "Pdf20Entity [accident_id=" + accident_id + ", firNumber=" + firNumber + ", dateOfAccident="
				+ dateOfAccident + ", placeOfAccident=" + placeOfAccident + ", psName=" + psName + ", district="
				+ district + ", state=" + state + ", pincode=" + pincode + ", currentDate=" + currentDate
				+ ", landMark=" + landMark + ", stateCode=" + stateCode + "]";
	}
	public Pdf20Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
