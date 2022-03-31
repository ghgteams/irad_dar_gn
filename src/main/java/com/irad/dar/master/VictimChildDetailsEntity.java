package com.irad.dar.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dar_minor_children_of_victim", schema = "public")
public class VictimChildDetailsEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="acc_id")
	private String acc_id;  
    
	@Column(name="age")
	private String age;
	
	@Column(name="annual_school_fee")
	private String annual_school_fee;

	@Column(name="any_injury")
	private String any_injury;
	
	@Column(name="caste")
	private String caste;

	@Column(name="child_disabled")
	private String child_disabled;
	
	@Column(name="child_disabled_details")
	private String child_disabled_details;
	
	@Column(name="contact_no")
	private String contact_no;
     

	@Column(name="cost_immediate_treatment")
	private String cost_immediate_treatment;

	@Column(name="cost_longterm_treatment")
	private String cost_longterm_treatment;
     
	@Column(name="cost_of_skill_development")
	private String cost_of_skill_development;
	
	@Column(name="diet_nutrition_expenses")
	private String diet_nutrition_expenses;
	
	@Column(name="economic_condition")
	private String economic_condition;
	
	@Column(name="ews_quota")
	private String ews_quota;
	
	@Column(name="family_income")
	private String family_income;

	@Column(name="father_name")
	private String father_name;

	@Column(name="going_to_school_or_not")
	private String going_to_school_or_not;

	@Column(name="guardian_name")
	private String guardian_name;

	@Column(name="injury_details")
	private String injury_details;
	
	@Column(name="level_of_education")
	private String level_of_education;
	
	@Column(name="long_term_support_required")
	private String long_term_support_required;
	
	@Column(name="loss_of_body_part")
	private String loss_of_body_part;
	
	@Column(name="monthly_school_fee")
	private String monthly_school_fee;
     
	@Column(name="mother_name")
	private String mother_name;
	
	@Column(name="name")
	private String name;
	
	@Column(name="other_fee")
	private String other_fee;
	
	@Column(name="permanent_address")
	private String permanent_address;
    
	@Column(name="present_address")
	private String present_address;
	
	@Column(name="private_management")
	private String private_management;
	
	@Column(name="psychological_counselling_required")
	private String psychological_counselling_required;
	
	@Column(name="pvt_tution_fee")
	private String pvt_tution_fee;

	@Column(name="school_region")
	private String school_region;

	@Column(name="school_syllabus")
	private String school_syllabus;

	@Column(name="sex")
	private String sex;

	@Column(name="type_of_skill_development")
	private String type_of_skill_development;
     
	@Column(name="victim_id")
	private String victim_id;

	@Column(name="whose_child")
	private String whose_child;

	@Column(name="user_type")
	private String user_type;

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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAnnual_school_fee() {
		return annual_school_fee;
	}

	public void setAnnual_school_fee(String annual_school_fee) {
		this.annual_school_fee = annual_school_fee;
	}

	public String getAny_injury() {
		return any_injury;
	}

	public void setAny_injury(String any_injury) {
		this.any_injury = any_injury;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getChild_disabled() {
		return child_disabled;
	}

	public void setChild_disabled(String child_disabled) {
		this.child_disabled = child_disabled;
	}

	public String getChild_disabled_details() {
		return child_disabled_details;
	}

	public void setChild_disabled_details(String child_disabled_details) {
		this.child_disabled_details = child_disabled_details;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getCost_immediate_treatment() {
		return cost_immediate_treatment;
	}

	public void setCost_immediate_treatment(String cost_immediate_treatment) {
		this.cost_immediate_treatment = cost_immediate_treatment;
	}

	public String getCost_longterm_treatment() {
		return cost_longterm_treatment;
	}

	public void setCost_longterm_treatment(String cost_longterm_treatment) {
		this.cost_longterm_treatment = cost_longterm_treatment;
	}

	public String getCost_of_skill_development() {
		return cost_of_skill_development;
	}

	public void setCost_of_skill_development(String cost_of_skill_development) {
		this.cost_of_skill_development = cost_of_skill_development;
	}

	public String getDiet_nutrition_expenses() {
		return diet_nutrition_expenses;
	}

	public void setDiet_nutrition_expenses(String diet_nutrition_expenses) {
		this.diet_nutrition_expenses = diet_nutrition_expenses;
	}

	public String getEconomic_condition() {
		return economic_condition;
	}

	public void setEconomic_condition(String economic_condition) {
		this.economic_condition = economic_condition;
	}

	public String getEws_quota() {
		return ews_quota;
	}

	public void setEws_quota(String ews_quota) {
		this.ews_quota = ews_quota;
	}

	public String getFamily_income() {
		return family_income;
	}

	public void setFamily_income(String family_income) {
		this.family_income = family_income;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getGoing_to_school_or_not() {
		return going_to_school_or_not;
	}

	public void setGoing_to_school_or_not(String going_to_school_or_not) {
		this.going_to_school_or_not = going_to_school_or_not;
	}

	public String getGuardian_name() {
		return guardian_name;
	}

	public void setGuardian_name(String guardian_name) {
		this.guardian_name = guardian_name;
	}

	public String getInjury_details() {
		return injury_details;
	}

	public void setInjury_details(String injury_details) {
		this.injury_details = injury_details;
	}

	public String getLevel_of_education() {
		return level_of_education;
	}

	public void setLevel_of_education(String level_of_education) {
		this.level_of_education = level_of_education;
	}

	public String getLong_term_support_required() {
		return long_term_support_required;
	}

	public void setLong_term_support_required(String long_term_support_required) {
		this.long_term_support_required = long_term_support_required;
	}

	public String getLoss_of_body_part() {
		return loss_of_body_part;
	}

	public void setLoss_of_body_part(String loss_of_body_part) {
		this.loss_of_body_part = loss_of_body_part;
	}

	public String getMonthly_school_fee() {
		return monthly_school_fee;
	}

	public void setMonthly_school_fee(String monthly_school_fee) {
		this.monthly_school_fee = monthly_school_fee;
	}

	public String getMother_name() {
		return mother_name;
	}

	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOther_fee() {
		return other_fee;
	}

	public void setOther_fee(String other_fee) {
		this.other_fee = other_fee;
	}

	public String getPermanent_address() {
		return permanent_address;
	}

	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}

	public String getPresent_address() {
		return present_address;
	}

	public void setPresent_address(String present_address) {
		this.present_address = present_address;
	}

	public String getPrivate_management() {
		return private_management;
	}

	public void setPrivate_management(String private_management) {
		this.private_management = private_management;
	}

	public String getPsychological_counselling_required() {
		return psychological_counselling_required;
	}

	public void setPsychological_counselling_required(String psychological_counselling_required) {
		this.psychological_counselling_required = psychological_counselling_required;
	}

	public String getPvt_tution_fee() {
		return pvt_tution_fee;
	}

	public void setPvt_tution_fee(String pvt_tution_fee) {
		this.pvt_tution_fee = pvt_tution_fee;
	}

	public String getSchool_region() {
		return school_region;
	}

	public void setSchool_region(String school_region) {
		this.school_region = school_region;
	}

	public String getSchool_syllabus() {
		return school_syllabus;
	}

	public void setSchool_syllabus(String school_syllabus) {
		this.school_syllabus = school_syllabus;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getType_of_skill_development() {
		return type_of_skill_development;
	}

	public void setType_of_skill_development(String type_of_skill_development) {
		this.type_of_skill_development = type_of_skill_development;
	}

	public String getVictim_id() {
		return victim_id;
	}

	public void setVictim_id(String victim_id) {
		this.victim_id = victim_id;
	}

	public String getWhose_child() {
		return whose_child;
	}

	public void setWhose_child(String whose_child) {
		this.whose_child = whose_child;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public VictimChildDetailsEntity(int id, String acc_id, String age, String annual_school_fee, String any_injury,
			String caste, String child_disabled, String child_disabled_details, String contact_no,
			String cost_immediate_treatment, String cost_longterm_treatment, String cost_of_skill_development,
			String diet_nutrition_expenses, String economic_condition, String ews_quota, String family_income,
			String father_name, String going_to_school_or_not, String guardian_name, String injury_details,
			String level_of_education, String long_term_support_required, String loss_of_body_part,
			String monthly_school_fee, String mother_name, String name, String other_fee, String permanent_address,
			String present_address, String private_management, String psychological_counselling_required,
			String pvt_tution_fee, String school_region, String school_syllabus, String sex,
			String type_of_skill_development, String victim_id, String whose_child, String user_type) {
		super();
		this.id = id;
		this.acc_id = acc_id;
		this.age = age;
		this.annual_school_fee = annual_school_fee;
		this.any_injury = any_injury;
		this.caste = caste;
		this.child_disabled = child_disabled;
		this.child_disabled_details = child_disabled_details;
		this.contact_no = contact_no;
		this.cost_immediate_treatment = cost_immediate_treatment;
		this.cost_longterm_treatment = cost_longterm_treatment;
		this.cost_of_skill_development = cost_of_skill_development;
		this.diet_nutrition_expenses = diet_nutrition_expenses;
		this.economic_condition = economic_condition;
		this.ews_quota = ews_quota;
		this.family_income = family_income;
		this.father_name = father_name;
		this.going_to_school_or_not = going_to_school_or_not;
		this.guardian_name = guardian_name;
		this.injury_details = injury_details;
		this.level_of_education = level_of_education;
		this.long_term_support_required = long_term_support_required;
		this.loss_of_body_part = loss_of_body_part;
		this.monthly_school_fee = monthly_school_fee;
		this.mother_name = mother_name;
		this.name = name;
		this.other_fee = other_fee;
		this.permanent_address = permanent_address;
		this.present_address = present_address;
		this.private_management = private_management;
		this.psychological_counselling_required = psychological_counselling_required;
		this.pvt_tution_fee = pvt_tution_fee;
		this.school_region = school_region;
		this.school_syllabus = school_syllabus;
		this.sex = sex;
		this.type_of_skill_development = type_of_skill_development;
		this.victim_id = victim_id;
		this.whose_child = whose_child;
		this.user_type = user_type;
	}

	@Override
	public String toString() {
		return "VictimChildDetailsEntity [id=" + id + ", acc_id=" + acc_id + ", age=" + age + ", annual_school_fee="
				+ annual_school_fee + ", any_injury=" + any_injury + ", caste=" + caste + ", child_disabled="
				+ child_disabled + ", child_disabled_details=" + child_disabled_details + ", contact_no=" + contact_no
				+ ", cost_immediate_treatment=" + cost_immediate_treatment + ", cost_longterm_treatment="
				+ cost_longterm_treatment + ", cost_of_skill_development=" + cost_of_skill_development
				+ ", diet_nutrition_expenses=" + diet_nutrition_expenses + ", economic_condition=" + economic_condition
				+ ", ews_quota=" + ews_quota + ", family_income=" + family_income + ", father_name=" + father_name
				+ ", going_to_school_or_not=" + going_to_school_or_not + ", guardian_name=" + guardian_name
				+ ", injury_details=" + injury_details + ", level_of_education=" + level_of_education
				+ ", long_term_support_required=" + long_term_support_required + ", loss_of_body_part="
				+ loss_of_body_part + ", monthly_school_fee=" + monthly_school_fee + ", mother_name=" + mother_name
				+ ", name=" + name + ", other_fee=" + other_fee + ", permanent_address=" + permanent_address
				+ ", present_address=" + present_address + ", private_management=" + private_management
				+ ", psychological_counselling_required=" + psychological_counselling_required + ", pvt_tution_fee="
				+ pvt_tution_fee + ", school_region=" + school_region + ", school_syllabus=" + school_syllabus
				+ ", sex=" + sex + ", type_of_skill_development=" + type_of_skill_development + ", victim_id="
				+ victim_id + ", whose_child=" + whose_child + ", user_type=" + user_type + "]";
	}

	public VictimChildDetailsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
