package com.irad.dar.insurance;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface InsuranceCompanyRepo extends JpaRepository<InsuranceCompany, Long>{
	@Query(nativeQuery = true,value="select id,code,name from sp_insurance_company where active=true and state_code is null order by 2")
	ArrayList<InsuranceCompany> getInsuranceCompany();

}
