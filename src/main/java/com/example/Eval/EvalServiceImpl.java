package com.example.Eval;

import org.springframework.stereotype.Service;

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
}
