package com.irad.dar.documents;

public class EdarFormsDoc {

	private String accidentId;    
	private String formno;
	private String mode;
	public String token;	
	public String version;
	public String getAccidentId() {
		return accidentId;
	}
	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}
	public String getFormno() {
		return formno;
	}
	public void setFormno(String formno) {
		this.formno = formno;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public EdarFormsDoc(String accidentId, String formno, String mode, String token, String version) {
		super();
		this.accidentId = accidentId;
		this.formno = formno;
		this.mode = mode;
		this.token = token;
		this.version = version;
	}
	public EdarFormsDoc() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
}
