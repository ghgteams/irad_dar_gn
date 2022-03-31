package com.irad.dar.pedestrian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PedestrianDetailsRepo extends JpaRepository<PedestrianIradEntity, Long>{
	@Query(nativeQuery = true,value="select *,patientdetails(id,hospitalid),health.get_hp_patient(hospitalid) as hp_details,master.get_pedestrainstatus(accident_id\\:\\:text,vehicle_id\\:\\:text,id\\:\\:text) as status from irad_pedestrian where accident_id=:accidentId and vehicle_id=:vehicleId")
	PedestrianIradEntity findByAccidentIdAndVehicleId(@Param("accidentId")String accidentId,@Param("vehicleId") String vehicleId);
    
}
