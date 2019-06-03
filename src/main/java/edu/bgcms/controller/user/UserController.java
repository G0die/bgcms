package edu.bgcms.controller.user;

import edu.bgcms.dao.UserMapper;
import edu.bgcms.dto.AjaxMsg;
import edu.bgcms.model.user.User;
import edu.bgcms.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userServivce;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/list")
    public String toList(){
        return "/user/list";
    }


    @RequestMapping("/manager")
    public String manager(){
        return "/user/userManager";
    }


    @ResponseBody
    @RequestMapping("/getList")
    public List<User> getList(String keyWord){
        //调用service方法
        List<User> list= userServivce.getList(keyWord);
//        return GsonUtils.object2json(list);
        return list;
    }

    @ResponseBody
    @RequestMapping("/denyLogin")
    public AjaxMsg denyLogin(String userId) {
        AjaxMsg ajaxMsg = new AjaxMsg();
        try{
            User u = userMapper.selectByPrimaryKey(userId);
            if(u.getDeny()==1){
                u.setDeny(0);
            }else {
                u.setDeny(1);
            }
            userMapper.updateByPrimaryKey(u);

        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("操作失败");
            return ajaxMsg;
        }
        ajaxMsg.setStatus(1);
        ajaxMsg.setMsg("操作成功");
        return ajaxMsg;
    }

    @ResponseBody
    @RequestMapping("/initPwd")
    public AjaxMsg initPwd(String userId) {
        AjaxMsg ajaxMsg = new AjaxMsg();
        try{
            User u = userMapper.selectByPrimaryKey(userId);
            u.setPwd("000000");
            userMapper.updateByPrimaryKey(u);
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("重置密码失败");
            return ajaxMsg;
        }
        ajaxMsg.setStatus(1);
        ajaxMsg.setMsg("密码已重置为\"000000\"");
        return ajaxMsg;
    }
}
