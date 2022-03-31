package com.irad.dar.utils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dar_family_losses", schema = "public")
public class LossesEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;	
	
	@Column(name="acc_id")
	private String accId;    
	
	@Column(name="ref_id")
	private String refId;
	
	@Column(name="loss_title")
	private String lossTitle; 
	
	@Column(name="loss_description")
	private String lossDescription;
	
	@Column(name="whose_loss")
	private String whoseLoss;

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getLossTitle() {
		return lossTitle;
	}

	public void setLossTitle(String lossTitle) {
		this.lossTitle = lossTitle;
	}

	public String getLossDescription() {
		return lossDescription;
	}

	public void setLossDescription(String lossDescription) {
		this.lossDescription = lossDescription;
	}

	public String getWhoseLoss() {
		return whoseLoss;
	}

	public void setWhoseLoss(String whoseLoss) {
		this.whoseLoss = whoseLoss;
	}

	public LossesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LossesEntity(long id, String accId, String refId, String lossTitle, String lossDescription,
			String whoseLoss) {
		super();
		this.id = id;
		this.accId = accId;
		this.refId = refId;
		this.lossTitle = lossTitle;
		this.lossDescription = lossDescription;
		this.whoseLoss = whoseLoss;
	}

	@Override
	public String toString() {
		return "LossesEntity [id=" + id + ", accId=" + accId + ", refId=" + refId + ", lossTitle=" + lossTitle
				+ ", lossDescription=" + lossDescription + ", whoseLoss=" + whoseLoss + "]";
	}
	
	
	
	
	
}
