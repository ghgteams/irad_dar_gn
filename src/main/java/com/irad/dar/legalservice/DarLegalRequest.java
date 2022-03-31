package com.irad.dar.legalservice;

public class DarLegalRequest {
	private String accidentId;
	private String district;
	private String flag;
	private String legalId;
	private String mode;
	private int status;
	private String taluk;
	private String typeofcourt;
	
	public String getAccidentId() {
		return accidentId;
	}
	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getLegalId() {
		return legalId;
	}
	public void setLegalId(String legalId) {
		this.legalId = legalId;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTaluk() {
		return taluk;
	}
	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}
	public String getTypeofcourt() {
		return typeofcourt;
	}
	public void setTypeofcourt(String typeofcourt) {
		this.typeofcourt = typeofcourt;
	}
	public DarLegalRequest(String accidentId, String district, String flag, String legalId, String mode, int status,
			String taluk, String typeofcourt) {
		super();
		this.accidentId = accidentId;
		this.district = district;
		this.flag = flag;
		this.legalId = legalId;
		this.mode = mode;
		this.status = status;
		this.taluk = taluk;
		this.typeofcourt = typeofcourt;
	}
	@Override
	public String toString() {
		return "darLegalRequest [accidentId=" + accidentId + ", district=" + district + ", flag=" + flag + ", legalId="
				+ legalId + ", mode=" + mode + ", status=" + status + ", taluk=" + taluk + ", typeofcourt="
				+ typeofcourt + "]";
	}
	public DarLegalRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
