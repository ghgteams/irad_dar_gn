package com.irad.dar.insurance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DarInsuranceRepo extends JpaRepository<DarInsuranceEntity, Long>{

	DarInsuranceEntity getInsuranceDetails(String accidentId);
	

}
