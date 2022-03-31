package com.irad.dar.pdf;

public class Pdf18Entity {
	private String date_of_award;
	private String case_number;
	private String title_of_case;
	private String award_amount;
	private String deposit_by_depositor;
	private String deposit_by_tribunal;
	private String amount_of_interest;
	private String amount_deposited;

	private String award_amount_interest_deposited;
	private String action_recover_award_interest;
	private String release_award_amount_claimnant;
	private String mode_of_release_award_amount;
	private String remarks;
	private String accident_id;
	private String currentDate;
	private String stateCode;
	public String getDate_of_award() {
		return date_of_award;
	}
	public void setDate_of_award(String date_of_award) {
		this.date_of_award = date_of_award;
	}
	public String getCase_number() {
		return case_number;
	}
	public void setCase_number(String case_number) {
		this.case_number = case_number;
	}
	public String getTitle_of_case() {
		return title_of_case;
	}
	public void setTitle_of_case(String title_of_case) {
		this.title_of_case = title_of_case;
	}
	public String getAward_amount() {
		return award_amount;
	}
	public void setAward_amount(String award_amount) {
		this.award_amount = award_amount;
	}
	public String getDeposit_by_depositor() {
		return deposit_by_depositor;
	}
	public void setDeposit_by_depositor(String deposit_by_depositor) {
		this.deposit_by_depositor = deposit_by_depositor;
	}
	public String getDeposit_by_tribunal() {
		return deposit_by_tribunal;
	}
	public void setDeposit_by_tribunal(String deposit_by_tribunal) {
		this.deposit_by_tribunal = deposit_by_tribunal;
	}
	public String getAmount_of_interest() {
		return amount_of_interest;
	}
	public void setAmount_of_interest(String amount_of_interest) {
		this.amount_of_interest = amount_of_interest;
	}
	public String getAmount_deposited() {
		return amount_deposited;
	}
	public void setAmount_deposited(String amount_deposited) {
		this.amount_deposited = amount_deposited;
	}
	public String getAward_amount_interest_deposited() {
		return award_amount_interest_deposited;
	}
	public void setAward_amount_interest_deposited(String award_amount_interest_deposited) {
		this.award_amount_interest_deposited = award_amount_interest_deposited;
	}
	public String getAction_recover_award_interest() {
		return action_recover_award_interest;
	}
	public void setAction_recover_award_interest(String action_recover_award_interest) {
		this.action_recover_award_interest = action_recover_award_interest;
	}
	public String getRelease_award_amount_claimnant() {
		return release_award_amount_claimnant;
	}
	public void setRelease_award_amount_claimnant(String release_award_amount_claimnant) {
		this.release_award_amount_claimnant = release_award_amount_claimnant;
	}
	public String getMode_of_release_award_amount() {
		return mode_of_release_award_amount;
	}
	public void setMode_of_release_award_amount(String mode_of_release_award_amount) {
		this.mode_of_release_award_amount = mode_of_release_award_amount;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getAccident_id() {
		return accident_id;
	}
	public void setAccident_id(String accident_id) {
		this.accident_id = accident_id;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public Pdf18Entity(String date_of_award, String case_number, String title_of_case, String award_amount,
			String deposit_by_depositor, String deposit_by_tribunal, String amount_of_interest, String amount_deposited,
			String award_amount_interest_deposited, String action_recover_award_interest,
			String release_award_amount_claimnant, String mode_of_release_award_amount, String remarks,
			String accident_id, String currentDate, String stateCode) {
		super();
		this.date_of_award = date_of_award;
		this.case_number = case_number;
		this.title_of_case = title_of_case;
		this.award_amount = award_amount;
		this.deposit_by_depositor = deposit_by_depositor;
		this.deposit_by_tribunal = deposit_by_tribunal;
		this.amount_of_interest = amount_of_interest;
		this.amount_deposited = amount_deposited;
		this.award_amount_interest_deposited = award_amount_interest_deposited;
		this.action_recover_award_interest = action_recover_award_interest;
		this.release_award_amount_claimnant = release_award_amount_claimnant;
		this.mode_of_release_award_amount = mode_of_release_award_amount;
		this.remarks = remarks;
		this.accident_id = accident_id;
		this.currentDate = currentDate;
		this.stateCode = stateCode;
	}
	@Override
	public String toString() {
		return "Pdf18Entity [date_of_award=" + date_of_award + ", case_number=" + case_number + ", title_of_case="
				+ title_of_case + ", award_amount=" + award_amount + ", deposit_by_depositor=" + deposit_by_depositor
				+ ", deposit_by_tribunal=" + deposit_by_tribunal + ", amount_of_interest=" + amount_of_interest
				+ ", amount_deposited=" + amount_deposited + ", award_amount_interest_deposited="
				+ award_amount_interest_deposited + ", action_recover_award_interest=" + action_recover_award_interest
				+ ", release_award_amount_claimnant=" + release_award_amount_claimnant
				+ ", mode_of_release_award_amount=" + mode_of_release_award_amount + ", remarks=" + remarks
				+ ", accident_id=" + accident_id + ", currentDate=" + currentDate + ", stateCode=" + stateCode + "]";
	}
	public Pdf18Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
}
