package com.irad.dar.witness;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "irad_witness", schema = "public")
public class WitnessEntity {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;	
	@Column(name="accident_id")
	public String accId;	
	@Column(name="name")
	public String name;
	@Column(name="gender")
	public String gender;
	@Column(name="mobile")
	public String mobile;
	@Column(name="residence")
	public String residence;
	@Column(name="gurardian_name")
	public String guardianName;
	@Column(name="guaridan_type")
	public String guaridanType;
	@Column(name="age")
	public String age;
	@Column(name="occupation")
	public String occupation;
	@Column(name="audio")
	public String audio;
	
	
	
	public String getAccId() {
		return accId;
	}
	public void setAccId(String accId) {
		this.accId = accId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	public String getGuardianName() {
		return guardianName;
	}
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	public String getGuaridanType() {
		return guaridanType;
	}
	public void setGuaridanType(String guaridanType) {
		this.guaridanType = guaridanType;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	public WitnessEntity() {
		super();
	}
	public WitnessEntity(long id, String accId, String name, String gender, String mobile, String residence,
			String guardianName, String guaridanType, String age, String occupation, String audio) {
		super();
		this.id = id;
		this.accId = accId;
		this.name = name;
		this.gender = gender;
		this.mobile = mobile;
		this.residence = residence;
		this.guardianName = guardianName;
		this.guaridanType = guaridanType;
		this.age = age;
		this.occupation = occupation;
		this.audio = audio;
	}
	@Override
	public String toString() {
		return "WitnessEntity [id=" + id + ", accId=" + accId + ", name=" + name + ", gender=" + gender + ", mobile="
				+ mobile + ", residence=" + residence + ", guardianName=" + guardianName + ", guaridanType="
				+ guaridanType + ", age=" + age + ", occupation=" + occupation + ", audio=" + audio + "]";
	}	
	
	

}
