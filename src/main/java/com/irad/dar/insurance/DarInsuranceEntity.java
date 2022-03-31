package com.irad.dar.insurance;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dar_insurance", schema = "public")
public class DarInsuranceEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="accident_id")
	private String accidentId;
	
	@Column(name="vehicle_id")
	private String vehicleId;
	
	@Column(name="vehicle_make")
	private String vehicleMake;
	
	@Column(name="vehicle_model")
	private String vehicleModel;
	
	@Column(name="name")
	private String name;
	
	@Column(name="residence")
	private String residence;
	
	@Column(name="insurance_details")
	private String insuranceDetails;

	@Column(name="insurance_policyno")
	private String insPolicyNo;
	
	@Column(name="insurance_validity")
	private String insValidity;
	
	@Column(name="nature_of_policy")
	private String natureOfPolicy;
	
	@Column(name="intimation_received_date_time_insured")
	private Date intimationReceivedDateTimeInsured;
	
	@Column(name="date_of_receipt_far")
	private Date receiptFarDate;
	
	@Column(name="date_of_receipt_iar")
	private Date receiptIarDate;
	
	@Column(name="date_of_receipt_dar")
	private Date receiptDarDate;
	
	@Column(name="dateof_appt_designated_officer_by_ins")
	private Date desigOfficerByInsApptDate;
	
	@Column(name="designated_officer_name")
	private String officerName;
	

	@Column(name="designated_officer_residence")
	private String officerResidence;
	
	@Column(name="surveyor_investigator_name")
	private String investigatorName;
	
	@Column(name="surveyor_investigator_residence")
	private String investigatorResidence;
	

	@Column(name="dateof_surveyor_investigator_report")
	private Date surveyorReportDate;
	
	@Column(name="dateof_designated_officer_report")
	private Date desigOfficerReportDate;
	
	@Column(name="form_filled_within_30")
	private String filledWithin30;
	
	@Column(name="if_ins_company_not_liability")
	private String compNotLiability;
	
	@Column(name="surveyor_appointment_date")
	private Date surveyorAppointmntDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccidentId() {
		return accidentId;
	}

	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getInsuranceDetails() {
		return insuranceDetails;
	}

	public void setInsuranceDetails(String insuranceDetails) {
		this.insuranceDetails = insuranceDetails;
	}

	public String getInsPolicyNo() {
		return insPolicyNo;
	}

	public void setInsPolicyNo(String insPolicyNo) {
		this.insPolicyNo = insPolicyNo;
	}

	public String getInsValidity() {
		return insValidity;
	}

	public void setInsValidity(String insValidity) {
		this.insValidity = insValidity;
	}

	public String getNatureOfPolicy() {
		return natureOfPolicy;
	}

	public void setNatureOfPolicy(String natureOfPolicy) {
		this.natureOfPolicy = natureOfPolicy;
	}

	public Date getIntimationReceivedDateTimeInsured() {
		return intimationReceivedDateTimeInsured;
	}

	public void setIntimationReceivedDateTimeInsured(Date intimationReceivedDateTimeInsured) {
		this.intimationReceivedDateTimeInsured = intimationReceivedDateTimeInsured;
	}

	public Date getReceiptFarDate() {
		return receiptFarDate;
	}

	public void setReceiptFarDate(Date receiptFarDate) {
		this.receiptFarDate = receiptFarDate;
	}

	public Date getReceiptIarDate() {
		return receiptIarDate;
	}

	public void setReceiptIarDate(Date receiptIarDate) {
		this.receiptIarDate = receiptIarDate;
	}

	public Date getReceiptDarDate() {
		return receiptDarDate;
	}

	public void setReceiptDarDate(Date receiptDarDate) {
		this.receiptDarDate = receiptDarDate;
	}

	public Date getDesigOfficerByInsApptDate() {
		return desigOfficerByInsApptDate;
	}

	public void setDesigOfficerByInsApptDate(Date desigOfficerByInsApptDate) {
		this.desigOfficerByInsApptDate = desigOfficerByInsApptDate;
	}

	public String getOfficerName() {
		return officerName;
	}

	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}

	public String getOfficerResidence() {
		return officerResidence;
	}

	public void setOfficerResidence(String officerResidence) {
		this.officerResidence = officerResidence;
	}

	public String getInvestigatorName() {
		return investigatorName;
	}

	public void setInvestigatorName(String investigatorName) {
		this.investigatorName = investigatorName;
	}

	public String getInvestigatorResidence() {
		return investigatorResidence;
	}

	public void setInvestigatorResidence(String investigatorResidence) {
		this.investigatorResidence = investigatorResidence;
	}

	public Date getSurveyorReportDate() {
		return surveyorReportDate;
	}

	public void setSurveyorReportDate(Date surveyorReportDate) {
		this.surveyorReportDate = surveyorReportDate;
	}

	public Date getDesigOfficerReportDate() {
		return desigOfficerReportDate;
	}

	public void setDesigOfficerReportDate(Date desigOfficerReportDate) {
		this.desigOfficerReportDate = desigOfficerReportDate;
	}

	public String getFilledWithin30() {
		return filledWithin30;
	}

	public void setFilledWithin30(String filledWithin30) {
		this.filledWithin30 = filledWithin30;
	}

	public String getCompNotLiability() {
		return compNotLiability;
	}

	public void setCompNotLiability(String compNotLiability) {
		this.compNotLiability = compNotLiability;
	}

	public Date getSurveyorAppointmntDate() {
		return surveyorAppointmntDate;
	}

	public void setSurveyorAppointmntDate(Date surveyorAppointmntDate) {
		this.surveyorAppointmntDate = surveyorAppointmntDate;
	}

	public DarInsuranceEntity(int id, String accidentId, String vehicleId, String vehicleMake, String vehicleModel,
			String name, String residence, String insuranceDetails, String insPolicyNo, String insValidity,
			String natureOfPolicy, Date intimationReceivedDateTimeInsured, Date receiptFarDate, Date receiptIarDate,
			Date receiptDarDate, Date desigOfficerByInsApptDate, String officerName, String officerResidence,
			String investigatorName, String investigatorResidence, Date surveyorReportDate, Date desigOfficerReportDate,
			String filledWithin30, String compNotLiability, Date surveyorAppointmntDate) {
		super();
		this.id = id;
		this.accidentId = accidentId;
		this.vehicleId = vehicleId;
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
		this.name = name;
		this.residence = residence;
		this.insuranceDetails = insuranceDetails;
		this.insPolicyNo = insPolicyNo;
		this.insValidity = insValidity;
		this.natureOfPolicy = natureOfPolicy;
		this.intimationReceivedDateTimeInsured = intimationReceivedDateTimeInsured;
		this.receiptFarDate = receiptFarDate;
		this.receiptIarDate = receiptIarDate;
		this.receiptDarDate = receiptDarDate;
		this.desigOfficerByInsApptDate = desigOfficerByInsApptDate;
		this.officerName = officerName;
		this.officerResidence = officerResidence;
		this.investigatorName = investigatorName;
		this.investigatorResidence = investigatorResidence;
		this.surveyorReportDate = surveyorReportDate;
		this.desigOfficerReportDate = desigOfficerReportDate;
		this.filledWithin30 = filledWithin30;
		this.compNotLiability = compNotLiability;
		this.surveyorAppointmntDate = surveyorAppointmntDate;
	}

	@Override
	public String toString() {
		return "DarInsuranceEntity [id=" + id + ", accidentId=" + accidentId + ", vehicleId=" + vehicleId
				+ ", vehicleMake=" + vehicleMake + ", vehicleModel=" + vehicleModel + ", name=" + name + ", residence="
				+ residence + ", insuranceDetails=" + insuranceDetails + ", insPolicyNo=" + insPolicyNo
				+ ", insValidity=" + insValidity + ", natureOfPolicy=" + natureOfPolicy
				+ ", intimationReceivedDateTimeInsured=" + intimationReceivedDateTimeInsured + ", receiptFarDate="
				+ receiptFarDate + ", receiptIarDate=" + receiptIarDate + ", receiptDarDate=" + receiptDarDate
				+ ", desigOfficerByInsApptDate=" + desigOfficerByInsApptDate + ", officerName=" + officerName
				+ ", officerResidence=" + officerResidence + ", investigatorName=" + investigatorName
				+ ", investigatorResidence=" + investigatorResidence + ", surveyorReportDate=" + surveyorReportDate
				+ ", desigOfficerReportDate=" + desigOfficerReportDate + ", filledWithin30=" + filledWithin30
				+ ", compNotLiability=" + compNotLiability + ", surveyorAppointmntDate=" + surveyorAppointmntDate + "]";
	}

	public DarInsuranceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
