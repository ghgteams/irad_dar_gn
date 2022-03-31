package com.irad.dar.insurance;

public class InsuranceData {
    private String accid;
	private String mode;
	private String token;
	private String version;
	public String getAccid() {
		return accid;
	}
	public void setAccid(String accid) {
		this.accid = accid;
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
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public InsuranceData(String accid, String mode, String token, String version) {
		super();
		this.accid = accid;
		this.mode = mode;
		this.token = token;
		this.version = version;
	}
	@Override
	public String toString() {
		return "InsuranceData [accid=" + accid + ", mode=" + mode + ", token=" + token + ", version=" + version + "]";
	}
	public InsuranceData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
