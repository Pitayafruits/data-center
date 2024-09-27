package com.cc.model.collect.request;

import com.cc.model.collect.enums.*;
import com.cc.model.exception.DataCenterException ;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class AddRuleRequest {

    /**
     * 规则
     */
    private RuleParam rule;

    @NoArgsConstructor
    @Data
    public static class RuleParam {
        private String businessId;
        private String businessName;
        private String indexName;
        private String ruleName;
        private Integer ruleType;
        private List<OrganParam> organs;
        private List<MetadataParam> metadatas;
        private List<CollectParam> collects;
        private List<CalculatesParam> calculates;
        private StoragesParam storage;

        @NoArgsConstructor
        @Data
        public static class OrganParam {
            /**
             * 类型
             */
            private Integer collectWay;
            /**
             * 脚本
             */
            private String content;
            /**
             * 抽取数据的数据源
             */
            private String dataSource;

            public void validate() {
                CollectWayEnum collectWayEnum = CollectWayEnum.parse(this.getCollectWay());
                if (Objects.isNull(collectWayEnum)) {
                    throw new DataCenterException("collectWay 参数must in [ 1: sql抽取，2: 接口抽取]");
                }
                String content = this.getContent();
                if (Objects.isNull(content) || content.trim().length() <= 0) {
                    throw new DataCenterException("content 参数不能为空");
                }
                String dataSource = this.getDataSource();
                if (Objects.isNull(dataSource) || dataSource.trim().length() <= 0) {
                    throw new DataCenterException("dataSource 参数不能为空");
                }
            }
        }

        @NoArgsConstructor
        @Data
        public static class MetadataParam {
            private String indexName;
            private String cnName;
            private String description;
            private Integer rank;
            private Boolean defaultShow;
            private Boolean storage;
            /**
             * 当前指标是否和维度有关
             */
            private Boolean dimension;

            /**
             * 当前指标是否和统计周期有关
             */
            private Boolean period;
            /**
             * 指标数据类型
             */
            private String dataType;
            /**
             * 指标类型：1.抽取类型，2.计算类型
             */
            private Integer sourceType;

            /**
             * 前端展示-宽度
             */
            private Integer extraWidth;

            /**
             * 基准值，用来做展示数据
             */
            private Integer baseValue;

            public void validate() {
                String indexName = this.getIndexName();
                if (Objects.isNull(indexName) || indexName.trim().length() <= 0) {
                    throw new DataCenterException("indexName 参数不能为空");
                }
                String name = this.getCnName();
                if (Objects.isNull(name) || name.trim().length() <= 0) {
                    throw new DataCenterException("cnName 参数不能为空");
                }
                String description = this.getDescription();
                if (Objects.isNull(description) || description.trim().length() <= 0) {
                    throw new DataCenterException("description 参数不能为空");
                }
                Integer rank = this.getRank();
                if (Objects.isNull(rank) || rank < 1) {
                    throw new DataCenterException("rank 参数不能为空或者小于1");
                }
                Boolean defaultShow = this.getDefaultShow();
                if (Objects.isNull(defaultShow)) {
                    throw new DataCenterException("defaultShow 参数不能为空");
                }
                Boolean storage = this.getStorage();
                if (Objects.isNull(storage)) {
                    throw new DataCenterException("storage 参数不能为空");
                }
                Boolean dimension = this.getDimension();
                if (Objects.isNull(dimension)) {
                    throw new DataCenterException("dimension 参数不能为空");
                }
                Boolean period = this.getPeriod();
                if (Objects.isNull(period)) {
                    throw new DataCenterException("period 参数不能为空");
                }
                DataTypeEnum dataTypeEnum = DataTypeEnum.parse(this.getDataType());
                if (Objects.isNull(dataTypeEnum)) {
                    throw new DataCenterException("metadata.dataType 参数 must in [BYTE,SHORT,INTEGER,LONG,FLOAT,DOUBLE,BOOLEAN,STRING,DATETIME,TIMESTAMP]");
                }
                SourceTypeEnum sourceTypeEnum = SourceTypeEnum.parse(this.getSourceType());
                if (Objects.isNull(sourceTypeEnum)) {
                    throw new DataCenterException("sourceType must in [1:抽取类型，2:计算类型] ");
                }

            }
        }

        @NoArgsConstructor
        @Data
        public static class CollectParam {

            /**
             * 指标名称
             */
            private String indexName;

            /**
             * 抽取数据的数据源
             */
            private String dataSource;

            /**
             * 抽取数据方式 1.sql抽取，2.接口抽取
             */
            private Integer collectWay;

            /**
             * 如果抽取方式为1，即sql脚本内容，如果抽取方式为2，即http地址
             */
            private String content;
            /**
             * 是否去重
             */
            private Boolean deduplicate;


            /**
             * 统计周期格式
             */
            private String periodFormat;

            public void validate() {
                String indexName = this.getIndexName();
                if (Objects.isNull(indexName) || indexName.trim().length() <= 0) {
                    throw new DataCenterException("collect.indexName 参数不能为空");
                }
                String dataSource = this.getDataSource();
                if (Objects.isNull(dataSource) || dataSource.trim().length() <= 0) {
                    throw new DataCenterException("collect.dataSource 参数为空或者不合法");
                }
                CollectWayEnum collectWay = CollectWayEnum.parse(this.getCollectWay());
                if (Objects.isNull(collectWay)) {
                    throw new DataCenterException("collect.collectWay 参数 must in [1.sql抽取，2.接口抽取]");
                }
                String periodFormat = this.getPeriodFormat();
                if (Objects.nonNull(periodFormat)){
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat(periodFormat);
                        sdf.format(new Date());
                    } catch (Exception e){
                        throw new DataCenterException("collect.periodFormat 不合法");
                    }
                }
            }
        }

        /**
         * 报表规则计算配置参数
         *
         * @author cenhy
         * @version 1.0.0
         * @since 2022/6/8 15:53
         */
        @NoArgsConstructor
        @Data
        public static class CalculatesParam {

            /**
             * 指标名称
             */
            private String indexName;

            /**
             * 计算参数
             */
            private List<String> parameters;


            /**
             * 计算表达式，加减乘除自定义运算
             */
            private String expression;

            /**
             * 函数
             */
            private String func;

            public void validate() {
                String indexName = this.getIndexName();
                if (Objects.isNull(indexName) || indexName.trim().length() <= 0) {
                    throw new DataCenterException("calculates.indexName 参数不能为空");
                }
                String expression = this.getExpression();
                if (Objects.isNull(expression) || expression.trim().length() <= 0) {
                    String func = this.getFunc();
                    if (Objects.isNull(func) || func.trim().length() <= 0) {
                        throw new DataCenterException("calculates.func 参数为空");
                    }
                    FunctionEnum function = FunctionEnum.parse(func);
                    if (Objects.isNull(function)) {
                        throw new DataCenterException("calculates.func must in [SUM,DEDUCTION,multiply,RATIO,AVG]");
                    }
                    List<String> parameters = this.getParameters();
                    if (Objects.isNull(parameters) || parameters.size() <= 0) {
                        throw new DataCenterException("calculates.parameters 参数不能为空，且个数不能小于等于0");
                    }
                    if (function.equals(FunctionEnum.RATIO)) {
                        if (parameters.size() != FunctionEnum.RATIO.getParamsCount()) {
                            throw new DataCenterException("calculates.func为RATIO时, calculates.parameters个数必须为2个");
                        }
                    }
                }

            }
        }

        @NoArgsConstructor
        @Data
        public static class StoragesParam {

            private String dataSource;

            /**
             * 表前缀
             */
            private String tablePrefix;

            public void validate() {
                String dataSource = this.getDataSource();
                if (Objects.isNull(dataSource) || dataSource.trim().length() <= 0) {
                    throw new DataCenterException("storage.dataSource 参数不能为空");
                }
                String tablePrefix = this.getTablePrefix();
                if (Objects.isNull(tablePrefix) || tablePrefix.trim().length() <= 0) {
                    throw new DataCenterException("torage.tablePrefix 参数不能为空");
                }
            }
        }

        public void validate() {
            String businessId = this.getBusinessId();
            if (Objects.isNull(businessId)) {
                throw new DataCenterException("businessId 参数不能为空");
            }
            String businessName = this.getBusinessName();
            if (Objects.isNull(businessName) || businessName.trim().length() <= 0) {
                throw new DataCenterException("businessName 参数不能为空");
            }
            String indexName = this.getIndexName();
            if (Objects.isNull(indexName) || indexName.trim().length() <= 0) {
                throw new DataCenterException("indexName 参数不能为空");
            }
            String ruleName = this.getRuleName();
            if (Objects.isNull(ruleName) || ruleName.trim().length() == 0) {
                throw new DataCenterException("ruleName 参数不能为空");
            }
            RuleTypeEnum ruleTypeEnum = RuleTypeEnum.parse(this.getRuleType());
            if (Objects.isNull(ruleTypeEnum)) {
                throw new DataCenterException("ruleType must in [1:采集规则 2:查询规则]");
            }
            List<MetadataParam> metadatas = this.getMetadatas();
            if (Objects.isNull(metadatas) || metadatas.size() == 0) {
                throw new DataCenterException("metadatas 参数不能为空，且个数不能等于0");
            } else {
                metadatas.forEach(MetadataParam::validate);
            }
            List<OrganParam> conditions = this.getOrgans();
            if (Objects.nonNull(conditions) && conditions.size() > 0) {
                conditions.forEach(OrganParam::validate);
            }
            Map<String, MetadataParam> metaMap = metadatas.stream().collect(Collectors.toMap(MetadataParam::getIndexName, value -> value));
            List<CollectParam> collects = this.getCollects();
            if (Objects.isNull(collects) || collects.size() == 0) {
                throw new DataCenterException("collects 参数不能为空，且个数不能等于0");
            } else {
                collects.forEach(param -> {
                    param.validate();
                    MetadataParam metadataParameter = metaMap.get(param.getIndexName());
                    if (Objects.isNull(metadataParameter)) {
                        throw new DataCenterException("collects.indexName 在metadata中不存在");
                    }
                });
            }
            List<CalculatesParam> calculates = this.getCalculates();
            if (Objects.isNull(calculates) || calculates.size() == 0){
                calculates.forEach(CalculatesParam::validate);
            }
            StoragesParam storage = this.getStorage();
            if (Objects.nonNull(storage)) {
                storage.validate();
            }
        }
    }



}
