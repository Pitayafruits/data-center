package com.cc.infra.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author cc
 * @since 2024-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_calculate")
public class TbCalculate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 规则表主键id
     */
    @TableField("rule_id")
    private Long ruleId;

    /**
     * 指标英文标识
     */
    @TableField("en_name")
    private String enName;

    /**
     * 指标计算时的参数，可以指定多个en_name，用英文,分割
     */
    @TableField("parameters")
    private String parameters;

    /**
     * 指标计算函数，内置：1：sum：累加 2：deduction：相减 3：multply：相乘 4：ratio 相除 5：avg 平均数
     */
    @TableField("func")
    private String func;

    /**
     * 指标计算表达式
     */
    @TableField("expression")
    private String expression;

    /**
     * 创建时间
     */
    @TableField("gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    @TableField("gmt_modified")
    private LocalDateTime gmtModified;

    /**
     * 状态？0：删除 1：未删除
     */
    @TableField("status")
    private Integer status;


}
