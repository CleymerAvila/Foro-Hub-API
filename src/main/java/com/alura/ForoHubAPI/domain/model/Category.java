package com.alura.ForoHubAPI.domain.model;

public enum Category {
    PROGRAMMING,
    LANGUAGE,
    MATH,
    ENGINEERING,
    DATA_SCIENCE,
    BACK_END,
    FRONT_END,
    BUSINESS,
    INNOVATION,
    DEV_OPS,
    OFF_TOPIC;

    public static Category fromString(String name) {
        for(Category c: Category.values() ){
            if(name.toUpperCase().equals(c.toString().toUpperCase())){
                return c;
            }
        }
        return null;
    }
}
