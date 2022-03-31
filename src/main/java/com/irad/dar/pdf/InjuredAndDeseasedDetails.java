package com.irad.dar.pdf;

public class InjuredAndDeseasedDetails {
	 private String name;
	 private String injuredOrDeseased;
	 private String address;
	 private String hospitalId;
	 private String hospitalizationRequired;
	 private String hpname;
	 private String hpAddress;
	 private String injury_severity;
	 private String mobileNo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInjuredOrDeseased() {
		return injuredOrDeseased;
	}
	public void setInjuredOrDeseased(String injuredOrDeseased) {
		this.injuredOrDeseased = injuredOrDeseased;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalizationRequired() {
		return hospitalizationRequired;
	}
	public void setHospitalizationRequired(String hospitalizationRequired) {
		this.hospitalizationRequired = hospitalizationRequired;
	}
	public String getHpname() {
		return hpname;
	}
	public void setHpname(String hpname) {
		this.hpname = hpname;
	}
	public String getHpAddress() {
		return hpAddress;
	}
	public void setHpAddress(String hpAddress) {
		this.hpAddress = hpAddress;
	}
	public String getInjury_severity() {
		return injury_severity;
	}
	public void setInjury_severity(String injury_severity) {
		this.injury_severity = injury_severity;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "InjuredAndDeseasedDetails [name=" + name + ", injuredOrDeseased=" + injuredOrDeseased + ", address="
				+ address + ", hospitalId=" + hospitalId + ", hospitalizationRequired=" + hospitalizationRequired
				+ ", hpname=" + hpname + ", hpAddress=" + hpAddress + ", injury_severity=" + injury_severity
				+ ", mobileNo=" + mobileNo + "]";
	}
	public InjuredAndDeseasedDetails(String name, String injuredOrDeseased, String address, String hospitalId,
			String hospitalizationRequired, String hpname, String hpAddress, String injury_severity, String mobileNo) {
		super();
		this.name = name;
		this.injuredOrDeseased = injuredOrDeseased;
		this.address = address;
		this.hospitalId = hospitalId;
		this.hospitalizationRequired = hospitalizationRequired;
		this.hpname = hpname;
		this.hpAddress = hpAddress;
		this.injury_severity = injury_severity;
		this.mobileNo = mobileNo;
	}
	public InjuredAndDeseasedDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	
}
