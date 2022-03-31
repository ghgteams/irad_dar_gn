package com.irad.dar.court;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "irad_dar_request", schema = "court")
public class ClaimsEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="accident_id")
	private String accidentId;
	
	@Column(name="status")
	private int status;
	
	public ClaimsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="req_officer")
	private String reqOfficer;
	
	@Column(name="ps_id")
	private String psId;
	
	@Column(name="court_id")
	private String courtId;

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

	public String getCourtId() {
		return courtId;
	}

	public void setCourtId(String courtId) {
		this.courtId = courtId;
	}

	public ClaimsEntity(int id, String accidentId, int status, String reqOfficer, String psId, String courtId) {
		super();
		this.id = id;
		this.accidentId = accidentId;
		this.status = status;
		this.reqOfficer = reqOfficer;
		this.psId = psId;
		this.courtId = courtId;
	}

	@Override
	public String toString() {
		return "ClaimsEntity [id=" + id + ", accidentId=" + accidentId + ", status=" + status + ", reqOfficer="
				+ reqOfficer + ", psId=" + psId + ", courtId=" + courtId + "]";
	}

	
}
