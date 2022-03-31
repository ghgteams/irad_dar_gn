package com.irad.dar.court;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sp_india_districts", schema = "spatial_layer")
public class CourtEntity {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="dtname")
	private String dtname;  
	
	@Column(name="dtcode11")
	private String dtcode11;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDtname() {
		return dtname;
	}

	public void setDtname(String dtname) {
		this.dtname = dtname;
	}

	public String getDtcode11() {
		return dtcode11;
	}

	public void setDtcode11(String dtcode11) {
		this.dtcode11 = dtcode11;
	}

	public CourtEntity(int id, String dtname, String dtcode11) {
		super();
		this.id = id;
		this.dtname = dtname;
		this.dtcode11 = dtcode11;
	}

	@Override
	public String toString() {
		return "CourtEntity [id=" + id + ", dtname=" + dtname + ", dtcode11=" + dtcode11 + "]";
	}

	public CourtEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
