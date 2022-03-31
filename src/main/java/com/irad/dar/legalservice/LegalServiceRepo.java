package com.irad.dar.legalservice;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LegalServiceRepo extends JpaRepository<LegalServiceEntity, Integer>{
	@Query(nativeQuery = true,value="select * from court.legal_services_authority_register where ps_state=:state and rev_district=:districtCode  and court_type=:courtType")
	ArrayList<LegalServiceEntity> findByDistrictCode(@Param("districtCode")String district,@Param("state")String state,@Param("courtType")String courtType);
	
	@Query(nativeQuery = true,value="select * from court.legal_services_authority_register where rev_district=:districtCode and rev_taluk=:taluk and court_type=:courtType")
	ArrayList<LegalServiceEntity> findByDistrictTalukCode(@Param("districtCode")String district,@Param("taluk")String taluk,@Param("courtType")String courtType);
}
