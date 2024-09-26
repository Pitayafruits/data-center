package com.cc.business.domain;

import lombok.Data;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 规则模型.
 */
@Data
public class Rule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * metadata
     */
    private List<Metadata> metadatas;

    private List<Calculate> calculates;

    private List<Collect> collects;

    private List<Organ> organs;

    private Storage storage;

    private Long id;

    private Long ruleId;

    /**
     * 业务id，兼容不同系统生成id的规则可能是不一样的
     */
    private String businessId;

    /**
     * 业务名称
     */
    private String businessName;

    /**
     * 业务英文标识
     */
    private String enName;

    /**
     * 当前规则名称
     */
    private String ruleName;

    /**
     * 规则类型，兼容采集规则、查询规则
     */
    private String ruleType;

    /**
     * 版本好，如果需要规则变更，直接创建一个新规则，将版本号递增
     */
    private String version;

    public List<Collect> getPredicateCollect(Predicate<Metadata> predicate) {
        List<Collect> allCollects = getCollects();
        //所有当前规则模型下的元数据指标
        List<Metadata> allMetaDatas = getMetadatas();
        Set<String> predicateIndexNames = allMetaDatas.stream().filter(predicate).map(Metadata::getEnName).collect(Collectors.toSet());
        return allCollects.stream().filter(collect -> predicateIndexNames.contains(collect.getEnName())).collect(Collectors.toList());
    }
}
