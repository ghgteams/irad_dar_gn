package com.irad.dar.documents;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "edar_forms_doc", schema = "documents")
public class EdarDocumentsEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public long id;	
	
	@Column(name="accident_id")
	private String accidentId;    
	
	@Column(name="formno")
	private String formNo;
	
	@Column(name="persontype")
	private String persontype;
	
	@Column(name="refid")
	private int refId;
	
	@Column(name="doctype")
	private String docType;    
	
	@Column(name="insertedon")
	private Date insertedOn;
	
	@Column(name="insertedby")
	private String insertedBy;
	
	@Column(name="file")
	private String file;
	
	@Column(name="flag")
	private String flag;    
	
	@Column(name="lastupdated")
	private Date lastUpdated;
	
	@Column(name="updatedby")
	private String updatedBy;
	
	@Column(name="doc_name")
	private String docName;
	
	@Column(name="srctypec")
	private String srctypec;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccidentId() {
		return accidentId;
	}

	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}

	public String getFormNo() {
		return formNo;
	}

	public void setFormNo(String formNo) {
		this.formNo = formNo;
	}

	public String getPersontype() {
		return persontype;
	}

	public void setPersontype(String persontype) {
		this.persontype = persontype;
	}

	public int getRefId() {
		return refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public Date getInsertedOn() {
		return insertedOn;
	}

	public void setInsertedOn(Date insertedOn) {
		this.insertedOn = insertedOn;
	}

	public String getInsertedBy() {
		return insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getSrctypec() {
		return srctypec;
	}

	public EdarDocumentsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EdarDocumentsEntity [id=" + id + ", accidentId=" + accidentId + ", formNo=" + formNo + ", persontype="
				+ persontype + ", refId=" + refId + ", docType=" + docType + ", insertedOn=" + insertedOn
				+ ", insertedBy=" + insertedBy + ", file=" + file + ", flag=" + flag + ", lastUpdated=" + lastUpdated
				+ ", updatedBy=" + updatedBy + ", docName=" + docName + ", srctypec=" + srctypec + "]";
	}

	public EdarDocumentsEntity(long id, String accidentId, String formNo, String persontype, int refId, String docType,
			Date insertedOn, String insertedBy, String file, String flag, Date lastUpdated, String updatedBy,
			String docName, String srctypec) {
		super();
		this.id = id;
		this.accidentId = accidentId;
		this.formNo = formNo;
		this.persontype = persontype;
		this.refId = refId;
		this.docType = docType;
		this.insertedOn = insertedOn;
		this.insertedBy = insertedBy;
		this.file = file;
		this.flag = flag;
		this.lastUpdated = lastUpdated;
		this.updatedBy = updatedBy;
		this.docName = docName;
		this.srctypec = srctypec;
	}

	public void setSrctypec(String srctypec) {
		this.srctypec = srctypec;
	}

	
	
}
