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
 * 元数据表
 * </p>
 *
 * @author cc
 * @since 2024-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_metadata")
public class TbMetadata implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 规则id
     */
    @TableField("rule_id")
    private Long ruleId;

    /**
     * 指标英文名称
     */
    @TableField("en_name")
    private String enName;

    /**
     * 指标中文名称
     */
    @TableField("cn_name")
    private String cnName;

    /**
     * 默认展示？0：否 1：是
     */
    @TableField("default_show")
    private Boolean defaultShow;

    /**
     * 是否存储当前指标？0：否 1：是
     */
    @TableField("storage")
    private Boolean storage;

    /**
     * 当前指标是否和维度有关？0：否 1：是
     */
    @TableField("dimension")
    private Boolean dimension;

    /**
     * 当前指标是否和统计周期有关？0：否  1：是
     */
    @TableField("period")
    private Boolean period;

    /**
     * 指标数据类型
     */
    @TableField("data_type")
    private String dataType;

    /**
     * 指标类型？1：抽取类型 2：计算类型
     */
    @TableField("source_type")
    private Integer sourceType;

    /**
     * 生命周期规则id
     */
    @TableField("life_cycle_rule_id")
    private Integer lifeCycleRuleId;

    /**
     * 跟踪的UUID
     */
    @TableField("trace_id")
    private String traceId;

    /**
     * 数据安全信息字段id
     */
    @TableField("data_security")
    private Integer dataSecurity;

    /**
     * 前端展示宽度
     */
    @TableField("extra_width")
    private Integer extraWidth;

    /**
     * 指标描述
     */
    @TableField("description")
    private String description;

    /**
     * 指标排序
     */
    @TableField("rank")
    private Integer rank;

    /**
     * 基准值，用来做展示数据
     */
    @TableField("base_value")
    private Integer baseValue;

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
     * 状态？0：删除 1：删除
     */
    @TableField("status")
    private Integer status;


}
