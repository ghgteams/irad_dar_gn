package com.irad.dar.tribunal;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dar_tribunal_compensation_death", schema = "public")
public class Form15Entity {
	@EmbeddedId
	private Form15Composite compId;
	
	@Column(name="death_income")
	private String death_income;
	
	@Column(name="death_future_prospects")
	private String death_future_prospects;
	
	@Column(name="death_less_personal_expenses")
	private String death_less_personal_expenses;
	
	@Column(name="death_monthly_loss_depedency")
	private String death_monthly_loss_depedency;
	
	@Column(name="death_anual_loss_depedency")
	private String death_anual_loss_depedency;
	
	@Column(name="death_mulltiplier")
	private String death_mulltiplier;
	
	@Column(name="death_total_loss_dependency")
	private String death_total_loss_dependency;
	
	@Column(name="death_medical_expenses")
	private String death_medical_expenses;
	
	@Column(name="death_loss_consortium")
	private String death_loss_consortium;
	
	@Column(name="death_loss_for_love_affection")
	private String death_loss_for_love_affection;
	
	@Column(name="death_loss_estate")
	private String death_loss_estate;
	
	@Column(name="death_loss_funeral_expenses")
	private String death_loss_funeral_expenses;
	
	@Column(name="death_total_compensation")
	private String death_total_compensation;
	
	@Column(name="death_rate_interest")
	private String death_rate_interest;
	
	@Column(name="death_interest_amount")
	private String death_interest_amount;
	
	@Column(name="total_amt_with_interest")
	private String total_amt_with_interest;
	
	@Column(name="award_amt_released")
	private String award_amt_released;
	
	@Column(name="award_amt_in_fdrs")
	private String award_amt_in_fdrs;
	
	@Column(name="mode_disbursement")
	private String mode_disbursement;
	
	@Column(name="nest_date_award")
	private String nest_date_award;
	
	

	
	@Column(name="insertedby")
	private String insertedby;



	  @Column(name="insertedon") 
	  private Date insertedon;
	  
	  

	public Date getInsertedon() {
		return insertedon;
	}




	public void setInsertedon(Date insertedon) {
		this.insertedon = insertedon;
	}




	public Form15Composite getCompId() {
		return compId;
	}




	public void setCompId(Form15Composite compId) {
		this.compId = compId;
	}




	public String getDeath_income() {
		return death_income;
	}




	public void setDeath_income(String death_income) {
		this.death_income = death_income;
	}




	public String getDeath_future_prospects() {
		return death_future_prospects;
	}




	public void setDeath_future_prospects(String death_future_prospects) {
		this.death_future_prospects = death_future_prospects;
	}




	public String getDeath_less_personal_expenses() {
		return death_less_personal_expenses;
	}




	public void setDeath_less_personal_expenses(String death_less_personal_expenses) {
		this.death_less_personal_expenses = death_less_personal_expenses;
	}




	public String getDeath_monthly_loss_depedency() {
		return death_monthly_loss_depedency;
	}




	public void setDeath_monthly_loss_depedency(String death_monthly_loss_depedency) {
		this.death_monthly_loss_depedency = death_monthly_loss_depedency;
	}




	public String getDeath_anual_loss_depedency() {
		return death_anual_loss_depedency;
	}




	public void setDeath_anual_loss_depedency(String death_anual_loss_depedency) {
		this.death_anual_loss_depedency = death_anual_loss_depedency;
	}




	public String getDeath_mulltiplier() {
		return death_mulltiplier;
	}




	public void setDeath_mulltiplier(String death_mulltiplier) {
		this.death_mulltiplier = death_mulltiplier;
	}




	public String getDeath_total_loss_dependency() {
		return death_total_loss_dependency;
	}




	public void setDeath_total_loss_dependency(String death_total_loss_dependency) {
		this.death_total_loss_dependency = death_total_loss_dependency;
	}




	public String getDeath_medical_expenses() {
		return death_medical_expenses;
	}




	public void setDeath_medical_expenses(String death_medical_expenses) {
		this.death_medical_expenses = death_medical_expenses;
	}




	public String getDeath_loss_consortium() {
		return death_loss_consortium;
	}




	public void setDeath_loss_consortium(String death_loss_consortium) {
		this.death_loss_consortium = death_loss_consortium;
	}




	public String getDeath_loss_for_love_affection() {
		return death_loss_for_love_affection;
	}




	public void setDeath_loss_for_love_affection(String death_loss_for_love_affection) {
		this.death_loss_for_love_affection = death_loss_for_love_affection;
	}




	public String getDeath_loss_estate() {
		return death_loss_estate;
	}




	public void setDeath_loss_estate(String death_loss_estate) {
		this.death_loss_estate = death_loss_estate;
	}




	public String getDeath_loss_funeral_expenses() {
		return death_loss_funeral_expenses;
	}




	public void setDeath_loss_funeral_expenses(String death_loss_funeral_expenses) {
		this.death_loss_funeral_expenses = death_loss_funeral_expenses;
	}




	public String getDeath_total_compensation() {
		return death_total_compensation;
	}




	public void setDeath_total_compensation(String death_total_compensation) {
		this.death_total_compensation = death_total_compensation;
	}




	public String getDeath_rate_interest() {
		return death_rate_interest;
	}




	public void setDeath_rate_interest(String death_rate_interest) {
		this.death_rate_interest = death_rate_interest;
	}




	public String getDeath_interest_amount() {
		return death_interest_amount;
	}




	public void setDeath_interest_amount(String death_interest_amount) {
		this.death_interest_amount = death_interest_amount;
	}




	public String getTotal_amt_with_interest() {
		return total_amt_with_interest;
	}




	public void setTotal_amt_with_interest(String total_amt_with_interest) {
		this.total_amt_with_interest = total_amt_with_interest;
	}




	public String getAward_amt_released() {
		return award_amt_released;
	}




	public void setAward_amt_released(String award_amt_released) {
		this.award_amt_released = award_amt_released;
	}




	public String getAward_amt_in_fdrs() {
		return award_amt_in_fdrs;
	}




	public void setAward_amt_in_fdrs(String award_amt_in_fdrs) {
		this.award_amt_in_fdrs = award_amt_in_fdrs;
	}




	public String getMode_disbursement() {
		return mode_disbursement;
	}




	public void setMode_disbursement(String mode_disbursement) {
		this.mode_disbursement = mode_disbursement;
	}




	public String getNest_date_award() {
		return nest_date_award;
	}




	public void setNest_date_award(String nest_date_award) {
		this.nest_date_award = nest_date_award;
	}




	public String getInsertedby() {
		return insertedby;
	}




	public void setInsertedby(String insertedby) {
		this.insertedby = insertedby;
	}
	
	
	
	
	
}
