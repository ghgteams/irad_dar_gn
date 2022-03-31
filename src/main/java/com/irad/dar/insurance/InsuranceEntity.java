package com.irad.dar.insurance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.locationtech.jts.geom.Geometry;

@Entity
@Table(name = "insuranceregister", schema = "court")
public class InsuranceEntity {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="rev_state")
	private String rev_state;

	@Column(name="rev_district")
	private String rev_district;

	@Column(name="rev_taluk")
	private String rev_taluk;

	@Column(name="nameofinsurance")
	private String nameofinsurance;

	@Column(name="address")
	private String address;

	@Column(name="pincode")
	private String pincode;

	@Column(name="landline")
	private String landline;

	@Column(name="emailid")
	private String emailid;

	@Column(name="the_geom")
	private Geometry the_geom;

	@Column(name="lat")
	private String lat;

	@Column(name="lng")
	private String lng;

	@Column(name="profile_update_flag")
	private String profile_update_flag;
	
	@Column(name="profile_update_by")
	private String profile_update_by;
	
	@Column(name="profile_update_date")
	private String profile_update_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRev_state() {
		return rev_state;
	}

	public void setRev_state(String rev_state) {
		this.rev_state = rev_state;
	}

	public String getRev_district() {
		return rev_district;
	}

	public void setRev_district(String rev_district) {
		this.rev_district = rev_district;
	}

	public String getRev_taluk() {
		return rev_taluk;
	}

	public void setRev_taluk(String rev_taluk) {
		this.rev_taluk = rev_taluk;
	}

	public String getNameofinsurance() {
		return nameofinsurance;
	}

	public void setNameofinsurance(String nameofinsurance) {
		this.nameofinsurance = nameofinsurance;
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

	public Geometry getThe_geom() {
		return the_geom;
	}

	public void setThe_geom(Geometry the_geom) {
		this.the_geom = the_geom;
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

	public InsuranceEntity(int id, String rev_state, String rev_district, String rev_taluk, String nameofinsurance,
			String address, String pincode, String landline, String emailid, Geometry the_geom, String lat, String lng,
			String profile_update_flag, String profile_update_by, String profile_update_date) {
		super();
		this.id = id;
		this.rev_state = rev_state;
		this.rev_district = rev_district;
		this.rev_taluk = rev_taluk;
		this.nameofinsurance = nameofinsurance;
		this.address = address;
		this.pincode = pincode;
		this.landline = landline;
		this.emailid = emailid;
		this.the_geom = the_geom;
		this.lat = lat;
		this.lng = lng;
		this.profile_update_flag = profile_update_flag;
		this.profile_update_by = profile_update_by;
		this.profile_update_date = profile_update_date;
	}

	@Override
	public String toString() {
		return "InsuranceEntity [id=" + id + ", rev_state=" + rev_state + ", rev_district=" + rev_district
				+ ", rev_taluk=" + rev_taluk + ", nameofinsurance=" + nameofinsurance + ", address=" + address
				+ ", pincode=" + pincode + ", landline=" + landline + ", emailid=" + emailid + ", the_geom=" + the_geom
				+ ", lat=" + lat + ", lng=" + lng + ", profile_update_flag=" + profile_update_flag
				+ ", profile_update_by=" + profile_update_by + ", profile_update_date=" + profile_update_date + "]";
	}

	public InsuranceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
