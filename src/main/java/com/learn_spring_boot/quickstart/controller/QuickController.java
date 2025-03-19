package com.learn_spring_boot.quickstart.controller;

import com.learn_spring_boot.quickstart.dto.ItemDto;
import com.learn_spring_boot.quickstart.dto.ResponseDto;
import com.learn_spring_boot.quickstart.service.QuickService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // 컨트롤러임을 명시
@Slf4j  // log를 쓰기 위함
public class QuickController {
    @Autowired
    private QuickService quickService;

    @GetMapping("/dummy")   // GET 메소드
    public String dummy() {
        log.info("dummy");
        return "dummy";
    }

    @GetMapping("/dummy2")
    public String dummy2() {
        log.info("dummy2");
        return "dummy2";
    }

    @GetMapping("/member")  // RequestParam 예시 /member?empNo=2&year=2024, 필수 여부 및 기본값도 설정할 수 있음
    public String getMember(@RequestParam("empNo") String empNo, @RequestParam("year") int year) {
        log.info("empNo: {}", empNo);
        log.info("year: {}", year);

        return "ok";
    }

    @GetMapping("/company/{id}")    // PathVariable 예시 /company/2234
    public String getCompany(@PathVariable("id") String id) {
        log.info("id: {}", id);

        return "ok";
    }

    @PostMapping("/item")   // POST 메소드
    @Operation(summary = "API 요약", description = "API 설명")  // Swagger 설명 추가
    public ResponseDto registerItem(@RequestBody ItemDto item) {    // Body를 받기 위함 (JSON에 해당하는 DTO를 만들어줘야 됨)
        log.info("item {}", item);

        boolean b = quickService.registerItem(item);
        ResponseDto responseDto = new ResponseDto();

        if (b) {
            responseDto.setMessage("ok");
        } else {
            responseDto.setMessage("fail");
        }

        return responseDto;
    }

    @GetMapping("/item")    // /company/2234
    public ItemDto getItem(@RequestParam("id") String id) {
        return quickService.getItemById(id);
    }
}
