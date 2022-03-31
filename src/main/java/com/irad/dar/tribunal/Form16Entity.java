package com.irad.dar.tribunal;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dar_tribunal_compensation_injured", schema = "public")


public class Form16Entity {
	@EmbeddedId
	private Foem16Composite compId;
	
	
	

	@Column(name="treatment")
	private String treatment;
	
	@Column(name="convenance")
	private String convenance;
	
	@Column(name="special_diet")
	private String special_diet;
	
	@Column(name="cost_nursing_attendant")
	private String cost_nursing_attendant;
	
	@Column(name="cost_artificial_limp")
	private String cost_artificial_limp;
	
	@Column(name="loss_earning_cap")
	private String loss_earning_cap;
	
	@Column(name="loss_income")
	private String loss_income;
	
	
	 @Column(name="any_other_loss") private String any_other_loss;
	
	
	@Column(name="com_mental_phy_shock")
	private String com_mental_phy_shock;

	@Column(name="pain_suffering")
	private String pain_suffering;
	
	@Column(name="loss_amenities")
	private String loss_amenities;
	
	@Column(name="disfiguration")
	private String disfiguration;
	
	@Column(name="loss_of_marriage")
	private String loss_of_marriage;
	
	@Column(name="loss_ear_inc_har_dis")
	private String loss_ear_inc_har_dis;
	
	@Column(name="per_disablity")
	private String per_disablity;
	
	@Column(name="loss_ami_life_span")
	private String loss_ami_life_span;
	
	@Column(name="per_loss_earning")
	private String per_loss_earning;
	
	@Column(name="loss_future_income")
	private String loss_future_income;
	
	
	  @Column(name="total_copensation") 
	  private String total_copensation;
	
		@Column(name="interest")
		private String interest;
		
		
		@Column(name="interest_amount")
		private String interest_amount;
		
		@Column(name="total_amt_with_interest")
		private String total_amt_with_interest;
		
		@Column(name="award_amt_released")
		private String award_amt_released;
		
		
		 @Column(name="award_amt_in_fdrs") private String award_amt_in_fdrs;
		 
		
		@Column(name="mode_disbursement")
		private String mode_disbursement;
		
		@Column(name="nest_date_award")
		private String nest_date_award;
		
		@Column(name="insertedon")
		private Date insertedon;
		
		@Column(name="insertedby")
		private String insertedby;
		
		@Column(name="multiplier")
		private String multiplier;
		
		@Column(name="inj_income")
		private String inj_income;
		


		public String getMultiplier() {
			return multiplier;
		}

		public void setMultiplier(String multiplier) {
			this.multiplier = multiplier;
		}

		public String getInj_income() {
			return inj_income;
		}

		public void setInj_income(String inj_income) {
			this.inj_income = inj_income;
		}

		public String getTotal_copensation() {
			return total_copensation;
		}

		public void setTotal_copensation(String total_copensation) {
			this.total_copensation = total_copensation;
		}

		public Foem16Composite getCompId() {
			return compId;
		}

		public void setCompId(Foem16Composite compId) {
			this.compId = compId;
		}

		public String getTreatment() {
			return treatment;
		}

		public void setTreatment(String treatment) {
			this.treatment = treatment;
		}

		public String getConvenance() {
			return convenance;
		}

		public void setConvenance(String convenance) {
			this.convenance = convenance;
		}

		public String getSpecial_diet() {
			return special_diet;
		}

		public void setSpecial_diet(String special_diet) {
			this.special_diet = special_diet;
		}

		public String getCost_nursing_attendant() {
			return cost_nursing_attendant;
		}

		public void setCost_nursing_attendant(String cost_nursing_attendant) {
			this.cost_nursing_attendant = cost_nursing_attendant;
		}

		public String getCost_artificial_limp() {
			return cost_artificial_limp;
		}

		public void setCost_artificial_limp(String cost_artificial_limp) {
			this.cost_artificial_limp = cost_artificial_limp;
		}

		public String getLoss_earning_cap() {
			return loss_earning_cap;
		}

		public void setLoss_earning_cap(String loss_earning_cap) {
			this.loss_earning_cap = loss_earning_cap;
		}

		public String getLoss_income() {
			return loss_income;
		}

		public void setLoss_income(String loss_income) {
			this.loss_income = loss_income;
		}

	
		 public String getAny_other_loss() { return any_other_loss; }
		 
		 public void setAny_other_loss(String any_other_loss) { this.any_other_loss =
		 any_other_loss; }
		

		public String getCom_mental_phy_shock() {
			return com_mental_phy_shock;
		}

		public void setCom_mental_phy_shock(String com_mental_phy_shock) {
			this.com_mental_phy_shock = com_mental_phy_shock;
		}

		public String getPain_suffering() {
			return pain_suffering;
		}

		public void setPain_suffering(String pain_suffering) {
			this.pain_suffering = pain_suffering;
		}

	

		public String getLoss_amenities() {
			return loss_amenities;
		}

		public void setLoss_amenities(String loss_amenities) {
			this.loss_amenities = loss_amenities;
		}

		public String getDisfiguration() {
			return disfiguration;
		}

		public void setDisfiguration(String disfiguration) {
			this.disfiguration = disfiguration;
		}

		public String getLoss_of_marriage() {
			return loss_of_marriage;
		}

		public void setLoss_of_marriage(String loss_of_marriage) {
			this.loss_of_marriage = loss_of_marriage;
		}

		public String getLoss_ear_inc_har_dis() {
			return loss_ear_inc_har_dis;
		}

		public void setLoss_ear_inc_har_dis(String loss_ear_inc_har_dis) {
			this.loss_ear_inc_har_dis = loss_ear_inc_har_dis;
		}

		public String getPer_disablity() {
			return per_disablity;
		}

		public void setPer_disablity(String per_disablity) {
			this.per_disablity = per_disablity;
		}

		public String getLoss_ami_life_span() {
			return loss_ami_life_span;
		}

		public void setLoss_ami_life_span(String loss_ami_life_span) {
			this.loss_ami_life_span = loss_ami_life_span;
		}

		public String getPer_loss_earning() {
			return per_loss_earning;
		}

		public void setPer_loss_earning(String per_loss_earning) {
			this.per_loss_earning = per_loss_earning;
		}

		public String getLoss_future_income() {
			return loss_future_income;
		}

		public void setLoss_future_income(String loss_future_income) {
			this.loss_future_income = loss_future_income;
		}

	

		public String getInterest() {
			return interest;
		}

		public void setInterest(String interest) {
			this.interest = interest;
		}

		public String getInterest_amount() {
			return interest_amount;
		}

		public void setInterest_amount(String interest_amount) {
			this.interest_amount = interest_amount;
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

	
		public String getAward_amt_in_fdrs() { return award_amt_in_fdrs; }
		 
		public void setAward_amt_in_fdrs(String award_amt_in_fdrs) {
		 this.award_amt_in_fdrs = award_amt_in_fdrs; }
		

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

		public Date getInsertedon() {
			return insertedon;
		}

		public void setInsertedon(Date insertedon) {
			this.insertedon = insertedon;
		}

		public String getInsertedby() {
			return insertedby;
		}

		public void setInsertedby(String insertedby) {
			this.insertedby = insertedby;
		}
		
		
	
	
}
