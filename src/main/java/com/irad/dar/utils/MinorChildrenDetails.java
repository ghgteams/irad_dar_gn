package com.irad.dar.utils;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class MinorChildrenDetails {
	 private JSONObject minorchilddetails;
	    private String accid;
		private String victimid;	
		private String whoseChild;

		private String token;
		private String version;
		public JSONObject getMinorchilddetails() {
			return minorchilddetails;
		}
		public void setMinorchilddetails(JSONObject minorchilddetails) {
			this.minorchilddetails = minorchilddetails;
		}
		public String getAccid() {
			return accid;
		}
		public void setAccid(String accid) {
			this.accid = accid;
		}
		public String getVictimid() {
			return victimid;
		}
		public void setVictimid(String victimid) {
			this.victimid = victimid;
		}
		public String getWhoseChild() {
			return whoseChild;
		}
		public void setWhoseChild(String whoseChild) {
			this.whoseChild = whoseChild;
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
