package com.learn_spring_boot.quickstart.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface QuickMapper {
    HashMap<String, Object> findById(HashMap<String, Object> paramMap);

    void registerItem(HashMap<String, Object> paramMap);
}
