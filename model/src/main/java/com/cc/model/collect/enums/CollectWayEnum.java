package com.cc.model.collect.enums;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum CollectWayEnum {

    SQL("SQL抽取", 1),
    INTERFACE("接口抽取", 2);

    private static final Map<Integer, CollectWayEnum> sourceMap = Arrays
            .stream(values()).collect(Collectors.toMap(CollectWayEnum::getSourceValue, v -> v));

    private final String sourceType;

    private final Integer sourceValue;

    private static CollectWayEnum parse(Integer sourceValue) {
        return sourceMap.get(sourceValue);
    }

}
