package com.cc.infra.mapping;

import com.cc.business.domain.*;
import com.cc.infra.repository.entity.TbRule;
import com.cc.model.collect.enums.CollectWayEnum;
import com.cc.model.collect.enums.SourceTypeEnum;
import com.cc.model.collect.request.AddRuleRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;


/**
 * 规则映射.
 */
@Mapper(componentModel = "spring")
public interface RuleMapping {

    TbRule toEntity(Rule rule);

    @Mapping(source = "id", target = "ruleId")
    Rule toVo(TbRule rule);

    @Mapping(source = "id", target = "ruleId")
    List<Rule> toVos(List<TbRule> rules);

    @Mapping(source = "indexName", target = "enName")
    Rule convert(AddRuleRequest.RuleParam ruleParam);

    @Mapping(source = "indexName", target = "enName")
    @Mapping(source = "sourceType", target = "sourceType", qualifiedByName = "toSourceTypeEnum")
    Metadata convert(AddRuleRequest.RuleParam.MetadataParam metadataParam);

    @Mapping(source = "indexName", target = "enName")
    @Mapping(source = "collectWay", target = "collectWay", qualifiedByName = "toCollectWayEnum")
    Collect convert(AddRuleRequest.RuleParam.CollectParam collectParam);

    @Mapping(source = "indexName", target = "enName")
    Calculate convert(AddRuleRequest.RuleParam.CalculatesParam calculatesParam);

    @Mapping(source = "collectWay", target = "collectWay", qualifiedByName = "toCollectWayEnum")
    Organ convert(AddRuleRequest.RuleParam.OrganParam organParam);

    @Named("toSourceTypeEnum")
    default SourceTypeEnum toSourceTypeEnum(Integer sourceType){
        return SourceTypeEnum.parse(sourceType);
    }

    @Named("toCollectWayEnum")
    default CollectWayEnum toCollectWay(Integer collectWay){
        return CollectWayEnum.parse(collectWay);
    }
}
