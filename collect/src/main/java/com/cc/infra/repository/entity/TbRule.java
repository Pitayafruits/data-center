package com.cc.infra.repository.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
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
@TableName("tb_rule")
public class TbRule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
     * 业务id
     */
    @TableField("business_id")
    private String businessId;

    /**
     * 业务名称
     */
    @TableField("business_name")
    private String businessName;

    /**
     * 业务英文标识
     */
    @TableField("en_name")
    private String enName;

    /**
     * 当前规则名称
     */
    @TableField("rule_name")
    private String ruleName;

    /**
     * 规则类型，兼容采集规则、查询规则
     */
    @TableField("rule_type")
    private String ruleType;

    /**
     * 版本号，如果需要规则变更，直接创建一个新规则，版本号递增
     */
    @TableField("version")
    private String version;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    /**
     * 状态？0：删除 1：未删除
     */
    @TableField("status")
    private Integer status;


}
