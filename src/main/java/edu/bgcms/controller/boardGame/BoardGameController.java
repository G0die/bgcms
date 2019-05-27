package edu.bgcms.controller.boardGame;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import edu.bgcms.dao.BoardGameMapper;
import edu.bgcms.dao.OrderMapper;
import edu.bgcms.dao.UserFBgMapper;
import edu.bgcms.dto.AjaxMsg;
import edu.bgcms.model.boardGame.BoardGame;
import edu.bgcms.model.boardGame.UserFBg;
import edu.bgcms.model.order.Order;
import edu.bgcms.service.boardGame.BoardGameService;
import edu.bgcms.utils.MyTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("/list")
    public String toList() {
        return "/boardgame/list";
    }

    @RequestMapping("/details")
    public String toDeetails(Model model, String uuid, HttpServletRequest request) {
        BoardGame bg = boardGameMapper.selectByPrimaryKey(uuid);
        Object bgViews = request.getSession().getAttribute(uuid);
        //添加浏览次数
        if(bgViews == null){
            request.getSession().setAttribute(uuid,1);
            boardGameService.addViews(bg);
        }
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
    public String getList() {
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

    @ResponseBody
    @RequestMapping(value = "/getNameList")
    public List<BoardGame> getNameList() {
        //调用service方法
        List<BoardGame> list = boardGameMapper.selectNameAll();
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/addBg")
    public AjaxMsg addBg(BoardGame bg) {
        AjaxMsg ajaxMsg = new AjaxMsg();
        bg.setUuid(MyTools.getUUID());
        bg.setApplicant(MyTools.getCurUser().getUuid());
        bg.setStatus("仅保存");
        bg.setCurrentuser(MyTools.getCurUser().getUuid());
        bg.setViews(0);
        bg.setLends(0);
        bg.setStars(0);
        bg.setRating(0);
        bg.setApplicantiontime(new Date());
        try{
           boardGameMapper.insert(bg);
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("保存失败");
            return ajaxMsg;
        }
        Order order = new Order();
        order.setStatus("wait");
        order.setBody("桌游众筹发起费用");
        order.setCreateTime(new Date());
        order.setObjId(bg.getUuid());
        order.setOutTradeNo(MyTools.getUUID());
        order.setTotalAmount(bg.getMoney()/2);
        order.setSubject(bg.getName());
        order.setUserId(MyTools.getCurUser().getUuid());
        orderMapper.insert(order);

        ajaxMsg.setStatus(1);
        ajaxMsg.setMsg("保存成功");
        ajaxMsg.setData(order.getOutTradeNo());
        return ajaxMsg;
    }


}
