package com.irad.dar.court;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.irad.dar.master.UserDao;

@Repository
public interface DistrictCourtUsersRepo extends JpaRepository<UserDao, Long>{
	@Query(nativeQuery = true,value="select * from master.irad_users where office_id=:officeId and role_code=:roleId")
	ArrayList<UserDao> findByOfficeId(@Param("officeId")String officeId,@Param("roleId")String roleId);
}
