package com.cc.model.collect.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 周期枚举.
 */
@Getter
@AllArgsConstructor
public enum PeriodEnum {
    CUSTOM("CUSTOM",1, "自定义"),
    DAY("DAY",2, "日"),
    WEEK("WEEK",3, "周"),
    MONTH("MONTH",4, "月"),
    SEMESTER("SEMESTER",5, "学期"),
    SCHOOL_YEAR("SCHOOL_YEAR",6, "学年"),
    ;

    private static final Map<Integer, PeriodEnum> typeMap = Arrays.asList(values()).stream().collect(Collectors.toMap(PeriodEnum::getType, v->v));
    private static final Map<String, PeriodEnum> nameMap = Arrays.asList(values()).stream().collect(Collectors.toMap(PeriodEnum::getName, v->v));

    private final String name;
    private final int type;
    private final String description;

    public static PeriodEnum parse(Integer type){
        return typeMap.get(type);
    }
    public static PeriodEnum parse(String name){
        return nameMap.get(name);
    }

    /**
     * 获取当前时间维度的下一个时间维度
     * @return
     */
    public PeriodEnum nextPeriod(){
        switch (this){
            case DAY -> {
                return WEEK;
            }
            case WEEK -> {
                return MONTH;
            }
            case MONTH ->
            {
                return SEMESTER;
            }
            case SEMESTER -> {
                return SCHOOL_YEAR;
            }
            default -> {
                return null;
            }
        }
    }

}
