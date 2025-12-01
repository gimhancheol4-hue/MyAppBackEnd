package com.example.Eval;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface EvalDAO {

    String testQuery();

    List<Map<String, Object>> getEmployeeByDept(String deptCd);;

    List<Map<String, Object>> getDept();

    List<Map<String, Object>> getProject();

    int createEvalMapping(Map<String, Object> param);

    int deleteEvalMapping(Map<String, Object> param);

    List<Map<String,Object>> getEvalMapping(Map<String, Object> param);
}
