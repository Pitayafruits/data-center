package com.cc.model.collect.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 数据类型枚举.
 */
@Getter
@AllArgsConstructor
public enum DataTypeEnum {
    BYTE("BYTE","tinyint(4)",Byte.class,"0","字节类型")
    ,SHORT("SHORT","smallint(6)",Short.class,"0","短整类型")
    ,INTEGER("INTEGER","int(11)",Integer.class,"0","整型数字")
    ,LONG("LONG","bigint(20)",Long.class,"0","长整类型")
    ,FLOAT("FLOAT","float",Float.class,"0.0","浮点类型")
    ,DOUBLE("DOUBLE","double",Double.class,"0.0","双精度类型")
    ,BOOLEAN("BOOLEAN","bit(1)",Boolean.class,"0","布尔值")
    ,STRING("STRING","varchar(64)",String.class,"","字符串")
    ,TEXT("TEXT","text",String.class,"","字符串")
    ,DATE("DATETIME","datetime", Date.class,"CURRENT_TIMESTAMP","日期类型")
    ,TIMESTAMP("TIMESTAMP","timestamp", Timestamp.class,"CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP","时间戳");
    private static final Map<String, DataTypeEnum> javaMap = Arrays.asList(values()).stream().collect(Collectors.toMap(DataTypeEnum::getJavaStrType, v->v));
    private static final Map<String, DataTypeEnum> columnMap = Arrays.asList(values()).stream().collect(Collectors.toMap(DataTypeEnum::getColumnType, v->v));

    private final String javaStrType;
    private final String columnType;
    private final Class<?> javaType;
    private final String dbDefaultValue;
    private final String description;

    /**
     * 根据java类型过滤
     * @param javaStrType
     * @return
     */
    public static DataTypeEnum parse(String javaStrType){
        return javaMap.get(javaStrType);
    }

    /**
     * 根据数据库类型类型过滤
     * @param columnType
     * @return
     */
    public static DataTypeEnum parseColumn(String columnType){
        return columnMap.get(columnType);
    }
}
