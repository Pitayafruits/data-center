package com.cc.model.collect.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 维度枚举.
 */
@Getter
@AllArgsConstructor
public enum DimensionEnum {
    USER("USER","用户"),
    GROUP("GROUP","群组"),
    SCHOLL("SCHOOL","学校"),
    ;

    private static final Map<String, DimensionEnum> sourceMap = Arrays.asList(values()).stream().collect(Collectors.toMap(DimensionEnum::getDimension, v->v));

    private final String dimension;
    private final String description;

    public static DimensionEnum parse(String dimension){
        return sourceMap.get(dimension);
    }

    public DimensionEnum nextDimension() {
        return switch (this) {
            case USER -> GROUP;
            case GROUP -> SCHOLL;
            case SCHOLL -> null;
        };
    }
}
