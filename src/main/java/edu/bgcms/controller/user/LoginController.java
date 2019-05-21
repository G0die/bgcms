package edu.bgcms.controller.user;

import edu.bgcms.dao.UserMapper;
import edu.bgcms.model.user.User;
import edu.bgcms.utils.MyTools;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping({"/","/index","/index.php"})
    public String index(){
        return "index";
    }
    //正常访问login页面
    @RequestMapping("/login")
    public String login(){
        if(MyTools.getCurUser()!=null){
            return "redirect:/";
        }
        return "user/login";
    }
    //表单提交过来的路径

    @ResponseBody
    @RequestMapping("/checkLogin")
    public String checkLogin(HttpServletRequest request,HttpServletResponse response, User user, Model model){
        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(),user.getPwd());

        //3.执行登录方法
        try {
            subject.login(token);
            //把user存放到cookie
            user = MyTools.getCurUser();
            user.setPwd(null);
//            Cookie cookie = new Cookie("user", GsonUtils.object2json(user));
            Cookie cookie = new Cookie("username", user.getUsername());
            cookie.setMaxAge(-1);
            response.addCookie(cookie);
            cookie.setPath("/");
            //登录成功
            //跳转到test.html
            return "1";
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登录失败:用户名不存在
//            model.addAttribute("msg", "用户名不存在");
            return "0";
        }catch (IncorrectCredentialsException e) {
            //e.printStackTrace();
            //登录失败:密码错误
//            model.addAttribute("msg", "密码错误");
            return "-1";
        }

    }
}
