package com.irad.dar.familydetails;

import org.json.simple.JSONObject;

public class Familydetails {
	private JSONObject familydetails;
	private String type;
	private String ref_id;
	private String token;
	private String version;


	public JSONObject getFamilydetails() {
		return familydetails;
	}
	public void setFamilydetails(JSONObject familydetails) {
		this.familydetails = familydetails;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRef_id() {
		return ref_id;
	}
	public void setRef_id(String ref_id) {
		this.ref_id = ref_id;
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

}
