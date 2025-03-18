package com.learn_spring_boot.quickstart.controller;

import com.learn_spring_boot.quickstart.dto.ItemDto;
import com.learn_spring_boot.quickstart.dto.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class QuickController {
    @GetMapping("/dummy")
    public String dummy() {
        log.info("dummy");
        return "dummy";
    }

    @GetMapping("/dummy2")
    public String dummy2() {
        log.info("dummy2");
        return "dummy2";
    }

    @GetMapping("/member")  // /member?empNo=2&year=2024
    public String getMember(@RequestParam("empNo") String empNo, @RequestParam("year") int year) {
        log.info("empNo: {}", empNo);
        log.info("year: {}", year);

        return "ok";
    }

    @GetMapping("/company/{id}")    // /company/2234
    public String getCompany(@PathVariable("id") String id) {
        log.info("id: {}", id);

        return "ok";
    }

    @PostMapping("/item")
    @Operation(summary = "API 요약", description = "API 설명")
    public ResponseDto registerItem(@RequestBody ItemDto item) {
        log.info("item {}", item);

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("ok");

        return responseDto;
    }
}
