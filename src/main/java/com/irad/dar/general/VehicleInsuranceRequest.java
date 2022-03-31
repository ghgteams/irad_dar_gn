package com.irad.dar.general;

public class VehicleInsuranceRequest {
	private String accidentId;
	private String token;
	private String version;
	
	public String getAccidentId() {
		return accidentId;
	}
	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public VehicleInsuranceRequest(String accidentId, String token, String version) {
		super();
		this.accidentId = accidentId;
		this.token = token;
		this.version = version;
	}
	@Override
	public String toString() {
		return "VehicleInsuranceRequest [accidentId=" + accidentId + ", token=" + token + ", version=" + version + "]";
	}
	public VehicleInsuranceRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
