package com.irad.dar.listdata;

import java.util.List;
import java.util.Map;

public class VehicleRespModel {

	private Map<String, Object> mop;

	private List<Map<String, Object>> listMop;

	public VehicleRespModel() {
		super();
	}

	public VehicleRespModel(Map<String, Object> mop, List<Map<String, Object>> listMop) {
		super();
		this.mop = mop;
		this.listMop = listMop;
	}

	public Map<String, Object> getMop() {
		return mop;
	}

	public void setMop(Map<String, Object> mop) {
		this.mop = mop;
	}

	public List<Map<String, Object>> getListMop() {
		return listMop;
	}

	public void setListMop(List<Map<String, Object>> listMop) {
		this.listMop = listMop;
	}

	@Override
	public String toString() {
		return "VehicleRespModel [mop=" + mop + ", listMop=" + listMop + "]";
	}

}
