package com.irad.dar.insurance;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "irad_dar_request_insurance", schema = "court")
public class InsuranceRegisterEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="accident_id")
	private String accidentId;
	
	@Column(name="status")
	private int status;
	
	@Column(name="req_datetime")
	private Date req_datetime;
	
	@Column(name="res_datetime")
	private Date res_datetime;
	
	@Column(name="req_pdf")
	private String req_pdf;
	
	@Column(name="res_officer")
	private String res_officer;
	
	@Column(name="remarks")
	private String remarks;

	@Column(name="req_officer")
	private String reqOfficer;
	
	@Column(name="ps_id")
	private String psId;
	
	@Column(name="insurance_id")
	private String insurance_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccidentId() {
		return accidentId;
	}

	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getReq_datetime() {
		return req_datetime;
	}

	public void setReq_datetime(Date req_datetime) {
		this.req_datetime = req_datetime;
	}

	public Date getRes_datetime() {
		return res_datetime;
	}

	public void setRes_datetime(Date res_datetime) {
		this.res_datetime = res_datetime;
	}

	public String getReq_pdf() {
		return req_pdf;
	}

	public void setReq_pdf(String req_pdf) {
		this.req_pdf = req_pdf;
	}

	public String getRes_officer() {
		return res_officer;
	}

	public void setRes_officer(String res_officer) {
		this.res_officer = res_officer;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getReqOfficer() {
		return reqOfficer;
	}

	public void setReqOfficer(String reqOfficer) {
		this.reqOfficer = reqOfficer;
	}

	public String getPsId() {
		return psId;
	}

	public void setPsId(String psId) {
		this.psId = psId;
	}

	public String getInsurance_id() {
		return insurance_id;
	}

	public InsuranceRegisterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "InsuranceRegisterEntity [id=" + id + ", accidentId=" + accidentId + ", status=" + status
				+ ", req_datetime=" + req_datetime + ", res_datetime=" + res_datetime + ", req_pdf=" + req_pdf
				+ ", res_officer=" + res_officer + ", remarks=" + remarks + ", reqOfficer=" + reqOfficer + ", psId="
				+ psId + ", insurance_id=" + insurance_id + "]";
	}

	public InsuranceRegisterEntity(int id, String accidentId, int status, Date req_datetime, Date res_datetime,
			String req_pdf, String res_officer, String remarks, String reqOfficer, String psId, String insurance_id) {
		super();
		this.id = id;
		this.accidentId = accidentId;
		this.status = status;
		this.req_datetime = req_datetime;
		this.res_datetime = res_datetime;
		this.req_pdf = req_pdf;
		this.res_officer = res_officer;
		this.remarks = remarks;
		this.reqOfficer = reqOfficer;
		this.psId = psId;
		this.insurance_id = insurance_id;
	}

	public void setInsurance_id(String insurance_id) {
		this.insurance_id = insurance_id;
	}

	
	
}
