package com.cc.business.domain;


import com.cc.model.collect.enums.CollectWayEnum ;
import lombok.Data;
import java.io.Serializable;

/**
 * 收集模型.
 */
@Data
public class Collect implements Serializable {

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
     * 采集的数据源
     */
    private String dataSource;

    /**
     * 采集方式 1：sql方式采集 2：接口方式采集
     */
    private CollectWayEnum collectWay;

    /**
     *  取决于collect_way配置，1：sql方式采集, 表示sql脚本 2：接口方式采集，url
     */
    private String content;

    /**
     * 是否去重
     */
    private Boolean deduplicate;

    /**
     * 统计周期格式
     */
    private String periodFormat;

}
