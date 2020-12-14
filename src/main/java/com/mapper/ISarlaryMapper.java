package com.mapper;

import org.springframework.stereotype.Service;

import com.po.Sarlary;
@Service("sarlaryDAO")
public interface ISarlaryMapper {
  public int save(Sarlary sa);
  public int update(Sarlary sa);
  public  int deleById(Integer eid);
  public Sarlary findSarlary(Integer eid); 
}
