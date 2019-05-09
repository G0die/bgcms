package edu.bgcms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class HelloFtl {
    @RequestMapping("/hello")
    public String hello(Map<String,Object> map){
        map.put("name", "[Angel -- 守护天使]");
        return "freemarker";
    }
}
