package com.irad.dar.vehicle;

import org.json.simple.JSONObject;

public class Vehicle {

	private JSONObject vehicle;
	private JSONObject vehicledoc;
	private String token;
	private String vehicleno;
	private String version;	
	
	public JSONObject getVehicle() {
		return vehicle;
	}



	public void setVehicle(JSONObject vehicle) {
		this.vehicle = vehicle;
	}



	public JSONObject getVehicledoc() {
		return vehicledoc;
	}



	public void setVehicledoc(JSONObject vehicledoc) {
		this.vehicledoc = vehicledoc;
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



	public String getVehicleno() {
		return vehicleno;
	}



	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
	}



	@Override
	public String toString() {
		return "Vehicle [vehicle=" + vehicle + ", vehicledoc=" + vehicledoc + ", token=" + token + ", vehicleno="
				+ vehicleno + ", version=" + version + "]";
	}

		
}
