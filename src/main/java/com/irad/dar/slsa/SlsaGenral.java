package com.irad.dar.slsa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dar_slsa", schema = "public")

public class SlsaGenral {

	
	@EmbeddedId
	 private SlsaGenralComposite compId;
	  	  
//	  @Column(name="id") private long id;

	  
	  @Column(name="nature_of_injuries") private String nature_of_injuries;
	 
	  @Column(name="brief_description_of_offense") private String
	  brief_description_of_offense;
	  
	  
	  @Column(name="name")
	  private String name;
	  @Column(name="father_spouse_name")
	  private String father_spouse_name;
	  @Column(name="age")
	  private String age;
	  @Column(name="gender") 
	  private String gender;
	  @Column(name="marital_status")
	  private String marital_status;
	  @Column(name="present_address") 
	  private String present_address;
	  @Column(name="conatc_emailid")
	  private String conatc_emailid;
	  @Column(name="conatc_mobileno") 
	  private String conatc_mobileno;
	  @Column(name="emotional_harm") 
	  private String emotional_harm;
	  @Column(name="damage_lose") 
	  private String damage_lose;
	  @Column(name="any_damage_lose") 
	  private String any_damage_lose;
	  
	  @Column(name="physical_harm") 
	  private String physicalHarm;
	  
	  @Column(name="property_loss_damage") 
	  private String property_loss_damage;
	  
	  @Column(name="loss_suffered") 
	  private String loss_suffered;

	public SlsaGenralComposite getCompId() {
		return compId;
	}

	public void setCompId(SlsaGenralComposite compId) {
		this.compId = compId;
	}

	public String getNature_of_injuries() {
		return nature_of_injuries;
	}

	public void setNature_of_injuries(String nature_of_injuries) {
		this.nature_of_injuries = nature_of_injuries;
	}

	public String getBrief_description_of_offense() {
		return brief_description_of_offense;
	}

	public void setBrief_description_of_offense(String brief_description_of_offense) {
		this.brief_description_of_offense = brief_description_of_offense;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFather_spouse_name() {
		return father_spouse_name;
	}

	public void setFather_spouse_name(String father_spouse_name) {
		this.father_spouse_name = father_spouse_name;
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

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getPresent_address() {
		return present_address;
	}

	public void setPresent_address(String present_address) {
		this.present_address = present_address;
	}

	public String getConatc_emailid() {
		return conatc_emailid;
	}

	public void setConatc_emailid(String conatc_emailid) {
		this.conatc_emailid = conatc_emailid;
	}

	public String getConatc_mobileno() {
		return conatc_mobileno;
	}

	public void setConatc_mobileno(String conatc_mobileno) {
		this.conatc_mobileno = conatc_mobileno;
	}

	public String getEmotional_harm() {
		return emotional_harm;
	}

	public void setEmotional_harm(String emotional_harm) {
		this.emotional_harm = emotional_harm;
	}

	public String getDamage_lose() {
		return damage_lose;
	}

	public void setDamage_lose(String damage_lose) {
		this.damage_lose = damage_lose;
	}

	public String getAny_damage_lose() {
		return any_damage_lose;
	}

	public void setAny_damage_lose(String any_damage_lose) {
		this.any_damage_lose = any_damage_lose;
	}

	public String getPhysicalHarm() {
		return physicalHarm;
	}

	public void setPhysicalHarm(String physicalHarm) {
		this.physicalHarm = physicalHarm;
	}

	public String getProperty_loss_damage() {
		return property_loss_damage;
	}

	public void setProperty_loss_damage(String property_loss_damage) {
		this.property_loss_damage = property_loss_damage;
	}

	public String getLoss_suffered() {
		return loss_suffered;
	}

	public void setLoss_suffered(String loss_suffered) {
		this.loss_suffered = loss_suffered;
	}

	@Override
	public String toString() {
		return "SlsaGenral [compId=" + compId + ", nature_of_injuries=" + nature_of_injuries
				+ ", brief_description_of_offense=" + brief_description_of_offense + ", name=" + name
				+ ", father_spouse_name=" + father_spouse_name + ", age=" + age + ", gender=" + gender
				+ ", marital_status=" + marital_status + ", present_address=" + present_address + ", conatc_emailid="
				+ conatc_emailid + ", conatc_mobileno=" + conatc_mobileno + ", emotional_harm=" + emotional_harm
				+ ", damage_lose=" + damage_lose + ", any_damage_lose=" + any_damage_lose + ", physicalHarm="
				+ physicalHarm + ", property_loss_damage=" + property_loss_damage + ", loss_suffered=" + loss_suffered
				+ "]";
	}

	public SlsaGenral(SlsaGenralComposite compId, String nature_of_injuries, String brief_description_of_offense,
			String name, String father_spouse_name, String age, String gender, String marital_status,
			String present_address, String conatc_emailid, String conatc_mobileno, String emotional_harm,
			String damage_lose, String any_damage_lose, String physicalHarm, String property_loss_damage,
			String loss_suffered) {
		super();
		this.compId = compId;
		this.nature_of_injuries = nature_of_injuries;
		this.brief_description_of_offense = brief_description_of_offense;
		this.name = name;
		this.father_spouse_name = father_spouse_name;
		this.age = age;
		this.gender = gender;
		this.marital_status = marital_status;
		this.present_address = present_address;
		this.conatc_emailid = conatc_emailid;
		this.conatc_mobileno = conatc_mobileno;
		this.emotional_harm = emotional_harm;
		this.damage_lose = damage_lose;
		this.any_damage_lose = any_damage_lose;
		this.physicalHarm = physicalHarm;
		this.property_loss_damage = property_loss_damage;
		this.loss_suffered = loss_suffered;
	}

	public SlsaGenral() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	  
	

	
}
