package edu.bgcms.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMapperTest {

    @Autowired
    private TestMapper testMapper;

    @Rollback
    @Test
    public void say() {
        List<edu.bgcms.model.Test> testList = testMapper.selectSurplus();
        System.out.println(testList.get(0).getId()+"---");
        System.out.println(testList.get(0).getDate()+"---");
        System.out.println(testList.get(0).getDatetime()+"---");
    }
}