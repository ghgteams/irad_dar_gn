package com.irad.dar.passenger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dar_passenger", schema = "public")
public class PassengerEntity {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;	

	@Column(name="acc_id")
	private String accId;    
	
	@Column(name="patient_disposition")
	private String patientDisposition;
	
	@Column(name="victim_or_not")
	private boolean victimOrNot; 
	
	@Column(name="veh_no")
	private String vehNo;
	
	@Column(name="passenger_name")
	private String passengerName;

	@Column(name="submit_check")
	private boolean submitCheck;
	
//////////////////////////////////////////
	
	@Column(name="marital_status")
	private String maritalStatus;
	
	@Column(name="occupation_name")
	private String occupationName; 
	
	@Column(name="employed_or_not")
	private boolean employedOrnot;
	
	@Column(name="name_add_employer")
	private String nameAddressemployer;
	
	@Column(name="income")
	private String income;
	
	@Column(name="assessed_to_income_tax")
	private boolean assessedToincometax;
	
	@Column(name="reimbursement_medical_expense")
	private boolean reimbursementMedicalexpense;
	
	@Column(name="cashless_treatment")
	private boolean cashlessTreatment;
	
	@Column(name="loss_to_property")
	private String lossToproperty;
	
	@Column(name="value_of_loss")
	private String valueOfloss;

	@Column(name="additional_info")
	private String additionalInfo;
	
	@Column(name="relief_amount")
	private String reliefAmount;
	
	@Column(name="passenger_ref_id")
	private String passengerId;
	
	@Column(name="victim_remainder_date")
	private String victimRemainderdate;
	///////////////////////////////////////
	@Column(name="sole_earning_member")
	private String soleEarningmember;
	
	@Column(name="treatment_details_of_deceased")
	private String treatmentDetailsofdeceased;
	
