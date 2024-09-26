package com.cc.business.domain;

import com.cc.model.collect.enums.DataTypeEnum ;
import com.cc.model.collect.enums.SourceTypeEnum ;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 元数据模型.
 */
@Slf4j
@Data
public class Metadata implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id.
     */
    private Long id;

    /**
     * 规则表主键id
     */
    private Long ruleId;

    /**
     * 指标英文标识
     */
    private String enName;

    /**
     * 指标中文标识
     */
    private String cnName;

    /**
     * 指标默认是否展示
     */
    private Boolean defaultShow;

    /**
     * 是否存储当前指标
     */
    private Boolean storage;

    /**
     * 当前指标是否和维度有关
     */
    private Boolean dimension;

    /**
     * 当前指标是否和统计周期有关
     */
    private Boolean period;

    /**
     * 指标数据类型
     */
    private DataTypeEnum dataType;

    /**
     * 指标类型：1抽取类型 2计算类型
     */
    private SourceTypeEnum sourceType;

    /**
     * 生命周期规则id
     */
    private Integer lifeCycleRuleId;

    /**
     * 跟踪的UUID
     */
    private String traceId;

    /**
     * 数据安全信息字段id
     */
    private Integer dataSecurity;

    /**
     * 前端展示宽度
     */
    private Integer extraWidth;

    /**
     * 指标描述
     */
    private String description;

    /**
     * 指标排序
     */
    private Integer rank;

    /**
     * 基准值，用来做展示数据
     */
    private Integer baseValue;


    public Object getDefaultValue() {
        Object result = null;
        try {
            if (Objects.isNull(dataType)) {
                return result;
            }
            if (Objects.equals(dataType, DataTypeEnum.DATE) || Objects.equals(dataType, DataTypeEnum.TIMESTAMP)) {
                return new Date();
            }
            Class<?> javaType = dataType.getJavaType();
            result = javaType.getDeclaredConstructor(String.class).newInstance(dataType.getDbDefaultValue());
        } catch (Exception e) {
            log.error("getDefaultValue err, e=", e);
        }
        return result;
    }

    public boolean periodAndDimension() {
        return isPeriod() && isDimension();
    }

    public boolean periodAndNotDimension() {
        return isPeriod() && !isDimension();
    }

    public boolean notPeriodAndDimension() {
        return !isPeriod() && isDimension();
    }

    public boolean notPeriodAndNotDimension() {
        return !isPeriod() && !isDimension();
    }

    public boolean isPeriod() {
        return Objects.isNull(period) ? false : period;
    }

    public boolean isDimension() {
        return Objects.isNull(dimension) ? false : dimension;
    }
}
