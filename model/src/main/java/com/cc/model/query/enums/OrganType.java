package com.cc.model.query.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum OrganType {

    USER(1, "用户"),

    GROUP(2, "群"),

    SCHOOL(3, "学校");


    private final int type;

    private final String description;

    private static final Map<Integer, OrganType > typeMap;

    OrganType(int type, String description) {
        this.type = type;
        this.description = description;
    }

    static {
        typeMap = Arrays.stream(OrganType .values()).collect(Collectors.toMap(OrganType ::getType, a -> a));
    }

    public static OrganType parse(Integer type) {
        if (typeMap.containsKey(type)) {
            return typeMap.get(type);
        }
        return null;
    }

    public String getDescription() {
        return description;
    }

    public int getType() {
        return type;
    }
}
