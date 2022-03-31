package com.irad.dar.court;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.irad.dar.master.MasterEntity;
import com.irad.dar.master.UserDao;

@Repository
public interface TalukRepo extends JpaRepository<TalukEntity, Long>{
	@Query(nativeQuery = true,value="select * from spatial_layer.sp_tn_taluk where dtcode11=:dtcode11")
	ArrayList<TalukEntity> findByDtcode11(@Param("dtcode11")String id);

	
}
