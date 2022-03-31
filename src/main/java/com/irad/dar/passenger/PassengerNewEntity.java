package com.irad.dar.passenger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dar_passenger", schema = "public")
public class PassengerNewEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;	
	
	@Column(name="acc_id")
	private String acc_id;    
	
	@Column(name="patient_disposition")
	private String patient_disposition;

	@Column(name="veh_no")
	private String veh_no;
	
	@Column(name="marital_status")
	private String marital_status;
	
	@Column(name="employed_or_not")
	private String employed_or_not;
	
	@Column(name="name_add_employer")
	private String name_add_employer;
	
	@Column(name="income")
	private String income;
	
	@Column(name="assessed_to_income_tax")
	private String assessed_to_income_tax;

	@Column(name="reimbursement_medical_expense")
	private String reimbursement_medical_expense;

	@Column(name="cashless_treatment")
	private String cashless_treatment;

	@Column(name="loss_to_property")
	private String loss_to_property;

	@Column(name="value_of_loss")
	private String value_of_loss;

	@Column(name="additional_info")
	private String additional_info;

	@Column(name="relief_amount")
	private String relief_amount;

	@Column(name="passenger_ref_id")
	private String passenger_ref_id;

	@Column(name="sole_earning_member")
	private String sole_earning_member;

	@Column(name="treatment_details_of_deceased")
	private String treatment_details_of_deceased;

	@Column(name="expense_details_of_deceased")
	private String expense_details_of_deceased;
	
	@Column(name="permanent_disability")
	private String permanent_disability;

	@Column(name="permanent_disability_details")
	private String permanent_disability_details;

	@Column(name="estimate_expenditure")
	private String estimate_expenditure;

	@Column(name="expenditure_conveyance")
	private String expenditure_conveyance;
	
	@Column(name="father_name")
	private String father_name;
	
	@Column(name="victim_remainder_date")
	private String victim_remainder_date;

	@Column(name="medical_expenses_incurred")
	private String medical_expenses_incurred;

	@Column(name="doctor_name")
	private String doctor_name;

	@Column(name="hospital_address")
	private String hospital_address;

	@Column(name="hospital_treatment_period")
	private String hospital_treatment_period;

	@Column(name="hospital_treatment_details")
	private String hospital_treatment_details;

	@Column(name="hospital_treatment_surgery_details")
	private String hospital_treatment_surgery_details;

	@Column(name="hospital_flag")
	private String hospital_flag;
	
	@Column(name="natureofinjury_description")
	private String natureofinjury_description;
	
	@Column(name="compensation_claimed")
	private String compensation_claimed;
	
	@Column(name="date_of_death")
	private String date_of_death;
	
	@Column(name="pecunairy_loss")
	private String pecunairy_loss;
	
	@Column(name="expendiure_on_treatment")
	private String expendiure_on_treatment;

	@Column(name="injury_type")
	private String injury_type;

	@Column(name="emailid")
	private String emailid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}

	public String getPatient_disposition() {
		return patient_disposition;
	}

	public void setPatient_disposition(String patient_disposition) {
		this.patient_disposition = patient_disposition;
	}

	public String getVeh_no() {
		return veh_no;
	}

	public void setVeh_no(String veh_no) {
		this.veh_no = veh_no;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getEmployed_or_not() {
		return employed_or_not;
	}

	public void setEmployed_or_not(String employed_or_not) {
		this.employed_or_not = employed_or_not;
	}

	public String getName_add_employer() {
		return name_add_employer;
	}

	public void setName_add_employer(String name_add_employer) {
		this.name_add_employer = name_add_employer;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getAssessed_to_income_tax() {
		return assessed_to_income_tax;
	}

	public void setAssessed_to_income_tax(String assessed_to_income_tax) {
		this.assessed_to_income_tax = assessed_to_income_tax;
	}

	public String getReimbursement_medical_expense() {
		return reimbursement_medical_expense;
	}

	public void setReimbursement_medical_expense(String reimbursement_medical_expense) {
		this.reimbursement_medical_expense = reimbursement_medical_expense;
	}

	public String getCashless_treatment() {
		return cashless_treatment;
	}

	public void setCashless_treatment(String cashless_treatment) {
		this.cashless_treatment = cashless_treatment;
	}

	public String getLoss_to_property() {
		return loss_to_property;
	}

	public void setLoss_to_property(String loss_to_property) {
		this.loss_to_property = loss_to_property;
	}

	public String getValue_of_loss() {
		return value_of_loss;
	}

	public void setValue_of_loss(String value_of_loss) {
		this.value_of_loss = value_of_loss;
	}

	public String getAdditional_info() {
		return additional_info;
	}

	public void setAdditional_info(String additional_info) {
		this.additional_info = additional_info;
	}

	public String getRelief_amount() {
		return relief_amount;
	}

	public void setRelief_amount(String relief_amount) {
		this.relief_amount = relief_amount;
	}

	public String getPassenger_ref_id() {
		return passenger_ref_id;
	}

	public void setPassenger_ref_id(String passenger_ref_id) {
		this.passenger_ref_id = passenger_ref_id;
	}

	public String getSole_earning_member() {
		return sole_earning_member;
	}

	public void setSole_earning_member(String sole_earning_member) {
		this.sole_earning_member = sole_earning_member;
	}

	public String getTreatment_details_of_deceased() {
		return treatment_details_of_deceased;
	}

	public void setTreatment_details_of_deceased(String treatment_details_of_deceased) {
		this.treatment_details_of_deceased = treatment_details_of_deceased;
	}

	public String getExpense_details_of_deceased() {
		return expense_details_of_deceased;
	}

	public void setExpense_details_of_deceased(String expense_details_of_deceased) {
		this.expense_details_of_deceased = expense_details_of_deceased;
	}

	public String getPermanent_disability() {
		return permanent_disability;
	}

	public void setPermanent_disability(String permanent_disability) {
		this.permanent_disability = permanent_disability;
	}

	public String getPermanent_disability_details() {
		return permanent_disability_details;
	}

	public void setPermanent_disability_details(String permanent_disability_details) {
		this.permanent_disability_details = permanent_disability_details;
	}

	public String getEstimate_expenditure() {
		return estimate_expenditure;
	}

	public void setEstimate_expenditure(String estimate_expenditure) {
		this.estimate_expenditure = estimate_expenditure;
	}

	public String getExpenditure_conveyance() {
		return expenditure_conveyance;
	}

	public void setExpenditure_conveyance(String expenditure_conveyance) {
		this.expenditure_conveyance = expenditure_conveyance;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getVictim_remainder_date() {
		return victim_remainder_date;
	}

	public void setVictim_remainder_date(String victim_remainder_date) {
		this.victim_remainder_date = victim_remainder_date;
	}

	public String getMedical_expenses_incurred() {
		return medical_expenses_incurred;
	}

	public void setMedical_expenses_incurred(String medical_expenses_incurred) {
		this.medical_expenses_incurred = medical_expenses_incurred;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getHospital_address() {
		return hospital_address;
	}

	public void setHospital_address(String hospital_address) {
		this.hospital_address = hospital_address;
	}

	public String getHospital_treatment_period() {
		return hospital_treatment_period;
	}

	public void setHospital_treatment_period(String hospital_treatment_period) {
		this.hospital_treatment_period = hospital_treatment_period;
	}

	public String getHospital_treatment_details() {
		return hospital_treatment_details;
	}

	public void setHospital_treatment_details(String hospital_treatment_details) {
		this.hospital_treatment_details = hospital_treatment_details;
	}

	public String getHospital_treatment_surgery_details() {
		return hospital_treatment_surgery_details;
	}

	public void setHospital_treatment_surgery_details(String hospital_treatment_surgery_details) {
		this.hospital_treatment_surgery_details = hospital_treatment_surgery_details;
	}

	public String getHospital_flag() {
		return hospital_flag;
	}

	public void setHospital_flag(String hospital_flag) {
		this.hospital_flag = hospital_flag;
	}

	public String getNatureofinjury_description() {
		return natureofinjury_description;
	}

	public void setNatureofinjury_description(String natureofinjury_description) {
		this.natureofinjury_description = natureofinjury_description;
	}

	public String getCompensation_claimed() {
		return compensation_claimed;
	}

	public void setCompensation_claimed(String compensation_claimed) {
		this.compensation_claimed = compensation_claimed;
	}

	public String getDate_of_death() {
		return date_of_death;
	}

	public void setDate_of_death(String date_of_death) {
		this.date_of_death = date_of_death;
	}

	public String getPecunairy_loss() {
		return pecunairy_loss;
	}

	public void setPecunairy_loss(String pecunairy_loss) {
		this.pecunairy_loss = pecunairy_loss;
	}

	public String getExpendiure_on_treatment() {
		return expendiure_on_treatment;
	}

	public void setExpendiure_on_treatment(String expendiure_on_treatment) {
		this.expendiure_on_treatment = expendiure_on_treatment;
	}

	public String getInjury_type() {
		return injury_type;
	}

	public void setInjury_type(String injury_type) {
		this.injury_type = injury_type;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Override
	public String toString() {
		return "PassengerNewEntity [id=" + id + ", acc_id=" + acc_id + ", patient_disposition=" + patient_disposition
				+ ", veh_no=" + veh_no + ", marital_status=" + marital_status + ", employed_or_not=" + employed_or_not
				+ ", name_add_employer=" + name_add_employer + ", income=" + income + ", assessed_to_income_tax="
				+ assessed_to_income_tax + ", reimbursement_medical_expense=" + reimbursement_medical_expense
				+ ", cashless_treatment=" + cashless_treatment + ", loss_to_property=" + loss_to_property
				+ ", value_of_loss=" + value_of_loss + ", additional_info=" + additional_info + ", relief_amount="
				+ relief_amount + ", passenger_ref_id=" + passenger_ref_id + ", sole_earning_member="
				+ sole_earning_member + ", treatment_details_of_deceased=" + treatment_details_of_deceased
				+ ", expense_details_of_deceased=" + expense_details_of_deceased + ", permanent_disability="
				+ permanent_disability + ", permanent_disability_details=" + permanent_disability_details
				+ ", estimate_expenditure=" + estimate_expenditure + ", expenditure_conveyance="
				+ expenditure_conveyance + ", father_name=" + father_name + ", victim_remainder_date="
				+ victim_remainder_date + ", medical_expenses_incurred=" + medical_expenses_incurred + ", doctor_name="
				+ doctor_name + ", hospital_address=" + hospital_address + ", hospital_treatment_period="
				+ hospital_treatment_period + ", hospital_treatment_details=" + hospital_treatment_details
				+ ", hospital_treatment_surgery_details=" + hospital_treatment_surgery_details + ", hospital_flag="
				+ hospital_flag + ", natureofinjury_description=" + natureofinjury_description
				+ ", compensation_claimed=" + compensation_claimed + ", date_of_death=" + date_of_death
				+ ", pecunairy_loss=" + pecunairy_loss + ", expendiure_on_treatment=" + expendiure_on_treatment
				+ ", injury_type=" + injury_type + ", emailid=" + emailid + "]";
	}

	public PassengerNewEntity(long id, String acc_id, String patient_disposition, String veh_no, String marital_status,
			String employed_or_not, String name_add_employer, String income, String assessed_to_income_tax,
			String reimbursement_medical_expense, String cashless_treatment, String loss_to_property,
			String value_of_loss, String additional_info, String relief_amount, String passenger_ref_id,
			String sole_earning_member, String treatment_details_of_deceased, String expense_details_of_deceased,
			String permanent_disability, String permanent_disability_details, String estimate_expenditure,
			String expenditure_conveyance, String father_name, String victim_remainder_date,
			String medical_expenses_incurred, String doctor_name, String hospital_address,
			String hospital_treatment_period, String hospital_treatment_details,
			String hospital_treatment_surgery_details, String hospital_flag, String natureofinjury_description,
			String compensation_claimed, String date_of_death, String pecunairy_loss, String expendiure_on_treatment,
			String injury_type, String emailid) {
		super();
		this.id = id;
		this.acc_id = acc_id;
		this.patient_disposition = patient_disposition;
		this.veh_no = veh_no;
		this.marital_status = marital_status;
		this.employed_or_not = employed_or_not;
		this.name_add_employer = name_add_employer;
		this.income = income;
		this.assessed_to_income_tax = assessed_to_income_tax;
		this.reimbursement_medical_expense = reimbursement_medical_expense;
		this.cashless_treatment = cashless_treatment;
		this.loss_to_property = loss_to_property;
		this.value_of_loss = value_of_loss;
		this.additional_info = additional_info;
		this.relief_amount = relief_amount;
		this.passenger_ref_id = passenger_ref_id;
		this.sole_earning_member = sole_earning_member;
		this.treatment_details_of_deceased = treatment_details_of_deceased;
		this.expense_details_of_deceased = expense_details_of_deceased;
		this.permanent_disability = permanent_disability;
		this.permanent_disability_details = permanent_disability_details;
		this.estimate_expenditure = estimate_expenditure;
		this.expenditure_conveyance = expenditure_conveyance;
		this.father_name = father_name;
		this.victim_remainder_date = victim_remainder_date;
		this.medical_expenses_incurred = medical_expenses_incurred;
		this.doctor_name = doctor_name;
		this.hospital_address = hospital_address;
		this.hospital_treatment_period = hospital_treatment_period;
		this.hospital_treatment_details = hospital_treatment_details;
		this.hospital_treatment_surgery_details = hospital_treatment_surgery_details;
		this.hospital_flag = hospital_flag;
		this.natureofinjury_description = natureofinjury_description;
		this.compensation_claimed = compensation_claimed;
		this.date_of_death = date_of_death;
		this.pecunairy_loss = pecunairy_loss;
		this.expendiure_on_treatment = expendiure_on_treatment;
		this.injury_type = injury_type;
		this.emailid = emailid;
	}

	public PassengerNewEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	 
	  
}
