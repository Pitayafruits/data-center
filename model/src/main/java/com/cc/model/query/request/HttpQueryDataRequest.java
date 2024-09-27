package com.cc.model.query.request;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * xx
 */
@ToString
@NoArgsConstructor
@Data
public class HttpQueryDataRequest {

    /**
     * 业务id
     */
    private String businessId;
    private String requestGroupId;

    private Integer periodType;

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
    //@JsonFormat(pattern = "yyyyMMdd")
    private Date startTime;

    /**
     * 结束时间
     */
    //@JsonFormat(pattern = "yyyyMMdd")
    private Date endTime;
}
