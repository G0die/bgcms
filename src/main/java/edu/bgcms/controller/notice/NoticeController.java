package edu.bgcms.controller.notice;

import edu.bgcms.dao.NoticeMapper;
import edu.bgcms.dto.AjaxMsg;
import edu.bgcms.model.notice.Notice;
import edu.bgcms.utils.MyTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeMapper noticeMapper;

    @RequestMapping("/index")
    public String index(Model model) {
        return "/notice/index";
    }

    @ResponseBody
    @RequestMapping("/getSeeList")
    public AjaxMsg getSeeList(Model model) {
        AjaxMsg ajaxMsg =  new AjaxMsg();
        List<Notice> list =  new ArrayList<>();
        try{
            list =  noticeMapper.selectSeeList(MyTools.getCurUser().getUuid());
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setMsg("获取公告列表失败");
            ajaxMsg.setStatus(0);
            return ajaxMsg;
        }
        ajaxMsg.setStatus(1);
        ajaxMsg.setData(list);
        return ajaxMsg;
    }

    @ResponseBody
    @RequestMapping("/save")
    public AjaxMsg save(Notice notice) {
        AjaxMsg ajaxMsg =  new AjaxMsg();
        notice.setUuid(MyTools.getUUID());
        notice.setCreator(MyTools.getCurUser().getUuid());
        notice.setCreatetime(new Date());
        try{
            int num = noticeMapper.insert(notice);
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setMsg("添加失败");
            ajaxMsg.setStatus(0);
            return ajaxMsg;
        }
        ajaxMsg.setStatus(1);
        ajaxMsg.setMsg("添加成功");
        return ajaxMsg;
    }
}
