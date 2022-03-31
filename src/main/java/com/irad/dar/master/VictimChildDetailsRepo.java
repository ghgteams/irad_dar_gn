package com.irad.dar.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VictimChildDetailsRepo extends JpaRepository<VictimChildDetailsEntity,Long>{

}
