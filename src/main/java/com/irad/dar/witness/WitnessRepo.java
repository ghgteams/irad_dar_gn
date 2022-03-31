package com.irad.dar.witness;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irad.dar.general.GeneralEntity;


@Repository
public interface WitnessRepo extends JpaRepository<WitnessEntity, Long> {
	
	
	
	public List<WitnessEntity> findByAccId(String accId);

}