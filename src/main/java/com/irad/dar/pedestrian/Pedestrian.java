package com.irad.dar.pedestrian;

import org.json.simple.JSONObject;

public class Pedestrian {
    private JSONObject pedestrian;
	
	private JSONObject pedestriandoc;

	private String token;
	private String vehicleno;	
	private String version;
	private String pedname;
	private String mode;
	private String accidentId;
	private String vehicleId;
	public JSONObject getPedestrian() {
		return pedestrian;
	}
	public void setPedestrian(JSONObject pedestrian) {
		this.pedestrian = pedestrian;
	}
	public JSONObject getPedestriandoc() {
		return pedestriandoc;
	}
	public void setPedestriandoc(JSONObject pedestriandoc) {
		this.pedestriandoc = pedestriandoc;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getVehicleno() {
		return vehicleno;
	}
	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getPedname() {
		return pedname;
	}
	public void setPedname(String pedname) {
		this.pedname = pedname;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getAccidentId() {
		return accidentId;
	}
	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	@Override
	public String toString() {
		return "Pedestrian [pedestrian=" + pedestrian + ", pedestriandoc=" + pedestriandoc + ", token=" + token
				+ ", vehicleno=" + vehicleno + ", version=" + version + ", pedname=" + pedname + ", mode=" + mode
				+ ", accidentId=" + accidentId + ", vehicleId=" + vehicleId + "]";
	}
	public Pedestrian() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
