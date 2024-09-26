package com.cc.model.collect.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 计算方法枚举.
 */
@Getter
@AllArgsConstructor
public enum FunctionEnum {
    /**
     * 指标计算函数，内置几个 1：sum 累加 2：deduction 相减 3.multiply 相乘 4：ratio 相除 5: avg 平均数
     */
    SUM("SUM","+",Integer.MAX_VALUE,"加"),
    DEDUCTION("DEDUCTION","-",Integer.MAX_VALUE,"减"),
    MULTIPLY("MULTIPLY","*",Integer.MAX_VALUE,"乘"),
    RATIO("RATIO","/",2,"除"),
    AVG("AVG","/count",Integer.MAX_VALUE,"平均"),
    ;

    private static final Map<String, FunctionEnum> sourceMap = Arrays
            .asList(values()).stream().collect(Collectors.toMap(FunctionEnum::getFunName, v->v));

    private final String funName;
    private final String symbol;
    private final int paramsCount;
    private final String description;


    public static FunctionEnum parse(String funName){
        return sourceMap.get(funName);
    }
}
