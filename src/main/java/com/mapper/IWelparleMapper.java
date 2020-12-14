package com.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.po.Welparle;
@Service("welparleDAO")
public interface IWelparleMapper {
  public List<Welparle> findAll();
}
