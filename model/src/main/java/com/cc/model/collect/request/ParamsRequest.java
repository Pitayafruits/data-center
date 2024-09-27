package com.cc.model.collect.request;

import cn.hutool.core.util.ObjectUtil;
import com.cc.model.collect.enums.DimensionEnum ;
import com.cc.model.collect.enums.RuleTypeEnum ;
import com.cc.model.exception.DataCenterException ;
import com.cc.model.query.request.QueryRequest ;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 请求参数.
 */
@Data
public class ParamsRequest {
    /**
     * 业务id
     */
    private String businessId;
    /**
     * 维度参数
     */
    private DimensionParameter dimensionParameter;
    /**
     * 周期类型
     */
    private String periodType;
    /**
     * 数据处理日期 2023-09-10 11:11:11 , 2023-09-10 00:00:00 2023-09-10 23:59:59
     */
    private Date requestDate;

    private Date startTime;
    private Date endTime;

    private RuleTypeEnum ruleTypeEnum;

    /**
     * 查询参数
     */
    private QueryRequest queryRequest;

    @Data

    public static class DimensionParameter {
        private String dimension;
        private Long schoolId;
        private String groupId;
        private List<Long> userIds;
    }

    public void validate() {
        Optional.ofNullable(this.getBusinessId()).orElseThrow(() -> new DataCenterException("businessId 不能为空"));
        DimensionParameter dimensionParam = Optional.ofNullable(this.getDimensionParameter()).orElseThrow(() -> new DataCenterException("dimensionParameter 不能为空"));
        DimensionEnum dimension = DimensionEnum.parse(dimensionParam.getDimension());

        List<Long> userIds = dimensionParam.getUserIds();
        String groupId = dimensionParam.getGroupId();
        Long schoolId = dimensionParam.getSchoolId();
        switch (dimension) {
            case USER -> {
                checkUser(userIds);
                checkGroupId(groupId);
                checkSchoolId(schoolId);
            }
            case GROUP -> {
                checkGroupId(groupId);
                checkSchoolId(schoolId);
            }
            case SCHOLL -> {
                checkSchoolId(schoolId);
            }
        }
        if (ObjectUtil.isEmpty(this.getPeriodType())) {
            throw new DataCenterException("periodType 不能为空");
        }
        if (Objects.isNull(this.getRequestDate())) {
            throw new DataCenterException("requestDate 不能为空");
        }
        if (Objects.isNull(this.getStartTime())) {
            throw new DataCenterException("startTime 不能为空");
        }
        if (Objects.isNull(this.getEndTime())) {
            throw new DataCenterException("endTime 不能为空");
        }
    }

    private void checkUser(List<Long> userIds) {
        if (ObjectUtil.isEmpty(userIds)) {
            throw new DataCenterException("userIds 不能为空");
        }
    }

    private void checkGroupId(String groupId) {
        if (ObjectUtil.isEmpty(groupId)) {
            throw new DataCenterException("groupId 不能为空");
        }
    }

    private void checkSchoolId(Long schoolId) {
        if (Objects.isNull(schoolId)) {
            throw new DataCenterException("schoolId 不能为空");
        }
    }
}
