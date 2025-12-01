package com.example.Eval;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EvalService {
    String testService();

    List<Map<String, Object>> getEmployeeByDept(String deptCd);;

    List<Map<String, Object>> getDept();

    List<Map<String, Object>> getProject();

    int createEvalMapping(Map<String, Object> param);

    List<Map<String,Object>> getEvalMapping(Map<String, Object> param);

    List<Map<String, Object>> getEvalForms(Map<String, Object> param);

    List<Map<String, Object>> getEvalLayout(Map<String, Object> param);
}
