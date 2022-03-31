package com.irad.dar.jwt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.irad.dar.master.UserDao;
import com.irad.dar.master.UserData;
import com.irad.dar.master.logData;

@Repository
public interface UserRepository extends JpaRepository<UserDao, Long> {
	
	UserDao findByUsername(Object object);
	
	@Query(nativeQuery = true,value="SELECT name, username,password,state_code,district_code,ps_code as station_code,master.get_role_name(role_code) rolename,role_code,dept_code as dept,master.get_department(dept_code,'en') department,get_statename(state_code) statename,get_ps_districtname(state_code,district_code) districtname,get_ps_name(state_code,district_code,ps_code) psname,email,created_date,active FROM master.irad_users where username= :uname")
	UserData findByName(@Param("uname")String uname);	
	// findByUsername(String uname);
	@Query(nativeQuery = true,value="select count(1) from logs.login_details where loginflag=true and  jwt=:jwt")
	String findByjwt(@Param("jwt")String jwt);
}
