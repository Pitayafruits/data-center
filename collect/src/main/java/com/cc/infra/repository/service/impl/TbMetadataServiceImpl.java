package com.cc.infra.repository.service.impl;

import com.cc.infra.repository.entity.TbMetadata ;
import com.cc.infra.repository.mapper.TbMetadataMapper ;
import com.cc.infra.repository.service.ITbMetadataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 元数据表 服务实现类
 * </p>
 *
 * @author cc
 * @since 2024-09-09
 */
@Service
public class TbMetadataServiceImpl extends ServiceImpl<TbMetadataMapper, TbMetadata> implements ITbMetadataService {

}
