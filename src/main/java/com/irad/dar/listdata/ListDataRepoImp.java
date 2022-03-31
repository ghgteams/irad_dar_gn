package com.irad.dar.listdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public class ListDataRepoImp implements ListDataRepo {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private final String VehicleDetails = "select vehicle.vehicle_reg_no as vehicle_reg_no, * from irad_vehicle vehicle inner join dar_vehicle dv on dv.veh_ref_id::integer=vehicle.id::integer inner join irad_driver driver on driver.vehicle_id::integer=vehicle.id::integer \r\n"
			+ "inner join  irad_vehicle_transport trp on trp.vehicle_reg_no::integer=vehicle.id::integer\r\n"
			+ "where vehicle.accident_id=:accident_id";

	@Override
	public VehicleRespModel dataResult(String id) {
		List<JSONObject> resObject = new ArrayList<JSONObject>();
		List<JSONObject> jObject1 = new ArrayList<JSONObject>();

		Map<String, Object> msd = new HashMap<String, Object>();

		List<Map<String, Object>> lmm = new ArrayList<Map<String, Object>>();

		VehicleRespModel vehicleRespModel = new VehicleRespModel();

		String accident_id = id;

		SqlParameterSource parameters = new MapSqlParameterSource().addValue("accident_id", accident_id);

		List<Object> ls = namedParameterJdbcTemplate.query(VehicleDetails, parameters, new RowMapper<Object>() {
			ArrayList<String> data = new ArrayList<String>();

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

				int columns = rs.getMetaData().getColumnCount();

//				System.out.println(rs.getString(columns));

				do {
					for (int i = 1; i <= columns; i++) {
						msd.put(rs.getMetaData().getColumnName(i), rs.getString(i));

//						System.out.println(rs.getMetaData().getColumnName(i));
					}
					lmm.add(msd);
				} while (rs.next());

				vehicleRespModel.setMop(msd);
				vehicleRespModel.setListMop(lmm);
				return rs;
			}
		});

		return vehicleRespModel;

	}

	@Override
	public VehicleRespModel dataAccidentResult(ReqModel reqModel, String reqOfficer) {
		List<JSONObject> resObject = new ArrayList<JSONObject>();
		List<JSONObject> jObject1 = new ArrayList<JSONObject>();

		Map<String, Object> msd = new HashMap<String, Object>();

		List<Map<String, Object>> lmm = new ArrayList<Map<String, Object>>();

		VehicleRespModel vehicleRespModel = new VehicleRespModel();
		SqlParameterSource parameter = new MapSqlParameterSource();
		String AccDetails = "";
        String OrderBy = reqModel.getOrderBy();
        int offset = reqModel.getOffset();
        int limit = reqModel.getLimit();
		if (reqModel.getRole_code().equalsIgnoreCase("60")) {
			AccDetails = "SELECT   accident_id as accid,fir_number, ipc_section,fo_user,io_user, TO_CHAR(accident_date_time::timestamp, ' dd-Mon-yyyy : HH:MI AM') as datetime, \r\n"
					+ "severity, master.get_severity(severity) as severity_desc,\r\n"
					+ "landmarks as landmark  ,fir_number as fir,master.get_mvistatus(accident_id),master.get_hwstatus(accident_id) as get_hwstatus,\r\n"
					+ "master.get_jirstatus(accident_id) as jir, master.get_ps_name(state,district,station) as ps\r\n"
					+ "FROM sp_irad_accident where active=true and  state='"+reqModel.getState()+"'  and active=true and  state='"+reqModel.getState()+"'  and  \r\n"
					+ "accident_id in (select distinct accident_id from claims.irad_dar_request where status='"+reqModel.getStatus()+"' and court_id='"+reqOfficer+"') "+OrderBy+" offset "+offset+" limit "+limit+"";
//			parameter = new MapSqlParameterSource().addValue("state", reqModel.getState()).addValue("status",
//					reqModel.getStatus());
		} else if (reqModel.getRole_code().equalsIgnoreCase("61")) {
			AccDetails = "SELECT   accident_id as accid,fir_number, ipc_section,fo_user,io_user, TO_CHAR(accident_date_time::timestamp, ' dd-Mon-yyyy : HH:MI AM') as datetime, \r\n"
					+ "severity, master.get_severity(severity) as severity_desc,\r\n"
					+ "landmarks as landmark  ,fir_number as fir,master.get_mvistatus(accident_id),master.get_hwstatus(accident_id) as get_hwstatus,\r\n"
					+ "master.get_jirstatus(accident_id) as jir, master.get_ps_name(state,district,station) as ps\r\n"
					+ "FROM sp_irad_accident where active=true and  state='"+reqModel.getState()+"'  and active=true and  state='"+reqModel.getState()+"'  and  \r\n"
					+ "accident_id in (select distinct accident_id from claims.irad_dar_request where status='"+reqModel.getStatus()+"' and court_id='"+reqOfficer+"') "+OrderBy+" offset "+offset+" limit "+limit+"";
//					reqModel.getStatus());
		}

		List<Object> ls = namedParameterJdbcTemplate.query(AccDetails, parameter, new RowMapper<Object>() {
			ArrayList<String> data = new ArrayList<String>();

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

				int columns = rs.getMetaData().getColumnCount();

//				System.out.println(rs.getString(columns));

				do {
					for (int i = 1; i <= columns; i++) {
						msd.put(rs.getMetaData().getColumnName(i), rs.getString(i));

//						System.out.println(rs.getMetaData().getColumnName(i));
					}
					lmm.add(msd);
				} while (rs.next());

				vehicleRespModel.setMop(msd);
				vehicleRespModel.setListMop(lmm);
				return rs;
			}
		});

		return vehicleRespModel;
	}

}
