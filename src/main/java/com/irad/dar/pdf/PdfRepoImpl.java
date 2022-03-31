package com.irad.dar.pdf;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class PdfRepoImpl implements PdfRepo {
	

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/////// form1
	private final String GET_ACCIDENT_DETAILS = "SELECT landmarks,TO_CHAR(accident_date_time::timestamp, ' dd-Mon-yyyy : HH:MI AM') as acctime,TO_CHAR(reporting_datetime::timestamp, ' dd-Mon-yyyy : HH:MI AM') as "
			+ "reporting_datetime,state,a.district,station,year,a.accident_id,a.io_user,a.fir_number,a.latitude,a.longitude,a.severity,a.road_details,INITCAP(landmarks) as landmarks,a.vehicles_count,"
			+ "a.passenger_count,a.pedestrian_count,a.driver_inj,a.pass_inj,a.ped_inj,a.driver_dead,a.pass_dead, a.ped_dead,a.animal_inj,master.get_statename(state) as statename,a.animal_dead,"
			+ "master.get_districtname(state, district)as districtname,a.insert_date,a.active,a.poi,a.total_injured,a.total_dead,a.animal_inj,a.animal_dead,TO_CHAR(accident_date_time::timestamp,'dd-Mon-yyyy : HH:MI AM') as datetime,\r\n"
			+ "TO_CHAR(reporting_datetime::timestamp,' dd-Mon-yyyy : HH:MI AM') as repdatetime,master.get_severity(severity,'') as severity_desc,a.gps,get_vehicle_count(a.accident_id) as vehicle_entered,"
			+ "get_passenger_count(a.accident_id) as passenger_entered, get_pedestrian_count(a.accident_id) as pedestrian_entered,master.get_accinfo(a.accident_id,'') as accinfo,get_ps_name(state,district,station)as"
			+ " psname,a.section,b.collision_type,c.name,c.mobile,c.regno,TO_CHAR(firdatetime::timestamp, ' dd-Mon-yyyy : HH:MI AM') as firdatetime,a.act as act,a.road_details as roaddetails,"
			+ "master.get_officer_test(a.io_user,'en') as reqofficer FROM public.sp_irad_accident a ,irad_accident b,master.irad_users c where a.accident_id=:accidentId and b.accident_id=a.accident_id and"
			+ " c.username=a.io_user limit 1";

	private final String sqlvec = "select regnstatus,id, accident_id, vehicle_reg_no,INITCAP(chasis_number) as ch, registration_date, INITCAP(engine_nr) as er,INITCAP(vehicle_owner) as own, INITCAP(disposition) as"
			+ " desp,load_condtions, vehicle_class,INITCAP(fuel_type) as fuel,master.get_regstatus(regnstatus,'en') as regnoknown,INITCAP(vehicle_make) as make, INITCAP(vehicle_model) as model, INITCAP(rc_statuson) "
			+ "as rcon, INITCAP(rc_status) as rc,INITCAP(insurance_details) as ins, insurance_policyno, insurance_validity, INITCAP(registered_at) as reg from irad_vehicle where accident_id=:accidentId";

	private final String injuredAndDeceased = "select id,ser_name as name,master.get_severity(injury_severity) as severity,injury_severity,mobile_no,residence as address from irad_driver where accident_id=:accidentId and"
			+ " injury_severity!='5' and vehicle_id in(select id::text from irad_vehicle where accident_id=:accidentId and accused_victim='Victim') union select id,name as name,master.get_severity(injury_severity) "
			+ "as severity,injury_severity,mobile,residence as address from irad_passenger where accident_id=:accidentId  and injury_severity!='5' union \r\n"
			+ "select id,name as name,master.get_severity(injury_severity)"
			+ " as severity,injury_severity,mobile,residence as address from irad_pedestrian where accident_id=:accidentId and injury_severity!='5'";

	private final String darGeneral = "select * from dar_general a JOIN dar_vehicle b on a.acc_id = b.acc_id where a.acc_id=:accidentId and veh_ref_id::integer in(select id from irad_vehicle where accident_id=:accidentId order by accused_victim limit 1)";

	private final String detailsOfVehicleDriver = "SELECT *,court.getinsuranceaddress(irad_vehicle.accident_id,irad_vehicle.id::text)as insaddress FROM irad_vehicle INNER JOIN irad_driver ON irad_vehicle.id::text = irad_driver.vehicle_id and irad_vehicle.accident_id = :accidentId order by accused_victim";

	private final String hospitalDetails = "select patient_name,doctor_name,doctor_regno,health.get_hospitalname_hpid(hospital_id) as hpname,health.get_hospitaladdr_hpid(hospital_id) as hpaddress from irad_hospital"
			+ " where accident_id=:accidentId group by patient_name,hospital_id,doctor_name,doctor_regno";
	
	private final String form1DocAttached = "select doc_name from documents.edar_forms_doc where accident_id=:accidentId and formno='1' and srctypec='attachment' and doc_name='fir'";

	/////// form2
	private final String victimDetails = "select name from irad_passenger where accident_id=:accidentId UNION select name from irad_pedestrian where accident_id=:accidentId UNION select ser_name as name from "
			+ "irad_driver where accident_id=:accidentId";
	private final String form2DocAttached = "select * from documents.edar_forms_doc where accident_id=:accidentId and formno='2' and srctypec='main' and doc_name='rightsofvictims'";

	/////// form 3
	private final String driver = "select drivinglicencetype,ser_dltransvaldtill,accident_id,ser_name as name,ser_permadd1 as permadd1,ser_dateofbirth as dateofbirth,ser_gender,ser_mobileno as sermobile,residence,"
			+ "injury_severity,age,license_number,education,master.get_education(education,'en') as drivereducation,ser_registration_authority,ser_dlnontransvaldtill,occupation,master.get_occupation(occupation,'')as"
			+ " driveroccupation,master.get_drivinglicencetype(drivinglicencetype,'')as licencetype from irad_driver where accident_id=:accidentId and vehicle_id=:vehicleId";

	private final String darVehicleData = "SELECT a.vehicle_no,a.dri_license_validity,a.dri_license_authority,a.driver_father_name,a.driver_education,a.driver_income,a.owner_mobile_no,b.vehicle_type,b.vehicle_reg_no,"
			+ "b.owneraddr,b.service_ownername,b.insurance_details,b.insurance_policyno,b.insurance_validity,master.get_vehicletype(vehicle_type,'') as vehicletype FROM dar_vehicle a INNER JOIN irad_vehicle b on "
			+ "a.acc_id=:accidentId and a.acc_id=b.accident_id and a.veh_ref_id=:vehicleId and a.veh_ref_id::integer=b.id";
	private final String form3DocLicense = "select doc_name as driving from documents.edar_forms_doc where accident_id=:accidentId and formno='3' and srctypec='attachment' and doc_name='drivinglicense'";

	private final String form3DocAddProof = "select doc_name as addproof from documents.edar_forms_doc where accident_id=:accidentId and formno='3' and srctypec='attachment' and doc_name='addproof'";

	private final String form3DocInsurance = "select doc_name as inspolicy from documents.edar_forms_doc where accident_id=:accidentId and formno='3' and srctypec='attachment' and doc_name='inspolicy'";

	/////// form4
	private final String driverReport4 = "select ser_registration_authority ,accident_id,ser_name as name,ser_permadd1 as permadd1,mobile_no,ser_mobileno as sermobile,residence,license_number,\r\n"
			+ "ser_dlnontransvaldtill,ser_dltransvaldtill,ser_dlnontransvaldtill,ser_dlhazrdvaldtill from irad_driver where accident_id=:accidentId and vehicle_id=:vehicleId";

	private final String darVehicleDataReport4 = "SELECT a.mact_owner_vehicle_fir,b.registered_at as ser_registration_authority, a.dri_license_validity,court.getinsuranceaddress(:accidentId,:vehicleId)as insaddress,a.dri_license_authority,a.driver_father_name,a.owner_occupation,"
			+ "a.owner_father_name,a.driver_education,a.driver_income,a.owner_mobile_no,a.owner_details_pre_ins,a.owner_mact,a.owner_report_acc,b.vehicle_type,b.vehicle_reg_no as regno,b.color,b.vehicle_make,"
			+ "b.vehicle_model,b.chasis_number,b.engine_nr,b.owneraddr,b.service_ownername,b.insurance_details,b.insurance_policyno,b.insurance_validity,b.loadcategory as vehicleusetype,"
			+ "master.get_vehicletype(vehicle_type,'') as vehicletype,b.rc_np_no as permitno,b.rc_np_upto as permitvalidity,b.rc_fit_upto as fitcertval,b.rc_manu_month_yr\r\n"
			+ "	FROM dar_vehicle a INNER JOIN irad_vehicle b on a.acc_id=:accidentId and a.acc_id=b.accident_id and a.veh_ref_id=:vehicleId and a.veh_ref_id::integer=b.id";

	private final String vehicleTransportReport4 = "select yearofmanfac,inscomaddr,permitno,permitvalidity,fitcertval from irad_vehicle_transport where accident_id=:accidentId";

	private final String form4AddProof = "select * from documents.edar_forms_doc where accident_id=:accidentId and formno='4' and srctypec='attachment' and doc_name='addproof' and refid=:vehicleId";
	private final String form4RegCert = "select * from documents.edar_forms_doc where accident_id=:accidentId and formno='4' and srctypec='attachment' and doc_name='regncertificate' and refid=:vehicleId";
	private final String form4DriLicense = "select * from documents.edar_forms_doc where accident_id=:accidentId and formno='4' and srctypec='attachment' and doc_name='drivinglicense' and refid=:vehicleId";
	private final String form4Insurance = "select * from documents.edar_forms_doc where accident_id=:accidentId and formno='4' and srctypec='attachment' and doc_name='inpolicy' and refid=:vehicleId";
	private final String form4Permit = "select * from documents.edar_forms_doc where accident_id=:accidentId and formno='4' and srctypec='attachment' and doc_name='permit' and refid=:vehicleId";
	private final String form4Fitness = "select * from documents.edar_forms_doc where accident_id=:accidentId and formno='4' and srctypec='attachment' and doc_name='fitness' and refid=:vehicleId";

	/////// form5
	private final String report5 = "SELECT e.section,court.getinsuranceaddress(:accidentId,:vehicleId)as insaddress,a.dri_license_validity,a.owner_mobile_no,a.dri_license_authority,a.driver_father_name,a.driver_father_name,a.owner_father_name,\r\n"
			+ "b.vehicle_reg_no,b.vehicle_make,b.vehicle_model,b.owneraddr,b.service_ownername,b.insurance_details,b.insurance_policyno,b.insurance_validity,\r\n"
			+ "b.rc_np_no as permitno,b.rc_fit_upto as fitcertval,d.accident_id,d.ser_name as name,d.ser_permadd1 as permadd1,\r\n"
			+ "d.ser_mobileno as sermobile,d.residence,d.license_number,master.get_drivinglicencetype(d.drivinglicencetype,'') as drivinglicencetype,d.mobile_no,d.ser_registration_authority,d.ser_dltransvaldtill,b.rc_np_upto as permitvalidity,TO_CHAR(accident_date_time::timestamp,' dd-Mon-yyyy : HH:MI AM') as datetime \r\n"
			+ "FROM dar_vehicle a INNER JOIN irad_vehicle b  on a.acc_id=:accidentId and a.acc_id=b.accident_id and a.veh_ref_id=:vehicleId and\r\n"
			+ "a.veh_ref_id::integer=b.id inner join irad_driver d on a.acc_id=d.accident_id and a.veh_ref_id=d.vehicle_id inner join sp_irad_accident e \r\n"
			+ "on a.acc_id=e.accident_id";

	private final String report5formDargeneral = "SELECT * FROM public.dar_general where acc_id=:accidentId";

	private final String sqlwitness = "SELECT initcap(name) as name,mobile,address as residence from public.irad_witness where accident_id=:accidentId";
	private final String detailsOfCompliance = "select id, dt_filing_far, dt_uploading_far, dt_delivery_fir_far_to_inscompany, dt_delivery_fir_form2_far_to_victim, dt_receipt_form3_from_driver, dt_receipt_form4_from_owner,"
			+ "dt_delivery_form3_Form4_to_inscompany, dt_delivery_form3_form4_to_victim,doc_of_driver_or_owner, acc_id, doc_of_driver_or_owner_verified from dar_details_of_compliance where acc_id=:accidentId";

	private final String form5FAR = "select formno from public.edar_formsubmition where accident_id=:accidentId and formno='1'";
	private final String form5RightsOfVictim = "select formno from public.edar_formsubmition where accident_id=:accidentId and formno='2'";
	private final String form5DriverForm = "select formno from public.edar_formsubmition where accident_id=:accidentId and formno='3'";
	private final String form5OwnerForm = "select formno from public.edar_formsubmition where accident_id=:accidentId and formno='4'";
	private final String form5Verification = "select formno from public.edar_formsubmition where accident_id=:accidentId and formno='10'";

	private final String report5form1 = "SELECT TO_CHAR(submitedon::timestamp, ' dd-Mon-yyyy : HH:MI AM') as submitedon FROM public.edar_formsubmition where accident_id=:accidentId and formno='1'";

	private final String report5form2 = "SELECT TO_CHAR(submitedon::timestamp, ' dd-Mon-yyyy : HH:MI AM') as submitedon FROM public.edar_formsubmition where accident_id=:accidentId and formno='2'";

	private final String report5form3 = "SELECT TO_CHAR(submitedon::timestamp, ' dd-Mon-yyyy : HH:MI AM') as submitedon FROM public.edar_formsubmition where accident_id=:accidentId and formno='3'";

	private final String report5form4 = "SELECT TO_CHAR(submitedon::timestamp, ' dd-Mon-yyyy : HH:MI AM') as submitedon FROM public.edar_formsubmition where accident_id=:accidentId and formno='4'";

	/////// form8
	private final String roadDetails = "select b.road_width,e.collision_type,master.get_collisiontype(e.collision_type,'en') as collisiontype,a.road_details,a.landmarks,b.type_carriageway,b.accident_locations,TO_CHAR(c.dt_siteplan::timestamp, ' dd-Mon-yyyy ') as dt_siteplan,"
			+ "c.description_siteplan,master.get_collisionnature(collnature,'en')as collisionnature from sp_irad_accident a inner join irad_road b  on a.accident_id=:accidentId inner join dar_general c on  "
			+ "a.accident_id=c.acc_id inner join irad_accident e on  a.accident_id=e.accident_id and a.accident_id=b.accident_id ";

	/////// form9
	private final String report9 ="select TO_CHAR(a.res_datetime::timestamp, ' dd-Mon-yyyy ') as res_datetime,master.get_username(res_officer) as res_officer,master.get_officer(a.res_officer,'en') as detailsofresoff,c.regno\r\n"
			+ "from irad_mvi_request a INNER JOIN master.irad_users c on a.accident_id=:accidentId and a.veh_reg_no=:vehicleId and c.username=a.res_officer";

	private final String report9a = "select a.make,a.engineno,a.chassisno,a.color,b.vehicle_reg_no,master.get_typeofvehicle(b.vehicle_type,'') as vehicletype,a.makeclass,a.location_scratch,\r\n"
			+ "a.permitno,a.permitissuedby,a.permitvalidity,master.get_permitcategory(regno_type,'en') as gpermitcategory,a.fitcertstatus,a.fitcertval,a.painttransfer,\r\n"
			+ "a.locationoftransfer,a.coloroftransfer,a.tofs,master.get_vehicledamagestatus(vdamagestat,'en') as  pointOfImpact,damge_sustained,\r\n"
			+ "master.get_steeringtype(streeringtype,'en') as  gstreeringtype,master.get_condtionofsteering(a.streeingcond,'en') as gcondtionofsteering,\r\n"
			+ "a.wheeltype,a.wiperstype,a.mirrors,a.dispinstallingcngosofv,master.get_tyrecondition(tyrecond,'en') as gtyrecondition,a.horn_installed,a.hornfunctional,a.lightsfuntional,\r\n"
			+ "a.faultynumberplate,a.airbags,a.airbagsfunctional,a.dodamages,a.tintedglass,a.psvinstalled,a.psvfunctional,a.parkingsensors,a.sensorfunctional,a.vehicletracking,\r\n"
			+ "a.vehicletrackingfunctional,a.educationalvehicle,a.changeofvehiclebody,a.place_ins,a.educationalvehicle from irad_vehicle_transport a join irad_vehicle b on\r\n"
			+ "a.accident_id=:accidentId and upper(b.vehicle_reg_no)=:vehicleId and b.accident_id=a.accident_id and a.vehicle_reg_no::integer=b.id limit 1";

	/////// form10
	private final String report10 = "select vehicle_reg_no,chasis_number,engine_nr,vehicle_class,vehicle_make,vehicle_model,vehicle_owner,service_ownername,owneraddr,insurance_details,rc_fit_upto,rc_np_no,"
			+ "rc_np_upto from irad_vehicle where accident_id=:accidentId and id=:vehicleRegNo::integer";
	/////// form7
//	private final String report7 = "select a.id,a.vehicle_type,a.loadcategory as vehicleusetype,b.vehicle_id,a.vehicle_reg_no,a.vehicle_make,a.vehicle_model,a.vehicle_type,a.service_ownername as vehicle_owner,a.insurance_policyno,a.insurance_validity,\r\n"
//			+ "a.insurance_details,a.owneraddr,a.vehicle_type,b.ser_name,b.mobile_no,b.residence,b.license_number,b.ser_registration_authority,b.drunk,b.drivinglicencetype,\r\n"
//			+ "c.driver_license_suspended,c.owner_report_acc,c.vehicle_driven_by,c.driver_mobile_usage,c.driver_imei,c.driver_make_model,c.owner_driver_ran_ownerproduce,c.owner_mact,c.owner_mobile_no,c.driver_father_name,\r\n"
//			+ "c.owner_father_name,TO_CHAR(b.ser_dltransvaldtill::timestamp, ' dd-Mon-yyyy ') as dri_license_validity,b.ser_registration_authority as dri_license_authority,c.victim_type,c.dri_injured_or_not,c.permit_fitness_verified,c.permit_fitness_verified_reasons,c.owner_reportedaccto_insdt,\r\n"
//			+ "c.victim_type,c.driver_remainder_date,c.owner_remainder_date,c.victim_remainder_date,d.permitno,d.permitvalidity,d.fitcertval,e.reg_authority_remainder_date,e.hospital_remainder_date,\r\n"
//			+ "e.under_section,e.nature_acc from irad_vehicle a INNER JOIN irad_driver b on a.accident_id=:accidentId and b.vehicle_id=:vehicleId and a.accused_victim='Accused' and a.accident_id=b.accident_id\r\n"
//			+ "and a.id=b.vehicle_id::integer INNER JOIN dar_vehicle c on a.accident_id=c.acc_id INNER JOIN irad_vehicle_transport d on a.accident_id=d.accident_id INNER JOIN dar_general e on a.accident_id=e.acc_id";

	private final String report7 ="select e.brief_description_accident,a.id,a.loadcategory as vehicleusetype,b.vehicle_id,a.vehicle_reg_no,a.vehicle_make,a.vehicle_model,master.get_vehicletype(a.vehicle_type,'') as vehicle_type,\r\n"
			+ "a.service_ownername as vehicle_owner,a.insurance_policyno,a.insurance_validity,a.insurance_details,a.owneraddr,a.vehicle_type,b.ser_name,b.mobile_no,\r\n"
			+ "b.residence,b.license_number,b.ser_registration_authority,c.driver_alcohol_usage,master.get_drivinglicencetype(b.drivinglicencetype,'')as drivinglicencetype,c.driver_license_suspended,c.owner_report_acc,c.vehicle_driven_by,\r\n"
			+ "c.driver_mobile_usage,c.driver_imei,c.driver_make_model,c.owner_driver_ran_ownerproduce,c.owner_mact,c.owner_mobile_no,c.driver_father_name,\r\n"
			+ "c.owner_father_name,b.ser_dltransvaldtill as dri_license_validity,b.ser_registration_authority as dri_license_authority,\r\n"
			+ "c.victim_type,c.dri_injured_or_not,c.permit_fitness_verified,c.permit_fitness_verified_reasons,c.owner_reportedaccto_insdt,c.owner_veh_type,\r\n"
			+ "c.victim_type,c.driver_remainder_date,c.owner_remainder_date,c.victim_remainder_date,a.rc_np_no as permitno,a.rc_np_upto as permitvalidity,\r\n"
			+ "a.rc_fit_upto as fitcertval,e.reg_authority_remainder_date,e.hospital_remainder_date,e.under_section,e.nature_acc,c.license_verified_reasons,c.license_suspended_details,c.dri_inj_in_acc_details,c.scientific_report_details,c.mact_owner_vehicle_fir,c.permit_fitness_verified_reason,\r\n"
			+ "c.owner_reportedaccto_insdt,c.owner_report_acc,b.age,master.get_occupation(b.occupation,'') as occupation,b.ser_name,c.license_verfied \r\n"
			+ "from irad_vehicle a INNER JOIN irad_driver b on  a.accident_id=:accidentId  and a.accused_victim='Accused' \r\n"
			+ "and a.accident_id=b.accident_id and a.id=b.vehicle_id::integer INNER JOIN dar_vehicle c on a.accident_id=c.acc_id and veh_ref_id=b.vehicle_id\r\n"
			+ "INNER JOIN dar_general e on a.accident_id=e.acc_id";
			
			private final String report7General ="select master.get_severity(severity) as severity from sp_irad_accident where accident_id=:accidentId";
			
			
			String passengerquery7 = "select a.accident_id,a.id as id,a.injury_severity as injurySeverity,a.name as nameOfDeceased,a.age as ageOfDeceased,master.get_occupation(a.occupation,'') as occupationOfDeceased,a.vehicle_id as vehicleId,b.ref_id as refId,\r\n"
					+ "b.name as legalRepName,b.age as legalRepAge,master.get_familymembers(b.relation_type,'en') as legalRepRelation from irad_passenger a inner join dar_family_details b on a.accident_id=:accidentId  \r\n"
					+ "and a.vehicle_id=:vehicleId and a.id=:refId::integer and b.acc_id=a.accident_id and a.id=b.ref_id::integer";

			String pedestrianquery7 = "select a.accident_id,a.id as id,a.injury_severity as injurySeverity,a.name as nameOfDeceased,a.age as ageOfDeceased,master.get_occupation(a.occupation,'') as occupationOfDeceased,a.vehicle_id as vehicleId,"
					+ "b.ref_id as refId,b.name as legalRepName,b.age as legalRepAge,master.get_familymembers(b.relation_type,'en') as legalRepRelation from irad_pedestrian a inner join dar_family_details b on a.accident_id=:accidentId\r\n"
					+ "and a.vehicle_id=:vehicleId and a.id=:refId::integer and b.acc_id=a.accident_id and a.id=b.ref_id::integer";

			String passengerquery1 = "select a.accident_id,a.id as id,a.injury_severity as injurySeverity,a.name as nameOfInjured,a.age as ageOfInjured,master.get_occupation(a.occupation,'') as occupationOfInjured,a.vehicle_id as vehicleId,\r\n"
					+ "b.ref_id as refId,b.name as legalRepName,b.age as legalRepAgemaster.get_familymembers(b.relation_type,'en') as legalRepRelation from irad_passenger a inner join dar_family_details b on a.accident_id=:accidentId\r\n"
					+ "and a.vehicle_id=:vehicleId and a.id=:refId::integer and b.acc_id=a.accident_id and a.id=b.ref_id::integer";
			String driverquery1 = "select a.accident_id,a.id as id,a.ser_name as nameOfInjured,a.age as ageOfInjured,a.occupation as occupationOfInjure,a.injury_severity as natureofinjury,a.injurytype,a.vehicle_id as vehicleId,b.ref_id as refId,\\r\\n\"\r\n"
					+ "	b.name as legalRepName,b.age as legalRepAge,master.get_familymembers(b.relation_type,'en') as legalRepRelation from irad_driver a inner join dar_family_details b on a.accident_id=:accidentId and  a.injury_severity IN ('4', '2', '3') \\r\\n\"\r\n"
					+ "	and a.vehicle_id=:vehicleId and a.id=:refId and b.acc_id=a.accident_id and b.ref_id=:refId";
			String pedestrianquery1 = "select a.accident_id,a.id as id,a.name as nameOfInjured,a.age as ageOfInjured,a.occupation as occupationOfInjure,a.ped_natureofinjury as injurySeverity,a.ped_injurytype,a.vehicle_id as vehicleId,b.ref_id as refId,\\r\\n\"\r\n"
					+ "b.name as legalRepName,b.age as legalRepAge,master.get_familymembers(b.relation_type,'en') as legalRepRelation from irad_pedestrian a inner join dar_family_details b on a.accident_id=:accidentId and  a.injury_severity IN ('4', '2', '3') \\r\\n\"\r\n"
					+ "and a.vehicle_id=:vehicleId and a.id=:refId and b.acc_id=a.accident_id and b.ref_id=:refId";

			String driverquery = "select a.id,a.injury_severity,a.age,master.get_occupation(a.occupation,'') as occupation,a.ser_name,a.vehicle_id,b.ref_id,b.name,b.age,master.get_familymembers(b.relation_type,'en') as relation_type from irad_driver a inner join dar_family_details b \r\n"
					+ "on a.accident_id=:accidentId and a.vehicle_id=:vehicleId and a.id=:refId::integer and b.acc_id=a.accident_id and b.ref_id =a.vehicle_id";

			private final String passengerSeverity7 = "select injury_severity from irad_passenger where accident_id=:accidentId and vehicle_id=:vehicleId";
			private final String pedestrianSeverity7 = "select injury_severity from irad_pedestrian where accident_id=:accidentId and vehicle_id=:vehicleId";
			private final String driverSeverity7 = "select injury_severity from irad_driver where accident_id=:accidentId and vehicle_id=:vehicleId";
			
			private final String reminder3 = "select * from court.reminder where accident_id=:accidentId and formno='3' and person_id='75199'";			
			private final String reminder4 = "select * from court.reminder where accident_id=:accidentId and formno='4' and person_id='75199'";			
			private final String reminder6 = "select * from court.reminder where accident_id=:accidentId and formno='6' and person_id='75199'";

	//////// FORM 6
			private final String generalDetails = "SELECT e.section,a.dri_license_validity,a.owner_mobile_no,a.dri_license_authority,a.driver_father_name,a.driver_father_name,a.owner_father_name,\r\n"
					+ "b.vehicle_reg_no,b.vehicle_make,b.vehicle_model,b.owneraddr,b.service_ownername,b.insurance_details,b.insurance_policyno,b.insurance_validity,\r\n"
					+ "b.vehicle_owner,b.rc_fit_upto,b.rc_np_no,b.rc_np_upto ,d.accident_id,d.ser_name as drivername,d.ser_permadd1,ser_permadd1,d.ser_permadd2,d.ser_permadd3,d.ser_mobileno as sermobile,\r\n"
					+ "d.residence,d.license_number,d.drivinglicencetype,d.mobile_no,TO_CHAR(accident_date_time::timestamp,' dd-Mon-yyyy : HH:MI AM') as datetime,\r\n"
					+ "c.brief_description_accident FROM dar_vehicle a INNER JOIN irad_vehicle b on a.acc_id=:accidentId and b.accused_victim='Accused' and a.acc_id=b.accident_id \r\n"
					+ "and a.veh_ref_id::integer=b.id inner join irad_driver d on a.acc_id=d.accident_id and a.veh_ref_id=d.vehicle_id inner join sp_irad_accident e \r\n"
					+ "on a.acc_id=e.accident_id inner join dar_general c on a.acc_id=c.acc_id";
			//////////------- passenger ---------- ///////////////
			
			private final String passengerQuery = "select a.relief_amount,a.date_of_death as dateOfDeath,b.name as name,a.marital_status as status,master.get_occupation(b.occupation,'') as occupation,a.employed_or_not as employeed,\r\n"
					+ "a.name_add_employer as nameadd,a.income as income,a.assessed_to_income_tax as incometax,a.cashless_treatment,a.sole_earning_member as soleearning,a.reimpursement_addional_details,\r\n"
					+ "a.treatment_details_of_deceased as treatment,a.medical_expenses_incurred as medicalexpenses,a.father_name as fathername, b.gender as gender,b.age as age,a.reimbursement_medical_expense as reimbursement\r\n"
					+ "from dar_passenger a inner join irad_passenger b on a.acc_id=:accidentId and a.acc_id=b.accident_id and a.passenger_ref_id=:refId and \r\n"
					+ "a.passenger_ref_id::integer=b.id";
			
			private final String passengerSeverity = "select injury_severity from irad_passenger where accident_id=:accidentId and id=:refId::integer";
			
			private final String passengerFamily = "select id,ref_id,user_type,name,age,gender,master.get_familymembers(relation_type,'en') as legalRepRelation,marital_status,address,contact_number,acc_id from dar_family_details where acc_id=:accidentId and ref_id=:refId and user_type='Passenger'";
			
			private final String passengerChildDetails = "select * from  dar_minor_children_of_victim where acc_id=:accidentId and whose_child=:refId and user_type='Passenger'";
			
			private final String  form6Passenger ="select documents.get_required_documentsvictims(accident_id,'6','attachment','Passenger',id::text,documents.severity(injury_severity)) as attachment from irad_passenger where accident_id=:accidentId";
			
			private final String  form6Pedestrian ="select documents.get_required_documentsvictims(accident_id,'6','attachment','Pedestrian',id::text,documents.severity(injury_severity)) as attachment from irad_pedestrian where accident_id=:accidentId";
			
			private final String  form6Driver ="select documents.get_required_documentsvictims(accident_id,'6','attachment','Driver',id::text,documents.severity(injury_severity)) as attachment from irad_driver where \r\n"
					+ "accident_id=:accidentId and vehicle_id in(select id::text from irad_vehicle where accident_id=:accidentId and accused_victim='Victim')";
			
			
			
			private final String passInjQuery1 = "select a.relief_amount,b.name as name,b.residence,b.mobile,b.gender as gender,b.age as age,a.marital_status as status,master.get_occupation(b.occupation,'') as occupation,\r\n"
			+ "a.employed_or_not as employeed,a.name_add_employer as nameadd,a.income as income,a.assessed_to_income_tax as incometax,a.reimbursement_medical_expense as reimbursement,\r\n"
			+ "a.father_name as fathername,a.natureofinjury_description,a.hospital_treatment_details,a.hospital_address,a.hospital_treatment_period,a.reimpursement_addional_details,\r\n"
			+ "a.doctor_name,a.hospital_treatment_surgery_details,a.permanent_disability,a.permanent_disability_details,a.expendiure_on_treatment,a.lossincome,a.lossearcapacity,\r\n"
			+ "a.estimate_expenditure,a.expenditure_conveyance,a.pecunairy_loss,a.value_of_loss,a.loss_to_property,a.additional_info,a.compensation_claimed\r\n"
			+ "from dar_passenger a inner join irad_passenger b on a.acc_id=:accidentId and a.acc_id=b.accident_id and\r\n"
			+ "a.passenger_ref_id=:refId and a.passenger_ref_id::integer=b.id";

			/////// -------- pedestrian -------////////
			private final String pedestrianSeverity = "select injury_severity,* from irad_pedestrian where accident_id=:accidentId and vehicle_id=:vehicleId and id=:refId::integer";

			

			private final String pedestrianQuery = "select a.relief_amount,a.date_of_death as dateOfDeath,b.name as name,a.marital_status as status,master.get_occupation(b.occupation,'') as occupation,a.employed_or_not as employeed,\r\n"
					+ "a.name_add_employer as nameadd,a.income as income,a.assessed_to_income_tax as incometax,a.cashless_treatment,a.treatment_details_of_deceased as treatment,a.reimpursement_addional_details,\r\n"
					+ "a.sole_earning_member as soleearning,a.medical_expenses_incurred as medicalexpenses,a.father_name as fathername,b.gender as gender,b.age as age,a.reimbursement_medical_expense as reimbursement\r\n"
					+ "from dar_pedestrian a inner join irad_pedestrian b on a.acc_id=:accidentId and a.acc_id=b.accident_id and a.pedestrian_ref_id=:refId and \r\n"
					+ "a.pedestrian_ref_id::integer=b.id";

			private final String pedestrianFamily = "select id,ref_id,user_type,name,age,gender,master.get_familymembers(relation_type,'en') as legalRepRelation,marital_status,address,contact_number,acc_id from dar_family_details where acc_id=:accidentId and ref_id=:refId and user_type='Pedestrian'";

			private final String pedestrianChildDetails = "select * from  dar_minor_children_of_victim where acc_id=:accidentId and whose_child=:refId and user_type='Pedestrian'";

			private final String pedestrianInjQuery = "select a.relief_amount,b.name as name,b.residence,b.mobile,b.gender as gender,b.age as age,a.marital_status as status,master.get_occupation(b.occupation,'') as occupation,\r\n"
					+ "a.employed_or_not as employeed,a.name_add_employer as nameadd,a.income as income,a.assessed_to_income_tax as incometax,a.reimbursement_medical_expense as reimbursement,\r\n"
					+ "a.father_name as fathername,a.natureofinjury_description,a.hospital_treatment_details,a.hospital_details,a.hospital_treatment_period,\r\n"
					+ "a.doctor_name,a.hospital_treatment_surgery_details,a.permanent_disability,a.permanent_disability_details,a.expendiure_on_treatment,a.reimpursement_addional_details,\r\n"
					+ "a.estimate_expenditure,a.expenditure_conveyance,a.pecunairy_loss,a.value_of_loss,a.loss_to_property,a.additional_info,a.compensation_claimed,a.lossincome,a.lossearcapacity\r\n"
					+ "from dar_pedestrian a inner join irad_pedestrian b on a.acc_id=:accidentId and a.acc_id=b.accident_id and a.pedestrian_ref_id=:refId \r\n"
					+ "and a.pedestrian_ref_id::integer=b.id";



			

			////////// ------- driver ---------- ///////////////

			private final String driverQuery = "select a.relief_amount,a.driver_date_of_death as dateOfDeath,b.ser_name as name,a.dri_marital_status as status,master.get_occupation(b.occupation,'') as occupation,a.dri_employed_or_not as employeed,\r\n"
					+ "a.dri_name_add_employer as nameadd,a.driver_income as income,a.dri_assessed_to_income_tax as incometax,a.dri_cashless_treatment as cashless_treatment,a.treatment_details_of_deceased as treatment,\r\n"
					+ "a.sole_earning_member as soleearning,a.dri_medical_expenses_incurred as medicalexpenses,a.driver_father_name as fathername,b.ser_gender as gender,a.reimpursement_addional_details,b.age as age \r\n"
					+ "from dar_vehicle a inner join irad_driver b on a.acc_id=:accidentId and a.acc_id=b.accident_id and a.veh_ref_id=:vehicleId and a.veh_ref_id=b.vehicle_id";

			private final String driverFamily = "select id,ref_id,user_type,name,age,gender,master.get_familymembers(relation_type,'en') as legalRepRelation,marital_status,address,contact_number,acc_id from dar_family_details where acc_id=:accidentId and ref_id=:refId and user_type='Driver'";

			private final String driverSeverity = "select * from irad_driver where accident_id=:accidentId and id=:refId::integer";

			private final String driverchildDetails = "select * from  dar_minor_children_of_victim where acc_id=:accidentId and whose_child=:refId and user_type='Driver'";

			private final String driverInjQuery = "select a.relief_amount,b.ser_name as name,b.residence,b.mobile_no as mobile,b.ser_gender as gender,b.age as age,a.dri_marital_status as status,master.get_occupation(b.occupation,'') as occupation,\r\n"
					+ "a.dri_employed_or_not as employeed,a.dri_name_add_employer as nameadd,a.driver_income as income,a.dri_assessed_to_income_tax as incometax,a.reimpursement_addional_details,\r\n"
					+ "a.dri_reimbursement_medical_expense as reimbursement,a.driver_father_name as fathername,a.nature_description_injury as natureofinjury_description,\r\n"
					+ "a.treatment_details_of_deceased as hospital_treatment_details,a.hospital_details as hospital_details,a.period_hospitlization as hospital_treatment_period,\r\n"
					+ "a.doctor_name,a.hospital_treatment_surgery_details,a.permanent_disability,a.permanent_disability_details,a.expendiure_on_treatment,a.estimate_expenditure,\r\n"
					+ "a.expenditure_conveyance,a.pecunairy_loss,a.value_of_loss,a.loss_to_property,a.additional_info,a.compensation_claimed,a.lossincome,a.lossearcapacity\r\n"
					+ "from dar_vehicle a inner join irad_driver b on a.acc_id=:accidentId and a.acc_id=b.accident_id and a.veh_ref_id=:vehicleId and a.veh_ref_id=b.vehicle_id";


////////FORM 11

	private final String generalDetails11 = "select landmarks,TO_CHAR(s.firdatetime::timestamp, ' dd-Mon-yyyy : HH:MI AM') as fir_time,TO_CHAR(s.accident_date_time::timestamp, ' dd-Mon-yyyy : HH:MI AM') as acctime,nature_of_policy,TO_CHAR(s.firdatetime::timestamp, ' dd-Mon-yyyy : HH:MI AM') as firdatetime,s.act,master.get_statename(state) as statename,master.get_districtname(s.state, s.district)as districtname,s.fir_number,TO_CHAR(reporting_datetime::timestamp, ' dd-Mon-yyyy : HH:MI AM') as reporting_datetime,s.act,ins.accident_id,s.section,\r\n"
			+ "get_ps_name(state,district,station)as psname,ins.vehicle_id,master.get_veh_no(ins.vehicle_id::integer),ins.vehicle_make,ins.vehicle_model,ins.name,\r\n"
			+ "ins.residence,ins.insurance_policyno,TO_CHAR(ins.insurance_validity::timestamp, ' dd-Mon-yyyy') as insurance_validity,ins.nature_of_policy,TO_CHAR(ins.intimation_received_date_time_insured::timestamp, ' dd-Mon-yyyy : HH:MI AM') as intimation_received_date_time_insured,TO_CHAR(ins.date_of_receipt_far::timestamp, ' dd-Mon-yyyy : HH:MI AM') as date_of_receipt_far,\r\n"
			+ "TO_CHAR(ins.date_of_receipt_iar::timestamp, ' dd-Mon-yyyy : HH:MI AM') as date_of_receipt_iar,TO_CHAR(ins.date_of_receipt_dar::timestamp, ' dd-Mon-yyyy : HH:MI AM') as date_of_receipt_dar,TO_CHAR(ins.dateof_appt_designated_officer_by_ins::timestamp, ' dd-Mon-yyyy : HH:MI AM') as dateof_appt_designated_officer_by_ins,ins.designated_officer_name,ins.designated_officer_residence,\r\n"
			+ "TO_CHAR(ins.surveyor_appointment_date::timestamp, ' dd-Mon-yyyy : HH:MI AM') as surveyor_appointment_date,ins.surveyor_investigator_name,ins.surveyor_investigator_residence,TO_CHAR(ins.dateof_surveyor_investigator_report::timestamp, ' dd-Mon-yyyy : HH:MI AM') as dateof_surveyor_investigator_report,\r\n"
			+ "TO_CHAR(ins.dateof_designated_officer_report::timestamp, ' dd-Mon-yyyy : HH:MI AM') as dateof_designated_officer_report,ins.form_filled_within_30,ins.if_ins_company_not_liability,ins.insurance_details \r\n"
			+ "from sp_irad_accident s,dar_insurance ins where s.accident_id=:accidentId and ins.accident_id=s.accident_id and ins.vehicle_id=:vehicleId";

	private final String report11form1 = "SELECT TO_CHAR(submitedon::timestamp, ' dd-Mon-yyyy : HH:MI AM') as submitedon FROM public.edar_formsubmition where accident_id=:accidentId and formno='1'";

	private final String report11form5 = "SELECT TO_CHAR(submitedon::timestamp, ' dd-Mon-yyyy : HH:MI AM') as submitedon FROM public.edar_formsubmition where accident_id=:accidentId and formno='5'";

	private final String report11form7 = "SELECT TO_CHAR(submitedon::timestamp, ' dd-Mon-yyyy : HH:MI AM') as submitedon FROM public.edar_formsubmition where accident_id=:accidentId and formno='7'";

	// private final String report11form4 = "SELECT TO_CHAR(submitedon::timestamp, '
	// dd-Mon-yyyy : HH:MI AM') as submitedon FROM public.edar_formsubmition where
	// accident_id=:accidentId and formno='4'";

//passenger

	private final String passengerSeverity11 = "select injury_severity from irad_passenger where accident_id=:accidentId and vehicle_id=:vehicleId and id=:personId::integer";

	private final String report11PassDeceased = "select pass.name as name,pass.age as age,master.get_occupation(occupation,'') as occupation,master.get_severity(pass.injury_severity) as severity,\r\n"
			+ "death.death_income,death.death_future_prospects,death.death_less_personal_expenses,death.death_monthly_loss_depedency,death.death_anual_loss_depedency,\r\n"
			+ "death.death_mulltiplier,death.death_total_loss_dependency, death.death_medical_expenses,death.death_loss_consortium,death.death_loss_for_love_affection,\r\n"
			+ "death.death_loss_estate,death.death_loss_funeral_expenses,death.death_total_compensation,pass.id,pass.injury_severity,pass.residence as address,death.id,\r\n"
			+ "death.id_insurance,death.vehicle_id,death.accident_id,death.person_id,death.person_type,death.inj_permenant_disablity from irad_passenger pass,\r\n"
			+ "dar_insurance_death death where pass.accident_id=:accidentId and pass.vehicle_id=:vehicleId and pass.id=:personId::integer and pass.injury_severity='1'\r\n"
			+ "and death.accident_id=pass.accident_id and death.person_id::text=pass.id::text and death.person_type='Passenger'";

	private final String report11PassInjured = "select inj.inj_treatment,pass.name as name,pass.age,master.get_occupation(occupation,'') as occupation,inj.inj_income,master.get_severity(pass.injury_severity) as severity,\r\n"
			+ "master.get_injury_type(pass.pass_injurytype,''),inj.inj_medical_treatment,inj.inj_permenant_disablity,inj.inj_convenance,inj.inj_special_diet,\r\n"
			+ "inj.inj_cost_nursing_attendant,inj.inj_cost_artificial_limp,inj.inj_loss_erning_capacity,inj.inj_loss_income,inj.inj_any_other_loss,inj.inj_com_mental_phy_shock,\r\n"
			+ "inj.inj_pain_suffering,inj.inj_loss_amenities,inj.inj_disfiguration,inj.inj_loss_of_marriage,inj.inj_loss_ear_inc_har_dis,inj.inj_total_copensation,pass.injury_severity\r\n"
			+ "from irad_passenger pass,dar_insurance_injured inj where pass.accident_id=:accidentId and pass.vehicle_id=:vehicleId and pass.id=:personId::integer and \r\n"
			+ "pass.injury_severity in('2','3','4') and inj.accident_id=pass.accident_id  and inj.person_id::text=pass.id::text and inj.person_type='Passenger'\r\n"
			+ "";

//pedestrian
	private final String pedestrianSeverity11 = "select injury_severity from irad_pedestrian where accident_id=:accidentId and vehicle_id=:vehicleId and id=:personId::integer";

	private final String report11PedDeceased = "select ped.name as name,master.get_severity(ped.injury_severity) as severity,ped.injury_severity,ped.residence as address,death.id, death.id_insurance,\r\n"
			+ "death.vehicle_id, death.accident_id, death.person_id, death.person_type,death.death_income, death.death_future_prospects, death.death_less_personal_expenses,\r\n"
			+ "death.death_monthly_loss_depedency, death.death_anual_loss_depedency, death.death_mulltiplier,death.death_total_loss_dependency, death.death_medical_expenses,\r\n"
			+ "death.death_loss_consortium,death.death_loss_for_love_affection, death.death_loss_estate, death.death_loss_funeral_expenses,death.death_total_compensation,\r\n"
			+ "death.inj_permenant_disablity,master.get_occupation(ped.occupation,'') as occupation,ped.age as age from irad_pedestrian ped,dar_insurance_death death where ped.accident_id=:accidentId and ped.vehicle_id=:vehicleId\r\n"
			+ "and ped.id=:personId::integer and ped.injury_severity='1' and death.accident_id=ped.accident_id and death.person_id::text=ped.id::text\r\n"
			+ "and death.person_type='Pedestrian'";

	private final String report11PedInjured = "select inj.inj_treatment,ped.name as name,ped.age as age,master.get_occupation(occupation,'') as occupation,inj.inj_income,master.get_severity(ped.injury_severity) as severity,\r\n"
			+ "master.get_injury_type(ped.ped_injurytype,''),inj.inj_medical_treatment,inj.inj_permenant_disablity,inj.inj_treatment,inj.inj_convenance,inj.inj_special_diet,\r\n"
			+ "inj.inj_cost_nursing_attendant,inj.inj_cost_artificial_limp,inj.inj_loss_erning_capacity,inj.inj_loss_income,inj.inj_any_other_loss,inj.inj_com_mental_phy_shock,\r\n"
			+ "inj.inj_pain_suffering,inj.inj_loss_amenities,inj.inj_disfiguration,inj.inj_loss_of_marriage,inj.inj_loss_ear_inc_har_dis,inj.inj_total_copensation,ped.injury_severity,inj.inj_income,inj.inj_natureofinjury\r\n"
			+ "from irad_pedestrian ped,dar_insurance_injured inj where ped.accident_id=:accidentId and ped.vehicle_id=:vehicleId and ped.id=:personId::integer and \r\n"
			+ "ped.injury_severity in('2','3','4') and inj.accident_id=ped.accident_id and inj.person_id::text=ped.id::text and inj.person_type='Pedestrian'";
//driver

	private final String driverSeverity11 = "select injury_severity from irad_driver where accident_id=:accidentId and vehicle_id=:vehicleId and id=:personId::integer";

	private final String report11driverDeceased = "select driver.id,driver.ser_name as name,driver.age as age,master.get_occupation(occupation,'') as occupation,master.get_severity(driver.injury_severity) as severity,\r\n"
			+ "driver.injury_severity,death.id,death.id_insurance, death.vehicle_id, death.accident_id, death.person_id, death.person_type,death.death_income,\r\n"
			+ "death.death_future_prospects, death.death_less_personal_expenses,death.death_monthly_loss_depedency, death.death_anual_loss_depedency,death.death_mulltiplier,\r\n"
			+ "death.death_total_loss_dependency,death.death_medical_expenses, death.death_loss_consortium,death.death_loss_for_love_affection,death.death_loss_estate,\r\n"
			+ "death.death_loss_funeral_expenses,death.death_total_compensation, death.inj_permenant_disablity from irad_driver driver,dar_insurance_death death\r\n"
			+ "where driver.accident_id=:accidentId and driver.vehicle_id=:vehicleId and driver.id=:personId::integer and driver.injury_severity='1' and death.accident_id=driver.accident_id\r\n"
			+ "and death.person_id::text=driver.id::text and death.vehicle_id=driver.vehicle_id and death.person_type='Driver'";

	private final String report11driverInjured = "select inj.inj_treatment,driver.ser_name as name,driver.age,master.get_occupation(occupation,'') as occupation,inj.inj_income,master.get_severity(driver.injury_severity) as severity,\r\n"
			+ "master.get_injury_type(driver.injurytype,'en'),inj.inj_medical_treatment,inj.inj_permenant_disablity,inj.inj_treatment,inj.inj_convenance,inj.inj_special_diet,\r\n"
			+ "inj.inj_cost_nursing_attendant,inj.inj_cost_artificial_limp,inj.inj_loss_erning_capacity,inj.inj_loss_income,inj.inj_any_other_loss,inj.inj_com_mental_phy_shock,\r\n"
			+ "inj.inj_pain_suffering,inj.inj_loss_amenities,inj.inj_disfiguration,inj.inj_loss_of_marriage,inj.inj_loss_ear_inc_har_dis,inj.inj_total_copensation\r\n"
			+ "from irad_driver driver,dar_insurance_injured inj where driver.accident_id=:accidentId and driver.vehicle_id=:vehicleId and driver.id=:personId::integer and \r\n"
			+ "driver.injury_severity in('2','3','4')and inj.accident_id=driver.accident_id and inj.person_id::text=driver.id::text and inj.vehicle_id=driver.vehicle_id\r\n"
			+ "and inj.person_type='Driver'";

	private final String report11LegalRep = "select ref_id as refId,name as legalRepName,age as legalRepAge,master.get_familymembers(relation_type,'en') as legalRepRelation from dar_family_details where acc_id=:accidentId and ref_id=:vehicleId ";

	//////// FORM 12

	private final String report12General = "SELECT slsa.property_loss_damage,slsa.loss_suffered,slsa.physical_harm,slsa.emotional_harm,slsa.damage_lose,slsa.any_damage_lose,s.fir_number,s.act,s.section,TO_CHAR(reporting_datetime::timestamp, ' dd-Mon-yyyy : HH:MI AM') as reporting_datetime,s.accident_id,\r\n"
			+ "get_ps_name(state,district,station)as psname,slsa.nature_of_injuries,slsa.brief_description_of_offense,slsa.name,slsa.father_spouse_name,\r\n"
			+ "slsa.age,slsa.gender,slsa.marital_status,slsa.present_address,slsa.permenant_address,slsa.conatc_emailid,slsa.conatc_mobileno\r\n"
			+ "FROM dar_slsa slsa,sp_irad_accident s where slsa.accident_id=:accidentId and slsa.accident_id=s.accident_id";

	private final String deceasedLegalRespresentatives12 = "select name,age,gender,relation from dar_family_details where acc_id=:accidentId and ref_id=:personId";

	private final String report12Accussed = "select master.get_conductofaccused_behaviour(acc_irresponsible_behaviour,'en') as acc_irresponsible_behaviour1,master.get_conductofaccused_aggressive(acc_aggressive_driving,'en') as acc_aggressive_driving1,master.get_conductofaccused_apparent_cir(acc_apaent_contributing_cir,'en') as acc_apaent_contributing_cir1, * FROM public.dar_slsa_accused where accident_id=:accidentId and victim_id=:personId";
//passenger
	private final String passengerSeverity12 = "select injury_severity from irad_passenger where accident_id=:accidentId and id=:personId::integer and vehicle_id=:vehicleId";

	private final String report12PassDeceased = "SELECT dt.death_total_compensation,darpass.loss_suufer_value_vehilce,dt.paying_cap_anual_income,dt.paying_cap_moveable_asset,dt.paying_cap_immovable_assets,dt.slsa_recommendation,darpass.property_description,darpass.emailid,pass.residence,darpass.marital_status,darpass.income,darpass.father_name,pass.name as name,pass.mobile,pass.age,pass.gender,master.get_occupation(pass.occupation,'') as occupation,dt.death_income,dt.death_future_prospects,\r\n"
			+ "dt.death_less_personal_expenses,dt.death_monthly_loss_depedency,dt.death_anual_loss_depedency,dt.death_mulltiplier,\r\n"
			+ "dt.death_total_loss_dependency,dt.death_medical_expenses,dt.death_loss_funeral_expenses,dt.death_any_other_pecuniary,\r\n"
			+ "dt.death_loss_consortium,dt.death_loss_for_love_affection,dt.death_loss_estate,dt.death_emotional_harm_etc,\r\n"
			+ "dt.death_post_traumatic_stress_disorder,dt.death_any_other_nonpecuniary FROM dar_slsa_death dt,irad_passenger pass,dar_passenger darpass where\r\n"
			+ "dt.accident_id=:accidentId and dt.vehicle_id=:vehicleId and dt.person_type='Passenger' and dt.person_id=:personId \r\n"
			+ "and dt.person_id::integer=pass.id and dt.vehicle_id=pass.vehicle_id and darpass.acc_id=pass.accident_id and darpass.veh_no=pass.vehicle_id and darpass.passenger_ref_id::integer=pass.id  and dt.accident_id=pass.accident_id ";

	private final String report12PassInjured = "Select inj.inj_total_copensation,inj.paying_cap_anual_income,inj.paying_cap_moveable_asset,inj.paying_cap_immovable_assets,inj.slsa_recommendation,darpass.loss_suufer_value_vehilce,darpass.property_description,darpass.hospital_treatment_surgery_details,inj.inj_peroid_of_hospital,darpass.emailid,pass.residence,darpass.marital_status,darpass.income,darpass.father_name,inj.inj_permenant_disablity,inj.inj_medical_treatment_taken_by_injured,inj.inj_name_of_hospital,inj.inj_peroid_of_hospital,inj.inj_got_reimpuresement, master.get_severity(injury_severity,'')as severity,pass.mobile,pass.name as name,pass.age,pass.gender,master.get_occupation(pass.occupation,'') as occupation,\r\n"
			+ "inj.inj_treatment,inj.inj_convenance,inj.multiplier,inj.inj_special_diet,inj.inj_cost_nursing_attendant,inj.inj_loss_income,inj.inj_any_other_loss_req_special_treatment,\r\n"
			+ "inj.inj_percentage_disablity,inj.inj_loss_erning_capacity,inj.inj_any_other_pecuniary_loss,inj.inj_pain_suffering,inj.inj_loss_amenities,\r\n"
			+ "inj.inj_post_traumatic,inj.inj_com_mental_phy_shock,inj.inj_disfiguration,inj.inj_loss_marriage_prospects,inj.inj_loss_reputation,\r\n"
			+ "inj.inj_anyother_non_pecuniary FROM dar_slsa_injured inj,irad_passenger pass,dar_passenger darpass where inj.accident_id=:accidentId \r\n"
			+ "and inj.vehicle_id=:vehicleId and inj.person_id=:personId and pass.accident_id=inj.accident_id and pass.id=inj.person_id::integer and darpass.acc_id=pass.accident_id and darpass.veh_no=pass.vehicle_id and darpass.passenger_ref_id::integer=pass.id \r\n"
			+ "and pass.vehicle_id=inj.vehicle_id";

//pedestrian
	private final String pedestrianSeverity12 = "select injury_severity from irad_pedestrian where accident_id=:accidentId and id=:personId::integer and vehicle_id=:vehicleId ";

	private final String report12PedDeceased = "SELECT dt.death_total_compensation,darped.loss_suufer_value_vehilce,dt.paying_cap_anual_income,dt.paying_cap_moveable_asset,dt.paying_cap_immovable_assets,dt.slsa_recommendation,darped.property_description,darped.emailid,darped.marital_status,darped.income,darped.father_name,master.get_severity(injury_severity,'')as severity, \r\n"
			+ "ped.name as name,ped.mobile,ped.residence,ped.age,ped.gender,master.get_occupation(occupation,'') as occupation,\r\n"
			+ "dt.death_income,dt.death_future_prospects,\r\n"
			+ "dt.death_less_personal_expenses,dt.death_monthly_loss_depedency,dt.death_anual_loss_depedency,dt.death_mulltiplier,\r\n"
			+ "dt.death_total_loss_dependency,dt.death_medical_expenses,dt.death_loss_funeral_expenses,dt.death_any_other_pecuniary,\r\n"
			+ "dt.death_loss_consortium,dt.death_loss_for_love_affection,dt.death_loss_estate,dt.death_emotional_harm_etc,\r\n"
			+ "dt.death_post_traumatic_stress_disorder,dt.death_any_other_nonpecuniary FROM  dar_slsa_death dt,irad_pedestrian ped,dar_pedestrian darped\r\n"
			+ "where dt.accident_id=:accidentId and dt.vehicle_id=:vehicleId and dt.person_id=:personId and dt.person_type='Pedestrian' and dt.person_id::integer=ped.id \r\n"
			+ "and dt.vehicle_id=ped.vehicle_id and dt.accident_id=ped.accident_id and darped.acc_id=ped.accident_id and darped.veh_no=ped.vehicle_id and darped.pedestrian_ref_id::integer=ped.id \r\n";

	private final String report12PedInjured = "Select inj.inj_total_copensation,darped.loss_suufer_value_vehilce,inj.paying_cap_anual_income,inj.paying_cap_moveable_asset,inj.paying_cap_immovable_assets,inj.slsa_recommendation,darped.property_description,darped.hospital_treatment_surgery_details,inj.inj_peroid_of_hospital,darped.emailid,darped.marital_status,darped.income,darped.father_name,master.get_severity(injury_severity,'')as severity, \r\n"
			+ "ped.name as name,ped.mobile,ped.residence,ped.age,ped.gender,master.get_occupation(occupation,'') as occupation,inj.inj_medical_treatment_taken_by_injured,inj.inj_name_of_hospital,inj.inj_peroid_of_hospital,inj.inj_got_reimpuresement,inj.inj_permenant_disablity,\r\n"
			+ "inj.inj_treatment,inj.multiplier,inj.inj_convenance,inj.inj_special_diet,inj.inj_cost_nursing_attendant,inj.inj_loss_income,inj.inj_any_other_loss_req_special_treatment,\r\n"
			+ "inj.inj_percentage_disablity,inj.inj_loss_erning_capacity,inj.inj_any_other_pecuniary_loss,inj.inj_pain_suffering,inj.inj_loss_amenities,\r\n"
			+ "inj.inj_post_traumatic,inj.inj_com_mental_phy_shock,inj.inj_disfiguration,inj.inj_loss_marriage_prospects,inj.inj_loss_reputation,\r\n"
			+ "inj.inj_anyother_non_pecuniary FROM  dar_slsa_injured inj,irad_pedestrian ped,dar_pedestrian darped\r\n"
			+ "where inj.accident_id=:accidentId and inj.vehicle_id=:vehicleId and inj.person_id=:personId\r\n"
			+ "and inj.person_type='Pedestrian' and inj.person_id::integer=ped.id and inj.vehicle_id=ped.vehicle_id \r\n"
			+ "and inj.accident_id=ped.accident_id and darped.acc_id=ped.accident_id and darped.veh_no=ped.vehicle_id and darped.pedestrian_ref_id::integer=ped.id ";

//driver
	private final String driverSeverity12 = "select injury_severity from irad_driver where accident_id=:accidentId and id=:personId::integer and vehicle_id=:vehicleId ";

	private final String report12driDeceased = "SELECT death_total_compensation,v.loss_suufer_value_vehilce,dt.paying_cap_anual_income,dt.paying_cap_moveable_asset,dt.paying_cap_immovable_assets,dt.slsa_recommendation,v.property_description,v.emailid,v.driver_martialstatus,v.driver_father_name,driver.ser_gender,driver.mobile_no,driver.ser_permadd1,driver.ser_permadd2,\r\n"
			+ "driver.ser_permadd3,driver.ser_name as name,driver.age,driver.ser_gender,master.get_occupation(occupation,'') as occupation,\r\n"
			+ "dt.death_income,dt.death_future_prospects,dt.death_less_personal_expenses,dt.death_monthly_loss_depedency,dt.death_anual_loss_depedency,dt.death_mulltiplier,\r\n"
			+ "dt.death_total_loss_dependency,dt.death_medical_expenses,dt.death_loss_funeral_expenses,dt.death_any_other_pecuniary,dt.death_loss_consortium,\r\n"
			+ "dt.death_loss_for_love_affection,dt.death_loss_estate,dt.death_emotional_harm_etc,dt.death_post_traumatic_stress_disorder,dt.death_any_other_nonpecuniary\r\n"
			+ "FROM dar_slsa_death dt,irad_driver driver,dar_vehicle v where dt.accident_id=:accidentId and dt.vehicle_id=:vehicleId and dt.person_type='Driver'and dt.person_id=:personId and dt.person_id::integer=driver.id  and dt.vehicle_id=driver.vehicle_id\r\n"
			+ "and dt.accident_id=driver.accident_id and driver.vehicle_id=v.veh_ref_id and driver.accident_id=v.acc_id ";

	private final String report12driInjured = "select inj.inj_total_copensation,inj.paying_cap_anual_income,inj.paying_cap_moveable_asset,inj.paying_cap_immovable_assets,inj.slsa_recommendation,v.loss_suufer_value_vehilce,v.property_description,v.hospital_treatment_surgery_details,inj.inj_peroid_of_hospital,v.emailid,v.driver_martialstatus,v.driver_father_name,driver.ser_gender,driver.mobile_no,driver.ser_permadd1,\r\n"
			+ "driver.ser_permadd2, driver.ser_gender,driver.mobile_no,driver.ser_permadd1,\r\n"
			+ "driver.ser_permadd3,driver.ser_name as name,driver.age,driver.ser_gender,master.get_occupation(occupation,'') as occupation,master.get_severity(injury_severity,'')as severity,inj.inj_medical_treatment_taken_by_injured,inj.inj_name_of_hospital,inj.inj_peroid_of_hospital,inj.inj_got_reimpuresement,inj.inj_permenant_disablity,\r\n"
			+ "inj.inj_treatment,inj.multiplier,inj.inj_convenance,inj.inj_special_diet,inj.inj_cost_nursing_attendant,inj.inj_loss_income,inj.inj_any_other_loss_req_special_treatment,\r\n"
			+ "inj.inj_percentage_disablity,inj.inj_loss_erning_capacity,inj.inj_any_other_pecuniary_loss,inj.inj_pain_suffering,inj.inj_loss_amenities,\r\n"
			+ "inj.inj_post_traumatic,inj.inj_com_mental_phy_shock,inj.inj_disfiguration,inj.inj_loss_marriage_prospects,inj.inj_loss_reputation,\r\n"
			+ "inj.inj_anyother_non_pecuniary FROM dar_slsa_injured inj,irad_driver driver,dar_vehicle v where inj.accident_id=:accidentId\r\n"
			+ "and inj.vehicle_id=:vehicleId and inj.person_id=:personId and inj.accident_id=driver.accident_id and inj.person_id::integer=driver.id\r\n"
			+ "and inj.vehicle_id=driver.vehicle_id and driver.accident_id=v.acc_id and driver.vehicle_id=v.veh_ref_id";

	private final String report12LegalRepDeceased = "select ref_id as refId,name as legalRepName,gender,age as legalRepAge,master.get_familymembers(relation_type,'en') as legalRepRelation from dar_family_details where acc_id=:accidentId and ref_id=:personId ";

	private final String report12LegalRepInjured = "select ref_id as refId,name as legalRepName,gender,age as legalRepAge,master.get_familymembers(relation_type,'en') as legalRepRelation from dar_family_details where acc_id=:accidentId and ref_id=:personId ";

	//////// FORM 13

	private final String report13Deceased = "select death.death_income,death.death_future_prospects,death.death_less_personal_expenses,death.death_monthly_loss_depedency,\r\n"
			+ "death.death_anual_loss_depedency,death.death_mulltiplier,death.death_total_loss_dependency,death.death_medical_expenses,death.death_loss_consortium,\r\n"
			+ "death.death_loss_for_love_affection,death.death_loss_estate,death.death_loss_funeral_expenses,death.death_total_compensation,death.death_interest,\r\n"
			+ "ins.death_income as ins_death_income,ins.death_future_prospects as ins_death_future_prospects,ins.death_less_personal_expenses as ins_death_less_personal_expenses,\r\n"
			+ "ins.death_monthly_loss_depedency as ins_death_monthly_loss_depedency,ins.death_anual_loss_depedency as ins_death_anual_loss_depedency,\r\n"
			+ "ins.death_mulltiplier as ins_death_mulltiplier,ins.death_total_loss_dependency as ins_death_total_loss_dependency,ins.death_medical_expenses as ins_death_medical_expenses,\r\n"
			+ "ins.death_loss_consortium as ins_death_loss_consortium,ins.death_loss_for_love_affection as ins_death_loss_for_love_affection,\r\n"
			+ "ins.death_loss_estate as ins_death_loss_estate,ins.death_loss_funeral_expenses as ins_death_loss_funeral_expenses,ins.death_total_compensation as ins_death_total_compensation,\r\n"
			+ "ins.death_interest as ins_death_interest from public.dar_petitioners_compensation_death death,dar_insurance_death ins where death.accident_id=:accidentId\r\n"
			+ "and death.vehicle_id=:vehicleId and death.person_id=:personId and death.person_type=:personType and ins.accident_id=death.accident_id and ins.vehicle_id=death.vehicle_id \r\n"
			+ "and ins.person_id=death.person_id and ins.person_type=death.person_type";
//passenger
	private final String passengerSeverity13 = "select injury_severity from irad_passenger where accident_id=:accidentId and vehicle_id=:vehicleId and id=:personId::integer";

	private final String report13Pass = "select pass.name as name,s.accident_id,TO_CHAR(accident_date_time::timestamp,' dd-Mon-yyyy : HH:MI AM') as reporting_datetime,pass.age as age,\r\n"
			+ "master.get_occupation(occupation,'') as occupation from irad_passenger pass,sp_irad_accident s where pass.accident_id=:accidentId and \r\n"
			+ "pass.vehicle_id=:vehicleId and pass.id=:personId::integer and pass.injury_severity='1'and s.accident_id=pass.accident_id";
//pedestrian
	private final String pedestrianSeverity13 = "select injury_severity from irad_pedestrian where accident_id=:accidentId and vehicle_id=:vehicleId and id=:personId::integer";

	private final String report13Ped = "select ped.name as name,s.accident_id,TO_CHAR(accident_date_time::timestamp,' dd-Mon-yyyy : HH:MI AM') as reporting_datetime, ped.age as age,\r\n"
			+ "master.get_occupation(occupation,'') as occupation from irad_pedestrian ped,sp_irad_accident s where ped.accident_id=:accidentId and\r\n"
			+ "ped.vehicle_id=:vehicleId and ped.id=:personId::integer and ped.injury_severity='1'and s.accident_id=ped.accident_id";
//driver
	private final String driverSeverity13 = "select injury_severity from irad_driver where accident_id=:accidentId and vehicle_id=:vehicleId and id=:personId::integer";

	private final String report13dri = "select driver.ser_name as name,s.accident_id,TO_CHAR(accident_date_time::timestamp,' dd-Mon-yyyy : HH:MI AM') as reporting_datetime,driver.age as age,\r\n"
			+ "master.get_occupation(occupation,'') as occupation from irad_driver driver,sp_irad_accident s where driver.accident_id=:accidentId and\r\n"
			+ "driver.vehicle_id=:vehicleId and driver.id=:personId::integer and driver.injury_severity='1'and s.accident_id=driver.accident_id";

	private final String report13LegalRep = "select ref_id as refId,name as legalRepName,age as legalRepAge,master.get_familymembers(relation_type,'en') as legalRepRelation from dar_family_details where acc_id=:accidentId and ref_id=:personId ";

	//////// FORM 14
	private final String report14Injured = "select inj.inj_convenance as inj_convenance,inj.inj_special_diet as inj_special_diet,inj.inj_cost_nursing_attendant as inj_cost_nursing_attendant,\r\n"
			+ "inj.inj_loss_income as inj_loss_income,inj.inj_cost_artificial_limp as inj_cost_artificial_limp,inj.inj_any_other_loss as inj_any_other_loss,\r\n"
			+ "inj.inj_com_mental_phy_shock as inj_com_mental_phy_shock,inj.inj_pain_suffering as inj_pain_suffering,inj.inj_loss_amenities as inj_loss_amenities,\r\n"
			+ "inj.inj_disfiguration as inj_disfiguration,inj.inj_loss_of_marriage as inj_loss_of_marriage,inj.inj_loss_ear_inc_har_dis as inj_loss_ear_inc_har_dis,\r\n"
			+ "inj.inj_per_disablity as inj_per_disablity,inj.inj_loss_ami_life_span as inj_loss_ami_life_span,inj.inj_per_loss_earning as inj_per_loss_earning,\r\n"
			+ "inj.in_loss_future_income as in_loss_future_income,inj.inj_total_copensation as inj_total_copensation,inj.inj_interest as inj_interest,\r\n"
			+ "inj.insertedon as insertedon,inj.insertedby as insertedby,inj.inj_income as inj_income,\r\n"
			+ "ins.inj_convenance as ins_inj_convenance,ins.inj_special_diet as ins_inj_special_diet,ins.inj_cost_nursing_attendant as ins_inj_cost_nursing_attendant,\r\n"
			+ "ins.inj_loss_income as ins_inj_loss_income,ins.inj_cost_artificial_limp as ins_inj_cost_artificial_limp,ins.inj_any_other_loss as ins_inj_any_other_loss,\r\n"
			+ "ins.inj_com_mental_phy_shock as ins_inj_com_mental_phy_shock,ins.inj_pain_suffering as ins_inj_pain_suffering,ins.inj_loss_amenities as ins_inj_loss_amenities,\r\n"
			+ "ins.inj_disfiguration as ins_inj_disfiguration,ins.inj_loss_of_marriage as ins_inj_loss_of_marriage,ins.inj_loss_ear_inc_har_dis as ins_inj_loss_ear_inc_har_dis,\r\n"
			+ "ins.inj_disablity_percentage as ins_inj_disablity_percentage,ins.inj_amenities_lifespan as ins_inj_amenities_lifespan,ins.inj_percentage_earning_capacity \r\n"
			+ "as ins_inj_percentage_earning_capacity,ins.inj_loss_future_income as ins_inj_loss_future_income,ins.inj_total_copensation as ins_inj_total_copensation,\r\n"
			+ "ins.inj_intrest as ins_inj_intrest,ins.inj_income as ins_inj_income,ins.inj_medical_treatment as ins_inj_medical_treatment,ins.inj_permenant_disablity \r\n"
			+ "as ins_inj_permenant_disablity,ins.inj_permenant_disablity_details as ins_inj_permenant_disablity_details from dar_petitioners_compensation_injured inj,\r\n"
			+ "dar_insurance_injured ins where inj.accident_id=:accidentId and inj.vehicle_id=:vehicleId and inj.person_id=:personId and inj.person_type=:personType \r\n"
			+ "and ins.accident_id=inj.accident_id and ins.vehicle_id=inj.vehicle_id and ins.person_id=inj.person_id and ins.person_type=inj.person_type\r\n"
			+ "";
	// passenger
	private final String passengerSeverity14 = "select injury_severity from irad_passenger where accident_id=:accidentId and vehicle_id=:vehicleId and id=:personId::integer";

	private final String report14Pass = "SELECT dar.permanent_disability,dar.hospital_treatment_period,pass.accident_id,pass.name,pass.age,master.get_occupation(pass.occupation,'') as occupation,dar.income,TO_CHAR(accident_date_time::timestamp,' dd-Mon-yyyy') as accident_datetime,\r\n"
			+ "dar.income,dar.period_hospitlization,dar.treatment_details,master.get_severity(pass.injury_severity) as natureofinjury FROM irad_passenger pass JOIN dar_passenger dar ON pass.accident_id =dar.acc_id \r\n"
			+ "JOIN sp_irad_accident s  on s.accident_id=pass.accident_id and pass.id=dar.passenger_ref_id::integer and pass.accident_id=:accidentId and pass.vehicle_id=:vehicleId and pass.id=:personId::integer and pass.injury_severity in('2','3','4')";

	// pedestrian
	private final String pedestrianSeverity14 = "select injury_severity from irad_pedestrian where accident_id=:accidentId and vehicle_id=:vehicleId and id=:personId::integer";

	private final String report14Ped = "SELECT dar.permanent_disability,dar.hospital_treatment_period,ped.accident_id,ped.name,ped.age,master.get_occupation(ped.occupation,'') as occupation,dar.income,TO_CHAR(accident_date_time::timestamp,' dd-Mon-yyyy') as accident_datetime,\r\n"
			+ "dar.income,dar.period_hospitlization,dar.treatment_details,master.get_severity(ped.injury_severity) as natureofinjury\r\n"
			+ "FROM irad_pedestrian ped JOIN dar_pedestrian dar ON ped.accident_id =dar.acc_id  JOIN sp_irad_accident s on s.accident_id=ped.accident_id\r\n"
			+ "and ped.id=dar.pedestrian_ref_id::integer and ped.accident_id=:accidentId and ped.vehicle_id=:vehicleId and ped.id=:personId::integer and ped.injury_severity in('2','3','4')";

	// driver
	private final String driverSeverity14 = "select injury_severity from irad_driver where accident_id=:accidentId and vehicle_id=:vehicleId and id=:personId::integer";

	private final String report14dri = "SELECT dar.permanent_disability,dar.period_hospitlization,dar.treatment_details,driver.accident_id,driver.ser_name,driver.age,master.get_occupation(driver.occupation,'') as occupation,dar.driver_income,TO_CHAR(accident_date_time::timestamp,' dd-Mon-yyyy') as accident_datetime,\r\n"
			+ "dar.period_hospitlization,dar.treatment_details,master.get_severity(driver.injury_severity) as natureofinjury FROM irad_driver driver  JOIN dar_vehicle dar ON  driver.accident_id =dar.acc_id JOIN sp_irad_accident s \r\n"
			+ "on s.accident_id=driver.accident_id and driver.vehicle_id=dar.veh_ref_id::text and driver.accident_id=:accidentId and driver.vehicle_id=:vehicleId \r\n"
			+ "and driver.id=:personId::integer and driver.injury_severity in('2','3','4')";

	//////// FORM 15
	private final String report15Deceased = "SELECT TO_CHAR(nest_date_award::timestamp,' dd-Mon-yyyy : HH:MI AM') as nest_date_award,* FROM public.dar_tribunal_compensation_death where accident_id=:accidentId and vehicle_id=:vehicleId and person_id=:personId";

	// passenger
	private final String passengerSeverity15 = "select injury_severity from irad_passenger where accident_id=:accidentId and vehicle_id=:vehicleId and id=:personId::integer";

	private final String report15Pass = "select pass.name as name,s.accident_id,TO_CHAR(accident_date_time::timestamp,' dd-Mon-yyyy : HH:MI AM') as reporting_datetime,pass.age as age,\r\n"
			+ "master.get_occupation(occupation,'') as occupation from irad_passenger pass,sp_irad_accident s where pass.accident_id=:accidentId and \r\n"
			+ "pass.vehicle_id=:vehicleId and pass.id=:personId::integer and pass.injury_severity='1'and s.accident_id=pass.accident_id";
	// pedestrian
	private final String pedestrianSeverity15 = "select injury_severity from irad_pedestrian where accident_id=:accidentId and vehicle_id=:vehicleId and id=:personId::integer";

	private final String report15Ped = "select ped.name as name,s.accident_id,TO_CHAR(accident_date_time::timestamp,' dd-Mon-yyyy : HH:MI AM') as reporting_datetime, ped.age as age,\r\n"
			+ "master.get_occupation(occupation,'') as occupation from irad_pedestrian ped,sp_irad_accident s where ped.accident_id=:accidentId and\r\n"
			+ "ped.vehicle_id=:vehicleId and ped.id=:personId::integer and ped.injury_severity='1'and s.accident_id=ped.accident_id";
	// driver
	private final String driverSeverity15 = "select injury_severity from irad_driver where accident_id=:accidentId and vehicle_id=:vehicleId and id=:personId::integer";

	private final String report15dri = "select driver.ser_name as name,s.accident_id,TO_CHAR(accident_date_time::timestamp,' dd-Mon-yyyy : HH:MI AM') as reporting_datetime,driver.age as age,\r\n"
			+ "master.get_occupation(occupation,'') as occupation from irad_driver driver,sp_irad_accident s where driver.accident_id=:accidentId and\r\n"
			+ "driver.vehicle_id=:vehicleId and driver.id=:personId::integer and driver.injury_severity='1'and s.accident_id=driver.accident_id";

	private final String report15LegalRep = "select ref_id as refId,name as legalRepName,age as legalRepAge,master.get_familymembers(relation_type,'en') as legalRepRelation from dar_family_details where acc_id=:accidentId and ref_id=:personId ";

	//////// FORM 16
	private final String report16 = "select TO_CHAR(nest_date_award::timestamp,' dd-Mon-yyyy : HH:MI AM') as nest_date_award,* from dar_tribunal_compensation_injured where accident_id=:accidentId and vehicle_id=:vehicleId and person_id=:personId";
	// passenger
	private final String passengerSeverity16 = "select injury_severity from irad_passenger where accident_id=:accidentId and vehicle_id=:vehicleId and id=:personId::integer";

	private final String report16Pass = "select darpass.permanent_disability_details,darpass.income,master.get_severity(pass.injury_severity)as severity,darpass.permanent_disability,"
			+ "darpass.hospital_treatment_details,darpass.hospital_treatment_period,pass.name as name,s.accident_id,TO_CHAR(accident_date_time::timestamp,' dd-Mon-yyyy : HH:MI AM') as reporting_datetime,"
			+ "pass.age as age,master.get_occupation(occupation,'') as occupation from irad_passenger pass,sp_irad_accident s,dar_passenger darpass where pass.accident_id=:accidentId and pass.vehicle_id=:vehicleId "
			+ "and pass.id=:personId::integer and pass.injury_severity in('2','3','4') and s.accident_id=pass.accident_id and pass.accident_id=darpass.acc_id and pass.vehicle_id=darpass.veh_no and "
			+ "pass.id=darpass.passenger_ref_id::integer";
	// pedestrian
	private final String pedestrianSeverity16 = "select injury_severity from irad_pedestrian where accident_id=:accidentId and vehicle_id=:vehicleId and id=:personId::integer";

	private final String report16Ped = "select darped.permanent_disability_details,darped.income,master.get_severity(ped.injury_severity)as severity,darped.permanent_disability,darped.hospital_treatment_details,"
			+ "darped.hospital_treatment_period,ped.name as name,s.accident_id,TO_CHAR(accident_date_time::timestamp,' dd-Mon-yyyy : HH:MI AM') as reporting_datetime, ped.age as age,\r\n"
			+ "master.get_occupation(occupation,'') as occupation from irad_pedestrian ped,sp_irad_accident s,dar_pedestrian darped where ped.accident_id=:accidentId and ped.vehicle_id=:vehicleId and"
			+ " ped.id=:personId::integer and ped.injury_severity in('2','3','4') and s.accident_id=ped.accident_id and ped.accident_id=darped.acc_id and ped.vehicle_id=darped.veh_no and ped.id=darped.pedestrian_ref_id::integer";
	// driver
	private final String driverSeverity16 = "select injury_severity from irad_driver where accident_id=:accidentId and vehicle_id=:vehicleId and id=:personId::integer";

	private final String report16dri = "select dardriver.permanent_disability_details,dardriver.driver_income,master.get_severity(injury_severity) as severity,dardriver.permanent_disability,dardriver.treatment_details,\r\n"
			+ "dardriver.period_hospitlization,driver.ser_name as name,s.accident_id,TO_CHAR(accident_date_time::timestamp,' dd-Mon-yyyy : HH:MI AM') as reporting_datetime,driver.age as age,\r\n"
			+ "master.get_occupation(occupation,'') as occupation from irad_driver driver,sp_irad_accident s,dar_vehicle dardriver\r\n"
			+ "where driver.accident_id=:accidentId and driver.vehicle_id=:vehicleId \r\n"
			+ "and driver.id=:personId::integer and driver.injury_severity in('2','3','4') and s.accident_id=driver.accident_id\r\n"
			+ "and  driver.accident_id=dardriver.acc_id and driver.vehicle_id=dardriver.veh_ref_id";

	//////// FORM 17
	private final String report17 = "select TO_CHAR(award_date::timestamp,' dd-Mon-yyyy : HH:MI AM') as award_date,"
			+ "TO_CHAR(permenent_res_addr::timestamp,' dd-Mon-yyyy : HH:MI AM') as permenent_res_addr,TO_CHAR(bank_acc_near::timestamp,' dd-Mon-yyyy : HH:MI AM') as bank_acc_near,"
			+ "TO_CHAR(examined::timestamp,' dd-Mon-yyyy : HH:MI AM') as examined,TO_CHAR(bank_acc_near::timestamp,' dd-Mon-yyyy : HH:MI AM') as bank_acc_near,TO_CHAR(date_passbook::timestamp,' dd-Mon-yyyy : HH:MI AM') as date_passbook,"
			+ " TO_CHAR(date_bank_acc_create::timestamp,' dd-Mon-yyyy : HH:MI AM') as date_bank_acc_create,* from dar_compliance where accident_id=:accidentId";
	
	private final String report17accident="select TO_CHAR(accident_date_time::timestamp,' dd-Mon-yyyy : HH:MI AM') as accident_date_time from sp_irad_accident where accident_id=:accidentId";

	private final String report17form1 = "SELECT TO_CHAR(submitedon::timestamp,' dd-Mon-yyyy : HH:MI AM') as submitedon FROM public.edar_formsubmition where accident_id=:accidentId and formno='1'";

	private final String report17form2 = "SELECT TO_CHAR(submitedon::timestamp,' dd-Mon-yyyy : HH:MI AM') as submitedon FROM public.edar_formsubmition where accident_id=:accidentId and formno='2'";

	private final String report17form3 = "SELECT TO_CHAR(submitedon::timestamp,' dd-Mon-yyyy : HH:MI AM') as submitedon FROM public.edar_formsubmition where accident_id=:accidentId and formno='3'";

	private final String report17form4 = "SELECT TO_CHAR(submitedon::timestamp,' dd-Mon-yyyy : HH:MI AM') as submitedon FROM public.edar_formsubmition where accident_id=:accidentId and formno='4'";

	private final String report17form5 = "SELECT TO_CHAR(submitedon::timestamp,' dd-Mon-yyyy : HH:MI AM') as submitedon FROM public.edar_formsubmition where accident_id=:accidentId and formno='5'";

	private final String report17form6 = "SELECT TO_CHAR(submitedon::timestamp,' dd-Mon-yyyy : HH:MI AM') as submitedon FROM public.edar_formsubmition where accident_id=:accidentId and formno='6'";

	private final String report17form6a = "SELECT TO_CHAR(submitedon::timestamp,' dd-Mon-yyyy : HH:MI AM') as submitedon FROM public.edar_formsubmition where accident_id=:accidentId and formno='6A'";

	private final String report17form7 = "SELECT TO_CHAR(submitedon::timestamp,' dd-Mon-yyyy : HH:MI AM') as submitedon FROM public.edar_formsubmition where accident_id=:accidentId and formno='7'";

	//////// FORM 18
	private final String report18 = "select TO_CHAR(award_date::timestamp,' dd-Mon-yyyy : HH:MI AM') as award_date,TO_CHAR(date_notice_depositer::timestamp,' dd-Mon-yyyy : HH:MI AM') as date_notice_depositer,"
			+ "TO_CHAR(date_notice_tribunal::timestamp,' dd-Mon-yyyy : HH:MI AM') as date_notice_tribunal,TO_CHAR(release_date::timestamp,' dd-Mon-yyyy : HH:MI AM') as release_date,* from dar_awards where accident_id=:accidentId";

	//////// FORM 20
	private final String report20 = "SELECT * FROM public.dar_record_of_awards";
	
	////////FORM 6a
	private final String report6aDocuments = "select 'Child' as ptype,id,whose_child,documents.get_required_documents(acc_id,'6A','attachment','Child',id::text) as attachment,user_type,age,name from "
			+ "dar_minor_children_of_victim where  acc_id=:accid and whose_child=:whoseChild";

	//////////////////////////////////////////////////////////// Report 1	//////////////////////////////////////////////////////////// ////////////////////////////////////////////////////////////

	@Override
	public Pdf1Entity getreport1(String accidentId) {
		List<JSONObject> resObject = new ArrayList<JSONObject>();
		List<JSONObject> jObject = new ArrayList<JSONObject>();
		Pdf1Entity pdf1Entity = new Pdf1Entity();

		SqlParameterSource parameters = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(GET_ACCIDENT_DETAILS, parameters, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				int totalDead = Integer.parseInt(rs.getString("driver_dead"))
						+ Integer.parseInt(rs.getString("pass_dead")) + Integer.parseInt(rs.getString("ped_dead"));
				int totalInjured = Integer.parseInt(rs.getString("driver_inj"))
						+ Integer.parseInt(rs.getString("pass_inj")) + Integer.parseInt(rs.getString("ped_inj"));
				String date = rs.getString("datetime");

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				String accidentDate = dtf.format(now);
				pdf1Entity.setCurrentDate(accidentDate);
				String firtime = rs.getString("firdatetime");
				pdf1Entity.setAccidentId(rs.getString("accident_id"));
				pdf1Entity.setFirNumber(rs.getString("fir_number"));
				pdf1Entity.setDateTime(date.substring(0, date.indexOf(':')));
				System.out.println(date.substring(0, date.indexOf(':')));
				pdf1Entity.setTimeOfTheDay(date.substring(date.indexOf(':') + 1));
				pdf1Entity.setPsName(rs.getString("psname"));
				pdf1Entity.setInvestigatingOfficerName(rs.getString("name"));
				pdf1Entity.setInvestigatingOfficerPis(rs.getString("regno"));
				pdf1Entity.setInvestigatingOfficerMobile(rs.getString("mobile"));
				pdf1Entity.setLandmarks(rs.getString("landmarks"));
				pdf1Entity.setVehiclesCount(rs.getString("vehicles_count"));
				pdf1Entity.setTotalDead(String.valueOf(totalDead));
				pdf1Entity.setTotalInjured(String.valueOf(totalInjured));
				pdf1Entity.setYear(rs.getString("year"));
				pdf1Entity.setCollisionType(rs.getString("collision_type"));
				pdf1Entity.setState(rs.getString("statename"));
				pdf1Entity.setDistrict(rs.getString("districtname"));
				pdf1Entity.setSection(rs.getString("section"));
				pdf1Entity.setSection(rs.getString("section"));
				pdf1Entity.setAct(rs.getString("act"));
				pdf1Entity.setRoadDetails(rs.getString("roaddetails"));
				pdf1Entity.setFirDateTime(firtime);
				String reqofficer = rs.getString("reqofficer");
				Object obj = null;
				try {
					obj = new JSONParser().parse(reqofficer);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				// typecasting obj to JSONObject
				JSONObject jo = (JSONObject) obj;
				// getting shoName and shoDesignation
				String shoName = (String) jo.get("name");
				String shoDesignation = (String) jo.get("designation");
				pdf1Entity.setShoName(shoName.toUpperCase());
				pdf1Entity.setShoDesignation(shoDesignation);
				pdf1Entity.setStateCode(accidentId.substring(4, 6));
				return pdf1Entity;
			}
		});
		List<VehicleAndDriverDetails> vehicleDriverDetails = new ArrayList<VehicleAndDriverDetails>();

		SqlParameterSource parameters5 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		List<Object> vehicleResObjec = namedParameterJdbcTemplate.query(detailsOfVehicleDriver, parameters5,
				new RowMapper<Object>() {
					@SuppressWarnings("unchecked")
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						do {
							VehicleAndDriverDetails vehicleAndDriverDetails = new VehicleAndDriverDetails();
							vehicleAndDriverDetails.setVehicleRegNo(rs.getString("vehicle_reg_no"));
							vehicleAndDriverDetails.setNameOfTheDriver(rs.getString("ser_name"));
							vehicleAndDriverDetails.setAddressOfDriver1(rs.getString("residence"));
							String permanentAddress = rs.getString("ser_permadd1") + rs.getString("ser_permadd2")
									+ rs.getString("ser_permadd3");
							String temporaryAddress = rs.getString("ser_tempadd1") + rs.getString("ser_tempadd2")
									+ rs.getString("ser_tempadd3");
							vehicleAndDriverDetails.setAddressOfDriver2(permanentAddress);
							vehicleAndDriverDetails.setAddressOfDriver3(temporaryAddress);
							vehicleAndDriverDetails.setDriverContactNumber(rs.getString("mobile_no"));
							vehicleAndDriverDetails.setNameOfTheOwner(rs.getString("service_ownername"));
							vehicleAndDriverDetails.setAddressOfOwner(rs.getString("owneraddr"));
							vehicleAndDriverDetails.setInsurancePolicyNumber(rs.getString("insurance_policyno"));

							String insValidity = rs.getString("insurance_validity");
							if (insValidity.length() >= 1) {
								String insurancePolicy = insValidity.substring(0, 11);
								vehicleAndDriverDetails.setPeriodOfInsurancePolicy(insurancePolicy);
							} else {
								vehicleAndDriverDetails.setPeriodOfInsurancePolicy(" ");
							}

							vehicleAndDriverDetails.setNameOfInsuranceCompany(rs.getString("insurance_details"));
							vehicleAndDriverDetails.setAddressOfInsuranceCompany(rs.getString("insaddress"));
							vehicleAndDriverDetails.setAccusedVictim(rs.getString("accused_victim"));
							vehicleDriverDetails.add(vehicleAndDriverDetails);
							pdf1Entity.setVehicleAndDriver(vehicleDriverDetails);
							// pdf1Entity.setAccusedVictim(rs.getString("accused_victim"));
						} while (rs.next());
						resObject.addAll(jObject);
						return resObject;
					}
				});

		SqlParameterSource parameters2 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(sqlvec, parameters2, new RowMapper<Object>() {
			@SuppressWarnings("unchecked")
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

//				pdf1Entity.setInsuranceDetails(rs.getString("ins"));
//				pdf1Entity.setInsurancePolicyNumber(rs.getString("insurance_policyno"));
//				pdf1Entity.setInsuranceValidity(rs.getString("insurance_validity"));
				// pdf1Entity.setVehicle_reg_no(rs.getString("vehicle_reg_no"));
				pdf1Entity.setRegnstatus(rs.getString("regnoknown"));
				return pdf1Entity;
			}
		});

		SqlParameterSource parameters6 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(darGeneral, parameters6, new RowMapper<Object>() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				String cctv = rs.getString("cctv_availability").toString();
				System.out.println(cctv);
				if (cctv.equals("t") && !cctv.isEmpty()) {
					pdf1Entity.setCctvAvailability("Yes");
				} else if (cctv.equals("f") && !cctv.isEmpty()) {
					pdf1Entity.setCctvAvailability("No");
				}
				String cctvFootage = rs.getString("cctv_footage_doc").toString();
				// accidentDetails.setCctvFootage(rs.getString("cctv_footage_doc"));

				if (cctvFootage.equals("t") && !cctvFootage.isEmpty()) {
					pdf1Entity.setCctvFootage("Yes");
				} else if (cctvFootage == "f" && !cctvFootage.isEmpty()) {
					pdf1Entity.setCctvFootage("No");
				}
				pdf1Entity.setNatureOfAccident(rs.getString("nature_acc"));
				pdf1Entity.setVehImpoundedPolice(rs.getString("vehicle_impounded_police"));
				pdf1Entity.setOffendingVehSpotted(rs.getString("offending_vehicle_spotted"));
				pdf1Entity.setOwner_mobile_no(rs.getString("owner_mobile_no"));
				pdf1Entity.setSourceOfInformation(rs.getString("who_report_acc"));

				pdf1Entity.setInformantName(rs.getString("reporting_person_name"));
				System.out.println(rs.getString("reporting_person_name"));
				pdf1Entity.setInformerContactNumber(rs.getString("reporting_person_mobile"));
				pdf1Entity.setInformerContactAddress(rs.getString("reporting_person_address"));
				return pdf1Entity;
			}
		});
		List<InjuredAndDeseasedDetails> injuredDeseasedDetails = new ArrayList<InjuredAndDeseasedDetails>();
		SqlParameterSource parameters7 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(injuredAndDeceased, parameters7, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				String injurySeverity;
				do {
					InjuredAndDeseasedDetails injuredAndDeseasedDetails = new InjuredAndDeseasedDetails();
					injuredAndDeseasedDetails.setName(rs.getString("name"));
					injuredAndDeseasedDetails.setAddress(rs.getString("address"));
					injuredAndDeseasedDetails.setMobileNo(rs.getString("mobile_no"));

					injurySeverity = rs.getString("injury_severity").toString();
					if (!injurySeverity.isEmpty()) {
						if (Integer.parseInt(injurySeverity) == 1 && injurySeverity != null
								&& Integer.parseInt(injurySeverity) != 0) {
							injuredAndDeseasedDetails.setInjuredOrDeseased("Deseased");
						} else if (Integer.parseInt(injurySeverity) == 2 || Integer.parseInt(injurySeverity) == 3
								|| Integer.parseInt(injurySeverity) == 4 && injurySeverity != null
										&& Integer.parseInt(injurySeverity) != 0) {
							injuredAndDeseasedDetails.setInjuredOrDeseased("Injured");
						}
					} else {
						injuredAndDeseasedDetails.setInjuredOrDeseased("No Injured/Deceased");
					}

					injuredDeseasedDetails.add(injuredAndDeseasedDetails);
					pdf1Entity.setInjuredAndDeseased(injuredDeseasedDetails);

//					accidentDetails.setHpname(rs.getString("hpname"));
//					accidentDetails.setHpaddress(rs.getString("address"));
//					accidentDetails.setDoctor_name(rs.getString("doctor_name"));
				} while (rs.next());
				return pdf1Entity;
			}

		});
		List<HospitalDetails> hospitalDetails1 = new ArrayList<HospitalDetails>();
		SqlParameterSource parameters8 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(hospitalDetails, parameters8, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				System.out.println("hospital");
				do {
					HospitalDetails HospitalDetails = new HospitalDetails();
					HospitalDetails.setDoctorName(rs.getString("doctor_name"));
					System.out.println(rs.getString("doctor_name"));
					HospitalDetails.setHospitalName(rs.getString("hpname"));
					HospitalDetails.setHospitalAddress(rs.getString("hpaddress"));
					System.out.println("Hospital Address" + rs.getString("hpaddress"));
					HospitalDetails.setDoctorRegno(rs.getString("doctor_regno"));

					hospitalDetails1.add(HospitalDetails);
					pdf1Entity.setHospital(hospitalDetails1);

				} while (rs.next());
//				System.out.println(pdf1Entity.getHospital());
				return pdf1Entity;
			}

		});

		SqlParameterSource parameters9 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(form1DocAttached, parameters9, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.equals(null)) {
					do {
						pdf1Entity.setForm1DocAttached("1");

					} while (rs.next());
				} else {
					pdf1Entity.setForm1DocAttached("0");
				}

//				System.out.println(pdf1Entity.getHospital());
				return pdf1Entity;
			}

		});

		return pdf1Entity;
	}
///////////////////////////////////////////////////////////////Report 2////////////////////////////////////////////////////////////////////////////

	@Override
	public Pdf2Entity getreport2(String accidentId, String name) {
		List<JSONObject> resObject = new ArrayList<JSONObject>();
		List<JSONObject> jObject = new ArrayList<JSONObject>();
		Pdf2Entity pdf2Entity = new Pdf2Entity();
		pdf2Entity.setStateCode(accidentId.substring(4, 6));
		SqlParameterSource parameters1 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(GET_ACCIDENT_DETAILS, parameters1, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				int totalDead = Integer.parseInt(rs.getString("driver_dead"))
						+ Integer.parseInt(rs.getString("pass_dead")) + Integer.parseInt(rs.getString("ped_dead"));
				int totalInjured = Integer.parseInt(rs.getString("driver_inj"))
						+ Integer.parseInt(rs.getString("pass_inj")) + Integer.parseInt(rs.getString("ped_inj"));
				String date = rs.getString("datetime");

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				String accidentDate = dtf.format(now);
				pdf2Entity.setCurrentDate(accidentDate);
				System.out.println(accidentDate);
				pdf2Entity.setAccidentId(rs.getString("accident_id"));
				pdf2Entity.setPsName(rs.getString("psname"));

				pdf2Entity.setInvestigatingOfficerName(rs.getString("name"));
				pdf2Entity.setInvestigatingOfficerPis(rs.getString("regno"));
				pdf2Entity.setInvestigatingOfficerMobile(rs.getString("mobile"));

				String reqofficer = rs.getString("reqofficer");
				Object obj = null;
				try {
					obj = new JSONParser().parse(reqofficer);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				// typecasting obj to JSONObject
				JSONObject jo = (JSONObject) obj;
				// getting shoName and shoDesignation
				String shoName = (String) jo.get("name");
				String shoDesignation = (String) jo.get("designation");
				pdf2Entity.setShoName(shoName.toUpperCase());
				pdf2Entity.setShoDesignation(shoDesignation);
				return pdf2Entity;
			}
		});
		SqlParameterSource parameters = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(victimDetails, parameters, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				List<String> victimDetails = new ArrayList<String>();
				do {
					victimDetails.add(rs.getString(1));
				} while (rs.next());

				pdf2Entity.setVictimDetails(name);
				return pdf2Entity;
			}
		});
		SqlParameterSource parameters9 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(form2DocAttached, parameters9, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.equals(null)) {
					do {
						pdf2Entity.setForm2DocAttached("1");

					} while (rs.next());
				} else {
					pdf2Entity.setForm2DocAttached("0");
				}
				return pdf2Entity;
			}

		});
		return pdf2Entity;
	}

/////////////////////////////////////////////////////////////////Report 3 //////////////////////////////////////////////////////////////////////////
	@Override
	public Pdf3Entity getreport3(String accidentId, String vehicleId) {
		List<JSONObject> resObject = new ArrayList<JSONObject>();
		List<JSONObject> jObject = new ArrayList<JSONObject>();
		AccidentDetails accidentDetails = new AccidentDetails();
		Pdf3Entity pdf3Entity = new Pdf3Entity();
		pdf3Entity.setStateCode(accidentId.substring(4, 6));
		SqlParameterSource parameters = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(GET_ACCIDENT_DETAILS, parameters, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

				String date = rs.getString("datetime");

				String firtime = rs.getString("firdatetime");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				String accidentDate = dtf.format(now);
				
				
				
				DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDateTime now1 = LocalDateTime.now();
				System.out.println("haiiiiiii"+dtf1.format(now1));
				String accidentDate1 = dtf1.format(now1);
				pdf3Entity.setFooterDate(accidentDate1);
				
				
				pdf3Entity.setCurrentDate(accidentDate);

				pdf3Entity.setAccidentId(rs.getString("accident_id"));
				pdf3Entity.setFirNumber(rs.getString("fir_number"));
				pdf3Entity.setDateTime(date.substring(0, date.indexOf(':')));
				System.out.println(date.substring(0, date.indexOf(':')));
				accidentDetails.setTimeOfTheDay(date.substring(date.indexOf(':') + 1));
				pdf3Entity.setPsName(rs.getString("psname"));
				pdf3Entity.setState(rs.getString("statename"));
				pdf3Entity.setDistrict(rs.getString("districtname"));
				pdf3Entity.setSection(rs.getString("section"));

				pdf3Entity.setInvestigatingOfficerName(rs.getString("name"));
				pdf3Entity.setInvestigatingOfficerPis(rs.getString("regno"));
				pdf3Entity.setInvestigatingOfficerMobile(rs.getString("mobile"));
				pdf3Entity.setAct(rs.getString("act"));

				pdf3Entity.setFirDateTime(firtime);

				String reqofficer = rs.getString("reqofficer");
				Object obj = null;
				try {
					obj = new JSONParser().parse(reqofficer);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				// typecasting obj to JSONObject
				JSONObject jo = (JSONObject) obj;
				// getting shoName and shoDesignation
				String shoName = (String) jo.get("name");
				String shoDesignation = (String) jo.get("designation");
				pdf3Entity.setShoName(shoName.toUpperCase());
				pdf3Entity.setShoDesignation(shoDesignation);
				
				return pdf3Entity;
			}
		});
		SqlParameterSource parameters3 = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(driver, parameters3, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				accidentDetails.setSer_dateofbirth(rs.getString("dateofbirth"));
				pdf3Entity.setDriverName(rs.getString("name"));

				pdf3Entity.setDriverMobileno(rs.getString("sermobile"));
				pdf3Entity.setAddressOfDriver(rs.getString("residence"));
				// accidentDetails.setSer_age(rs.getString("age"));
				// accidentDetails.setSer_gender(rs.getString("ser_gender"));

				pdf3Entity.setDriverage(rs.getString("age"));
				pdf3Entity.setDriverOccupation(rs.getString("driveroccupation"));
				pdf3Entity.setLicense_number(rs.getString("license_number"));
				pdf3Entity.setSerGender(rs.getString("ser_gender"));
				pdf3Entity.setDrivinglicencetype(rs.getString("licencetype"));
				pdf3Entity.setDriver_education(rs.getString("drivereducation"));
				pdf3Entity.setDriverLicensingAuthority(rs.getString("ser_registration_authority"));
				pdf3Entity.setDriverLicenceValidity(rs.getString("ser_dltransvaldtill"));
				return pdf3Entity;
			}
		});

		SqlParameterSource parameters3a = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(darVehicleData, parameters3a, new RowMapper<Object>() {
			@SuppressWarnings("unchecked")
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

				pdf3Entity.setDriver_income(rs.getString("driver_income"));
				pdf3Entity.setOwner_veh_type(rs.getString("vehicletype"));

				pdf3Entity.setOwner_mobile_no(rs.getString("owner_mobile_no"));
				pdf3Entity.setRegno(rs.getString("vehicle_reg_no"));
				pdf3Entity.setVowneraddr(rs.getString("owneraddr"));
				pdf3Entity.setOwnername(rs.getString("service_ownername"));
				pdf3Entity.setInsuranceDetails(rs.getString("insurance_details"));
				pdf3Entity.setInsurancePolicyNumber(rs.getString("insurance_policyno"));
				pdf3Entity.setInsuranceValidity(rs.getString("insurance_validity"));
				pdf3Entity.setDriverFatherName(rs.getString("driver_father_name"));

				return pdf3Entity;
			}
		});

		SqlParameterSource parameters9a = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(form3DocLicense, parameters9a, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.equals(null)) {
					do {
						pdf3Entity.setForm3IdLicense("1");

					} while (rs.next());
				} else {
					pdf3Entity.setForm3IdLicense("0");
				}
				return pdf3Entity;
			}

		});
		SqlParameterSource parameters9b = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(form3DocAddProof, parameters9b, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.equals(null)) {
					do {
						pdf3Entity.setForm3IdProof("1");

					} while (rs.next());
				} else {
					pdf3Entity.setForm3IdProof("0");
				}
				return pdf3Entity;
			}

		});
		SqlParameterSource parameters9c = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(form3DocInsurance, parameters9c, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.equals(null)) {
					do {
						pdf3Entity.setForm3IdInsurance("1");

					} while (rs.next());
				} else {
					pdf3Entity.setForm3IdInsurance("0");
				}
				return pdf3Entity;
			}

		});
		return pdf3Entity;
	}

///////////////////////////////////////////////////////////////Report 4////////////////////////////////////////////////////////////////////////////	 
	@Override
	public Pdf4Entity getreport4(String accidentId, String vehicleId) {
		List<JSONObject> resObject = new ArrayList<JSONObject>();
		List<JSONObject> jObject = new ArrayList<JSONObject>();
		Pdf4Entity pdf4Entity = new Pdf4Entity();
		pdf4Entity.setStateCode(accidentId.substring(4, 6));
		SqlParameterSource parameters = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(GET_ACCIDENT_DETAILS, parameters, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				String date = rs.getString("datetime");

				String firtime = rs.getString("firdatetime");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				String accidentDate = dtf.format(now);
				pdf4Entity.setCurrentDate(accidentDate);

				System.out.println(accidentDate);
				
				
				DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDateTime now1 = LocalDateTime.now();
				String accidentDate1 = dtf1.format(now1);
				pdf4Entity.setFooterDate(accidentDate1);
				
				pdf4Entity.setAccidentId(rs.getString("accident_id"));

				pdf4Entity.setFirNumber(rs.getString("fir_number"));
				pdf4Entity.setDateTime(date.substring(0, date.indexOf(':')));
				System.out.println(date.substring(0, date.indexOf(':')));
				// pdf4Entity.setTimeOfTheDay(date.substring(date.indexOf(':') + 1));
				pdf4Entity.setSection(rs.getString("section"));
				pdf4Entity.setPsName(rs.getString("psname"));
				pdf4Entity.setState(rs.getString("statename"));
				pdf4Entity.setDistrict(rs.getString("districtname"));
				pdf4Entity.setInvestigatingOfficerName(rs.getString("name"));
				pdf4Entity.setInvestigatingOfficerPis(rs.getString("regno"));
				pdf4Entity.setInvestigatingOfficerMobile(rs.getString("mobile"));

				String reqofficer = rs.getString("reqofficer");
				Object obj = null;
				try {
					obj = new JSONParser().parse(reqofficer);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				// typecasting obj to JSONObject
				JSONObject jo = (JSONObject) obj;
				// getting shoName and shoDesignation
				String shoName = (String) jo.get("name");
				String shoDesignation = (String) jo.get("designation");
				pdf4Entity.setShoName(shoName.toUpperCase());
				pdf4Entity.setShoDesignation(shoDesignation);
				pdf4Entity.setFirDateTime(firtime);
				pdf4Entity.setAct(rs.getString("act"));

				return pdf4Entity;
			}
		});
		SqlParameterSource parameters4 = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(driverReport4, parameters4, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

				pdf4Entity.setDriverName(rs.getString("name"));
				// pdf4Entity.setDriver_mobileNo(rs.getString("sermobile"));
				pdf4Entity.setDriver_mobile_no(rs.getString("sermobile"));
				pdf4Entity.setSer_permadd1(rs.getString("residence"));
				pdf4Entity.setLicense_number(rs.getString("license_number"));
				// pdf4Entity.setSerRegistrationAuthority(rs.getString("ser_registration_authority"));licensingAuthority
				pdf4Entity.setDriverLicenceValidity(rs.getString("ser_dltransvaldtill"));
				pdf4Entity.setLicensingAuthority(rs.getString("ser_registration_authority"));
				return pdf4Entity;
			}
		});

		SqlParameterSource parameters4a = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(darVehicleDataReport4, parameters4a, new RowMapper<Object>() {
			@SuppressWarnings("unchecked")
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

				pdf4Entity.setVehicle_reg_no(rs.getString("regno"));
				// pdf4Entity.setRegno(rs.getString("vehicle_reg_no"));
				pdf4Entity.setColor(rs.getString("color"));
				pdf4Entity.setMake(rs.getString("vehicle_make"));
				pdf4Entity.setChassisno(rs.getString("chasis_number"));
				pdf4Entity.setEngineno(rs.getString("engine_nr"));
				pdf4Entity.setVowneraddr(rs.getString("owneraddr"));
				pdf4Entity.setVehicleModel(rs.getString("vehicle_model"));
				pdf4Entity.setOwner_mobile_no(rs.getString("owner_mobile_no"));
				pdf4Entity.setVtype(rs.getString("vehicletype"));
				pdf4Entity.setVehicleUseType(rs.getString("vehicleusetype"));
				pdf4Entity.setInsurancePolicyno(rs.getString("insurance_policyno"));
				pdf4Entity.setPeriodOfInsurancePolicy(rs.getString("insurance_validity"));
				pdf4Entity.setNameOfInsuranceCompany(rs.getString("insurance_details"));
				pdf4Entity.setSerRegistrationAuthority(rs.getString("ser_registration_authority"));

				// accidentDetails.setOwner_report_acc(rs.getString("owner_report_acc"));
				String reportedAccident = rs.getString("owner_report_acc");
				if (reportedAccident.equals("t") && !reportedAccident.isEmpty()) {
					pdf4Entity.setOwner_report_acc("Yes");
				} else if (reportedAccident.equals("f") && !reportedAccident.isEmpty()) {
					pdf4Entity.setOwner_report_acc("No");
				}
				pdf4Entity.setDriverFatherName(rs.getString("driver_father_name"));

				String mact = rs.getString("owner_mact");
				if (mact.equals("t") && !mact.isEmpty()) {
					pdf4Entity.setOwner_mact("Yes");
				} else if (mact.equals("f") && !mact.isEmpty()) {
					pdf4Entity.setOwner_mact("No");
				}

				pdf4Entity.setOwner_details_pre_ins(rs.getString("owner_details_pre_ins"));
				pdf4Entity.setOwnerFatherName(rs.getString("owner_father_name"));
				pdf4Entity.setOwnername(rs.getString("service_ownername"));
				pdf4Entity.setOwnerOccupation(rs.getString("owner_occupation"));
				// accidentDetails.setDriverLicensingAuthority(rs.getString("dri_license_authority"));

				pdf4Entity.setPermitno(rs.getString("permitno"));
				String permitValidity = rs.getString("permitvalidity");
				if (permitValidity.length() >= 1) {
					String perValidity = permitValidity.substring(0, 11);
					pdf4Entity.setPermitvalidity(perValidity);
				} else {
					pdf4Entity.setPermitvalidity(" ");
				}
				pdf4Entity.setFitcertval(rs.getString("fitcertval"));
				pdf4Entity.setYearofmanfac(rs.getString("rc_manu_month_yr"));
				pdf4Entity.setInsComAddr(rs.getString("insaddress"));
				pdf4Entity.setMactVehcileFir(rs.getString("mact_owner_vehicle_fir"));
				return pdf4Entity;
			}
		});
		SqlParameterSource parameters4b = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(vehicleTransportReport4, parameters4b, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

				return pdf4Entity;
			}
		});
		SqlParameterSource parameters4c = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(form4AddProof, parameters4c, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.equals(null)) {
					do {
						pdf4Entity.setForm4AdressProof("1");
					} while (rs.next());
				} else {
					pdf4Entity.setForm4AdressProof("0");
				}
				return pdf4Entity;
			}

		});
		SqlParameterSource parameters4d = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(form4RegCert, parameters4d, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.equals(null)) {
					do {
						pdf4Entity.setForm4RegCertificate("1");
					} while (rs.next());
				} else {
					pdf4Entity.setForm4RegCertificate("0");
				}
				return pdf4Entity;
			}
		});
		SqlParameterSource parameters4e = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(form4DriLicense, parameters4e, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.equals(null)) {
					do {
						pdf4Entity.setForm4driLicense("1");
					} while (rs.next());
				} else {
					pdf4Entity.setForm4driLicense("0");
				}
				return pdf4Entity;
			}
		});
		SqlParameterSource parameters4f = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(form4Insurance, parameters4f, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.equals(null)) {
					do {
						pdf4Entity.setForm4InsurancePolicy("1");
					} while (rs.next());
				} else {
					pdf4Entity.setForm4InsurancePolicy("0");
				}
				return pdf4Entity;
			}
		});
		SqlParameterSource parameters4g = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(form4Permit, parameters4g, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.equals(null)) {
					do {
						pdf4Entity.setForm4Permit("1");
					} while (rs.next());
				} else {
					pdf4Entity.setForm4Permit("0");
				}
				return pdf4Entity;
			}
		});
		SqlParameterSource parameters4h = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(form4Fitness, parameters4h, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.equals(null)) {
					do {
						pdf4Entity.setForm4Fitness("1");
					} while (rs.next());
				} else {
					pdf4Entity.setForm4Fitness("0");
				}
				return pdf4Entity;
			}
		});
		return pdf4Entity;
	}

	/////////////////////////////////////////////////////////////// Report5/////////////////////////////////////////////////////////////////////////
	@Override
	public Pdf5Entity getreport5(String accidentId, String vehicleId) {
		List<JSONObject> resObject = new ArrayList<JSONObject>();
		List<JSONObject> jObject = new ArrayList<JSONObject>();
		Pdf5Entity pdf5Entity = new Pdf5Entity();
		pdf5Entity.setStateCode(accidentId.substring(4, 6));
		SqlParameterSource parameters = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(GET_ACCIDENT_DETAILS, parameters, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				String date = rs.getString("datetime");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				String accidentDate = dtf.format(now);
				pdf5Entity.setCurrentDate(accidentDate);
				pdf5Entity.setAccidentId(rs.getString("accident_id"));
				pdf5Entity.setFirNumber(rs.getString("fir_number"));
				pdf5Entity.setDateTime(date.substring(0, date.indexOf(':')));
				System.out.println(date.substring(0, date.indexOf(':')));
				pdf5Entity.setTimeOfTheDay(date.substring(date.indexOf(':') + 1));
				pdf5Entity.setPsName(rs.getString("psname"));
				pdf5Entity.setLandmarks(rs.getString("landmarks"));
				pdf5Entity.setSection(rs.getString("section"));
				pdf5Entity.setState(rs.getString("statename"));
				pdf5Entity.setDistrict(rs.getString("districtname"));

				pdf5Entity.setInvestigatingOfficerName(rs.getString("name"));
				pdf5Entity.setInvestigatingOfficerPis(rs.getString("regno"));
				pdf5Entity.setInvestigatingOfficerMobile(rs.getString("mobile"));

				String firtime = rs.getString("firdatetime");
				pdf5Entity.setAct(rs.getString("act"));
				pdf5Entity.setFirDateTime(firtime);

				String reqofficer = rs.getString("reqofficer");
				Object obj = null;
				try {
					obj = new JSONParser().parse(reqofficer);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				// typecasting obj to JSONObject
				JSONObject jo = (JSONObject) obj;
				// getting shoName and shoDesignation
				String shoName = (String) jo.get("name");
				String shoDesignation = (String) jo.get("designation");
				pdf5Entity.setShoName(shoName.toUpperCase());
				pdf5Entity.setShoDesignation(shoDesignation);
				pdf5Entity.setRoadDetails(rs.getString("roaddetails"));
				return pdf5Entity;
			}
		});
		SqlParameterSource parameters5 = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(report5, parameters5, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				pdf5Entity.setOwner_mobile_no(rs.getString("owner_mobile_no"));
				pdf5Entity.setDriverLicensingAuthority(rs.getString("ser_registration_authority"));
				pdf5Entity.setDriverFatherName(rs.getString("driver_father_name"));
				pdf5Entity.setOwnerFatherName(rs.getString("owner_father_name"));
				pdf5Entity.setVehicle_reg_no(rs.getString("vehicle_reg_no"));
				pdf5Entity.setVehicleMake(rs.getString("vehicle_make"));
				pdf5Entity.setVehicleModel(rs.getString("vehicle_model"));
				pdf5Entity.setOwnerAddr(rs.getString("owneraddr"));
				pdf5Entity.setVehOwner(rs.getString("service_ownername"));
				pdf5Entity.setInsuranceDetails(rs.getString("insurance_details"));
				pdf5Entity.setInsurancePolicyno(rs.getString("insurance_policyno"));
				pdf5Entity.setInsuranceValidity(rs.getString("insurance_validity"));
				pdf5Entity.setInsComAddr(rs.getString("insaddress"));
				pdf5Entity.setPermitno(rs.getString("permitno"));
				String permitValidity = rs.getString("permitvalidity");
				if (permitValidity.length() >= 1) {
					String perValidity = permitValidity.substring(0, 11);
					pdf5Entity.setPermitvalidity(perValidity);
				} else {
					pdf5Entity.setPermitvalidity(" ");
				}
				// pdf5Entity.setPermitvalidity(rs.getString("permitvalidity"));
				pdf5Entity.setFitcertval(rs.getString("fitcertval"));
				pdf5Entity.setAcc_id(rs.getString("accident_id"));
				pdf5Entity.setSer_name(rs.getString("name"));
				pdf5Entity.setSer_permadd1(rs.getString("permadd1"));
				pdf5Entity.setSerMobileNumber(rs.getString("sermobile"));
				pdf5Entity.setResidence(rs.getString("residence"));
				pdf5Entity.setLicense_number(rs.getString("license_number"));
				pdf5Entity.setDrivinglicencetype(rs.getString("drivinglicencetype"));
				pdf5Entity.setSerMobileNumber(rs.getString("mobile_no"));
				pdf5Entity.setDriverLicenceValidity(rs.getString("ser_dltransvaldtill"));
				pdf5Entity.setOwnername(rs.getString("service_ownername"));
				pdf5Entity.setDocOfDriverOrOwnerVerified("Yes");
				return pdf5Entity;
			}
		});

		SqlParameterSource parameters5a1 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report5formDargeneral, parameters5a1, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				do {
					pdf5Entity.setBriefDescription(rs.getString("brief_description_accident"));
				} while (rs.next());
				return pdf5Entity;
			}
		});

		SqlParameterSource parameters5d1 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report5form1, parameters5d1, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {
						pdf5Entity.setDtFilingFar(rs.getString("submitedon"));
						// System.out.println("form submittedin first"+rs.getString("submitedon"));
						pdf5Entity.setDtUploadingFar(rs.getString("submitedon"));
						pdf5Entity.setDtDeliveryFirFarToInscompany(rs.getString("submitedon"));
					} while (rs.next());
				} else {
					pdf5Entity.setDtFilingFar(rs.getString(" "));
					pdf5Entity.setDtUploadingFar(rs.getString(" "));
					pdf5Entity.setDtDeliveryFirFarToInscompany(rs.getString(" "));
				}
				return pdf5Entity;
			}
		});

		SqlParameterSource parameters5a3 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report5form2, parameters5a3, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {
						pdf5Entity.setDtDeliveryFirForm2FarToVictim(rs.getString("submitedon"));

					} while (rs.next());
				} else {
					pdf5Entity.setDtDeliveryFirForm2FarToVictim(rs.getString(" "));
				}
				return pdf5Entity;
			}
		});

		SqlParameterSource parameters5a2 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report5form3, parameters5a2, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {
						pdf5Entity.setDtReceiptForm3FromDriver(rs.getString("submitedon"));
						pdf5Entity.setDtDeliveryForm3Form4ToInscompany(rs.getString("submitedon"));

					} while (rs.next());
				} else {
					pdf5Entity.setDtReceiptForm3FromDriver(rs.getString(" "));
					pdf5Entity.setDtDeliveryForm3Form4ToInscompany(rs.getString(" "));
				}
				return pdf5Entity;
			}
		});

		SqlParameterSource parameters5a4 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report5form4, parameters5a4, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {
						pdf5Entity.setDtReceiptForm4From_owner(rs.getString("submitedon"));
						pdf5Entity.setDtDeliveryForm3Form4ToVictim(rs.getString("submitedon"));

					} while (rs.next());
				} else {
					pdf5Entity.setDtReceiptForm4From_owner(rs.getString(" "));
					pdf5Entity.setDtDeliveryForm3Form4ToVictim(rs.getString(" "));
				}
				return pdf5Entity;
			}
		});

		List<WitnessDetails> details = new ArrayList<WitnessDetails>();
		SqlParameterSource parameters5a = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(sqlwitness, parameters5a, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				do {
					WitnessDetails witnessDetails = new WitnessDetails();
					witnessDetails.setWitnessName(rs.getString("name"));
					witnessDetails.setWitnessAddress(rs.getString("residence"));
					witnessDetails.setWitnessContact(rs.getString("mobile"));
					details.add(witnessDetails);
					pdf5Entity.setWitness(details);
				} while (rs.next());
				resObject.addAll(jObject);
				return details;
			}
		});
		namedParameterJdbcTemplate.query(detailsOfCompliance, parameters5a, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				pdf5Entity.setDtFilingFar(rs.getString("dt_filing_far"));
				pdf5Entity.setDtUploadingFar(rs.getString("dt_uploading_far"));
				pdf5Entity.setDtDeliveryFirFarToInscompany(rs.getString("dt_delivery_fir_far_to_inscompany"));
				pdf5Entity.setDtDeliveryFirForm2FarToVictim(rs.getString("dt_delivery_fir_form2_far_to_victim"));
				pdf5Entity.setDtReceiptForm3FromDriver(rs.getString("dt_receipt_form3_from_driver"));
				pdf5Entity.setDtReceiptForm4From_owner(rs.getString("dt_receipt_form4_from_owner"));
				pdf5Entity.setDtDeliveryForm3Form4ToInscompany(rs.getString("dt_delivery_form3_Form4_to_inscompany"));
				pdf5Entity.setDtDeliveryForm3Form4ToVictim(rs.getString("dt_delivery_form3_Form4_to_victim"));
				pdf5Entity.setDocOfDriverOrOwner(rs.getString("doc_of_driver_or_owner"));
				pdf5Entity.setDocOfDriverOrOwnerVerified(rs.getString("doc_of_driver_or_owner_verified"));
				return pdf5Entity;
			}
		});
		SqlParameterSource parameters5b = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(form5FAR, parameters5b, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.equals(null)) {
					do {
						pdf5Entity.setForm5FAR("1");
					} while (rs.next());
				} else {
					pdf5Entity.setForm5FAR("0");
				}
				return pdf5Entity;
			}
		});
		SqlParameterSource parameters5c = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(form5DriverForm, parameters5c, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.equals(null)) {
					do {
						pdf5Entity.setForm5DriverForm("1");
					} while (rs.next());
				} else {
					pdf5Entity.setForm5DriverForm("0");
				}
				return pdf5Entity;
			}
		});
		SqlParameterSource parameters5d = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(form5OwnerForm, parameters5d, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.equals(null)) {
					do {
						pdf5Entity.setForm5OwnerForm("1");
					} while (rs.next());
				} else {
					pdf5Entity.setForm5OwnerForm("0");
				}
				return pdf5Entity;
			}
		});
		SqlParameterSource parameters5e = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(form5Verification, parameters5e, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.equals(null)) {
					do {
						pdf5Entity.setForm5Verification("1");
					} while (rs.next());
				} else {
					pdf5Entity.setForm5Verification("0");
				}
				return pdf5Entity;
			}
		});
		SqlParameterSource parameters5f = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(form5RightsOfVictim, parameters5f, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.equals(null)) {
					do {
						pdf5Entity.setForm5RightsOfVictim("1");
					} while (rs.next());
				} else {
					pdf5Entity.setForm5RightsOfVictim("0");
				}
				return pdf5Entity;
			}
		});
		return pdf5Entity;
	}
///////////////////////////////////////////////////////////////Report 6////////////////////////////////////////////////////////////////////////////

	@Override
	public Pdf6Entity getreport6(String accidentId, String ref_id, String mode, String vehicle_id) {

		Pdf6Entity pdf6Entity = new Pdf6Entity();
		System.out.println(mode);
		System.out.println(ref_id);
		System.out.println(vehicle_id);
		String victims = mode;
		SqlParameterSource parameters = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(GET_ACCIDENT_DETAILS, parameters, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				String date = rs.getString("datetime");

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				String accidentDate = dtf.format(now);
				pdf6Entity.setCurrentDate(accidentDate);
				DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String accidentDate1 = dtf1.format(now);
				pdf6Entity.setFooterDate(accidentDate1);
				pdf6Entity.setAccidentId(rs.getString("accident_id"));
				pdf6Entity.setFirNumber(rs.getString("fir_number"));
				pdf6Entity.setDateTime(date.substring(0, date.indexOf(':')));
				System.out.println(date.substring(0, date.indexOf(':')));
				pdf6Entity.setTimeOfTheDay(date.substring(date.indexOf(':') + 1));
				pdf6Entity.setPsName(rs.getString("psname"));
				pdf6Entity.setLandmarks(rs.getString("landmarks"));
				pdf6Entity.setVehiclesCount(rs.getString("vehicles_count"));
				pdf6Entity.setYear(rs.getString("year"));
				pdf6Entity.setCollisionType(rs.getString("collision_type"));
				pdf6Entity.setState(rs.getString("statename"));
				pdf6Entity.setDistrict(rs.getString("districtname"));
				pdf6Entity.setSection(rs.getString("section"));

				pdf6Entity.setInvestigatingOfficerName(rs.getString("name"));
				pdf6Entity.setInvestigatingOfficerPis(rs.getString("regno"));
				pdf6Entity.setInvestigatingOfficerMobile(rs.getString("mobile"));

				String firtime = rs.getString("firdatetime");

				// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				pdf6Entity.setAct(rs.getString("act"));
				pdf6Entity.setFirDateTime(firtime);

				String reqofficer = rs.getString("reqofficer");
				Object obj = null;
				try {
					obj = new JSONParser().parse(reqofficer);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				// typecasting obj to JSONObject
				JSONObject jo = (JSONObject) obj;
				// getting shoName and shoDesignation
				String shoName = (String) jo.get("name");
				String shoDesignation = (String) jo.get("designation");
				pdf6Entity.setShoName(shoName.toUpperCase());
				pdf6Entity.setShoDesignation(shoDesignation);
				pdf6Entity.setRoadDetails(rs.getString("roaddetails"));

				return pdf6Entity;
			}
		});
		if (victims.equals("pass")) {

			SqlParameterSource parameters6a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("refId", ref_id);
			namedParameterJdbcTemplate.query(passengerSeverity, parameters6a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					pdf6Entity.setInjurySeverity(injurySeverity);
					if (injurySeverity.equals("1")) {
						pdf6Entity.setNatureOfAccident("Fatal");
					} else if (injurySeverity.equals("2")) {
						pdf6Entity.setNatureOfAccident("Simple Injury");
					} else if (injurySeverity.equals("3")) {
						pdf6Entity.setNatureOfAccident("Grievous Injury");
					} else if (injurySeverity.equals("4")) {
						pdf6Entity.setNatureOfAccident("Simple Injury Non Hospitalized");
					} else if (injurySeverity.equals("5")) {
						pdf6Entity.setNatureOfAccident("Any other loss/injury");
					}
					return pdf6Entity;
				}
			});
			SqlParameterSource parameters5 = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("refId", ref_id).addValue("vehicleId", vehicle_id);
			namedParameterJdbcTemplate.query(generalDetails, parameters5, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf6Entity.setVehicle_reg_no(rs.getString("vehicle_reg_no"));
					pdf6Entity.setOwnerAddr(rs.getString("owneraddr"));
					pdf6Entity.setVehOwner(rs.getString("service_ownername"));
					pdf6Entity.setInsuranceDetails(rs.getString("insurance_details"));
					pdf6Entity.setInsurancePolicyno(rs.getString("insurance_policyno"));
					pdf6Entity.setInsuranceValidity(rs.getString("insurance_validity"));
					pdf6Entity.setAcc_id(rs.getString("accident_id"));
					pdf6Entity.setSer_name(rs.getString("drivername"));
					String permanentAddress = rs.getString("ser_permadd1")+"," + rs.getString("ser_permadd2")+","+ rs.getString("ser_permadd3");
					pdf6Entity.setSer_permadd1(permanentAddress);
					pdf6Entity.setBriefDesAccident(rs.getString("brief_description_accident"));
					return pdf6Entity;
				}
			});

			if (pdf6Entity.getInjurySeverity().equals("1") && victims.equals("pass")) {
				SqlParameterSource parameters6d = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(passengerQuery, parameters6d, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						pdf6Entity.setDeceasedName(rs.getString("name"));
						pdf6Entity.setFatherNameOfDeceased(rs.getString("fathername"));
						pdf6Entity.setAgeOfDeceased(rs.getString("age"));
						
						
						String dateOfDeath = rs.getString("dateOfDeath");
						if (dateOfDeath.length() >= 1) {
							String insurancePolicy = dateOfDeath.substring(0, 10);
							pdf6Entity.setDeceasedDeathDate(insurancePolicy);
						} else {
							pdf6Entity.setDeceasedDeathDate("");
						}					
						
						pdf6Entity.setGenderOfDeceased(rs.getString("gender"));
						pdf6Entity.setMaritalstatusOfDeceased(rs.getString("status"));
						pdf6Entity.setOccupationOfDeceased(rs.getString("occupation"));
						pdf6Entity.setInjEmployed(rs.getString("employeed"));
						pdf6Entity.setNameAndAddressOfDeceased(rs.getString("nameadd"));
						pdf6Entity.setIncomeOfDeceased(rs.getString("income"));
						
						pdf6Entity.setAssesedToIncomeTaxDeceased(rs.getString("incometax"));
						
//						String incometax = rs.getString("incometax");
//						if (incometax.equals("t") && !incometax.isEmpty()) {
//							pdf6Entity.setAssesedToIncomeTaxDeceased("Yes");
//						} else if (incometax.equals("f") && !incometax.isEmpty()) {
//							pdf6Entity.setAssesedToIncomeTaxDeceased("No");
//						}
						
						
						pdf6Entity.setSoleEarningMember(rs.getString("soleearning"));
						pdf6Entity.setInjmedicalTrtmnt(rs.getString("treatment"));
						pdf6Entity.setMedicalExpenses(rs.getString("medicalexpenses"));
						pdf6Entity.setReimbursement(rs.getString("cashless_treatment"));
						pdf6Entity.setReimbursementDetails(rs.getString("reimpursement_addional_details"));
						
						return pdf6Entity;
					}
				});
				SqlParameterSource parameters6b = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(passengerFamily, parameters6b, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						pdf6Entity.setDeceasedLegalRepName(rs.getString("name"));
						pdf6Entity.setDeceasedLegalRepAge(rs.getString("age"));
						pdf6Entity.setDeceasedLegalRepGender(rs.getString("gender"));
						pdf6Entity.setDeceasedLegalRepRelation(rs.getString("legalRepRelation"));
						pdf6Entity.setDeceasedLegalRepMaritalStatus(rs.getString("marital_status"));
						pdf6Entity.setDeceasedLegalRepContactNumber(rs.getString("contact_number"));
						pdf6Entity.setDeceasedLegalRepAddress(rs.getString("address"));
						return pdf6Entity;
					}
				});
				SqlParameterSource parameters6c = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(passengerChildDetails, parameters6c, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						pdf6Entity.setNameOfChild(rs.getString("name"));
						pdf6Entity.setAnnualSchoolFee(rs.getString("annual_school_fee"));
						pdf6Entity.setDetailsOfSchool(rs.getString("private_management"));
						pdf6Entity.setDetailsOfClass(rs.getString("school_syllabus"));
						pdf6Entity.setApproxExpenditure(rs.getString("approx_expenditure"));
						return pdf6Entity;
					}
				});
			} else if (pdf6Entity.getInjurySeverity().equals("2") || pdf6Entity.getInjurySeverity().equals("3")
					|| pdf6Entity.getInjurySeverity().equals("4") && victims.equals("pass")) {
				SqlParameterSource parameters6d = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(passInjQuery1, parameters6d, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

						pdf6Entity.setNameOfInjured(rs.getString("name"));
						pdf6Entity.setInjFatherName(rs.getString("fathername"));
						pdf6Entity.setInjAge(rs.getString("age"));
						pdf6Entity.setInjGender(rs.getString("gender"));
						pdf6Entity.setInjContactNumber(rs.getString("mobile"));
						pdf6Entity.setInjMaritalStatus(rs.getString("status"));
						pdf6Entity.setInjOccupation(rs.getString("occupation"));
						pdf6Entity.setInjIncome(rs.getString("income"));

						pdf6Entity.setInjAddress(rs.getString("residence"));
						
						pdf6Entity.setInjEmployed(rs.getString("employeed"));
//						String employed = rs.getString("employeed");
//						if (employed.equals("t") && !employed.isEmpty()) {
//						  pdf6Entity.setInjEmployed("Yes");
//						} else if (employed.equals("f") && !employed.isEmpty()) {
//						  pdf6Entity.setInjEmployed("No");
//						}

						pdf6Entity.setInjEmployerNameAndAddr(rs.getString("nameadd"));
						pdf6Entity.setInjNatureDescription(rs.getString("natureofinjury_description"));
						pdf6Entity.setInjmedicalTrtmnt(rs.getString("hospital_treatment_details"));
						pdf6Entity.setInjdetailsOfSurgery(rs.getString("hospital_treatment_surgery_details"));
						pdf6Entity.setInjpermanentDiability(rs.getString("permanent_disability"));
						pdf6Entity.setInjDiabilityDetails(rs.getString("permanent_disability_details"));

						pdf6Entity.setAssesedToIncomeTaxDeceased(rs.getString("incometax"));

//						String incometax = rs.getString("incometax");
//						if (incometax.equals("t") && !incometax.isEmpty()) {
//						  pdf6Entity.setAssesedToIncomeTaxDeceased("Yes");
//						} else if (incometax.equals("f") && !incometax.isEmpty()) {
//						  pdf6Entity.setAssesedToIncomeTaxDeceased("No");
//						}
						
						pdf6Entity.setInjNatureDescription(rs.getString("natureofinjury_description"));
						pdf6Entity.setInjmedicalTrtmnt(rs.getString("hospital_treatment_details"));
						pdf6Entity.setHpname(rs.getString("hospital_address"));
						pdf6Entity.setDoctor_name(rs.getString("doctor_name"));
						pdf6Entity.setPeriodOfHospitalization(rs.getString("hospital_treatment_period"));
						
						pdf6Entity.setExpenditureOnTreatment(rs.getString("expendiure_on_treatment"));
						pdf6Entity.setTreatmentStillContinuing(rs.getString("estimate_expenditure"));
						pdf6Entity.setExpenditureOnConveyance(rs.getString("expenditure_conveyance"));
						pdf6Entity.setLossOfIncome(rs.getString("lossincome"));
						pdf6Entity.setLossOfEarningCapacity(rs.getString("lossearcapacity"));
						pdf6Entity.setOtherPecuniaryLoss(rs.getString("pecunairy_loss"));
						
						pdf6Entity.setInjuredReimbursement(rs.getString("reimbursement"));
//						pdf6Entity.setInjuredReimbursementDetails(rs.getString(""));
						pdf6Entity.setLossDamageToProperty(rs.getString("loss_to_property"));
						pdf6Entity.setAdditionalInfo(rs.getString("additional_info"));
						pdf6Entity.setValueOfLoss(rs.getString("value_of_loss"));
						pdf6Entity.setCompensationClaimed(rs.getString("compensation_claimed"));
						
						pdf6Entity.setReimbursementDetails(rs.getString("reimpursement_addional_details"));
						return pdf6Entity;
					}
				});
			
				SqlParameterSource parameters6c = new MapSqlParameterSource().addValue("accidentId", accidentId).addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(passengerChildDetails, parameters6c, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						pdf6Entity.setNameOfChild(rs.getString("name"));
						pdf6Entity.setAnnualSchoolFee(rs.getString("annual_school_fee"));
						pdf6Entity.setDetailsOfSchool(rs.getString("private_management"));
						pdf6Entity.setDetailsOfClass(rs.getString("school_syllabus"));
						pdf6Entity.setApproxExpenditure(rs.getString("approx_expenditure"));
						return pdf6Entity;
					}
				});
				SqlParameterSource parameters6l = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(passengerFamily, parameters6l, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						pdf6Entity.setInjLegalRepName(rs.getString("name"));
						pdf6Entity.setInjLegalRepAge(rs.getString("age"));
						pdf6Entity.setInjLegalRepGender(rs.getString("gender"));
						pdf6Entity.setInjLegalRepRelation(rs.getString("legalRepRelation"));
						pdf6Entity.setInjLegalRepMaritalStatus(rs.getString("marital_status"));
						pdf6Entity.setInjLegalRepContactNumber(rs.getString("contact_number"));
						pdf6Entity.setInjLegalRepAddress(rs.getString("address"));
						return pdf6Entity;
					}
				});

			}
			SqlParameterSource parameters6m = new  MapSqlParameterSource().addValue("accidentId", accidentId);
			  namedParameterJdbcTemplate.query(form6Passenger, parameters6m, new RowMapper<Object>() { public Object mapRow(ResultSet rs, int rowNum) throws  SQLException {
				  if (!rs.equals(null)) {
					  do { 
						  JSONParser parser = new JSONParser();
						  Object obj = rs.getObject(1); 
						  System.out.println(rs.getString(1));
						  String result = rs.getString(1);
						  JSONArray array = new JSONArray(result);  
						  for(int i=0; i < array.length(); i++) {  
							  
						  org.json.JSONObject object = array.getJSONObject(i);  
						  
						  System.out.println(object.getString("doc_name")); 
						                                                                                     
						  
						  if(object.getString("doc_name").equalsIgnoreCase("deathcertificate")) { 
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setDeathCertificate("1"); 
							  } else {
								  pdf6Entity.setDeathCertificate("0"); 
							  }
								
							}
						  else if(object.getString("doc_name").equalsIgnoreCase("ageproof")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setAgeProof("1");
							  } else {
								  pdf6Entity.setAgeProof("0");
							  }
							 
						  } else if(object.getString("doc_name").equalsIgnoreCase("occupationproof")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setOccupationProof("1");
							  } else {
								  pdf6Entity.setOccupationProof("0");
							  }
							 
						  } else if(object.getString("doc_name").equalsIgnoreCase("legalrepresentative")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setLegalRep("1");
							  } else {
								  pdf6Entity.setLegalRep("0");
							  }
							 
						  } else if(object.getString("doc_name").equalsIgnoreCase("below18")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setBelow18("1");
							  } else {
								  pdf6Entity.setBelow18("0");
							  }
							  
						  } else if(object.getString("doc_name").equalsIgnoreCase("treatmentrecord")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setTrtmntRecord("1");
							  } else {
								  pdf6Entity.setTrtmntRecord("0");
							  }
							 
						  } else if(object.getString("doc_name").equalsIgnoreCase("bankaccount")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setBankAccnt("1");
							  } else {
								  pdf6Entity.setBankAccnt("0");
							  }
							
						  } else if(object.getString("doc_name").equalsIgnoreCase("reimbursement")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setReimbursementProof("1");
							  } else {
								  pdf6Entity.setReimbursementProof("0");
							  }
							 
						  } else if(object.getString("doc_name").equalsIgnoreCase("other")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setOther("1");
							  } else {
								  pdf6Entity.setOther("0");
							  }
							 
						  } else if(object.getString("doc_name").equalsIgnoreCase("injuredphotographs")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setPhoto("1");
							  } else {
								  pdf6Entity.setPhoto("0");
							  }
							
						  } else if(object.getString("doc_name").equalsIgnoreCase("proofofabsense")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setAbsenseProof("1");
							  } else {
								  pdf6Entity.setAbsenseProof("0");
							  }
							 
						  } else if(object.getString("doc_name").equalsIgnoreCase("incometaxone")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setIncomTax1("1");
							  } else {
								  pdf6Entity.setIncomTax1("0");
							  }
							  
						  } else if(object.getString("doc_name").equalsIgnoreCase("incometaxtwo")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setIncomTax2("1");
							  } else {
								  pdf6Entity.setIncomTax2("0");
							  }
							  
						  } else if(object.getString("doc_name").equalsIgnoreCase("incometaxthree")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setIncomTax3("1");
							  } else {
								  pdf6Entity.setIncomTax3("0");
							  }
							  
						  }
						  } 
						  	          
						    
			  } while (rs.next()); 
			}
			return pdf6Entity; 
			  }
			  });

		} else if (victims.equals("ped")) {

			SqlParameterSource parameters6b = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("refId", ref_id).addValue("vehicleId", vehicle_id);
			namedParameterJdbcTemplate.query(pedestrianSeverity, parameters6b, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = (rs.getString("injury_severity"));
					pdf6Entity.setInjurySeverity(rs.getString("injury_severity"));
					if (injurySeverity.equals("1")) {
						pdf6Entity.setNatureOfAccident("Fatal");
					} else if (injurySeverity.equals("2")) {
						pdf6Entity.setNatureOfAccident("Simple Injury");
					} else if (injurySeverity.equals("3")) {
						pdf6Entity.setNatureOfAccident("Grievous Injury");
					} else if (injurySeverity.equals("4")) {
						pdf6Entity.setNatureOfAccident("Simple Injury Non Hospitalized");
					} else if (injurySeverity.equals("5")) {
						pdf6Entity.setNatureOfAccident("Any other loss/injury");
					}
					return pdf6Entity;
				}
			});
			SqlParameterSource parameters5 = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("refId", ref_id).addValue("vehicleId", vehicle_id);
			namedParameterJdbcTemplate.query(generalDetails, parameters5, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf6Entity.setVehicle_reg_no(rs.getString("vehicle_reg_no"));
					pdf6Entity.setOwnerAddr(rs.getString("owneraddr"));
					pdf6Entity.setVehOwner(rs.getString("service_ownername"));
					pdf6Entity.setInsuranceDetails(rs.getString("insurance_details"));
					pdf6Entity.setInsurancePolicyno(rs.getString("insurance_policyno"));
					pdf6Entity.setInsuranceValidity(rs.getString("insurance_validity"));
					pdf6Entity.setAcc_id(rs.getString("accident_id"));
					pdf6Entity.setSer_name(rs.getString("drivername"));
					String permanentAddress = rs.getString("ser_permadd1")+"," + rs.getString("ser_permadd2")+","+ rs.getString("ser_permadd3");
					pdf6Entity.setSer_permadd1(permanentAddress);
					pdf6Entity.setBriefDesAccident(rs.getString("brief_description_accident"));
					return pdf6Entity;
				}
			});
			if (pdf6Entity.getInjurySeverity().equals("1") && victims.equals("ped")) {
				SqlParameterSource parameters6d = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(pedestrianQuery, parameters6d, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						pdf6Entity.setDeceasedName(rs.getString("name"));
						pdf6Entity.setFatherNameOfDeceased(rs.getString("fathername"));
						pdf6Entity.setAgeOfDeceased(rs.getString("age"));
						String dateOfDeath = rs.getString("dateOfDeath");
						if (dateOfDeath.length() >= 1) {
							String insurancePolicy = dateOfDeath.substring(0, 10);
							pdf6Entity.setDeceasedDeathDate(insurancePolicy);
						} else {
							pdf6Entity.setDeceasedDeathDate("");
						}
						pdf6Entity.setGenderOfDeceased(rs.getString("gender"));
						pdf6Entity.setMaritalstatusOfDeceased(rs.getString("status"));
						pdf6Entity.setOccupationOfDeceased(rs.getString("occupation"));
						pdf6Entity.setInjEmployed(rs.getString("employeed"));
						pdf6Entity.setNameAndAddressOfDeceased(rs.getString("nameadd"));
						pdf6Entity.setIncomeOfDeceased(rs.getString("income"));
						
						pdf6Entity.setAssesedToIncomeTaxDeceased(rs.getString("incometax"));
//						String incometax = rs.getString("incometax");
//						if (incometax.equals("t") && !incometax.isEmpty()) {
//							pdf6Entity.setAssesedToIncomeTaxDeceased("Yes");
//						} else if (incometax.equals("f") && !incometax.isEmpty()) {
//							pdf6Entity.setAssesedToIncomeTaxDeceased("No");
//						}
						pdf6Entity.setSoleEarningMember(rs.getString("soleearning"));
						pdf6Entity.setInjmedicalTrtmnt(rs.getString("treatment"));
						pdf6Entity.setMedicalExpenses(rs.getString("medicalexpenses"));
						pdf6Entity.setReimbursement(rs.getString("cashless_treatment"));
						pdf6Entity.setReimbursementDetails(rs.getString("reimpursement_addional_details"));
						pdf6Entity.setReliefAmount(rs.getString("relief_amount"));
						return pdf6Entity;
					}
				});
				SqlParameterSource parameters6a = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(pedestrianFamily, parameters6a, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						pdf6Entity.setDeceasedLegalRepName(rs.getString("name"));
						pdf6Entity.setDeceasedLegalRepAge(rs.getString("age"));
						pdf6Entity.setDeceasedLegalRepGender(rs.getString("gender"));
						pdf6Entity.setDeceasedLegalRepRelation(rs.getString("legalRepRelation"));
						pdf6Entity.setDeceasedLegalRepMaritalStatus(rs.getString("marital_status"));
						pdf6Entity.setDeceasedLegalRepContactNumber(rs.getString("contact_number"));
						pdf6Entity.setDeceasedLegalRepAddress(rs.getString("address"));
						return pdf6Entity;
					}
				});
				SqlParameterSource parameters6c = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(pedestrianChildDetails, parameters6c, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						pdf6Entity.setNameOfChild(rs.getString("name"));
						pdf6Entity.setAnnualSchoolFee(rs.getString("annual_school_fee"));
						pdf6Entity.setDetailsOfSchool(rs.getString("private_management"));
						pdf6Entity.setDetailsOfClass(rs.getString("school_syllabus"));
						pdf6Entity.setApproxExpenditure(rs.getString("approx_expenditure"));
						return pdf6Entity;
					}
				});
			} else if (pdf6Entity.getInjurySeverity().equals("2") || pdf6Entity.getInjurySeverity().equals("3")
					|| pdf6Entity.getInjurySeverity().equals("4") && victims.equals("ped")) {
				SqlParameterSource parameters6d = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(pedestrianInjQuery, parameters6d, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						pdf6Entity.setNameOfInjured(rs.getString("name"));
						pdf6Entity.setInjFatherName(rs.getString("fathername"));
						pdf6Entity.setInjAge(rs.getString("age"));
						pdf6Entity.setInjGender(rs.getString("gender"));
						pdf6Entity.setInjContactNumber(rs.getString("mobile"));
						pdf6Entity.setInjMaritalStatus(rs.getString("status"));
						pdf6Entity.setInjOccupation(rs.getString("occupation"));
						pdf6Entity.setInjIncome(rs.getString("income"));

						pdf6Entity.setInjAddress(rs.getString("residence"));
						pdf6Entity.setInjEmployed(rs.getString("employeed"));
//						String employed = rs.getString("employeed");
//						if (employed.equals("t") && !employed.isEmpty()) {
//						  pdf6Entity.setInjEmployed("Yes");
//						} else if (employed.equals("f") && !employed.isEmpty()) {
//						  pdf6Entity.setInjEmployed("No");
//						}

						pdf6Entity.setInjEmployerNameAndAddr(rs.getString("nameadd"));
						pdf6Entity.setInjNatureDescription(rs.getString("natureofinjury_description"));
						pdf6Entity.setInjmedicalTrtmnt(rs.getString("hospital_treatment_details"));
						pdf6Entity.setInjdetailsOfSurgery(rs.getString("hospital_treatment_surgery_details"));
						pdf6Entity.setInjpermanentDiability(rs.getString("permanent_disability"));
						pdf6Entity.setInjDiabilityDetails(rs.getString("permanent_disability_details"));

						pdf6Entity.setAssesedToIncomeTaxDeceased(rs.getString("incometax"));

//						String incometax = rs.getString("incometax");
//						if (incometax.equals("t") && !incometax.isEmpty()) {
//						  pdf6Entity.setAssesedToIncomeTaxDeceased("Yes");
//						} else if (incometax.equals("f") && !incometax.isEmpty()) {
//						  pdf6Entity.setAssesedToIncomeTaxDeceased("No");
//						}
						pdf6Entity.setInjNatureDescription(rs.getString("natureofinjury_description"));
						pdf6Entity.setInjmedicalTrtmnt(rs.getString("hospital_treatment_details"));
						pdf6Entity.setHpname(rs.getString("hospital_details"));
						pdf6Entity.setDoctor_name(rs.getString("doctor_name"));
						pdf6Entity.setPeriodOfHospitalization(rs.getString("hospital_treatment_period"));
						pdf6Entity.setExpenditureOnTreatment(rs.getString("expendiure_on_treatment"));
						pdf6Entity.setTreatmentStillContinuing(rs.getString("estimate_expenditure"));
						pdf6Entity.setExpenditureOnConveyance(rs.getString("expenditure_conveyance"));
						pdf6Entity.setOtherPecuniaryLoss(rs.getString("pecunairy_loss"));
						pdf6Entity.setInjuredReimbursement(rs.getString("reimbursement"));
//						pdf6Entity.setInjuredReimbursementDetails(rs.getString(""));
						pdf6Entity.setLossDamageToProperty(rs.getString("loss_to_property"));
						pdf6Entity.setAdditionalInfo(rs.getString("additional_info"));
						pdf6Entity.setValueOfLoss(rs.getString("value_of_loss"));
						
						//pdf6Entity.setCompensationClaimed(rs.getString("compensation_claimed"));
						pdf6Entity.setLossOfIncome(rs.getString("lossincome"));
						pdf6Entity.setLossOfEarningCapacity(rs.getString("lossearcapacity"));
						pdf6Entity.setReimbursementDetails(rs.getString("reimpursement_addional_details"));
						
						int expeditureTreatment=Integer.parseInt(rs.getString("expendiure_on_treatment"));
						int estimateExpenditure=Integer.parseInt(rs.getString("estimate_expenditure"));
						int expeditureConveyance=Integer.parseInt(rs.getString("expenditure_conveyance"));
						int pecunairyLoss=Integer.parseInt(rs.getString("pecunairy_loss"));
						int proprtyToLoss=Integer.parseInt(rs.getString("loss_to_property"));
						int reliefAmount=Integer.parseInt(rs.getString("relief_amount"));
						int lossofincome=Integer.parseInt(rs.getString("lossincome"));
						int lossearcapacity=Integer.parseInt(rs.getString("lossearcapacity"));
						int total=expeditureTreatment+estimateExpenditure+expeditureConveyance+pecunairyLoss+proprtyToLoss+reliefAmount+lossofincome+lossearcapacity;
						pdf6Entity.setCompensationClaimed(String.valueOf(total));
						pdf6Entity.setReimbursementDetails(rs.getString("reimpursement_addional_details"));
						pdf6Entity.setReliefAmount(rs.getString("relief_amount"));
						
						
						return pdf6Entity;
					}
				});


				SqlParameterSource parameters6c = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(pedestrianChildDetails, parameters6c, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						pdf6Entity.setNameOfChild(rs.getString("name"));
						pdf6Entity.setAnnualSchoolFee(rs.getString("annual_school_fee"));
						pdf6Entity.setDetailsOfSchool(rs.getString("private_management"));
						pdf6Entity.setDetailsOfClass(rs.getString("school_syllabus"));
						pdf6Entity.setApproxExpenditure(rs.getString("approx_expenditure"));
						return pdf6Entity;
					}
				});
				SqlParameterSource parameters6l = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(pedestrianFamily, parameters6l, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						pdf6Entity.setInjLegalRepName(rs.getString("name"));
						pdf6Entity.setInjLegalRepAge(rs.getString("age"));
						pdf6Entity.setInjLegalRepGender(rs.getString("gender"));
						pdf6Entity.setInjLegalRepRelation(rs.getString("legalRepRelation"));
						pdf6Entity.setInjLegalRepMaritalStatus(rs.getString("marital_status"));
						pdf6Entity.setInjLegalRepContactNumber(rs.getString("contact_number"));
						pdf6Entity.setInjLegalRepAddress(rs.getString("address"));
						return pdf6Entity;
					}
				});
				
			}
			
			
			
//			SqlParameterSource parameters6m = new  MapSqlParameterSource().addValue("accidentId", accidentId);
//			  namedParameterJdbcTemplate.query(form6Pedestrian, parameters6m, new RowMapper<Object>() { public Object mapRow(ResultSet rs, int rowNum) throws  SQLException {
//				  if (!rs.equals(null)) {
//					  do { 
//						  JSONParser parser = new JSONParser();
//						  Object obj = rs.getObject(1); 
//						  System.out.println(rs.getString(1));
//						  String result = rs.getString(1);
//						  JSONArray array = new JSONArray(result);  
//						  for(int i=0; i < array.length(); i++) {  
//							  
//						  org.json.JSONObject object = array.getJSONObject(i);  
//						  
//						  System.out.println(object.getString("doc_name")); 
//						                                                                                     
//						  if(object.getString("doc_name").equalsIgnoreCase("deathcertificate")) { 
//							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
//								  pdf6Entity.setDeathCertificate("1"); 
//							  } else {
//								  pdf6Entity.setDeathCertificate("0"); 
//							  }
//								
//							}
//						  else if(object.getString("doc_name").equalsIgnoreCase("ageproof")) {
//							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
//								  pdf6Entity.setAgeProof("1");
//							  } else {
//								  pdf6Entity.setAgeProof("0");
//							  }
//							 
//						  } else if(object.getString("doc_name").equalsIgnoreCase("occupationproof")) {
//							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
//								  pdf6Entity.setOccupationProof("1");
//							  } else {
//								  pdf6Entity.setOccupationProof("0");
//							  }
//							 
//						  } else if(object.getString("doc_name").equalsIgnoreCase("legalrepresentative")) {
//							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
//								  pdf6Entity.setLegalRep("1");
//							  } else {
//								  pdf6Entity.setLegalRep("0");
//							  }
//							 
//						  } else if(object.getString("doc_name").equalsIgnoreCase("below18")) {
//							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
//								  pdf6Entity.setBelow18("1");
//							  } else {
//								  pdf6Entity.setBelow18("0");
//							  }
//							  
//						  } else if(object.getString("doc_name").equalsIgnoreCase("treatmentrecord")) {
//							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
//								  pdf6Entity.setTrtmntRecord("1");
//							  } else {
//								  pdf6Entity.setTrtmntRecord("0");
//							  }
//							 
//						  } else if(object.getString("doc_name").equalsIgnoreCase("bankaccount")) {
//							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
//								  pdf6Entity.setBankAccnt("1");
//							  } else {
//								  pdf6Entity.setBankAccnt("0");
//							  }
//							
//						  } else if(object.getString("doc_name").equalsIgnoreCase("reimbursement")) {
//							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
//								  pdf6Entity.setReimbursementProof("1");
//							  } else {
//								  pdf6Entity.setReimbursementProof("0");
//							  }
//							 
//						  } else if(object.getString("doc_name").equalsIgnoreCase("other")) {
//							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
//								  pdf6Entity.setOther("1");
//							  } else {
//								  pdf6Entity.setOther("0");
//							  }
//							 
//						  } else if(object.getString("doc_name").equalsIgnoreCase("injuredphotographs")) {
//							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
//								  pdf6Entity.setPhoto("1");
//							  } else {
//								  pdf6Entity.setPhoto("0");
//							  }
//							
//						  } else if(object.getString("doc_name").equalsIgnoreCase("proofofabsense")) {
//							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
//								  pdf6Entity.setAbsenseProof("1");
//							  } else {
//								  pdf6Entity.setAbsenseProof("0");
//							  }
//							 
//						  } else if(object.getString("doc_name").equalsIgnoreCase("incometaxone")) {
//							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
//								  pdf6Entity.setIncomTax1("1");
//							  } else {
//								  pdf6Entity.setIncomTax1("0");
//							  }
//							  
//						  } else if(object.getString("doc_name").equalsIgnoreCase("incometaxtwo")) {
//							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
//								  pdf6Entity.setIncomTax2("1");
//							  } else {
//								  pdf6Entity.setIncomTax2("0");
//							  }
//							  
//						  } else if(object.getString("doc_name").equalsIgnoreCase("incometaxthree")) {
//							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
//								  pdf6Entity.setIncomTax3("1");
//							  } else {
//								  pdf6Entity.setIncomTax3("0");
//							  }
//							  
//						  }
//						  } 
//						  	          
//						    
//			  } while (rs.next()); 
//			}  return pdf6Entity; 
//			  }
//			  });
			
		} else if (victims.equalsIgnoreCase("veh")) {


			
			SqlParameterSource parameters6a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("refId", ref_id);
			namedParameterJdbcTemplate.query(driverSeverity, parameters6a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					pdf6Entity.setInjurySeverity(injurySeverity);
					if (injurySeverity.equals("1")) {
						pdf6Entity.setNatureOfAccident("Fatal");
					} else if (injurySeverity.equals("2")) {
						pdf6Entity.setNatureOfAccident("Simple Injury");
					} else if (injurySeverity.equals("3")) {
						pdf6Entity.setNatureOfAccident("Grievous Injury");
					} else if (injurySeverity.equals("4")) {
						pdf6Entity.setNatureOfAccident("Simple Injury Non Hospitalized");
					} else if (injurySeverity.equals("5")) {
						pdf6Entity.setNatureOfAccident("Any other loss/injury");
					}
					return pdf6Entity;
				}
			});
			
			
			SqlParameterSource parameters5 = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("refId", ref_id).addValue("vehicleId", vehicle_id);
			namedParameterJdbcTemplate.query(generalDetails, parameters5, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf6Entity.setVehicle_reg_no(rs.getString("vehicle_reg_no"));
					pdf6Entity.setOwnerAddr(rs.getString("owneraddr"));
					pdf6Entity.setVehOwner(rs.getString("service_ownername"));
					pdf6Entity.setInsuranceDetails(rs.getString("insurance_details"));
					pdf6Entity.setInsurancePolicyno(rs.getString("insurance_policyno"));
					pdf6Entity.setInsuranceValidity(rs.getString("insurance_validity"));
					pdf6Entity.setAcc_id(rs.getString("accident_id"));
					pdf6Entity.setSer_name(rs.getString("drivername"));
					String permanentAddress = rs.getString("ser_permadd1")+"," + rs.getString("ser_permadd2")+","+ rs.getString("ser_permadd3");
					pdf6Entity.setSer_permadd1(permanentAddress);
					pdf6Entity.setBriefDesAccident(rs.getString("brief_description_accident"));
					return pdf6Entity;
				}
			});
			if (pdf6Entity.getInjurySeverity().equals("1") && victims.equals("veh")) {

				SqlParameterSource parameters6d = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(driverQuery, parameters6d, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						pdf6Entity.setDeceasedName(rs.getString("name"));
						pdf6Entity.setFatherNameOfDeceased(rs.getString("fathername"));
						pdf6Entity.setAgeOfDeceased(rs.getString("age"));
						String dateOfDeath = rs.getString("dateOfDeath");
						if (dateOfDeath.length() >= 1) {
							String insurancePolicy = dateOfDeath.substring(0, 10);
							pdf6Entity.setDeceasedDeathDate(insurancePolicy);
						} else {
							pdf6Entity.setDeceasedDeathDate("");
						}
						pdf6Entity.setGenderOfDeceased(rs.getString("gender"));
						pdf6Entity.setMaritalstatusOfDeceased(rs.getString("status"));
						pdf6Entity.setOccupationOfDeceased(rs.getString("occupation"));
						pdf6Entity.setInjEmployed(rs.getString("employeed"));
						pdf6Entity.setNameAndAddressOfDeceased(rs.getString("nameadd"));
						pdf6Entity.setIncomeOfDeceased(rs.getString("income"));
						String incometax = rs.getString("incometax");
						if (incometax.equals("t") && !incometax.isEmpty()) {
							pdf6Entity.setAssesedToIncomeTaxDeceased("Yes");
						} else if (incometax.equals("f") && !incometax.isEmpty()) {
							pdf6Entity.setAssesedToIncomeTaxDeceased("No");
						}
						pdf6Entity.setSoleEarningMember(rs.getString("soleearning"));
						pdf6Entity.setInjmedicalTrtmnt(rs.getString("treatment"));
						pdf6Entity.setMedicalExpenses(rs.getString("medicalexpenses"));
						pdf6Entity.setReimbursement(rs.getString("cashless_treatment"));
						pdf6Entity.setReimbursementDetails(rs.getString("reimpursement_addional_details"));
						return pdf6Entity;
					}
				});
				SqlParameterSource parameters6b = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(driverFamily, parameters6b, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						pdf6Entity.setDeceasedLegalRepName(rs.getString("name"));
						pdf6Entity.setDeceasedLegalRepAge(rs.getString("age"));
						pdf6Entity.setDeceasedLegalRepGender(rs.getString("gender"));
						pdf6Entity.setDeceasedLegalRepRelation(rs.getString("legalRepRelation"));
						pdf6Entity.setDeceasedLegalRepMaritalStatus(rs.getString("marital_status"));
						pdf6Entity.setDeceasedLegalRepContactNumber(rs.getString("contact_number"));
						pdf6Entity.setDeceasedLegalRepAddress(rs.getString("address"));
						return pdf6Entity;
					}
				});
				SqlParameterSource parameters6e = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(driverchildDetails, parameters6e, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						pdf6Entity.setNameOfChild(rs.getString("name"));
						pdf6Entity.setAnnualSchoolFee(rs.getString("annual_school_fee"));
						pdf6Entity.setDetailsOfSchool(rs.getString("private_management"));
						pdf6Entity.setDetailsOfClass(rs.getString("school_syllabus"));
						pdf6Entity.setApproxExpenditure(rs.getString("approx_expenditure"));
						return pdf6Entity;
					}
				});
			} else if (pdf6Entity.getInjurySeverity().equals("2") || pdf6Entity.getInjurySeverity().equals("3")
					|| pdf6Entity.getInjurySeverity().equals("4") && victims.equals("driver")) {
				SqlParameterSource parameters6d = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(driverInjQuery, parameters6d, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						pdf6Entity.setNameOfInjured(rs.getString("name"));
						pdf6Entity.setInjFatherName(rs.getString("fathername"));
						pdf6Entity.setInjAge(rs.getString("age"));
						pdf6Entity.setInjGender(rs.getString("gender"));
						pdf6Entity.setInjContactNumber(rs.getString("mobile"));
						pdf6Entity.setInjMaritalStatus(rs.getString("status"));
						pdf6Entity.setInjOccupation(rs.getString("occupation"));
						pdf6Entity.setInjIncome(rs.getString("income"));

						pdf6Entity.setInjAddress(rs.getString("residence"));
						pdf6Entity.setInjEmployed(rs.getString("employeed"));
//						String employed = rs.getString("employeed");
//						if (employed.equals("t") && !employed.isEmpty()) {
//						  pdf6Entity.setInjEmployed("Yes");
//						} else if (employed.equals("f") && !employed.isEmpty()) {
//						  pdf6Entity.setInjEmployed("No");
//						}

						pdf6Entity.setInjEmployerNameAndAddr(rs.getString("nameadd"));
						pdf6Entity.setInjNatureDescription(rs.getString("natureofinjury_description"));
						pdf6Entity.setInjmedicalTrtmnt(rs.getString("hospital_treatment_details"));
						pdf6Entity.setInjdetailsOfSurgery(rs.getString("hospital_treatment_surgery_details"));
						pdf6Entity.setInjpermanentDiability(rs.getString("permanent_disability"));
						pdf6Entity.setInjDiabilityDetails(rs.getString("permanent_disability_details"));
						
						String incometax = rs.getString("incometax");
						if (incometax.equals("t") && !incometax.isEmpty()) {
						  pdf6Entity.setAssesedToIncomeTaxDeceased("Yes");
						} else if (incometax.equals("f") && !incometax.isEmpty()) {
						  pdf6Entity.setAssesedToIncomeTaxDeceased("No");
						}
						pdf6Entity.setInjNatureDescription(rs.getString("natureofinjury_description"));
						pdf6Entity.setInjmedicalTrtmnt(rs.getString("hospital_treatment_details"));
						pdf6Entity.setHpname(rs.getString("hospital_details"));
						pdf6Entity.setDoctor_name(rs.getString("doctor_name"));
						pdf6Entity.setPeriodOfHospitalization(rs.getString("hospital_treatment_period"));
						pdf6Entity.setExpenditureOnTreatment(rs.getString("expendiure_on_treatment"));
						pdf6Entity.setTreatmentStillContinuing(rs.getString("estimate_expenditure"));
						pdf6Entity.setExpenditureOnConveyance(rs.getString("expenditure_conveyance"));
						pdf6Entity.setOtherPecuniaryLoss(rs.getString("pecunairy_loss"));
						pdf6Entity.setInjuredReimbursement(rs.getString("reimbursement"));
//						pdf6Entity.setInjuredReimbursementDetails(rs.getString(""));
						pdf6Entity.setLossDamageToProperty(rs.getString("loss_to_property"));
						pdf6Entity.setAdditionalInfo(rs.getString("additional_info"));
						pdf6Entity.setLossOfIncome(rs.getString("lossincome"));
						pdf6Entity.setLossOfEarningCapacity(rs.getString("lossearcapacity"));
						
						int expeditureTreatment=Integer.parseInt(rs.getString("expendiure_on_treatment"));
						int estimateExpenditure=Integer.parseInt(rs.getString("estimate_expenditure"));
						int expeditureConveyance=Integer.parseInt(rs.getString("expenditure_conveyance"));
						int pecunairyLoss=Integer.parseInt(rs.getString("pecunairy_loss"));
						int proprtyToLoss=Integer.parseInt(rs.getString("loss_to_property"));
						int reliefAmount=Integer.parseInt(rs.getString("relief_amount"));
						int lossofincome=Integer.parseInt(rs.getString("lossincome"));
						int lossearcapacity=Integer.parseInt(rs.getString("lossearcapacity"));
						int total=expeditureTreatment+estimateExpenditure+expeditureConveyance+pecunairyLoss+proprtyToLoss+reliefAmount+lossofincome+lossearcapacity;
						pdf6Entity.setCompensationClaimed(String.valueOf(total));
						pdf6Entity.setReimbursementDetails(rs.getString("reimpursement_addional_details"));
						pdf6Entity.setReliefAmount(rs.getString("relief_amount"));
						
						//int expeditureTreatment=Integer.parseInt(rs.getString("expendiure_on_treatment"));
						pdf6Entity.setValueOfLoss(rs.getString("value_of_loss"));
						pdf6Entity.setCompensationClaimed(rs.getString("compensation_claimed"));	
						
						return pdf6Entity;
					}
				});

			
				SqlParameterSource parameters6c1 = new MapSqlParameterSource().addValue("accidentId", accidentId).addValue("vehicleId", vehicle_id)
						.addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(driverchildDetails, parameters6c1, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						pdf6Entity.setNameOfChild(rs.getString("name"));
						pdf6Entity.setAnnualSchoolFee(rs.getString("annual_school_fee"));
						pdf6Entity.setDetailsOfSchool(rs.getString("private_management"));
						pdf6Entity.setDetailsOfClass(rs.getString("school_syllabus"));
						pdf6Entity.setApproxExpenditure(rs.getString("approx_expenditure"));
						return pdf6Entity;
					}
				});
				SqlParameterSource parameters6l = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("refId", ref_id);
				namedParameterJdbcTemplate.query(driverFamily, parameters6l, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						pdf6Entity.setInjLegalRepName(rs.getString("name"));
						pdf6Entity.setInjLegalRepAge(rs.getString("age"));
						pdf6Entity.setInjLegalRepGender(rs.getString("gender"));
						pdf6Entity.setInjLegalRepRelation(rs.getString("legalRepRelation"));
						pdf6Entity.setInjLegalRepMaritalStatus(rs.getString("marital_status"));
						pdf6Entity.setInjLegalRepContactNumber(rs.getString("contact_number"));
						pdf6Entity.setInjLegalRepAddress(rs.getString("address"));
						return pdf6Entity;
					}
				});		
			
		}
			
			SqlParameterSource parameters6m = new  MapSqlParameterSource().addValue("accidentId", accidentId);
			  namedParameterJdbcTemplate.query(form6Driver, parameters6m, new RowMapper<Object>() { public Object mapRow(ResultSet rs, int rowNum) throws  SQLException {
				  if (!rs.equals(null)) {
					  do { 
						  JSONParser parser = new JSONParser();
						  Object obj = rs.getObject(1); 
						  System.out.println(rs.getString(1));
						  String result = rs.getString(1);
						  JSONArray array = new JSONArray(result);  
						  for(int i=0; i < array.length(); i++) {  
							  
						  org.json.JSONObject object = array.getJSONObject(i);  
						  
						  System.out.println(object.getString("doc_name")); 
						                                                                                     
						  
						  if(object.getString("doc_name").equalsIgnoreCase("deathcertificate")) { 
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setDeathCertificate("1"); 
							  } else {
								  pdf6Entity.setDeathCertificate("0"); 
							  }
								
							}
						  else if(object.getString("doc_name").equalsIgnoreCase("ageproof")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setAgeProof("1");
							  } else {
								  pdf6Entity.setAgeProof("0");
							  }
							 
						  } else if(object.getString("doc_name").equalsIgnoreCase("occupationproof")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setOccupationProof("1");
							  } else {
								  pdf6Entity.setOccupationProof("0");
							  }
							 
						  } else if(object.getString("doc_name").equalsIgnoreCase("legalrepresentative")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setLegalRep("1");
							  } else {
								  pdf6Entity.setLegalRep("0");
							  }
							 
						  } else if(object.getString("doc_name").equalsIgnoreCase("below18")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setBelow18("1");
							  } else {
								  pdf6Entity.setBelow18("0");
							  }
							  
						  } else if(object.getString("doc_name").equalsIgnoreCase("treatmentrecord")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setTrtmntRecord("1");
							  } else {
								  pdf6Entity.setTrtmntRecord("0");
							  }
							 
						  } else if(object.getString("doc_name").equalsIgnoreCase("bankaccount")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setBankAccnt("1");
							  } else {
								  pdf6Entity.setBankAccnt("0");
							  }
							
						  } else if(object.getString("doc_name").equalsIgnoreCase("reimbursement")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setReimbursementProof("1");
							  } else {
								  pdf6Entity.setReimbursementProof("0");
							  }
							 
						  } else if(object.getString("doc_name").equalsIgnoreCase("other")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setOther("1");
							  } else {
								  pdf6Entity.setOther("0");
							  }
							 
						  } else if(object.getString("doc_name").equalsIgnoreCase("injuredphotographs")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setPhoto("1");
							  } else {
								  pdf6Entity.setPhoto("0");
							  }
							
						  } else if(object.getString("doc_name").equalsIgnoreCase("proofofabsense")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setAbsenseProof("1");
							  } else {
								  pdf6Entity.setAbsenseProof("0");
							  }
							 
						  } else if(object.getString("doc_name").equalsIgnoreCase("incometaxone")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setIncomTax1("1");
							  } else {
								  pdf6Entity.setIncomTax1("0");
							  }
							  
						  } else if(object.getString("doc_name").equalsIgnoreCase("incometaxtwo")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setIncomTax2("1");
							  } else {
								  pdf6Entity.setIncomTax2("0");
							  }
							  
						  } else if(object.getString("doc_name").equalsIgnoreCase("incometaxthree")) {
							  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
								  pdf6Entity.setIncomTax3("1");
							  } else {
								  pdf6Entity.setIncomTax3("0");
							  }
							  
						  }
						  } 
						  	          
						    
			  } while (rs.next()); 
			} else { 
				
				pdf6Entity.setForm6DeathCert("0"); 
			} return pdf6Entity; 
			  }
			  });	
		}
		
		   
		 
//		SqlParameterSource parameters6n = new MapSqlParameterSource().addValue("accidentId", accidentId)
//				.addValue("vehicleId", vehicle_id);
//		namedParameterJdbcTemplate.query(form6Pedestrian, parameters6n, new RowMapper<Object>() {
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				if (!rs.equals(null)) {
//					do {
//						pdf6Entity.setForm6DeathCert("1");
//					} while (rs.next());
//				} else {
//					pdf6Entity.setForm6DeathCert("0");
//				}
//				return pdf6Entity;
//			}
//		});
		SqlParameterSource parameters6o = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicle_id);
		namedParameterJdbcTemplate.query(form6Driver, parameters6o, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.equals(null)) {
					do {
						pdf6Entity.setForm6DeathCert("1");
					} while (rs.next());
				} else {
					pdf6Entity.setForm6DeathCert("0");
				}
				return pdf6Entity;
			}
		});
		return pdf6Entity;

	}

///////////////////////////////////////////////////////////////Report 6a////////////////////////////////////////////////////////////////////////////
	@Override
	public Pdf6aEntity getreport6a(String accid, String whoseChild, String user_type) {
		Pdf6aEntity pdf6aEntity = new Pdf6aEntity();
		pdf6aEntity.setStateCode(accid.substring(4, 6));
		SqlParameterSource parameters = new MapSqlParameterSource().addValue("accidentId", accid);
		namedParameterJdbcTemplate.query(GET_ACCIDENT_DETAILS, parameters, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

				String date = rs.getString("datetime");
				Date date1 = new Date();
				Calendar c = Calendar.getInstance();
				c.setTime(date1);
				int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
				int accidentDate = c.get(Calendar.DATE);
				System.out.println(accidentDate);
				pdf6aEntity.setAccidentId(rs.getString("accident_id"));
				pdf6aEntity.setFirNumber(rs.getString("fir_number"));
				pdf6aEntity.setDateTime(date.substring(0, date.indexOf(':')));
				System.out.println(date.substring(0, date.indexOf(':')));

				pdf6aEntity.setPsName(rs.getString("psname"));
				pdf6aEntity.setLandmarks(rs.getString("landmarks"));
				pdf6aEntity.setSection(rs.getString("section"));
				pdf6aEntity.setState(rs.getString("statename"));
				pdf6aEntity.setDistrict(rs.getString("districtname"));
				return pdf6aEntity;
			}
		});
		SqlParameterSource parameters1 = new MapSqlParameterSource().addValue("accidentId", accid).addValue("whoseChild", whoseChild);
		namedParameterJdbcTemplate.query(report6aDocuments, parameters1, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				

				  do { 
					  JSONParser parser = new JSONParser();
					  Object obj = rs.getObject(1); 
					  System.out.println(rs.getString(1));
					  String result = rs.getString(1);
					  JSONArray array = new JSONArray(result);  
					  for(int i=0; i < array.length(); i++) {  
						  
					  org.json.JSONObject object = array.getJSONObject(i);  
					  
					  System.out.println(object.getString("doc_name")); 
					  if(object.getString("doc_name").equalsIgnoreCase("schoolinsid")) { 
						  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
							  pdf6aEntity.setInstitutionId("1"); 
							  
						  } else {
							  pdf6aEntity.setInstitutionId("0"); 
						  }
							
						}
					  else if(object.getString("doc_name").equalsIgnoreCase("adhar")) {
						  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
							  pdf6aEntity.setAadharCard("1");
						  } else {
							  pdf6aEntity.setAadharCard("0");
						  }
						 
					  } else if(object.getString("doc_name").equalsIgnoreCase("educationfee")) {
						  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
							  pdf6aEntity.setEducationFee("1");
						  } else {
							  pdf6aEntity.setEducationFee("0");
						  }
						 
					  } else if(object.getString("doc_name").equalsIgnoreCase("expenses")) {
						  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
							  pdf6aEntity.setOtherExpenses("1");
						  } else {
							  pdf6aEntity.setOtherExpenses("0");
						  }
						 
					  } else if(object.getString("doc_name").equalsIgnoreCase("medicaldocuments")) {
						  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
							  pdf6aEntity.setMedicalDoc("1");
						  } else {
							  pdf6aEntity.setMedicalDoc("0");
						  }
						 
					  } else if(object.getString("doc_name").equalsIgnoreCase("disablitycertificate")) {
						  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
							  pdf6aEntity.setDisabilityCertificate("1");
						  } else {
							  pdf6aEntity.setDisabilityCertificate("0");
						  }
						 
					  } else if(object.getString("doc_name").equalsIgnoreCase("castecertifate")) {
						  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
							  pdf6aEntity.setCasteCertificate("1");
						  } else {
							  pdf6aEntity.setCasteCertificate("0");
						  }
						 
					  } else if(object.getString("doc_name").equalsIgnoreCase("copyofincome")) {
						  if(!object.get("get_edarpersonwisesubmitted").equals(null)) {
							  pdf6aEntity.setIncomeCertificate("1");
						  } else {
							  pdf6aEntity.setIncomeCertificate("0");
						  }
						 
					  }                                                                                    
					  
					   
					  }
				  } while(rs.next());
				return pdf6aEntity;
			}
			});
				
		
		return pdf6aEntity;
	}
///////////////////////////////////////////////////////////////Report 7////////////////////////////////////////////////////////////////////////////

	@Override
	public Pdf7Entity getreport7(String accidentId, String vehicleId, String refId, String mode) {
		Pdf7Entity pdf7Entity = new Pdf7Entity();
		pdf7Entity.setStateCode(accidentId.substring(4, 6));
		List<Object> accidentDetails1 = new ArrayList<>();
		List<DeceasedDetails> passengerdetails = new ArrayList<DeceasedDetails>();
		SqlParameterSource parameters = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(GET_ACCIDENT_DETAILS, parameters, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

				String date = rs.getString("datetime");

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				String accidentDate = dtf.format(now);
				pdf7Entity.setCurrentDate(accidentDate);
				DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String accidentDate1 = dtf1.format(now);
				pdf7Entity.setFooterDate(accidentDate1);				
				pdf7Entity.setAccidentId(rs.getString("accident_id"));
				pdf7Entity.setFirNumber(rs.getString("fir_number"));
				pdf7Entity.setDateTime(date.substring(0, date.indexOf(':')));
				System.out.println(date.substring(0, date.indexOf(':')));
				pdf7Entity.setTimeOfTheDay(date.substring(date.indexOf(':') + 1));
				pdf7Entity.setPsName(rs.getString("psname"));
				pdf7Entity.setLandmarks(rs.getString("landmarks"));
				pdf7Entity.setSection(rs.getString("section"));
				pdf7Entity.setRoadDetails(rs.getString("roaddetails"));
				pdf7Entity.setState(rs.getString("statename"));
				pdf7Entity.setDistrict(rs.getString("districtname"));
				pdf7Entity.setInvestigatingOfficerName(rs.getString("name"));
				pdf7Entity.setInvestigatingOfficerPis(rs.getString("regno"));
				pdf7Entity.setInvestigatingOfficerMobile(rs.getString("mobile"));

				String firtime = rs.getString("firdatetime");
				//accidentDetails.setSection(rs.getString("under_section"));
				pdf7Entity.setSection(rs.getString("section"));
				pdf7Entity.setAct(rs.getString("act"));
				pdf7Entity.setFirDateTime(firtime);

				String reqofficer = rs.getString("reqofficer");
				Object obj = null;
				try {
					obj = new JSONParser().parse(reqofficer);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				// typecasting obj to JSONObject
				JSONObject jo = (JSONObject) obj;
				// getting shoName and shoDesignation
				String shoName = (String) jo.get("name");
				String shoDesignation = (String) jo.get("designation");
				pdf7Entity.setShoName(shoName.toUpperCase());
				pdf7Entity.setShoDesignation(shoDesignation);

				return pdf7Entity;
			}
		});
		
		SqlParameterSource parameters7k = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId).addValue("refId", refId);
			namedParameterJdbcTemplate.query(report7General, parameters7k, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf7Entity.setNatureOfAccident(rs.getString("severity"));
					
					return pdf7Entity;
				}
			});
			SqlParameterSource parameters7 = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId);
			namedParameterJdbcTemplate.query(reminder3, parameters7, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					if(rs!= null) {
						pdf7Entity.setDriverReminderDate(rs.getString("res_datetime"));
					} else {
						pdf7Entity.setDriverReminderDate(rs.getString("res_datetime"));
					}
					
					
					return pdf7Entity;
				}
			});
			SqlParameterSource parameters7b = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId);
			namedParameterJdbcTemplate.query(reminder4, parameters7b, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					if(rs!= null) {
						pdf7Entity.setOwnerReminderDate(rs.getString("res_datetime"));
					} else {
						pdf7Entity.setOwnerReminderDate(rs.getString("res_datetime"));
					}
					
					return pdf7Entity;
				}
			});
			SqlParameterSource parameters7c = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId);
			namedParameterJdbcTemplate.query(reminder6, parameters7c, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					if(rs!= null) {
						pdf7Entity.setVictimRemainderDate(rs.getString("res_datetime"));
					} else {
						pdf7Entity.setVictimRemainderDate(rs.getString("res_datetime"));
					}
					
					return pdf7Entity;
				}
			});
			
		SqlParameterSource parameters7a = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId).addValue("refId", refId);
		String query = null;
		String victim = mode;
		String id = null;
		if (victim.equals("pass")) {

			SqlParameterSource parameters6a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId);
			namedParameterJdbcTemplate.query(passengerSeverity7, parameters6a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf7Entity.setInjurySeverity(rs.getString("injury_severity"));
					
					return pdf7Entity;
				}
			});
			
			SqlParameterSource parameters5 = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId);
			accidentDetails1 = namedParameterJdbcTemplate.query(report7, parameters5, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf7Entity.setVehRegNo(rs.getString("vehicle_reg_no"));
					pdf7Entity.setVehicleMake(rs.getString("vehicle_make"));
					pdf7Entity.setVehicleModel(rs.getString("vehicle_model"));
					pdf7Entity.setVehicleType(rs.getString("vehicle_type"));
					pdf7Entity.setVehicleSubType(rs.getString("vehicleusetype"));
					pdf7Entity.setVictimType(rs.getString("victim_type"));
					pdf7Entity.setOwnername(rs.getString("vehicle_owner"));
					pdf7Entity.setInsurancePolicyno(rs.getString("insurance_policyno"));
					pdf7Entity.setInsuranceValidity(rs.getString("insurance_validity"));
					pdf7Entity.setInsuranceDetails(rs.getString("insurance_details"));
					pdf7Entity.setOwnerAddr(rs.getString("owneraddr"));
					pdf7Entity.setSer_name(rs.getString("ser_name"));
					pdf7Entity.setSerMobileNumber(rs.getString("mobile_no"));
					pdf7Entity.setSer_permadd1(rs.getString("residence"));
					pdf7Entity.setLicense_number(rs.getString("license_number"));
					String drunk = rs.getString("driver_alcohol_usage");
					if (drunk.equals("t") && !drunk.isEmpty()) {
						
						pdf7Entity.setDrunk("Yes");
					} else if (drunk.equals("f") && !drunk.isEmpty()) {
					
						pdf7Entity.setDrunk("No");
					}
					String licenceSuspended = rs.getString("driver_license_suspended");
					String driverInjOrNot = rs.getString("dri_injured_or_not");
					String mobileUsage = rs.getString("driver_mobile_usage");
					String mact = rs.getString("owner_mact");
					String fledFromSpot = rs.getString("owner_driver_ran_ownerproduce");

					String reportedAccident = rs.getString("owner_report_acc");
					if (reportedAccident.equals("t") && !reportedAccident.isEmpty()) {
						pdf7Entity.setOwner_report_acc("Yes");
					} else if (reportedAccident.equals("f") && !reportedAccident.isEmpty()) {
						pdf7Entity.setOwner_report_acc("No");
					}
					if (licenceSuspended.equals("t") && !licenceSuspended.isEmpty()) {
						pdf7Entity.setDriver_license_suspended("Yes");
					} else if (licenceSuspended.equals("f") && !licenceSuspended.isEmpty()) {
						pdf7Entity.setDriver_license_suspended("No");
					}
					if (driverInjOrNot.equals("t") && !driverInjOrNot.isEmpty()) {
						pdf7Entity.setDriverInjuredOrNot("Yes");
					} else if (driverInjOrNot.equals("f") && !driverInjOrNot.isEmpty()) {
						pdf7Entity.setDriverInjuredOrNot("No");
					}
					if (mobileUsage.equals("t") && !mobileUsage.isEmpty()) {
						pdf7Entity.setDriverMobileUsage("Yes");
					} else if (mobileUsage.equals("f") && !mobileUsage.isEmpty()) {
						pdf7Entity.setDriverMobileUsage("No");
					}
					if (mact.equals("t") && !mact.isEmpty()) {
						pdf7Entity.setOwner_mact("Yes");
					} else if (mact.equals("f") && !mact.isEmpty()) {
						pdf7Entity.setOwner_mact("No");
					}
					if (fledFromSpot.equals("t") && !fledFromSpot.isEmpty()) {
						pdf7Entity.setOwner_driver_ran_ownerproduce("Yes");
					} else if (fledFromSpot.equals("f") && !fledFromSpot.isEmpty()) {
						pdf7Entity.setOwner_driver_ran_ownerproduce("No");
					}
					// accidentDetails.setDriverInjuredOrNot(rs.getString("dri_injured_or_not"));
					// accidentDetails.setDriverMobileUsage(rs.getString("driver_mobile_usage"));
					// accidentDetails.setOwner_mact(rs.getString("owner_mact"));
					// accidentDetails.setOwner_driver_ran_ownerproduce(rs.getString("owner_driver_ran_ownerproduce"));

					pdf7Entity.setVehicleDrivenBy(rs.getString("vehicle_driven_by"));
					pdf7Entity.setDriver_imei(rs.getString("driver_imei"));
					pdf7Entity.setDriver_make_model(rs.getString("driver_make_model"));
					pdf7Entity.setVehicleType(rs.getString("vehicle_type"));
					pdf7Entity.setVehicleSubType(rs.getString("vehicleusetype"));
					pdf7Entity.setOwner_mobile_no(rs.getString("owner_mobile_no"));
					pdf7Entity.setDriverLicenseType(rs.getString("drivinglicencetype"));
					pdf7Entity.setDriverFatherName(rs.getString("driver_father_name"));
					pdf7Entity.setOwnerFatherName(rs.getString("owner_father_name"));					
					String licenseValidity = rs.getString("dri_license_validity");
					if (licenseValidity.length() >= 1) {
						String licValidity = licenseValidity.substring(0, 10);
						pdf7Entity.setDriverLicenceValidity(licValidity);
					} else {
						pdf7Entity.setDriverLicenceValidity("");
					}					
					pdf7Entity.setDriverLicensingAuthority(rs.getString("license_verfied"));
					pdf7Entity.setPermitFitnessVerified(rs.getString("permit_fitness_verified"));
//					String permitFitnessVerified = rs.getString("permit_fitness_verified");
//					if (permitFitnessVerified.equals("t") && !permitFitnessVerified.isEmpty()) {
//						pdf7Entity.setPermitFitnessVerified("Yes");
//					} else if (permitFitnessVerified.equalsIgnoreCase("f") && !permitFitnessVerified.isEmpty()) {
//						pdf7Entity.setPermitFitnessVerified("No");
//					}
					pdf7Entity.setPermitFitnessVerifiedReasons(rs.getString("permit_fitness_verified_reasons"));					
					String ownerReportedAcc = rs.getString("owner_report_acc");
					if (ownerReportedAcc.equals("t") && !ownerReportedAcc.isEmpty()) {						
						pdf7Entity.setOwnerReportedAccInsDate("Yes");
					} else if (ownerReportedAcc.equalsIgnoreCase("f") && !ownerReportedAcc.isEmpty()) {						
						pdf7Entity.setOwnerReportedAccInsDate("No");
					}					
					pdf7Entity.setVictimType(rs.getString("victim_type"));
					pdf7Entity.setPermitno(rs.getString("permitno"));
					pdf7Entity.setPermitvalidity(rs.getString("permitvalidity"));
					pdf7Entity.setFitcertval(rs.getString("fitcertval"));
					pdf7Entity.setDriRemainderDate(rs.getString("driver_remainder_date"));
					pdf7Entity.setOwnRemainderDate(rs.getString("owner_remainder_date"));
					pdf7Entity.setVictimRemainderDate(rs.getString("victim_remainder_date"));
					pdf7Entity.setRegAuthRemainderDate(rs.getString("reg_authority_remainder_date"));
					pdf7Entity.setHospitalRemainderDate(rs.getString("hospital_remainder_date"));
					pdf7Entity.setLicenseVerifiedReasons(rs.getString("license_verified_reasons"));					
					pdf7Entity.setLicenseSuspendedDetails(rs.getString("license_suspended_details"));
					pdf7Entity.setDriInjInAccDetails(rs.getString("dri_inj_in_acc_details"));
					pdf7Entity.setScientificReportDetails(rs.getString("scientific_report_details"));
					pdf7Entity.setMactOwnerVehicleFir(rs.getString("mact_owner_vehicle_fir"));
					pdf7Entity.setPermitFitnessVerifiedReason(rs.getString("permit_fitness_verified_reason"));
					pdf7Entity.setOwnerReportedAcctoInsdt(rs.getString("owner_reportedaccto_insdt"));
					pdf7Entity.setBriefDescription(rs.getString("brief_description_accident"));					
					//pdf7Entity.setDriInjuredNot(rs.getString("dri_injured_not"));		
					return pdf7Entity;
				}
			});
			if (accidentDetails1.size() == 0) {
				pdf7Entity.setVehRegNo("Not Applicable");
				pdf7Entity.setVehRegNo("Not Applicable");
				pdf7Entity.setVehicleMake("Not Applicable");
				pdf7Entity.setVehicleModel("Not Applicable");
				pdf7Entity.setVehicleType("Not Applicable");
				pdf7Entity.setVehicleSubType("Not Applicable");
				pdf7Entity.setVictimType("Not Applicable");
				pdf7Entity.setOwnername("Not Applicable");
				pdf7Entity.setInsurancePolicyno("Not Applicable");
				pdf7Entity.setInsuranceValidity("Not Applicable");
				pdf7Entity.setInsuranceDetails("Not Applicable");
				pdf7Entity.setOwnerAddr("Not Applicable");
				pdf7Entity.setSer_name("Not Applicable");
				pdf7Entity.setSerMobileNumber("Not Applicable");
				pdf7Entity.setSer_permadd1("Not Applicable");
				pdf7Entity.setLicense_number("Not Applicable");
				pdf7Entity.setDrunk("Not Applicable");
				pdf7Entity.setSection("Not Applicable");
				String licenceSuspended = "Not Applicable";
				String driverInjOrNot = "Not Applicable";
				String mobileUsage = "Not Applicable";
				String mact = "Not Applicable";
				String fledFromSpot = "Not Applicable";
				pdf7Entity.setDriver_license_suspended("Not Applicable");
				pdf7Entity.setDriverInjuredOrNot("Not Applicable");
				pdf7Entity.setDriverMobileUsage("Not Applicable");
				pdf7Entity.setOwner_mact("Not Applicable");
				pdf7Entity.setOwner_driver_ran_ownerproduce("Not Applicable");
				pdf7Entity.setVehicleDrivenBy("Not Applicable");
				pdf7Entity.setDriver_imei("Not Applicable");
				pdf7Entity.setDriver_make_model("Not Applicable");
				pdf7Entity.setVehicleType("Not Applicable");
				pdf7Entity.setVehicleSubType("Not Applicable");
				pdf7Entity.setOwner_mobile_no("Not Applicable");
				pdf7Entity.setDriverLicenseType("Not Applicable");
				pdf7Entity.setDriverFatherName("Not Applicable");
				pdf7Entity.setOwnerFatherName("Not Applicable");
				pdf7Entity.setDriverLicenceValidity("Not Applicable");
				pdf7Entity.setDriverLicensingAuthority("Not Applicable");
				pdf7Entity.setPermitFitnessVerified("Not Applicable");
				pdf7Entity.setPermitFitnessVerifiedReasons("Not Applicable");
				pdf7Entity.setOwnerReportedAccInsDate("Not Applicable");
				pdf7Entity.setVictimType("Not Applicable");
				pdf7Entity.setPermitno("Not Applicable");
				pdf7Entity.setPermitvalidity("Not Applicable");
				pdf7Entity.setFitcertval("Not Applicable");
				pdf7Entity.setDriRemainderDate("Not Applicable");
				pdf7Entity.setOwnRemainderDate("Not Applicable");
				pdf7Entity.setVictimRemainderDate("Not Applicable");
				pdf7Entity.setRegAuthRemainderDate("Not Applicable");
				pdf7Entity.setHospitalRemainderDate("Not Applicable");
//				return accidentDetails;
			}
			if (pdf7Entity.getInjurySeverity().equals("1") && !pdf7Entity.getInjurySeverity().equals(null)) {
				namedParameterJdbcTemplate.query(passengerquery7, parameters7a, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						do {
							DeceasedDetails passengerDeceasedDetails = new DeceasedDetails();
							passengerDeceasedDetails.setId(rs.getString("id"));
							passengerDeceasedDetails.setInjurySeverity(rs.getString("injurySeverity"));							
							passengerDeceasedDetails.setVehicle_id(rs.getString("vehicleId"));
							passengerDeceasedDetails.setRef_id(rs.getString("refId"));
							passengerDeceasedDetails.setLegalRepName(rs.getString("legalRepName"));
							passengerDeceasedDetails.setLegalRepRelation(rs.getString("legalRepRelation"));
							passengerDeceasedDetails.setLegalRepAge(rs.getString("legalRepAge"));
							passengerdetails.add(passengerDeceasedDetails);
							pdf7Entity.setDeceasedDetails(passengerdetails);
							pdf7Entity.setNameOfDeceased(rs.getString("nameOfDeceased"));
							pdf7Entity.setAgeOfDeceased(rs.getString("ageOfDeceased"));
							pdf7Entity.setOccupationOfDeceased(rs.getString("occupationOfDeceased"));
						} while (rs.next());
						return pdf7Entity;
					}
				});
			} else if (pdf7Entity.getInjurySeverity().equals("2") || pdf7Entity.getInjurySeverity().equals("3")|| pdf7Entity.getInjurySeverity().equals("4")) {

				String passengerquery1 = "select a.accident_id,a.id as id,a.name as nameOfInjured,a.age as ageOfInjured,master.get_occupation(a.occupation,'') as occupationOfInjured,\r\n"
						+ "a.vehicle_id as vehicleId,b.ref_id as refId,b.name as legalRepName,b.age as legalRepAge,b.relation_type as legalRepRelation,"
						+ "master.get_severity(a.injury_severity) as injurySeverity,master.get_injury_type(a.pass_injurytype,'') as pass_injurytype from irad_passenger a\r\n"
						+ "inner join dar_family_details b on a.accident_id=:accidentId and a.vehicle_id=:vehicleId and b.acc_id=a.accident_id and a.id=b.ref_id::integer";

				namedParameterJdbcTemplate.query(passengerquery1, parameters7a, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						do {
							InjuredDetails passengerInjuredDetails = new InjuredDetails();							
						//	passengerInjuredDetails.setNatureOfInjury(rs.getString("injurySeverity"));
							passengerInjuredDetails.setDetailsOfInjury(rs.getString("pass_injurytype"));
							// accidentDetails.setSection(rs.getString("under_section"));
							// passengerdetails.add(passengerInjuredDetails);
							pdf7Entity.setInjuryDetails(passengerInjuredDetails);
							pdf7Entity.setNameOfInjured(rs.getString("nameOfInjured"));
							pdf7Entity.setAgeOfInjured(rs.getString("ageOfInjured"));
							pdf7Entity.setOccupationOfInjured(rs.getString("occupationOfInjured"));
							pdf7Entity.setNatureOfInjuryInjured(rs.getString("injurySeverity"));
							pdf7Entity.setDetailsOfInjuryInjured(rs.getString("pass_injurytype"));
						} while (rs.next());

						return pdf7Entity;
					}
				});
			}
		} else if (victim.equals("ped")) {
			// String accidentId, String vehicleId,String refId,String mode
//			String pedestrianquery = "select a.id,a.injury_severity,a.name,a.age,a.occupation,b.ref_id,b.name,b.age,b.relation_type from irad_pedestrian a inner join dar_family_details b on a.accident_id=:accidentId and a.id=:refId::integer and b.acc_id=a.accident_id and b.ref_id=:refId";
//			SqlParameterSource parameters5 = new MapSqlParameterSource().addValue("accidentId", accidentId).addValue("refId", refId);

			SqlParameterSource parameters7ped = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId);
			namedParameterJdbcTemplate.query(pedestrianSeverity7, parameters7ped, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf7Entity.setInjurySeverity(rs.getString("injury_severity"));
					return pdf7Entity;
				}
			});
			
			SqlParameterSource parameters71ped = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId);
			accidentDetails1 = namedParameterJdbcTemplate.query(report7, parameters71ped, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf7Entity.setVehRegNo(rs.getString("vehicle_reg_no"));
					pdf7Entity.setVehicleMake(rs.getString("vehicle_make"));
					pdf7Entity.setVehicleModel(rs.getString("vehicle_model"));
					pdf7Entity.setVehicleType(rs.getString("vehicle_type"));
					pdf7Entity.setVehicleSubType(rs.getString("vehicleusetype"));
					pdf7Entity.setVictimType(rs.getString("victim_type"));
					pdf7Entity.setOwnername(rs.getString("vehicle_owner"));
					pdf7Entity.setInsurancePolicyno(rs.getString("insurance_policyno"));
					pdf7Entity.setInsuranceValidity(rs.getString("insurance_validity"));
					pdf7Entity.setInsuranceDetails(rs.getString("insurance_details"));
					pdf7Entity.setOwnerAddr(rs.getString("owneraddr"));
					pdf7Entity.setSer_name(rs.getString("ser_name"));
					pdf7Entity.setSerMobileNumber(rs.getString("mobile_no"));
					pdf7Entity.setSer_permadd1(rs.getString("residence"));
					pdf7Entity.setLicense_number(rs.getString("license_number"));
					String drunk = rs.getString("driver_alcohol_usage");
					if (drunk.equals("t") && !drunk.isEmpty()) {
						
						pdf7Entity.setDrunk("Yes");
					} else if (drunk.equals("f") && !drunk.isEmpty()) {
					
						pdf7Entity.setDrunk("No");
					}
					// accidentDetails.setSection(rs.getString("under_section"));
					String licenceSuspended = rs.getString("driver_license_suspended");
					String driverInjOrNot = rs.getString("dri_injured_or_not");
					String mobileUsage = rs.getString("driver_mobile_usage");
					String mact = rs.getString("owner_mact");
					String fledFromSpot = rs.getString("owner_driver_ran_ownerproduce");

					String reportedAccident = rs.getString("owner_report_acc");
					if (reportedAccident.equals("t") && !reportedAccident.isEmpty()) {
						pdf7Entity.setOwner_report_acc("Yes");
					} else if (reportedAccident.equals("f") && !reportedAccident.isEmpty()) {
						pdf7Entity.setOwner_report_acc("No");
					}
					if (licenceSuspended.equals("t") && !licenceSuspended.isEmpty()) {
						pdf7Entity.setDriver_license_suspended("Yes");
					} else if (licenceSuspended.equals("f") && !licenceSuspended.isEmpty()) {
						pdf7Entity.setDriver_license_suspended("No");
					}
					if (driverInjOrNot.equals("t") && !driverInjOrNot.isEmpty()) {
						pdf7Entity.setDriverInjuredOrNot("Yes");
					} else if (driverInjOrNot.equals("f") && !driverInjOrNot.isEmpty()) {
						pdf7Entity.setDriverInjuredOrNot("No");
					}
					if (mobileUsage.equals("t") && !mobileUsage.isEmpty()) {
						pdf7Entity.setDriverMobileUsage("Yes");
					} else if (mobileUsage.equals("f") && !mobileUsage.isEmpty()) {
						pdf7Entity.setDriverMobileUsage("No");
					}
					if (mact.equals("t") && !mact.isEmpty()) {
						pdf7Entity.setOwner_mact("Yes");
					} else if (mact.equals("f") && !mact.isEmpty()) {
						pdf7Entity.setOwner_mact("No");
					}
					if (fledFromSpot.equals("t") && !fledFromSpot.isEmpty()) {
						pdf7Entity.setOwner_driver_ran_ownerproduce("Yes");
					} else if (fledFromSpot.equals("f") && !fledFromSpot.isEmpty()) {
						pdf7Entity.setOwner_driver_ran_ownerproduce("No");
					}
					// accidentDetails.setDriverInjuredOrNot(rs.getString("dri_injured_or_not"));
					// accidentDetails.setDriverMobileUsage(rs.getString("driver_mobile_usage"));
					// accidentDetails.setOwner_mact(rs.getString("owner_mact"));
					// accidentDetails.setOwner_driver_ran_ownerproduce(rs.getString("owner_driver_ran_ownerproduce"));
					pdf7Entity.setVehicleDrivenBy(rs.getString("vehicle_driven_by"));
					pdf7Entity.setDriver_imei(rs.getString("driver_imei"));
					pdf7Entity.setDriver_make_model(rs.getString("driver_make_model"));
					pdf7Entity.setVehicleType(rs.getString("vehicle_type"));
					pdf7Entity.setVehicleSubType(rs.getString("vehicleusetype"));
					pdf7Entity.setOwner_mobile_no(rs.getString("owner_mobile_no"));
					pdf7Entity.setDriverLicenseType(rs.getString("drivinglicencetype"));
					pdf7Entity.setDriverFatherName(rs.getString("driver_father_name"));
					pdf7Entity.setOwnerFatherName(rs.getString("owner_father_name"));
					
					String licenseValidity = rs.getString("dri_license_validity");
					if (licenseValidity.length() >= 1) {
						String licValidity = licenseValidity.substring(0, 10);
						pdf7Entity.setDriverLicenceValidity(licValidity);
					} else {
						pdf7Entity.setDriverLicenceValidity("");
					}
					
					pdf7Entity.setBriefDescription(rs.getString("brief_description_accident"));
					pdf7Entity.setDriverLicensingAuthority(rs.getString("license_verfied"));
					pdf7Entity.setPermitFitnessVerified(rs.getString("permit_fitness_verified"));
//					String permitFitnessVerified = rs.getString("permit_fitness_verified");
//					if (permitFitnessVerified.equals("t") && !permitFitnessVerified.isEmpty()) {
//						pdf7Entity.setPermitFitnessVerified("Yes");
//					} else if (permitFitnessVerified.equalsIgnoreCase("f") && !permitFitnessVerified.isEmpty()) {
//						pdf7Entity.setPermitFitnessVerified("No");
//					}

					pdf7Entity.setPermitFitnessVerifiedReasons(rs.getString("permit_fitness_verified_reasons"));
					String ownerReportedAcc = rs.getString("owner_report_acc");
					if (ownerReportedAcc.equals("t") && !ownerReportedAcc.isEmpty()) {
						
						pdf7Entity.setOwnerReportedAccInsDate("Yes");
					} else if (ownerReportedAcc.equalsIgnoreCase("f") && !ownerReportedAcc.isEmpty()) {
						
						pdf7Entity.setOwnerReportedAccInsDate("No");
					}
					pdf7Entity.setVictimType(rs.getString("victim_type"));
					pdf7Entity.setPermitno(rs.getString("permitno"));
					pdf7Entity.setPermitvalidity(rs.getString("permitvalidity"));
					pdf7Entity.setFitcertval(rs.getString("fitcertval"));
					pdf7Entity.setDriRemainderDate(rs.getString("driver_remainder_date"));
					pdf7Entity.setOwnRemainderDate(rs.getString("owner_remainder_date"));
					pdf7Entity.setVictimRemainderDate(rs.getString("victim_remainder_date"));
					pdf7Entity.setRegAuthRemainderDate(rs.getString("reg_authority_remainder_date"));
					pdf7Entity.setHospitalRemainderDate(rs.getString("hospital_remainder_date"));
					pdf7Entity.setLicenseVerifiedReasons(rs.getString("license_verified_reasons"));
					pdf7Entity.setLicenseSuspendedDetails(rs.getString("license_suspended_details"));
					pdf7Entity.setDriInjInAccDetails(rs.getString("dri_inj_in_acc_details"));
					pdf7Entity.setScientificReportDetails(rs.getString("scientific_report_details"));
					pdf7Entity.setMactOwnerVehicleFir(rs.getString("mact_owner_vehicle_fir"));
					pdf7Entity.setPermitFitnessVerifiedReason(rs.getString("permit_fitness_verified_reason"));
					pdf7Entity.setOwnerReportedAcctoInsdt(rs.getString("owner_reportedaccto_insdt"));
					//pdf7Entity.setDriInjuredNot(rs.getString("dri_injured_not"));
					pdf7Entity.setNameOfDeceased(rs.getString("ser_name"));
					pdf7Entity.setAgeOfDeceased(rs.getString("age"));
					pdf7Entity.setOccupationOfDeceased(rs.getString("occupation"));
					return pdf7Entity;
				}
			});

			if (accidentDetails1.size() == 0) {
				pdf7Entity.setVehRegNo("Not Applicable");
				pdf7Entity.setVehRegNo("Not Applicable");
				pdf7Entity.setVehicleMake("Not Applicable");
				pdf7Entity.setVehicleModel("Not Applicable");
				pdf7Entity.setVehicleType("Not Applicable");
				pdf7Entity.setVehicleSubType("Not Applicable");
				pdf7Entity.setVictimType("Not Applicable");
				pdf7Entity.setOwnername("Not Applicable");
				pdf7Entity.setInsurancePolicyno("Not Applicable");
				pdf7Entity.setInsuranceValidity("Not Applicable");
				pdf7Entity.setInsuranceDetails("Not Applicable");
				pdf7Entity.setOwnerAddr("Not Applicable");
				pdf7Entity.setSer_name("Not Applicable");
				pdf7Entity.setSerMobileNumber("Not Applicable");
				pdf7Entity.setSer_permadd1("Not Applicable");
				pdf7Entity.setLicense_number("Not Applicable");
				pdf7Entity.setDrunk("Not Applicable");
				pdf7Entity.setSection("Not Applicable");
				String licenceSuspended = "Not Applicable";
				String driverInjOrNot = "Not Applicable";
				String mobileUsage = "Not Applicable";
				String mact = "Not Applicable";
				String fledFromSpot = "Not Applicable";

				if (licenceSuspended.equals("t") && !licenceSuspended.isEmpty()) {
					pdf7Entity.setDriver_license_suspended("Not Applicable");
				} else if (licenceSuspended.equals("f") && !licenceSuspended.isEmpty()) {
					pdf7Entity.setDriver_license_suspended("No");
				}
				pdf7Entity.setDriverInjuredOrNot("Not Applicable");
				pdf7Entity.setDriverMobileUsage("Not Applicable");
				pdf7Entity.setOwner_mact("Not Applicable");
				pdf7Entity.setOwner_driver_ran_ownerproduce("Not Applicable");
				// accidentDetails.setDriverInjuredOrNot(rs.getString("dri_injured_or_not"));
				// accidentDetails.setDriverMobileUsage(rs.getString("driver_mobile_usage"));
				// accidentDetails.setOwner_mact(rs.getString("owner_mact"));
				// accidentDetails.setOwner_driver_ran_ownerproduce(rs.getString("owner_driver_ran_ownerproduce"));
				pdf7Entity.setVehicleDrivenBy("Not Applicable");
				pdf7Entity.setDriver_imei("Not Applicable");
				pdf7Entity.setDriver_make_model("Not Applicable");
				pdf7Entity.setVehicleType("Not Applicable");
				pdf7Entity.setVehicleSubType("Not Applicable");
				pdf7Entity.setOwner_mobile_no("Not Applicable");
				pdf7Entity.setDriverLicenseType("Not Applicable");
				pdf7Entity.setDriverFatherName("Not Applicable");
				pdf7Entity.setOwnerFatherName("Not Applicable");
				pdf7Entity.setDriverLicenceValidity("Not Applicable");
				pdf7Entity.setDriverLicensingAuthority("Not Applicable");
				pdf7Entity.setPermitFitnessVerified("Not Applicable");
				pdf7Entity.setPermitFitnessVerifiedReasons("Not Applicable");
				pdf7Entity.setOwnerReportedAccInsDate("Not Applicable");
				pdf7Entity.setVictimType("Not Applicable");
				pdf7Entity.setPermitno("Not Applicable");
				pdf7Entity.setPermitvalidity("Not Applicable");
				pdf7Entity.setFitcertval("Not Applicable");
				pdf7Entity.setDriRemainderDate("Not Applicable");
				pdf7Entity.setOwnRemainderDate("Not Applicable");
				pdf7Entity.setVictimRemainderDate("Not Applicable");
				pdf7Entity.setRegAuthRemainderDate("Not Applicable");
				pdf7Entity.setHospitalRemainderDate("Not Applicable");

				return pdf7Entity;
			}

			if (pdf7Entity.getInjurySeverity().equals("1")) {
				namedParameterJdbcTemplate.query(pedestrianquery7, parameters7a, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						do {
							DeceasedDetails pedestrianDeceasedDetails = new DeceasedDetails();
							pedestrianDeceasedDetails.setId(rs.getString("id"));
							pedestrianDeceasedDetails.setInjurySeverity(rs.getString("injurySeverity"));
//							pedestrianDeceasedDetails.setNameOfDeceased(rs.getString("nameOfDeceased"));
//							pedestrianDeceasedDetails.setAgeOfDeceased(rs.getString("ageOfDeceased"));
//							pedestrianDeceasedDetails.setOccupationOfDeceased(rs.getString("occupationOfDeceased"));
							pedestrianDeceasedDetails.setVehicle_id(rs.getString("vehicleId"));
							pedestrianDeceasedDetails.setRef_id(rs.getString("refId"));
							pedestrianDeceasedDetails.setLegalRepName(rs.getString("legalRepName"));
							pedestrianDeceasedDetails.setLegalRepRelation(rs.getString("legalRepRelation"));
							pedestrianDeceasedDetails.setLegalRepAge(rs.getString("legalRepAge"));
							passengerdetails.add(pedestrianDeceasedDetails);
							pdf7Entity.setDeceasedDetails(passengerdetails);
							pdf7Entity.setNameOfDeceased(rs.getString("nameOfDeceased"));
							pdf7Entity.setAgeOfDeceased(rs.getString("ageOfDeceased"));
							pdf7Entity.setOccupationOfDeceased(rs.getString("occupationOfDeceased"));
						} while (rs.next());

						return passengerdetails;
					}
				});
			} else if (pdf7Entity.getInjurySeverity().equals("2") || pdf7Entity.getInjurySeverity().equals("3")
					|| pdf7Entity.getInjurySeverity().equals("4")) {
				InjuredDetails pedestrianInjuredDetails = new InjuredDetails();
				pedestrianInjuredDetails.setNameOfInjured(id);

				String pedestrianquery1 = "select a.accident_id,a.id as id,a.name as nameOfInjured,a.age as ageOfInjured,master.get_occupation(a.occupation,'') as occupationOfInjured,"
						+ "a.vehicle_id as vehicleId,b.ref_id as refId,b.name as legalRepName,b.age as legalRepAge,master.get_severity(a.injury_severity) as injurySeverity,"
						+ "master.get_injury_type(a.ped_injurytype,'') as ped_injurytype,b.relation_type as legalRepRelation from irad_pedestrian a inner join dar_family_details b "
						+ "on a.accident_id=:accidentId and  a.injury_severity IN ('4', '2', '3') and a.vehicle_id=:vehicleId and a.id=:refId::integer and b.acc_id=a.accident_id and b.ref_id=:refId";

				namedParameterJdbcTemplate.query(pedestrianquery1, parameters7a, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						do {

							InjuredDetails pedestrianInjuredDetails = new InjuredDetails();
							
							
							pedestrianInjuredDetails.setDetailsOfInjury(rs.getString("ped_injurytype"));
//							pdf7Entity.setSection(rs.getString("under_section"));
							// pedestriandetails.add(pedestrianInjuredDetails);
							pdf7Entity.setInjuryDetails(pedestrianInjuredDetails);
							pdf7Entity.setNameOfInjured(rs.getString("nameOfInjured"));
							pdf7Entity.setAgeOfInjured(rs.getString("ageOfInjured"));
							pdf7Entity.setOccupationOfInjured(rs.getString("occupationOfInjured"));
							pdf7Entity.setNatureOfInjuryInjured(rs.getString("injurySeverity"));
							pdf7Entity.setDetailsOfInjuryInjured(rs.getString("ped_injurytype"));

						} while (rs.next());

						return passengerdetails;
					}
				});

			}
		} else if (victim.equals("veh")) {

			SqlParameterSource parameters7veh = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId);
			namedParameterJdbcTemplate.query(driverSeverity7, parameters7veh, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf7Entity.setInjurySeverity(rs.getString("injury_severity"));
					return pdf7Entity;
				}
			});
			
//			driverquery
			SqlParameterSource parameters5 = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId);
			accidentDetails1 = namedParameterJdbcTemplate.query(report7, parameters5, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf7Entity.setVehRegNo(rs.getString("vehicle_reg_no"));
					pdf7Entity.setVehicleMake(rs.getString("vehicle_make"));
					pdf7Entity.setVehicleModel(rs.getString("vehicle_model"));
					pdf7Entity.setVehicleType(rs.getString("vehicle_type"));
					pdf7Entity.setVehicleSubType(rs.getString("vehicleusetype"));
					pdf7Entity.setVictimType(rs.getString("victim_type"));
					pdf7Entity.setOwnername(rs.getString("vehicle_owner"));
					pdf7Entity.setInsurancePolicyno(rs.getString("insurance_policyno"));
					pdf7Entity.setInsuranceValidity(rs.getString("insurance_validity"));
					pdf7Entity.setInsuranceDetails(rs.getString("insurance_details"));
					pdf7Entity.setOwnerAddr(rs.getString("owneraddr"));
					pdf7Entity.setSer_name(rs.getString("ser_name"));
					pdf7Entity.setSerMobileNumber(rs.getString("mobile_no"));
					pdf7Entity.setSer_permadd1(rs.getString("residence"));
					pdf7Entity.setLicense_number(rs.getString("license_number"));
					String drunk = rs.getString("driver_alcohol_usage");
					if (drunk.equals("t") && !drunk.isEmpty()) {
						
						pdf7Entity.setDrunk("Yes");
					} else if (drunk.equals("f") && !drunk.isEmpty()) {
					
						pdf7Entity.setDrunk("No");
					}
					String licenceSuspended = rs.getString("driver_license_suspended");
					String driverInjOrNot = rs.getString("dri_injured_or_not");
					String mobileUsage = rs.getString("driver_mobile_usage");
					String mact = rs.getString("owner_mact");
					String fledFromSpot = rs.getString("owner_driver_ran_ownerproduce");
					String reportedAccident = rs.getString("owner_report_acc");
					if (reportedAccident.equals("t") && !reportedAccident.isEmpty()) {
						pdf7Entity.setOwner_report_acc("Yes");
					} else if (reportedAccident.equals("f") && !reportedAccident.isEmpty()) {
						pdf7Entity.setOwner_report_acc("No");
					}
					if (licenceSuspended.equals("t") && !licenceSuspended.isEmpty()) {
						pdf7Entity.setDriver_license_suspended("Yes");
					} else if (licenceSuspended.equals("f") && !licenceSuspended.isEmpty()) {
						pdf7Entity.setDriver_license_suspended("No");
					}
					if (driverInjOrNot.equals("t") && !driverInjOrNot.isEmpty()) {
						pdf7Entity.setDriverInjuredOrNot("Yes");
					} else if (driverInjOrNot.equals("f") && !driverInjOrNot.isEmpty()) {
						pdf7Entity.setDriverInjuredOrNot("No");
					}
					if (mobileUsage.equals("t") && !mobileUsage.isEmpty()) {
						pdf7Entity.setDriverMobileUsage("Yes");
					} else if (mobileUsage.equals("f") && !mobileUsage.isEmpty()) {
						pdf7Entity.setDriverMobileUsage("No");
					}
					if (mact.equals("t") && !mact.isEmpty()) {
						pdf7Entity.setOwner_mact("Yes");
					} else if (mact.equals("f") && !mact.isEmpty()) {
						pdf7Entity.setOwner_mact("No");
					}
					if (fledFromSpot.equals("t") && !fledFromSpot.isEmpty()) {
						pdf7Entity.setOwner_driver_ran_ownerproduce("Yes");
					} else if (fledFromSpot.equals("f") && !fledFromSpot.isEmpty()) {
						pdf7Entity.setOwner_driver_ran_ownerproduce("No");
					}
					// accidentDetails.setDriverInjuredOrNot(rs.getString("dri_injured_or_not"));
					// accidentDetails.setDriverMobileUsage(rs.getString("driver_mobile_usage"));
					// accidentDetails.setOwner_mact(rs.getString("owner_mact"));
					// accidentDetails.setOwner_driver_ran_ownerproduce(rs.getString("owner_driver_ran_ownerproduce"));
					pdf7Entity.setVehicleDrivenBy(rs.getString("vehicle_driven_by"));
					pdf7Entity.setDriver_imei(rs.getString("driver_imei"));
					pdf7Entity.setDriver_make_model(rs.getString("driver_make_model"));
					pdf7Entity.setVehicleType(rs.getString("vehicle_type"));
					
					pdf7Entity.setOwner_mobile_no(rs.getString("owner_mobile_no"));
					pdf7Entity.setDriverLicenseType(rs.getString("drivinglicencetype"));
					pdf7Entity.setDriverFatherName(rs.getString("driver_father_name"));
					pdf7Entity.setOwnerFatherName(rs.getString("owner_father_name"));
					String licenseValidity = rs.getString("dri_license_validity");
					if (licenseValidity.length() >= 1) {
						String licValidity = licenseValidity.substring(0, 10);
						pdf7Entity.setDriverLicenceValidity(licValidity);
					} else {
						pdf7Entity.setDriverLicenceValidity("");
					}
					pdf7Entity.setDriverLicensingAuthority(rs.getString("license_verfied"));
					pdf7Entity.setPermitFitnessVerified(rs.getString("permit_fitness_verified"));
					pdf7Entity.setBriefDescription(rs.getString("brief_description_accident"));
//					String permitFitnessVerified = rs.getString("permit_fitness_verified");
//					if (permitFitnessVerified.equals("t") && !permitFitnessVerified.isEmpty()) {
//						pdf7Entity.setPermitFitnessVerified("Yes");
//					} else if (permitFitnessVerified.equalsIgnoreCase("f") && !permitFitnessVerified.isEmpty()) {
//						pdf7Entity.setPermitFitnessVerified("No");
//					}

					pdf7Entity.setPermitFitnessVerifiedReasons(rs.getString("permit_fitness_verified_reasons"));
					String ownerReportedAcc = rs.getString("owner_report_acc");
					if (ownerReportedAcc.equals("t") && !ownerReportedAcc.isEmpty()) {
						
						pdf7Entity.setOwnerReportedAccInsDate("Yes");
					} else if (ownerReportedAcc.equalsIgnoreCase("f") && !ownerReportedAcc.isEmpty()) {
						
						pdf7Entity.setOwnerReportedAccInsDate("No");
					}
					pdf7Entity.setVictimType(rs.getString("victim_type"));
					pdf7Entity.setPermitno(rs.getString("permitno"));
					pdf7Entity.setPermitvalidity(rs.getString("permitvalidity"));
					pdf7Entity.setFitcertval(rs.getString("fitcertval"));
					pdf7Entity.setDriRemainderDate(rs.getString("driver_remainder_date"));
					pdf7Entity.setOwnRemainderDate(rs.getString("owner_remainder_date"));
					pdf7Entity.setVictimRemainderDate(rs.getString("victim_remainder_date"));
					pdf7Entity.setRegAuthRemainderDate(rs.getString("reg_authority_remainder_date"));
					pdf7Entity.setHospitalRemainderDate(rs.getString("hospital_remainder_date"));
					pdf7Entity.setLicenseVerifiedReasons(rs.getString("license_verified_reasons"));
					pdf7Entity.setLicenseSuspendedDetails(rs.getString("license_suspended_details"));
					pdf7Entity.setDriInjInAccDetails(rs.getString("dri_inj_in_acc_details"));
					pdf7Entity.setScientificReportDetails(rs.getString("scientific_report_details"));
					pdf7Entity.setMactOwnerVehicleFir(rs.getString("mact_owner_vehicle_fir"));
					pdf7Entity.setPermitFitnessVerifiedReason(rs.getString("permit_fitness_verified_reason"));
					pdf7Entity.setOwnerReportedAcctoInsdt(rs.getString("owner_reportedaccto_insdt"));
					//pdf7Entity.setDriInjuredNot(rs.getString("dri_injured_not"));
					pdf7Entity.setNameOfDeceased(rs.getString("ser_name"));
					pdf7Entity.setAgeOfDeceased(rs.getString("age"));
					pdf7Entity.setOccupationOfDeceased(rs.getString("occupation"));
					return pdf7Entity;
				}
			});

			if (accidentDetails1.size() == 0) {
				pdf7Entity.setVehRegNo("Not Applicable");
				pdf7Entity.setVehicleMake("Not Applicable");
				pdf7Entity.setVehicleModel("Not Applicable");
				pdf7Entity.setVehicleType("Not Applicable");
				pdf7Entity.setVehicleSubType("Not Applicable");
				pdf7Entity.setVictimType("Not Applicable");
				pdf7Entity.setOwnername("Not Applicable");
				pdf7Entity.setInsurancePolicyno("Not Applicable");
				pdf7Entity.setInsuranceValidity("Not Applicable");
				pdf7Entity.setInsuranceDetails("Not Applicable");
				pdf7Entity.setOwnerAddr("Not Applicable");
				pdf7Entity.setSer_name("Not Applicable");
				pdf7Entity.setSerMobileNumber("Not Applicable");
				pdf7Entity.setSer_permadd1("Not Applicable");
				pdf7Entity.setLicense_number("Not Applicable");
				pdf7Entity.setDrunk("Not Applicable");
				pdf7Entity.setSection("Not Applicable");
//				String licenceSuspended = "Not Applicable";
//				String driverInjOrNot = "Not Applicable";
//				String mobileUsage = "Not Applicable";
//				String mact = "Not Applicable";
//				String fledFromSpot = "Not Applicable";

				pdf7Entity.setDriver_license_suspended("Not Applicable");
				pdf7Entity.setDriverInjuredOrNot("Not Applicable");
				pdf7Entity.setDriverMobileUsage("Not Applicable");
				pdf7Entity.setOwner_mact("Not Applicable");
				pdf7Entity.setOwner_driver_ran_ownerproduce("Not Applicable");
				pdf7Entity.setVehicleDrivenBy("Not Applicable");
				pdf7Entity.setDriver_imei("Not Applicable");
				pdf7Entity.setDriver_make_model("Not Applicable");
				pdf7Entity.setVehicleType("Not Applicable");
				pdf7Entity.setVehicleSubType("Not Applicable");
				pdf7Entity.setOwner_mobile_no("Not Applicable");
				pdf7Entity.setDriverLicenseType("Not Applicable");
				pdf7Entity.setDriverFatherName("Not Applicable");
				pdf7Entity.setOwnerFatherName("Not Applicable");
				pdf7Entity.setDriverLicenceValidity("Not Applicable");
				pdf7Entity.setDriverLicensingAuthority("Not Applicable");
				pdf7Entity.setPermitFitnessVerified("Not Applicable");
				pdf7Entity.setPermitFitnessVerifiedReasons("Not Applicable");
				pdf7Entity.setOwnerReportedAccInsDate("Not Applicable");
				pdf7Entity.setVictimType("Not Applicable");
				pdf7Entity.setPermitno("Not Applicable");
				pdf7Entity.setPermitvalidity("Not Applicable");
				pdf7Entity.setFitcertval("Not Applicable");
				pdf7Entity.setDriRemainderDate("Not Applicable");
				pdf7Entity.setOwnRemainderDate("Not Applicable");
				pdf7Entity.setVictimRemainderDate("Not Applicable");
				pdf7Entity.setRegAuthRemainderDate("Not Applicable");
				pdf7Entity.setHospitalRemainderDate("Not Applicable");
				return pdf7Entity;
			}
			String valcheck = pdf7Entity.getInjurySeverity();
			System.out.println("Inhjury Sev Value/// " + valcheck);

			if (null != valcheck) {
				if (pdf7Entity.getInjurySeverity().equals("1")) {
					namedParameterJdbcTemplate.query(driverquery, parameters7a, new RowMapper<Object>() {
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							do {
								DeceasedDetails driverDeceasedDetails = new DeceasedDetails();
								driverDeceasedDetails.setId(rs.getString("id"));
								driverDeceasedDetails.setInjurySeverity(rs.getString("injurySeverity"));			
								driverDeceasedDetails.setVehicle_id(rs.getString("vehicleId"));
								driverDeceasedDetails.setRef_id(rs.getString("refId"));
								driverDeceasedDetails.setLegalRepName(rs.getString("legalRepName"));
								driverDeceasedDetails.setLegalRepRelation(rs.getString("legalRepRelation"));
								driverDeceasedDetails.setLegalRepAge(rs.getString("legalRepAge"));
								passengerdetails.add(driverDeceasedDetails);
								pdf7Entity.setDeceasedDetails(passengerdetails);
								pdf7Entity.setNameOfDeceased(rs.getString("ser_name"));
								pdf7Entity.setAgeOfDeceased(rs.getString("age"));
								pdf7Entity.setOccupationOfDeceased(rs.getString("occupation"));
							} while (rs.next());

							return passengerdetails;
						}
					});
				} else if (pdf7Entity.getInjurySeverity().equals("2") || pdf7Entity.getInjurySeverity().equals("3")
						|| pdf7Entity.getInjurySeverity().equals("4")) {

					InjuredDetails pedestrianInjuredDetails = new InjuredDetails();
					//pedestrianInjuredDetails.setNameOfInjured(id);

					String driverquery1 = "select a.accident_id,a.id as id,a.ser_name as nameOfInjured,a.age as ageOfInjured,master.get_occupation(a.occupation,'') as occupationOfInjured,a.vehicle_id as vehicleId,\r\n"
							+ "b.ref_id as refId,b.name as legalRepName,b.age as legalRepAge,b.relation_type as legalRepRelation,master.get_severity(a.injury_severity) as injurySeverity,\r\n"
							+ "master.get_injury_type(a.injurytype,'') as ped_injurytype from irad_driver a inner join dar_family_details b on a.accident_id=:accidentId and \r\n"
							+ "a.injury_severity IN ('4', '2', '3')and a.vehicle_id=:vehicleId and a.id=:refId::integer and b.acc_id=a.accident_id and b.ref_id::integer=a.id";

					namedParameterJdbcTemplate.query(driverquery1, parameters7a, new RowMapper<Object>() {
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							do {

								InjuredDetails driverInjuredDetails = new InjuredDetails();
								// driverdetails.add(driverInjuredDetails);
								pdf7Entity.setInjuryDetails(driverInjuredDetails);
								pdf7Entity.setNameOfInjured(rs.getString("nameOfInjured"));
								pdf7Entity.setAgeOfInjured(rs.getString("ageOfInjured"));
								pdf7Entity.setOccupationOfInjured(rs.getString("occupationOfInjured"));
								pdf7Entity.setNatureOfInjuryInjured(rs.getString("injurySeverity"));
								pdf7Entity.setDetailsOfInjuryInjured(rs.getString("ped_injurytype"));
							} while (rs.next());

							return passengerdetails;
						}
					});

				}
			} else {
				System.out.println("No Injury Severity");
			}
		}

		return pdf7Entity;
	}

///////////////////////////////////////////////////////////////Report 8////////////////////////////////////////////////////////////////////////////
	@Override
	public Pdf8Entity getreport8(String accidentId, String vehicleId) {
		List<JSONObject> resObject = new ArrayList<JSONObject>();
		List<JSONObject> jObject = new ArrayList<JSONObject>();
		Pdf8Entity pdf8Entity = new Pdf8Entity();
		pdf8Entity.setStateCode(accidentId.substring(4, 6));
		SqlParameterSource parameters = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(GET_ACCIDENT_DETAILS, parameters, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				String date = rs.getString("datetime");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				String accidentDate = dtf.format(now);
				pdf8Entity.setCurrentDate(accidentDate);
				pdf8Entity.setAccidentId(rs.getString("accident_id"));
				pdf8Entity.setFirNumber(rs.getString("fir_number"));
				pdf8Entity.setDateTime(date.substring(0, date.indexOf(':')));
				System.out.println(date.substring(0, date.indexOf(':')));
				pdf8Entity.setTimeOfTheDay(date.substring(date.indexOf(':') + 1));
				pdf8Entity.setPsName(rs.getString("psname"));
				pdf8Entity.setLandmarks(rs.getString("landmarks"));
				pdf8Entity.setSection(rs.getString("section"));
				pdf8Entity.setState(rs.getString("statename"));
				pdf8Entity.setDistrict(rs.getString("districtname"));

				String firtime = rs.getString("firdatetime");

				pdf8Entity.setAct(rs.getString("act"));
				pdf8Entity.setFirDateTime(firtime);

				String reqofficer = rs.getString("reqofficer");
				Object obj = null;
				try {
					obj = new JSONParser().parse(reqofficer);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				// typecasting obj to JSONObject
				JSONObject jo = (JSONObject) obj;
				// getting shoName and shoDesignation
				String shoName = (String) jo.get("name");
				String shoDesignation = (String) jo.get("designation");
				pdf8Entity.setShoName(shoName.toUpperCase());
				pdf8Entity.setShoDesignation(shoDesignation);

				pdf8Entity.setInvestigatingOfficerPis(rs.getString("regno"));
				pdf8Entity.setInvestigatingOfficerMobile(rs.getString("mobile"));

				return pdf8Entity;
			}
		});
		SqlParameterSource parameters8 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(roadDetails, parameters8, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

				pdf8Entity.setCollisionNature(rs.getString("collisiontype"));
				pdf8Entity.setRoadDetails(rs.getString("road_details"));
				pdf8Entity.setLandmarks(rs.getString("landmarks"));
//				if (Integer.parseInt(rs.getString("trafficmovement")) == 1) {
//					accidentDetails.setTrafficMovement("One-way");
//				} else if (Integer.parseInt(rs.getString("trafficmovement")) == 2) {
//					accidentDetails.setTrafficMovement("Two-way");
//				}

				if (rs.getString("type_carriageway").equals("1")) {
					pdf8Entity.setTrafficMovement("Two-way");
					pdf8Entity.setNoOfLanes("1");
				} else if (rs.getString("type_carriageway").equals("2")) {
					pdf8Entity.setTrafficMovement("One-way");
					pdf8Entity.setNoOfLanes("2");
				} else if (rs.getString("type_carriageway").equals("3")) {
					pdf8Entity.setTrafficMovement("Two-way");
					pdf8Entity.setNoOfLanes("2");
				} else if (rs.getString("type_carriageway").equals("4")) {
					pdf8Entity.setTrafficMovement("One-way");
					pdf8Entity.setNoOfLanes("3");
				} else if (rs.getString("type_carriageway").equals("5")) {
					pdf8Entity.setTrafficMovement("Two-way");
					pdf8Entity.setNoOfLanes("3");
				} else if (rs.getString("type_carriageway").equals("6")) {
					pdf8Entity.setTrafficMovement("Two-way");
					pdf8Entity.setNoOfLanes("4");
				} else if (rs.getString("type_carriageway").equals("7")) {
					pdf8Entity.setTrafficMovement("Two-way");
					pdf8Entity.setNoOfLanes("4");
				} else if (rs.getString("type_carriageway").equals("8")) {
					pdf8Entity.setTrafficMovement("Two-way");
					pdf8Entity.setNoOfLanes("6");
				} else if (rs.getString("type_carriageway").equals("9")) {
					pdf8Entity.setTrafficMovement("Two-way");
					pdf8Entity.setNoOfLanes("6");
				} else if (rs.getString("type_carriageway").equals("10")) {
					pdf8Entity.setTrafficMovement("Two-way");
					pdf8Entity.setNoOfLanes("8");
				}
				if (rs.getString("accident_locations").equals("1")) {
					pdf8Entity.setVehicleLocationOnRoad("Nearby Junction");
				} else if (rs.getString("accident_locations").equals("2")) {
					pdf8Entity.setVehicleLocationOnRoad("Nearby  Horizantol curve");
				} else if (rs.getString("accident_locations").equals("3")) {
					pdf8Entity.setVehicleLocationOnRoad("Nearby Vertical curve");
				} else if (rs.getString("accident_locations").equals("4")) {
					pdf8Entity.setVehicleLocationOnRoad("Nearby Bus stop");
				}

				// accidentDetails.setRoadName(rs.getString("road_name"));
				// accidentDetails.setRoadNumber(rs.getString("road_number"));
				pdf8Entity.setVehiclewidth(rs.getString("road_width"));
				pdf8Entity.setSitePlanDescription(rs.getString("description_siteplan"));
				pdf8Entity.setSitePlanDate(rs.getString("dt_siteplan"));

				return pdf8Entity;
			}
		});
		return pdf8Entity;
	}

/////////////////////////////////////////////////////////////// Report 9////////////////////////////////////////////////////////////////////////////			
	@Override
	public Pdf9Entity getreport9(String accidentId, String vehicleId) {
		List<JSONObject> resObject = new ArrayList<JSONObject>();
		List<JSONObject> jObject = new ArrayList<JSONObject>();
		Pdf9Entity pdf9Entity = new Pdf9Entity();
		pdf9Entity.setStateCode(accidentId.substring(4, 6));
		SqlParameterSource parameters = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(GET_ACCIDENT_DETAILS, parameters, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				String date = rs.getString("datetime");

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				String accidentDate = dtf.format(now);
				pdf9Entity.setCurrentDate(accidentDate);

				pdf9Entity.setAccidentId(rs.getString("accident_id"));

				pdf9Entity.setFirNumber(rs.getString("fir_number"));
				pdf9Entity.setDateTime(date.substring(0, date.indexOf(':')));
				System.out.println(date.substring(0, date.indexOf(':')));
				pdf9Entity.setTimeOfTheDay(date.substring(date.indexOf(':') + 1));
				pdf9Entity.setPsName(rs.getString("psname"));
				pdf9Entity.setLandmarks(rs.getString("landmarks"));
				pdf9Entity.setSection(rs.getString("section"));
				pdf9Entity.setState(rs.getString("statename"));
				pdf9Entity.setDistrict(rs.getString("districtname"));
				String firtime = rs.getString("firdatetime");
				pdf9Entity.setAct(rs.getString("act"));
				pdf9Entity.setFirDateTime(firtime);

				String reqofficer = rs.getString("reqofficer");
				Object obj = null;
				try {
					obj = new JSONParser().parse(reqofficer);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				// typecasting obj to JSONObject
				JSONObject jo = (JSONObject) obj;
				// getting shoName and shoDesignation
				String shoName = (String) jo.get("name");
				String shoDesignation = (String) jo.get("designation");
				pdf9Entity.setShoName(shoName.toUpperCase());
				pdf9Entity.setShoDesignation(shoDesignation);
				return pdf9Entity;
			}
		});
		SqlParameterSource parameters9 = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(report9, parameters9, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				pdf9Entity.setMvi_req_dt(rs.getString("res_datetime"));
				pdf9Entity.setMvi_name(rs.getString("res_officer"));
				pdf9Entity.setMvi_regno(rs.getString("regno"));
				

				return pdf9Entity;
			}
		});
		SqlParameterSource parameters9a = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(report9a, parameters9, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				pdf9Entity.setVehicle_reg_no(rs.getString("vehicle_reg_no"));
				pdf9Entity.setVehicleType(rs.getString("vehicletype"));
				
				pdf9Entity.setVehicleMake(rs.getString("make"));
				pdf9Entity.setVehicleModel(rs.getString("makeclass"));
				pdf9Entity.setColor(rs.getString("color"));
				pdf9Entity.setEngineno(rs.getString("engineno"));
				pdf9Entity.setChassisno(rs.getString("chassisno"));
				pdf9Entity.setFitcertval(rs.getString("fitcertval"));
				pdf9Entity.setPermitno(rs.getString("permitno"));
				String permitValidity = rs.getString("permitvalidity");
				if (permitValidity.length() >= 1) {
					String permit = permitValidity.substring(0, 10);
					pdf9Entity.setPermitvalidity(permit);
				} else {
					pdf9Entity.setPermitvalidity("");
				}
				
				pdf9Entity.setVeh_paint_transfer(rs.getString("painttransfer"));
				pdf9Entity.setVeh_color_paint_transfer(rs.getString("coloroftransfer"));
				pdf9Entity.setVeh_location_paint_transfer1(rs.getString("locationoftransfer"));
				pdf9Entity.setVeh_type_scratch(rs.getString("tofs"));
				pdf9Entity.setVeh_steer_cond(rs.getString("gcondtionofsteering"));
				pdf9Entity.setVeh_wheel_cond(rs.getString("wheeltype"));
				pdf9Entity.setVeh_wiper_cond(rs.getString("wiperstype"));
				pdf9Entity.setVeh_mirror_cond(rs.getString("mirrors"));
				pdf9Entity.setVeh_cng_kit(rs.getString("dispinstallingcngosofv"));
				pdf9Entity.setVeh_tyre_condition(rs.getString("gtyrecondition"));
				pdf9Entity.setVeh_horn_installed(rs.getString("horn_installed"));
				
				pdf9Entity.setVeh_brake_lights_functional(rs.getString("lightsfuntional"));
				pdf9Entity.setVeh_faulty_no_plate(rs.getString("faultynumberplate"));
				pdf9Entity.setVeh_fitted_airbags(rs.getString("airbags"));
				pdf9Entity.setVeh_airbags_deployed(rs.getString("airbagsfunctional"));
				pdf9Entity.setVeh_tinted_glass(rs.getString("tintedglass"));
				pdf9Entity.setVeh_speed_limiter(rs.getString("psvinstalled"));
				pdf9Entity.setVeh_speed_limiter_functional(rs.getString("psvfunctional"));
				pdf9Entity.setVeh_rear_parkingsensor(rs.getString("parkingsensors"));
				pdf9Entity.setVeh_rear_parkingsensor_works(rs.getString("sensorfunctional"));
				pdf9Entity.setVeh_tracking_devices(rs.getString("vehicletracking"));
				pdf9Entity.setVeh_tracking_devices_works(rs.getString("vehicletrackingfunctional"));
				pdf9Entity.setVeh_description_damage(rs.getString("damge_sustained"));
				pdf9Entity.setVeh_location_inspection(rs.getString("place_ins"));
				pdf9Entity.setVeh_change_veh_body(rs.getString("changeofvehiclebody"));
				pdf9Entity.setEducationalVehicle(rs.getString("educationalvehicle"));
				pdf9Entity.setPointOfImpact(rs.getString("pointOfImpact"));
				pdf9Entity.setLocationScratch(rs.getString("location_scratch"));
				pdf9Entity.setVeh_horn_functional(rs.getString("hornfunctional"));
				return pdf9Entity;
			}
		});
		return pdf9Entity;
	}

///////////////////////////////////////////////////////////////Report 10////////////////////////////////////////////////////////////////////////////		 
	@Override
	public Pdf10Entity getreport10(String accidentId, String vehicleRegNo, boolean flag) {
		List<JSONObject> resObject = new ArrayList<JSONObject>();
		List<JSONObject> jObject = new ArrayList<JSONObject>();
		Pdf10Entity pdf10Entity = new Pdf10Entity();
		pdf10Entity.setStateCode(accidentId.substring(4, 6));
		SqlParameterSource parameters = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(GET_ACCIDENT_DETAILS, parameters, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				String date = rs.getString("datetime");
				// Date date1 = new Date();

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				String accidentDate = dtf.format(now);
				pdf10Entity.setCurrentDate(accidentDate);

				pdf10Entity.setAccidentId(rs.getString("accident_id"));
				pdf10Entity.setFirNumber(rs.getString("fir_number"));
				pdf10Entity.setDateTime(date.substring(0, date.indexOf(':')));
				System.out.println(date.substring(0, date.indexOf(':')));
				pdf10Entity.setTimeOfTheDay(date.substring(date.indexOf(':') + 1));
				pdf10Entity.setPsName(rs.getString("psname"));
				pdf10Entity.setSection(rs.getString("section"));
				pdf10Entity.setState(rs.getString("statename"));
				pdf10Entity.setDistrict(rs.getString("districtname"));

				String firtime = rs.getString("firdatetime");
				pdf10Entity.setAct(rs.getString("act"));
				pdf10Entity.setFirDateTime(firtime);

				String reqofficer = rs.getString("reqofficer");
				Object obj = null;
				try {
					obj = new JSONParser().parse(reqofficer);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				// typecasting obj to JSONObject
				JSONObject jo = (JSONObject) obj;
				// getting shoName and shoDesignation
				String shoName = (String) jo.get("name");
				String shoDesignation = (String) jo.get("designation");
				pdf10Entity.setShoName(shoName.toUpperCase());
				pdf10Entity.setShoDesignation(shoDesignation);

				pdf10Entity.setInvestigatingOfficerPis(rs.getString("regno"));
				pdf10Entity.setInvestigatingOfficerMobile(rs.getString("mobile"));

				return pdf10Entity;
			}
		});
		if (flag) {
			SqlParameterSource parameters10 = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleRegNo", vehicleRegNo);
			namedParameterJdbcTemplate.query(report10, parameters10, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					if (rs != null) {
						do {
							pdf10Entity.setVehicle_reg_no(rs.getString("vehicle_reg_no"));
							pdf10Entity.setRegnoValidity(rs.getString("rc_fit_upto"));
							pdf10Entity.setEngineno(rs.getString("engine_nr"));
							pdf10Entity.setChassisno(rs.getString("chasis_number"));
							pdf10Entity.setVclass(rs.getString("vehicle_class"));
							pdf10Entity.setVehicleMake(rs.getString("vehicle_make"));
							pdf10Entity.setVehicleModel(rs.getString("vehicle_model"));
							pdf10Entity.setOwnername(rs.getString("service_ownername"));
							pdf10Entity.setVowneraddr(rs.getString("owneraddr"));
							pdf10Entity.setNameOfInsuranceCompany(rs.getString("insurance_details"));
							pdf10Entity.setPermitno(rs.getString("rc_np_no"));
							// pdf10Entity.setPermitvalidity(rs.getString("rc_np_upto"));
							String permitValidity = rs.getString("rc_np_upto");
							if (permitValidity.length() >= 1) {
								String perValidity = permitValidity.substring(0, 11);
								pdf10Entity.setPermitvalidity(perValidity);
							} else {
								pdf10Entity.setPermitvalidity(" ");
							}
							pdf10Entity.setFitcertval(rs.getString("rc_fit_upto"));
						} while (rs.next());
					}
					return pdf10Entity;
				}
			});
		} else if (flag == false) {
			pdf10Entity.setVehicle_reg_no("Not Available");
			pdf10Entity.setRegnoValidity("Not Available");
			pdf10Entity.setEngineno("Not Available");
			pdf10Entity.setChassisno("Not Available");
			pdf10Entity.setVclass("Not Available");
			pdf10Entity.setVehicleMake("Not Available");
			pdf10Entity.setVehicleModel("Not Available");
			pdf10Entity.setOwnername("Not Available");
			pdf10Entity.setVowneraddr("Not Available");
			pdf10Entity.setNameOfInsuranceCompany("Not Available");
			pdf10Entity.setPermitno("Not Available");
			pdf10Entity.setPermitvalidity("Not Available");
			pdf10Entity.setFitcertval("Not Available");
		}
		return pdf10Entity;
	}
//		}

	@Override
	public Pdf11Entity getPdf11Report(String accidentId, String vehicleId, String mode, String personId) {
		Pdf11Entity pdf11Entity = new Pdf11Entity();
		pdf11Entity.setStateCode(accidentId.substring(4, 6));
		SqlParameterSource parameters = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId);
		namedParameterJdbcTemplate.query(generalDetails11, parameters, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				String date = rs.getString("reporting_datetime");

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				String accidentDate = dtf.format(now);
				pdf11Entity.setCurrentDate(accidentDate);
				String firtime = rs.getString("firdatetime");
				
				
				pdf11Entity.setFirDateTime(firtime);
				pdf11Entity.setAccidentId(rs.getString("accident_id"));
				pdf11Entity.setFirNumber(rs.getString("fir_number"));
				pdf11Entity.setDateTime(date.substring(0, date.indexOf(':')));
				System.out.println(date.substring(0, date.indexOf(':')));
				pdf11Entity.setTimeOfTheDay(date.substring(date.indexOf(':') + 1));
				pdf11Entity.setPsName(rs.getString("psname"));
				pdf11Entity.setState(rs.getString("statename"));
				pdf11Entity.setDistrict(rs.getString("districtname"));
				pdf11Entity.setSection(rs.getString("section"));
				pdf11Entity.setAct(rs.getString("act"));

				pdf11Entity.setVehRegNo(rs.getString("get_veh_no"));
				pdf11Entity.setVehMake(rs.getString("vehicle_make"));
				pdf11Entity.setVehModel(rs.getString("vehicle_model"));

				pdf11Entity.setInsuredName(rs.getString("name"));
				pdf11Entity.setInsuredAddress(rs.getString("residence"));

				pdf11Entity.setPolicyNumber(rs.getString("insurance_policyno"));
				pdf11Entity.setPeriodOfPolicy(rs.getString("insurance_validity"));

				//pdf11Entity.setTypeOfInjury(rs.getString("nature_of_policy"));
				pdf11Entity.setTypeOfPolicy(rs.getString("nature_of_policy"));

				pdf11Entity.setAccidentDate(rs.getString("acctime"));
				pdf11Entity.setDateOfIntimation(rs.getString("intimation_received_date_time_insured"));

				// pdf11Entity.setDateOfreceiptFAR(rs.getString("date_of_receipt_far"));

				// pdf11Entity.setDateOfreceiptIAR(rs.getString("date_of_receipt_iar"));

				// pdf11Entity.setDateOfreceiptDAR(rs.getString("date_of_receipt_dar"));

				pdf11Entity.setDateOfAppnmntDsgndOfficer(rs.getString("dateof_appt_designated_officer_by_ins"));
				pdf11Entity.setDesgnOfficerName(rs.getString("designated_officer_name"));
				pdf11Entity.setDesgnOfficerAddress(rs.getString("designated_officer_residence"));

				pdf11Entity.setDateOfAppnmntOfInvestigator(rs.getString("surveyor_appointment_date"));
				pdf11Entity.setInvestigatorName(rs.getString("surveyor_investigator_name"));
				pdf11Entity.setInvestigatorAddress(rs.getString("surveyor_investigator_residence"));

				pdf11Entity.setDateOfReportOfInvestigator(rs.getString("dateof_surveyor_investigator_report"));
				pdf11Entity.setDateOfDecision(rs.getString("dateof_designated_officer_report"));
				pdf11Entity.setFormFilledWithin30Days(rs.getString("form_filled_within_30"));
				pdf11Entity.setInsCompLiabilityToPay(rs.getString("if_ins_company_not_liability"));
				pdf11Entity.setFirDateTime(rs.getString("fir_time"));
				
				return pdf11Entity;
			}
		});

		SqlParameterSource parameters11a3 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report11form1, parameters11a3, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {
						pdf11Entity.setDateOfreceiptFAR(rs.getString("submitedon"));

					} while (rs.next());
				} else {
					pdf11Entity.setDateOfreceiptFAR(rs.getString(" "));

				}
				return pdf11Entity;
			}
		});

		SqlParameterSource parameters11a2 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report11form5, parameters11a2, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {
						pdf11Entity.setDateOfreceiptIAR(rs.getString("submitedon"));
					} while (rs.next());
				} else {
					pdf11Entity.setDateOfreceiptIAR(rs.getString(" "));
				}
				return pdf11Entity;
			}
		});

		SqlParameterSource parameters11a1 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report11form7, parameters11a1, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {
						pdf11Entity.setDateOfreceiptDAR(rs.getString("submitedon"));
					} while (rs.next());
				} else {
					pdf11Entity.setDateOfreceiptDAR(rs.getString(" "));
				}
				return pdf11Entity;
			}
		});

		if (mode.equals("Passenger")) {

			SqlParameterSource parameters6a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId);
			namedParameterJdbcTemplate.query(passengerSeverity11, parameters6a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					pdf11Entity.setInjurySeverity(injurySeverity);
					return pdf11Entity;
				}
			});

			if (pdf11Entity.getInjurySeverity().equals("1")) {
				SqlParameterSource parameters10 = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicleId).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report11PassDeceased, parameters10, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						if (rs != null) {
							do {
								pdf11Entity.setDeceasedName(rs.getString("name"));
								pdf11Entity.setDeceasedAge(rs.getString("age"));
								pdf11Entity.setDeceasedOccupation(rs.getString("occupation"));
								pdf11Entity.setDeceasedMonthlyIncome(rs.getString("death_income"));
								pdf11Entity.setDeceasedIncome(rs.getString("death_income"));
								pdf11Entity.setAddFutureProspects(rs.getString("death_future_prospects"));
								pdf11Entity.setLessPersonalExpenses(rs.getString("death_less_personal_expenses"));
								pdf11Entity.setMonthlyLossDependency(rs.getString("death_monthly_loss_depedency"));
								pdf11Entity.setAnnualLossDependency(rs.getString("death_anual_loss_depedency"));
								pdf11Entity.setMultiplier(rs.getString("death_mulltiplier"));
								pdf11Entity.setTotalLossOfDependency(rs.getString("death_total_loss_dependency"));
								pdf11Entity.setMedicalExpenses(rs.getString("death_medical_expenses"));
								pdf11Entity.setCompLossOfConsortium(rs.getString("death_loss_consortium"));
								pdf11Entity.setCompLossOfLoveAndAffection(rs.getString("death_loss_for_love_affection"));
								pdf11Entity.setCompForLossOfEstate(rs.getString("death_loss_estate"));
								pdf11Entity.setCompFuneralExpenses(rs.getString("death_loss_funeral_expenses"));
								pdf11Entity.setDeceasedTotalCompensation(rs.getString("death_total_compensation"));
							} while (rs.next());
						}
						return pdf11Entity;
					}
				});

			} else if (pdf11Entity.getInjurySeverity().equals("2") || pdf11Entity.getInjurySeverity().equals("3")
					|| pdf11Entity.getInjurySeverity().equals("4")) {
				SqlParameterSource parameters10 = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicleId).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report11PassInjured, parameters10, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						if (rs != null) {
							do {
								pdf11Entity.setVictimName(rs.getString("name"));
								pdf11Entity.setVictimAge(rs.getString("age"));
								pdf11Entity.setVictimOccupation(rs.getString("occupation"));
								pdf11Entity.setVictimMonthlyIncome(rs.getString("inj_income"));
								pdf11Entity.setVictimNatureOfInjury(rs.getString("severity"));
								pdf11Entity.setTypeOfInjury(rs.getString("get_injury_type"));

								pdf11Entity.setMedicalTreatmentDetails(rs.getString("inj_medical_treatment"));
								pdf11Entity.setPermanentDisabilityDetails(rs.getString("inj_permenant_disablity"));
								pdf11Entity.setExpenOnTreatment(rs.getString("inj_treatment"));
								pdf11Entity.setExpenOnConveyance(rs.getString("inj_convenance"));
								pdf11Entity.setExpenOnSpecialDiet(rs.getString("inj_special_diet"));
								pdf11Entity.setCostOfNursing(rs.getString("inj_cost_nursing_attendant"));
								pdf11Entity.setCostOfArtificialLimb(rs.getString("inj_cost_artificial_limp"));
								pdf11Entity.setLossOfEarningCapcity(rs.getString("inj_loss_erning_capacity"));
								pdf11Entity.setLossOfIncome(rs.getString("inj_loss_income"));
								pdf11Entity.setAnyOtherLoss(rs.getString("inj_any_other_loss"));
								pdf11Entity.setCompForMental(rs.getString("inj_com_mental_phy_shock"));
								pdf11Entity.setPainAndSuffering(rs.getString("inj_pain_suffering"));
								pdf11Entity.setLossOfAmenities(rs.getString("inj_loss_amenities"));
								pdf11Entity.setDisfiguration(rs.getString("inj_disfiguration"));
								pdf11Entity.setLossOfMarriage(rs.getString("inj_loss_of_marriage"));
								pdf11Entity.setLossOfEarningHardships(rs.getString("inj_loss_ear_inc_har_dis"));
								System.out.println("loss" + rs.getString("inj_loss_erning_capacity"));
//								int injTreatment = Integer.parseInt(rs.getString("inj_treatment"));
//								int injConveanc = Integer.parseInt(rs.getString("inj_convenance"));
//								int specialDiet = Integer.parseInt(rs.getString("inj_special_diet"));
//								int nursingattendant = Integer.parseInt(rs.getString("inj_cost_nursing_attendant"));
//								int artifiicalLimp = Integer.parseInt(rs.getString("inj_cost_artificial_limp"));
//								int erningCapacity = Integer.parseInt(rs.getString("inj_loss_erning_capacity"));
//								int lossincome = Integer.parseInt(rs.getString("inj_loss_income"));
//								int otherloss = Integer.parseInt(rs.getString("inj_any_other_loss"));
//								int physhock = Integer.parseInt(rs.getString("inj_com_mental_phy_shock"));
//								int painsuffering = Integer.parseInt(rs.getString("inj_pain_suffering"));
//								int lossamenities = Integer.parseInt(rs.getString("inj_loss_amenities"));
//								int disfiguration = Integer.parseInt(rs.getString("inj_disfiguration"));
//								int lossOfmarriage = Integer.parseInt(rs.getString("inj_loss_of_marriage"));
//								int harDis = Integer.parseInt(rs.getString("inj_loss_ear_inc_har_dis"));

								// injTreatment+injConveanc+specialDiet+nursingattendant+artifiicalLimp

								pdf11Entity.setInjuredTotalCompensation(rs.getString("inj_total_copensation"));

							} while (rs.next());
						}
						return pdf11Entity;
					}
				});
			}
		} else if (mode.equals("Pedestrian")) {
			SqlParameterSource parameters6a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId);
			namedParameterJdbcTemplate.query(pedestrianSeverity11, parameters6a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					pdf11Entity.setInjurySeverity(injurySeverity);
					return pdf11Entity;
				}
			});
			if (pdf11Entity.getInjurySeverity().equals("1")) {
				SqlParameterSource parameters10 = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicleId).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report11PedDeceased, parameters10, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						if (rs != null) {
							do {
								pdf11Entity.setDeceasedName(rs.getString("name"));
								pdf11Entity.setDeceasedAge(rs.getString("age"));
								pdf11Entity.setDeceasedOccupation(rs.getString("occupation"));
								pdf11Entity.setDeceasedMonthlyIncome(rs.getString("death_income"));
								pdf11Entity.setDeceasedIncome(rs.getString("death_income"));
								pdf11Entity.setAddFutureProspects(rs.getString("death_future_prospects"));
								pdf11Entity.setLessPersonalExpenses(rs.getString("death_less_personal_expenses"));
								pdf11Entity.setMonthlyLossDependency(rs.getString("death_monthly_loss_depedency"));
								pdf11Entity.setAnnualLossDependency(rs.getString("death_anual_loss_depedency"));
								pdf11Entity.setMultiplier(rs.getString("death_mulltiplier"));
								pdf11Entity.setTotalLossOfDependency(rs.getString("death_total_loss_dependency"));
								pdf11Entity.setMedicalExpenses(rs.getString("death_medical_expenses"));
								pdf11Entity.setCompLossOfConsortium(rs.getString("death_loss_consortium"));
								pdf11Entity.setCompLossOfLoveAndAffection(rs.getString("death_loss_for_love_affection"));
								pdf11Entity.setCompForLossOfEstate(rs.getString("death_loss_estate"));
								pdf11Entity.setCompFuneralExpenses(rs.getString("death_loss_funeral_expenses"));
								pdf11Entity.setDeceasedTotalCompensation(rs.getString("death_total_compensation"));
							} while (rs.next());
						}
						return pdf11Entity;
					}
				});

			} else if (pdf11Entity.getInjurySeverity().equals("2") || pdf11Entity.getInjurySeverity().equals("3")
					|| pdf11Entity.getInjurySeverity().equals("4")) {
				SqlParameterSource parameters10 = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicleId).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report11PedInjured, parameters10, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						if (rs != null) {
							do {
								pdf11Entity.setVictimName(rs.getString("name"));
								pdf11Entity.setVictimAge(rs.getString("age"));
								pdf11Entity.setVictimOccupation(rs.getString("occupation"));
								pdf11Entity.setVictimMonthlyIncome(rs.getString("inj_income"));
								pdf11Entity.setVictimNatureOfInjury(rs.getString("inj_natureofinjury"));
								pdf11Entity.setTypeOfInjury(rs.getString("get_injury_type"));
								pdf11Entity.setMedicalTreatmentDetails(rs.getString("inj_medical_treatment"));
								pdf11Entity.setPermanentDisabilityDetails(rs.getString("inj_permenant_disablity"));
								pdf11Entity.setExpenOnTreatment(rs.getString("inj_treatment"));
								pdf11Entity.setExpenOnConveyance(rs.getString("inj_convenance"));
								pdf11Entity.setExpenOnSpecialDiet(rs.getString("inj_special_diet"));
								pdf11Entity.setCostOfNursing(rs.getString("inj_cost_nursing_attendant"));
								pdf11Entity.setCostOfArtificialLimb(rs.getString("inj_cost_artificial_limp"));
								pdf11Entity.setLossOfEarningCapcity(rs.getString("inj_loss_erning_capacity"));
								pdf11Entity.setLossOfIncome(rs.getString("inj_loss_income"));
								pdf11Entity.setAnyOtherLoss(rs.getString("inj_any_other_loss"));
								pdf11Entity.setCompForMental(rs.getString("inj_com_mental_phy_shock"));
								pdf11Entity.setPainAndSuffering(rs.getString("inj_pain_suffering"));
								pdf11Entity.setLossOfAmenities(rs.getString("inj_loss_amenities"));
								pdf11Entity.setDisfiguration(rs.getString("inj_disfiguration"));
								pdf11Entity.setLossOfMarriage(rs.getString("inj_loss_of_marriage"));
								pdf11Entity.setLossOfEarningHardships(rs.getString("inj_loss_ear_inc_har_dis"));
								pdf11Entity.setInjuredTotalCompensation(rs.getString("inj_total_copensation"));
								pdf11Entity.setVictimMonthlyIncome(rs.getString("inj_income"));
								pdf11Entity.setVictimNatureOfInjury(rs.getString("severity"));
							} while (rs.next());
						}
						return pdf11Entity;
					}
				});
			}
		} else if (mode.equals("Driver")) {
			SqlParameterSource parameters6a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId);
			namedParameterJdbcTemplate.query(driverSeverity11, parameters6a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					pdf11Entity.setInjurySeverity(injurySeverity);
					return pdf11Entity;
				}
			});
			if (pdf11Entity.getInjurySeverity().equals("1")) {
				SqlParameterSource parameters10 = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicleId).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report11driverDeceased, parameters10, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						if (rs != null) {
							do {
								pdf11Entity.setDeceasedName(rs.getString("name"));
								pdf11Entity.setDeceasedAge(rs.getString("age"));
								pdf11Entity.setDeceasedOccupation(rs.getString("occupation"));
								pdf11Entity.setDeceasedMonthlyIncome(rs.getString("death_income"));
								pdf11Entity.setDeceasedIncome(rs.getString("death_income"));
								pdf11Entity.setAddFutureProspects(rs.getString("death_future_prospects"));
								pdf11Entity.setLessPersonalExpenses(rs.getString("death_less_personal_expenses"));
								pdf11Entity.setMonthlyLossDependency(rs.getString("death_monthly_loss_depedency"));
								pdf11Entity.setAnnualLossDependency(rs.getString("death_anual_loss_depedency"));
								pdf11Entity.setMultiplier(rs.getString("death_mulltiplier"));
								pdf11Entity.setTotalLossOfDependency(rs.getString("death_total_loss_dependency"));
								pdf11Entity.setMedicalExpenses(rs.getString("death_medical_expenses"));
								pdf11Entity.setCompLossOfConsortium(rs.getString("death_loss_consortium"));
								pdf11Entity.setCompLossOfLoveAndAffection(rs.getString("death_loss_for_love_affection"));
								pdf11Entity.setCompForLossOfEstate(rs.getString("death_loss_estate"));
								pdf11Entity.setCompFuneralExpenses(rs.getString("death_loss_funeral_expenses"));
								pdf11Entity.setDeceasedTotalCompensation(rs.getString("death_total_compensation"));
							} while (rs.next());
						}
						return pdf11Entity;
					}
				});

			} else if (pdf11Entity.getInjurySeverity().equals("2") || pdf11Entity.getInjurySeverity().equals("3")
					|| pdf11Entity.getInjurySeverity().equals("4")) {
				SqlParameterSource parameters10 = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report11driverInjured, parameters10, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						if (rs != null) {
							do {

								pdf11Entity.setVictimName(rs.getString("name"));
								pdf11Entity.setVictimAge(rs.getString("age"));
								pdf11Entity.setVictimOccupation(rs.getString("occupation"));
								pdf11Entity.setVictimMonthlyIncome(rs.getString("inj_income"));
								pdf11Entity.setVictimNatureOfInjury(rs.getString("severity"));
								pdf11Entity.setTypeOfInjury(rs.getString("get_injury_type"));
								pdf11Entity.setMedicalTreatmentDetails(rs.getString("inj_medical_treatment"));
								pdf11Entity.setPermanentDisabilityDetails(rs.getString("inj_permenant_disablity"));
								pdf11Entity.setExpenOnTreatment(rs.getString("inj_treatment"));
								pdf11Entity.setExpenOnConveyance(rs.getString("inj_convenance"));
								pdf11Entity.setExpenOnSpecialDiet(rs.getString("inj_special_diet"));
								pdf11Entity.setCostOfNursing(rs.getString("inj_cost_nursing_attendant"));
								pdf11Entity.setCostOfArtificialLimb(rs.getString("inj_cost_artificial_limp"));
								pdf11Entity.setLossOfEarningCapcity(rs.getString("inj_loss_erning_capacity"));
								pdf11Entity.setLossOfIncome(rs.getString("inj_loss_income"));
								pdf11Entity.setAnyOtherLoss(rs.getString("inj_any_other_loss"));
								pdf11Entity.setCompForMental(rs.getString("inj_com_mental_phy_shock"));
								pdf11Entity.setPainAndSuffering(rs.getString("inj_pain_suffering"));
								pdf11Entity.setLossOfAmenities(rs.getString("inj_loss_amenities"));
								pdf11Entity.setDisfiguration(rs.getString("inj_disfiguration"));
								pdf11Entity.setLossOfMarriage(rs.getString("inj_loss_of_marriage"));
								pdf11Entity.setLossOfEarningHardships(rs.getString("inj_loss_ear_inc_har_dis"));
								pdf11Entity.setInjuredTotalCompensation(rs.getString("inj_total_copensation"));
								pdf11Entity.setVictimMonthlyIncome(rs.getString("inj_income"));
								pdf11Entity.setVictimNatureOfInjury(rs.getString("severity"));
							} while (rs.next());
						}
						return pdf11Entity;
					}
				});
			}
		}
		List<DeceasedLeagalRepresentatives> deceasedLegalRespresentatives = new ArrayList<DeceasedLeagalRepresentatives>();
		SqlParameterSource parameters7 = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId).addValue("personId", personId);
		namedParameterJdbcTemplate.query(report11LegalRep, parameters7, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				do {
					DeceasedLeagalRepresentatives legalRepresentative = new DeceasedLeagalRepresentatives();
					legalRepresentative.setName(rs.getString("legalRepName"));
					legalRepresentative.setAge(rs.getString("legalRepAge"));
					legalRepresentative.setRelation(rs.getString("legalRepRelation"));
					deceasedLegalRespresentatives.add(legalRepresentative);
					pdf11Entity.setDeceasedLegalRepresentatives(deceasedLegalRespresentatives);

				} while (rs.next());
				return pdf11Entity;
			}
		});
		return pdf11Entity;
	}

	@Override
	public Pdf12Entity getPdf12Report(String accidentId, String vehicle_id, String mode, String personId) {
		Pdf12Entity pdf12Entity = new Pdf12Entity();
		pdf12Entity.setStateCode(accidentId.substring(4, 6));
		List<DeceasedLeagalRepresentatives> deceasedLegalRespresentatives = new ArrayList<DeceasedLeagalRepresentatives>();

		System.out.println(mode);

		SqlParameterSource parameters12h = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(GET_ACCIDENT_DETAILS, parameters12h, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				String date = rs.getString("reporting_datetime");
				String firtime = rs.getString("firdatetime");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				String accidentDate = dtf.format(now);
				pdf12Entity.setCurrentDate(accidentDate);

				pdf12Entity.setAccidentId(rs.getString("accident_id"));
				pdf12Entity.setFirNumber(rs.getString("fir_number"));
				pdf12Entity.setDateTime(date.substring(0, date.indexOf(':')));

				pdf12Entity.setPsName(rs.getString("psname"));
				pdf12Entity.setState(rs.getString("statename"));
				pdf12Entity.setDistrict(rs.getString("districtname"));
				pdf12Entity.setSection(rs.getString("section"));
				pdf12Entity.setFirNumber(rs.getString("fir_number"));
				pdf12Entity.setSection(rs.getString("section"));
				pdf12Entity.setPoliceStationName(rs.getString("psname"));
				pdf12Entity.setAccidentDate(rs.getString("reporting_datetime"));
				pdf12Entity.setFirDateTime(firtime);
				pdf12Entity.setAct(rs.getString("act"));
				pdf12Entity.setRoadDetails(rs.getString("roaddetails"));
				// pdf12Entity.setPropertyDamageDescription("No damage");
				// pdf12Entity.setLossSufferedValue("1000");
				pdf12Entity.setLandmarks(rs.getString("landmarks"));
				pdf12Entity.setAccidentDatetime(rs.getString("acctime"));
				return pdf12Entity;

			}
		});

		SqlParameterSource parameters12j = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicle_id).addValue("personId", personId);
		namedParameterJdbcTemplate.query(report12General, parameters12j, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				String date = rs.getString("reporting_datetime");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				String accidentDate = dtf.format(now);
				// pdf12Entity.setCurrentDate(accidentDate);

//				pdf12Entity.setAccidentId(rs.getString("accident_id"));
//				pdf12Entity.setFirNumber(rs.getString("fir_number"));
//				pdf12Entity.setDateTime(date.substring(0, date.indexOf(':')));
//				System.out.println(date.substring(0, date.indexOf(':')));
//				pdf12Entity.setPsName(rs.getString("psname"));
//				// pdf11Entity.setState(rs.getString("state"));
//				// pdf11Entity.setDistrict(rs.getString("district"));
//				pdf12Entity.setSection(rs.getString("section"));
//				pdf12Entity.setFirNumber(rs.getString("fir_number"));
//				pdf12Entity.setSection(rs.getString("section"));
//				pdf12Entity.setPoliceStationName(rs.getString("psname"));
//				pdf12Entity.setAccidentDate(rs.getString("reporting_datetime"));
				pdf12Entity.setNatureOfInjurySufferedByVictim(rs.getString("nature_of_injuries"));
				pdf12Entity.setOffenceDescription(rs.getString("brief_description_of_offense"));
				pdf12Entity.setVictimName(rs.getString("name"));
				pdf12Entity.setFatherOrSpouseName(rs.getString("father_spouse_name"));
				pdf12Entity.setAge(rs.getString("age"));
				pdf12Entity.setGender(rs.getString("gender"));
				pdf12Entity.setMaritalStatus(rs.getString("marital_status"));
				pdf12Entity.setPermanentAddress(rs.getString("permenant_address"));
				pdf12Entity.setPresentAddress(rs.getString("present_address"));
				pdf12Entity.setMobileNumber(rs.getString("conatc_mobileno"));
				pdf12Entity.setEmailId(rs.getString("conatc_emailid"));				
				pdf12Entity.setPhysicalHarm(rs.getString("physical_harm"));
				pdf12Entity.setEmotionalHarm(rs.getString("emotional_harm"));
				pdf12Entity.setDamageLossProperty(rs.getString("damage_lose"));
				pdf12Entity.setAnyOtherLoss(rs.getString("any_damage_lose"));				
				pdf12Entity.setPropertyLossDamage(rs.getString("property_loss_damage"));
				pdf12Entity.setLossSuffered(rs.getString("loss_suffered"));	
				return pdf12Entity;

			}
		});
//		if (mode.equalsIgnoreCase("Driver")) {
			SqlParameterSource parameters12k = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicle_id).addValue("personId", personId);
			namedParameterJdbcTemplate.query(report12Accussed, parameters12k, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

					pdf12Entity.setAccusedFledFromSpot(rs.getString("acc_fled_spot"));
					pdf12Entity.setAccusedReportedAccidentToPolice(rs.getString("acc_reported_to_police"));
					pdf12Entity.setAccusedProvidedAssistanceToVictim(rs.getString("acc_provided_any_assitance_victim"));
					pdf12Entity.setAccusedTookVictimToHospital(rs.getString("acc_took_victim_hospital"));
					pdf12Entity.setAccusedVisitedVictimAtHospital(rs.getString("acc_visited_victim_hospital"));
					pdf12Entity.setAccusedRemainedAtspot(rs.getString("acc_remained_spot_police_arrived"));
					pdf12Entity.setAccusedCooperatedInvestigation(rs.getString("acc_cooperated_investigation"));
					pdf12Entity.setAccusedRemovedVehicleFromSpot(rs.getString("acc_removed_vehicle_police_arrived"));
					pdf12Entity.setAccusedPaidCompensation(rs.getString("acc_paid_compensation_medical_expenses"));
					pdf12Entity.setAccusedPreviousConvictions(rs.getString("acc_previous_convictions"));
					pdf12Entity.setAccusedCloseRelative(rs.getString("acc_close_friend_victim"));
					pdf12Entity.setAccusedAge(rs.getString("acc_age"));
					pdf12Entity.setAccusedGender(rs.getString("acc_gender"));
					pdf12Entity.setAccusedSufferedInjuries(rs.getString("acc_suffered_injuries"));
					pdf12Entity.setAccusedDischargedDuties(rs.getString("acc_discharged_duties"));
					pdf12Entity.setMotorAccidentCase(rs.getString("acc_pre_invloved_motor"));
//				  pdf12Entity.setFirNumber(rs.getString("vehicleRegNo"));
//				  pdf12Entity.setAccusedPoliceStationName(rs.getString("vehicleRegNo"));
					pdf12Entity.setDriverFledFromSpot(rs.getString("acc_pre_spot_owner"));
					pdf12Entity.setAccusedOtherConductInformation(rs.getString("acc_other_information"));
					pdf12Entity.setApparentContributingCircumstances(rs.getString("acc_apaent_contributing_cir1"));
					pdf12Entity.setAggressiveDriving(rs.getString("acc_aggressive_driving1"));
					pdf12Entity.setIrresponsibleBehaviour(rs.getString("acc_irresponsible_behaviour1"));
					return rowNum;
				}
			});
//		}
		if (mode.equalsIgnoreCase("Passenger")) {

			SqlParameterSource parameters12a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicle_id).addValue("personId", personId);
			namedParameterJdbcTemplate.query(passengerSeverity12, parameters12a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					pdf12Entity.setInjurySeverity(injurySeverity);
					return pdf12Entity;
				}
			});

			if (pdf12Entity.getInjurySeverity().equals("1")) {
				SqlParameterSource parameters12b = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report12PassDeceased, parameters12b, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						if (rs != null) {
							do {

								pdf12Entity.setDeceasedName(rs.getString("name"));
								pdf12Entity.setDeceasedAge(rs.getString("age"));
								pdf12Entity.setDeceasedGender(rs.getString("gender"));
								pdf12Entity.setDeceasedOccupation(rs.getString("occupation"));
								pdf12Entity.setDeceasedIncome(rs.getString("death_income"));
								pdf12Entity.setDeceasedAddFutureProspects(rs.getString("death_future_prospects"));
								pdf12Entity.setDeceasedLessPersonalExpenses(rs.getString("death_less_personal_expenses"));
								pdf12Entity.setDeceasedMonthlyLossDependency(rs.getString("death_monthly_loss_depedency"));
								pdf12Entity.setAnnualLossDependency(rs.getString("death_anual_loss_depedency"));
								pdf12Entity.setDeceasedMultiplier(rs.getString("death_mulltiplier"));
								pdf12Entity.setDeceasedTotalLossDependency(rs.getString("death_total_loss_dependency"));
								pdf12Entity.setDeceasedMedicalExpenses(rs.getString("death_medical_expenses"));
								pdf12Entity.setDeceasedFuneralExpenses(rs.getString("death_loss_funeral_expenses"));
								pdf12Entity.setDeceasedPecuniaryLossDamage(rs.getString("death_any_other_pecuniary"));
								pdf12Entity.setDeceasedLossOfConsortium(rs.getString("death_loss_consortium"));
								pdf12Entity.setDeceasedLossOfLoveAffection(rs.getString("death_loss_for_love_affection"));
								pdf12Entity.setDeceasedLossOfEstate(rs.getString("death_loss_estate"));
								pdf12Entity.setDeceasedEmotionalHarmTaruma(rs.getString("death_emotional_harm_etc"));
								pdf12Entity.setDeceasedPostTraumaticDisorder(rs.getString("death_post_traumatic_stress_disorder"));
								pdf12Entity.setDeceasedOtherNonPecuniaryLoss(rs.getString("death_any_other_nonpecuniary"));
								pdf12Entity.setDeceasedFatherOrSpouseName(rs.getString("father_name"));
								pdf12Entity.setDeceasedMaritalStatus(rs.getString("marital_status"));
								pdf12Entity.setMobileNumber(rs.getString("mobile"));
								pdf12Entity.setPermanentAddress(rs.getString("residence"));
								pdf12Entity.setPresentAddress(rs.getString("residence"));
								pdf12Entity.setEmailId(rs.getString("emailid"));
								pdf12Entity.setPropertyDamageDescription(rs.getString("property_description"));
//								int totalDependency = Integer.parseInt(rs.getString("death_total_loss_dependency"));
//								int medicalExpenses = Integer.parseInt(rs.getString("death_medical_expenses"));
//								int funderalExpenses = Integer.parseInt(rs.getString("death_loss_funeral_expenses"));
//								int otherPecuniary = Integer.parseInt(rs.getString("death_any_other_pecuniary"));
//
//								int lossConsortium = Integer.parseInt(rs.getString("death_loss_consortium"));
//								int loveaffection = Integer.parseInt(rs.getString("death_loss_for_love_affection"));
//								int lossEstate = Integer.parseInt(rs.getString("death_loss_estate"));
//								int emotionalHarm = Integer.parseInt(rs.getString("death_emotional_harm_etc"));
//								int stressDisorder = Integer.parseInt(rs.getString("death_post_traumatic_stress_disorder"));
//								int nonPecuniary = Integer.parseInt(rs.getString("death_any_other_nonpecuniary"));
//
//								int totalloss = loveaffection + totalDependency + medicalExpenses + funderalExpenses
//										+ otherPecuniary + lossConsortium + lossEstate + emotionalHarm + stressDisorder
//										+ nonPecuniary;
//								String totalLossSuffered = Integer.toString(totalloss);
								pdf12Entity.setDeceasedTotalLossSuffered(rs.getString("death_total_compensation"));
								//pdf12Entity.setLossSufferedValue(rs.getString("loss_suufer_value_vehilce"));
								
								
								pdf12Entity.setDeceasedcapannualincome(rs.getString("paying_cap_anual_income"));
								pdf12Entity.setDeceasedmovableasset(rs.getString("paying_cap_moveable_asset"));
								pdf12Entity.setDeceasedimmovableasset(rs.getString("paying_cap_immovable_assets"));
								pdf12Entity.setDeceasedrecommendation(rs.getString("slsa_recommendation"));
							} while (rs.next());
						}
						return pdf12Entity;
					}
				});

				List<DeceasedLeagalRepresentatives> deceasedLegalRespresentatives12 = new ArrayList<DeceasedLeagalRepresentatives>();
				SqlParameterSource parameters13h = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report12LegalRepDeceased, parameters13h, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						do {
							DeceasedLeagalRepresentatives deceasedLegalRepresentative = new DeceasedLeagalRepresentatives();
							deceasedLegalRepresentative.setName(rs.getString("legalRepName"));
							deceasedLegalRepresentative.setAge(rs.getString("legalRepAge"));
							deceasedLegalRepresentative.setRelation(rs.getString("legalRepRelation"));
							deceasedLegalRepresentative.setGender(rs.getString("gender"));
							deceasedLegalRespresentatives.add(deceasedLegalRepresentative);
							pdf12Entity.setDeceasedLegalRepresentatives(deceasedLegalRespresentatives);

						} while (rs.next());
						return pdf12Entity;
					}
				});

			} else if (pdf12Entity.getInjurySeverity().equals("2") || pdf12Entity.getInjurySeverity().equals("3")
					|| pdf12Entity.getInjurySeverity().equals("4")) {
				SqlParameterSource parameters12c = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report12PassInjured, parameters12c, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						if (rs != null) {
							do {
								pdf12Entity.setInjuredName(rs.getString("name"));
								pdf12Entity.setInjuredAge(rs.getString("age"));
								pdf12Entity.setInjuredGender(rs.getString("gender"));
								pdf12Entity.setInjuredOccupation(rs.getString("occupation"));
								pdf12Entity.setInjuryNatureAndDescription(rs.getString("severity"));
								pdf12Entity.setEmailId(rs.getString("emailid"));
								pdf12Entity.setInjuredMedicalTreatment(rs.getString("inj_medical_treatment_taken_by_injured"));
								pdf12Entity.setHospitalNameAndHospitalizationPeriod(rs.getString("inj_name_of_hospital"));
								pdf12Entity.setPermanentDisability(rs.getString("inj_permenant_disablity"));
								pdf12Entity.setReimbursementOfMedicalExpenses(rs.getString("inj_got_reimpuresement"));
								pdf12Entity.setInjuredTreatmentExpenditureEstimation(rs.getString("inj_treatment"));
								pdf12Entity.setInjuredExpenditureOnTreatment(rs.getString("inj_treatment"));
								pdf12Entity.setInjuredExpenditureOnConveyance(rs.getString("inj_convenance"));
								pdf12Entity.setInjuredExpenditureOnSpecialDiet(rs.getString("inj_special_diet"));
								pdf12Entity.setInjuredExpenditureOnAttendant(rs.getString("inj_cost_nursing_attendant"));
								pdf12Entity.setInjuredLossOfIncome(rs.getString("inj_loss_income"));
								pdf12Entity.setInjuredSpecialTreatment(rs.getString("inj_any_other_loss_req_special_treatment"));
								pdf12Entity.setIjuredNatureOfDisability(rs.getString("inj_percentage_disablity"));
								pdf12Entity.setInjuredLossOfEarningCapacity(rs.getString("inj_loss_erning_capacity"));
								pdf12Entity.setInjuredPecuniaryLoss(rs.getString("inj_any_other_pecuniary_loss"));
								pdf12Entity.setInjuredPainAndSuffering(rs.getString("inj_pain_suffering"));
								pdf12Entity.setInjuredLossOfAmenities(rs.getString("inj_loss_amenities"));
								pdf12Entity.setInjuredPostTraumaticDisorder(rs.getString("inj_post_traumatic"));
								pdf12Entity.setInjuredEmotionalHarmTaruma(rs.getString("inj_com_mental_phy_shock"));
								pdf12Entity.setInjuredDisfiguration(rs.getString("inj_disfiguration"));
								pdf12Entity.setInjuredLossOfMarriageProspects(rs.getString("inj_loss_marriage_prospects"));
								pdf12Entity.setInjuredLossOfReputation(rs.getString("inj_loss_reputation"));
								pdf12Entity.setInjuredOtherNonPecuniaryLoss(rs.getString("inj_anyother_non_pecuniary"));
								pdf12Entity.setInjuredMaritalStatus(rs.getString("marital_status"));
								pdf12Entity.setInjuredFatherOrSpouseName(rs.getString("father_name"));
								pdf12Entity.setInjuredIncome(rs.getString("income"));
								pdf12Entity.setMobileNumber(rs.getString("mobile"));
								pdf12Entity.setPermanentAddress(rs.getString("residence"));
								pdf12Entity.setPresentAddress(rs.getString("residence"));
								pdf12Entity.setInjuredMedicalTreatment(rs.getString("inj_medical_treatment_taken_by_injured"));
								pdf12Entity.setHospitalNameAndHospitalizationPeriod(rs.getString("inj_name_of_hospital"));
								pdf12Entity.setPermanentDisability(rs.getString("inj_permenant_disablity"));
								pdf12Entity.setReimbursementOfMedicalExpenses(rs.getString("inj_got_reimpuresement"));
								pdf12Entity.setHospitalPeriod(rs.getString("inj_peroid_of_hospital"));
								pdf12Entity.setInjuredPostTraumaticDisorder(rs.getString("inj_post_traumatic"));
								pdf12Entity.setInjuredDisfiguration(rs.getString("inj_disfiguration"));
								pdf12Entity.setInjuredLossOfMarriageProspects(rs.getString("inj_loss_marriage_prospects"));
								pdf12Entity.setInjuredLossOfReputation(rs.getString("inj_loss_reputation"));
								pdf12Entity.setInjuredOtherNonPecuniaryLoss(rs.getString("inj_anyother_non_pecuniary"));
								pdf12Entity.setSurgeriesDetails(rs.getString("hospital_treatment_surgery_details"));
								pdf12Entity.setPropertyDamageDescription(rs.getString("property_description"));

								//int injTreatment = Integer.parseInt(rs.getString("inj_treatment"));
								//int injConvenance = Integer.parseInt(rs.getString("inj_convenance"));
								//int injSpecial = Integer.parseInt(rs.getString("inj_special_diet"));
								//int costNursing = Integer.parseInt(rs.getString("inj_cost_nursing_attendant"));
								//int cost=injTreatment+injConvenance+injSpecial+costNursing;
								//pdf12Entity.setInjuredExpenditureOnTreatment(Integer.toString(cost));
								
								
								//int injtreatment = Integer.parseInt(rs.getString("inj_treatment"));
								//int lossincome = Integer.parseInt(rs.getString("inj_loss_income"));
								//int specialtreatment = Integer.parseInt(rs.getString("inj_any_other_loss_req_special_treatment"));
								//int diabilitypercent = Integer.parseInt(rs.getString("inj_percentage_disablity"));
								//int earningcapacity = Integer.parseInt(rs.getString("inj_loss_erning_capacity"));
								//int pecuniaryloss = Integer.parseInt(rs.getString("inj_any_other_pecuniary_loss"));
								//int painsuffering = Integer.parseInt(rs.getString("inj_pain_suffering"));
								//int amenitiesloss = Integer.parseInt(rs.getString("inj_loss_amenities"));
								//int physhock = Integer.parseInt(rs.getString("inj_com_mental_phy_shock"));
								//int marraiageprospects = Integer.parseInt(rs.getString("inj_loss_marriage_prospects"));
								//int reputation = Integer.parseInt(rs.getString("inj_loss_reputation"));
								//int nonpecuniaryloss = Integer.parseInt(rs.getString("inj_anyother_non_pecuniary"));
								//int multiplier = Integer.parseInt(rs.getString("multiplier"));
								//int posttraumatic = Integer.parseInt(rs.getString("inj_post_traumatic"));
								//int disfuguration = Integer.parseInt(rs.getString("inj_disfiguration"));
								//int futureIncome = lossincome *(earningcapacity)*multiplier;
								//int futureIncome1=futureIncome/100;
								
								//int totalloss = injTreatment + injConvenance + injSpecial + costNursing + injtreatment+ lossincome + specialtreatment
										//+ pecuniaryloss + painsuffering + amenitiesloss + physhock + marraiageprospects
										//+ reputation + nonpecuniaryloss + futureIncome1+posttraumatic+disfuguration;
								//String totalLossSuffered = Integer.toString(totalloss);
								//String lossFutureIncome = Integer.toString(futureIncome1);
								
								//pdf12Entity.setInjuredLossOfFutureIncome(rs.getString("inj_total_copensation"));
								
								pdf12Entity.setInjuredTotalLossSuffered(rs.getString("inj_total_copensation"));				
								pdf12Entity.setLossSufferedValue(rs.getString("loss_suufer_value_vehilce"));
								pdf12Entity.setDeceasedcapannualincome(rs.getString("paying_cap_anual_income"));
								pdf12Entity.setDeceasedmovableasset(rs.getString("paying_cap_moveable_asset"));
								pdf12Entity.setDeceasedimmovableasset(rs.getString("paying_cap_immovable_assets"));
								pdf12Entity.setDeceasedrecommendation(rs.getString("slsa_recommendation"));
								// pdf12Entity.setInjuredTotalLossSuffered(rs.getString("vehicleRegNo"));
								// pdf12Entity.setInjuryNatureAndDescription(rs.getString("vehicleRegNo"));
								// pdf12Entity.setInjuredMedicalTreatment(rs.getString("vehicleRegNo"));
								// pdf12Entity.setHospitalNameAndHospitalizationPeriod(rs.getString("vehicleRegNo"));
								// pdf12Entity.setSurgeriesDetails(rs.getString("vehicleRegNo"));
								// pdf12Entity.setPermanentDisability(rs.getString("vehicleRegNo"));
								// pdf12Entity.setReimbursementOfMedicalExpenses(rs.getString("vehicleRegNo"));
								// list is pending
								// pdf12Entity.setInjuredPecuniaryLoss(rs.getString("vehicleRegNo"));

							} while (rs.next());
						}
						return pdf12Entity;
					}
				});
				List<DeceasedLeagalRepresentatives> deceasedLegalRespresentatives12 = new ArrayList<DeceasedLeagalRepresentatives>();
				SqlParameterSource parameters13h = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report12LegalRepInjured, parameters13h, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						do {
							DeceasedLeagalRepresentatives deceasedLegalRepresentative = new DeceasedLeagalRepresentatives();
							deceasedLegalRepresentative.setName(rs.getString("legalRepName"));
							deceasedLegalRepresentative.setAge(rs.getString("legalRepAge"));
							deceasedLegalRepresentative.setRelation(rs.getString("legalRepRelation"));
							deceasedLegalRepresentative.setGender(rs.getString("gender"));
							deceasedLegalRespresentatives.add(deceasedLegalRepresentative);
							pdf12Entity.setDeceasedLegalRepresentatives(deceasedLegalRespresentatives);

						} while (rs.next());
						return pdf12Entity;
					}
				});
			}
		} else if (mode.equalsIgnoreCase("Pedestrian")) {
			SqlParameterSource parameters6a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicle_id).addValue("personId", personId);
			namedParameterJdbcTemplate.query(pedestrianSeverity12, parameters6a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					pdf12Entity.setInjurySeverity(injurySeverity);
					return pdf12Entity;
				}
			});
			if (pdf12Entity.getInjurySeverity().equals("1")) {
				SqlParameterSource parameters12d = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report12PedDeceased, parameters12d, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						if (rs != null) {
							do {
								pdf12Entity.setDeceasedName(rs.getString("name"));
								pdf12Entity.setDeceasedAge(rs.getString("age"));
								pdf12Entity.setDeceasedGender(rs.getString("gender"));
								pdf12Entity.setDeceasedOccupation(rs.getString("occupation"));
								pdf12Entity.setDeceasedIncome(rs.getString("death_income"));
								pdf12Entity.setEmailId(rs.getString("emailid"));
								pdf12Entity.setDeceasedAddFutureProspects(rs.getString("death_future_prospects"));
								pdf12Entity.setDeceasedLessPersonalExpenses(rs.getString("death_less_personal_expenses"));
								pdf12Entity.setDeceasedMonthlyLossDependency(rs.getString("death_monthly_loss_depedency"));
								pdf12Entity.setAnnualLossDependency(rs.getString("death_anual_loss_depedency"));
								pdf12Entity.setDeceasedMultiplier(rs.getString("death_mulltiplier"));
								pdf12Entity.setDeceasedTotalLossDependency(rs.getString("death_total_loss_dependency"));
								pdf12Entity.setDeceasedMedicalExpenses(rs.getString("death_medical_expenses"));
								pdf12Entity.setDeceasedFuneralExpenses(rs.getString("death_loss_funeral_expenses"));
								pdf12Entity.setDeceasedPecuniaryLossDamage(rs.getString("death_any_other_pecuniary"));
								pdf12Entity.setDeceasedLossOfConsortium(rs.getString("death_loss_consortium"));
								pdf12Entity.setDeceasedLossOfLoveAffection(rs.getString("death_loss_for_love_affection"));
								pdf12Entity.setDeceasedLossOfEstate(rs.getString("death_loss_estate"));
								pdf12Entity.setDeceasedEmotionalHarmTaruma(rs.getString("death_emotional_harm_etc"));
								pdf12Entity.setDeceasedPostTraumaticDisorder(rs.getString("death_post_traumatic_stress_disorder"));
								pdf12Entity.setDeceasedOtherNonPecuniaryLoss(rs.getString("death_any_other_nonpecuniary"));
								pdf12Entity.setDeceasedFatherOrSpouseName(rs.getString("father_name"));
								pdf12Entity.setDeceasedMaritalStatus(rs.getString("marital_status"));
								pdf12Entity.setMobileNumber(rs.getString("mobile"));
								pdf12Entity.setPermanentAddress(rs.getString("residence"));
								pdf12Entity.setPresentAddress(rs.getString("residence"));
								pdf12Entity.setPropertyDamageDescription(rs.getString("property_description"));
								
								/*
								 * int totalDependency =
								 * Integer.parseInt(rs.getString("death_total_loss_dependency")); int
								 * medicalExpenses = Integer.parseInt(rs.getString("death_medical_expenses"));
								 * int funderalExpenses =
								 * Integer.parseInt(rs.getString("death_loss_funeral_expenses")); int
								 * otherPecuniary = Integer.parseInt(rs.getString("death_any_other_pecuniary"));
								 * 
								 * int lossConsortium = Integer.parseInt(rs.getString("death_loss_consortium"));
								 * int loveaffection =
								 * Integer.parseInt(rs.getString("death_loss_for_love_affection")); int
								 * lossEstate = Integer.parseInt(rs.getString("death_loss_estate")); int
								 * emotionalHarm = Integer.parseInt(rs.getString("death_emotional_harm_etc"));
								 * int stressDisorder = Integer
								 * .parseInt(rs.getString("death_post_traumatic_stress_disorder")); int
								 * nonPecuniary =
								 * Integer.parseInt(rs.getString("death_any_other_nonpecuniary"));
								 * 
								 * int totalloss = loveaffection + totalDependency + medicalExpenses +
								 * funderalExpenses + otherPecuniary + lossConsortium + lossEstate +
								 * emotionalHarm + stressDisorder + nonPecuniary; String totalLossSuffered =
								 * Integer.toString(totalloss);
								 * pdf12Entity.setDeceasedTotalLossSuffered(totalLossSuffered);
								 */
								
								pdf12Entity.setLossSufferedValue(rs.getString("loss_suufer_value_vehilce"));
								pdf12Entity.setDeceasedcapannualincome(rs.getString("paying_cap_anual_income"));
								pdf12Entity.setDeceasedmovableasset(rs.getString("paying_cap_moveable_asset"));
								pdf12Entity.setDeceasedimmovableasset(rs.getString("paying_cap_immovable_assets"));
								pdf12Entity.setDeceasedrecommendation(rs.getString("slsa_recommendation"));
							} while (rs.next());
						}
						return pdf12Entity;
					}
				});
				List<DeceasedLeagalRepresentatives> deceasedLegalRespresentatives12 = new ArrayList<DeceasedLeagalRepresentatives>();
				SqlParameterSource parameters13h = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report12LegalRepDeceased, parameters13h, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						do {
							DeceasedLeagalRepresentatives deceasedLegalRepresentative = new DeceasedLeagalRepresentatives();
							deceasedLegalRepresentative.setName(rs.getString("legalRepName"));
							deceasedLegalRepresentative.setAge(rs.getString("legalRepAge"));
							deceasedLegalRepresentative.setRelation(rs.getString("legalRepRelation"));
							deceasedLegalRepresentative.setGender(rs.getString("gender"));
							deceasedLegalRespresentatives.add(deceasedLegalRepresentative);
							pdf12Entity.setDeceasedLegalRepresentatives(deceasedLegalRespresentatives);

						} while (rs.next());
						return pdf12Entity;
					}
				});
			} else if (pdf12Entity.getInjurySeverity().equals("2") || pdf12Entity.getInjurySeverity().equals("3")
					|| pdf12Entity.getInjurySeverity().equals("4")) {
				SqlParameterSource parameters12e = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report12PedInjured, parameters12e, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						if (rs != null) {
							do {
								pdf12Entity.setInjuredName(rs.getString("name"));
								pdf12Entity.setInjuredAge(rs.getString("age"));
								pdf12Entity.setInjuredGender(rs.getString("gender"));
								pdf12Entity.setInjuredOccupation(rs.getString("occupation"));
								pdf12Entity.setInjuryNatureAndDescription(rs.getString("severity"));
								pdf12Entity.setInjuredMedicalTreatment(
										rs.getString("inj_medical_treatment_taken_by_injured"));
								pdf12Entity
										.setHospitalNameAndHospitalizationPeriod(rs.getString("inj_name_of_hospital"));
								pdf12Entity.setPermanentDisability(rs.getString("inj_permenant_disablity"));
								pdf12Entity.setReimbursementOfMedicalExpenses(rs.getString("inj_got_reimpuresement"));
								pdf12Entity.setInjuredTreatmentExpenditureEstimation(rs.getString("inj_treatment"));
								//pdf12Entity.setInjuredExpenditureOnTreatment(rs.getString("inj_treatment"));
								pdf12Entity.setInjuredExpenditureOnConveyance(rs.getString("inj_convenance"));
								pdf12Entity.setInjuredExpenditureOnSpecialDiet(rs.getString("inj_special_diet"));
								pdf12Entity
										.setInjuredExpenditureOnAttendant(rs.getString("inj_cost_nursing_attendant"));
								pdf12Entity.setInjuredLossOfIncome(rs.getString("inj_loss_income"));
								pdf12Entity.setInjuredSpecialTreatment(
										rs.getString("inj_any_other_loss_req_special_treatment"));
								pdf12Entity.setIjuredNatureOfDisability(rs.getString("inj_percentage_disablity"));
								pdf12Entity.setInjuredLossOfEarningCapacity(rs.getString("inj_loss_erning_capacity"));
								pdf12Entity.setInjuredPecuniaryLoss(rs.getString("inj_any_other_pecuniary_loss"));
								pdf12Entity.setInjuredPainAndSuffering(rs.getString("inj_pain_suffering"));
								pdf12Entity.setInjuredLossOfAmenities(rs.getString("inj_loss_amenities"));

								pdf12Entity.setInjuredEmotionalHarmTaruma(rs.getString("inj_com_mental_phy_shock"));
								pdf12Entity.setInjuredPostTraumaticDisorder(rs.getString("inj_post_traumatic"));
								pdf12Entity.setInjuredDisfiguration(rs.getString("inj_disfiguration"));
								pdf12Entity
										.setInjuredLossOfMarriageProspects(rs.getString("inj_loss_marriage_prospects"));
								pdf12Entity.setInjuredLossOfReputation(rs.getString("inj_loss_reputation"));
								pdf12Entity.setInjuredOtherNonPecuniaryLoss(rs.getString("inj_anyother_non_pecuniary"));
								pdf12Entity.setInjuredMaritalStatus(rs.getString("marital_status"));
								pdf12Entity.setInjuredFatherOrSpouseName(rs.getString("father_name"));
								pdf12Entity.setInjuredIncome(rs.getString("income"));
								pdf12Entity.setMobileNumber(rs.getString("mobile"));
								pdf12Entity.setPermanentAddress(rs.getString("residence"));
								pdf12Entity.setPresentAddress(rs.getString("residence"));
								pdf12Entity.setPermanentDisability(rs.getString("inj_permenant_disablity"));
								pdf12Entity.setReimbursementOfMedicalExpenses(rs.getString("inj_got_reimpuresement"));
								pdf12Entity.setHospitalPeriod(rs.getString("inj_peroid_of_hospital"));
								pdf12Entity.setEmailId(rs.getString("emailid"));
								pdf12Entity.setSurgeriesDetails(rs.getString("hospital_treatment_surgery_details"));
								pdf12Entity.setPropertyDamageDescription(rs.getString("property_description"));

//								int multiplier = Integer.parseInt(rs.getString("multiplier"));
//								int injTreatment = Integer.parseInt(rs.getString("inj_treatment"));
//								int injConvenance = Integer.parseInt(rs.getString("inj_convenance"));
//								int injSpecial = Integer.parseInt(rs.getString("inj_special_diet"));
//								int costNursing = Integer.parseInt(rs.getString("inj_cost_nursing_attendant"));
//								
//								int injtreatment = Integer.parseInt(rs.getString("inj_treatment"));
//								int lossincome = Integer.parseInt(rs.getString("inj_loss_income"));
//								int specialtreatment = Integer
//										.parseInt(rs.getString("inj_any_other_loss_req_special_treatment"));
//								int earningcapacity = Integer.parseInt(rs.getString("inj_loss_erning_capacity"));
//								int pecuniaryloss = Integer.parseInt(rs.getString("inj_any_other_pecuniary_loss"));
//								int painsuffering = Integer.parseInt(rs.getString("inj_pain_suffering"));
//								int amenitiesloss = Integer.parseInt(rs.getString("inj_loss_amenities"));
//								int physhock = Integer.parseInt(rs.getString("inj_com_mental_phy_shock"));
//								int marraiageprospects = Integer.parseInt(rs.getString("inj_loss_marriage_prospects"));
//								int reputation = Integer.parseInt(rs.getString("inj_loss_reputation"));
//								int nonpecuniaryloss = Integer.parseInt(rs.getString("inj_anyother_non_pecuniary"));
//								int disfiguration = Integer.parseInt(rs.getString("inj_disfiguration"));
//								int posttraumic = Integer.parseInt(rs.getString("inj_post_traumatic"));
//								int nonpecunairy = Integer.parseInt(rs.getString("inj_anyother_non_pecuniary"));
//								int futureIncome = lossincome *(earningcapacity)*multiplier;
//								int futureIncome1=futureIncome/100;
//								int cost=injTreatment+injConvenance+injSpecial+costNursing;
//								
//								int totalloss = cost + lossincome + specialtreatment + disfiguration+posttraumic+injtreatment
//										+ pecuniaryloss + painsuffering + amenitiesloss + physhock + marraiageprospects
//										+ reputation + nonpecuniaryloss + futureIncome1+nonpecunairy;
//								
//								String totalLossSuffered = Integer.toString(totalloss);
//								String lossFutureIncome = Integer.toString(futureIncome1);
								//pdf12Entity.setInjuredLossOfFutureIncome(lossFutureIncome);
								
								
								pdf12Entity.setLossSufferedValue(rs.getString("loss_suufer_value_vehilce"));
								
							
								
								//pdf12Entity.setInjuredExpenditureOnTreatment(Integer.toString(cost));report12PedInjured
								pdf12Entity.setInjuredTotalLossSuffered(rs.getString("inj_total_copensation"));
								
								pdf12Entity.setDeceasedcapannualincome(rs.getString("paying_cap_anual_income"));
								pdf12Entity.setDeceasedmovableasset(rs.getString("paying_cap_moveable_asset"));
								pdf12Entity.setDeceasedimmovableasset(rs.getString("paying_cap_immovable_assets"));
								pdf12Entity.setDeceasedrecommendation(rs.getString("slsa_recommendation"));
								
								// pdf12Entity.setInjuredTotalLossSuffered(rs.getString("vehicleRegNo"));
								// pdf12Entity.setInjuryNatureAndDescription(rs.getString("vehicleRegNo"));
								// pdf12Entity.setInjuredMedicalTreatment(rs.getString("vehicleRegNo"));
								// pdf12Entity.setHospitalNameAndHospitalizationPeriod(rs.getString("vehicleRegNo"));
								// pdf12Entity.setSurgeriesDetails(rs.getString("vehicleRegNo"));
								// pdf12Entity.setPermanentDisability(rs.getString("vehicleRegNo"));
								// pdf12Entity.setReimbursementOfMedicalExpenses(rs.getString("vehicleRegNo"));
								// list is pending
								// pdf12Entity.setInjuredPecuniaryLoss(rs.getString("vehicleRegNo"));
							} while (rs.next());
						}
						return pdf12Entity;
					}
				});
				List<DeceasedLeagalRepresentatives> deceasedLegalRespresentatives12 = new ArrayList<DeceasedLeagalRepresentatives>();
				SqlParameterSource parameters13h = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report12LegalRepInjured, parameters13h, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						do {
							DeceasedLeagalRepresentatives deceasedLegalRepresentative = new DeceasedLeagalRepresentatives();
							deceasedLegalRepresentative.setName(rs.getString("legalRepName"));
							deceasedLegalRepresentative.setAge(rs.getString("legalRepAge"));
							deceasedLegalRepresentative.setRelation(rs.getString("legalRepRelation"));
							deceasedLegalRepresentative.setGender(rs.getString("gender"));
							deceasedLegalRespresentatives.add(deceasedLegalRepresentative);
							pdf12Entity.setDeceasedLegalRepresentatives(deceasedLegalRespresentatives);

						} while (rs.next());
						return pdf12Entity;
					}
				});
			}

		} else if (mode.equalsIgnoreCase("driver")) {
			SqlParameterSource parameters6a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicle_id).addValue("personId", personId);
			namedParameterJdbcTemplate.query(driverSeverity12, parameters6a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					int length = report12Accussed.length();
					if (length >= 1) {
						pdf12Entity.setAccusedVictim("Accused");
					} else {
						pdf12Entity.setAccusedVictim("Victim");
					}
					pdf12Entity.setInjurySeverity(injurySeverity);
					return pdf12Entity;
				}
			});
			if (pdf12Entity.getInjurySeverity().equals("1")) {
				SqlParameterSource parameters12f = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report12driDeceased, parameters12f, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						if (rs != null) {
							do {

								pdf12Entity.setDeceasedName(rs.getString("name"));
								pdf12Entity.setDeceasedAge(rs.getString("age"));
								pdf12Entity.setDeceasedGender(rs.getString("ser_gender"));
								pdf12Entity.setDeceasedOccupation(rs.getString("occupation"));
								pdf12Entity.setDeceasedIncome(rs.getString("death_income"));
								pdf12Entity.setDeceasedAddFutureProspects(rs.getString("death_future_prospects"));
								pdf12Entity
										.setDeceasedLessPersonalExpenses(rs.getString("death_less_personal_expenses"));
								pdf12Entity
										.setDeceasedMonthlyLossDependency(rs.getString("death_monthly_loss_depedency"));
								pdf12Entity.setAnnualLossDependency(rs.getString("death_anual_loss_depedency"));
								pdf12Entity.setDeceasedMultiplier(rs.getString("death_mulltiplier"));
								pdf12Entity.setDeceasedTotalLossDependency(rs.getString("death_total_loss_dependency"));
								pdf12Entity.setDeceasedMedicalExpenses(rs.getString("death_medical_expenses"));
								pdf12Entity.setDeceasedFuneralExpenses(rs.getString("death_loss_funeral_expenses"));
								pdf12Entity.setDeceasedPecuniaryLossDamage(rs.getString("death_any_other_pecuniary"));
								pdf12Entity.setDeceasedLossOfConsortium(rs.getString("death_loss_consortium"));
								pdf12Entity
										.setDeceasedLossOfLoveAffection(rs.getString("death_loss_for_love_affection"));
								pdf12Entity.setDeceasedLossOfEstate(rs.getString("death_loss_estate"));
								pdf12Entity.setDeceasedEmotionalHarmTaruma(rs.getString("death_emotional_harm_etc"));
								pdf12Entity.setDeceasedPostTraumaticDisorder(
										rs.getString("death_post_traumatic_stress_disorder"));
								pdf12Entity
										.setDeceasedOtherNonPecuniaryLoss(rs.getString("death_any_other_nonpecuniary"));
								pdf12Entity.setDeceasedFatherOrSpouseName(rs.getString("driver_father_name"));
								pdf12Entity.setMobileNumber(rs.getString("mobile_no"));
								pdf12Entity.setEmailId(rs.getString("emailid"));
								String permanentAddress = rs.getString("ser_permadd1") + rs.getString("ser_permadd2")
										+ rs.getString("ser_permadd3");
								pdf12Entity.setPermanentAddress(permanentAddress);
								pdf12Entity.setPresentAddress(permanentAddress);
								pdf12Entity.setPropertyDamageDescription(rs.getString("property_description"));
								pdf12Entity.setDeceasedMaritalStatus(rs.getString("driver_martialstatus"));
//								int totalDependency = Integer.parseInt(rs.getString("death_total_loss_dependency"));
//								int medicalExpenses = Integer.parseInt(rs.getString("death_medical_expenses"));
//								int funderalExpenses = Integer.parseInt(rs.getString("death_loss_funeral_expenses"));
//								int otherPecuniary = Integer.parseInt(rs.getString("death_any_other_pecuniary"));
//
//								int lossConsortium = Integer.parseInt(rs.getString("death_loss_consortium"));
//								int loveaffection = Integer.parseInt(rs.getString("death_loss_for_love_affection"));
//								int lossEstate = Integer.parseInt(rs.getString("death_loss_estate"));
//								int emotionalHarm = Integer.parseInt(rs.getString("death_emotional_harm_etc"));
//								int stressDisorder = Integer
//										.parseInt(rs.getString("death_post_traumatic_stress_disorder"));
//								int nonPecuniary = Integer.parseInt(rs.getString("death_any_other_nonpecuniary"));
//
//								int totalloss = loveaffection + totalDependency + medicalExpenses + funderalExpenses
//										+ otherPecuniary + lossConsortium + lossEstate + emotionalHarm + stressDisorder
//										+ nonPecuniary;
								//String totalLossSuffered = Integer.toString(totalloss);
								pdf12Entity.setLossSufferedValue(rs.getString("loss_suufer_value_vehilce"));
								pdf12Entity.setDeceasedTotalLossSuffered(" ");
								
								pdf12Entity.setDeceasedcapannualincome(rs.getString("paying_cap_anual_income"));
								pdf12Entity.setDeceasedmovableasset(rs.getString("paying_cap_moveable_asset"));
								pdf12Entity.setDeceasedimmovableasset(rs.getString("paying_cap_immovable_assets"));
								pdf12Entity.setDeceasedrecommendation(rs.getString("slsa_recommendation"));
							} while (rs.next());
						}
						return pdf12Entity;
					}
				});
				List<DeceasedLeagalRepresentatives> deceasedLegalRespresentatives12 = new ArrayList<DeceasedLeagalRepresentatives>();
				SqlParameterSource parameters13h = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report12LegalRepDeceased, parameters13h, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						do {
							DeceasedLeagalRepresentatives deceasedLegalRepresentative = new DeceasedLeagalRepresentatives();
							deceasedLegalRepresentative.setName(rs.getString("legalRepName"));
							deceasedLegalRepresentative.setAge(rs.getString("legalRepAge"));
							deceasedLegalRepresentative.setRelation(rs.getString("legalRepRelation"));
							deceasedLegalRepresentative.setGender(rs.getString("gender"));
							deceasedLegalRespresentatives.add(deceasedLegalRepresentative);
							pdf12Entity.setDeceasedLegalRepresentatives(deceasedLegalRespresentatives);

						} while (rs.next());
						return pdf12Entity;
					}
				});
			}

			else if (pdf12Entity.getInjurySeverity().equals("2") || pdf12Entity.getInjurySeverity().equals("3")
					|| pdf12Entity.getInjurySeverity().equals("4")) {
				SqlParameterSource parameters12g = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report12driInjured, parameters12g, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						if (rs != null) {
							do {

								pdf12Entity.setInjuredName(rs.getString("name"));
								pdf12Entity.setInjuredAge(rs.getString("age"));
								pdf12Entity.setInjuredGender(rs.getString("ser_gender"));
								pdf12Entity.setInjuredOccupation(rs.getString("occupation"));
								pdf12Entity.setInjuryNatureAndDescription(rs.getString("severity"));
								pdf12Entity.setInjuredMedicalTreatment(
										rs.getString("inj_medical_treatment_taken_by_injured"));
								pdf12Entity
										.setHospitalNameAndHospitalizationPeriod(rs.getString("inj_name_of_hospital"));
								pdf12Entity.setPermanentDisability(rs.getString("inj_permenant_disablity"));
								pdf12Entity.setReimbursementOfMedicalExpenses(rs.getString("inj_got_reimpuresement"));
								pdf12Entity.setInjuredTreatmentExpenditureEstimation(rs.getString("inj_treatment"));
								//pdf12Entity.setInjuredExpenditureOnTreatment(rs.getString("inj_treatment"));
								pdf12Entity.setInjuredExpenditureOnConveyance(rs.getString("inj_convenance"));
								pdf12Entity.setInjuredExpenditureOnSpecialDiet(rs.getString("inj_special_diet"));
								pdf12Entity
										.setInjuredExpenditureOnAttendant(rs.getString("inj_cost_nursing_attendant"));
								pdf12Entity.setInjuredLossOfIncome(rs.getString("inj_loss_income"));
								pdf12Entity.setInjuredSpecialTreatment(
										rs.getString("inj_any_other_loss_req_special_treatment"));
								pdf12Entity.setIjuredNatureOfDisability(rs.getString("inj_percentage_disablity"));
								pdf12Entity.setInjuredLossOfEarningCapacity(rs.getString("inj_loss_erning_capacity"));
								pdf12Entity.setInjuredPecuniaryLoss(rs.getString("inj_any_other_pecuniary_loss"));
								pdf12Entity.setInjuredPainAndSuffering(rs.getString("inj_pain_suffering"));
								pdf12Entity.setInjuredLossOfAmenities(rs.getString("inj_loss_amenities"));
								pdf12Entity.setInjuredPostTraumaticDisorder(rs.getString("inj_post_traumatic"));
								pdf12Entity.setInjuredEmotionalHarmTaruma(rs.getString("inj_com_mental_phy_shock"));
								pdf12Entity.setInjuredDisfiguration(rs.getString("inj_disfiguration"));
								pdf12Entity
										.setInjuredLossOfMarriageProspects(rs.getString("inj_loss_marriage_prospects"));
								pdf12Entity.setInjuredLossOfReputation(rs.getString("inj_loss_reputation"));
								pdf12Entity.setInjuredOtherNonPecuniaryLoss(rs.getString("inj_anyother_non_pecuniary"));
								pdf12Entity.setInjuredFatherOrSpouseName(rs.getString("driver_father_name"));
								pdf12Entity.setMobileNumber(rs.getString("mobile_no"));
								pdf12Entity.setEmailId(rs.getString("emailid"));
								String permanentAddress = rs.getString("ser_permadd1") + rs.getString("ser_permadd2")
										+ rs.getString("ser_permadd3");
								pdf12Entity.setPermanentAddress(permanentAddress);
								pdf12Entity.setPresentAddress(permanentAddress);
								pdf12Entity.setDeceasedMaritalStatus(rs.getString("driver_martialstatus"));
								pdf12Entity.setHospitalPeriod(rs.getString("inj_peroid_of_hospital"));
								pdf12Entity.setSurgeriesDetails(rs.getString("hospital_treatment_surgery_details"));
								pdf12Entity.setPropertyDamageDescription(rs.getString("property_description"));

//								int injTreatment = Integer.parseInt(rs.getString("inj_treatment"));
//								int injConvenance = Integer.parseInt(rs.getString("inj_convenance"));
//								int injSpecial = Integer.parseInt(rs.getString("inj_special_diet"));
//								int costNursing = Integer.parseInt(rs.getString("inj_cost_nursing_attendant"));
//								int injtreatment = Integer.parseInt(rs.getString("inj_treatment"));
//								int lossincome = Integer.parseInt(rs.getString("inj_loss_income"));
//								int specialtreatment = Integer
//										.parseInt(rs.getString("inj_any_other_loss_req_special_treatment"));
//								int diabilitypercent = Integer.parseInt(rs.getString("inj_percentage_disablity"));
//								int earningcapacity = Integer.parseInt(rs.getString("inj_loss_erning_capacity"));
//								int pecuniaryloss = Integer.parseInt(rs.getString("inj_any_other_pecuniary_loss"));
//								int painsuffering = Integer.parseInt(rs.getString("inj_pain_suffering"));
//								int amenitiesloss = Integer.parseInt(rs.getString("inj_loss_amenities"));
//								int physhock = Integer.parseInt(rs.getString("inj_com_mental_phy_shock"));
//								int marraiageprospects = Integer.parseInt(rs.getString("inj_loss_marriage_prospects"));
//								int reputation = Integer.parseInt(rs.getString("inj_loss_reputation"));
//								int nonpecuniaryloss = Integer.parseInt(rs.getString("inj_anyother_non_pecuniary"));
//								int multiplier = Integer.parseInt(rs.getString("multiplier"));
//								int futureIncome = lossincome * earningcapacity * multiplier;
//								int totalloss = injTreatment + injConvenance + injSpecial + costNursing + injtreatment
//										+ lossincome + specialtreatment + diabilitypercent + earningcapacity
//										+ pecuniaryloss + painsuffering + amenitiesloss + physhock + marraiageprospects
//										+ reputation + nonpecuniaryloss + futureIncome;
//								String totalLossSuffered = Integer.toString(totalloss);
//								String lossFutureIncome = Integer.toString(futureIncome);
								
								//pdf12Entity.setInjuredLossOfFutureIncome(lossFutureIncome);
								pdf12Entity.setInjuredTotalLossSuffered(rs.getString("inj_total_copensation"));
								//int cost=injTreatment+injConvenance+injSpecial+costNursing;
								//pdf12Entity.setInjuredExpenditureOnTreatment(Integer.toString(cost));
								pdf12Entity.setLossSufferedValue(rs.getString("loss_suufer_value_vehilce"));
								// pdf12Entity.setInjuredTotalLossSuffered(rs.getString("vehicleRegNo"));
								// pdf12Entity.setInjuredMaritalStatus(rs.getString("marital_status"));
								// pdf12Entity.setInjuredIncome(rs.getString("income"));
								// pdf12Entity.setInjuryNatureAndDescription(rs.getString("vehicleRegNo"));
								// pdf12Entity.setInjuredMedicalTreatment(rs.getString("vehicleRegNo"));
								// pdf12Entity.setHospitalNameAndHospitalizationPeriod(rs.getString("vehicleRegNo"));
								// pdf12Entity.setSurgeriesDetails(rs.getString("vehicleRegNo"));
								// pdf12Entity.setPermanentDisability(rs.getString("vehicleRegNo"));
								// pdf12Entity.setReimbursementOfMedicalExpenses(rs.getString("vehicleRegNo"));
								// list is pending
								// pdf12Entity.setInjuredPecuniaryLoss(rs.getString("vehicleRegNo"));
								pdf12Entity.setDeceasedcapannualincome(rs.getString("paying_cap_anual_income"));
								pdf12Entity.setDeceasedmovableasset(rs.getString("paying_cap_moveable_asset"));
								pdf12Entity.setDeceasedimmovableasset(rs.getString("paying_cap_immovable_assets"));
								pdf12Entity.setDeceasedrecommendation(rs.getString("slsa_recommendation"));
							} while (rs.next());
						}
						return pdf12Entity;
					}
				});
				List<DeceasedLeagalRepresentatives> deceasedLegalRespresentatives12 = new ArrayList<DeceasedLeagalRepresentatives>();
				SqlParameterSource parameters13h = new MapSqlParameterSource().addValue("accidentId", accidentId)
						.addValue("vehicleId", vehicle_id).addValue("personId", personId);
				namedParameterJdbcTemplate.query(report12LegalRepInjured, parameters13h, new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						do {
							DeceasedLeagalRepresentatives deceasedLegalRepresentative = new DeceasedLeagalRepresentatives();
							deceasedLegalRepresentative.setName(rs.getString("legalRepName"));
							deceasedLegalRepresentative.setAge(rs.getString("legalRepAge"));
							deceasedLegalRepresentative.setRelation(rs.getString("legalRepRelation"));
							deceasedLegalRepresentative.setGender(rs.getString("gender"));
							deceasedLegalRespresentatives.add(deceasedLegalRepresentative);
							pdf12Entity.setDeceasedLegalRepresentatives(deceasedLegalRespresentatives);

						} while (rs.next());
						return pdf12Entity;
					}
				});
			}

		}
		return pdf12Entity;
	}

	@Override
	public Pdf13Entity getPdf13Report(String accidentId, String vehicleId, String personId, String personType) {
		Pdf13Entity pdf13Entity = new Pdf13Entity();
		pdf13Entity.setStateCode(accidentId.substring(4, 6));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		String currentDate = dtf.format(now);
		pdf13Entity.setCurrentDate(currentDate);
		if (personType.equalsIgnoreCase("Passenger")) {

			SqlParameterSource parameters10a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(report13Pass, parameters10a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf13Entity.setAccidentId(rs.getString("accident_id"));
					pdf13Entity.setAccidentDate(rs.getString("reporting_datetime"));
					pdf13Entity.setDeceasedName(rs.getString("name"));
					pdf13Entity.setDeceasedAge(rs.getString("age"));
					pdf13Entity.setDeceasedOccupation(rs.getString("occupation"));
					return rowNum;
				}
			});

			SqlParameterSource parameters12a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(passengerSeverity13, parameters12a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					pdf13Entity.setDeceasedInjurySeverity(injurySeverity);
					return pdf13Entity;
				}
			});
		} else if (personType.equalsIgnoreCase("Pedestrian")) {

			SqlParameterSource report10a = new MapSqlParameterSource().addValue("accidentId", accidentId).addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(report13Ped, report10a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf13Entity.setAccidentId(rs.getString("accident_id"));
					pdf13Entity.setAccidentDate(rs.getString("reporting_datetime"));
					pdf13Entity.setDeceasedName(rs.getString("name"));
					pdf13Entity.setDeceasedAge(rs.getString("age"));
					pdf13Entity.setDeceasedOccupation(rs.getString("occupation"));
					return pdf13Entity;
				}
			});
			SqlParameterSource parameters13a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(pedestrianSeverity13, parameters13a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					pdf13Entity.setDeceasedInjurySeverity(injurySeverity);
					return pdf13Entity;
				}
			});
		} else if (personType.equalsIgnoreCase("Driver")) {

			SqlParameterSource parameters10a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(report13dri, parameters10a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf13Entity.setAccidentId(rs.getString("accident_id"));
					pdf13Entity.setAccidentDate(rs.getString("reporting_datetime"));
					pdf13Entity.setDeceasedName(rs.getString("name"));
					pdf13Entity.setDeceasedAge(rs.getString("age"));
					pdf13Entity.setDeceasedOccupation(rs.getString("occupation"));
					return pdf13Entity;
				}
			});
			SqlParameterSource parameters12a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(driverSeverity13, parameters12a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					pdf13Entity.setDeceasedInjurySeverity(injurySeverity);
					return pdf13Entity;
				}
			});

		}

		if (pdf13Entity.getDeceasedInjurySeverity().equals("1")) {
			SqlParameterSource parameters12b = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(report13Deceased, parameters12b, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					if (rs != null) {
						do {

							pdf13Entity.setPetitionersDeceasedIncome(rs.getString("death_income"));
							pdf13Entity.setPetitionersFutureProspects(rs.getString("death_future_prospects"));
							pdf13Entity.setPetitionersDeceasedPersonalExpenses(
									rs.getString("death_less_personal_expenses"));
//							int petitionerA = Integer.parseInt(rs.getString("death_income"));
//							int petitionerB = Integer.parseInt(rs.getString("death_future_prospects"));
//							int petitionerC = Integer.parseInt(rs.getString("death_less_personal_expenses"));
//							int petitionerD = (petitionerA + petitionerB) - petitionerC;
//							pdf13Entity.setPetitionersMonthlyLoss(Integer.toString(petitionerD));
//							pdf13Entity.setPetitionersAnnualLoss(Integer.toString(petitionerD * 12));

							pdf13Entity.setPetitionersMonthlyLoss(rs.getString("death_monthly_loss_depedency"));
							pdf13Entity.setPetitionersAnnualLoss(rs.getString("death_anual_loss_depedency"));

							pdf13Entity.setPetitionersMultiplier(rs.getString("death_mulltiplier"));
//							int petitionerE = Integer.parseInt(rs.getString("death_mulltiplier"));
//							int petitionerF = petitionerD * 12 * petitionerE;
							pdf13Entity.setPetitionersTotalLoss(rs.getString("death_total_loss_dependency"));
							pdf13Entity.setPetitionersMedicalExpense(rs.getString("death_medical_expenses"));
							pdf13Entity.setPetitionersLossConsortium(rs.getString("death_loss_consortium"));
							pdf13Entity.setPetitionersLoveAffection(rs.getString("death_loss_for_love_affection"));
							pdf13Entity.setPetitionersLossEstate(rs.getString("death_loss_estate"));
							pdf13Entity.setPetitionersFuneralExpenses(rs.getString("death_loss_funeral_expenses"));

//							int petitionerG = Integer.parseInt(rs.getString("death_medical_expenses"));
//							int petitionerH = Integer.parseInt(rs.getString("death_loss_consortium"));
//							int petitionerI = Integer.parseInt(rs.getString("death_loss_for_love_affection"));
//							int petitionerJ = Integer.parseInt(rs.getString("death_loss_estate"));
//							int petitionerK = Integer.parseInt(rs.getString("death_loss_funeral_expenses"));
//							int PetitionerTotal = petitionerF + petitionerG + petitionerH + petitionerI + petitionerI+ petitionerJ + petitionerK;
//							  int PetitionerTotal = petitionerF+Integer.parseInt(rs.getString("death_medical_expenses"))+Integer.parseInt(rs.getString("death_loss_consortium"))+Integer.parseInt(rs.getString("death_loss_for_love_affection"))
//									  +Integer.parseInt(rs.getString("death_loss_estate"))+Integer.parseInt(rs.getString("death_loss_funeral_expenses"));
							pdf13Entity.setPetitionersTotalCompensation(rs.getString("death_total_compensation"));
							// pdf13Entity.setPetitionersTotalCompensation(Integer.toString(petitionerF));
							pdf13Entity.setPetitionersTotalInterest(rs.getString("death_interest"));

							pdf13Entity.setRespondentsDeceasedIncome(rs.getString("ins_death_income"));
							pdf13Entity.setRespondentsFutureProspects(rs.getString("ins_death_future_prospects"));
							pdf13Entity.setRespondentsDeceasedPersonalExpenses(
									rs.getString("ins_death_less_personal_expenses"));
//							int respondentA = Integer.parseInt(rs.getString("ins_death_income"));
//							int respondentB = Integer.parseInt(rs.getString("ins_death_future_prospects"));
//							int respondentC = Integer.parseInt(rs.getString("ins_death_less_personal_expenses"));
//							int respondentD = (respondentA + respondentB) - respondentC;
							pdf13Entity.setRespondentsMonthlyLoss(rs.getString("ins_death_monthly_loss_depedency"));
							pdf13Entity.setRespondentsAnnualLoss(rs.getString("ins_death_anual_loss_depedency"));

							pdf13Entity.setRespondentsMultiplier(rs.getString("ins_death_mulltiplier"));

//							double respondentE = Double.parseDouble(rs.getString("ins_death_mulltiplier"));
//							double respondentF = respondentD * 12 * respondentE;

							pdf13Entity.setRespondentsTotalLoss(rs.getString("ins_death_total_loss_dependency"));
							pdf13Entity.setRespondentsMedicalExpense(rs.getString("ins_death_medical_expenses"));
							pdf13Entity.setRespondentsLossConsortium(rs.getString("ins_death_loss_consortium"));
							pdf13Entity.setRespondentsLoveAffection(rs.getString("ins_death_loss_for_love_affection"));
							pdf13Entity.setRespondentsLossEstate(rs.getString("ins_death_loss_estate"));
							pdf13Entity.setRespondentsFuneralExpenses(rs.getString("ins_death_loss_funeral_expenses"));
//							int respondentG = Integer.parseInt(rs.getString("ins_death_medical_expenses"));
//							int respondentH = Integer.parseInt(rs.getString("ins_death_loss_consortium"));
//							int respondentI = Integer.parseInt(rs.getString("ins_death_loss_for_love_affection"));
//							int respondentJ = Integer.parseInt(rs.getString("ins_death_loss_estate"));
//							int respondentK = Integer.parseInt(rs.getString("ins_death_loss_funeral_expenses"));
//							double respondentTotal = respondentF + respondentG + respondentH + respondentI + respondentJ
//									+ respondentK;
							// pdf13Entity.setRespondentsTotalCompensation(String.valueOf(respondentTotal));
							pdf13Entity.setRespondentsTotalCompensation(rs.getString("ins_death_total_compensation"));
							pdf13Entity.setRespondentsTotalInterest(rs.getString("ins_death_interest"));
						} while (rs.next());
					}
					return pdf13Entity;
				}
			});
		}
		List<DeceasedLeagalRepresentatives> deceasedLegalRespresentatives = new ArrayList<DeceasedLeagalRepresentatives>();
		SqlParameterSource parameters7 = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId).addValue("personId",personId);
		namedParameterJdbcTemplate.query(report13LegalRep, parameters7, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				do {
					DeceasedLeagalRepresentatives legalRepresentative = new DeceasedLeagalRepresentatives();
					legalRepresentative.setName(rs.getString("legalRepName"));
					legalRepresentative.setAge(rs.getString("legalRepAge"));
					legalRepresentative.setRelation(rs.getString("legalRepRelation"));
					deceasedLegalRespresentatives.add(legalRepresentative);
					pdf13Entity.setDeceasedLegalRepresentatives(deceasedLegalRespresentatives);

				} while (rs.next());
				return pdf13Entity;
			}
		});
		return pdf13Entity;
	}

	@Override
	public Pdf14Entity getPdf14Report(String accidentId, String vehicleId, String personId, String personType) {
		Pdf14Entity pdf14Entity = new Pdf14Entity();
		pdf14Entity.setStateCode(accidentId.substring(4, 6));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		String currentDate = dtf.format(now);
		pdf14Entity.setCurrentDate(currentDate);
		if (personType.equalsIgnoreCase("Passenger")) {
			SqlParameterSource parameters10a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(report14Pass, parameters10a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf14Entity.setAccidentId(rs.getString("accident_id"));
					pdf14Entity.setAccidentDate(rs.getString("accident_datetime"));
					pdf14Entity.setNameOfInjured(rs.getString("name"));
					pdf14Entity.setAgeOfInjured(rs.getString("age"));
					pdf14Entity.setOccupationOfInjured(rs.getString("occupation"));
					pdf14Entity.setIncomeOfInjured(rs.getString("income"));
					pdf14Entity.setNatureOfInjury(rs.getString("natureofinjury"));
					pdf14Entity.setMedicalTreatment(rs.getString("treatment_details"));
					pdf14Entity.setPeriodOfHospitalization(rs.getString("hospital_treatment_period"));
					pdf14Entity.setPermanentDisability(rs.getString("permanent_disability"));
					pdf14Entity.setPhotographsOfInjured(" ");

					return pdf14Entity;
				}
			});

			SqlParameterSource parameters12a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(passengerSeverity14, parameters12a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					pdf14Entity.setInjurySeverity(injurySeverity);
					return pdf14Entity;
				}
			});
		} else if (personType.equalsIgnoreCase("Pedestrian")) {

			SqlParameterSource parameters10a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(report14Ped, parameters10a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf14Entity.setAccidentId(rs.getString("accident_id"));
					pdf14Entity.setAccidentDate(rs.getString("accident_datetime"));
					pdf14Entity.setNameOfInjured(rs.getString("name"));
					pdf14Entity.setAgeOfInjured(rs.getString("age"));
					pdf14Entity.setOccupationOfInjured(rs.getString("occupation"));
					pdf14Entity.setIncomeOfInjured(rs.getString("income"));
					pdf14Entity.setNatureOfInjury(rs.getString("natureofinjury"));
					pdf14Entity.setMedicalTreatment(rs.getString("treatment_details"));
					pdf14Entity.setPeriodOfHospitalization(rs.getString("hospital_treatment_period"));
					pdf14Entity.setPermanentDisability(rs.getString("permanent_disability"));
					pdf14Entity.setPhotographsOfInjured(" ");
					return pdf14Entity;
				}
			});
			SqlParameterSource parameters12a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(pedestrianSeverity14, parameters12a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					pdf14Entity.setInjurySeverity(injurySeverity);
					return pdf14Entity;
				}
			});
		} else if (personType.equalsIgnoreCase("Driver")) {

			SqlParameterSource parameters10a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(report14dri, parameters10a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf14Entity.setAccidentId(rs.getString("accident_id"));
					pdf14Entity.setAccidentDate(rs.getString("accident_datetime"));
					pdf14Entity.setNameOfInjured(rs.getString("ser_name"));
					pdf14Entity.setAgeOfInjured(rs.getString("age"));
					pdf14Entity.setOccupationOfInjured(rs.getString("occupation"));
					pdf14Entity.setIncomeOfInjured(rs.getString("driver_income"));
					pdf14Entity.setNatureOfInjury(rs.getString("natureofinjury"));
					pdf14Entity.setMedicalTreatment(rs.getString("treatment_details"));
					pdf14Entity.setPeriodOfHospitalization(rs.getString("period_hospitlization"));
					pdf14Entity.setPermanentDisability(rs.getString("permanent_disability"));
					pdf14Entity.setPhotographsOfInjured(" ");
					return pdf14Entity;
				}
			});
			SqlParameterSource parameters12a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(driverSeverity14, parameters12a, new RowMapper<Object>() {

				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					pdf14Entity.setInjurySeverity(injurySeverity);
					return pdf14Entity;
				}
			});

		}

		if (pdf14Entity.getInjurySeverity().equals("2") || pdf14Entity.getInjurySeverity().equals("3")
				|| pdf14Entity.getInjurySeverity().equals("4")) {

			SqlParameterSource parameters12b = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(report14Injured, parameters12b, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					if (rs != null) {
						do {
							pdf14Entity.setPetitionersExpenditure_on_treatment(" ");
							pdf14Entity.setPetitionersExpenditure_on_conveniyance(rs.getString("inj_convenance"));
							pdf14Entity.setPetitionersexpenditure_on_specialdiet(rs.getString("inj_special_diet"));
							pdf14Entity.setPetitionersCost_of_nursing(rs.getString("inj_cost_nursing_attendant"));
							pdf14Entity.setPetitionersLoss_of_income(rs.getString("inj_loss_income"));
							pdf14Entity.setPetitionersCost_of_artificiallimb(rs.getString("inj_cost_artificial_limp"));
							pdf14Entity.setPetitionersAny_other_loss(rs.getString("inj_any_other_loss"));
							pdf14Entity
									.setPetitionersComp_mental_and_physical(rs.getString("inj_com_mental_phy_shock"));
							pdf14Entity.setPetitionersPain_and_suffering(rs.getString("inj_pain_suffering"));
							pdf14Entity.setPetitionersLoss_of_amenities(rs.getString("inj_loss_amenities"));
							pdf14Entity.setPetitionersDisfiguration(rs.getString("inj_disfiguration"));
							pdf14Entity.setPetitionersLoss_of_marriage_prospects(rs.getString("inj_loss_of_marriage"));
							pdf14Entity.setPetitionersLoss_of_earning_inconvenience(
									rs.getString("inj_loss_ear_inc_har_dis"));
							pdf14Entity.setPetitionersPercentage_of_disablity(rs.getString("inj_per_disablity"));
							pdf14Entity.setPetitionersLoss_of_amenities_or_expectation(
									rs.getString("inj_loss_ami_life_span"));
							pdf14Entity
									.setPetitionersPercentage_of_loss_of_earning(rs.getString("inj_per_loss_earning"));
							// int futureIncome =
							// Integer.parseInt(rs.getString("death_income"))*Integer.parseInt(rs.getString("inj_per_loss_earning"))*Integer.parseInt(rs.getString("inj_per_loss_earning"));
							pdf14Entity.setPetitionersLoss_of_future_income(rs.getString("in_loss_future_income"));
							pdf14Entity.setPetitionersTotalCompensation(rs.getString("inj_total_copensation"));
							pdf14Entity.setPetitionersInterest(rs.getString("inj_interest"));

							pdf14Entity.setRespondentsExpenditure_on_treatment(" ");
							pdf14Entity.setRespondentsExpenditure_on_conveniyance(rs.getString("ins_inj_convenance"));
							pdf14Entity.setRespondentsexpenditure_on_specialdiet(rs.getString("ins_inj_special_diet"));
							pdf14Entity.setRespondentsCost_of_nursing(rs.getString("ins_inj_cost_nursing_attendant"));
							pdf14Entity.setRespondentsLoss_of_income(rs.getString("ins_inj_loss_income"));
							pdf14Entity
									.setRespondentsCost_of_artificiallimb(rs.getString("ins_inj_cost_artificial_limp"));
							pdf14Entity.setRespondentsAny_other_loss(rs.getString("ins_inj_any_other_loss"));
							pdf14Entity.setRespondentsComp_mental_and_physical(
									rs.getString("ins_inj_com_mental_phy_shock"));
							pdf14Entity.setRespondentsPain_and_suffering(rs.getString("ins_inj_pain_suffering"));
							pdf14Entity.setRespondentsLoss_of_amenities(rs.getString("ins_inj_loss_amenities"));
							pdf14Entity.setRespondentsDisfiguration(rs.getString("ins_inj_disfiguration"));
							pdf14Entity
									.setRespondentsLoss_of_marriage_prospects(rs.getString("ins_inj_loss_of_marriage"));
							pdf14Entity.setRespondentsLoss_of_earning_inconvenience(
									rs.getString("ins_inj_loss_ear_inc_har_dis"));
							pdf14Entity.setRespondentsPercentage_of_disablity(
									rs.getString("ins_inj_disablity_percentage"));
							pdf14Entity.setRespondentsLoss_of_amenities_or_expectation(
									rs.getString("ins_inj_amenities_lifespan"));
							pdf14Entity.setRespondentsPercentage_of_loss_of_earning(
									rs.getString("ins_inj_percentage_earning_capacity"));
							pdf14Entity.setRespondentsLoss_of_future_income(rs.getString("ins_inj_loss_future_income"));
							pdf14Entity.setRespondentsTotalCompensation(rs.getString("ins_inj_total_copensation"));
							pdf14Entity.setRespondentsInterest(rs.getString("ins_inj_intrest"));

						} while (rs.next());
					}
					return pdf14Entity;
				}
			});
		}
		return pdf14Entity;
	}

	@Override
	public Pdf15Entity getPdf15Report(String accidentId, String vehicleId, String personId, String personType) {
		Pdf15Entity pdf15Entity = new Pdf15Entity();
		pdf15Entity.setStateCode(accidentId.substring(4, 6));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		String currentDate = dtf.format(now);
		pdf15Entity.setCurrentDate(currentDate);
		
		if (personType.equalsIgnoreCase("Passenger")) {

			SqlParameterSource parameters10a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(report15Pass, parameters10a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf15Entity.setAccidentId(rs.getString("accident_id"));
					pdf15Entity.setAccidentDate(rs.getString("reporting_datetime"));
					pdf15Entity.setDeceasedName(rs.getString("name"));
					pdf15Entity.setDeceasedAge(rs.getString("age"));
					pdf15Entity.setDeceasedOccupation(rs.getString("occupation"));
					// pdf15Entity.setDeceasedIncome("");
					return rowNum;
				}
			});

			SqlParameterSource parameters15a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(passengerSeverity15, parameters15a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					pdf15Entity.setDeceasedInjurySeverity(injurySeverity);
					return pdf15Entity;
				}
			});
		} else if (personType.equalsIgnoreCase("Pedestrian")) {

			SqlParameterSource parameters15b = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(report15Ped, parameters15b, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf15Entity.setAccidentId(rs.getString("accident_id"));
					pdf15Entity.setAccidentDate(rs.getString("reporting_datetime"));
					pdf15Entity.setDeceasedName(rs.getString("name"));
					pdf15Entity.setDeceasedAge(rs.getString("age"));
					pdf15Entity.setDeceasedOccupation(rs.getString("occupation"));
					// pdf15Entity.setDeceasedIncome("");
					return rowNum;
				}
			});
			SqlParameterSource parameters15c = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(pedestrianSeverity15, parameters15c, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					pdf15Entity.setDeceasedInjurySeverity(injurySeverity);
					return pdf15Entity;
				}
			});
		} else if (personType.equalsIgnoreCase("Driver")) {

			SqlParameterSource parameters15d = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(report15dri, parameters15d, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf15Entity.setAccidentId(rs.getString("accident_id"));
					pdf15Entity.setAccidentDate(rs.getString("reporting_datetime"));
					pdf15Entity.setDeceasedName(rs.getString("name"));
					pdf15Entity.setDeceasedAge(rs.getString("age"));
					pdf15Entity.setDeceasedOccupation(rs.getString("occupation"));
					// pdf15Entity.setDeceasedIncome("");
					return rowNum;
				}
			});
			SqlParameterSource parameters15e = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(driverSeverity15, parameters15e, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					pdf15Entity.setDeceasedInjurySeverity(injurySeverity);
					return pdf15Entity;
				}
			});

		}
		List<DeceasedLeagalRepresentatives> LeagalRepresentativesDetails = new ArrayList<DeceasedLeagalRepresentatives>();
		if (pdf15Entity.getDeceasedInjurySeverity().equals("1")) {
			SqlParameterSource parameters15Deceased = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(report15Deceased, parameters15Deceased, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					if (rs != null) {
						do {
							// pdf15Entity.setAccidentId(rs.getString(""));
							// pdf15Entity.setNameOfDeceased(rs.getString(""));
							// pdf15Entity.setAgeOfDeceased(rs.getString(""));
							// pdf15Entity.setOccupationOfDeceased(rs.getString(""));
							pdf15Entity.setDeceasedIncome(rs.getString("death_income"));
							pdf15Entity.setAddFutureProspects(rs.getString("death_future_prospects"));
							pdf15Entity.setLessPersonalExpenses(rs.getString("death_less_personal_expenses"));

//							int deceasedA = Integer.parseInt(rs.getString("death_income"));
//							int deceasedB = Integer.parseInt(rs.getString("death_future_prospects"));
//							int deceasedC = Integer.parseInt(rs.getString("death_less_personal_expenses"));
//							int deceasedD = (deceasedA + deceasedB) - deceasedC;

							pdf15Entity.setMonthlyLoss(rs.getString("death_monthly_loss_depedency"));

							pdf15Entity.setAnnualLoss(rs.getString("death_anual_loss_depedency"));

//							int deceasedE = Integer.parseInt(rs.getString("death_mulltiplier"));
//							int deceasedF = (deceasedD) * 12 * deceasedE;

							pdf15Entity.setMultiplier(rs.getString("death_mulltiplier"));

							pdf15Entity.setTotalLossOfDependency(rs.getString("death_total_loss_dependency"));

							pdf15Entity.setMedicalExpenses(rs.getString("death_medical_expenses"));
							pdf15Entity.setCompForLossOfConsortium(rs.getString("death_loss_consortium"));
							pdf15Entity.setCompForlossOfLoveAndAffection(rs.getString("death_loss_for_love_affection"));
							pdf15Entity.setCompForlossOfEstate(rs.getString("death_loss_estate"));
							pdf15Entity.setCompTowardsFuneralExpenses(rs.getString("death_loss_funeral_expenses"));

//							int deceasedG = Integer.parseInt(rs.getString("death_medical_expenses"));
//							int deceasedH = Integer.parseInt(rs.getString("death_loss_consortium"));
//							int deceasedI = Integer.parseInt(rs.getString("death_loss_for_love_affection"));
//							int deceasedJ = Integer.parseInt(rs.getString("death_loss_estate"));
//							int deceasedK = Integer.parseInt(rs.getString("death_loss_funeral_expenses"));
//							int total = deceasedF + deceasedG + deceasedH + deceasedI + deceasedJ + deceasedK;
							pdf15Entity.setTotalCompensation(rs.getString("death_total_compensation"));

							pdf15Entity.setRateOfInterest(rs.getString("death_rate_interest"));
							pdf15Entity.setInterestToDateOfAward(rs.getString("death_interest_amount"));

							int deceasedM = Integer.parseInt(rs.getString("death_interest_amount"));

//							int totalInterestAmount = total + deceasedM;
							pdf15Entity.setTotalAmntIncludeInterest(rs.getString("total_amt_with_interest"));

							pdf15Entity.setAwardAmntReleased(rs.getString("award_amt_released"));
							pdf15Entity.setAwardAmntInFDR(rs.getString("award_amt_in_fdrs"));
							pdf15Entity.setModeOfDisbursement(rs.getString("mode_disbursement"));
							pdf15Entity.setNextDateForCompliance(rs.getString("nest_date_award"));
						} while (rs.next());
					}
					return pdf15Entity;
				}
			});
		}
		SqlParameterSource parameters15f = new MapSqlParameterSource().addValue("accidentId", accidentId)
				.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
		namedParameterJdbcTemplate.query(report15LegalRep, parameters15f, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {
						DeceasedLeagalRepresentatives leagalRepresentatives = new DeceasedLeagalRepresentatives();
						leagalRepresentatives.setName(rs.getString("legalRepName"));
						leagalRepresentatives.setAge(rs.getString("legalRepAge"));
						leagalRepresentatives.setRelation(rs.getString("legalRepRelation"));
						LeagalRepresentativesDetails.add(leagalRepresentatives);
						pdf15Entity.setDeceasedLeagalRepresentatives(LeagalRepresentativesDetails);
					} while (rs.next());
				}
				return pdf15Entity;
			}
		});

		return pdf15Entity;
	}

	@Override
	public Pdf16Entity getPdf16Report(String accidentId, String vehicleId, String personId, String personType) {
		Pdf16Entity pdf16Entity = new Pdf16Entity();
		pdf16Entity.setStateCode(accidentId.substring(4, 6));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		String currentDate = dtf.format(now);
		pdf16Entity.setCurrentDate(currentDate);

		if (personType.equalsIgnoreCase("Passenger")) {
			SqlParameterSource parameters10a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(report16Pass, parameters10a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf16Entity.setAccidentId(rs.getString("accident_id"));
					pdf16Entity.setAccidentDate(rs.getString("reporting_datetime"));
					pdf16Entity.setInjuredName(rs.getString("name"));
					pdf16Entity.setInjuredAge(rs.getString("age"));
					pdf16Entity.setInjuredOccupation(rs.getString("occupation"));
					pdf16Entity.setInjuredIncome(rs.getString("income"));
					pdf16Entity.setInjuryNature(rs.getString("severity"));
					pdf16Entity.setInjuredMedicalTreatment(rs.getString("hospital_treatment_details"));
					pdf16Entity.setHospitalizationPeriod(rs.getString("hospital_treatment_period"));
					pdf16Entity.setPermanentDisability(rs.getString("permanent_disability"));
					
					pdf16Entity.setDisabilityDetails(rs.getString("permanent_disability_details"));

					return pdf16Entity;
				}
			});

			SqlParameterSource parameters12a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(passengerSeverity16, parameters12a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					pdf16Entity.setInjurySeverity(injurySeverity);
					return pdf16Entity;
				}
			});
		} else if (personType.equalsIgnoreCase("Pedestrian")) {

			SqlParameterSource parameters10a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(report16Ped, parameters10a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf16Entity.setAccidentId(rs.getString("accident_id"));
					pdf16Entity.setAccidentDate(rs.getString("reporting_datetime"));
					pdf16Entity.setInjuredName(rs.getString("name"));
					pdf16Entity.setInjuredAge(rs.getString("age"));
					pdf16Entity.setInjuredOccupation(rs.getString("occupation"));

					pdf16Entity.setInjuredIncome(rs.getString("income"));
					pdf16Entity.setInjuryNature(rs.getString("severity"));
					pdf16Entity.setInjuredMedicalTreatment(rs.getString("hospital_treatment_details"));
					pdf16Entity.setHospitalizationPeriod(rs.getString("hospital_treatment_period"));
					pdf16Entity.setPermanentDisability(rs.getString("permanent_disability"));
					pdf16Entity.setDisabilityDetails(rs.getString("permanent_disability_details"));
					return pdf16Entity;
				}
			});
			SqlParameterSource parameters12a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(pedestrianSeverity16, parameters12a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					pdf16Entity.setInjurySeverity(injurySeverity);
					return pdf16Entity;
				}
			});
		} else if (personType.equalsIgnoreCase("Driver")) {

			SqlParameterSource parameters10a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(report16dri, parameters10a, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					pdf16Entity.setAccidentId(rs.getString("accident_id"));
					pdf16Entity.setAccidentDate(rs.getString("reporting_datetime"));
					pdf16Entity.setInjuredName(rs.getString("name"));
					pdf16Entity.setInjuredAge(rs.getString("age"));
					pdf16Entity.setInjuredOccupation(rs.getString("occupation"));
					pdf16Entity.setInjuredIncome(rs.getString("driver_income"));
					pdf16Entity.setInjuryNature(rs.getString("severity"));
					pdf16Entity.setInjuredMedicalTreatment(rs.getString("treatment_details"));
					pdf16Entity.setHospitalizationPeriod(rs.getString("period_hospitlization"));
					pdf16Entity.setPermanentDisability(rs.getString("permanent_disability"));
					pdf16Entity.setDisabilityDetails(rs.getString("permanent_disability_details"));
					return pdf16Entity;
				}
			});
			SqlParameterSource parameters12a = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(driverSeverity16, parameters12a, new RowMapper<Object>() {

				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String injurySeverity = rs.getString("injury_severity");
					System.out.println(injurySeverity);
					pdf16Entity.setInjurySeverity(injurySeverity);
					return pdf16Entity;
				}
			});

		}

		if (pdf16Entity.getInjurySeverity().equals("2") || pdf16Entity.getInjurySeverity().equals("3")
				|| pdf16Entity.getInjurySeverity().equals("4")) {

			SqlParameterSource parameters10 = new MapSqlParameterSource().addValue("accidentId", accidentId)
					.addValue("vehicleId", vehicleId).addValue("personId", personId).addValue("personType", personType);
			namedParameterJdbcTemplate.query(report16, parameters10, new RowMapper<Object>() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					if (rs != null) {
						do {
							pdf16Entity.setExpenditureTreatment(rs.getString("treatment"));
							pdf16Entity.setExpenditureConveyance(rs.getString("convenance"));
							pdf16Entity.setExpenditureSpecialDiet(rs.getString("special_diet"));
							pdf16Entity.setNursingAttendantCost(rs.getString("cost_nursing_attendant"));
							pdf16Entity.setEarningCapacityLoss(rs.getString("loss_earning_cap"));
							pdf16Entity.setLossOfIncome(rs.getString("loss_income"));
							pdf16Entity.setSpecialTreatment(rs.getString("any_other_loss"));
							pdf16Entity.setMentalPhysicalShock(rs.getString("com_mental_phy_shock"));
							pdf16Entity.setPainAndSuffering(rs.getString("pain_suffering"));
							pdf16Entity.setAmenitiesLoss(rs.getString("loss_amenities"));
							pdf16Entity.setDisfiguration(rs.getString("disfiguration"));
							pdf16Entity.setMarriageProspects(rs.getString("loss_of_marriage"));
							pdf16Entity.setOverAllLosses(rs.getString("loss_ear_inc_har_dis"));
							pdf16Entity.setPercentageOfDisability(rs.getString("per_disablity"));
							pdf16Entity.setLossOfExpectation(rs.getString("loss_ami_life_span"));
							pdf16Entity.setLossOfEarningCapacity(rs.getString("per_loss_earning"));
							pdf16Entity.setLossOffutureIncome(rs.getString("loss_future_income"));
							pdf16Entity.setTotalCompansation(rs.getString("total_copensation"));
							pdf16Entity.setTotalInterestAwarded(rs.getString("interest"));
							pdf16Entity.setInterestAmount(rs.getString("interest_amount"));
							pdf16Entity.setTotalAmount(rs.getString("total_amt_with_interest"));
							pdf16Entity.setReleasedAwardAmount(rs.getString("award_amt_released"));
							pdf16Entity.setKeptAwardAmount(rs.getString("award_amt_in_fdrs"));
							pdf16Entity.setModeOfDisbursement(rs.getString("mode_disbursement"));
							pdf16Entity.setCompilanceAwardDate(rs.getString("nest_date_award"));
							pdf16Entity.setArtificialLimbCost(rs.getString("cost_artificial_limp"));
							pdf16Entity.setOverAllLosses(rs.getString("loss_ear_inc_har_dis"));
						} while (rs.next());
					}
					return pdf16Entity;
				}
			});
			return pdf16Entity;
		}
		return pdf16Entity;
	}

	@Override
	public Pdf17Entity getPdf17Report(String accidentId) {
		Pdf17Entity pdf17Entity = new Pdf17Entity();
		pdf17Entity.setStateCode(accidentId.substring(4, 6));

		SqlParameterSource parameters17a = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report17form1, parameters17a, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {
						pdf17Entity.setDate_of_filing_form1(rs.getString("submitedon"));

					} while (rs.next());
				} else {
					pdf17Entity.setDate_of_filing_form1(rs.getString(""));
				}
				return pdf17Entity;
			}
		});

		SqlParameterSource parameters17b = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report17form2, parameters17b, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {

						pdf17Entity.setDate_of_delivery_form2(rs.getString("submitedon"));

					} while (rs.next());
				} else {
					pdf17Entity.setDate_of_delivery_form2(rs.getString(""));
				}
				return pdf17Entity;
			}
		});

		SqlParameterSource parameters17c = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report17form3, parameters17c, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {

						pdf17Entity.setDate_of_receipt_form3(rs.getString("submitedon"));

					} while (rs.next());
				} else {
					pdf17Entity.setDate_of_receipt_form3(rs.getString(""));
				}
				return pdf17Entity;
			}
		});

		SqlParameterSource parameters17d = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report17form4, parameters17d, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {

						pdf17Entity.setDate_of_receipt_form4(rs.getString("submitedon"));

					} while (rs.next());
				} else {
					pdf17Entity.setDate_of_receipt_form4(rs.getString(""));
				}
				return pdf17Entity;
			}
		});

		SqlParameterSource parameters17e = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report17form5, parameters17e, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {
						pdf17Entity.setDate_of_filling_form5(rs.getString("submitedon"));

					} while (rs.next());
				} else {
					pdf17Entity.setDate_of_filling_form5(rs.getString(""));
				}
				return pdf17Entity;
			}
		});
		SqlParameterSource parameters17f = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report17form6, parameters17f, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {
						pdf17Entity.setDate_of_receipt_form6_form6a(rs.getString("submitedon"));

					} while (rs.next());
				} else {
					pdf17Entity.setDate_of_receipt_form6_form6a(rs.getString(""));
				}
				return pdf17Entity;
			}
		});

//		SqlParameterSource parameters17i = new MapSqlParameterSource().addValue("accidentId", accidentId);
//		namedParameterJdbcTemplate.query(report17, parameters17i, new RowMapper<Object>() {
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				if (rs != null) {
//					do {
//						pdf17Entity.setDate_of_receipt_form6_form6a(rs.getString("date_of_receipt_form6_form6a"));
//						
//					} while (rs.next());
//				}else {
//					pdf17Entity.setDate_of_receipt_form6_form6a(rs.getString(""));
//				}
//				return pdf17Entity;
//			}
//		});

		SqlParameterSource parameters17g = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report17form7, parameters17g, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {
						pdf17Entity.setDate_of_filling_form7(rs.getString("submitedon"));
					} while (rs.next());
				} else {
					pdf17Entity.setDate_of_filling_form7(rs.getString(""));
				}
				return pdf17Entity;
			}
		});
		
		
		SqlParameterSource parameters17l = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report17accident, parameters17l, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {
						pdf17Entity.setAccidentDateTime(rs.getString("accident_date_time"));
					} while (rs.next());
				} else {
					pdf17Entity.setAccidentDateTime(rs.getString(" "));
				}
				return pdf17Entity;
			}
		});

//		SqlParameterSource parameters17h = new MapSqlParameterSource().addValue("accidentId", accidentId);
//		namedParameterJdbcTemplate.query(report17, parameters17h, new RowMapper<Object>() {
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				if (rs != null) {
//					do {
//						pdf17Entity.setAccidentId(accidentId);
//						pdf17Entity.setDate_of_filing_form1(rs.getString("date_of_filing_form1"));
//						pdf17Entity.setDate_of_delivery_form2(rs.getString("date_of_delivery_form2"));
//						pdf17Entity.setDate_of_receipt_form3(rs.getString("date_of_receipt_form3"));
//						pdf17Entity.setDate_of_receipt_form4(rs.getString("date_of_receipt_form4"));
//						pdf17Entity.setDate_of_filling_form5(rs.getString("date_of_filling_form5"));
//						pdf17Entity.setDate_of_receipt_form6_form6a(rs.getString("date_of_receipt_form6_form6a"));
//						pdf17Entity.setDate_of_filling_form7(rs.getString("date_of_filling_form7"));
//					} while (rs.next());
//				}
//				return pdf17Entity;
//			}
//		});

		SqlParameterSource parameters10a = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report17, parameters10a, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {

						pdf17Entity.setDelay_or_deficiency_invest_officer(rs.getString("investigation_delay"));
						pdf17Entity.setDate_appointment_desig_officer("");
						// pdf17Entity.setDate_appointment_desig_officer(rs.getString("date_appointment_desig_officer"));

						// pdf17Entity.setInsurance_officer_submitted_dar(rs.getString("insurance_officer_submitted_dar"));
						pdf17Entity.setInsurance_officer_submitted_dar("");

						pdf17Entity.setDelay_or_deficiency_desig_officer(rs.getString("insurance_delay"));
						pdf17Entity.setDate_of_response(rs.getString("date_bank_acc_create"));
						pdf17Entity.setDate_of_award(rs.getString("award_date"));
						pdf17Entity.setDirected_to_open_savings(rs.getString("create_bank_acc_near"));
						pdf17Entity.setDate_on_passbook_produced(rs.getString("date_passbook"));
						pdf17Entity.setClaimants_permanent_address(rs.getString("permenent_res_addr"));
						pdf17Entity.setBank_near_to_residence(rs.getString("bank_acc_near"));
						pdf17Entity.setExamined_time_of_passing(rs.getString("examined"));
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
						LocalDateTime now = LocalDateTime.now();
						System.out.println(dtf.format(now));
						String accidentDate = dtf.format(now);
						pdf17Entity.setCurrentDate(accidentDate);
					} while (rs.next());
				}
				return pdf17Entity;
			}
		});
		return pdf17Entity;
	}

	@Override
	public Pdf18Entity getPdf18Report(String accidentId) {
		Pdf18Entity pdf18Entity = new Pdf18Entity();
		pdf18Entity.setStateCode(accidentId.substring(4, 6));
		SqlParameterSource parameters10 = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(report18, parameters10, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					do {

						pdf18Entity.setAccident_id(accidentId);
						pdf18Entity.setDate_of_award(rs.getString("award_date"));
						pdf18Entity.setCase_number(rs.getString("case_no"));
						pdf18Entity.setTitle_of_case(rs.getString("case_title"));
						pdf18Entity.setAward_amount(rs.getString("award_amount"));
						pdf18Entity.setDeposit_by_depositor(rs.getString("date_notice_depositer"));
						pdf18Entity.setDeposit_by_tribunal(rs.getString("date_notice_tribunal"));
						pdf18Entity.setAmount_of_interest(rs.getString("amount_interest"));
						pdf18Entity.setAmount_deposited(rs.getString("amount_deposit_date"));

						pdf18Entity.setAward_amount_interest_deposited(rs.getString("amount_status"));
						pdf18Entity.setAction_recover_award_interest(rs.getString("action_taken"));
						pdf18Entity.setRelease_award_amount_claimnant(rs.getString("release_date"));

						pdf18Entity.setMode_of_release_award_amount(rs.getString("mode_release"));
						pdf18Entity.setRemarks(rs.getString("remarks"));
					} while (rs.next());
				}
				return pdf18Entity;
			}
		});
		return pdf18Entity;
	}

	@Override
	public Pdf20Entity getPdf20Report(String accidentId) {
		Pdf20Entity pdf20Entity = new Pdf20Entity();
		pdf20Entity.setStateCode(accidentId.substring(4, 6));
		SqlParameterSource parameters = new MapSqlParameterSource().addValue("accidentId", accidentId);
		namedParameterJdbcTemplate.query(GET_ACCIDENT_DETAILS, parameters, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

				String date = rs.getString("datetime");

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				String accidentDate = dtf.format(now);

				pdf20Entity.setCurrentDate(accidentDate);
				String firtime = rs.getString("firdatetime");
				pdf20Entity.setAccident_id(accidentId);
				pdf20Entity.setFirNumber(rs.getString("fir_number"));
				pdf20Entity.setDateOfAccident(date.substring(0, date.indexOf(':')));
				pdf20Entity.setPlaceOfAccident(rs.getString("landmarks"));
				pdf20Entity.setPsName(rs.getString("psname"));
				pdf20Entity.setDistrict(rs.getString("districtname"));
				pdf20Entity.setState(rs.getString("statename"));
				// pdf20Entity.setPincode(accidentId);
				pdf20Entity.setCurrentDate(dtf.format(now));
				pdf20Entity.setDateOfAccident(rs.getString("acctime"));
				pdf20Entity.setLandMark(rs.getString("landmarks"));
				pdf20Entity.setPlaceOfAccident(rs.getString("road_details"));
				return pdf20Entity;
			}
		});
		return pdf20Entity;
	}

}
