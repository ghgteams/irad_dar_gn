package com.irad.dar.documents;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "irad_dar_documents", schema = "public")
public class DocumentEntity {
		
		@Id
		@Column(name="id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		public long id;	
		
		@Column(name="accident_id")
		private String accidentId;    
		
		@Column(name="usetype")
		private String usetype;
		
		@Column(name="link_id")
		private String linkId;
		
		@Column(name="title")
		private String title;
		
		@Column(name="file")
		private String file;
		
		@Column(name="remarks")
		private String remarks;
		
		@Column(name="active")
		private boolean active;
		
		@Column(name="insertedon")
		private Timestamp insertedOn;
		
		@Column(name="insertedby")
		private String insertedBy;

		public String getAccidentId() {
			return accidentId;
		}

		public void setAccidentId(String accidentId) {
			this.accidentId = accidentId;
		}

		public String getUsetype() {
			return usetype;
		}

		public void setUsetype(String usetype) {
			this.usetype = usetype;
		}

		public String getLinkId() {
			return linkId;
		}

		public void setLinkId(String linkId) {
			this.linkId = linkId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getFile() {
			return file;
		}

		public void setFile(String file) {
			this.file = file;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		public Timestamp getInsertedOn() {
			return insertedOn;
		}

		public void setInsertedOn(Timestamp insertedOn) {
			this.insertedOn = insertedOn;
		}

		public String getInsertedBy() {
			return insertedBy;
		}

		public void setInsertedBy(String insertedBy) {
			this.insertedBy = insertedBy;
		}

		public DocumentEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public DocumentEntity(long id, String accidentId, String usetype, String linkId, String title, String file,
				String remarks, boolean active, Timestamp insertedOn, String insertedBy) {
			super();
			this.id = id;
			this.accidentId = accidentId;
			this.usetype = usetype;
			this.linkId = linkId;
			this.title = title;
			this.file = file;
			this.remarks = remarks;
			this.active = active;
			this.insertedOn = insertedOn;
			this.insertedBy = insertedBy;
		}

		@Override
		public String toString() {
			return "DocumentEntity [id=" + id + ", accidentId=" + accidentId + ", usetype=" + usetype + ", linkId="
					+ linkId + ", title=" + title + ", file=" + file + ", remarks=" + remarks + ", active=" + active
					+ ", insertedOn=" + insertedOn + ", insertedBy=" + insertedBy + "]";
		}
		
		
	
		
		
}
