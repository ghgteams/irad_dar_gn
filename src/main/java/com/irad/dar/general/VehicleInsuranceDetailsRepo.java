package com.irad.dar.general;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface VehicleInsuranceDetailsRepo extends JpaRepository<VehicleDetails, Long>{
	@Query(nativeQuery = true,value="select id,upper(vehicle_reg_no) as vehicle,accused_victim,insurance_details,insurance_policyno,insurance_validity from irad_vehicle where accident_id=:accidentId  and insurance_details!='' and insurance_policyno!=''")
	public List<VehicleDetails> getVehicleInsuranceDetails(String accidentId);
}
