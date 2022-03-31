package com.irad.dar.master;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


@Repository
@SuppressWarnings({ "unchecked","unused" })
public class UserRepoImpl implements UserRepo {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private final String GET_STATION_SERIAL = "select max(station_serial)+1 as stationcase from sp_irad_accident where state= :state and district=:district and  station=:station and year =:year ";

	// private final String GEOM_VALUE = "select ";
	private final String GET_ACCLIST = "SELECT accident_id as accid,TO_CHAR(accident_date_time :: timestamp, 'dd-Mon-yyyy : HH:MI AM') as datetime,severity,master.get_severity(severity) as severity_desc,landmarks as landmark,fir_number as fir FROM sp_irad_accident where active = true and state = :state and district = :district and station = :station and ( vehicles_count != get_vehicle_count(accident_id) or passenger_count != get_passenger_count(accident_id) or pedestrian_count != get_pedestrian_count(accident_id)) order by insert_date desc offset :offset limit :limit";

	private final String GET_ACCVIEWS = "SELECT state,district,station,year,accident_id,investigating_officer,fir_number,latitude,longitude,severity,landmarks,vehicles_count,passenger_count,pedestrian_count,driver_inj,pass_inj,"
			+ "ped_inj,driver_dead,pass_dead,ped_dead,animal_inj,animal_dead,insert_date,active,poi,userid,total_injured,total_dead,animal_inj,animal_dead,TO_CHAR(accident_date_time :: timestamp,'dd-Mon-yyyy : HH:MI AM') as datetime,TO_CHAR(reporting_datetime :: timestamp,'dd-Mon-yyyy : HH:MI AM') as repdatetime,master.get_severity(severity, :ln) as severity_desc,get_vehicle_count(accident_id) as vehicle_entered,"
			+ "get_passenger_count(accident_id) as passenger_entered,get_pedestrian_count(accident_id) as pedestrian_entered,master.get_accinfo(accident_id, :ln) as accinfo FROM sp_irad_accident where state = :state and district = :district and station = :station and accident_id = :accident_id limit 1";

	private final String GET_ACCVIEWS1 = "select *,master.get_regstatus(regnstatus,:ln),master.get_vehiclemotion(vehiclemotion,:ln),master.get_vehicledamage(vdamage,:ln),master.get_vehicledefect(vdefect,:ln),"
			+ "master.get_driver(accident_id,upper(vehicle_reg_no),:ln) as driver,master.get_passengers(accident_id,id::text,:ln) as passengers from irad_vehicle where accident_id=:accident_id";

	private final String GET_ACCVIEWS2 = "select *,master.get_veh_no(vehicle_id::int) as veh_no,master.get_severity(injury_severity,:ln) as severity_desc,"
			+ "master.get_occupation(occupation,:ln),master.get_injury_type(ped_injurytype,:ln),master.get_mod_tran_hosp(modeoftransport,:ln),"
			+ "master.get_hospitaltime(hospitaldelay,:ln),master.get_pedposition(pedpostion,:ln),master.get_pedaction(pedaction,:ln),"
			+ "master.get_injury_nature(ped_natureofinjury,:ln) from irad_pedestrian where accident_id=:accident_id";

	private final String GET_ACCVIEWS3 = "select *,master.get_roadtype(road_type,:ln),master.get_roadweather(weather,:ln),master.get_roadjunction(road_junctiontype,:ln),"
			+ "master.get_roadjunctionctrl(junctioncontrol,:ln),master.get_roadsurface(surfacecondtion,:ln),master.get_road_accspot(accident_spot,:ln),"
			+ "master.get_pedestrian_infra(pedestrian_infra,:ln) ,master.get_roadlightcondition(lightcondtion,:ln) from irad_road where accident_id=:accident_id";

	private final String GET_ACCVIEWS4 = "select *,master.get_veh_no(vehicle_reg_no::int) as veh_no from public.irad_vehicle_transport where accident_id=:accident_id";

