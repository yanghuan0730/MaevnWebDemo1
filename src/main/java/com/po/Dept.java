package com.po;

import java.io.Serializable;

public class Dept implements Serializable {
    private Integer  deptid;
    private String dname;
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dept(Integer deptid, String dname) {
		super();
		this.deptid = deptid;
		this.dname = dname;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Dept [deptid=" + deptid + ", dname=" + dname + "]";
	}
    
}
