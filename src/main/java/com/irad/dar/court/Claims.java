package com.irad.dar.court;

public class Claims {
	private String accidentId;
	private int status;
	private String courtId;
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
	public String getCourtId() {
		return courtId;
	}
	public void setCourtId(String courtId) {
		this.courtId = courtId;
	}
	@Override
	public String toString() {
		return "Claims [accidentId=" + accidentId + ", status=" + status + ", courtId=" + courtId + "]";
	}
	public Claims() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
