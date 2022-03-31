package com.irad.dar.pdf;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDetailsRepo extends JpaRepository<vehicleDetailsEntity, Long>{
	List<vehicleDetailsEntity> findByVehicleRegNo(String vehicleRegNo);

	List<vehicleDetailsEntity> findByAccidentId(String accidentId);

	List<vehicleDetailsEntity> findById(int id);
}
