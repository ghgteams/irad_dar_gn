package com.irad.dar.vehicle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverFamilyRepo extends JpaRepository<DriverFamilyEntity, Long>{
	public List<DriverFamilyEntity> findByAccId(String accId);

}
