package com.cc.infra.mapping;

import com.cc.infra.repository.entity.TbCollect ;
import com.cc.business.domain.Collect ;
import com.cc.model.collect.enums.CollectWayEnum ;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * 收集mapping.
 */
@Mapper(componentModel = "spring")
public interface CollectMapping {
    @Mapping(source = "collectWay", target = "collectWay", qualifiedByName = "toCollectWay")
    TbCollect toEntity(Collect collect);

    @Mapping(source = "collectWay", target = "collectWay", qualifiedByName = "toCollectWayEnum")
    Collect toVo(TbCollect collect);

    @Named("toCollectWay")
    default Integer toCollectWay(CollectWayEnum collectWayEnum){
        return collectWayEnum.getSourceValue();
    }

    @Named("toCollectWayEnum")
    default CollectWayEnum toCollectWay(Integer collectWay){
        return CollectWayEnum.parse(collectWay);
    }
}
