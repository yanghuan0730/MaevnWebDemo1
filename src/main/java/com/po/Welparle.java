package com.po;

import java.io.Serializable;

public class Welparle implements Serializable {
    private Integer wid;
    private String wname;
	public Welparle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Welparle(Integer wid, String wname) {
		super();
		this.wid = wid;
		this.wname = wname;
	}
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	@Override
	public String toString() {
		return "Welparle [wid=" + wid + ", wname=" + wname + "]";
	}
    
}
