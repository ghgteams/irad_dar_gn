package com.irad.dar.master;

import java.util.List;

public class MasterDetailsResponse {
	private int id;  
	private String lang;  
	private int dispid;  
	public MasterDetailsResponse() {
		
	};
	public MasterDetailsResponse(int id, String lang, int dispid) {  
	    this.id = id;  
	    this.lang = lang;  
	    this.dispid = dispid;    
	}
	public MasterDetailsResponse(List<String> nameList) {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public int getDispid() {
		return dispid;
	}
	public void setDispid(int dispid) {
		this.dispid = dispid;
	}
//	public void setId(String string) {
//		// TODO Auto-generated method stub
//		
//	}
//	public void setDispid(String string) {
//		// TODO Auto-generated method stub
//		
//	}  
}
