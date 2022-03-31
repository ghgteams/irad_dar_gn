package com.irad.dar.pdf;

public class VehicleAndDriverDetails {
	private String vehicleRegNo;
	private String vehicleModel;
	private String vehicleMake;
	private String nameOfTheOwner;
	private String addressOfOwner;
	private String age;
	private String driverDOB;
    private String driverOccupation;
    private String serRegAuthority;
	private String contactNumberOfOwner;
	private String nameOfTheDriver;
	
	private String addressOfDriver1;
	private String addressOfDriver2;
	private String addressOfDriver3;
	
    private String driverContactNumber;
    private String insurancePolicyNumber;
	private String periodOfInsurancePolicy;
	private String nameOfInsuranceCompany;
	private String addressOfInsuranceCompany;
	private String gender;
	private String accusedVictim;
	public String getVehicleRegNo() {
		return vehicleRegNo;
	}
	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getVehicleMake() {
		return vehicleMake;
	}
	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}
	public String getNameOfTheOwner() {
		return nameOfTheOwner;
	}
	public void setNameOfTheOwner(String nameOfTheOwner) {
		this.nameOfTheOwner = nameOfTheOwner;
	}
	public String getAddressOfOwner() {
		return addressOfOwner;
	}
	public void setAddressOfOwner(String addressOfOwner) {
		this.addressOfOwner = addressOfOwner;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDriverDOB() {
		return driverDOB;
	}
	public void setDriverDOB(String driverDOB) {
		this.driverDOB = driverDOB;
	}
	public String getDriverOccupation() {
		return driverOccupation;
	}
	public void setDriverOccupation(String driverOccupation) {
		this.driverOccupation = driverOccupation;
	}
	public String getSerRegAuthority() {
		return serRegAuthority;
	}
	public void setSerRegAuthority(String serRegAuthority) {
		this.serRegAuthority = serRegAuthority;
	}
	public String getContactNumberOfOwner() {
		return contactNumberOfOwner;
	}
	public void setContactNumberOfOwner(String contactNumberOfOwner) {
		this.contactNumberOfOwner = contactNumberOfOwner;
	}
	public String getNameOfTheDriver() {
		return nameOfTheDriver;
	}
	public void setNameOfTheDriver(String nameOfTheDriver) {
		this.nameOfTheDriver = nameOfTheDriver;
	}
	public String getAddressOfDriver1() {
		return addressOfDriver1;
	}
	public void setAddressOfDriver1(String addressOfDriver1) {
		this.addressOfDriver1 = addressOfDriver1;
	}
	public String getAddressOfDriver2() {
		return addressOfDriver2;
	}
	public void setAddressOfDriver2(String addressOfDriver2) {
		this.addressOfDriver2 = addressOfDriver2;
	}
	public String getAddressOfDriver3() {
		return addressOfDriver3;
	}
	public void setAddressOfDriver3(String addressOfDriver3) {
		this.addressOfDriver3 = addressOfDriver3;
	}
	public String getDriverContactNumber() {
		return driverContactNumber;
	}
	public void setDriverContactNumber(String driverContactNumber) {
		this.driverContactNumber = driverContactNumber;
	}
	public String getInsurancePolicyNumber() {
		return insurancePolicyNumber;
	}
	public void setInsurancePolicyNumber(String insurancePolicyNumber) {
		this.insurancePolicyNumber = insurancePolicyNumber;
	}
	public String getPeriodOfInsurancePolicy() {
		return periodOfInsurancePolicy;
	}
	public void setPeriodOfInsurancePolicy(String periodOfInsurancePolicy) {
		this.periodOfInsurancePolicy = periodOfInsurancePolicy;
	}
	public String getNameOfInsuranceCompany() {
		return nameOfInsuranceCompany;
	}
	public void setNameOfInsuranceCompany(String nameOfInsuranceCompany) {
		this.nameOfInsuranceCompany = nameOfInsuranceCompany;
	}
	public String getAddressOfInsuranceCompany() {
		return addressOfInsuranceCompany;
	}
	public void setAddressOfInsuranceCompany(String addressOfInsuranceCompany) {
		this.addressOfInsuranceCompany = addressOfInsuranceCompany;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAccusedVictim() {
		return accusedVictim;
	}
	public void setAccusedVictim(String accusedVictim) {
		this.accusedVictim = accusedVictim;
	}
	@Override
	public String toString() {
		return "VehicleAndDriverDetails [vehicleRegNo=" + vehicleRegNo + ", vehicleModel=" + vehicleModel
				+ ", vehicleMake=" + vehicleMake + ", nameOfTheOwner=" + nameOfTheOwner + ", addressOfOwner="
				+ addressOfOwner + ", age=" + age + ", driverDOB=" + driverDOB + ", driverOccupation="
				+ driverOccupation + ", serRegAuthority=" + serRegAuthority + ", contactNumberOfOwner="
				+ contactNumberOfOwner + ", nameOfTheDriver=" + nameOfTheDriver + ", addressOfDriver1="
				+ addressOfDriver1 + ", addressOfDriver2=" + addressOfDriver2 + ", addressOfDriver3=" + addressOfDriver3
				+ ", driverContactNumber=" + driverContactNumber + ", insurancePolicyNumber=" + insurancePolicyNumber
				+ ", periodOfInsurancePolicy=" + periodOfInsurancePolicy + ", nameOfInsuranceCompany="
				+ nameOfInsuranceCompany + ", addressOfInsuranceCompany=" + addressOfInsuranceCompany + ", gender="
				+ gender + ", accusedVictim=" + accusedVictim + "]";
	}
	public VehicleAndDriverDetails(String vehicleRegNo, String vehicleModel, String vehicleMake, String nameOfTheOwner,
			String addressOfOwner, String age, String driverDOB, String driverOccupation, String serRegAuthority,
			String contactNumberOfOwner, String nameOfTheDriver, String addressOfDriver1, String addressOfDriver2,
			String addressOfDriver3, String driverContactNumber, String insurancePolicyNumber,
			String periodOfInsurancePolicy, String nameOfInsuranceCompany, String addressOfInsuranceCompany,
			String gender, String accusedVictim) {
		super();
		this.vehicleRegNo = vehicleRegNo;
		this.vehicleModel = vehicleModel;
		this.vehicleMake = vehicleMake;
		this.nameOfTheOwner = nameOfTheOwner;
		this.addressOfOwner = addressOfOwner;
		this.age = age;
		this.driverDOB = driverDOB;
		this.driverOccupation = driverOccupation;
		this.serRegAuthority = serRegAuthority;
		this.contactNumberOfOwner = contactNumberOfOwner;
		this.nameOfTheDriver = nameOfTheDriver;
		this.addressOfDriver1 = addressOfDriver1;
		this.addressOfDriver2 = addressOfDriver2;
		this.addressOfDriver3 = addressOfDriver3;
		this.driverContactNumber = driverContactNumber;
		this.insurancePolicyNumber = insurancePolicyNumber;
		this.periodOfInsurancePolicy = periodOfInsurancePolicy;
		this.nameOfInsuranceCompany = nameOfInsuranceCompany;
		this.addressOfInsuranceCompany = addressOfInsuranceCompany;
		this.gender = gender;
		this.accusedVictim = accusedVictim;
	}
	public VehicleAndDriverDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
