package com.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.po.Dept;
@Service("deptDAO")
public interface IDeptMapper {
  public  List<Dept> findAll();
}
