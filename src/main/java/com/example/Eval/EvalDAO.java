package com.example.Eval;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EvalDAO {

    String testQuery();

    List<Map<String, Object>> getEmployeeByDept(String deptCd);;

    List<Map<String, Object>> getDept();

    List<Map<String, Object>> getProject();
}
