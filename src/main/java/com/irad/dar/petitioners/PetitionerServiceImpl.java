package com.irad.dar.petitioners;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


@Service
public class PetitionerServiceImpl implements PetitionerService{
	@Autowired
	PetitionerDeceasedRepo petitionerDeceasedRepo;
	
	@Autowired
	PetitionerInjuredRepo petitionerInjuredRepo;

	@Override
	public String saveInsuranceDeceased(PetitionerDeceasedEntity petitionerDeceasedEntity) {
		if(!Objects.isNull(petitionerDeceasedEntity)) {
			try {
				petitionerDeceasedRepo.save(petitionerDeceasedEntity);
				return "1";
			} catch (DataIntegrityViolationException e) {
			    System.out.println("Already exist");
			    return "0";
			}
			
		}
		return "0";
	}

	@Override
	public String savePetitionerInjured(PetitionerInjuredEntity petitionerInjuredEntity) {
		if(!Objects.isNull(petitionerInjuredEntity)) {
			try {
				petitionerInjuredRepo.save(petitionerInjuredEntity);
				return "1";
			} catch (DataIntegrityViolationException e) {
			    System.out.println("Already exist");
			    return "0";
			}
			
		}
		return "0";
	}

}
