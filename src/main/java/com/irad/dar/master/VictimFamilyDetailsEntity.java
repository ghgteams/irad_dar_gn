package com.irad.dar.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dar_family_details", schema = "public")
public class VictimFamilyDetailsEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="acc_id")
	private String acc_id;  
	
	@Column(name="ref_id")
	private String ref_id;

	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private String age;

	@Column(name="gender")
	private String gender;

	@Column(name="relation_type")
	private String relation_type;

	@Column(name="marital_status")
	private String marital_status;
	
	@Column(name="user_type")
	private String user_type;
	
	@Column(name="address")
	private String address;
	
	@Column(name="contact_number")
	private String contact_number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}

	public String getRef_id() {
		return ref_id;
	}

	public void setRef_id(String ref_id) {
		this.ref_id = ref_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRelation_type() {
		return relation_type;
	}

	public void setRelation_type(String relation_type) {
		this.relation_type = relation_type;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public VictimFamilyDetailsEntity(int id, String acc_id, String ref_id, String name, String age, String gender,
			String relation_type, String marital_status, String user_type, String address, String contact_number) {
		super();
		this.id = id;
		this.acc_id = acc_id;
		this.ref_id = ref_id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.relation_type = relation_type;
		this.marital_status = marital_status;
		this.user_type = user_type;
		this.address = address;
		this.contact_number = contact_number;
	}

	@Override
	public String toString() {
		return "VictimFamilyDetailsEntity [id=" + id + ", acc_id=" + acc_id + ", ref_id=" + ref_id + ", name=" + name
				+ ", age=" + age + ", gender=" + gender + ", relation_type=" + relation_type + ", marital_status="
				+ marital_status + ", user_type=" + user_type + ", address=" + address + ", contact_number="
				+ contact_number + "]";
	}

	public VictimFamilyDetailsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
