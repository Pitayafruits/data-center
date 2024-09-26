package com.cc.model.collect.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 规则类型枚举.
 */
@Getter
@AllArgsConstructor
public enum RuleTypeEnum {
    /**
     * 规则类型，兼容采集规则、查询规则
     */
    COLLECT("COLLECT",1,"采集规则"),
    QUERY("QUERY",2,"查询规则");

    private static final Map<Integer, RuleTypeEnum> sourceMap = Arrays.asList(values()).stream().collect(Collectors.toMap(RuleTypeEnum::getSourceValue, v->v));

    private final String sourceType;
    private final Integer sourceValue;
    private final String desctiption;

    public static RuleTypeEnum parse(Integer sourceValue){
        return sourceMap.get(sourceValue);
    }
}
