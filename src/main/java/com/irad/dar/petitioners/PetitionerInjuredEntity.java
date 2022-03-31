package com.irad.dar.petitioners;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
@Table(name = "dar_petitioners_compensation_injured", schema = "public")
public class PetitionerInjuredEntity {

		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public long id;

		@Column(name = "accident_id")
		private String accidentId;

		@Column(name = "vehicle_id")
		private String vehicleId;

		@Column(name = "person_id")
		private String personId;

		@Column(name = "person_type")
		private String personType;

		@Column(name = "inj_treatment")
		private String injTreatment;

		@Column(name = "inj_convenance")
		private String injConvenance;

		@Column(name = "inj_special_diet")
		private String injSpecialDiet;

		@Column(name = "inj_cost_nursing_attendant")
		private String injCostNursingAttend;

		@Column(name = "inj_loss_income")
		private String injLossIncome;

		@Column(name = "inj_cost_artificial_limp")
		private String injCostArtificialLimp;

		@Column(name = "inj_any_other_loss")
		private String injAnotherLoss;

		@Column(name = "inj_com_mental_phy_shock")
		private String injPhyShock;

		@Column(name = "inj_pain_suffering")
		private String injPainSuffer;

		@Column(name = "inj_loss_amenities")
		private String lossAmenities;

		@Column(name = "inj_disfiguration")
		private String injDisfiguration;

		@Column(name = "inj_loss_of_marriage")
		private String injLossOfMarriage;

		@Column(name = "inj_loss_ear_inc_har_dis")
		private String injLossHarDis;

		@Column(name = "inj_per_disablity")
		private String injDisability;

		@Column(name = "inj_loss_ami_life_span")
		private String injLifeSpan;

		@Column(name = "inj_per_loss_earning")
		private String injLossEarning;

		@Column(name = "in_loss_future_income")
		private String injLossFutureIncome;

		@Column(name = "inj_total_copensation")
		private String injTotalCompensation;

		@Column(name = "inj_interest")
		private String injInterest;

		
		@Column(name = "inj_income")
		private String inj_income;
		
		@Column(name = "multiplier")
		private String multiplier;
		
		@Column(name = "permanent_or_temporary_disablity")
		private String permanentOrTemporaryDisability;

		public long getId() {
			return id;
		}

