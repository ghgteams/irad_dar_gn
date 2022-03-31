package com.irad.dar.pedestrian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PedestrianRepo extends JpaRepository<PedestrianEntity, Long>{
  public PedestrianEntity findByAccId(String accId);
  PedestrianEntity findByPedestrianId(String refid);
}
