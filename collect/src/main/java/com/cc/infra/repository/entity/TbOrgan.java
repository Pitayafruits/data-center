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
@TableName("tb_organ")
public class TbOrgan implements Serializable {

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
     * 抽取组织方式？1：sql抽取 2：接口抽取
     */
    @TableField("collect_way")
    private Integer collectWay;

    /**
     * 根据抽取组织方式分别表示sql脚本或url
     */
    @TableField("content")
    private String content;

    /**
     * 抽取组织的数据源
     */
    @TableField("data_source")
    private String dataSource;

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
