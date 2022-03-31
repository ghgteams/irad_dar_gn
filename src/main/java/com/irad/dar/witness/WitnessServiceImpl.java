package com.irad.dar.witness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irad.dar.general.GeneralEntity;

@Service
public class WitnessServiceImpl implements WitnessService{

	@Autowired
	WitnessRepo witnessRepo;

	
	@Override
	public List<WitnessEntity> getWitnessdata(String accid) {
		System.out.println("WitnessAcc Id"+accid);
		List<WitnessEntity> witnessEntities=witnessRepo.findByAccId(accid);
		System.out.println("WitnessEntities"+witnessEntities);
		//general
		return witnessEntities;
	}


	@Override
	public String saveWitness(WitnessEntity witnessEntity) {
		System.out.println("generalEntity.getAcc_id"+witnessEntity.getAccId());
		  if(witnessEntity.getAccId()!=null) {
			  witnessRepo.save(witnessEntity);
			return "Success";
		  }	
		  return "Failed";
	}
}