	@Override
	public ArrayList<JSONObject> getPostDetail(String tableArrayName, String lang) {
		ArrayList<JSONObject> jObject = new ArrayList<JSONObject>();
		ArrayList<JSONObject> resObject = new ArrayList<JSONObject>();
		// String stringOne = "select id,";
		// String stringTwo = lang;
		String stringThree = tableArrayName;
		String finalString = "select id," + lang + " as name, dispid from " + stringThree + " order by dispid";
		SqlParameterSource parameter = new MapSqlParameterSource();
		namedParameterJdbcTemplate.queryForObject(finalString, parameter, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				do {

					JSONObject jOBj = new JSONObject();
					jOBj.put("id", rs.getString("id"));
					jOBj.put("name", rs.getString("name"));
					jOBj.put("dispid", rs.getString("dispid"));
					jObject.add(jOBj);
				} while (rs.next());
				// resObject.put(stringThree, jObject);
				resObject.addAll(jObject);
				return resObject;
			}
		});
		return resObject;
	}

//	@Override
//	public String insertAccidentDetails(AccidentDetailsRequest accidentDetailsRequest) {
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		KeyHolder holder = new GeneratedKeyHolder();
//		double dlatitude = Double.parseDouble(accidentDetailsRequest.getLat());
//		double dlongitude = Double.parseDouble(accidentDetailsRequest.getLon());
//		String year = "2021";
//		String stateCode = accidentDetailsRequest.getState();
//		String distCode = accidentDetailsRequest.getDistrict();
//		String stationCode = accidentDetailsRequest.getStation();
////		Date accdtparsedDate, reportdtparsedDate = null;
////		Timestamp accdttimestamp = null;
////		Timestamp reportdttimestamp = null;
//
//		try {
////			accdtparsedDate = accidentDetailsRequest.getMvalue_date_time();
////			reportdtparsedDate = accidentDetailsRequest.getReport_datetime();
////			accdtparsedDate = dateFormat.parse(accidentDetailsRequest.getMvalue_date_time());
////			reportdtparsedDate = dateFormat.parse(accidentDetailsRequest.getReport_datetime());
////			accdttimestamp = new java.sql.Timestamp(accdtparsedDate.getTime());
////			reportdttimestamp = new java.sql.Timestamp(reportdtparsedDate.getTime());
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//		String INSERT_ACCIDENT_DETAILS = "INSERT INTO public.sp_irad_accident(state, district, station, year, accident_id, investigating_officer, fir_number,"
//				+ " accident_date_time, latitude, longitude, accuracy, gps, severity, crash_type,collision_type,initial_observation, landmarks, vehicles_count, passenger_count,"
//				+ " pedestrian_count, mode_of_transfer, the_geom,insert_date, active, poi, userid,station_serial, id, total_injured, total_dead, month, driver_inj, pass_inj, ped_inj, driver_dead, pass_dead, ped_dead, offline, reporting_datetime,animal_inj, animal_dead)VALUES "
//				+ "(:state, :district, :station, :year, :accidentId, :investigatingOfficer, :firNumber, :accidentDateTime,"
//				+ ":latitude,:longitude, :accuracy, :gps, :severity,:crashType, :collisionType,:initialObservation, :landmarks,"
//				+ ":vehiclesCount, :passengerCount, :pedestrianCount,:modeOfTransfer, " + "ST_SetSRID(ST_MakePoint("
//				+ dlatitude + "," + dlongitude + "),4326)" + ",:insertDate, :active, :poi, :userid, "
//				+ ":stationSerial, :id, :totalInjured, :totalDead, :month, :driverInj, :passInj,:pedInj, :driverDead,:passDead, :pedDead,"
//				+ " :offline, :reportingDatetime,:animalInj, :animalDead)";
//		SqlParameterSource parameters = new MapSqlParameterSource().addValue("state", accidentDetailsRequest.getState())
//				.addValue("station", accidentDetailsRequest.getStation())
//				.addValue("district", accidentDetailsRequest.getDistrict())
//				.addValue("year", accidentDetailsRequest.getYear());
//		Map<String, Object> stationSerialMaxCount = namedParameterJdbcTemplate.queryForMap(GET_STATION_SERIAL,
//				parameters);
//		String stationSerial = String.format("%04d", stationSerialMaxCount.get("stationcase"));
//		String accidentId = year.concat(stateCode).concat(distCode).concat(stationCode).concat(stationSerial);
//		SqlParameterSource parameters1 = new MapSqlParameterSource().addValue("accidentId", accidentId)
//				.addValue("accidentDateTime", accidentDetailsRequest.getMvalue_date_time())
//				.addValue("accuracy", accidentDetailsRequest.getAccq())
//				.addValue("active", accidentDetailsRequest.getActive())
//				.addValue("animalDead", accidentDetailsRequest.getAnimal_dead())
//				.addValue("animalInj", accidentDetailsRequest.getAnimal_inj())
//				.addValue("collisionType", accidentDetailsRequest.getCollisionType())
//				.addValue("crashType", accidentDetailsRequest.getCrashType())
//				.addValue("district", accidentDetailsRequest.getDistrict())
//				.addValue("driverDead", accidentDetailsRequest.getDriver_dead())
//				.addValue("driverInj", accidentDetailsRequest.getDriver_inj())
//				.addValue("firNumber", accidentDetailsRequest.getFirNumber())
//				.addValue("gps", accidentDetailsRequest.getGps()).addValue("id", accidentDetailsRequest.getId())
//				.addValue("initialObservation", accidentDetailsRequest.getInitialObservation())
//				.addValue("insertDate", LocalDateTime.now())
//				.addValue("investigatingOfficer", accidentDetailsRequest.getInvestigating())
//				.addValue("landmarks", accidentDetailsRequest.getLname()).addValue("latitude", dlatitude)
//				.addValue("longitude", dlongitude)
//				.addValue("modeOfTransfer", accidentDetailsRequest.getModeOfTransfer())
//				.addValue("month", accidentDetailsRequest.getMonth())
//				.addValue("offline", accidentDetailsRequest.getOffline())
//				.addValue("passDead", accidentDetailsRequest.getPass_dead())
//				.addValue("passInj", accidentDetailsRequest.getPass_inj())
//				.addValue("passengerCount", accidentDetailsRequest.getPassengerCount())
//				// .addValue("TheGeom", accidentDetailsRequest.getTheGeom())
//				.addValue("pedDead", accidentDetailsRequest.getPed_dead())
//				.addValue("pedInj", accidentDetailsRequest.getPed_inj())
//				.addValue("pedestrianCount", accidentDetailsRequest.getPedestrianCount())
//				.addValue("poi", accidentDetailsRequest.getPoi())
//				.addValue("reportingDatetime", accidentDetailsRequest.getReport_datetime())
//				.addValue("severity", accidentDetailsRequest.getMvalue_severity())
//				.addValue("state", accidentDetailsRequest.getState())
//				.addValue("station", accidentDetailsRequest.getStation())
//				.addValue("stationSerial", Integer.parseInt(stationSerial))
//				.addValue("totalDead", accidentDetailsRequest.getTotalDead())
//				.addValue("totalInjured", accidentDetailsRequest.getTotalInjured())
//				.addValue("userid", accidentDetailsRequest.getUserid())
//				.addValue("vehiclesCount", accidentDetailsRequest.getMvalue_vcount())
//				.addValue("year", accidentDetailsRequest.getYear());
//		try {
//			int result = namedParameterJdbcTemplate.update(INSERT_ACCIDENT_DETAILS, parameters1, holder);
//			System.out.println(result);
//			return "Inserted Succesfully";
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//		return null;
//
//	}

	@Override
	public List<JSONObject> getAccViewDetail(String state, String district, String station, String id, String ln,
			String mode) {
		List<JSONObject> jObject = new ArrayList<JSONObject>();
		List<JSONObject> resObject = new ArrayList<JSONObject>();

		if (mode.equals("generalinfo")) {
			SqlParameterSource parameter = new MapSqlParameterSource().addValue("accident_id", id).addValue("ln", ln)
					.addValue("state", state).addValue("district", district).addValue("station", station);

			
			List<Object> resObjec = namedParameterJdbcTemplate.query(GET_ACCVIEWS, parameter, new RowMapper<Object>() {

				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					do {
						JSONObject jOBj = new JSONObject();
						jOBj.put("state", rs.getString("state"));
						jOBj.put("district", rs.getString("district"));
						jOBj.put("station", rs.getString("station"));
						jOBj.put("year", rs.getString("year"));
						jOBj.put("accident_id", rs.getString("accident_id"));
						jOBj.put("investigating_officer", rs.getString("investigating_officer"));
						jOBj.put("fir_number", rs.getString("fir_number"));
						jOBj.put("latitude", rs.getString("latitude"));
						jOBj.put("longitude", rs.getString("longitude"));
						jOBj.put("severity", rs.getString("severity"));
						jOBj.put("landmarks", rs.getString("landmarks"));
						jOBj.put("vehicles_count", rs.getString("vehicles_count"));
						jOBj.put("passenger_count", rs.getString("passenger_count"));
						jOBj.put("pedestrian_count", rs.getString("pedestrian_count"));
						jOBj.put("driver_inj", rs.getString("driver_inj"));
						jOBj.put("pass_inj", rs.getString("pass_inj"));
						jOBj.put("ped_inj", rs.getString("ped_inj"));
						jOBj.put("driver_dead", rs.getString("driver_dead"));
						jOBj.put("pass_dead", rs.getString("pass_dead"));
						jOBj.put("ped_dead", rs.getString("ped_dead"));
						jOBj.put("animal_inj", rs.getString("animal_inj"));
						jOBj.put("animal_dead", rs.getString("animal_dead"));
						jOBj.put("insert_date", rs.getString("insert_date"));
						jOBj.put("active", rs.getString("active"));
						jOBj.put("poi", rs.getString("poi"));
						jOBj.put("userid", rs.getString("userid"));
						jOBj.put("total_injured", rs.getString("total_injured"));
						jOBj.put("total_dead", rs.getString("total_dead"));
						jOBj.put("animal_inj", rs.getString("animal_inj"));
						jOBj.put("animal_dead", rs.getString("animal_dead"));
						jOBj.put("datetime", rs.getString("datetime"));
						jOBj.put("repdatetime", rs.getString("repdatetime"));
						jOBj.put("severity_desc", rs.getString("severity_desc"));
						jOBj.put("vehicle_entered", rs.getString("vehicle_entered"));
						jOBj.put("passenger_entered", rs.getString("passenger_entered"));
						jOBj.put("pedestrian_entered", rs.getString("pedestrian_entered"));
						jOBj.put("accinfo", rs.getString("accinfo"));
						jObject.add(jOBj);
					} while (rs.next());
					resObject.addAll(jObject);
					return resObject;

				}

			});
		} else if (mode.equals("vehicle")) {

			SqlParameterSource parameter = new MapSqlParameterSource().addValue("accident_id", id).addValue("ln", ln);

			List<Object> resObjec = namedParameterJdbcTemplate.query(GET_ACCVIEWS1, parameter, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					do {
						JSONObject jOBj = new JSONObject();
						jOBj.put("accident_id", rs.getString("accident_id"));
						jOBj.put("vehicle_reg_no", rs.getString("vehicle_reg_no"));
						jOBj.put("chasis_number", rs.getString("chasis_number"));
						jOBj.put("registration_date", rs.getString("registration_date"));
						jOBj.put("engine_nr", rs.getString("engine_nr"));
						jOBj.put("vehicle_owner", rs.getString("vehicle_owner"));
						jOBj.put("disposition", rs.getString("disposition"));
						jOBj.put("vehiclemotion", rs.getString("vehiclemotion"));
						jOBj.put("mechanical_failure", rs.getString("mechanical_failure"));
						jOBj.put("load_condtions", rs.getString("load_condtions"));
						jOBj.put("vehicle_class", rs.getString("vehicle_class"));
						jOBj.put("fuel_type", rs.getString("fuel_type"));
						jOBj.put("vehicle_make", rs.getString("vehicle_make"));
						jOBj.put("vehicle_model", rs.getString("vehicle_model"));
						jOBj.put("rc_statuson", rs.getString("rc_statuson"));
						jOBj.put("rc_status", rs.getString("rc_status"));
						jOBj.put("insurance_details", rs.getString("insurance_details"));
						jOBj.put("insurance_policyno", rs.getString("insurance_policyno"));
						jOBj.put("insurance_validity", rs.getString("insurance_validity"));
						jOBj.put("registered_at", rs.getString("registered_at"));
						jOBj.put("owneraddr", rs.getString("owneraddr"));
						jOBj.put("id", rs.getString("id"));
						jOBj.put("color", rs.getString("color"));
						jOBj.put("service_ownername", rs.getString("service_ownername"));
						jOBj.put("hitandrun", rs.getString("hitandrun"));
						jOBj.put("remarks", rs.getString("remarks"));
						jOBj.put("vdamage", rs.getString("vdamage"));
						jOBj.put("vdefect", rs.getString("vdefect"));
						jOBj.put("accused_victim", rs.getString("accused_victim"));
						jOBj.put("vaahanflag", rs.getString("vaahanflag"));
						jOBj.put("vahan_datetime", rs.getString("vahan_datetime"));
						jOBj.put("vehicle_type", rs.getString("vehicle_type"));
						jOBj.put("vehicle_subtype", rs.getString("vehicle_subtype"));
						jOBj.put("vehiclecategory", rs.getString("vehiclecategory"));
						jOBj.put("loadcategory", rs.getString("loadcategory"));
						jOBj.put("regnstatus", rs.getString("regnstatus"));
						jOBj.put("get_regstatus", rs.getString("get_regstatus"));
						jOBj.put("get_vehiclemotion", rs.getString("get_vehiclemotion"));
						jOBj.put("get_vehicledamage", rs.getString("get_vehicledamage"));
						// jOBj.put("get_manoeuvre", rs.getString("get_manoeuvre"));
						jOBj.put("driver", rs.getString("driver"));
						jOBj.put("passengers", rs.getString("passengers"));
						jObject.add(jOBj);
					} while (rs.next());
					resObject.addAll(jObject);
					return resObject;

				}

			});
		} else if (mode.equals("pedestrian")) {

			SqlParameterSource parameter = new MapSqlParameterSource().addValue("accident_id", id).addValue("ln", ln);

			
			List<Object> resObjec = namedParameterJdbcTemplate.query(GET_ACCVIEWS2, parameter, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					do {
						JSONObject jOBj = new JSONObject();
						jOBj.put("id", rs.getString("id"));
						jOBj.put("accident_id", rs.getString("accident_id"));
						jOBj.put("name", rs.getString("name"));
						jOBj.put("gender", rs.getString("gender"));
						jOBj.put("mobile", rs.getString("mobile"));
						jOBj.put("residence", rs.getString("residence"));
						jOBj.put("occupation", rs.getString("occupation"));
						jOBj.put("injury_severity", rs.getString("injury_severity"));
						jOBj.put("remarks", rs.getString("remarks"));
						jOBj.put("age", rs.getString("age"));
						jOBj.put("ped_injurytype", rs.getString("ped_injurytype"));
						jOBj.put("ped_natureofinjury", rs.getString("ped_natureofinjury"));
						jOBj.put("vehicle_id", rs.getString("vehicle_id"));
						jOBj.put("nationality", rs.getString("nationality"));
						jOBj.put("passport_nr", rs.getString("passport_nr"));
						jOBj.put("pedaction", rs.getString("pedaction"));
						jOBj.put("pedpostion", rs.getString("pedpostion"));
						jOBj.put("modeoftransport", rs.getString("modeoftransport"));
						jOBj.put("hospitaldelay", rs.getString("hospitaldelay"));
						jOBj.put("whotookvictim_hpl", rs.getString("whotookvictim_hpl"));
						jOBj.put("treatment_deny", rs.getString("treatment_deny"));
						jOBj.put("victim_hopitalizeddate", rs.getString("victim_hopitalizeddate"));
						jOBj.put("veh_no", rs.getString("veh_no"));
						jOBj.put("severity_desc", rs.getString("severity_desc"));
						jOBj.put("get_occupation", rs.getString("get_occupation"));
						jOBj.put("get_injury_type", rs.getString("get_injury_type"));
						jOBj.put("get_mod_tran_hosp", rs.getString("get_mod_tran_hosp"));
						jOBj.put("get_hospitaltime", rs.getString("get_hospitaltime"));
						jOBj.put("get_pedposition", rs.getString("get_pedposition"));
						jOBj.put("get_pedaction", rs.getString("get_pedaction"));
						jOBj.put("get_injury_nature", rs.getString("get_injury_nature"));
						jObject.add(jOBj);
					} while (rs.next());
					resObject.addAll(jObject);
					return resObject;

				}

			});

		} else if (mode.equals("environment")) {
			SqlParameterSource parameter = new MapSqlParameterSource().addValue("accident_id", id).addValue("ln", ln);

			List<Object> resObjec = namedParameterJdbcTemplate.query(GET_ACCVIEWS3, parameter, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					do {
						JSONObject jOBj = new JSONObject();
						jOBj.put("id", rs.getString("id"));
						jOBj.put("accident_id", rs.getString("accident_id"));
						jOBj.put("road_type", rs.getString("road_type"));
						jOBj.put("road_name", rs.getString("road_name"));
						jOBj.put("road_number", rs.getString("road_number"));
						jOBj.put("road_chainage", rs.getString("road_chainage"));
						jOBj.put("road_speedlimit", rs.getString("road_speedlimit"));
						jOBj.put("road_feature", rs.getString("road_feature"));
						jOBj.put("road_junctiontype", rs.getString("road_junctiontype"));
						jOBj.put("nooflanes", rs.getString("nooflanes"));
						jOBj.put("roadwork", rs.getString("roadwork"));
						jOBj.put("trafficmovement", rs.getString("trafficmovement"));
						jOBj.put("pedestrian_infra", rs.getString("pedestrian_infra"));
						jOBj.put("accident_spot", rs.getString("accident_spot"));
						jOBj.put("weather", rs.getString("weather"));
						jOBj.put("visibilty", rs.getString("visibilty"));
						jOBj.put("area_type", rs.getString("area_type"));
						jOBj.put("surfacecondtion", rs.getString("surfacecondtion"));
						jOBj.put("lightcondtion", rs.getString("lightcondtion"));
						jOBj.put("junctioncontrol", rs.getString("junctioncontrol"));
						jOBj.put("phy_divider", rs.getString("phy_divider"));
						jOBj.put("roadsurfacetype", rs.getString("roadsurfacetype"));
						jOBj.put("surfacetype", rs.getString("surfacetype"));
						jOBj.put("roadconstruction", rs.getString("roadconstruction"));
						jOBj.put("topology", rs.getString("topology"));
						jOBj.put("gradient", rs.getString("gradient"));
						jOBj.put("vert", rs.getString("vert"));
						jOBj.put("hori", rs.getString("hori"));
						jOBj.put("get_roadtype", rs.getString("get_roadtype"));
						jOBj.put("get_roadweather", rs.getString("get_roadweather"));
						jOBj.put("get_roadjunction", rs.getString("get_roadjunction"));
						jOBj.put("get_roadjunctionctrl", rs.getString("get_roadjunctionctrl"));
						jOBj.put("get_roadsurface", rs.getString("get_roadsurface"));
						jOBj.put("get_road_accspot", rs.getString("get_road_accspot"));
						jOBj.put("get_pedestrian_infra", rs.getString("get_pedestrian_infra"));
						jOBj.put("get_roadlightcondition", rs.getString("get_roadlightcondition"));
						jObject.add(jOBj);
					} while (rs.next());
					resObject.addAll(jObject);
					return resObject;

				}

			});
		} else if (mode.equals("transport")) {
			SqlParameterSource parameter = new MapSqlParameterSource().addValue("accident_id", id);
			List<Object> resObjec = namedParameterJdbcTemplate.query(GET_ACCVIEWS4, parameter, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					do {
						JSONObject jOBj = new JSONObject();
						jOBj.put("officer_name", rs.getString("officer_name"));
						jOBj.put("accident_id", rs.getString("accident_id"));
						jOBj.put("vehicle_reg_no", rs.getString("vehicle_reg_no"));
						jOBj.put("regno_status", rs.getString("regno_status"));
						jOBj.put("regno_type", rs.getString("regno_type"));
						jOBj.put("regno", rs.getString("regno"));
						jOBj.put("temp_regno_validity", rs.getString("temp_regno_validity"));
						jOBj.put("trade_plate_issuedby", rs.getString("trade_plate_issuedby"));
						jOBj.put("trade_plate_validity", rs.getString("trade_plate_validity"));
						jOBj.put("f19_sno", rs.getString("f19_sno"));
						jOBj.put("f19_tp_dt", rs.getString("f19_tp_dt"));
						jOBj.put("f19_tp_purpose", rs.getString("f19_tp_purpose"));
						jOBj.put("f19_mileage", rs.getString("f19_mileage"));
						jOBj.put("vclass", rs.getString("vclass"));
						jOBj.put("vtype", rs.getString("vtype"));
						jOBj.put("vowneraddr", rs.getString("vowneraddr"));
						jOBj.put("make", rs.getString("make"));
						jOBj.put("makeclass", rs.getString("makeclass"));
						jOBj.put("yearofmanfac", rs.getString("yearofmanfac"));
						jOBj.put("vage", rs.getString("vage"));
						jOBj.put("engineno", rs.getString("engineno"));
						jOBj.put("chassisno", rs.getString("chassisno"));
						jOBj.put("color", rs.getString("color"));
						jOBj.put("seat_cap", rs.getString("seat_cap"));
						jOBj.put("uloadenweight", rs.getString("uloadenweight"));
						jOBj.put("max_speed", rs.getString("max_speed"));
						jOBj.put("vdescription", rs.getString("vdescription"));
						jOBj.put("permitcat", rs.getString("permitcat"));
						jOBj.put("permitno", rs.getString("permitno"));
						jOBj.put("permitvalidity", rs.getString("permitvalidity"));
						jOBj.put("permitissuedby", rs.getString("permitissuedby"));
						jOBj.put("fitcertstatus", rs.getString("fitcertstatus"));
						jOBj.put("fitcertval", rs.getString("fitcertval"));
						jOBj.put("regloadenweg", rs.getString("regloadenweg"));
						jOBj.put("regcrtval", rs.getString("regcrtval"));
						jOBj.put("polctrlcertval", rs.getString("polctrlcertval"));
						jOBj.put("inscomname", rs.getString("inscomname"));
						jOBj.put("inscomaddr", rs.getString("inscomaddr"));
						jOBj.put("inscrtpolicyno", rs.getString("inscrtpolicyno"));
						jOBj.put("inscrtvalidity", rs.getString("inscrtvalidity"));
						jOBj.put("tax", rs.getString("tax"));
						jOBj.put("req_police", rs.getString("req_police"));
						jOBj.put("mvi_name", rs.getString("mvi_name"));
						jOBj.put("mvi_req_dt", rs.getString("mvi_req_dt"));
						jOBj.put("place_ins", rs.getString("place_ins"));
						jOBj.put("lefthanddrive", rs.getString("lefthanddrive"));
						jOBj.put("vlength", rs.getString("vlength"));
						jOBj.put("vwidth", rs.getString("vwidth"));
						jOBj.put("vheight", rs.getString("vheight"));
						jOBj.put("heightofbtoe", rs.getString("heightofbtoe"));
						jOBj.put("damge_sustained", rs.getString("damge_sustained"));
						jOBj.put("vdamagestat", rs.getString("vdamagestat"));
						jOBj.put("conditionofbreak", rs.getString("conditionofbreak"));
						jOBj.put("effoffoodbreak", rs.getString("effoffoodbreak"));
						jOBj.put("effofhandbreak", rs.getString("effofhandbreak"));
						jOBj.put("breakseorn", rs.getString("breakseorn"));
						jOBj.put("cffb_hydair", rs.getString("cffb_hydair"));
						jOBj.put("cffb_mech", rs.getString("cffb_mech"));
						jOBj.put("cfhandbreak", rs.getString("cfhandbreak"));
						jOBj.put("streeringtype", rs.getString("streeringtype"));
						jOBj.put("streeingcond", rs.getString("streeingcond"));
						jOBj.put("tyrecond", rs.getString("tyrecond"));
						jOBj.put("opif_vd_rd", rs.getString("opif_vd_rd"));
						jOBj.put("mech_fstat", rs.getString("mech_fstat"));
						jOBj.put("vdefecttype", rs.getString("vdefecttype"));
						jOBj.put("skidmark", rs.getString("skidmark"));
						jOBj.put("trackmark", rs.getString("trackmark"));
						jOBj.put("skidleng", rs.getString("skidleng"));
						jOBj.put("disposofv", rs.getString("disposofv"));
						jOBj.put("whechkrepiss", rs.getString("whechkrepiss"));
						jOBj.put("whecfxiss", rs.getString("whecfxiss"));
						jOBj.put("insdt", rs.getString("insdt"));
						jOBj.put("ownername", rs.getString("ownername"));
						jOBj.put("veh_no", rs.getString("veh_no"));
						jObject.add(jOBj);
					} while (rs.next());
					resObject.addAll(jObject);
					return resObject;

				}

			});
		} else if (mode.equals("media")) {

		} else if (mode.equals("disable")) {

		} else {

		}

		return resObject;
	}

	@Override
	public ArrayList<JSONObject> getPostDetail(String state, String district, String station, String mode, String type,
			int dept, int offset, int limit) {
		ArrayList<JSONObject> jObject = new ArrayList<JSONObject>();
		ArrayList<JSONObject> resObject = new ArrayList<JSONObject>();
		// JSONObject resObject1 = new JSONObject();
		SqlParameterSource parameter = new MapSqlParameterSource().addValue("state", state)

				.addValue("district", district)

				.addValue("station", station)

				.addValue("offset", offset)

				.addValue("limit", limit);
//		if (mode == "acclist") {
//			if (type == "pending") {
//				if (dept == '1') {
//
//				}
//				if (dept == '2') {
//
//				}
//				if (dept == '3' || dept == '4') {
//
//				}
//			} else if (type == "completed") {
//
//			} else if (type == "disabled") {
//
//			}
//		} else if (mode == "accSearch") {
//
//		} else {
//			System.out.println("Spme Thing Went Wrong!!!!");
//		}

		List<Object> resObjec = namedParameterJdbcTemplate.query(GET_ACCLIST, parameter, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				do {
					JSONObject jOBj = new JSONObject();
					jOBj.put("accid", rs.getString("accid"));
					jOBj.put("datetime", rs.getString("datetime"));
					jOBj.put("severity", rs.getString("severity"));
					jOBj.put("severity_desc", rs.getString("severity_desc"));
					jOBj.put("landmark", rs.getString("landmark"));
					jOBj.put("fir", rs.getString("fir"));
					jObject.add(jOBj);
				} while (rs.next());
//				resObject1.put("data", jObject);
//				resObject1.put("data", jObject);
				resObject.addAll(jObject);
				return resObject;

			}

		});

		return resObject;

	}

	/**
	 * create post detail
	 */
