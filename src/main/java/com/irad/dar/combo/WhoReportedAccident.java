package com.irad.dar.combo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_dar_who_report_acc", schema = "public")
public class WhoReportedAccident {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;

	@Column(name = "en")
	private String en;

	@Column(name = "ta")
	private String ta;

	@Column(name = "hi")
	private String hi;

	@Column(name = "te")
	private String te;

	@Column(name = "kn")
	private String kn;

	@Column(name = "be")
	private String be;

	@Column(name = "asm")
	private String asm;

	@Column(name = "mr")
	private String mr;

	@Column(name = "od")
	private String od;

	@Column(name = "pa")
	private String pa;

	@Column(name = "ml")
	private String ml;

	@Column(name = "dispid")
	private int dispid;

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public String getTa() {
		return ta;
	}

	public void setTa(String ta) {
		this.ta = ta;
	}

	public String getHi() {
		return hi;
	}

	public void setHi(String hi) {
		this.hi = hi;
	}

	public String getTe() {
		return te;
	}

	public void setTe(String te) {
		this.te = te;
	}

	public String getKn() {
		return kn;
	}

	public void setKn(String kn) {
		this.kn = kn;
	}

	public String getBe() {
		return be;
	}

	public void setBe(String be) {
		this.be = be;
	}

	public String getAsm() {
		return asm;
	}

	public void setAsm(String asm) {
		this.asm = asm;
	}

	public String getMr() {
		return mr;
	}

	public void setMr(String mr) {
		this.mr = mr;
	}

	public String getOd() {
		return od;
	}

	public void setOd(String od) {
		this.od = od;
	}

	public String getPa() {
		return pa;
	}

	public void setPa(String pa) {
		this.pa = pa;
	}

	public String getMl() {
		return ml;
	}

	public void setMl(String ml) {
		this.ml = ml;
	}

	public int getDispid() {
		return dispid;
	}

	public void setDispid(int dispid) {
		this.dispid = dispid;
	}

	public WhoReportedAccident() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WhoReportedAccident(long id, String en, String ta, String hi, String te, String kn, String be, String asm,
			String mr, String od, String pa, String ml, int dispid) {
		super();
		this.id = id;
		this.en = en;
		this.ta = ta;
		this.hi = hi;
		this.te = te;
		this.kn = kn;
		this.be = be;
		this.asm = asm;
		this.mr = mr;
		this.od = od;
		this.pa = pa;
		this.ml = ml;
		this.dispid = dispid;
	}

	@Override
	public String toString() {
		return "WhoReportedAccident [id=" + id + ", en=" + en + ", ta=" + ta + ", hi=" + hi + ", te=" + te + ", kn="
				+ kn + ", be=" + be + ", asm=" + asm + ", mr=" + mr + ", od=" + od + ", pa=" + pa + ", ml=" + ml
				+ ", dispid=" + dispid + "]";
	}

}
