package com.irad.dar.petitioners;

public interface PetitionerService {

	String saveInsuranceDeceased(PetitionerDeceasedEntity petitionerDeceasedEntity);

	String savePetitionerInjured(PetitionerInjuredEntity petitionerInjuredEntity);

}
