package com.irad.dar.petitioners;

public class PetitionerDeceasedPojo {
	private String vehicle_id;
	private String accident_id;
	private String person_id;
	private String person_type;
	
	
	private String death_income;
	private String death_future_prospects;
	private String death_less_personal_expenses;
	private String death_monthly_loss_depedency;
	private String death_anual_loss_depedency;
	private String death_mulltiplier;
	private String death_total_loss_dependency;
	private String death_medical_expenses;
	private String death_loss_consortium;
	private String death_loss_for_love_affection;
	private String death_loss_estate;
	private String death_loss_funeral_expenses;
	private String death_total_compensation;
	private String death_interest;
	public String getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getAccident_id() {
		return accident_id;
	}
	public void setAccident_id(String accident_id) {
		this.accident_id = accident_id;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public String getPerson_type() {
		return person_type;
	}
	public void setPerson_type(String person_type) {
		this.person_type = person_type;
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
	public String getDeath_interest() {
		return death_interest;
	}
	public void setDeath_interest(String death_interest) {
		this.death_interest = death_interest;
	}
	public PetitionerDeceasedPojo(String vehicle_id, String accident_id, String person_id, String person_type,
			String death_income, String death_future_prospects, String death_less_personal_expenses,
			String death_monthly_loss_depedency, String death_anual_loss_depedency, String death_mulltiplier,
			String death_total_loss_dependency, String death_medical_expenses, String death_loss_consortium,
			String death_loss_for_love_affection, String death_loss_estate, String death_loss_funeral_expenses,
			String death_total_compensation, String death_interest) {
		super();
		this.vehicle_id = vehicle_id;
		this.accident_id = accident_id;
		this.person_id = person_id;
		this.person_type = person_type;
		this.death_income = death_income;
		this.death_future_prospects = death_future_prospects;
		this.death_less_personal_expenses = death_less_personal_expenses;
		this.death_monthly_loss_depedency = death_monthly_loss_depedency;
		this.death_anual_loss_depedency = death_anual_loss_depedency;
		this.death_mulltiplier = death_mulltiplier;
		this.death_total_loss_dependency = death_total_loss_dependency;
		this.death_medical_expenses = death_medical_expenses;
		this.death_loss_consortium = death_loss_consortium;
		this.death_loss_for_love_affection = death_loss_for_love_affection;
		this.death_loss_estate = death_loss_estate;
		this.death_loss_funeral_expenses = death_loss_funeral_expenses;
		this.death_total_compensation = death_total_compensation;
		this.death_interest = death_interest;
	}
	@Override
	public String toString() {
		return "PetitionerDeceasedPojo [vehicle_id=" + vehicle_id + ", accident_id=" + accident_id + ", person_id="
				+ person_id + ", person_type=" + person_type + ", death_income=" + death_income
				+ ", death_future_prospects=" + death_future_prospects + ", death_less_personal_expenses="
				+ death_less_personal_expenses + ", death_monthly_loss_depedency=" + death_monthly_loss_depedency
				+ ", death_anual_loss_depedency=" + death_anual_loss_depedency + ", death_mulltiplier="
				+ death_mulltiplier + ", death_total_loss_dependency=" + death_total_loss_dependency
				+ ", death_medical_expenses=" + death_medical_expenses + ", death_loss_consortium="
				+ death_loss_consortium + ", death_loss_for_love_affection=" + death_loss_for_love_affection
				+ ", death_loss_estate=" + death_loss_estate + ", death_loss_funeral_expenses="
				+ death_loss_funeral_expenses + ", death_total_compensation=" + death_total_compensation
				+ ", death_interest=" + death_interest + "]";
	}
	public PetitionerDeceasedPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
