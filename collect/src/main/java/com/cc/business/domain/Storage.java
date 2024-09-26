package com.cc.business.domain;

import com.cc.business.constants.SymbolConstants;
import com.cc.model.collect.enums.DimensionEnum;
import com.cc.model.collect.enums.PeriodEnum;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.Data;


/**
 * 存储模型.
 */
@Data
public class Storage implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String DEFAULT_TABLE_PREFIX = "t_generate_";
    public static final String DEFAULT_DATASOURCE = "data-center";
    public static final String DEFAULT_DAY_SUFFIX = "day";
    public static final String DEFAULT_NOT_DAY_SUFFIX = "statistics";

    public static final List<String> DEFAULT_DATA_SUFFIX = Arrays.asList(DEFAULT_DAY_SUFFIX, DEFAULT_NOT_DAY_SUFFIX);

    private Long id;

    /**
     * 规则表主键id
     */
    private Long rule;

    /**
     * 存储当前规则下的指标所用的数据源，默认是data-center
     */
    private String dataSource;

    /**
     * 自动生成表前缀，默认为t_generate_，生成表的规则：t_generate_{en_name}_{dimension}_{date}
     */
    private String tablePrefix;

    /**
     * 获取表前缀
     *
     * @return
     */
    public String getTablePrefix() {
        return Optional.ofNullable(tablePrefix).orElse(DEFAULT_TABLE_PREFIX);
    }

    public static Storage defaultStorage() {
        Storage storage = new Storage();
        storage.setTablePrefix(DEFAULT_TABLE_PREFIX);
        storage.setDataSource(DEFAULT_DATASOURCE);
        return storage;
    }

    public String getTableName(String ruleEnName, DimensionEnum dimension, PeriodEnum periodEnum) {
        String tablePrefix = getTablePrefix();
        return doGetTableName(ruleEnName, dimension, periodEnum, tablePrefix);
    }
    public String getTableName(String ruleEnName, DimensionEnum dimension, String suffix) {
        String tablePrefix = getTablePrefix();
        StringBuilder sb = new StringBuilder();
        sb.append(tablePrefix).append(ruleEnName).append(SymbolConstants.UNERLINE)
                .append(dimension.getDimension().toLowerCase())
                .append(SymbolConstants.UNERLINE).append(suffix);

        return sb.toString();
    }

    public static String getDefaultTableName(String ruleEnName, DimensionEnum dimension, PeriodEnum periodEnum) {
        return doGetTableName(ruleEnName, dimension, periodEnum, DEFAULT_TABLE_PREFIX);
    }

    private static String doGetTableName(String ruleEnName, DimensionEnum dimension, PeriodEnum periodEnum, String tablePrefix) {
        //如果是 日或者是自定义，最后都以 day 后缀结尾
        String suffix = Objects.equals(periodEnum, PeriodEnum.DAY) || Objects.equals(periodEnum, PeriodEnum.CUSTOM) ? DEFAULT_DAY_SUFFIX : DEFAULT_NOT_DAY_SUFFIX;
        StringBuilder sb = new StringBuilder();
        sb.append(tablePrefix).append(ruleEnName).append(SymbolConstants.UNERLINE).append(dimension.getDimension().toLowerCase()).append(SymbolConstants.UNERLINE).append(suffix);
        return sb.toString();
    }
}
