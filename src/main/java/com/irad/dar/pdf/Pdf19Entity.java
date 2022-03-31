package com.irad.dar.pdf;

public class Pdf19Entity {

	private String currentDate;
	private String accidentId;
	private String stateCode;
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public String getAccidentId() {
		return accidentId;
	}
	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public Pdf19Entity(String currentDate, String accidentId, String stateCode) {
		super();
		this.currentDate = currentDate;
		this.accidentId = accidentId;
		this.stateCode = stateCode;
	}
	@Override
	public String toString() {
		return "Pdf19Entity [currentDate=" + currentDate + ", accidentId=" + accidentId + ", stateCode=" + stateCode
				+ "]";
	}
	public Pdf19Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
