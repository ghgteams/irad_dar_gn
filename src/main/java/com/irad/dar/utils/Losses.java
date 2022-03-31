package com.irad.dar.utils;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Losses {
    private ArrayList<JSONObject> loss_description;
    private String accid;
    private String whoseloss;
	private String ref_id;	

	private String token;
	private String version;
	
	
	public ArrayList<JSONObject> getLoss_description() {
		return loss_description;
	}
	public void setLoss_description(ArrayList<JSONObject> loss_description) {
		this.loss_description = loss_description;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRef_id() {
		return ref_id;
	}
	public void setRef_id(String ref_id) {
		this.ref_id = ref_id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAccid() {
		return accid;
	}
	public void setAccid(String accid) {
		this.accid = accid;
	}
	public String getWhoseloss() {
		return whoseloss;
	}
	public void setWhoseloss(String whoseloss) {
		this.whoseloss = whoseloss;
	}
	
	
	
}
