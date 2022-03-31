package com.irad.dar.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralDardao extends JpaRepository<GeneralEntity, Long> {
		GeneralEntity findByAccId(String accid);
		
}
