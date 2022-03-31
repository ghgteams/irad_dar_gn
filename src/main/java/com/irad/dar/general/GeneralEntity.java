package com.irad.dar.general;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dar_general", schema = "public")
public class GeneralEntity {

		@Id
		@Column(name="acc_id")
		private String accId;    
		@Column(name="officer_name")
		private String officerName;  
		@Column(name="officer_address")
		private String officerAddress;  
		@Column(name="officer_number")
		private String officerNumber;
		@Column(name="who_report_acc")
		private String whoreportAcc;  
		@Column(name="cctv_availability")
		private boolean cctvAvailability;   
		@Column(name="acc_description")
		private String accDescription;  
		@Column(name="dt_siteplan")
		private String dtSiteplan;   
		@Column(name="description_siteplan")
		private String descriptionSiteplan;  
		
		@Column(name="fir_doc")
		private boolean firDoc;    
		@Column(name="siteplan_doc")
		private boolean siteplanDoc;  
		@Column(name="photos_scene_allangles_doc")
		private boolean photossceneallanglesDoc;   
		@Column(name="photos_vehicles_allangles_doc")
		private boolean photosvehiclesallanglesDoc;
		@Column(name="cctv_footage_doc")
		private boolean cctvfootageDoc;    
		@Column(name="report_173crpc_doc")
		private boolean report173crpcDoc;  
		@Column(name="driver_doc")
		private boolean driverDoc;    
		@Column(name="owner_doc")
		private boolean ownerDoc;  
		@Column(name="ins_comp_doc")
		private boolean ins_compDoc;    
		@Column(name="claimant_doc")
		private boolean claimantDoc;  
		@Column(name="reg_authority_doc")
		private boolean reg_authorityDoc;  
		@Column(name="hospital_doc")
		private boolean hospitalDoc;
		@Column(name="witness_check")
		private boolean witnessCheck;
		@Column(name="submit_check")
		private boolean submitCheck;
		@Column(name="under_section")
		private String underSection;
		@Column(name="loss_of_property")
		private String lossOfproperty;
		@Column(name="other_loss")
		private String otherLoss;
		
		@Column(name="nature_acc")
		private String natureAcc;
		@Column(name="reporting_person_name")
		private String reportingPersonname;
		@Column(name="reporting_person_address")
		private String reportingPersonaddress;
		@Column(name="reporting_person_mobile")
		private String reportingPersonmobile;
		
		@Column(name="hospital_remainder_date")
		private String hospitalRemainderdate;
		@Column(name="reg_authority_remainder_date")
		private String regAuthorityremainderdate;
		
		@Column(name="brief_description_accident")
		private String briefDescriptionaccident;
		
