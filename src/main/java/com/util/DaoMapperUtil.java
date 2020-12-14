package com.util;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.IDeptMapper;
import com.mapper.IEmpMapper;
import com.mapper.IEmpWelparleMapper;
import com.mapper.ISarlaryMapper;
import com.mapper.IWelparleMapper;


@Service("daomapper")
public class DaoMapperUtil {
	@Resource(name="deptDAO")
private IDeptMapper depMapper;
	@Resource(name="empDAO")
private IEmpMapper empMapper;
	@Resource(name="empwelparleDAO")
private IEmpWelparleMapper empWelparle;
	@Resource(name="sarlaryDAO")
private ISarlaryMapper salaryMapper;
	@Resource(name="welparleDAO")
private IWelparleMapper welparleMapper;
	public IDeptMapper getDepMapper() {
		return depMapper;
	}
	public void setDepMapper(IDeptMapper depMapper) {
		this.depMapper = depMapper;
	}
	public IEmpMapper getEmpMapper() {
		return empMapper;
	}
	public void setEmpMapper(IEmpMapper empMapper) {
		this.empMapper = empMapper;
	}
	public IEmpWelparleMapper getEmpWelparle() {
		return empWelparle;
	}
	public void setEmpWelparle(IEmpWelparleMapper empWelparle) {
		this.empWelparle = empWelparle;
	}
	public ISarlaryMapper getSalaryMapper() {
		return salaryMapper;
	}
	public void setSalaryMapper(ISarlaryMapper salaryMapper) {
		this.salaryMapper = salaryMapper;
	}
	public IWelparleMapper getWelparleMapper() {
		return welparleMapper;
	}
	public void setWelparleMapper(IWelparleMapper welparleMapper) {
		this.welparleMapper = welparleMapper;
	}
	
}
