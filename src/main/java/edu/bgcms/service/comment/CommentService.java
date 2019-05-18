package edu.bgcms.service.comment;

import edu.bgcms.dao.CommentMapper;
import edu.bgcms.dto.AjaxMsg;
import edu.bgcms.dto.CommentDto;
import edu.bgcms.model.comment.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class CommentService {
    @Autowired
    CommentMapper commentMapper;


    public void dataDeal(List<Comment> modes, List<CommentDto> dtos,int grade,String uuid) {
        //筛选0级
        Iterator<Comment> it = modes.iterator();
        while(it.hasNext()){
            Comment mode = it.next();
            if(mode.getGrade()==grade&&mode.getLastId().equals(uuid)){
                CommentDto dto = new CommentDto();
                model2Dto(mode,dto);
                it.remove();
                if(grade<3){
                    dataDeal(modes,dtos,grade+1,mode.getUuid());
                }
                dtos.add(dto);
            }
        }
    }
    public void model2Dto(Comment mode, CommentDto dto) {
        dto.setUuid(mode.getUuid());
        dto.setContent(mode.getUuid());
        dto.setImgId(mode.getImgId());
        dto.setFromUserId(mode.getFromUserId());
        dto.setToUserId(mode.getToUserId());
        dto.setObjId(mode.getObjId());
        dto.setGrade(mode.getGrade());
        dto.setCreateTime(mode.getCreateTime());
    }
}
