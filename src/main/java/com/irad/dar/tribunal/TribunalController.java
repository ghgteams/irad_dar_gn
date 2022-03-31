package com.irad.dar.tribunal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class TribunalController {
	
	@Autowired 
	private ObjectMapper objectMapper;
	@Autowired    
	private Form15Repo repos15;
	@Autowired    
	private Form16Repo repos16;
	
	@PostMapping(value="/form15insert",produces="application/json")
	public Form15Pojo Fifthteen(@RequestBody String body) throws JsonMappingException, JsonProcessingException 
	{		
		Form15Pojo en = objectMapper.readValue(body, Form15Pojo.class);
		Form15Entity form15DB = new Form15Entity();
		Form15Composite compId = new Form15Composite();
		compId.setAccident_id(en.getAccident_id());
		compId.setPerson_type(en.getPerson_type());
		compId.setVehicle_id(en.getVehicle_id());
		compId.setPerson_id(en.getPerson_id());	
		form15DB.setCompId(compId);
		form15DB.setDeath_income(en.getDeath_income());
		form15DB.setDeath_future_prospects(en.getDeath_future_prospects());
		form15DB.setDeath_less_personal_expenses(en.getDeath_less_personal_expenses());
		form15DB.setDeath_monthly_loss_depedency(en.getDeath_monthly_loss_depedency());
		form15DB.setDeath_anual_loss_depedency(en.getDeath_anual_loss_depedency());
		form15DB.setDeath_mulltiplier(en.getDeath_mulltiplier());
		form15DB.setDeath_total_loss_dependency(en.getDeath_total_loss_dependency());
		form15DB.setDeath_medical_expenses(en.getDeath_medical_expenses());
		form15DB.setDeath_loss_consortium(en.getDeath_loss_consortium());
		form15DB.setDeath_loss_for_love_affection(en.getDeath_loss_for_love_affection());
		form15DB.setDeath_loss_estate(en.getDeath_loss_estate());
		form15DB.setDeath_loss_funeral_expenses(en.getDeath_loss_funeral_expenses());
		form15DB.setDeath_total_compensation(en.getDeath_total_compensation());
		form15DB.setDeath_rate_interest(en.getDeath_rate_interest());
		form15DB.setDeath_interest_amount(en.getDeath_interest_amount());
		form15DB.setTotal_amt_with_interest(en.getTotal_amt_with_interest());
		form15DB.setAward_amt_released(en.getAward_amt_released());
		form15DB.setAward_amt_in_fdrs(en.getAward_amt_in_fdrs());
		form15DB.setMode_disbursement(en.getMode_disbursement());
		form15DB.setNest_date_award(en.getNest_date_award());
		form15DB.setInsertedby(en.getInsertedby());
		form15DB.setInsertedon(en.getInsertedon());
		form15DB = repos15.save(form15DB);
		return en;
	}
	
	
	@PostMapping(value="/form16insert",produces="application/json")
	public Form16Pojo Sixtheen(@RequestBody String body) throws JsonMappingException, JsonProcessingException 
	{		
		Form16Pojo en = objectMapper.readValue(body, Form16Pojo.class);
		Form16Entity form16DB = new Form16Entity();
		Foem16Composite compId = new Foem16Composite();
		compId.setAccident_id(en.getAccident_id());
		compId.setPerson_type(en.getPerson_type());
		compId.setVehicle_id(en.getVehicle_id());
		compId.setPerson_id(en.getPerson_id());	
		form16DB.setCompId(compId);
		form16DB.setTreatment(en.getTreatment());
		form16DB.setConvenance(en.getConvenance());
		form16DB.setSpecial_diet(en.getSpecial_diet());
		form16DB.setCost_nursing_attendant(en.getCost_nursing_attendant());
		form16DB.setCost_artificial_limp(en.getCost_artificial_limp());
		form16DB.setLoss_earning_cap(en.getLoss_earning_cap());
		form16DB.setLoss_income(en.getLoss_income());
		form16DB.setAny_other_loss(en.getAny_other_loss());
		form16DB.setCom_mental_phy_shock(en.getCom_mental_phy_shock());
		form16DB.setPain_suffering(en.getPain_suffering());
		form16DB.setLoss_amenities(en.getLoss_amenities());
		form16DB.setDisfiguration(en.getDisfiguration());
		form16DB.setLoss_of_marriage(en.getLoss_of_marriage());
		form16DB.setLoss_ear_inc_har_dis(en.getLoss_ear_inc_har_dis());
		form16DB.setPer_disablity(en.getPer_disablity());
		form16DB.setLoss_ami_life_span(en.getLoss_ami_life_span());
		form16DB.setPer_loss_earning(en.getPer_loss_earning());
		form16DB.setLoss_future_income(en.getLoss_future_income());
		form16DB.setTotal_copensation(en.getTotal_copensation());
		form16DB.setInterest(en.getInterest());
		form16DB.setInterest_amount(en.getInterest_amount());
		form16DB.setTotal_amt_with_interest(en.getTotal_amt_with_interest());
		form16DB.setAward_amt_released(en.getAward_amt_released());
		form16DB.setAward_amt_in_fdrs(en.getAward_amt_in_fdrs());
		form16DB.setMode_disbursement(en.getMode_disbursement());
		form16DB.setNest_date_award(en.getNest_date_award());
		form16DB.setInsertedon(en.getInsertedon());
		form16DB.setInsertedby(en.getInterest());
		form16DB.setInj_income(en.getInj_income());
		form16DB.setMultiplier(en.getMultiplier());


		
		form16DB = repos16.save(form16DB);
		
	
		return en;
		//System.out.println("save value"+form16DB);
		/*
		 * String message; if(form16DB.equals("0") ){ message="Failed";
		 * 
		 * } else { message="Success"; } return message;
		 */
		
	}
}
