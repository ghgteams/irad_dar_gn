package com.irad.dar.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GeneralRepo extends JpaRepository<GeneralEntity, String> {	
	
	public GeneralEntity findByAccId(String accId);
	
	@Query(nativeQuery = true,value="select count(*) as getcount from edar_formsubmition where accident_id=:accidentId and status='1'")
	public String formSubmission(String accidentId);
	
	

}
