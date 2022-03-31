package com.irad.dar.tribunal;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable

public class Foem16Composite implements Serializable {

	 public String vehicle_id; 
	  public String accident_id;
	  public String person_id;
	  public String person_type;
	public String getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getAccident_id() {
		return accident_id;
	}
	public void setAccident_id(String accident_id) {
		this.accident_id = accident_id;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public String getPerson_type() {
		return person_type;
	}
	public void setPerson_type(String person_type) {
		this.person_type = person_type;
	}
	public Foem16Composite() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
	  
}