	@Column(name="expense_details_of_deceased")
	private String expenseDetailsofdeceased;
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="permanent_disability")
	private String permanentDisability;
	
	@Column(name="permanent_disability_details")
	private String permanentDisabilitydetails;
	
	@Column(name="estimate_expenditure")
	private String estimateExpenditure;
	
	@Column(name="expenditure_conveyance")
	private String expenditureConveyance;
	
	@Column(name="victim_type")
	private String victimType;
	
	@Column(name="father_name")
	private String fatherName;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="period_hospitlization")
	private String periodHospitlization;
	
	@Column(name="treatment_details")
	private String treatmentDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public String getPatientDisposition() {
		return patientDisposition;
	}

	public void setPatientDisposition(String patientDisposition) {
		this.patientDisposition = patientDisposition;
	}

	public boolean isVictimOrNot() {
		return victimOrNot;
	}

	public void setVictimOrNot(boolean victimOrNot) {
		this.victimOrNot = victimOrNot;
	}

	public String getVehNo() {
		return vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public boolean isSubmitCheck() {
		return submitCheck;
	}

	public void setSubmitCheck(boolean submitCheck) {
		this.submitCheck = submitCheck;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getOccupationName() {
		return occupationName;
	}

	public void setOccupationName(String occupationName) {
		this.occupationName = occupationName;
	}

	public boolean isEmployedOrnot() {
		return employedOrnot;
	}

	public void setEmployedOrnot(boolean employedOrnot) {
		this.employedOrnot = employedOrnot;
	}

	public String getNameAddressemployer() {
		return nameAddressemployer;
	}

	public void setNameAddressemployer(String nameAddressemployer) {
		this.nameAddressemployer = nameAddressemployer;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public boolean isAssessedToincometax() {
		return assessedToincometax;
	}

	public void setAssessedToincometax(boolean assessedToincometax) {
		this.assessedToincometax = assessedToincometax;
	}

	public boolean isReimbursementMedicalexpense() {
		return reimbursementMedicalexpense;
	}

	public void setReimbursementMedicalexpense(boolean reimbursementMedicalexpense) {
		this.reimbursementMedicalexpense = reimbursementMedicalexpense;
	}

	public boolean isCashlessTreatment() {
		return cashlessTreatment;
	}

	public void setCashlessTreatment(boolean cashlessTreatment) {
		this.cashlessTreatment = cashlessTreatment;
	}

	public String getLossToproperty() {
		return lossToproperty;
	}

	public void setLossToproperty(String lossToproperty) {
		this.lossToproperty = lossToproperty;
	}

	public String getValueOfloss() {
		return valueOfloss;
	}

	public void setValueOfloss(String valueOfloss) {
		this.valueOfloss = valueOfloss;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getReliefAmount() {
		return reliefAmount;
	}

	public void setReliefAmount(String reliefAmount) {
		this.reliefAmount = reliefAmount;
	}

	public String getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	public String getVictimRemainderdate() {
		return victimRemainderdate;
	}

	public void setVictimRemainderdate(String victimRemainderdate) {
		this.victimRemainderdate = victimRemainderdate;
	}

	public String getSoleEarningmember() {
		return soleEarningmember;
	}

	public void setSoleEarningmember(String soleEarningmember) {
		this.soleEarningmember = soleEarningmember;
	}

	public String getTreatmentDetailsofdeceased() {
		return treatmentDetailsofdeceased;
	}

	public void setTreatmentDetailsofdeceased(String treatmentDetailsofdeceased) {
		this.treatmentDetailsofdeceased = treatmentDetailsofdeceased;
	}

	public String getExpenseDetailsofdeceased() {
		return expenseDetailsofdeceased;
	}

	public void setExpenseDetailsofdeceased(String expenseDetailsofdeceased) {
		this.expenseDetailsofdeceased = expenseDetailsofdeceased;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getPermanentDisability() {
		return permanentDisability;
	}

	public void setPermanentDisability(String permanentDisability) {
		this.permanentDisability = permanentDisability;
	}

	public String getPermanentDisabilitydetails() {
		return permanentDisabilitydetails;
	}

	public void setPermanentDisabilitydetails(String permanentDisabilitydetails) {
		this.permanentDisabilitydetails = permanentDisabilitydetails;
	}

	public String getEstimateExpenditure() {
		return estimateExpenditure;
	}

	public void setEstimateExpenditure(String estimateExpenditure) {
		this.estimateExpenditure = estimateExpenditure;
	}

	public String getExpenditureConveyance() {
		return expenditureConveyance;
	}

	public void setExpenditureConveyance(String expenditureConveyance) {
		this.expenditureConveyance = expenditureConveyance;
	}

	public String getVictimType() {
		return victimType;
	}

	public void setVictimType(String victimType) {
		this.victimType = victimType;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPeriodHospitlization() {
		return periodHospitlization;
	}

	public void setPeriodHospitlization(String periodHospitlization) {
		this.periodHospitlization = periodHospitlization;
	}

	public String getTreatmentDetails() {
		return treatmentDetails;
	}

	public void setTreatmentDetails(String treatmentDetails) {
		this.treatmentDetails = treatmentDetails;
	}

	public PassengerEntity(long id, String accId, String patientDisposition, boolean victimOrNot, String vehNo,
			String passengerName, boolean submitCheck, String maritalStatus, String occupationName,
			boolean employedOrnot, String nameAddressemployer, String income, boolean assessedToincometax,
			boolean reimbursementMedicalexpense, boolean cashlessTreatment, String lossToproperty, String valueOfloss,
			String additionalInfo, String reliefAmount, String passengerId, String victimRemainderdate,
			String soleEarningmember, String treatmentDetailsofdeceased, String expenseDetailsofdeceased,
			String schoolName, String permanentDisability, String permanentDisabilitydetails,
			String estimateExpenditure, String expenditureConveyance, String victimType, String fatherName, String dob,
			String periodHospitlization, String treatmentDetails) {
		super();
		this.id = id;
		this.accId = accId;
		this.patientDisposition = patientDisposition;
		this.victimOrNot = victimOrNot;
		this.vehNo = vehNo;
		this.passengerName = passengerName;
		this.submitCheck = submitCheck;
		this.maritalStatus = maritalStatus;
		this.occupationName = occupationName;
		this.employedOrnot = employedOrnot;
		this.nameAddressemployer = nameAddressemployer;
		this.income = income;
		this.assessedToincometax = assessedToincometax;
		this.reimbursementMedicalexpense = reimbursementMedicalexpense;
		this.cashlessTreatment = cashlessTreatment;
		this.lossToproperty = lossToproperty;
		this.valueOfloss = valueOfloss;
		this.additionalInfo = additionalInfo;
		this.reliefAmount = reliefAmount;
		this.passengerId = passengerId;
		this.victimRemainderdate = victimRemainderdate;
		this.soleEarningmember = soleEarningmember;
		this.treatmentDetailsofdeceased = treatmentDetailsofdeceased;
		this.expenseDetailsofdeceased = expenseDetailsofdeceased;
		this.schoolName = schoolName;
		this.permanentDisability = permanentDisability;
		this.permanentDisabilitydetails = permanentDisabilitydetails;
		this.estimateExpenditure = estimateExpenditure;
		this.expenditureConveyance = expenditureConveyance;
		this.victimType = victimType;
		this.fatherName = fatherName;
		this.dob = dob;
		this.periodHospitlization = periodHospitlization;
		this.treatmentDetails = treatmentDetails;
	}

	@Override
	public String toString() {
		return "PassengerEntity [id=" + id + ", accId=" + accId + ", patientDisposition=" + patientDisposition
				+ ", victimOrNot=" + victimOrNot + ", vehNo=" + vehNo + ", passengerName=" + passengerName
				+ ", submitCheck=" + submitCheck + ", maritalStatus=" + maritalStatus + ", occupationName="
				+ occupationName + ", employedOrnot=" + employedOrnot + ", nameAddressemployer=" + nameAddressemployer
				+ ", income=" + income + ", assessedToincometax=" + assessedToincometax
				+ ", reimbursementMedicalexpense=" + reimbursementMedicalexpense + ", cashlessTreatment="
				+ cashlessTreatment + ", lossToproperty=" + lossToproperty + ", valueOfloss=" + valueOfloss
				+ ", additionalInfo=" + additionalInfo + ", reliefAmount=" + reliefAmount + ", passengerId="
				+ passengerId + ", victimRemainderdate=" + victimRemainderdate + ", soleEarningmember="
				+ soleEarningmember + ", treatmentDetailsofdeceased=" + treatmentDetailsofdeceased
				+ ", expenseDetailsofdeceased=" + expenseDetailsofdeceased + ", schoolName=" + schoolName
				+ ", permanentDisability=" + permanentDisability + ", permanentDisabilitydetails="
				+ permanentDisabilitydetails + ", estimateExpenditure=" + estimateExpenditure
				+ ", expenditureConveyance=" + expenditureConveyance + ", victimType=" + victimType + ", fatherName="
				+ fatherName + ", dob=" + dob + ", periodHospitlization=" + periodHospitlization + ", treatmentDetails="
				+ treatmentDetails + "]";
	}

	public PassengerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
