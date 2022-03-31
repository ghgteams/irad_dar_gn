package com.irad.dar.slsa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlsaAccusedService implements SlsaServiceInterface {
	
	@Autowired
	private SlsaAccusedMapper mapper;
	
	@Autowired SlsaAccusedRepo repo;
	
	@Autowired SlsaGenralRepo genrepo;

	
	
	public SlsaAccusedVO createSlsaAccused(SlsaAccusedPOJO pojo) {
		// TODO Auto-generated method stub
		SlsaAccusedEntity entity = mapper.mapSlsaAccusedPOJOtoEntity(pojo);
		entity = repo.save(entity);
		SlsaAccusedVO vo=mapper.mapSlsaAccusedEntityToVO(entity);
		return vo;

	}
	public Slsa createSlsaGenral(Slsa genpojo) {
		// TODO Auto-generated method stub
		SlsaGenral entity = mapper.mapSlsaPOJOtoEntity(genpojo);
		entity = genrepo.save(entity);
		Slsa vo=mapper.mapSlsaGenralEntityToSlsaPOJO(entity);
		return vo;

	}

}
