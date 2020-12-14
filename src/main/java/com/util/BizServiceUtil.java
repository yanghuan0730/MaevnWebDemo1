package com.util;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import  com.service.Impl.*;


@Service("BizService")
public class BizServiceUtil {
	@Resource(name="DeptServiceImpl")
	private IDeptService deptService;
	@Resource(name="EmpServiceImpl")
	private IEmpService empService;
	@Resource(name="WelparleServiceImpl")
	private IWelparleService welparleService;
	public IDeptService getDeptService() {
		return deptService;
	}
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	public IEmpService getEmpService() {
		return empService;
	}
	public void setEmpService(IEmpService empService) {
		this.empService = empService;
	}
	public IWelparleService getWelparleService() {
		return welparleService;
	}
	public void setWelparleService(IWelparleService welparleService) {
		this.welparleService = welparleService;
	}
	
	

}
