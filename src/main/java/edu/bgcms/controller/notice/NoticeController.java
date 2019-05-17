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

@Controller
@RequestMapping("/bill")
public class NoticeController {

    @Autowired
    private NoticeMapper noticeMapper;

    @RequestMapping("/index")
    public String index(Model model) {
        return "/notice/index";
    }

    @RequestMapping("/getSeeList")
    public AjaxMsg getSeeList(Model model) {
        AjaxMsg ajaxMsg =  new AjaxMsg();
        return ajaxMsg;
    }

    @ResponseBody
    @RequestMapping("/save")
    public AjaxMsg save(Notice notice) {
        AjaxMsg ajaxMsg =  new AjaxMsg();
        notice.setCreator(MyTools.getCurUser().getUuid());
        notice.setCreatetime(LocalDateTime.now());
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
