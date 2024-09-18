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
@TableName("tb_storage")
public class TbStorage implements Serializable {

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
     * 存储当前规则下的指标所用的数据源
     */
    @TableField("data_source")
    private String dataSource;

    /**
     * 自动生成表前缀，默认为t_generate_，生成表的规则：t_generate_{en_name}_{dimension}_{date}
     */
    @TableField("table_prefix")
    private String tablePrefix;

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
