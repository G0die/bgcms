package edu.bgcms.controller.user;

import edu.bgcms.model.user.User;
import edu.bgcms.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userServivce;

    @RequestMapping("/list")
    public String toList(){
        return "/user/list";
    }

    @ResponseBody
    @RequestMapping("/getList")
    public List<User> getList(String keyWord, Model model){
        //调用service方法
        List<User> list= userServivce.getList(keyWord);
//        return GsonUtils.object2json(list);
        return list;
    }

}
