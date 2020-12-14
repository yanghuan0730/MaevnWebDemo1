package com.po;

import java.io.Serializable;
//工资实体类
public class Sarlary implements Serializable {
      private Integer sid;
      private Integer eid;
      private Float  emoney;
	public Sarlary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sarlary(Integer sid, Integer eid, Float emoney) {
		super();
		this.sid = sid;
		this.eid = eid;
		this.emoney = emoney;
	}
	public Sarlary(Integer eid, Float emoney) {
		super();
		this.eid = eid;
		this.emoney = emoney;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public Float getEmoney() {
		return emoney;
	}
	public void setEmoney(Float emoney) {
		this.emoney = emoney;
	}
	@Override
	public String toString() {
		return "Sarlary [sid=" + sid + ", eid=" + eid + ", emoney=" + emoney + "]";
	}
      
}
