package com.irad.dar.court;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sp_tn_taluk", schema = "spatial_layer")
public class TalukEntity {
	@Id
	@Column(name="gid")
	private String gId;
	
	@Column(name="dtcode11")
	private String dtcode11;
	
	@Column(name="ed_tlkcode")
	private String ed_tlkcode;
	
	@Column(name="talukname")
	private String talukname;

	public String getgId() {
		return gId;
	}

	public void setgId(String gId) {
		this.gId = gId;
	}

	public String getDtcode11() {
		return dtcode11;
	}

	public void setDtcode11(String dtcode11) {
		this.dtcode11 = dtcode11;
	}

	public String getEd_tlkcode() {
		return ed_tlkcode;
	}

	public void setEd_tlkcode(String ed_tlkcode) {
		this.ed_tlkcode = ed_tlkcode;
	}

	public String getTalukname() {
		return talukname;
	}

	public void setTalukname(String talukname) {
		this.talukname = talukname;
	}

	public TalukEntity(String gId, String dtcode11, String ed_tlkcode, String talukname) {
		super();
		this.gId = gId;
		this.dtcode11 = dtcode11;
		this.ed_tlkcode = ed_tlkcode;
		this.talukname = talukname;
	}

	@Override
	public String toString() {
		return "TalukEntity [gId=" + gId + ", dtcode11=" + dtcode11 + ", ed_tlkcode=" + ed_tlkcode + ", talukname="
				+ talukname + "]";
	}

	public TalukEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
