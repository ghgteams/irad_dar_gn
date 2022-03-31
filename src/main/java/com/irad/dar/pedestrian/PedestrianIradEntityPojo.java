package com.irad.dar.pedestrian;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PedestrianIradEntityPojo {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;	
	
	@Column(name="name")
	private String name;    
	
	@Column(name="accident_id")
	private String accident_id;
	
	@Column(name="injury_severity")
	private String injury_severity;
	
	@Column(name="vehicle_id")
	private String vehicle_id;
	
	@Column(name="patient_id")
	private String patient_id;
	
	@Column(name="hospitalid")
	private String hospitalid; 
	
	@Column(name="patientdetails")
	private String patientdetails;
	
	@Column(name="hp_details")
	private String hp_details;
	
	@Column(name="status")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccident_id() {
		return accident_id;
	}

	public void setAccident_id(String accident_id) {
		this.accident_id = accident_id;
	}

	public String getInjury_severity() {
		return injury_severity;
	}

	public void setInjury_severity(String injury_severity) {
		this.injury_severity = injury_severity;
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public String getHospitalid() {
		return hospitalid;
	}

	public void setHospitalid(String hospitalid) {
		this.hospitalid = hospitalid;
	}

	public String getPatientdetails() {
		return patientdetails;
	}

	public void setPatientdetails(String patientdetails) {
		this.patientdetails = patientdetails;
	}

	public String getHp_details() {
		return hp_details;
	}

	public void setHp_details(String hp_details) {
		this.hp_details = hp_details;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PedestrianIradEntityPojo(int id, String name, String accident_id, String injury_severity, String vehicle_id,
			String patient_id, String hospitalid, String patientdetails, String hp_details, String status) {
		super();
		this.id = id;
		this.name = name;
		this.accident_id = accident_id;
		this.injury_severity = injury_severity;
		this.vehicle_id = vehicle_id;
		this.patient_id = patient_id;
		this.hospitalid = hospitalid;
		this.patientdetails = patientdetails;
		this.hp_details = hp_details;
		this.status = status;
	}

	@Override
	public String toString() {
		return "PedestrianIradEntityPojo [id=" + id + ", name=" + name + ", accident_id=" + accident_id
				+ ", injury_severity=" + injury_severity + ", vehicle_id=" + vehicle_id + ", patient_id=" + patient_id
				+ ", hospitalid=" + hospitalid + ", patientdetails=" + patientdetails + ", hp_details=" + hp_details
				+ ", status=" + status + "]";
	}

	public PedestrianIradEntityPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
