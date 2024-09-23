package com.cc.business.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.cc.model.collect.enums.CollectWayEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;


/**
 * 组织实体.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_organ")
public class Organ implements Serializable {

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
    private CollectWayEnum collectWay;

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



}
