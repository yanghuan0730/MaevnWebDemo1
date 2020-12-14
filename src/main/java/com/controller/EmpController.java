package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.po.Dept;
import com.po.Emp;
import com.po.PageBean;
import com.po.Welparle;
import com.util.AJAXUtils;
import com.util.BizServiceUtil;

@Controller
public class EmpController {
@Resource(name="BizService")
private BizServiceUtil  bsu;

public BizServiceUtil getBsu() {
	return bsu;
}

public void setBsu(BizServiceUtil bsu) {
	this.bsu = bsu;
}
@RequestMapping(value="save_emp.do")
public String save(HttpServletRequest request,HttpServletResponse response,Emp emp){
	 String realpath=request.getRealPath("/");
	   //获取文件上传的对象
	   MultipartFile multipartFile=emp.getPic();
	   if(multipartFile!=null&&!multipartFile.isEmpty()){
		   //获取文件上传名称
		   String fname=multipartFile.getOriginalFilename();
		   //更名
		   if(fname.lastIndexOf(".")!=-1){
			   //获取存在的后缀
			   String ext=fname.substring(fname.lastIndexOf("."));
			   //判断后缀格式
			   if(ext.equalsIgnoreCase(".jpg")){
				   String newfname=new Date().getTime()+ext;
				   //创建文件对象指定上传路径
				   File dostfile=new File(realpath+"/uppic/"+newfname);
				   //复制文件内容,上传
				   try {
					FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), dostfile);
					emp.setPhoto(newfname);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
		   }
	   }
	boolean flag=bsu.getEmpService().save(emp);
	if(flag){
		AJAXUtils.printString(response, 1+"");
	}else{
		AJAXUtils.printString(response, 0+"");
	}
	return null;
}
@RequestMapping(value="update_emp.do")
public String update(HttpServletRequest request,HttpServletResponse response,Emp emp){
	//获取原来照片
		String oldphoto=bsu.getEmpService().findById(emp.getEid()).getPhoto();
		String realpath=request.getRealPath("/");
		   //获取文件上传的对象
		   MultipartFile multipartFile=emp.getPic();
		   if(multipartFile!=null&&!multipartFile.isEmpty()){
			   //获取文件上传名称
			   String fname=multipartFile.getOriginalFilename();
			   //更名
			   if(fname.lastIndexOf(".")!=-1){
				   //获取存在的后缀
				   String ext=fname.substring(fname.lastIndexOf("."));
				   //判断后缀格式
				   if(ext.equalsIgnoreCase(".jpg")){
					   String newfname=new Date().getTime()+ext;
					   //创建文件对象指定上传路径
					   File dostfile=new File(realpath+"/uppic/"+newfname);
					   //复制文件内容,上传
					   try {
						FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), dostfile);
						emp.setPhoto(newfname);
						//删除原来照片
						File oldfile=new File(realpath+"/uppic/"+oldphoto);
						if(oldfile.exists()&&!oldphoto.equalsIgnoreCase("default.jpg")){
							oldfile.delete();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   }
			   }
		   }else{
			   emp.setPhoto(oldphoto);
		   }
		 
		boolean flag=bsu.getEmpService().update(emp);
	
		
		if(flag){
			AJAXUtils.printString(response, 1+"");
		}else{
			AJAXUtils.printString(response, 0+"");
		}
	return null;
}
@RequestMapping(value="deleById_emp.do")
public String deleById(HttpServletRequest request,HttpServletResponse response,Integer eid){
	boolean flag=bsu.getEmpService().deleById(eid);
	if(flag){
		AJAXUtils.printString(response, 1+"");
	}else{
		AJAXUtils.printString(response, 0+"");
	}  
	return null;
}
@RequestMapping(value="findDetail_emp.do")
public String findDetail(HttpServletRequest request,HttpServletResponse response,Integer eid){
	Emp oldemp=bsu.getEmpService().findById(eid);

	PropertyFilter propertyFilter=AJAXUtils.filterProperts("birthday","pic");
	String jsonstr=JSONObject.toJSONString(oldemp,propertyFilter,SerializerFeature.DisableCircularReferenceDetect);
	AJAXUtils.printString(response,jsonstr);  
	return null;
  }
@RequestMapping(value="findPageAll_emp.do")
public String findPageAll(HttpServletRequest request,HttpServletResponse response,Integer page,Integer rows){
	Map<String,Object> map= new HashMap<String,Object>();
	PageBean pb=new PageBean();
	page=page==null||page<1?pb.getPage():page;
	rows=rows==null||rows<1?pb.getRows():rows;
	pb.setPage(page);
	pb.setRows(rows);
	List<Emp> lsemp=bsu.getEmpService().findPageAll(pb);
	int maxrows=bsu.getEmpService().findMaxRows();
	//按照easyUI的格式封装数据
	map.put("page",page);
	map.put("rows",lsemp);
	map.put("total",maxrows);
	PropertyFilter propertyFilter=AJAXUtils.filterProperts("birthday","pic");
	String jsonstr=JSONObject.toJSONString(map,propertyFilter,SerializerFeature.DisableCircularReferenceDetect);
	AJAXUtils.printString(response,jsonstr);
	return null;
}
@RequestMapping(value="doinit_emp.do")
public String doinit(HttpServletRequest request,HttpServletResponse response){
	Map<String,Object> map= new HashMap<String,Object>();
	List<Dept> lsdep=bsu.getDeptService().findAll();
	List<Welparle> lswp=bsu.getWelparleService().findAll();
	map.put("lsdep", lsdep);
	map.put("lswf", lswp);
	PropertyFilter propertyFilter=AJAXUtils.filterProperts("birthday","pic");
	String jsonstr=JSONObject.toJSONString(map,propertyFilter,SerializerFeature.DisableCircularReferenceDetect);
	AJAXUtils.printString(response,jsonstr); 
	return null;
  }
@RequestMapping(value="findById_emp.do")
public String findById(HttpServletRequest request,HttpServletResponse response,Integer eid){
	Emp oldemp=bsu.getEmpService().findById(eid);
	PropertyFilter propertyFilter=AJAXUtils.filterProperts("birthday","pic");
	String jsonstr=JSONObject.toJSONString(oldemp,propertyFilter,SerializerFeature.DisableCircularReferenceDetect);
	AJAXUtils.printString(response,jsonstr);
	return null;
  }
}
