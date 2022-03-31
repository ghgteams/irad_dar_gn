package com.irad.dar.jwt;

public class AuthModel {

	private String userid;
	private String password;
	private String dept_code;
	private String captcha;
	private String randval;
	private String deviceInfo;
	private String loc;
	private String uuid;
	private String uuid1;
	private Boolean returnSecureToken;
	
	
	public AuthModel() {
		super();
		// TODO Auto-generated constructor stub
	}







	public AuthModel(String userid, String password, String dept_code, String captcha, String randval,
			String deviceInfo, String loc, String uuid, String uuid1, Boolean returnSecureToken) {
		super();
		this.userid = userid;
		this.password = password;
		this.dept_code = dept_code;
		this.captcha = captcha;
		this.randval = randval;
		this.deviceInfo = deviceInfo;
		this.loc = loc;
		this.uuid = uuid;
		this.uuid1 = uuid1;
		this.returnSecureToken = returnSecureToken;
	}







	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getRandval() {
		return randval;
	}

	public void setRandval(String randval) {
		this.randval = randval;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUuid1() {
		return uuid1;
	}

	public void setUuid1(String uuid1) {
		this.uuid1 = uuid1;
	}

	public Boolean getReturnSecureToken() {
		return returnSecureToken;
	}

	public void setReturnSecureToken(Boolean returnSecureToken) {
		this.returnSecureToken = returnSecureToken;
	}

	@Override
	public String toString() {
		return "AuthModel [userid=" + userid + ", password=" + password + ", dept_code=" + dept_code + ", captcha="
				+ captcha + ", randval=" + randval + ", deviceInfo=" + deviceInfo + ", loc=" + loc + ", uuid=" + uuid
				+ ", uuid1=" + uuid1 + ", returnSecureToken=" + returnSecureToken + "]";
	}



}
