package com.irad.dar.court;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtListRepo extends JpaRepository<CourtListEntity, Integer> {
	@Query(nativeQuery = true,value="select * from court.courtregister where ps_state=:state and rev_district=:districtCode  and court_type=:courtType")
	ArrayList<CourtListEntity> findByDistrictCode(@Param("districtCode")String district,@Param("state")String state,@Param("courtType")String courtType);
	
	@Query(nativeQuery = true,value="select * from court.courtregister where rev_district=:districtCode and rev_taluk=:taluk and court_type=:courtType")
	ArrayList<CourtListEntity> findByDistrictTalukCode(@Param("districtCode")String district,@Param("taluk")String taluk,@Param("courtType")String courtType);

	@Query(nativeQuery = true,value="select *,spatial_layer.dtname(rev_state,rev_district),spatial_layer.stname(rev_state),master.get_courttype(court_type,'en') from court.courtregister where ps_state=:psId and id=:officeId")
	ArrayList<CourtListEntity> findByStateOfficeId(@Param("psId")String psId,@Param("officeId")int officeId);
}
 
 

 
