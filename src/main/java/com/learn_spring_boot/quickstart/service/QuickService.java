package com.learn_spring_boot.quickstart.service;

import com.learn_spring_boot.quickstart.dto.ItemDto;
import com.learn_spring_boot.quickstart.mapper.QuickMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service    // 서비스임을 명시
@Slf4j      // 로그 사용하기 위해 명시
public class QuickService {
    @Autowired
    private QuickMapper quickMapper;

    public QuickService(QuickMapper quickMapper) {
        this.quickMapper = quickMapper;
    }

    public boolean registerItem(ItemDto itemDto) {
        // TODO: DB insert

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", itemDto.getId());
        paramMap.put("name", itemDto.getName());

        quickMapper.registerItem(paramMap);

        return true;
    }

    public ItemDto getItemById(String id) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);

        HashMap<String, Object> res = quickMapper.findById(paramMap);

        ItemDto itemDto = new ItemDto();
        itemDto.setId((String) res.get("ID"));
        itemDto.setName((String) res.get("NAME"));

        return itemDto;
    }
}
