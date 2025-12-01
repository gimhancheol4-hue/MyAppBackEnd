package com.example.Eval;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EvalServiceImpl implements EvalService {


    private final EvalDAO evalDAO;

    public EvalServiceImpl(EvalDAO evalDAO) {
        this.evalDAO = evalDAO;
    }

    @Override
    public String testService() {

        String result = evalDAO.testQuery();
        return result;
    }

    @Override
    public List<Map<String, Object>> getEmployeeByDept(String deptCd) {
        return evalDAO.getEmployeeByDept(deptCd);
    }

    @Override
    public List<Map<String, Object>> getDept() {
        return evalDAO.getDept();
    }

    @Override
    public List<Map<String, Object>> getProject() {
        return evalDAO.getProject();
    }

    public int createEvalMapping(Map<String, Object> param){

        evalDAO.deleteEvalMapping(param);

        return evalDAO.createEvalMapping(param);
    }

    public List<Map<String,Object>> getEvalMapping(Map<String, Object> param){
        return evalDAO.getEvalMapping(param);
    };

    @Override
    public List<Map<String, Object>> getEvalForms(Map<String, Object> param) {
        return evalDAO.getEvalForms(param);
    }

    @Override
    public List<Map<String, Object>> getEvalLayout(Map<String, Object> param) {
        return evalDAO.getEvalLayout(param);
    }
}
