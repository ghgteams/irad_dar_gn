package com.irad.dar.pedestrian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PedestrianRepository extends JpaRepository<PedestrianNewEntity, String>{

}
