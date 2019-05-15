package edu.bgcms.controller.boardGame;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import edu.bgcms.dao.BoardGameMapper;
import edu.bgcms.dao.UserFBgMapper;
import edu.bgcms.dto.AjaxMsg;
import edu.bgcms.model.boardGame.BoardGame;
import edu.bgcms.model.boardGame.UserFBg;
import edu.bgcms.service.boardGame.BoardGameService;
import edu.bgcms.utils.MyTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/boardGame")
public class BoardGameController {

    @Autowired
    private BoardGameService boardGameService;
    @Autowired
    private BoardGameMapper boardGameMapper;
    @Autowired
    private UserFBgMapper userFBgMapper;

    @RequestMapping("/list")
    public String toList() {
        return "/boardgame/list";
    }

    @RequestMapping("/details")
    public String toDeetails(Model model, String uuid) {
        BoardGame bg = boardGameMapper.selectByPrimaryKey(uuid);
        List<String> follwPerson = userFBgMapper.selectFollowNum(uuid);
        boolean followFlag = false;
        if (follwPerson.size() > 0) {
            followFlag = MyTools.isFollow(follwPerson);
        }
        model.addAttribute("bg", bg);
        model.addAttribute("followNum", follwPerson.size());
        model.addAttribute("followFlag", followFlag);
        return "/boardgame/details";
    }

    @ResponseBody
    @RequestMapping("/followOrCancel")
    public AjaxMsg followOrCancel(Boolean followFlag, String uuid) {
        Map<String, Object> param = new HashMap<>();
        param.put("bg", uuid);
        param.put("user", MyTools.getCurUser().getUuid());
        UserFBg userFBg = new UserFBg();
        userFBg.setBgUuid(uuid);
        userFBg.setUserUuid(MyTools.getCurUser().getUuid());
        AjaxMsg msg = new AjaxMsg();
        try {
            if (followFlag) {
                userFBgMapper.deleteFollow(param);
                msg.setMsg("取消关注成功");
            }else {
                userFBgMapper.insert(userFBg);
                msg.setMsg("关注成功");
            }
        }catch (Exception e){
            msg.setStatus(0);
            msg.setMsg("系统异常,关注操作失败");
            e.printStackTrace();
            return msg;
        }
        msg.setStatus(1);
        return msg;

    }

    @ResponseBody
    @RequestMapping(value = "/getList", produces = "application/json;charset=UTF-8")
    public String getList(String keyWord, Model model) {
        //调用service方法
        List<BoardGame> list = boardGameService.getList();
        JSONArray array = JSONArray.parseArray(JSON.toJSONString(list));
        int total = (int) (list.size() / 10 + 1);
        String jsonData = "{\"page\":\"1\"," +
                "      \"total\":" + total + "," +
                "      \"records\":\"" + list.size() + "\"," +
                "      \"rows\":" + array;
        return jsonData;
    }

    @ResponseBody
    @RequestMapping(value = "/test")
    public List<BoardGame> test() {
        //调用service方法
        List<BoardGame> list = boardGameService.getList();
        return list;
    }


}
