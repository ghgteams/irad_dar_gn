package com.irad.dar.legalservice;

public class Legal {
	private String accidentId;
	private int status;
	private String legalId;
	private String district;
	private String mode;
	private String token;
	private String typeodcourt;
	private String version;
	public String getAccidentId() {
		return accidentId;
	}
	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getLegalId() {
		return legalId;
	}
	public void setLegalId(String legalId) {
		this.legalId = legalId;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTypeodcourt() {
		return typeodcourt;
	}
	public void setTypeodcourt(String typeodcourt) {
		this.typeodcourt = typeodcourt;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Legal(String accidentId, int status, String legalId, String district, String mode, String token,
			String typeodcourt, String version) {
		super();
		this.accidentId = accidentId;
		this.status = status;
		this.legalId = legalId;
		this.district = district;
		this.mode = mode;
		this.token = token;
		this.typeodcourt = typeodcourt;
		this.version = version;
	}
	@Override
	public String toString() {
		return "Legal [accidentId=" + accidentId + ", status=" + status + ", legalId=" + legalId + ", district="
				+ district + ", mode=" + mode + ", token=" + token + ", typeodcourt=" + typeodcourt + ", version="
				+ version + "]";
	}
	
	
	
	
}
