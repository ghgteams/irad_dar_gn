package com.irad.dar.court;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimsRepo extends JpaRepository<ClaimsEntity, Long>{

}
