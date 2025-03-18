package com.learn_spring_boot.quickstart.dto;

public class ItemDto {
    private String id;
    private String name;

    // Alt + Insert -> getter 및 setter 메뉴 클릭
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
