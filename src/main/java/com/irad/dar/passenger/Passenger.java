package com.irad.dar.passenger;

import org.json.simple.JSONObject;

public class Passenger {
    private JSONObject passenger;
	
	private JSONObject pedestriandoc;

	private String token;
	private String version;	
	private String vehicleno;	
	private String mode;
	private String passname;
	private String victimid;

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JSONObject getPassenger() {
		return passenger;
	}

	public void setPassenger(JSONObject passenger) {
		this.passenger = passenger;
	}

	public JSONObject getPedestriandoc() {
		return pedestriandoc;
	}

	public void setPedestriandoc(JSONObject pedestriandoc) {
		this.pedestriandoc = pedestriandoc;
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

	public String getVehicleno() {
		return vehicleno;
	}

	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
	}

	public String getPassname() {
		return passname;
	}

	public void setPassname(String passname) {
		this.passname = passname;
	}

	public String getVictimid() {
		return victimid;
	}

	public void setVictimid(String victimid) {
		this.victimid = victimid;
	}

	@Override
	public String toString() {
		return "Passenger [passenger=" + passenger + ", pedestriandoc=" + pedestriandoc + ", token=" + token
				+ ", version=" + version + ", vehicleno=" + vehicleno + ", mode=" + mode + ", passname=" + passname
				+ ", victimid=" + victimid + "]";
	}

	

}
