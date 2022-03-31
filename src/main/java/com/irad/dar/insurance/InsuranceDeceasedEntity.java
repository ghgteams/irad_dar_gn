package com.irad.dar.insurance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.locationtech.jts.geom.Geometry;

@Entity
@Table(name = "dar_insurance_death", schema = "public")
public class InsuranceDeceasedEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="id_insurance")
	private int insuranceId;

	@Column(name="vehicle_id")
	private String vehicleId;

	@Column(name="accident_id")
	private String accidentId;

	@Column(name="person_id")
	private String personId;

	@Column(name="person_type")
	private String personType;

	@Column(name="death_income")
	private String deathIncome;

	@Column(name="death_future_prospects")
	private String deathFutureProspects;

	@Column(name="death_less_personal_expenses")
	private String deathLessPersonalExpenses;

	@Column(name="death_monthly_loss_depedency")
	private String deathMonthlyLoss;

	@Column(name="death_anual_loss_depedency")
	private String deathAnnualLoss;

	@Column(name="death_mulltiplier")
	private String deathMultiplier;
	
	@Column(name="death_total_loss_dependency")
	private String deathTotalLoss;

	@Column(name="death_medical_expenses")
	private String deathMedicalExpenses;
	
	@Column(name="death_loss_consortium")
	private String deathLossConsortium;

	@Column(name="death_loss_for_love_affection")
	private String deathLossForLove;
	
	@Column(name="death_loss_estate")
	private String deathLossEstate;
	
	@Column(name="death_loss_funeral_expenses")
	private String deathLossFuneralExpenses;

	@Column(name="death_total_compensation")
	private String deathTotalCompensation;
	
	@Column(name="death_interest")
	private String deathInterest;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getAccidentId() {
		return accidentId;
	}

	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public String getDeathIncome() {
		return deathIncome;
	}

	public void setDeathIncome(String deathIncome) {
		this.deathIncome = deathIncome;
	}

	public String getDeathFutureProspects() {
		return deathFutureProspects;
	}

	public void setDeathFutureProspects(String deathFutureProspects) {
		this.deathFutureProspects = deathFutureProspects;
	}

	public String getDeathLessPersonalExpenses() {
		return deathLessPersonalExpenses;
	}

	public void setDeathLessPersonalExpenses(String deathLessPersonalExpenses) {
		this.deathLessPersonalExpenses = deathLessPersonalExpenses;
	}

	public String getDeathMonthlyLoss() {
		return deathMonthlyLoss;
	}

	public void setDeathMonthlyLoss(String deathMonthlyLoss) {
		this.deathMonthlyLoss = deathMonthlyLoss;
	}

	public String getDeathAnnualLoss() {
		return deathAnnualLoss;
	}

	public void setDeathAnnualLoss(String deathAnnualLoss) {
		this.deathAnnualLoss = deathAnnualLoss;
	}

	public String getDeathMultiplier() {
		return deathMultiplier;
	}

	public void setDeathMultiplier(String deathMultiplier) {
		this.deathMultiplier = deathMultiplier;
	}

	public String getDeathTotalLoss() {
		return deathTotalLoss;
	}

	public void setDeathTotalLoss(String deathTotalLoss) {
		this.deathTotalLoss = deathTotalLoss;
	}

	public String getDeathMedicalExpenses() {
		return deathMedicalExpenses;
	}

	public void setDeathMedicalExpenses(String deathMedicalExpenses) {
		this.deathMedicalExpenses = deathMedicalExpenses;
	}

	public String getDeathLossConsortium() {
		return deathLossConsortium;
	}

	public void setDeathLossConsortium(String deathLossConsortium) {
		this.deathLossConsortium = deathLossConsortium;
	}

	public String getDeathLossForLove() {
		return deathLossForLove;
	}

	public void setDeathLossForLove(String deathLossForLove) {
		this.deathLossForLove = deathLossForLove;
	}

	public String getDeathLossEstate() {
		return deathLossEstate;
	}

	public void setDeathLossEstate(String deathLossEstate) {
		this.deathLossEstate = deathLossEstate;
	}

	public String getDeathLossFuneralExpenses() {
		return deathLossFuneralExpenses;
	}

	public void setDeathLossFuneralExpenses(String deathLossFuneralExpenses) {
		this.deathLossFuneralExpenses = deathLossFuneralExpenses;
	}

	public String getDeathTotalCompensation() {
		return deathTotalCompensation;
	}

	public void setDeathTotalCompensation(String deathTotalCompensation) {
		this.deathTotalCompensation = deathTotalCompensation;
	}

	public String getDeathInterest() {
		return deathInterest;
	}

	public void setDeathInterest(String deathInterest) {
		this.deathInterest = deathInterest;
	}

	public InsuranceDeceasedEntity(int id, int insuranceId, String vehicleId, String accidentId, String personId,
			String personType, String deathIncome, String deathFutureProspects, String deathLessPersonalExpenses,
			String deathMonthlyLoss, String deathAnnualLoss, String deathMultiplier, String deathTotalLoss,
			String deathMedicalExpenses, String deathLossConsortium, String deathLossForLove, String deathLossEstate,
			String deathLossFuneralExpenses, String deathTotalCompensation, String deathInterest) {
		super();
		this.id = id;
		this.insuranceId = insuranceId;
		this.vehicleId = vehicleId;
		this.accidentId = accidentId;
		this.personId = personId;
		this.personType = personType;
		this.deathIncome = deathIncome;
		this.deathFutureProspects = deathFutureProspects;
		this.deathLessPersonalExpenses = deathLessPersonalExpenses;
		this.deathMonthlyLoss = deathMonthlyLoss;
		this.deathAnnualLoss = deathAnnualLoss;
		this.deathMultiplier = deathMultiplier;
		this.deathTotalLoss = deathTotalLoss;
		this.deathMedicalExpenses = deathMedicalExpenses;
		this.deathLossConsortium = deathLossConsortium;
		this.deathLossForLove = deathLossForLove;
		this.deathLossEstate = deathLossEstate;
		this.deathLossFuneralExpenses = deathLossFuneralExpenses;
		this.deathTotalCompensation = deathTotalCompensation;
		this.deathInterest = deathInterest;
	}

	@Override
	public String toString() {
		return "InsuranceDeceasedEntity [id=" + id + ", insuranceId=" + insuranceId + ", vehicleId=" + vehicleId
				+ ", accidentId=" + accidentId + ", personId=" + personId + ", personType=" + personType
				+ ", deathIncome=" + deathIncome + ", deathFutureProspects=" + deathFutureProspects
				+ ", deathLessPersonalExpenses=" + deathLessPersonalExpenses + ", deathMonthlyLoss=" + deathMonthlyLoss
				+ ", deathAnnualLoss=" + deathAnnualLoss + ", deathMultiplier=" + deathMultiplier + ", deathTotalLoss="
				+ deathTotalLoss + ", deathMedicalExpenses=" + deathMedicalExpenses + ", deathLossConsortium="
				+ deathLossConsortium + ", deathLossForLove=" + deathLossForLove + ", deathLossEstate="
				+ deathLossEstate + ", deathLossFuneralExpenses=" + deathLossFuneralExpenses
				+ ", deathTotalCompensation=" + deathTotalCompensation + ", deathInterest=" + deathInterest + "]";
	}

	public InsuranceDeceasedEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
