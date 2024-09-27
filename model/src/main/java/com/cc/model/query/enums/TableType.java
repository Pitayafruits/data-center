package com.cc.model.query.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum TableType {

    TABLE(1, "报表"),

    CHART(2, "图表");


    private final int type;

    private final String description;

    private static final Map<Integer, TableType> typeMap;

    TableType(int type, String description) {
        this.type = type;
        this.description = description;
    }

    static {
        typeMap = Arrays.stream(TableType.values()).collect(Collectors.toMap(TableType::getType, a -> a));
    }

    public static TableType parse(Integer type) {
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
