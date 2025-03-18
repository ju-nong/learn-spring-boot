package com.learn_spring_boot.quickstart.service;

import com.learn_spring_boot.quickstart.dto.ItemDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service    // 서비스임을 명시
@Slf4j      // 로그 사용하기 위해 명시
public class QuickService {
    public boolean registerItem(ItemDto itemDto) {
        // TODO: DB insert

        log.info("service ...");

        return true;
    }
}
