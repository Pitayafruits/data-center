package com.cc.infra.mapping;

import com.cc.infra.repository.entity.TbStorage;
import com.cc.business.domain.Storage ;
import org.mapstruct.Mapper;

/**
 * 组织映射.
 */
@Mapper(componentModel = "spring")
public interface StorageMapping {
    TbStorage toEntity(Storage storage);

    Storage toVo(TbStorage storage);

}
