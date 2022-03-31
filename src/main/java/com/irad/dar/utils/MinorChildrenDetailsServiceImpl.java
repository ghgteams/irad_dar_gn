package com.irad.dar.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class MinorChildrenDetailsServiceImpl implements MinorChildrenDetailsService{
	

	@Autowired
	MinorChildrenDetailsRepo minorRepo;
	
	@Override
	public List<MinorChildrenDetailsEntity> getMinorChildrendata(String victimid) {
		List<MinorChildrenDetailsEntity> minorChildrenDetailsEntity=new ArrayList<MinorChildrenDetailsEntity>();
		if(victimid!="") {
			minorChildrenDetailsEntity=(List<MinorChildrenDetailsEntity>) minorRepo.findByVictimId(victimid);
			return minorChildrenDetailsEntity;
		}
		return minorChildrenDetailsEntity;
	}

	@Override
	public String saveMinorchilddata(MinorChildrenDetailsEntity minorChildrenDetailsEntity) {
		if(minorChildrenDetailsEntity.getAccId()!=null) {
			minorRepo.save(minorChildrenDetailsEntity);
			return "Success";
		  }	
		  return "Provide Accident Id to Save";
	}

}
