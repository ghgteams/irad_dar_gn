package com.irad.dar.documents;

public class EdarDocuments {
	private String mode;
	
	private String mimetype;
	
	private String accidentid;

	private String formno;

	private String persontype;

	private int refid;
	
	private String doctype;
	
	private String docname;

	private String flag;

	private String file;
	
	private String version;
	
	private String srctypec;

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public String getAccidentid() {
		return accidentid;
	}

	public void setAccidentid(String accidentid) {
		this.accidentid = accidentid;
	}

	public String getFormno() {
		return formno;
	}

	public void setFormno(String formno) {
		this.formno = formno;
	}

	public String getPersontype() {
		return persontype;
	}

	public void setPersontype(String persontype) {
		this.persontype = persontype;
	}

	public int getRefid() {
		return refid;
	}

	public void setRefid(int refid) {
		this.refid = refid;
	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSrctypec() {
		return srctypec;
	}

	public void setSrctypec(String srctypec) {
		this.srctypec = srctypec;
	}

	public EdarDocuments(String mode, String mimetype, String accidentid, String formno, String persontype, int refid,
			String doctype, String docname, String flag, String file, String version, String srctypec) {
		super();
		this.mode = mode;
		this.mimetype = mimetype;
		this.accidentid = accidentid;
		this.formno = formno;
		this.persontype = persontype;
		this.refid = refid;
		this.doctype = doctype;
		this.docname = docname;
		this.flag = flag;
		this.file = file;
		this.version = version;
		this.srctypec = srctypec;
	}

	@Override
	public String toString() {
		return "EdarDocuments [mode=" + mode + ", mimetype=" + mimetype + ", accidentid=" + accidentid + ", formno="
				+ formno + ", persontype=" + persontype + ", refid=" + refid + ", doctype=" + doctype + ", docname="
				+ docname + ", flag=" + flag + ", file=" + file + ", version=" + version + ", srctypec=" + srctypec
				+ "]";
	}

	public EdarDocuments() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
