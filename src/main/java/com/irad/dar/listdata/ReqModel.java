package com.irad.dar.listdata;

public class ReqModel {

	private String accidentId;
	private String state;
	private int status;
	private int offset;
	private int limit;
	private String court_id;
	private String role_code;
	private String dept_code;
	private String orderBy;

	public ReqModel() {
		super();
	}

	public ReqModel(String accidentId, String state, int status, int offset, int limit, String court_id,
			String role_code, String dept_code, String orderBy) {
		super();
		this.accidentId = accidentId;
		this.state = state;
		this.status = status;
		this.offset = offset;
		this.limit = limit;
		this.court_id = court_id;
		this.role_code = role_code;
		this.dept_code = dept_code;
		this.orderBy = orderBy;
	}

	public String getAccidentId() {
		return accidentId;
	}

	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getCourt_id() {
		return court_id;
	}

	public void setCourt_id(String court_id) {
		this.court_id = court_id;
	}

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	@Override
	public String toString() {
		return "ReqModel [accidentId=" + accidentId + ", state=" + state + ", status=" + status + ", offset=" + offset
				+ ", limit=" + limit + ", court_id=" + court_id + ", role_code=" + role_code + ", dept_code="
				+ dept_code + ", orderBy=" + orderBy + "]";
	}

}
