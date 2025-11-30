package com.example.Eval;

import java.util.List;
import java.util.Map;

public interface EvalService {
    String testService();

    List<Map<String, Object>> getEmployeeByDept(String deptCd);;

    List<Map<String, Object>> getDept();

    List<Map<String, Object>> getProject();
}
