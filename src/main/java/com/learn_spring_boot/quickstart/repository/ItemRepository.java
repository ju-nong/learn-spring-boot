package com.learn_spring_boot.quickstart.repository;

import com.learn_spring_boot.quickstart.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// ItemEntity, ItemEntity의 Primary key 타입 = String
public interface ItemRepository extends JpaRepository<ItemEntity, String> {

}
