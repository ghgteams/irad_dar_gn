package com.irad.dar.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dar_driver_family", schema = "public")
public class DriverFamilyEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;	
	@Column(name = "acc_id")
	private String accId;
	@Column(name = "driver_id")
	private String driverId;
	@Column(name = "name")
	private String name;
	@Column(name = "relationship")
	private String relationship;
	@Column(name = "address")
	private String address;
	
	public String getAccId() {
		return accId;
	}
	public void setAccId(String accId) {
		this.accId = accId;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public DriverFamilyEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DriverFamilyEntity(long id, String accId, String driverId, String name, String relationship,
			String address) {
		super();
		this.id = id;
		this.accId = accId;
		this.driverId = driverId;
		this.name = name;
		this.relationship = relationship;
		this.address = address;
	}
	@Override
	public String toString() {
		return "DriverFamilyEntity [id=" + id + ", accId=" + accId + ", driverId=" + driverId + ", name=" + name
				+ ", relationship=" + relationship + ", address=" + address + "]";
	}
	
	
	
	
}
