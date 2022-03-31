package com.irad.dar.master;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "irad_users", schema = "master")
public class UserDao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "username", nullable = false)
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "role_code")
	private String role_code;
	@Column(name = "dept_code")
	private String dept;
	@Column(name = "password_enc")
	private String password_enc;
	@Column
	private String mobile;
	@Column
	private String state_code;
	@Column
	private String district_code;
	@Column(name = "ps_code")
	private String station_code;
	@Column
	private String email;
	@Column
	private Date created_date;
	@Column
	private boolean active;

	public UserDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDao(Long id, String name, String username, String password, String role_code, String dept,
			String password_enc, String mobile, String state_code, String district_code, String station_code,
			String email, Date created_date, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.role_code = role_code;
		this.dept = dept;
		this.password_enc = password_enc;
		this.mobile = mobile;
		this.state_code = state_code;
		this.district_code = district_code;
		this.station_code = station_code;
		this.email = email;
		this.created_date = created_date;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPassword_enc() {
		return password_enc;
	}

	public void setPassword_enc(String password_enc) {
		this.password_enc = password_enc;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getState_code() {
		return state_code;
	}

	public void setState_code(String state_code) {
		this.state_code = state_code;
	}

	public String getDistrict_code() {
		return district_code;
	}

	public void setDistrict_code(String district_code) {
		this.district_code = district_code;
	}

	public String getStation_code() {
		return station_code;
	}

	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "UserDao [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", role_code=" + role_code + ", dept=" + dept + ", password_enc=" + password_enc + ", mobile="
				+ mobile + ", state_code=" + state_code + ", district_code=" + district_code + ", station_code="
				+ station_code + ", email=" + email + ", created_date=" + created_date + ", active=" + active + "]";
	}

}
