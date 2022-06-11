package com.gsnotes.web.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentExcel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sid;
	private String scne;
	private String snom;
	private String sprenom;
	
	private long sniveau;
	private String stype;
	public StudentExcel(long sid, String scne,String snom, String sprenom, long niveau, String stype) {
		super();
		this.sid = sid;
		this.scne=scne;
		this.snom = snom;
		this.sprenom = sprenom;
		this.sniveau = niveau;
		this.stype = stype;
	}
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public String getSnom() {
		return snom;
	}
	public void setSnom(String snom) {
		this.snom = snom;
	}
	public String getSprenom() {
		return sprenom;
	}
	public void setSprenom(String sprenom) {
		this.sprenom = sprenom;
	}
	public long getSniveau() {
		return sniveau;
	}
	public void setSniveau(long sniveau) {
		this.sniveau = sniveau;
	}
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	public String getScne() {
		return scne;
	}
	public void setScne(String scne) {
		this.scne = scne;
	}
	@Override
	public String toString() {
		return "StudentExcel wissal [sid=" + this.sid + ", scne=" + this.scne + ", snom=" + this.snom + ", sprenom=" + this.sprenom + ", sniveau="
				+ this.sniveau + ", stype=" + this.stype + "]";
	}
	
	
	
	
	

}
