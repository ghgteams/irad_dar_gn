package com.irad.dar.familydetails;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irad.dar.vehicle.DriverFamilyEntity;

@Repository
public interface FamilyDetailsRepo extends JpaRepository<FamilydetailsEntity, Long> {
	public List<FamilydetailsEntity> findByAccId(String accId);

	public List<FamilydetailsEntity> findByUserType(String userType);
}
