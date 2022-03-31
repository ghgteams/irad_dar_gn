package com.irad.dar.slsa;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
@Component
public class SlsaAccusedMapper {
	
//----------------------------Accused------------------------------------//
	public SlsaAccusedEntity mapSlsaAccusedPOJOtoEntity(SlsaAccusedPOJO pojo) {
		SlsaAccusedEntity entity = new SlsaAccusedEntity();
		BeanUtils.copyProperties(pojo,entity); // (source,destination)
		return entity;
	}
	
	public SlsaAccusedVO mapSlsaAccusedEntityToVO(SlsaAccusedEntity entity) {
		SlsaAccusedVO vo = new SlsaAccusedVO();
		BeanUtils.copyProperties(entity,vo); // (source,destination)
		return vo;
	}
	
//----------------------------------------------------------------------------//
	
//-----------------------------General-----------------------------------//
	
	public SlsaGenral mapSlsaPOJOtoEntity(Slsa pojo) {
		SlsaGenral slsadb = new SlsaGenral();
		//Create object and set values for Composite key Class
		SlsaGenralComposite compId = new SlsaGenralComposite();
		compId.setAccident_id(pojo.getAccident_id());
		compId.setPerson_id(pojo.getPerson_id());
		compId.setPerson_type(pojo.getPerson_type());
		compId.setVehicle_id(pojo.getVehicle_id());
		//Set Values in SlsaGenral
		slsadb.setCompId(compId);
		//slsadb.setId(pojo.getId());
		slsadb.setNature_of_injuries(pojo.getNature_of_injuries());
		slsadb.setBrief_description_of_offense(pojo.getBrief_description_of_offense());
		/*
		 * slsadb.setDescription_of_property_damage(pojo.
		 * getDescription_of_property_damage());
		 * slsadb.setValue_of_loss_suffered(pojo.getValue_of_loss_suffered());
		 */
		return slsadb;
	}
	
	public Slsa mapSlsaGenralEntityToSlsaPOJO(SlsaGenral entity) {
		Slsa genvo = new Slsa();
		BeanUtils.copyProperties(entity,genvo); // (source,destination)
		return genvo;
	}
	
	
//------------------------------------------------------------------------//	
	
}
