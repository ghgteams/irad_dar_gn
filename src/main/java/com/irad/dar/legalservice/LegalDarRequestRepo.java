package com.irad.dar.legalservice;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface LegalDarRequestRepo extends JpaRepository<LegalDarRequestEntity, String>{

	public LegalDarRequestEntity findByAccidentId(String accidentId);

	
	@Transactional
	@Modifying
	@Query(nativeQuery = true,value="update court.irad_dar_request_legal set legal_id=:legalId where accident_id=:accidentId")
	int updateDarRequest(String accidentId, String legalId);

}
