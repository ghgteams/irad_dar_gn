package com.irad.dar.punjab.cctns;

import java.util.Objects;

public class DecryptDTO {
	
	private String data;

	public DecryptDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DecryptDTO other = (DecryptDTO) obj;
		return Objects.equals(data, other.data);
	}

	@Override
	public String toString() {
		return "DecryptDTO [data=" + data + "]";
	}

	

	
}
