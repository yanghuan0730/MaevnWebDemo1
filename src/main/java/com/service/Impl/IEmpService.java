package com.service.Impl;

import java.util.List;

import com.po.Emp;
import com.po.PageBean;

public interface IEmpService {
	public  boolean save(Emp emp);
	 public  boolean deleById(Integer eid);
	 public  boolean update(Emp emp);
	 public  Emp  findById(Integer eid);
	 public  List<Emp>  findPageAll(PageBean pb);
	 public   int   findMaxRows();
	 public   int   findMaxEid();
}
