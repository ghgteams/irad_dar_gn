package com.irad.dar.documents;

public class DarDocuments {
	private String accidentId;

	private String documents;

	private String modeOfTheDocument;

	private String nameOfTheDocument;
	
	private String linkId;
	
	private String remarks;

	private boolean active;

	private String insertedBy;
	
	private String token;
	
	private String version;

	public DarDocuments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAccidentId() {
		return accidentId;
	}

	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}

	public String getDocuments() {
		return documents;
	}

	public void setDocuments(String documents) {
		this.documents = documents;
	}

	public String getModeOfTheDocument() {
		return modeOfTheDocument;
	}

	public void setModeOfTheDocument(String modeOfTheDocument) {
		this.modeOfTheDocument = modeOfTheDocument;
	}

	public String getNameOfTheDocument() {
		return nameOfTheDocument;
	}

	public void setNameOfTheDocument(String nameOfTheDocument) {
		this.nameOfTheDocument = nameOfTheDocument;
	}

	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	public String getInsertedBy() {
		return insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
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

	@Override
	public String toString() {
		return "DarDocuments [accidentId=" + accidentId + ", documents=" + documents + ", modeOfTheDocument="
				+ modeOfTheDocument + ", nameOfTheDocument=" + nameOfTheDocument + ", linkId=" + linkId + ", remarks="
				+ remarks + ", active=" + active +  ", insertedBy=" + insertedBy
				+ ", token=" + token + ", version=" + version + "]";
	}

	
}
