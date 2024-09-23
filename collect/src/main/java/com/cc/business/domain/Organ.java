package com.cc.business.domain;

import com.cc.model.collect.enums.CollectWayEnum;
import lombok.Data;
import java.io.Serializable;


/**
 * 组织模型.
 */
@Data
public class Organ implements Serializable {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 规则表主键id
     */
    private Long ruleId;

    /**
     * 抽取组织方式？1：sql抽取 2：接口抽取
     */
    private CollectWayEnum collectWay;

    /**
     * 根据抽取组织方式分别表示sql脚本或url
     */
    private String content;

    /**
     * 抽取组织的数据源
     */
    private String dataSource;

}
