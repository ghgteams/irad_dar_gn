package com.irad.dar.slsa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "dar_slsa_injured", schema = "public")

public class SlsaInjuredEntity {

	
	/*
	 * @Column(name="id") private long id;
	 */
	
	@Column(name="id_insurance")
	private long id_insurance; 
	
	
	@Column(name="accident_id")
	private String accident_id; 
	@Id
	@Column(name="person_id")
	private String person_id; 
	
	@Column(name="person_type")
	private String person_type; 
	
	@Column(name="vehicle_id")
	private String vehicle_id;
	
	
	@Column(name="inj_permenant_disablity")
	private String inj_permenant_disablity;
	
	
	@Column(name="inj_treatment")
	private String inj_treatment;
	
	
	@Column(name="inj_convenance")
	private String inj_convenance;
	
	
	@Column(name="inj_special_diet")
	private String inj_special_diet;
	
	
	@Column(name="inj_cost_nursing_attendant")
	private String inj_cost_nursing_attendant;
	
	
	@Column(name="inj_cost_artificial_limp")
	private String inj_cost_artificial_limp;
	
	
	@Column(name="inj_loss_erning_capacity")
	private String inj_loss_erning_capacity;
	
	
	@Column(name="inj_loss_income")
	private String inj_loss_income;
	
	
	@Column(name="inj_any_other_loss")
	private String inj_any_other_loss;
	
	
	@Column(name="inj_com_mental_phy_shock")
	private String inj_com_mental_phy_shock;
	
	
	@Column(name="inj_pain_suffering")
	private String inj_pain_suffering;
	
	
	@Column(name="inj_loss_amenities")
	private String inj_loss_amenities;
	
	
	@Column(name="inj_loss_ear_inc_har_dis")
	private String inj_loss_ear_inc_har_dis;
	
	
	@Column(name="inj_name_of_hospital")
	private String inj_name_of_hospital;
	
	

	
	
	@Column(name="inj_got_reimpuresement")
	private String inj_got_reimpuresement;
	
	
	@Column(name="inj_treatment_still_continuing")
	private String inj_treatment_still_continuing;
	
	
	@Column(name="inj_any_other_loss_req_special_treatment")
	private String inj_any_other_loss_req_special_treatment;
	
	
	@Column(name="inj_percentage_disablity")
	private String inj_percentage_disablity;
	
	
	@Column(name="inj_loss_of_future_income")
	private String inj_loss_of_future_income;
	
	
	@Column(name="inj_any_other_pecuniary_loss")
	private String inj_any_other_pecuniary_loss;
	
	
	@Column(name="inj_total_copensation")
	private String inj_total_copensation;

	@Column(name="multiplier")
	private String multiplier;
	
	@Column(name="inj_income")
	private String inj_income;
	
	@Column(name="paying_cap_anual_income")
	private String paying_cap_anual_income;
	
	@Column(name="paying_cap_immovable_assets")
	private String paying_cap_immovable_assets;
	
	@Column(name="paying_cap_moveable_asset")
	private String paying_cap_moveable_asset;
	
	@Column(name="slsa_recommendation")
	private String slsa_recommendation;
	@Column(name="inj_anyother_non_pecuniary")
	private String inj_anyother_non_pecuniary;
	
	/*
	 * public long getId() { return id; }
	 * 
	 * 
	 * public void setId(long id) { this.id = id; }
	 */


	public long getId_insurance() {
		return id_insurance;
	}


	public String getInj_anyother_non_pecuniary() {
		return inj_anyother_non_pecuniary;
	}


	public void setInj_anyother_non_pecuniary(String inj_anyother_non_pecuniary) {
		this.inj_anyother_non_pecuniary = inj_anyother_non_pecuniary;
	}


	public String getPaying_cap_anual_income() {
		return paying_cap_anual_income;
	}


	public void setPaying_cap_anual_income(String paying_cap_anual_income) {
		this.paying_cap_anual_income = paying_cap_anual_income;
	}


	public String getPaying_cap_immovable_assets() {
		return paying_cap_immovable_assets;
	}


	public void setPaying_cap_immovable_assets(String paying_cap_immovable_assets) {
		this.paying_cap_immovable_assets = paying_cap_immovable_assets;
	}


	public String getPaying_cap_moveable_asset() {
		return paying_cap_moveable_asset;
	}


	public void setPaying_cap_moveable_asset(String paying_cap_moveable_asset) {
		this.paying_cap_moveable_asset = paying_cap_moveable_asset;
	}


	public String getSlsa_recommendation() {
		return slsa_recommendation;
	}


	public void setSlsa_recommendation(String slsa_recommendation) {
		this.slsa_recommendation = slsa_recommendation;
	}


	public String getInj_income() {
		return inj_income;
	}


	public void setInj_income(String inj_income) {
		this.inj_income = inj_income;
	}


	public String getMultiplier() {
		return multiplier;
	}


	public void setMultiplier(String multiplier) {
		this.multiplier = multiplier;
	}


	public void setId_insurance(long id_insurance) {
		this.id_insurance = id_insurance;
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


	public String getVehicle_id() {
		return vehicle_id;
	}


	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}


