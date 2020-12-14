package com.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.IEmpMapper;
import com.po.Emp;
import com.po.EmpWelparle;
import com.po.PageBean;
import com.po.Sarlary;
import com.po.Welparle;

import com.util.DaoMapperUtil;
@Service("EmpServiceImpl")
public class EmpServiceImpl implements IEmpService {
@Resource(name="daomapper")
private DaoMapperUtil dmu;


	public DaoMapperUtil getDmu() {
	return dmu;
}

public void setDmu(DaoMapperUtil dmu) {
	this.dmu = dmu;
}

	@Override
	public boolean save(Emp emp) {
		//添加员工信息
	    int code=dmu.getEmpMapper().save(emp);
	    if(code>0){
	    	//获取最大员工id
	    	Integer eid=dmu.getEmpMapper().findMaxEid();
	    	//向工资表添加工资
	    	Sarlary sa=new Sarlary(eid,emp.getEmoney());
	    	dmu.getSalaryMapper().save(sa);
	    	//获取福利id的数组
	    String[] wids=emp.getWid();
	    //向福利表添加员工id和福利id
	    if(wids!=null&&wids.length>0){
	    	for(int i=0;i<wids.length;i++){
	    		EmpWelparle ew=new EmpWelparle(eid,new Integer(wids[i]));
	    		dmu.getEmpWelparle().save(ew);
	    	}
	    }
	    return true;
	 }
		return false;
	}

	@Override
	public boolean deleById(Integer eid) {
		//先删除子表数据
		dmu.getSalaryMapper().deleById(eid);
		dmu.getEmpWelparle().deleById(eid);
		//删除员工数据
		int code=dmu.getEmpMapper().deleById(eid);
		if(code>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Emp emp) {
		//先修改员工信息
		int code=dmu.getEmpMapper().update(emp);
		if(code>0){
			//修改工资
			Sarlary oldsa=dmu.getSalaryMapper().findSarlary(emp.getEid());
			if(oldsa!=null&&oldsa.getEmoney()!=null){
				if(oldsa.getEmoney()<emp.getEmoney()){
					oldsa.setEmoney(emp.getEmoney());
				
				}else{
					dmu.getSalaryMapper().update(oldsa);
				}
				
			}else{
				Sarlary sa=new Sarlary(emp.getEid(),emp.getEmoney());
				dmu.getSalaryMapper().update(sa);
			}
			//修改员工福利
			List<Welparle> lwlp=dmu.getEmpWelparle().findAll(emp.getEid());
			if(lwlp!=null&&lwlp.size()>0){
				dmu.getEmpWelparle().deleById(emp.getEid());
			}
			String[] wids=emp.getWid();
			if(wids!=null&&wids.length>0){
				for(int i=0;i<wids.length;i++){
		    		EmpWelparle ew=new EmpWelparle(emp.getEid(),new Integer(wids[i]));
		    		dmu.getEmpWelparle().save(ew);
		    	}
			}
			return true;
		}
		return false;
	}

	@Override
	public Emp findById(Integer eid) {
		//查询员工信息
	     Emp oldemp=dmu.getEmpMapper().findById(eid);
	
	     //查询薪资
	     Sarlary oldsa=dmu.getSalaryMapper().findSarlary(eid);
	   
	     if(oldemp!=null&&oldsa.getEmoney()!=null){
	    	
	    	 oldemp.setEmoney(oldsa.getEmoney());
	    
	     }
	     //查询福利
	     List<Welparle> lwl=dmu.getEmpWelparle().findAll(eid);
	     if(lwl!=null&&lwl.size()>0){
				//创建福利编号数组
				String[] wids=new String[lwl.size()];
				for(int i=0;i<lwl.size();i++){
					Welparle wf=lwl.get(i);
					wids[i]=wf.getWid().toString();
				}
				oldemp.setWid(wids);
			}
			oldemp.setWname(lwl);
		return oldemp;
	}

	@Override
	public List<Emp> findPageAll(PageBean pb) {
		// TODO Auto-generated method stub
		return dmu.getEmpMapper().findPageAll(pb);
	}

	@Override
	public int findMaxRows() {
		// TODO Auto-generated method stub
		return dmu.getEmpMapper().findMaxRows();
	}

	@Override
	public int findMaxEid() {
		// TODO Auto-generated method stub
		return dmu.getEmpMapper().findMaxEid();
	}

}
