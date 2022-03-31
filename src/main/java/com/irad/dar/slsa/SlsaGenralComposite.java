package com.irad.dar.slsa;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SlsaGenralComposite implements Serializable {
	
	  public String vehicle_id; 
	  public String accident_id;
	  public String person_id;
	  public String person_type;
	  public String getVehicle_id()
	  { 
		  return vehicle_id;
	 } 
	  public void setVehicle_id(String vehicle_id)
	  { this.vehicle_id =
	  vehicle_id;
	  } 
	  public String getAccident_id()
	  { return accident_id; } 
	  public
	  void setAccident_id(String accident_id) { this.accident_id = accident_id; }
	  
	  public String getPerson_id() { return person_id; }
	  public void
	  setPerson_id(String person_id) { this.person_id = person_id; } 
	  public String
	  getPerson_type() { return person_type; } 
	  public void setPerson_type(String
	  person_type) { this.person_type = person_type; }
	  public
	  SlsaGenralComposite(String vehicle_id, String accident_id, String person_id,String person_type)
	  { super(); this.vehicle_id = vehicle_id; this.accident_id
	= accident_id; this.person_id = person_id; this.person_type = person_type; }
	public SlsaGenralComposite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
