package com.irad.dar.witness;

import org.json.simple.JSONObject;

public class Witness {

	private JSONObject witness;
	private String mode;
	private String token;
	private String mobile;
	private String version;
	private String accId;
	public JSONObject getWitness() {
		return witness;
	}
	public void setWitness(JSONObject witness) {
		this.witness = witness;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAccId() {
		return accId;
	}
	public void setAccId(String accId) {
		this.accId = accId;
	}
	public Witness(JSONObject witness, String mode, String token, String mobile, String version, String accId) {
		super();
		this.witness = witness;
		this.mode = mode;
		this.token = token;
		this.mobile = mobile;
		this.version = version;
		this.accId = accId;
	}
	@Override
	public String toString() {
		return "Witness [witness=" + witness + ", mode=" + mode + ", token=" + token + ", mobile=" + mobile
				+ ", version=" + version + ", accId=" + accId + "]";
	}
	
	
	
	
}
