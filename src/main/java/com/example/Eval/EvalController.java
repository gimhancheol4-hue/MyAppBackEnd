package com.example.Eval;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eval")  // 컨트롤러 루트 경로
public class EvalController {

    private final EvalService evalService;

    public EvalController(EvalService evalService) {
        this.evalService = evalService;
    }

    // 기존 테스트용 엔드포인트: GET /eval
    @GetMapping
    public String test() {
        return evalService.testService();
    }

    // ✅ 부서 목록 조회: GET /eval/dept
    @GetMapping("/dept")
    public List<Map<String, Object>> getDeptList() {
        return evalService.getDept();
    }

    // ✅ 특정 부서 사원 목록 조회: GET /eval/dept/{deptCd}/employees
    @GetMapping("/dept/{deptCd}/employees")
    public List<Map<String, Object>> getEmployeeByDept(@PathVariable String deptCd) {
        return evalService.getEmployeeByDept(deptCd);
    }
}
