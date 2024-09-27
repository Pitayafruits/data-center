package com.cc.model.collect.request;

import com.cc.model.collect.enums.PeriodEnum ;
import lombok.Data;

import java.util.Date;

/**
 * 请求周期.
 */
@Data
public class RequestPeriod {
    private PeriodEnum periodEnum;
    private Date collectDate;
    private Date startTime;
    private Date endTime;
}
