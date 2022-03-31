package com.irad.dar.jwt;

public class DistrictModel {
	
		private String districtcourt;
		private String id;
		private String mode;
		private String talukcourt;
		public DistrictModel() {
			super();
			// TODO Auto-generated constructor stub
		}
		public DistrictModel(String districtcourt, String id, String mode, String talukcourt) {
			super();
			this.districtcourt = districtcourt;
			this.id = id;
			this.mode = mode;
			this.talukcourt = talukcourt;
		}
		public String getDistrictcourt() {
			return districtcourt;
		}
		public void setDistrictcourt(String districtcourt) {
			this.districtcourt = districtcourt;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getMode() {
			return mode;
		}
		public void setMode(String mode) {
			this.mode = mode;
		}
		public String getTalukcourt() {
			return talukcourt;
		}
		public void setTalukcourt(String talukcourt) {
			this.talukcourt = talukcourt;
		}
	
}
