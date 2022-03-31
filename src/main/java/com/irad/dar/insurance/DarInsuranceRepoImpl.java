package com.irad.dar.insurance;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class DarInsuranceRepoImpl implements InsuranceViewRepo{
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final String insuranceDetails = "select *,master.get_veh_no(vehicle_id::int) vehregno,documents.get_dar_insurance_death(accident_id,vehicle_id),documents.get_dar_insurance_injured(accident_id,vehicle_id)"
			+ " from dar_insurance where accident_id=:accidentId";
	@Override
	public DarInsuranceEntity getInsuranceDetails(String accidentId) {
		DarInsuranceEntity darInsuranceEntity = new DarInsuranceEntity();
		SqlParameterSource parameters = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(insuranceDetails, parameters, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return darInsuranceEntity;
				
			}
		
	});
		return  darInsuranceEntity;
}
}
