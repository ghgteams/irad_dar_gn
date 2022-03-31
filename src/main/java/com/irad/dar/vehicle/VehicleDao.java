package com.irad.dar.vehicle;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDao extends JpaRepository<VehicleEntity, Long> {
	public VehicleEntity findByAccId(String accId);
	public VehicleEntity findByVehrefId(String refId);
//	public VehicleEntity findByVehId(String refid);
}
