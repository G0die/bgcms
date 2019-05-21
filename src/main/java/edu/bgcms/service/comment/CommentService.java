package edu.bgcms.service.comment;

import edu.bgcms.dao.CommentMapper;
import edu.bgcms.dto.CommentDto;
import edu.bgcms.model.comment.CommentLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class CommentService {
    @Autowired
    CommentMapper commentMapper;


    public void dataDeal(List<CommentLike> modes, List<CommentDto> dtos, int grade, String uuid) {
        //筛选0级
        Iterator<CommentLike> it = modes.iterator();
        while(it.hasNext()){
            CommentLike mode = it.next();
            System.out.println(mode.getGrade()+"---"+mode.getContent());
            if(mode.getGrade()==grade&&mode.getLastId().equals(uuid)){
                CommentDto dto = new CommentDto();
                model2Dto(mode,dto);
//                it.remove();
                if(grade<3){
                    List<CommentDto> nextData = new ArrayList<>();
                    dataDeal(modes,nextData,grade+1,mode.getUuid());
                    dto.setNextData(nextData);
                }
                dtos.add(dto);
            }
        }
    }

    public void model2Dto(CommentLike mode, CommentDto dto) {
        dto.setUuid(mode.getUuid());
        dto.setContent(mode.getContent());
        dto.setImgId(mode.getImgId());
        dto.setFromUserId(mode.getFromUserId());
        dto.setToUserId(mode.getToUserId());
        dto.setObjId(mode.getObjId());
        dto.setGrade(mode.getGrade());
        dto.setCreateTime(mode.getCreateTime());
        dto.setLikeFlag(mode.getLikeFlag());
        dto.setFromUserName(mode.getFromUserName());
        dto.setToUserName(mode.getToUserName());
    }
}
