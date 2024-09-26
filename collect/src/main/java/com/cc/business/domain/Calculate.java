package com.cc.business.domain;


import com.cc.model.collect.enums.FunctionEnum;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * 采集模型.
 */
@Data
public class Calculate implements Serializable {

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
     * 元数据
     */
    private Metadata metadata;

    /**
     * 指标计算时的参数，可以指定多个en_name，用英文逗号分隔
     */
    private List<String> parameters;

    /**
     * 指标计算函数，内置几个 1：sum 累加 2：deduction 相减 3.multiply 相乘 4：ratio 相除 5: avg 平均数
     */
    private FunctionEnum func;

    /**
     * 指标计算表达式
     */
    private String expression;


}
