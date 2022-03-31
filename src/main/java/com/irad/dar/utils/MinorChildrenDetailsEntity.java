package com.irad.dar.utils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dar_minor_children_of_victim", schema = "public")
public class MinorChildrenDetailsEntity {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;	
	
	@Column(name="acc_id")
	private String accId;    
	
	@Column(name="victim_id")
	private String victimId;
	
	@Column(name="name")
	private String name; 
	
	@Column(name="age")
	private String age;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="caste")
	private String caste;    
	
	@Column(name="father_name")
	private String fatherName;
	
	@Column(name="mother_name")
	private String motherName; 
	
	@Column(name="guardian_name")
	private String guardianName;
	
	@Column(name="family_income")
	private String familyIncome;
	
	@Column(name="permanent_address")
	private String permanentAddress;    
	
	@Column(name="present_address")
	private String presentAddress;
	
	@Column(name="contact_no")
	private String contactNo; 
	
	@Column(name="child_disabled")
	private String childDisabled;
	
	@Column(name="child_disabled_details")
	private String childDisableddetails;
	
	@Column(name="economic_condition")
	private String economicCondition;    
	
	@Column(name="level_of_education")
	private String levelOfeducation;
	
	@Column(name="ews_quota")
	private String ewsQuota; 
	
	@Column(name="going_to_school_or_not")
	private String goingToschoolornot;
	
	@Column(name="school_region")
	private String schoolRegion;
	
	@Column(name="school_syllabus")
	private String schoolSyllabus;    
	
	@Column(name="private_management")
	private String privateManagement;
	
	@Column(name="monthly_school_fee")
	private String monthlySchoolfee; 
	
	@Column(name="annual_school_fee")
	private String annualSchoolfee;
	
	@Column(name="pvt_tution_fee")
	private String pvtTutionfee;
	
	@Column(name="other_fee")
	private String otherFee;
	
	@Column(name="type_of_skill_development")
	private String typeOfskilldevelopment;    
	
	@Column(name="cost_of_skill_development")
	private String costOfskilldevelopment;
	
	@Column(name="any_injury")
	private String anyInjury; 
	
	@Column(name="injury_details")
	private String injuryDetails;
	
	@Column(name="loss_of_body_part")
	private String lossOfbodypart;
	
	@Column(name="psychological_counselling_required")
	private String psychologicalCounsellingrequired;
	
	@Column(name="long_term_support_required")
	private String longTermsupportrequired;    
	
	@Column(name="cost_immediate_treatment")
	private String costImmediatetreatment;
	
	@Column(name="cost_longterm_treatment")
	private String costLongtermtreatment; 
	
	@Column(name="diet_nutrition_expenses")
	private String dietNutritionexpenses;
	
	@Column(name="whose_child")
	private String whoseChild;

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public String getVictimId() {
		return victimId;
	}

	public void setVictimId(String victimId) {
		this.victimId = victimId;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getFamilyIncome() {
		return familyIncome;
	}

	public void setFamilyIncome(String familyIncome) {
		this.familyIncome = familyIncome;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getChildDisabled() {
		return childDisabled;
	}

	public void setChildDisabled(String childDisabled) {
		this.childDisabled = childDisabled;
	}

	public String getChildDisableddetails() {
		return childDisableddetails;
	}

	public void setChildDisableddetails(String childDisableddetails) {
		this.childDisableddetails = childDisableddetails;
	}

	public String getEconomicCondition() {
		return economicCondition;
	}

	public void setEconomicCondition(String economicCondition) {
		this.economicCondition = economicCondition;
	}

	public String getLevelOfeducation() {
		return levelOfeducation;
	}

	public void setLevelOfeducation(String levelOfeducation) {
		this.levelOfeducation = levelOfeducation;
	}

	public String getEwsQuota() {
		return ewsQuota;
	}

	public void setEwsQuota(String ewsQuota) {
		this.ewsQuota = ewsQuota;
	}

	public String getGoingToschoolornot() {
		return goingToschoolornot;
	}

	public void setGoingToschoolornot(String goingToschoolornot) {
		this.goingToschoolornot = goingToschoolornot;
	}

	public String getSchoolRegion() {
		return schoolRegion;
	}

	public void setSchoolRegion(String schoolRegion) {
		this.schoolRegion = schoolRegion;
	}

	public String getSchoolSyllabus() {
		return schoolSyllabus;
	}

	public void setSchoolSyllabus(String schoolSyllabus) {
		this.schoolSyllabus = schoolSyllabus;
	}

	public String getPrivateManagement() {
		return privateManagement;
	}

	public void setPrivateManagement(String privateManagement) {
		this.privateManagement = privateManagement;
	}

	public String getMonthlySchoolfee() {
		return monthlySchoolfee;
	}

	public void setMonthlySchoolfee(String monthlySchoolfee) {
		this.monthlySchoolfee = monthlySchoolfee;
	}

	public String getAnnualSchoolfee() {
		return annualSchoolfee;
	}

	public void setAnnualSchoolfee(String annualSchoolfee) {
		this.annualSchoolfee = annualSchoolfee;
	}

	public String getPvtTutionfee() {
		return pvtTutionfee;
	}

	public void setPvtTutionfee(String pvtTutionfee) {
		this.pvtTutionfee = pvtTutionfee;
	}

	public String getOtherFee() {
		return otherFee;
	}

	public void setOtherFee(String otherFee) {
		this.otherFee = otherFee;
	}

	public String getTypeOfskilldevelopment() {
		return typeOfskilldevelopment;
	}

	public void setTypeOfskilldevelopment(String typeOfskilldevelopment) {
		this.typeOfskilldevelopment = typeOfskilldevelopment;
	}

	public String getCostOfskilldevelopment() {
		return costOfskilldevelopment;
	}

	public void setCostOfskilldevelopment(String costOfskilldevelopment) {
		this.costOfskilldevelopment = costOfskilldevelopment;
	}

	public String getAnyInjury() {
		return anyInjury;
	}

	public void setAnyInjury(String anyInjury) {
		this.anyInjury = anyInjury;
	}

	public String getInjuryDetails() {
		return injuryDetails;
	}

	public void setInjuryDetails(String injuryDetails) {
		this.injuryDetails = injuryDetails;
	}

	public String getLossOfbodypart() {
		return lossOfbodypart;
	}

	public void setLossOfbodypart(String lossOfbodypart) {
		this.lossOfbodypart = lossOfbodypart;
	}

	public String getPsychologicalCounsellingrequired() {
		return psychologicalCounsellingrequired;
	}

	public void setPsychologicalCounsellingrequired(String psychologicalCounsellingrequired) {
		this.psychologicalCounsellingrequired = psychologicalCounsellingrequired;
	}

	public String getLongTermsupportrequired() {
		return longTermsupportrequired;
	}

	public void setLongTermsupportrequired(String longTermsupportrequired) {
		this.longTermsupportrequired = longTermsupportrequired;
	}

	public String getCostImmediatetreatment() {
		return costImmediatetreatment;
	}

	public void setCostImmediatetreatment(String costImmediatetreatment) {
		this.costImmediatetreatment = costImmediatetreatment;
	}

	public String getCostLongtermtreatment() {
		return costLongtermtreatment;
	}

	public void setCostLongtermtreatment(String costLongtermtreatment) {
		this.costLongtermtreatment = costLongtermtreatment;
	}

	public String getDietNutritionexpenses() {
		return dietNutritionexpenses;
	}

	public void setDietNutritionexpenses(String dietNutritionexpenses) {
		this.dietNutritionexpenses = dietNutritionexpenses;
	}

	public String getWhoseChild() {
		return whoseChild;
	}

	public void setWhoseChild(String whoseChild) {
		this.whoseChild = whoseChild;
	}

	public MinorChildrenDetailsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MinorChildrenDetailsEntity(long id, String accId, String victimId, String name, String age, String sex,
			String caste, String fatherName, String motherName, String guardianName, String familyIncome,
			String permanentAddress, String presentAddress, String contactNo, String childDisabled,
			String childDisableddetails, String economicCondition, String levelOfeducation, String ewsQuota,
			String goingToschoolornot, String schoolRegion, String schoolSyllabus, String privateManagement,
			String monthlySchoolfee, String annualSchoolfee, String pvtTutionfee, String otherFee,
			String typeOfskilldevelopment, String costOfskilldevelopment, String anyInjury, String injuryDetails,
			String lossOfbodypart, String psychologicalCounsellingrequired, String longTermsupportrequired,
			String costImmediatetreatment, String costLongtermtreatment, String dietNutritionexpenses,
			String whoseChild) {
		super();
		this.id = id;
		this.accId = accId;
		this.victimId = victimId;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.caste = caste;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.guardianName = guardianName;
		this.familyIncome = familyIncome;
		this.permanentAddress = permanentAddress;
		this.presentAddress = presentAddress;
		this.contactNo = contactNo;
		this.childDisabled = childDisabled;
		this.childDisableddetails = childDisableddetails;
		this.economicCondition = economicCondition;
		this.levelOfeducation = levelOfeducation;
		this.ewsQuota = ewsQuota;
		this.goingToschoolornot = goingToschoolornot;
		this.schoolRegion = schoolRegion;
		this.schoolSyllabus = schoolSyllabus;
		this.privateManagement = privateManagement;
		this.monthlySchoolfee = monthlySchoolfee;
		this.annualSchoolfee = annualSchoolfee;
		this.pvtTutionfee = pvtTutionfee;
		this.otherFee = otherFee;
		this.typeOfskilldevelopment = typeOfskilldevelopment;
		this.costOfskilldevelopment = costOfskilldevelopment;
		this.anyInjury = anyInjury;
		this.injuryDetails = injuryDetails;
		this.lossOfbodypart = lossOfbodypart;
		this.psychologicalCounsellingrequired = psychologicalCounsellingrequired;
		this.longTermsupportrequired = longTermsupportrequired;
		this.costImmediatetreatment = costImmediatetreatment;
		this.costLongtermtreatment = costLongtermtreatment;
		this.dietNutritionexpenses = dietNutritionexpenses;
		this.whoseChild = whoseChild;
	}

	@Override
	public String toString() {
		return "MinorChildrenDetailsEntity [id=" + id + ", accId=" + accId + ", victimId=" + victimId + ", name=" + name
				+ ", age=" + age + ", sex=" + sex + ", caste=" + caste + ", fatherName=" + fatherName + ", motherName="
				+ motherName + ", guardianName=" + guardianName + ", familyIncome=" + familyIncome
				+ ", permanentAddress=" + permanentAddress + ", presentAddress=" + presentAddress + ", contactNo="
				+ contactNo + ", childDisabled=" + childDisabled + ", childDisableddetails=" + childDisableddetails
				+ ", economicCondition=" + economicCondition + ", levelOfeducation=" + levelOfeducation + ", ewsQuota="
				+ ewsQuota + ", goingToschoolornot=" + goingToschoolornot + ", schoolRegion=" + schoolRegion
				+ ", schoolSyllabus=" + schoolSyllabus + ", privateManagement=" + privateManagement
				+ ", monthlySchoolfee=" + monthlySchoolfee + ", annualSchoolfee=" + annualSchoolfee + ", pvtTutionfee="
				+ pvtTutionfee + ", otherFee=" + otherFee + ", typeOfskilldevelopment=" + typeOfskilldevelopment
				+ ", costOfskilldevelopment=" + costOfskilldevelopment + ", anyInjury=" + anyInjury + ", injuryDetails="
				+ injuryDetails + ", lossOfbodypart=" + lossOfbodypart + ", psychologicalCounsellingrequired="
				+ psychologicalCounsellingrequired + ", longTermsupportrequired=" + longTermsupportrequired
				+ ", costImmediatetreatment=" + costImmediatetreatment + ", costLongtermtreatment="
				+ costLongtermtreatment + ", dietNutritionexpenses=" + dietNutritionexpenses + ", whoseChild="
				+ whoseChild + "]";
	}
	
	
	
	

}