		public String getAccId() {
			return accId;
		}
		public void setAccId(String accId) {
			this.accId = accId;
		}
		public String getOfficerName() {
			return officerName;
		}
		public void setOfficerName(String officerName) {
			this.officerName = officerName;
		}
		public String getOfficerAddress() {
			return officerAddress;
		}
		public void setOfficerAddress(String officerAddress) {
			this.officerAddress = officerAddress;
		}
		public String getOfficerNumber() {
			return officerNumber;
		}
		public void setOfficerNumber(String officerNumber) {
			this.officerNumber = officerNumber;
		}
		public String getWhoreportAcc() {
			return whoreportAcc;
		}
		public void setWhoreportAcc(String whoreportAcc) {
			this.whoreportAcc = whoreportAcc;
		}
		public boolean isCctvAvailability() {
			return cctvAvailability;
		}
		public void setCctvAvailability(boolean cctvAvailability) {
			this.cctvAvailability = cctvAvailability;
		}
		public String getAccDescription() {
			return accDescription;
		}
		public void setAccDescription(String accDescription) {
			this.accDescription = accDescription;
		}
		public String getDtSiteplan() {
			return dtSiteplan;
		}
		public void setDtSiteplan(String dtSiteplan) {
			this.dtSiteplan = dtSiteplan;
		}
		public String getDescriptionSiteplan() {
			return descriptionSiteplan;
		}
		public void setDescriptionSiteplan(String descriptionSiteplan) {
			this.descriptionSiteplan = descriptionSiteplan;
		}
		public boolean isFirDoc() {
			return firDoc;
		}
		public void setFirDoc(boolean firDoc) {
			this.firDoc = firDoc;
		}
		public boolean isSiteplanDoc() {
			return siteplanDoc;
		}
		public void setSiteplanDoc(boolean siteplanDoc) {
			this.siteplanDoc = siteplanDoc;
		}
		public boolean isPhotossceneallanglesDoc() {
			return photossceneallanglesDoc;
		}
		public void setPhotossceneallanglesDoc(boolean photossceneallanglesDoc) {
			this.photossceneallanglesDoc = photossceneallanglesDoc;
		}
		public boolean isPhotosvehiclesallanglesDoc() {
			return photosvehiclesallanglesDoc;
		}
		public void setPhotosvehiclesallanglesDoc(boolean photosvehiclesallanglesDoc) {
			this.photosvehiclesallanglesDoc = photosvehiclesallanglesDoc;
		}
		public boolean isCctvfootageDoc() {
			return cctvfootageDoc;
		}
		public void setCctvfootageDoc(boolean cctvfootageDoc) {
			this.cctvfootageDoc = cctvfootageDoc;
		}
		public boolean isReport173crpcDoc() {
			return report173crpcDoc;
		}
		public void setReport173crpcDoc(boolean report173crpcDoc) {
			this.report173crpcDoc = report173crpcDoc;
		}
		public boolean isDriverDoc() {
			return driverDoc;
		}
		public void setDriverDoc(boolean driverDoc) {
			this.driverDoc = driverDoc;
		}
		public boolean isOwnerDoc() {
			return ownerDoc;
		}
		public void setOwnerDoc(boolean ownerDoc) {
			this.ownerDoc = ownerDoc;
		}
		public boolean isIns_compDoc() {
			return ins_compDoc;
		}
		public void setIns_compDoc(boolean ins_compDoc) {
			this.ins_compDoc = ins_compDoc;
		}
		public boolean isClaimantDoc() {
			return claimantDoc;
		}
		public void setClaimantDoc(boolean claimantDoc) {
			this.claimantDoc = claimantDoc;
		}
		public boolean isReg_authorityDoc() {
			return reg_authorityDoc;
		}
		public void setReg_authorityDoc(boolean reg_authorityDoc) {
			this.reg_authorityDoc = reg_authorityDoc;
		}
		public boolean isHospitalDoc() {
			return hospitalDoc;
		}
		public void setHospitalDoc(boolean hospitalDoc) {
			this.hospitalDoc = hospitalDoc;
		}
		public boolean isWitnessCheck() {
			return witnessCheck;
		}
		public void setWitnessCheck(boolean witnessCheck) {
			this.witnessCheck = witnessCheck;
		}
		public boolean isSubmitCheck() {
			return submitCheck;
		}
		public void setSubmitCheck(boolean submitCheck) {
			this.submitCheck = submitCheck;
		}
		public String getUnderSection() {
			return underSection;
		}
		public void setUnderSection(String underSection) {
			this.underSection = underSection;
		}
		public String getLossOfproperty() {
			return lossOfproperty;
		}
		public void setLossOfproperty(String lossOfproperty) {
			this.lossOfproperty = lossOfproperty;
		}
		public String getOtherLoss() {
			return otherLoss;
		}
		public void setOtherLoss(String otherLoss) {
			this.otherLoss = otherLoss;
		}
		public String getNatureAcc() {
			return natureAcc;
		}
		public void setNatureAcc(String natureAcc) {
			this.natureAcc = natureAcc;
		}
		public String getReportingPersonname() {
			return reportingPersonname;
		}
		public void setReportingPersonname(String reportingPersonname) {
			this.reportingPersonname = reportingPersonname;
		}
		public String getReportingPersonaddress() {
			return reportingPersonaddress;
		}
		public void setReportingPersonaddress(String reportingPersonaddress) {
			this.reportingPersonaddress = reportingPersonaddress;
		}
		public String getReportingPersonmobile() {
			return reportingPersonmobile;
		}
		public void setReportingPersonmobile(String reportingPersonmobile) {
			this.reportingPersonmobile = reportingPersonmobile;
		}
		public String getHospitalRemainderdate() {
			return hospitalRemainderdate;
		}
		public void setHospitalRemainderdate(String hospitalRemainderdate) {
			this.hospitalRemainderdate = hospitalRemainderdate;
		}
		public String getRegAuthorityremainderdate() {
			return regAuthorityremainderdate;
		}
		public void setRegAuthorityremainderdate(String regAuthorityremainderdate) {
			this.regAuthorityremainderdate = regAuthorityremainderdate;
		}		
		public String getBriefDescriptionaccident() {
			return briefDescriptionaccident;
		}
		public void setBriefDescriptionaccident(String briefDescriptionaccident) {
			this.briefDescriptionaccident = briefDescriptionaccident;
		}
		public GeneralEntity(String accId, String officerName, String officerAddress, String officerNumber,
				String whoreportAcc, boolean cctvAvailability, String accDescription, String dtSiteplan,
				String descriptionSiteplan, boolean firDoc, boolean siteplanDoc, boolean photossceneallanglesDoc,
				boolean photosvehiclesallanglesDoc, boolean cctvfootageDoc, boolean report173crpcDoc, boolean driverDoc,
				boolean ownerDoc, boolean ins_compDoc, boolean claimantDoc, boolean reg_authorityDoc,
				boolean hospitalDoc, boolean witnessCheck, boolean submitCheck, String underSection,
				String lossOfproperty, String otherLoss, String natureAcc, String reportingPersonname,
				String reportingPersonaddress, String reportingPersonmobile, String hospitalRemainderdate,
				String regAuthorityremainderdate, String briefDescriptionaccident) {
			super();
			this.accId = accId;
			this.officerName = officerName;
			this.officerAddress = officerAddress;
			this.officerNumber = officerNumber;
			this.whoreportAcc = whoreportAcc;
			this.cctvAvailability = cctvAvailability;
			this.accDescription = accDescription;
			this.dtSiteplan = dtSiteplan;
			this.descriptionSiteplan = descriptionSiteplan;
			this.firDoc = firDoc;
			this.siteplanDoc = siteplanDoc;
			this.photossceneallanglesDoc = photossceneallanglesDoc;
			this.photosvehiclesallanglesDoc = photosvehiclesallanglesDoc;
			this.cctvfootageDoc = cctvfootageDoc;
			this.report173crpcDoc = report173crpcDoc;
			this.driverDoc = driverDoc;
			this.ownerDoc = ownerDoc;
			this.ins_compDoc = ins_compDoc;
			this.claimantDoc = claimantDoc;
			this.reg_authorityDoc = reg_authorityDoc;
			this.hospitalDoc = hospitalDoc;
			this.witnessCheck = witnessCheck;
			this.submitCheck = submitCheck;
			this.underSection = underSection;
			this.lossOfproperty = lossOfproperty;
			this.otherLoss = otherLoss;
			this.natureAcc = natureAcc;
			this.reportingPersonname = reportingPersonname;
			this.reportingPersonaddress = reportingPersonaddress;
			this.reportingPersonmobile = reportingPersonmobile;
			this.hospitalRemainderdate = hospitalRemainderdate;
			this.regAuthorityremainderdate = regAuthorityremainderdate;
			this.briefDescriptionaccident = briefDescriptionaccident;
		}
		public GeneralEntity() {
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "GeneralEntity [accId=" + accId + ", officerName=" + officerName + ", officerAddress="
					+ officerAddress + ", officerNumber=" + officerNumber + ", whoreportAcc=" + whoreportAcc
					+ ", cctvAvailability=" + cctvAvailability + ", accDescription=" + accDescription + ", dtSiteplan="
					+ dtSiteplan + ", descriptionSiteplan=" + descriptionSiteplan + ", firDoc=" + firDoc
					+ ", siteplanDoc=" + siteplanDoc + ", photossceneallanglesDoc=" + photossceneallanglesDoc
					+ ", photosvehiclesallanglesDoc=" + photosvehiclesallanglesDoc + ", cctvfootageDoc="
					+ cctvfootageDoc + ", report173crpcDoc=" + report173crpcDoc + ", driverDoc=" + driverDoc
					+ ", ownerDoc=" + ownerDoc + ", ins_compDoc=" + ins_compDoc + ", claimantDoc=" + claimantDoc
					+ ", reg_authorityDoc=" + reg_authorityDoc + ", hospitalDoc=" + hospitalDoc + ", witnessCheck="
					+ witnessCheck + ", submitCheck=" + submitCheck + ", underSection=" + underSection
					+ ", lossOfproperty=" + lossOfproperty + ", otherLoss=" + otherLoss + ", natureAcc=" + natureAcc
					+ ", reportingPersonname=" + reportingPersonname + ", reportingPersonaddress="
					+ reportingPersonaddress + ", reportingPersonmobile=" + reportingPersonmobile
					+ ", hospitalRemainderdate=" + hospitalRemainderdate + ", regAuthorityremainderdate="
					+ regAuthorityremainderdate + ", briefDescriptionaccident=" + briefDescriptionaccident + "]";
		}
		
		
		
		
		
				
}
