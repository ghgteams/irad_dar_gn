package com.irad.dar.pdf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "irad_vehicle", schema = "public")
public class vehicleDetailsEntity {
	@Id
	@Column(name="accident_id")
	private String accidentId;
	
	@Column(name="id")
	private int id;
	
	@Column(name="vehicle_reg_no")
	private String vehicleRegNo;
	
	@Column(name="chasis_number")
	private String chasisNumber;
	
	@Column(name="registration_date")
	private String registrationDate;
	
	@Column(name="engine_nr")
	private String engineNr;
}
