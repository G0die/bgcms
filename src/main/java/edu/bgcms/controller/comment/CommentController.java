package edu.bgcms.controller.comment;

import edu.bgcms.dao.CommentMapper;
import edu.bgcms.dto.AjaxMsg;
import edu.bgcms.dto.CommentDto;
import edu.bgcms.model.comment.Comment;
import edu.bgcms.model.comment.CommentLike;
import edu.bgcms.service.comment.CommentService;
import edu.bgcms.utils.MyTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    CommentService commentService;

    @ResponseBody
    @RequestMapping("/getCommentList")
    public AjaxMsg getCommentList(String objId) {
        AjaxMsg ajaxMsg = new AjaxMsg();
        List<CommentLike> comments = new ArrayList<>();
        List<CommentDto> commentDtos = new ArrayList<>();
        try{
            Map param = new HashMap();
            param.put("obj",objId);
            param.put("user", MyTools.getCurUser().getUuid());
            comments =commentMapper.selectListByObjId(param);
            commentService.dataDeal(comments,commentDtos,0,objId);
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("获取评论失败");
            return ajaxMsg;
        }
        ajaxMsg.setStatus(1);
        ajaxMsg.setData(commentDtos);
        return  ajaxMsg;
    }

    @ResponseBody
    @RequestMapping("/sendComment")
    public AjaxMsg sendComment(Comment comment) {
        AjaxMsg ajaxMsg = new AjaxMsg();
       comment.setUuid(MyTools.getUUID());
       comment.setFromUserId(MyTools.getCurUser().getUuid());
       comment.setGrade(0);
       comment.setLastId(comment.getObjId());
       comment.setToUserId("0");
       comment.setCreateTime(new Date());
        try{
            commentMapper.insert(comment);
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("发表评论失败");
            return ajaxMsg;
        }
        ajaxMsg.setStatus(1);
        ajaxMsg.setMsg("发表评论成功");
        return  ajaxMsg;
    }
    @ResponseBody
    @RequestMapping("/reply")
    public AjaxMsg reply(Comment comment) {
        AjaxMsg ajaxMsg = new AjaxMsg();
        comment.setUuid(MyTools.getUUID());
        comment.setFromUserId(MyTools.getCurUser().getUuid());
        comment.setToUserId("0");
        comment.setCreateTime(new Date());
        try{
            commentMapper.insert(comment);
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("回复评论失败");
            return ajaxMsg;
        }
        ajaxMsg.setStatus(1);
        ajaxMsg.setMsg("回复评论成功");
        return  ajaxMsg;
    }


}