		public void setId(long id) {
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

		public String getInjTreatment() {
			return injTreatment;
		}

		public void setInjTreatment(String injTreatment) {
			this.injTreatment = injTreatment;
		}

		public String getInjConvenance() {
			return injConvenance;
		}

		public void setInjConvenance(String injConvenance) {
			this.injConvenance = injConvenance;
		}

		public String getInjSpecialDiet() {
			return injSpecialDiet;
		}

		public void setInjSpecialDiet(String injSpecialDiet) {
			this.injSpecialDiet = injSpecialDiet;
		}

		public String getInjCostNursingAttend() {
			return injCostNursingAttend;
		}

		public void setInjCostNursingAttend(String injCostNursingAttend) {
			this.injCostNursingAttend = injCostNursingAttend;
		}

		public String getInjLossIncome() {
			return injLossIncome;
		}

		public void setInjLossIncome(String injLossIncome) {
			this.injLossIncome = injLossIncome;
		}

		public String getInjCostArtificialLimp() {
			return injCostArtificialLimp;
		}

		public void setInjCostArtificialLimp(String injCostArtificialLimp) {
			this.injCostArtificialLimp = injCostArtificialLimp;
		}

		public String getInjAnotherLoss() {
			return injAnotherLoss;
		}

		public void setInjAnotherLoss(String injAnotherLoss) {
			this.injAnotherLoss = injAnotherLoss;
		}

		public String getInjPhyShock() {
			return injPhyShock;
		}

		public void setInjPhyShock(String injPhyShock) {
			this.injPhyShock = injPhyShock;
		}

		public String getInjPainSuffer() {
			return injPainSuffer;
		}

		public void setInjPainSuffer(String injPainSuffer) {
			this.injPainSuffer = injPainSuffer;
		}

		public String getLossAmenities() {
			return lossAmenities;
		}

		public void setLossAmenities(String lossAmenities) {
			this.lossAmenities = lossAmenities;
		}

		public String getInjDisfiguration() {
			return injDisfiguration;
		}

		public void setInjDisfiguration(String injDisfiguration) {
			this.injDisfiguration = injDisfiguration;
		}

		public String getInjLossOfMarriage() {
			return injLossOfMarriage;
		}

		public void setInjLossOfMarriage(String injLossOfMarriage) {
			this.injLossOfMarriage = injLossOfMarriage;
		}

		public String getInjLossHarDis() {
			return injLossHarDis;
		}

		public void setInjLossHarDis(String injLossHarDis) {
			this.injLossHarDis = injLossHarDis;
		}

		public String getInjDisability() {
			return injDisability;
		}

		public void setInjDisability(String injDisability) {
			this.injDisability = injDisability;
		}

		public String getInjLifeSpan() {
			return injLifeSpan;
		}

		public void setInjLifeSpan(String injLifeSpan) {
			this.injLifeSpan = injLifeSpan;
		}

		public String getInjLossEarning() {
			return injLossEarning;
		}

		public void setInjLossEarning(String injLossEarning) {
			this.injLossEarning = injLossEarning;
		}

		public String getInjLossFutureIncome() {
			return injLossFutureIncome;
		}

		public void setInjLossFutureIncome(String injLossFutureIncome) {
			this.injLossFutureIncome = injLossFutureIncome;
		}

		public String getInjTotalCompensation() {
			return injTotalCompensation;
		}

		public void setInjTotalCompensation(String injTotalCompensation) {
			this.injTotalCompensation = injTotalCompensation;
		}

		public String getInjInterest() {
			return injInterest;
		}

		public void setInjInterest(String injInterest) {
			this.injInterest = injInterest;
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

		public String getPermanentOrTemporaryDisability() {
			return permanentOrTemporaryDisability;
		}

		public void setPermanentOrTemporaryDisability(String permanentOrTemporaryDisability) {
			this.permanentOrTemporaryDisability = permanentOrTemporaryDisability;
		}

		public PetitionerInjuredEntity(long id, String accidentId, String vehicleId, String personId, String personType,
				String injTreatment, String injConvenance, String injSpecialDiet, String injCostNursingAttend,
				String injLossIncome, String injCostArtificialLimp, String injAnotherLoss, String injPhyShock,
				String injPainSuffer, String lossAmenities, String injDisfiguration, String injLossOfMarriage,
				String injLossHarDis, String injDisability, String injLifeSpan, String injLossEarning,
				String injLossFutureIncome, String injTotalCompensation, String injInterest, String inj_income,
				String multiplier, String permanentOrTemporaryDisability) {
			super();
			this.id = id;
			this.accidentId = accidentId;
			this.vehicleId = vehicleId;
			this.personId = personId;
			this.personType = personType;
			this.injTreatment = injTreatment;
			this.injConvenance = injConvenance;
			this.injSpecialDiet = injSpecialDiet;
			this.injCostNursingAttend = injCostNursingAttend;
			this.injLossIncome = injLossIncome;
			this.injCostArtificialLimp = injCostArtificialLimp;
			this.injAnotherLoss = injAnotherLoss;
			this.injPhyShock = injPhyShock;
			this.injPainSuffer = injPainSuffer;
			this.lossAmenities = lossAmenities;
			this.injDisfiguration = injDisfiguration;
			this.injLossOfMarriage = injLossOfMarriage;
			this.injLossHarDis = injLossHarDis;
			this.injDisability = injDisability;
			this.injLifeSpan = injLifeSpan;
			this.injLossEarning = injLossEarning;
			this.injLossFutureIncome = injLossFutureIncome;
			this.injTotalCompensation = injTotalCompensation;
			this.injInterest = injInterest;
			this.inj_income = inj_income;
			this.multiplier = multiplier;
			this.permanentOrTemporaryDisability = permanentOrTemporaryDisability;
		}

		@Override
		public String toString() {
			return "PetitionerInjuredEntity [id=" + id + ", accidentId=" + accidentId + ", vehicleId=" + vehicleId
					+ ", personId=" + personId + ", personType=" + personType + ", injTreatment=" + injTreatment
					+ ", injConvenance=" + injConvenance + ", injSpecialDiet=" + injSpecialDiet
					+ ", injCostNursingAttend=" + injCostNursingAttend + ", injLossIncome=" + injLossIncome
					+ ", injCostArtificialLimp=" + injCostArtificialLimp + ", injAnotherLoss=" + injAnotherLoss
					+ ", injPhyShock=" + injPhyShock + ", injPainSuffer=" + injPainSuffer + ", lossAmenities="
					+ lossAmenities + ", injDisfiguration=" + injDisfiguration + ", injLossOfMarriage="
					+ injLossOfMarriage + ", injLossHarDis=" + injLossHarDis + ", injDisability=" + injDisability
					+ ", injLifeSpan=" + injLifeSpan + ", injLossEarning=" + injLossEarning + ", injLossFutureIncome="
					+ injLossFutureIncome + ", injTotalCompensation=" + injTotalCompensation + ", injInterest="
					+ injInterest + ", inj_income=" + inj_income + ", multiplier=" + multiplier
					+ ", permanentOrTemporaryDisability=" + permanentOrTemporaryDisability + "]";
		}

		public PetitionerInjuredEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		
		
		
		
}


