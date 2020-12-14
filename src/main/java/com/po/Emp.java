package com.po;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Emp implements Serializable {
   private Integer eid;
   private String  ename;
   private String  sex;
   private String  address;
   private Date    birthday;
   private String  photo="defalut.jpg";
   private Integer deptid;
   //临时属性
   //部门名称
   private String dname;
   //日期类型转换成字符串
   private String sdate;
   
   private Float  emoney;
   //福利名称
   private List<Welparle> wname;
   private String[] wid;
   //上传图片处理
   private MultipartFile pic;
   
public Emp() {
	super();
	// TODO Auto-generated constructor stub
}
public Emp(Integer eid, String ename, String sex, String address, Date birthday, String photo, Integer deptid) {
	super();
	this.eid = eid;
	this.ename = ename;
	this.sex = sex;
	this.address = address;
	this.birthday = birthday;
	this.photo = photo;
	this.deptid = deptid;
}

public Emp(Integer eid, String ename, String sex, String address, Date birthday, String photo, Integer deptid,
		String dname, String sdate, Float emoney, List<Welparle> wname, String[] wid, MultipartFile pic) {
	super();
	this.eid = eid;
	this.ename = ename;
	this.sex = sex;
	this.address = address;
	this.birthday = birthday;
	this.photo = photo;
	this.deptid = deptid;
	this.dname = dname;
	this.sdate = sdate;
	this.emoney = emoney;
	this.wname = wname;
	this.wid = wid;
	this.pic = pic;
}
public Integer getEid() {
	return eid;
}
public void setEid(Integer eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
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
public String getSdate() {
	sdate=new SimpleDateFormat("yyyy-MM-dd").format(birthday);
	return sdate;
}
public void setSdate(String sdate) {
	try {
		birthday=new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
	} catch (ParseException e) {
		
		e.printStackTrace();
	}
	this.sdate = sdate;
}
public Float getEmoney() {
	return emoney;
}
public void setEmoney(Float emoney) {
	this.emoney = emoney;
}

public List<Welparle> getWname() {
	return wname;
}
public void setWname(List<Welparle> wname) {
	this.wname = wname;
}
public String[] getWid() {
	return wid;
}
public void setWid(String[] wid) {
	this.wid = wid;
}
public MultipartFile getPic() {
	return pic;
}
public void setPic(MultipartFile pic) {
	this.pic = pic;
}
@Override
public String toString() {
	return "Emp [eid=" + eid + ", ename=" + ename + ", sex=" + sex + ", address=" + address + ", birthday=" + birthday
			+ ", photo=" + photo + ", deptid=" + deptid + ", dname=" + dname + ", sdate=" + sdate + ", emoney=" + emoney
			+ ", wname=" + wname + ", wid=" + Arrays.toString(wid) + ", pic=" + pic + "]";
}

   
}
