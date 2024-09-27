package com.cc.model.query.request;


import com.cc.model.collect.enums.DimensionEnum;
import com.cc.model.collect.enums.PeriodEnum;
import lombok.Builder;
import lombok.Data;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Builder
@Data
public class QueryRequest {

    /**
     * 业务id
     */
    private String businessId;
    private String requestGroupId;
    /**
     * 群组（这个是执行过程查询到的）
     */
//    private UserCenterGroupVo group;
    /**
     * 当前查询到的指标名称 指标英文名称。（这个是执行过程查询到的）
     */
    private Set<String> indexNames;
    /**
     * 中文名称（这个是执行过程查询到的）
     */
    private Set<String> zhNames;

    /**
     * 业务名称（这个是执行过程查询到的）
     */
    private String businessName;

//    private TableType tableType;

    private List<Long> schoolIds;

    private List<String> groupIds;

    private List<Long> userIds;

    private DimensionEnum dimension;

    private PeriodEnum periodType;

    /**
     * 每页数量
     */
    private Integer pageSize;
    /**
     * 分页开始偏移量
     */
    private Integer offset;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

}
