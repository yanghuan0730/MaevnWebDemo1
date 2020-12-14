package com.po;

import java.io.Serializable;

public class EmpWelparle  implements Serializable{
     private Integer ewid;
     private Integer eid;
     private Integer wid;
	public EmpWelparle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpWelparle(Integer ewid, Integer eid, Integer wid) {
		super();
		this.ewid = ewid;
		this.eid = eid;
		this.wid = wid;
	}
	
	public EmpWelparle(Integer eid, Integer wid) {
		super();
		this.eid = eid;
		this.wid = wid;
	}
	public Integer getEwid() {
		return ewid;
	}
	public void setEwid(Integer ewid) {
		this.ewid = ewid;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	@Override
	public String toString() {
		return "EmpWelparle [ewid=" + ewid + ", eid=" + eid + ", wid=" + wid + "]";
	}
     
}
