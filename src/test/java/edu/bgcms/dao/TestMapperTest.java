package edu.bgcms.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMapperTest {

    @Autowired
    private TestMapper testMapper;

    @Rollback
    @Test
    public void say() {
        edu.bgcms.model.Test testList = testMapper.selectByPrimaryKey(1);
        System.out.println(testList.getId()+"---");
        System.out.println(testList.getDate()+"---");
        System.out.println(testList.getDatetime()+"---");
    }
}