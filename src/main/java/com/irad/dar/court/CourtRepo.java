package com.irad.dar.court;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtRepo extends JpaRepository<CourtEntity, Long>{
	@Query(nativeQuery = true,value="select * from spatial_layer.sp_india_districts where ps_state=:stateCode order by dtname")
	ArrayList<CourtEntity> findByStcode11(@Param("stateCode")String id);

	
}
