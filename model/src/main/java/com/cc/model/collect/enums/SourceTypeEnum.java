package com.cc.model.collect.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum SourceTypeEnum {

    COLLECT("抽取类型", 1),
    CALCULATE("计算类型", 2);

    private static final Map<Integer, SourceTypeEnum> sourceMap = Arrays
            .stream(values()).collect(Collectors.toMap(SourceTypeEnum::getSourceValue, v -> v));

    private final String sourceType;

    private final Integer sourceValue;

    private static SourceTypeEnum parse(Integer sourceValue) {
        return sourceMap.get(sourceValue);
    }

}
