package com.cc.service;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.cc.Application;
import com.cc.infra.repository.entity.TbRule;
import com.cc.infra.repository.service.ITbRuleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class RuleServiceTest {

    @Autowired
    private ITbRuleService iTbRuleService;

    @Test
    public void testSave() {
        TbRule tbRule = new TbRule();
        tbRule.setRuleName("测试数据");
        tbRule.setRuleType("1");
        tbRule.setBusinessId("00000");
        tbRule.setBusinessName("测试业务");
        tbRule.setEnName("testData");
        tbRule.setVersion(String.valueOf(System.currentTimeMillis()));
        boolean save = iTbRuleService.save(tbRule);
        Assert.isTrue(save, "插入成功！");
    }

    @Test
    public void testList() {
        List<TbRule> tbRuleList = iTbRuleService.list();
        log.info("查询结果：{}", tbRuleList);
    }


}
