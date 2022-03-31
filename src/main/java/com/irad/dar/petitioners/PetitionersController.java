package com.irad.dar.petitioners;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetitionersController {
	@Autowired
	PetitionerService petitionerService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/savePetitionerDeceased", method = RequestMethod.POST)
	public JSONObject saveInsuranceInjured(@RequestBody PetitionerDeceasedPojo petitionerDeceasedPojo)throws Exception {
		String result;
		JSONObject response = new JSONObject();
		PetitionerDeceasedEntity petitionerDeceasedEntity = new PetitionerDeceasedEntity();
//		petitionerDeceasedEntity.setInsuranceId(Integer.parseInt(insuranceDeceasedPojo.getId_insurance()));
		petitionerDeceasedEntity.setVehicleId(petitionerDeceasedPojo.getVehicle_id());
		petitionerDeceasedEntity.setAccidentId(petitionerDeceasedPojo.getAccident_id());
		petitionerDeceasedEntity.setPersonId(petitionerDeceasedPojo.getPerson_id());
		petitionerDeceasedEntity.setPersonType(petitionerDeceasedPojo.getPerson_type());
		petitionerDeceasedEntity.setDeathIncome(petitionerDeceasedPojo.getDeath_income());
		petitionerDeceasedEntity.setDeathFutureProspects(petitionerDeceasedPojo.getDeath_future_prospects());
		petitionerDeceasedEntity.setDeathLessPersonalExpenses(petitionerDeceasedPojo.getDeath_less_personal_expenses());
		petitionerDeceasedEntity.setDeathMonthlyLoss(petitionerDeceasedPojo.getDeath_monthly_loss_depedency());
		petitionerDeceasedEntity.setDeathAnnualLoss(petitionerDeceasedPojo.getDeath_anual_loss_depedency());
		petitionerDeceasedEntity.setDeathMultiplier(petitionerDeceasedPojo.getDeath_mulltiplier());
		petitionerDeceasedEntity.setDeathTotalLoss(petitionerDeceasedPojo.getDeath_total_loss_dependency());
		petitionerDeceasedEntity.setDeathMedicalExpenses(petitionerDeceasedPojo.getDeath_medical_expenses());
		petitionerDeceasedEntity.setDeathLossConsortium(petitionerDeceasedPojo.getDeath_loss_consortium());
		petitionerDeceasedEntity.setDeathLossForLove(petitionerDeceasedPojo.getDeath_loss_for_love_affection());
		petitionerDeceasedEntity.setDeathLossEstate(petitionerDeceasedPojo.getDeath_loss_estate());
		petitionerDeceasedEntity.setDeathLossFuneralExpenses(petitionerDeceasedPojo.getDeath_loss_funeral_expenses());
		petitionerDeceasedEntity.setDeathTotalCompensation(petitionerDeceasedPojo.getDeath_total_compensation());
		petitionerDeceasedEntity.setDeathInterest(petitionerDeceasedPojo.getDeath_interest());
		result = petitionerService.saveInsuranceDeceased(petitionerDeceasedEntity);
		if(result.equals("0")&& !result.isEmpty()) {
			response.put("ErrorCode", result);
			response.put("Message", "Not Inserted");
		}else if(result.equals("1")&&!result.isEmpty()) {
			response.put("ErrorCode", result);
			response.put("Message", "Inserted Successfully");
		}
		return response;
	}
	@RequestMapping(value = "/savePetitionerInjured", method = RequestMethod.POST)
	public JSONObject petitionSubmitionData(@RequestBody PetitionerInjuredPojo petitionerInjuredPojo) throws Exception {
		String result;
		System.out.println("accidentId" + petitionerInjuredPojo.getAccidentId());
		System.out.println("formNo" + petitionerInjuredPojo.getVehicleId());
		JSONObject response = new JSONObject();
		
		PetitionerInjuredEntity petitionerInjuredEntity = new PetitionerInjuredEntity();
		
		petitionerInjuredEntity.setAccidentId(petitionerInjuredPojo.getAccidentId());
		petitionerInjuredEntity.setVehicleId(petitionerInjuredPojo.getVehicleId());
		petitionerInjuredEntity.setPersonId(petitionerInjuredPojo.getPersonId());
		petitionerInjuredEntity.setPersonType(petitionerInjuredPojo.getPersonType());
		
		petitionerInjuredEntity.setInjTreatment(petitionerInjuredPojo.getInjTreatment());
		petitionerInjuredEntity.setInjConvenance(petitionerInjuredPojo.getInjConvenance());
		petitionerInjuredEntity.setInjSpecialDiet(petitionerInjuredPojo.getInjSpecialDiet());
		petitionerInjuredEntity.setInjCostNursingAttend(petitionerInjuredPojo.getInjCostNursingAttend());
		petitionerInjuredEntity.setInjLossIncome(petitionerInjuredPojo.getInjLossIncome());
		petitionerInjuredEntity.setInjCostArtificialLimp(petitionerInjuredPojo.getInjCostArtificialLimp());
		petitionerInjuredEntity.setInjAnotherLoss(petitionerInjuredPojo.getInjAnotherLoss());
		petitionerInjuredEntity.setInjPhyShock(petitionerInjuredPojo.getInjPhyShock());
		
		petitionerInjuredEntity.setInjPainSuffer(petitionerInjuredPojo.getInjPainSuffer());
		petitionerInjuredEntity.setLossAmenities(petitionerInjuredPojo.getLossAmenities());
		petitionerInjuredEntity.setInjDisfiguration(petitionerInjuredPojo.getInjDisfiguration());
		petitionerInjuredEntity.setInjLossOfMarriage(petitionerInjuredPojo.getInjLossOfMarriage());
		petitionerInjuredEntity.setInjLossHarDis(petitionerInjuredPojo.getInjLossHarDis());
		
		petitionerInjuredEntity.setInjDisability(petitionerInjuredPojo.getInjDisability());
		petitionerInjuredEntity.setInjLifeSpan(petitionerInjuredPojo.getInjLifeSpan());
		petitionerInjuredEntity.setInjLossEarning(petitionerInjuredPojo.getInjLossEarning());
		petitionerInjuredEntity.setInjLossFutureIncome(petitionerInjuredPojo.getInjLossFutureIncome());
		petitionerInjuredEntity.setInjTotalCompensation(petitionerInjuredPojo.getInjTotalCompensation());
		petitionerInjuredEntity.setInjInterest(petitionerInjuredPojo.getInjInterest());

		petitionerInjuredEntity.setInj_income(petitionerInjuredPojo.getInj_income());
		petitionerInjuredEntity.setMultiplier(petitionerInjuredPojo.getMultiplier());
		petitionerInjuredEntity.setPermanentOrTemporaryDisability(petitionerInjuredPojo.getPermanent_or_temporary_disability());
		
		result = petitionerService.savePetitionerInjured(petitionerInjuredEntity);

		if(result.equals("0")&& !result.isEmpty()) {
			response.put("ErrorCode", result);
			response.put("Message", "Not Inserted");
		}else if(result.equals("1")&&!result.isEmpty()) {
			response.put("ErrorCode", result);
			response.put("Message", "Inserted Successfully");
		}
		return response;
}
}
