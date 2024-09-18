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
 * 数据采集表
 * </p>
 *
 * @author cc
 * @since 2024-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_collect")
public class TbCollect implements Serializable {

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
     * 指标英文标识
     */
    @TableField("en_name")
    private String enName;

    /**
     * 采集的数据源
     */
    @TableField("data_source")
    private String dataSource;

    /**
     * 采集方式？1：SQL方式 2：接口方式
     */
    @TableField("collect_way")
    private Integer collectWay;

    /**
     * 采集内容？和采集方式有关，SQL脚本或URL
     */
    @TableField("content")
    private String content;

    /**
     * 是否去重？0：否 1：重
     */
    @TableField("deduplicate")
    private Boolean deduplicate;

    /**
     * 统计周期格式
     */
    @TableField("period_format")
    private String periodFormat;

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
