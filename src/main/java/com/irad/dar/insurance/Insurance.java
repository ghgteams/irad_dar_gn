package com.irad.dar.insurance;

public class Insurance {
	private String accidentId;
	private String status;
	private String insuranceId;
	public String getAccidentId() {
		return accidentId;
	}
	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}
	public Insurance(String accidentId, String status, String insuranceId) {
		super();
		this.accidentId = accidentId;
		this.status = status;
		this.insuranceId = insuranceId;
	}
	@Override
	public String toString() {
		return "Insurance [accidentId=" + accidentId + ", status=" + status + ", insuranceId=" + insuranceId + "]";
	}
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
