package com.irad.dar.documents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "edar_forms_doc", schema = "documents")
public class EdarFormsDocEntity {
	@Id
	@Column(name="id")
	public long id;	
	
	@Column(name="accident_id")
	private String accidentId;    
	
	@Column(name="formno")
	private String formno;
	
	@Column(name="persontype")
	private String persontype;
	
	@Column(name="refid")
	private String refid;
	
	@Column(name="doctype")
	private String doctype;
	
	@Column(name="insertedon")
	private String insertedon;
	
	@Column(name="insertedby")
	private String insertedby;
	
	@Column(name="file")
	private String file;
	
	@Column(name="flag")
	private String flag;
	
	@Column(name="lastupdated")
	private String lastupdated;
	
	@Column(name="updatedby")
	private String updatedby;

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

	public String getRefid() {
		return refid;
	}

	public void setRefid(String refid) {
		this.refid = refid;
	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public String getInsertedon() {
		return insertedon;
	}

	public void setInsertedon(String insertedon) {
		this.insertedon = insertedon;
	}

	public String getInsertedby() {
		return insertedby;
	}

	public void setInsertedby(String insertedby) {
		this.insertedby = insertedby;
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

	public String getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(String lastupdated) {
		this.lastupdated = lastupdated;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public EdarFormsDocEntity(long id, String accidentId, String formno, String persontype, String refid,
			String doctype, String insertedon, String insertedby, String file, String flag, String lastupdated,
			String updatedby) {
		super();
		this.id = id;
		this.accidentId = accidentId;
		this.formno = formno;
		this.persontype = persontype;
		this.refid = refid;
		this.doctype = doctype;
		this.insertedon = insertedon;
		this.insertedby = insertedby;
		this.file = file;
		this.flag = flag;
		this.lastupdated = lastupdated;
		this.updatedby = updatedby;
	}

	@Override
	public String toString() {
		return "EdarFormsDocEntity [id=" + id + ", accidentId=" + accidentId + ", formno=" + formno + ", persontype="
				+ persontype + ", refid=" + refid + ", doctype=" + doctype + ", insertedon=" + insertedon
				+ ", insertedby=" + insertedby + ", file=" + file + ", flag=" + flag + ", lastupdated=" + lastupdated
				+ ", updatedby=" + updatedby + "]";
	}

	public EdarFormsDocEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
