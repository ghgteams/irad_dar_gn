package com.irad.dar.pedestrian;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PedestrianNewEntityId implements Serializable {
	
	@Column(name="acc_id")
	private String acc_id; 
	
	@Column(name="pedestrian_ref_id")
	private String pedestrian_ref_id;

	public String getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}

	public String getPedestrian_ref_id() {
		return pedestrian_ref_id;
	}

	public void setPedestrian_ref_id(String pedestrian_ref_id) {
		this.pedestrian_ref_id = pedestrian_ref_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acc_id == null) ? 0 : acc_id.hashCode());
		result = prime * result + ((pedestrian_ref_id == null) ? 0 : pedestrian_ref_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedestrianNewEntityId other = (PedestrianNewEntityId) obj;
		if (acc_id == null) {
			if (other.acc_id != null)
				return false;
		} else if (!acc_id.equals(other.acc_id))
			return false;
		if (pedestrian_ref_id == null) {
			if (other.pedestrian_ref_id != null)
				return false;
		} else if (!pedestrian_ref_id.equals(other.pedestrian_ref_id))
			return false;
		return true;
	}

	public PedestrianNewEntityId() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PedestrianNewEntityId [acc_id=" + acc_id + ", pedestrian_ref_id=" + pedestrian_ref_id + "]";
	}

	public PedestrianNewEntityId(String acc_id, String pedestrian_ref_id) {
		super();
		this.acc_id = acc_id;
		this.pedestrian_ref_id = pedestrian_ref_id;
	}

	
	
}
