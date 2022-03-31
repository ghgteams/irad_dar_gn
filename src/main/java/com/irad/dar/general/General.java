package com.irad.dar.general;

import org.json.simple.JSONObject;

public class General {
	private JSONObject general;
	private JSONObject generaldoc;
	private String token;
	private String version;

	public General() {
		super();
	}

	public General(JSONObject general,JSONObject generaldoc, String token, String version) {
		super();
		this.general = general;
		this.generaldoc=generaldoc;
		this.token = token;
		this.version = version;
	}

	public JSONObject getGeneral() {
		return general;
	}

	public void setGeneral(JSONObject general) {
		this.general = general;
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

	public JSONObject getGeneraldoc() {
		return generaldoc;
	}

	public void setGeneraldoc(JSONObject generaldoc) {
		this.generaldoc = generaldoc;
	}

	@Override
	public String toString() {
		return "General [general=" + general + ", generaldoc=" + generaldoc + ", token=" + token + ", version="
				+ version + "]";
	}

	

}
