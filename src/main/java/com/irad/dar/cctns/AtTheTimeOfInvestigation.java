package com.irad.dar.cctns;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtTheTimeOfInvestigation {
	public List<UpdatedAccdetail> updated_accdetails;
    public String psCode;
    public String districtCode;
    public List<UpdatedActsandsection> updated_actsandsections;
    public List<UpdatedVehicledetail> updated_vehicledetails;
    @JsonProperty("Updates_on_caseStatus") 
    public UpdatesOnCaseStatus updates_on_caseStatus;
    public String iradAccidentID;
    public String modeofinfo;
    public String firRegDate;
    public String firNo;
    public String receive_ps_tm;
	public List<UpdatedAccdetail> getUpdated_accdetails() {
		return updated_accdetails;
	}
	public void setUpdated_accdetails(List<UpdatedAccdetail> updated_accdetails) {
		this.updated_accdetails = updated_accdetails;
	}
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
	public List<UpdatedActsandsection> getUpdated_actsandsections() {
		return updated_actsandsections;
	}
	public void setUpdated_actsandsections(List<UpdatedActsandsection> updated_actsandsections) {
		this.updated_actsandsections = updated_actsandsections;
	}
	public List<UpdatedVehicledetail> getUpdated_vehicledetails() {
		return updated_vehicledetails;
	}
	public void setUpdated_vehicledetails(List<UpdatedVehicledetail> updated_vehicledetails) {
		this.updated_vehicledetails = updated_vehicledetails;
	}
	public UpdatesOnCaseStatus getUpdates_on_caseStatus() {
		return updates_on_caseStatus;
	}
	public void setUpdates_on_caseStatus(UpdatesOnCaseStatus updates_on_caseStatus) {
		this.updates_on_caseStatus = updates_on_caseStatus;
	}
	public String getIradAccidentID() {
		return iradAccidentID;
	}
	public void setIradAccidentID(String iradAccidentID) {
		this.iradAccidentID = iradAccidentID;
	}
	public String getModeofinfo() {
		return modeofinfo;
	}
	public void setModeofinfo(String modeofinfo) {
		this.modeofinfo = modeofinfo;
	}
	public String getFirRegDate() {
		return firRegDate;
	}
	public void setFirRegDate(String firRegDate) {
		this.firRegDate = firRegDate;
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
    
    
}
