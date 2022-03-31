package com.irad.dar.court;

import com.vividsolutions.jts.geom.Geometry;

public class CourtListPojo {

	private int id;
	
	private String rev_district;  
	
	private String courtname;
	
	private String rev_state;
	
	private String rev_taluk;
	
	private String ps_state;
	
	private String ps_district;

	private String ps_station;
	
	private String court_type;	
	
	private String address;	
	
	private String pincode;	
	
	private String landline;	
	
	private String emailid;	
	
	private String lat;	
	
	private String lng;     
	
	private String profile_update_flag;	
	
	private String profile_update_by;	
	
	private String profile_update_date;	
	
	private Geometry the_geom;
	
	private String dtname;	
	
	private String stname;	
	
	private String get_courttype;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRev_district() {
		return rev_district;
	}

	public void setRev_district(String rev_district) {
		this.rev_district = rev_district;
	}

	public String getCourtname() {
		return courtname;
	}

	public void setCourtname(String courtname) {
		this.courtname = courtname;
	}

	public String getRev_state() {
		return rev_state;
	}

	public void setRev_state(String rev_state) {
		this.rev_state = rev_state;
	}

	public String getRev_taluk() {
		return rev_taluk;
	}

	public void setRev_taluk(String rev_taluk) {
		this.rev_taluk = rev_taluk;
	}

	public String getPs_state() {
		return ps_state;
	}

	public void setPs_state(String ps_state) {
		this.ps_state = ps_state;
	}

	public String getPs_district() {
		return ps_district;
	}

	public void setPs_district(String ps_district) {
		this.ps_district = ps_district;
	}

	public String getPs_station() {
		return ps_station;
	}

	public void setPs_station(String ps_station) {
		this.ps_station = ps_station;
	}

	public String getCourt_type() {
		return court_type;
	}

	public void setCourt_type(String court_type) {
		this.court_type = court_type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getProfile_update_flag() {
		return profile_update_flag;
	}

	public void setProfile_update_flag(String profile_update_flag) {
		this.profile_update_flag = profile_update_flag;
	}

	public String getProfile_update_by() {
		return profile_update_by;
	}

	public void setProfile_update_by(String profile_update_by) {
		this.profile_update_by = profile_update_by;
	}

	public String getProfile_update_date() {
		return profile_update_date;
	}

	public void setProfile_update_date(String profile_update_date) {
		this.profile_update_date = profile_update_date;
	}

	public Geometry getThe_geom() {
		return the_geom;
	}

	public void setThe_geom(Geometry the_geom) {
		this.the_geom = the_geom;
	}

	public String getDtname() {
		return dtname;
	}

	public CourtListPojo(int id, String rev_district, String courtname, String rev_state, String rev_taluk,
			String ps_state, String ps_district, String ps_station, String court_type, String address, String pincode,
			String landline, String emailid, String lat, String lng, String profile_update_flag,
			String profile_update_by, String profile_update_date, Geometry the_geom, String dtname, String stname,
			String get_courttype) {
		super();
		this.id = id;
		this.rev_district = rev_district;
		this.courtname = courtname;
		this.rev_state = rev_state;
		this.rev_taluk = rev_taluk;
		this.ps_state = ps_state;
		this.ps_district = ps_district;
		this.ps_station = ps_station;
		this.court_type = court_type;
		this.address = address;
		this.pincode = pincode;
		this.landline = landline;
		this.emailid = emailid;
		this.lat = lat;
		this.lng = lng;
		this.profile_update_flag = profile_update_flag;
		this.profile_update_by = profile_update_by;
		this.profile_update_date = profile_update_date;
		this.the_geom = the_geom;
		this.dtname = dtname;
		this.stname = stname;
		this.get_courttype = get_courttype;
	}

	public void setDtname(String dtname) {
		this.dtname = dtname;
	}

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public String getGet_courttype() {
		return get_courttype;
	}

	public void setGet_courttype(String get_courttype) {
		this.get_courttype = get_courttype;
	}

	@Override
	public String toString() {
		return "CourtListPojo [id=" + id + ", rev_district=" + rev_district + ", courtname=" + courtname
				+ ", rev_state=" + rev_state + ", rev_taluk=" + rev_taluk + ", ps_state=" + ps_state + ", ps_district="
				+ ps_district + ", ps_station=" + ps_station + ", court_type=" + court_type + ", address=" + address
				+ ", pincode=" + pincode + ", landline=" + landline + ", emailid=" + emailid + ", lat=" + lat + ", lng="
				+ lng + ", profile_update_flag=" + profile_update_flag + ", profile_update_by=" + profile_update_by
				+ ", profile_update_date=" + profile_update_date + ", the_geom=" + the_geom + ", dtname=" + dtname
				+ ", stname=" + stname + ", get_courttype=" + get_courttype + "]";
	}

	public CourtListPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
