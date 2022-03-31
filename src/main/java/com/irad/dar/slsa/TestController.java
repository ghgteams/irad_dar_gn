package com.irad.dar.slsa;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class TestController {
	
	//@Autowired is used to create objects for Classes
	@Autowired 
	private ObjectMapper objectMapper;
	
	@Autowired    
	private SlsaGenralRepo slsarepo;
	@Autowired    
	private SlsaDeathRepo slsadeathrepo;
	
	@Autowired    
	private SlsaInjuredRepo slsainjuredrepo;
	
	/*  DIRECTLY CALLING SERVICE IMPLEMENTATION
	 * @Autowired private SlsaAccusedService slsaAccusedService;
	 */
	 @Autowired private SlsaServiceInterface slsaAccusedService;
	
	
	//#####################SAVE USING COMPOSITE ENTITY 
	
		@PostMapping(value="/slsagenral",produces="application/json")
		public Slsa genralLegalService (@RequestBody String body) throws JsonMappingException, JsonProcessingException //Employee is Return type and post is Method NAME
		{
			
			Slsa e = objectMapper.readValue(body, Slsa.class);
			SlsaGenral slsadb = new SlsaGenral();
			SlsaGenralComposite compId = new SlsaGenralComposite();
			compId.setAccident_id(e.getAccident_id());
			compId.setPerson_id(e.getPerson_id());
			compId.setPerson_type(e.getPerson_type());
			compId.setVehicle_id(e.getVehicle_id());
			slsadb.setCompId(compId);
			//slsadb.setId(e.getId());
			slsadb.setNature_of_injuries(e.getNature_of_injuries());
			slsadb.setEmotional_harm(e.getEmotional_harm());
			slsadb.setDamage_lose(e.getDamage_lose());
			slsadb.setAny_damage_lose(e.getAny_damage_lose());
			slsadb.setBrief_description_of_offense(e.getBrief_description_of_offense());
			slsadb.setName(e.getName());
			slsadb.setFather_spouse_name(e.getFather_spouse_name());
			slsadb.setAge(e.getAge());
			slsadb.setGender(e.getGender());
			slsadb.setMarital_status(e.getMarital_status());
			slsadb.setPresent_address(e.getPresent_address());
			slsadb.setConatc_emailid(e.getConatc_emailid());
			slsadb.setConatc_mobileno(e.getConatc_mobileno());
		    slsadb.setPhysicalHarm(e.getPhysical_harm());
		    System.out.println("losss"+e.getProperty_loss_damage());
		    slsadb.setProperty_loss_damage(e.getProperty_loss_damage());
		    slsadb.setLoss_suffered(e.getLoss_suffered());
		    
		    System.out.println("losss"+e.getLoss_suffered());

			
			/*
			 * slsadb.setDescription_of_property_damage(e.getDescription_of_property_damage(
			 * )); slsadb.setValue_of_loss_suffered(e.getValue_of_loss_suffered());
			 */
			
			slsadb = slsarepo.save(slsadb);
			
			return e;

		}
	
	//SAVE  USING COPY PROPERTIES NOT USED SERVICEIMP
	@PostMapping(value="/slsadeath",produces="application/json")
	public SlsaDeathPojo deathSlsa (@RequestBody String body) throws JsonMappingException, JsonProcessingException //Employee is Return type and postEmployee is Method NAME
	{
		
		SlsaDeathPojo pojo = objectMapper.readValue(body, SlsaDeathPojo.class);
		SlsaDeathEntity db_e = new SlsaDeathEntity();
		BeanUtils.copyProperties(pojo, db_e);//copyProperties paste only value  the entity not composite finsideor that ypu should use getter setter
		db_e = slsadeathrepo.save(db_e);
		
		return pojo;
		

	}
	//
	@PostMapping(value="/slsainjured",produces="application/json")
	public SlsaInjuredPojo injuredSlsa (@RequestBody String body) throws JsonMappingException, JsonProcessingException //Employee is Return type and postEmployee is Method NAME
	{
		
		SlsaInjuredPojo pojo = objectMapper.readValue(body, SlsaInjuredPojo.class);
		SlsaInjuredEntity db_e = new SlsaInjuredEntity();
		BeanUtils.copyProperties(pojo, db_e);//copyProperties paste only value  the entity not composite finsideor that ypu should use getter setter
		db_e = slsainjuredrepo.save(db_e);
		
		return pojo;
		

	}
	
	// SAVE USING SERVICE IMPLEMENTATION AND MAPPING
	@PostMapping(value="/slsaaccused",produces="application/json")
	public SlsaAccusedVO createSlsaAccused (@RequestBody String body) throws JsonMappingException, JsonProcessingException
	{
		SlsaAccusedPOJO pojo = objectMapper.readValue(body, SlsaAccusedPOJO.class);
		
		SlsaAccusedVO responseVO = slsaAccusedService.createSlsaAccused(pojo); //call service method HERE createSlsaAccused is method name present in service

		return responseVO;
	}
	

	// SAVE USING SERVICE IMPLEMENTATION AND MAPPING
	@PostMapping(value="/slsagen",produces="application/json")
	public Slsa createSlsagenral (@RequestBody String body) throws JsonMappingException, JsonProcessingException
	{
		Slsa genpojo = objectMapper.readValue(body, Slsa.class);
		
		Slsa responseVO = slsaAccusedService.createSlsaGenral(genpojo); //call service method HERE createSlsaAccused is method name present in service
		return responseVO;
	}
	
	
	
	

	
}
