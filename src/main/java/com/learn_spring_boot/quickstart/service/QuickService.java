package com.learn_spring_boot.quickstart.service;

import com.learn_spring_boot.quickstart.dto.ItemDto;
import com.learn_spring_boot.quickstart.entity.ItemEntity;
import com.learn_spring_boot.quickstart.mapper.QuickMapper;
import com.learn_spring_boot.quickstart.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    // 서비스임을 명시
@Slf4j      // 로그 사용하기 위해 명시
public class QuickService {
    @Autowired
    private QuickMapper quickMapper;

    @Autowired
    private ItemRepository itemRepository;

    public QuickService(QuickMapper quickMapper) {
        this.quickMapper = quickMapper;
    }

    public boolean registerItem(ItemDto itemDto) {
        // Mybatis
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", itemDto.getId());
//        paramMap.put("name", itemDto.getName());
//
//        quickMapper.registerItem(paramMap);
//
//        return true;

        // JPA
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());

        itemRepository.save(itemEntity);    // insert
        return true;
    }

    public ItemDto getItemById(String id) {
        // Mybatis
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", id);
//
//        HashMap<String, Object> res = quickMapper.findById(paramMap);
//
//        ItemDto itemDto = new ItemDto();
//        itemDto.setId((String) res.get("ID"));
//        itemDto.setName((String) res.get("NAME"));
//
//        return itemDto;

        // JPA
        ItemEntity itemEntity = itemRepository.findById(id).get();  // select

        ItemDto itemDto = new ItemDto();
        itemDto.setId(itemEntity.getId());
        itemDto.setName(itemEntity.getName());

        return itemDto;
    }
}
