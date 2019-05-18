package edu.bgcms.controller.comment;

import edu.bgcms.dao.CommentMapper;
import edu.bgcms.dto.AjaxMsg;
import edu.bgcms.dto.CommentDto;
import edu.bgcms.model.comment.Comment;
import edu.bgcms.service.comment.CommentService;
import edu.bgcms.utils.MyTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    CommentService commentService;

    @ResponseBody
    @RequestMapping("/getCommentList")
    public AjaxMsg followOrCancel(String objId) {
        AjaxMsg ajaxMsg = new AjaxMsg();
        List<Comment> comments = new ArrayList<>();
        List<CommentDto> commentDtos = new ArrayList<>();
        try{
            Map param = new HashMap();
            param.put("obj",objId);
            param.put("user", MyTools.getCurUser().getUuid());
            comments =commentMapper.selectListByObjId(param);
            commentService.dataDeal(comments,commentDtos,0,objId);
        }catch (Exception e){
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("获取评论失败");
            return ajaxMsg;
        }
        ajaxMsg.setStatus(1);
        ajaxMsg.setData(commentDtos);
        return  ajaxMsg;
    }
}
