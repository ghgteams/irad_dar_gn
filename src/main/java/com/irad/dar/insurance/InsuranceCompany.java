package com.irad.dar.insurance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sp_insurance_company")
public class InsuranceCompany {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="code")
	private int code;
	
	@Column(name="name")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InsuranceCompany(int id, String accidentId, int code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		return "InsuranceCompany [id=" + id + ", code=" + code + ", name=" + name + "]";
	}

	public InsuranceCompany() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
