package com.irad.dar.general;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "irad_vehicle", schema = "public")
public class VehicleDetails {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="vehicle")
	private String vehicle;
	@Column(name="accused_victim")
	private String accusedVictim;
	@Column(name="insurance_details")
	private String insuranceDetails;
	@Column(name="insurance_policyno")
	private String insurancePolicyno;
	@Column(name="insurance_validity")
	private String insuranceValidity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getAccusedVictim() {
		return accusedVictim;
	}
	public void setAccusedVictim(String accusedVictim) {
		this.accusedVictim = accusedVictim;
	}
	public String getInsuranceDetails() {
		return insuranceDetails;
	}
	public void setInsuranceDetails(String insuranceDetails) {
		this.insuranceDetails = insuranceDetails;
	}
	public String getInsurancePolicyno() {
		return insurancePolicyno;
	}
	public void setInsurancePolicyno(String insurancePolicyno) {
		this.insurancePolicyno = insurancePolicyno;
	}
	public String getInsuranceValidity() {
		return insuranceValidity;
	}
	public void setInsuranceValidity(String insuranceValidity) {
		this.insuranceValidity = insuranceValidity;
	}
	public VehicleDetails(int id, String vehicle, String accusedVictim, String insuranceDetails,
			String insurancePolicyno, String insuranceValidity) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.accusedVictim = accusedVictim;
		this.insuranceDetails = insuranceDetails;
		this.insurancePolicyno = insurancePolicyno;
		this.insuranceValidity = insuranceValidity;
	}
	@Override
	public String toString() {
		return "VehicleDetails [id=" + id + ", vehicle=" + vehicle + ", accusedVictim=" + accusedVictim
				+ ", insuranceDetails=" + insuranceDetails + ", insurancePolicyno=" + insurancePolicyno
				+ ", insuranceValidity=" + insuranceValidity + "]";
	}
	public VehicleDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