	public String getInj_permenant_disablity() {
		return inj_permenant_disablity;
	}


	public void setInj_permenant_disablity(String inj_permenant_disablity) {
		this.inj_permenant_disablity = inj_permenant_disablity;
	}


	public String getInj_treatment() {
		return inj_treatment;
	}


	public void setInj_treatment(String inj_treatment) {
		this.inj_treatment = inj_treatment;
	}


	public String getInj_convenance() {
		return inj_convenance;
	}


	public void setInj_convenance(String inj_convenance) {
		this.inj_convenance = inj_convenance;
	}


	public String getInj_special_diet() {
		return inj_special_diet;
	}


	public void setInj_special_diet(String inj_special_diet) {
		this.inj_special_diet = inj_special_diet;
	}


	public String getInj_cost_nursing_attendant() {
		return inj_cost_nursing_attendant;
	}


	public void setInj_cost_nursing_attendant(String inj_cost_nursing_attendant) {
		this.inj_cost_nursing_attendant = inj_cost_nursing_attendant;
	}


	public String getInj_cost_artificial_limp() {
		return inj_cost_artificial_limp;
	}


	public void setInj_cost_artificial_limp(String inj_cost_artificial_limp) {
		this.inj_cost_artificial_limp = inj_cost_artificial_limp;
	}


	public String getInj_loss_erning_capacity() {
		return inj_loss_erning_capacity;
	}


	public void setInj_loss_erning_capacity(String inj_loss_erning_capacity) {
		this.inj_loss_erning_capacity = inj_loss_erning_capacity;
	}


	public String getInj_loss_income() {
		return inj_loss_income;
	}


	public void setInj_loss_income(String inj_loss_income) {
		this.inj_loss_income = inj_loss_income;
	}


	public String getInj_any_other_loss() {
		return inj_any_other_loss;
	}


	public void setInj_any_other_loss(String inj_any_other_loss) {
		this.inj_any_other_loss = inj_any_other_loss;
	}


	public String getInj_com_mental_phy_shock() {
		return inj_com_mental_phy_shock;
	}


	public void setInj_com_mental_phy_shock(String inj_com_mental_phy_shock) {
		this.inj_com_mental_phy_shock = inj_com_mental_phy_shock;
	}


	public String getInj_pain_suffering() {
		return inj_pain_suffering;
	}


	public void setInj_pain_suffering(String inj_pain_suffering) {
		this.inj_pain_suffering = inj_pain_suffering;
	}


	public String getInj_loss_amenities() {
		return inj_loss_amenities;
	}


	public void setInj_loss_amenities(String inj_loss_amenities) {
		this.inj_loss_amenities = inj_loss_amenities;
	}


	public String getInj_loss_ear_inc_har_dis() {
		return inj_loss_ear_inc_har_dis;
	}


	public void setInj_loss_ear_inc_har_dis(String inj_loss_ear_inc_har_dis) {
		this.inj_loss_ear_inc_har_dis = inj_loss_ear_inc_har_dis;
	}


	public String getInj_name_of_hospital() {
		return inj_name_of_hospital;
	}


	public void setInj_name_of_hospital(String inj_name_of_hospital) {
		this.inj_name_of_hospital = inj_name_of_hospital;
	}




	public String getInj_got_reimpuresement() {
		return inj_got_reimpuresement;
	}


	public void setInj_got_reimpuresement(String inj_got_reimpuresement) {
		this.inj_got_reimpuresement = inj_got_reimpuresement;
	}


	public String getInj_treatment_still_continuing() {
		return inj_treatment_still_continuing;
	}


	public void setInj_treatment_still_continuing(String inj_treatment_still_continuing) {
		this.inj_treatment_still_continuing = inj_treatment_still_continuing;
	}


	public String getInj_any_other_loss_req_special_treatment() {
		return inj_any_other_loss_req_special_treatment;
	}


	public void setInj_any_other_loss_req_special_treatment(String inj_any_other_loss_req_special_treatment) {
		this.inj_any_other_loss_req_special_treatment = inj_any_other_loss_req_special_treatment;
	}


	public String getInj_percentage_disablity() {
		return inj_percentage_disablity;
	}


	public void setInj_percentage_disablity(String inj_percentage_disablity) {
		this.inj_percentage_disablity = inj_percentage_disablity;
	}


	public String getInj_loss_of_future_income() {
		return inj_loss_of_future_income;
	}


	public void setInj_loss_of_future_income(String inj_loss_of_future_income) {
		this.inj_loss_of_future_income = inj_loss_of_future_income;
	}


	public String getInj_any_other_pecuniary_loss() {
		return inj_any_other_pecuniary_loss;
	}


	public void setInj_any_other_pecuniary_loss(String inj_any_other_pecuniary_loss) {
		this.inj_any_other_pecuniary_loss = inj_any_other_pecuniary_loss;
	}


	public String getInj_total_copensation() {
		return inj_total_copensation;
	}


	public void setInj_total_copensation(String inj_total_copensation) {
		this.inj_total_copensation = inj_total_copensation;
	}
	

	
	
	
}
