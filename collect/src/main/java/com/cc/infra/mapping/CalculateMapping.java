package com.cc.infra.mapping;

import cn.hutool.core.util.ObjectUtil;
import com.cc.business.constants.SymbolConstants ;
import com.cc.infra.repository.entity.TbCalculate ;
import com.cc.business.domain.Calculate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.Arrays;
import java.util.List;


/**
 * 计算Mapping.
 */
@Mapper(componentModel = "spring")
public interface CalculateMapping {
    @Mapping(source = "parameters", target = "parameters", qualifiedByName = "toParmString")
    TbCalculate toEntity(Calculate calculate);

    @Mapping(source = "parameters", target = "parameters", qualifiedByName = "toParmList")
    Calculate toVo(TbCalculate calculate);

    @Named("toParmString")
    default String toParmString(List<String> params){
        if (ObjectUtil.isEmpty(params)) {
            return "";
        }
        return String.join(SymbolConstants.COMMA, params);
    }

    @Named("toParmList")
    default List<String> toParmList(String params){
        return Arrays.asList(params.split(SymbolConstants.COMMA));
    }
}
