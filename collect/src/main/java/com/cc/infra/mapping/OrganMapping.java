package com.cc.infra.mapping;

import com.cc.infra.repository.entity.TbOrgan;
import com.cc.business.domain.Organ;
import com.cc.model.collect.enums.CollectWayEnum ;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * 组织映射.
 */
@Mapper(componentModel = "spring")
public interface OrganMapping {
    @Mapping(source = "collectWay", target = "collectWay", qualifiedByName = "toCollectWay")
    TbOrgan toEntity(Organ organ);

    @Mapping(source = "collectWay", target = "collectWay", qualifiedByName = "toCollectWayEnum")
    Organ toVo(TbOrgan organ);

    @Named("toCollectWay")
    default Integer toCollectWay(CollectWayEnum collectWayEnum){
        return collectWayEnum.getSourceValue();
    }

    @Named("toCollectWayEnum")
    default CollectWayEnum toCollectWay(Integer collectWay){
        return CollectWayEnum.parse(collectWay);
    }
}
