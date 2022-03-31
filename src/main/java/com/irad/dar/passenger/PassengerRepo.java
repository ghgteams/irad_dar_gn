package com.irad.dar.passenger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




public interface PassengerRepo extends JpaRepository<PassengerEntity, Long>{
	public PassengerEntity findByAccId(String accId);
	PassengerEntity findByPassengerId(String passengerId);
	
//	@Query("select 'passenger', as type id, name from irad_passenger where accident_id= :accid union"
//			+"select 'pedentrian', as type id, name from irad_pedestrian where accident_id= :accid")
//	List<VictimListPojo> getListofVictims(String accid);

}
