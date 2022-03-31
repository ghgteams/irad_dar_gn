package com.irad.dar.petitioners;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PetitionerDeceasedRepo extends JpaRepository<PetitionerDeceasedEntity, Long>{

}
