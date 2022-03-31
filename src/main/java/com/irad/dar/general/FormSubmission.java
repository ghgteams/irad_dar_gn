package com.irad.dar.general;

public class FormSubmission {
	private String count;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public FormSubmission(String count) {
		super();
		this.count = count;
	}

	@Override
	public String toString() {
		return "formSubmission [count=" + count + "]";
	}

	public FormSubmission() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
