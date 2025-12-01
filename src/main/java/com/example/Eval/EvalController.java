package com.example.Eval;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    /**
     * 인사평가 매핑 일괄 생성
     * - TCOM010_EMP_DEPT 기준으로 EVAL_MAPPING 생성
     * - 1행 = 1명 (자기/1차/2차 평가자 정보 포함)
     *
     * 예시 요청:
     * POST /api/eval/mapping/create
     * {
     *   "year": "2025",
     *   "evalType": "INS",
     *   "instCd": "001",
     *   "selfDueDate": "2025-12-10",
     *   "firstDueDate": "2025-12-15",
     *   "secondDueDate": "2025-12-20"
     * }
     */
    @PostMapping("/mapping/create")
    public Map<String, Object> createEvalMapping(@RequestBody Map<String, Object> body) {

        // 파라미터 가공 (필요하면 기본값 세팅)
        Map<String, Object> param = new HashMap<>();
        param.put("year",        body.get("year"));        // "2025"
        param.put("instCd",      body.get("instCd"));      // "001" (nullable)
        param.put("selfDueDate", body.get("selfDueDate")); // "2025-12-10"
        param.put("firstDueDate", body.get("firstDueDate"));
        param.put("secondDueDate", body.get("secondDueDate"));

        // 서비스 호출 (내부에서 기존 데이터 삭제 + INSERT ... SELECT 실행하도록)
        int insertedCount = evalService.createEvalMapping(param);

        // 프론트로 보낼 응답
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("insertedCount", insertedCount);
        result.put("message", "인사평가 매핑이 생성되었습니다.");

        return result;
    }
}
