package com.irad.dar.insurance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceDeceasedRepo extends JpaRepository<InsuranceDeceasedEntity, Long>{

}