//	@Override
//	public Long createPostDetail(String title, String content, String thumbURL, String pictureURL, String userId, String userNmae ) {
//		
//		KeyHolder holder = new GeneratedKeyHolder();
//		SqlParameterSource parameters = new MapSqlParameterSource()
//				.addValue("title", title)
//				.addValue("content", content)
//				.addValue("picture", pictureURL)
//				.addValue("thumbnail", thumbURL)
//				.addValue("created_user_id", userId)
//			//	.addValue("created_on", DateConvertion.getSystemDate())
//				//.addValue("updated_on", DateConvertion.getSystemDate())
//				.addValue("deleted", false)
//				.addValue("username", userNmae);
//				//.addValue("published_on", DateConvertion.getSystemDate());
//			try { 
//			  namedParameterJdbcTemplate.update(INSERT_POST, parameters, holder);
//			  }
//		  catch (Exception e) { 
//			//  throw new DaoException(e);
//		  }	
//		return holder.getKey().longValue();
//	}

//	@Override
//	public PostDetailList getPostDetail(Long postId) {
//		SqlParameterSource parameter = new MapSqlParameterSource()
//			.addValue("id", postId);
//			return (PostDetailList)namedParameterJdbcTemplate.queryForObject(GET_POST_DETAIL,parameter, new RowMapper<Object>() {
//				        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				        	PostDetailList post = new PostDetailList();
//				        	post.setRetPictureURL(rs.getString("retPictureURL"));
//				        	post.setRetThumbnailURL(rs.getString("retThumbnailURL"));
//				        	post.setRetId(String.valueOf(rs.getLong("retId")));
//				        	post.setRetContent(rs.getString("retContent"));
//				           	post.setRetTitle(rs.getString("retTitle"));
//				        	post.setRetChecksumId(rs.getString("retChecksumId"));
//				        	post.setRetpublishedOn(rs.getString("retpublishedOn"));
//				        	post.setRetUserName(rs.getString("username"));
//				            return post;
//				         }
//				    });			
//		
//	}
//	@Override
//	public PostURL getPostUrls(Long postId) {
//		
//		
//			 SqlParameterSource parameter = new MapSqlParameterSource()
//			.addValue("id", postId);
//			return (PostURL)namedParameterJdbcTemplate.queryForObject(GET_POST_URL,	parameter, new RowMapper<Object>() {
//				        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				        	PostURL postURL = new PostURL();
//				        	postURL.setPicture(rs.getString("picture"));
//				        	postURL.setThumbnail(rs.getString("thumbnail"));
//				            return postURL;
//				        }
//				    });			
//		
//	}

//	@Override
//	public AccDetailList getAccList() {
//		//ArrayList<AccDetailList> certList = (ArrayList<AccDetailList>) namedParameterJdbcTemplate.queryForObject(GET_ACC_DETAIL,parameter, new RowMapper<Object>());
//		  //  cert =  DataAccessUtils.singleResult(certList);
//		 SqlParameterSource parameter = new MapSqlParameterSource();
//					return (AccDetailList)namedParameterJdbcTemplate.queryForObject(GET_ACC_DETAIL,	parameter, new RowMapper<Object>() {
//						        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//						        	AccDetailList accDetailList = new AccDetailList();
//						            return accDetailList;
//						        }
//	});									
//	}
	@Override
	public String getUser(String token) {
		Date dt = new Date();
		return dt.toString();
	}

	@Override
	public void getMasterDetails(String language) {

	}

}
