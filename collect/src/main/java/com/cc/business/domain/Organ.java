package com.cc.business.domain;


import com.cc.model.collect.enums.CollectWayEnum ;
import lombok.Data;
import java.io.Serializable;


/**
 * 组织实体.
 */
@Data
public class Organ implements Serializable {

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
     * 抽取组织方式 1：sql抽取 2：接口抽取
     */
    private CollectWayEnum collectWay;

    /**
     * collec_way抽取组织方式 1：sql抽取  sql脚本 2：接口抽取 url http地址
     */
    private String content;

    /**
     * 抽取组织的数据源
     */
    private String dataSource;

}
