package com.irad.dar.master;

import java.util.Arrays;

public class MasterEntity {
	 String token;
	 String version;
	 String mode;
	 String tableArrayName[];
	 String lang;
	 String district;
	 String typeofcourt;
	 String taluk;
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
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String[] getTableArrayName() {
		return tableArrayName;
	}
	public void setTableArrayName(String[] tableArrayName) {
		this.tableArrayName = tableArrayName;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getTypeofcourt() {
		return typeofcourt;
	}
	public void setTypeofcourt(String typeofcourt) {
		this.typeofcourt = typeofcourt;
	}
	public String getTaluk() {
		return taluk;
	}
	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}
	public MasterEntity(String token, String version, String mode, String[] tableArrayName, String lang,
			String district, String typeofcourt, String taluk) {
		super();
		this.token = token;
		this.version = version;
		this.mode = mode;
		this.tableArrayName = tableArrayName;
		this.lang = lang;
		this.district = district;
		this.typeofcourt = typeofcourt;
		this.taluk = taluk;
	}
	@Override
	public String toString() {
		return "MasterEntity [token=" + token + ", version=" + version + ", mode=" + mode + ", tableArrayName="
				+ Arrays.toString(tableArrayName) + ", lang=" + lang + ", district=" + district + ", typeofcourt="
				+ typeofcourt + ", taluk=" + taluk + "]";
	}
	public MasterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
