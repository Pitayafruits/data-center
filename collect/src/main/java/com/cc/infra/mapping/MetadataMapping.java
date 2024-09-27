package com.cc.infra.mapping;


import com.cc.business.domain.Metadata;
import com.cc.infra.repository.entity.TbMetadata ;
import com.cc.model.collect.enums.SourceTypeEnum ;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * 元数据映射.
 */
@Mapper(componentModel = "spring")
public interface MetadataMapping {

    @Mapping(source = "sourceType", target = "sourceType", qualifiedByName = "toSourceTypeStr")
    TbMetadata toEntity(Metadata metadata);

    @Mapping(source = "sourceType", target = "sourceType", qualifiedByName = "toSourceTypeEnum")
    Metadata toVo(TbMetadata metadata);

    @Named("toSourceTypeStr")
    default Integer toSourceTypeStr(SourceTypeEnum sourceTypeEnum){
        return sourceTypeEnum.getSourceValue();
    }

    @Named("toSourceTypeEnum")
    default SourceTypeEnum toSourceTypeEnum(Integer sourceType){
        return SourceTypeEnum.parse(sourceType);
    }
}
