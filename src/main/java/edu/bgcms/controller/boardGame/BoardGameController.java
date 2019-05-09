package edu.bgcms.controller.boardGame;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import edu.bgcms.model.boardGame.BoardGame;
import edu.bgcms.service.boardGame.BoardGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/boardGame")
public class BoardGameController {

    @Autowired
    private BoardGameService boardGameService;

    @RequestMapping("/list")
    public String toList(){
        return "/boardgame/list";
    }

    @ResponseBody
    @RequestMapping(value = "/getList",produces = "application/json;charset=UTF-8")
    public String getList(String keyWord, Model model){
        //调用service方法
        List<BoardGame> list= boardGameService.getList();
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(list));
        int total = (int)(list.size()/10+1);
        String jsonData =  "{\"page\":\"1\"," +
                "      \"total\":"+total+"," +
                "      \"records\":\""+list.size()+"\"," +
                "      \"rows\":" + array;
        return jsonData;
    }
    @ResponseBody
    @RequestMapping(value = "/test")
    public List<BoardGame> test(){
        //调用service方法
        List<BoardGame> list= boardGameService.getList();
//        JSONArray array= JSONArray.parseArray(JSON.toJSONString(list));
//        int total = (int)(list.size()/10+1);
//        Map<String,Object> map = new HashMap<>();
//        map.put("page",1);
//        map.put("total",total);
//        map.put("record",list.size());
//        map.put("rows",list);
        return list;
    }
}
