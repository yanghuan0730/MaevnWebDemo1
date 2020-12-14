package com.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.po.EmpWelparle;
import com.po.Welparle;


@Service("empwelparleDAO")
public interface IEmpWelparleMapper {
 public  int  save(EmpWelparle ewl);
 public  int deleById(Integer eid);
 public List<Welparle> findAll(Integer eid);
}
