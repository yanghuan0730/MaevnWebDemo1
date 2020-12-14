package com.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.IDeptMapper;
import com.po.Dept;

import com.util.DaoMapperUtil;

@Service("DeptServiceImpl")
public class DeptServiceImpl implements IDeptService {
 @Resource(name="daomapper")
  private  DaoMapperUtil dmu;



	public DaoMapperUtil getDmu() {
	return dmu;
}



public void setDmu(DaoMapperUtil dmu) {
	this.dmu = dmu;
}



	@Override
	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		return dmu.getDepMapper().findAll();
	}

}
