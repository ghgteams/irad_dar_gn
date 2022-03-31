package com.irad.dar.pedestrian;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "irad_pedestrian", schema = "public")
public class PedestrianIradEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;	
	
	@Column(name="accident_id")
	private String accident_id;    
	
	@Column(name="name")
	private String name;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="residence")
	private String residence;
	
	@Column(name="occupation")
	private String occupation; 
	
	@Column(name="injury_severity")
	private String injury_severity;

	@Column(name="remarks")
	private String remarks;    
	
	@Column(name="age")
	private String age;
	
	@Column(name="ped_injurytype")
	private String ped_injurytype;
	
	@Column(name="ped_natureofinjury")
	private String ped_natureofinjury;
	
	@Column(name="vehicle_id")
	private String vehicle_id;
	
	@Column(name="nationality")
	private String nationality; 
	
	@Column(name="passport_nr")
	private String passport_nr;
	
	@Column(name="pedaction")
	private String pedaction;    
	
	@Column(name="pedpostion")
	private String pedpostion;
	
	@Column(name="modeoftransport")
	private String modeoftransport;
	
	@Column(name="hospitaldelay")
	private String hospitaldelay;
	
	@Column(name="whotookvictim_hpl")
	private String whotookvictim_hpl;
	
	@Column(name="treatment_deny")
	private String treatment_deny; 
	
	@Column(name="victim_hopitalizeddate")
	private String victim_hopitalizeddate;
	
	@Column(name="patient_id")
	private String patient_id;    
	
	@Column(name="pm_request")
	private String pm_request;
	
	@Column(name="pm_resultdate")
	private String pm_resultdate;
	
	@Column(name="pm_requestofficer")
	private String pm_requestofficer;
	
	@Column(name="pm_hospitalid")
	private String pm_hospitalid;
	
	@Column(name="pm_requestdate")
	private String pm_requestdate; 
	
	@Column(name="pm_request_policeid")
	private String pm_request_policeid;

	@Column(name="discharge_certificate")
	private String discharge_certificate;

	@Column(name="discharge_certificate_policestnid")
	private String discharge_certificate_policestnid;

	@Column(name="discharge_certificate_hpid")
	private String discharge_certificate_hpid;

	@Column(name="pm_hospitalshow")
	private String pm_hospitalshow;

	@Column(name="hospitalid")
	private String hospitalid;

	@Column(name="referral_flag")
	private String referral_flag;

	@Column(name="hp_refferal_done")
	private String hp_refferal_done;

	@Column(name="referral_hospitalid")
	private String referral_hospitalid;

	@Column(name="witness_flag")
	private String witness_flag;
	
	@Column(name="education")
	private String education;
	
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

	public String getAccident_id() {
		return accident_id;
	}

	public void setAccident_id(String accident_id) {
		this.accident_id = accident_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getInjury_severity() {
		return injury_severity;
	}

	public void setInjury_severity(String injury_severity) {
		this.injury_severity = injury_severity;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPed_injurytype() {
		return ped_injurytype;
	}

	public void setPed_injurytype(String ped_injurytype) {
		this.ped_injurytype = ped_injurytype;
	}

	public String getPed_natureofinjury() {
		return ped_natureofinjury;
	}

	public void setPed_natureofinjury(String ped_natureofinjury) {
		this.ped_natureofinjury = ped_natureofinjury;
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPassport_nr() {
		return passport_nr;
	}

	public void setPassport_nr(String passport_nr) {
		this.passport_nr = passport_nr;
	}

	public String getPedaction() {
		return pedaction;
	}

	public void setPedaction(String pedaction) {
		this.pedaction = pedaction;
	}

	public String getPedpostion() {
		return pedpostion;
	}

	public void setPedpostion(String pedpostion) {
		this.pedpostion = pedpostion;
	}

	public String getModeoftransport() {
		return modeoftransport;
	}

	public void setModeoftransport(String modeoftransport) {
		this.modeoftransport = modeoftransport;
	}

	public String getHospitaldelay() {
		return hospitaldelay;
	}

	public void setHospitaldelay(String hospitaldelay) {
		this.hospitaldelay = hospitaldelay;
	}

	public String getWhotookvictim_hpl() {
		return whotookvictim_hpl;
	}

	public void setWhotookvictim_hpl(String whotookvictim_hpl) {
		this.whotookvictim_hpl = whotookvictim_hpl;
	}

	public String getTreatment_deny() {
		return treatment_deny;
	}

	public void setTreatment_deny(String treatment_deny) {
		this.treatment_deny = treatment_deny;
	}

	public String getVictim_hopitalizeddate() {
		return victim_hopitalizeddate;
	}

	public void setVictim_hopitalizeddate(String victim_hopitalizeddate) {
		this.victim_hopitalizeddate = victim_hopitalizeddate;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public String getPm_request() {
		return pm_request;
	}

	public void setPm_request(String pm_request) {
		this.pm_request = pm_request;
	}

	public String getPm_resultdate() {
		return pm_resultdate;
	}

	public void setPm_resultdate(String pm_resultdate) {
		this.pm_resultdate = pm_resultdate;
	}

	public String getPm_requestofficer() {
		return pm_requestofficer;
	}

	public void setPm_requestofficer(String pm_requestofficer) {
		this.pm_requestofficer = pm_requestofficer;
	}

	public String getPm_hospitalid() {
		return pm_hospitalid;
	}

	public void setPm_hospitalid(String pm_hospitalid) {
		this.pm_hospitalid = pm_hospitalid;
	}

	public String getPm_requestdate() {
		return pm_requestdate;
	}

	public void setPm_requestdate(String pm_requestdate) {
		this.pm_requestdate = pm_requestdate;
	}

	public String getPm_request_policeid() {
		return pm_request_policeid;
	}

	public void setPm_request_policeid(String pm_request_policeid) {
		this.pm_request_policeid = pm_request_policeid;
	}

	public String getDischarge_certificate() {
		return discharge_certificate;
	}

	public void setDischarge_certificate(String discharge_certificate) {
		this.discharge_certificate = discharge_certificate;
	}

	public String getDischarge_certificate_policestnid() {
		return discharge_certificate_policestnid;
	}

	public void setDischarge_certificate_policestnid(String discharge_certificate_policestnid) {
		this.discharge_certificate_policestnid = discharge_certificate_policestnid;
	}

	public String getDischarge_certificate_hpid() {
		return discharge_certificate_hpid;
	}

	public void setDischarge_certificate_hpid(String discharge_certificate_hpid) {
		this.discharge_certificate_hpid = discharge_certificate_hpid;
	}

	public String getPm_hospitalshow() {
		return pm_hospitalshow;
	}

	public void setPm_hospitalshow(String pm_hospitalshow) {
		this.pm_hospitalshow = pm_hospitalshow;
	}

	public String getHospitalid() {
		return hospitalid;
	}

	public void setHospitalid(String hospitalid) {
		this.hospitalid = hospitalid;
	}

	public String getReferral_flag() {
		return referral_flag;
	}

	public void setReferral_flag(String referral_flag) {
		this.referral_flag = referral_flag;
	}

	public String getHp_refferal_done() {
		return hp_refferal_done;
	}

	public void setHp_refferal_done(String hp_refferal_done) {
		this.hp_refferal_done = hp_refferal_done;
	}

	public String getReferral_hospitalid() {
		return referral_hospitalid;
	}

	public void setReferral_hospitalid(String referral_hospitalid) {
		this.referral_hospitalid = referral_hospitalid;
	}

	public String getWitness_flag() {
		return witness_flag;
	}

	public void setWitness_flag(String witness_flag) {
		this.witness_flag = witness_flag;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
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

	public PedestrianIradEntity(int id, String accident_id, String name, String gender, String mobile, String residence,
			String occupation, String injury_severity, String remarks, String age, String ped_injurytype,
			String ped_natureofinjury, String vehicle_id, String nationality, String passport_nr, String pedaction,
			String pedpostion, String modeoftransport, String hospitaldelay, String whotookvictim_hpl,
			String treatment_deny, String victim_hopitalizeddate, String patient_id, String pm_request,
			String pm_resultdate, String pm_requestofficer, String pm_hospitalid, String pm_requestdate,
			String pm_request_policeid, String discharge_certificate, String discharge_certificate_policestnid,
			String discharge_certificate_hpid, String pm_hospitalshow, String hospitalid, String referral_flag,
			String hp_refferal_done, String referral_hospitalid, String witness_flag, String education,
			String patientdetails, String hp_details, String status) {
		super();
		this.id = id;
		this.accident_id = accident_id;
		this.name = name;
		this.gender = gender;
		this.mobile = mobile;
		this.residence = residence;
		this.occupation = occupation;
		this.injury_severity = injury_severity;
		this.remarks = remarks;
		this.age = age;
		this.ped_injurytype = ped_injurytype;
		this.ped_natureofinjury = ped_natureofinjury;
		this.vehicle_id = vehicle_id;
		this.nationality = nationality;
		this.passport_nr = passport_nr;
		this.pedaction = pedaction;
		this.pedpostion = pedpostion;
		this.modeoftransport = modeoftransport;
		this.hospitaldelay = hospitaldelay;
		this.whotookvictim_hpl = whotookvictim_hpl;
		this.treatment_deny = treatment_deny;
		this.victim_hopitalizeddate = victim_hopitalizeddate;
		this.patient_id = patient_id;
		this.pm_request = pm_request;
		this.pm_resultdate = pm_resultdate;
		this.pm_requestofficer = pm_requestofficer;
		this.pm_hospitalid = pm_hospitalid;
		this.pm_requestdate = pm_requestdate;
		this.pm_request_policeid = pm_request_policeid;
		this.discharge_certificate = discharge_certificate;
		this.discharge_certificate_policestnid = discharge_certificate_policestnid;
		this.discharge_certificate_hpid = discharge_certificate_hpid;
		this.pm_hospitalshow = pm_hospitalshow;
		this.hospitalid = hospitalid;
		this.referral_flag = referral_flag;
		this.hp_refferal_done = hp_refferal_done;
		this.referral_hospitalid = referral_hospitalid;
		this.witness_flag = witness_flag;
		this.education = education;
		this.patientdetails = patientdetails;
		this.hp_details = hp_details;
		this.status = status;
	}

	@Override
	public String toString() {
		return "PedestrianIradEntity [id=" + id + ", accident_id=" + accident_id + ", name=" + name + ", gender="
				+ gender + ", mobile=" + mobile + ", residence=" + residence + ", occupation=" + occupation
				+ ", injury_severity=" + injury_severity + ", remarks=" + remarks + ", age=" + age + ", ped_injurytype="
				+ ped_injurytype + ", ped_natureofinjury=" + ped_natureofinjury + ", vehicle_id=" + vehicle_id
				+ ", nationality=" + nationality + ", passport_nr=" + passport_nr + ", pedaction=" + pedaction
				+ ", pedpostion=" + pedpostion + ", modeoftransport=" + modeoftransport + ", hospitaldelay="
				+ hospitaldelay + ", whotookvictim_hpl=" + whotookvictim_hpl + ", treatment_deny=" + treatment_deny
				+ ", victim_hopitalizeddate=" + victim_hopitalizeddate + ", patient_id=" + patient_id + ", pm_request="
				+ pm_request + ", pm_resultdate=" + pm_resultdate + ", pm_requestofficer=" + pm_requestofficer
				+ ", pm_hospitalid=" + pm_hospitalid + ", pm_requestdate=" + pm_requestdate + ", pm_request_policeid="
				+ pm_request_policeid + ", discharge_certificate=" + discharge_certificate
				+ ", discharge_certificate_policestnid=" + discharge_certificate_policestnid
				+ ", discharge_certificate_hpid=" + discharge_certificate_hpid + ", pm_hospitalshow=" + pm_hospitalshow
				+ ", hospitalid=" + hospitalid + ", referral_flag=" + referral_flag + ", hp_refferal_done="
				+ hp_refferal_done + ", referral_hospitalid=" + referral_hospitalid + ", witness_flag=" + witness_flag
				+ ", education=" + education + ", patientdetails=" + patientdetails + ", hp_details=" + hp_details
				+ ", status=" + status + "]";
	}

	public PedestrianIradEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
