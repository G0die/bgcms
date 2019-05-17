package edu.bgcms.controller;

import edu.bgcms.dao.TestMapper;
import edu.bgcms.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloFtl {
    @Autowired
    private TestMapper testMapper;
    @ResponseBody
    @RequestMapping("/test")
    public Test hello(Map<String,Object> map){
        return testMapper.selectByPrimaryKey(1);
    }
}
