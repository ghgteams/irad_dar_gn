package com.irad.dar.master;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class VictimFamilyDetailsServiceImpl implements VictimFamilyDetailsService{
	@Autowired
	VictimFamilyDetailsRepo victimFamilyDetailsRepo;
	@Autowired
	VictimChildDetailsRepo victimChildDetailsRepo;
	
	@Override
	public String saveVictimFamilyDetails(VictimFamilyDetailsEntity victimFamilyDetailsEntity) {
		String result = null;
		if(!Objects.isNull(victimFamilyDetailsEntity)) {
			try {
				victimFamilyDetailsRepo.save(victimFamilyDetailsEntity);
				return "Inserted Successfully";
			} catch (DataIntegrityViolationException e) {
			    //System.out.println("Already exist");
			    return "Not Inserted";
			}
				
		
		}
		return "Not Inserted";
	}

	@Override
	public String saveVictimChildDetailsEntity(VictimChildDetailsEntity victimChildDetailsEntity) {
		String result = null;
		if(!Objects.isNull(victimChildDetailsEntity)) {
			try {
				victimChildDetailsRepo.save(victimChildDetailsEntity);
				return "Inserted Successfully";
			} catch (DataIntegrityViolationException e) {
			    //System.out.println("Already exist");
			    return "Not Inserted";
			}
				
		
		}
		return "Not Inserted";
		
	}

}
