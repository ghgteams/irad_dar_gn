package com.irad.dar.familydetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dar_family_details", schema = "public")
public class FamilydetailsEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="acc_id")
	private String accId;    
	@Column(name="ref_id")
	private String pedestrianId;  
	@Column(name="user_type")
	private String userType;  
	@Column(name="name")
	private String famName;
	@Column(name="age")
	private String famAge;  
	@Column(name="gender")
	private String famGender;   
	@Column(name="relation_type")
	private String famRelation;  
	@Column(name="marital_status")
	private String maritalStatus;   
	@Column(name="address")
	private String famAddress;  
	@Column(name="contact_number")
	private String famContact;
	
	public String getAccId() {
		return accId;
	}
	public void setAccId(String accId) {
		this.accId = accId;
	}
	public String getPedestrianId() {
		return pedestrianId;
	}
	public void setPedestrianId(String pedestrianId) {
		this.pedestrianId = pedestrianId;
	}	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getFamName() {
		return famName;
	}
	public void setFamName(String famName) {
		this.famName = famName;
	}
	public String getFamAge() {
		return famAge;
	}
	public void setFamAge(String famAge) {
		this.famAge = famAge;
	}
	
	public String getFamGender() {
		return famGender;
	}
	public void setFamGender(String famGender) {
		this.famGender = famGender;
	}
	public String getFamRelation() {
		return famRelation;
	}
	public void setFamRelation(String famRelation) {
		this.famRelation = famRelation;
	}
	public String getFamAddress() {
		return famAddress;
	}
	public void setFamAddress(String famAddress) {
		this.famAddress = famAddress;
	}
	public String getFamContact() {
		return famContact;
	}
	public void setFamContact(String famContact) {
		this.famContact = famContact;
	}
	public FamilydetailsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FamilydetailsEntity(long id, String accId, String pedestrianId, String userType, String famName,
			String famAge, String famGender, String famRelation, String maritalStatus, String famAddress,
			String famContact) {
		super();
		this.id = id;
		this.accId = accId;
		this.pedestrianId = pedestrianId;
		this.userType = userType;
		this.famName = famName;
		this.famAge = famAge;
		this.famGender = famGender;
		this.famRelation = famRelation;
		this.maritalStatus = maritalStatus;
		this.famAddress = famAddress;
		this.famContact = famContact;
	}
	@Override
	public String toString() {
		return "FamilydetailsEntity [id=" + id + ", accId=" + accId + ", pedestrianId=" + pedestrianId + ", userType="
				+ userType + ", famName=" + famName + ", famAge=" + famAge + ", famGender=" + famGender
				+ ", famRelation=" + famRelation + ", maritalStatus=" + maritalStatus + ", famAddress=" + famAddress
				+ ", famContact=" + famContact + "]";
	} 
	
	
	
	
	
}
