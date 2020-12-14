package com.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.po.Welparle;

import com.util.DaoMapperUtil;
@Service("WelparleServiceImpl")
public class WelparleServiceImpl implements IWelparleService {
	@Resource(name="daomapper")
	private DaoMapperUtil dmu;


		public DaoMapperUtil getDmu() {
		return dmu;
	}

	public void setDmu(DaoMapperUtil dmu) {
		this.dmu = dmu;
	}
	@Override
	public List<Welparle> findAll() {
		// TODO Auto-generated method stub
		return dmu.getWelparleMapper().findAll();
	}

}
