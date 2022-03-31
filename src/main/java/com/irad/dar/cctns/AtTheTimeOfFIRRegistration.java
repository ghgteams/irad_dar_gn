package com.irad.dar.cctns;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtTheTimeOfFIRRegistration {

	public String psCode;
    public String districtCode;
    public List<AccusedList> accused_list;
    public String iradAccidentID;
    public List<Act> acts;
    public String firRegDate;
    public ComplainantDetails complainant_details;
    public CourtDetails court_details;
    public InvestigatingOfficer investigating_officer;
    public String modeofinfo;
    public String firNo;
    public String receive_ps_tm;
    @JsonProperty("Victim") 
    public List<Victim> victim;
    public List<VehicleDetail> vehicle_details;
	public String getPsCode() {
		return psCode;
	}
	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public List<AccusedList> getAccused_list() {
		return accused_list;
	}
	public void setAccused_list(List<AccusedList> accused_list) {
		this.accused_list = accused_list;
	}
	public String getIradAccidentID() {
		return iradAccidentID;
	}
	public void setIradAccidentID(String iradAccidentID) {
		this.iradAccidentID = iradAccidentID;
	}
	public List<Act> getActs() {
		return acts;
	}
	public void setActs(List<Act> acts) {
		this.acts = acts;
	}
	public String getFirRegDate() {
		return firRegDate;
	}
	public void setFirRegDate(String firRegDate) {
		this.firRegDate = firRegDate;
	}
	public ComplainantDetails getComplainant_details() {
		return complainant_details;
	}
	public void setComplainant_details(ComplainantDetails complainant_details) {
		this.complainant_details = complainant_details;
	}
	public CourtDetails getCourt_details() {
		return court_details;
	}
	public void setCourt_details(CourtDetails court_details) {
		this.court_details = court_details;
	}
	public InvestigatingOfficer getInvestigating_officer() {
		return investigating_officer;
	}
	public void setInvestigating_officer(InvestigatingOfficer investigating_officer) {
		this.investigating_officer = investigating_officer;
	}
	public String getModeofinfo() {
		return modeofinfo;
	}
	public void setModeofinfo(String modeofinfo) {
		this.modeofinfo = modeofinfo;
	}
	public String getFirNo() {
		return firNo;
	}
	public void setFirNo(String firNo) {
		this.firNo = firNo;
	}
	public String getReceive_ps_tm() {
		return receive_ps_tm;
	}
	public void setReceive_ps_tm(String receive_ps_tm) {
		this.receive_ps_tm = receive_ps_tm;
	}
	public List<Victim> getVictim() {
		return victim;
	}
	public void setVictim(List<Victim> victim) {
		this.victim = victim;
	}
	public List<VehicleDetail> getVehicle_details() {
		return vehicle_details;
	}
	public void setVehicle_details(List<VehicleDetail> vehicle_details) {
		this.vehicle_details = vehicle_details;
	}
    
    
    
    
}
