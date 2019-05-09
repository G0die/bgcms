package edu.bgcms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
    //正常访问login页面
    @RequestMapping("/aaa")
    public String aaa(){
        return "aaa";
    }
    @RequestMapping("/bbb")
    public String bbb(){
        return "user/bbb";
    }
    @RequestMapping("/ccc")
    public String ccc(){
        return "bbb";
    }
}
