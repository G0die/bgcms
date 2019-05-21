package edu.bgcms.dao;

import edu.bgcms.model.comment.Comment;
import edu.bgcms.model.comment.CommentLike;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CommentMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
    //-----------------

    @Select("SELECT c.*, IFNULL(l.flag,0) as likeFlag," +
            "(SELECT username FROM `user` as a WHERE a.uuid = c.to_user_id  ) as`to_user_name`," +
            " (SELECT username FROM `user` as b WHERE b.uuid = c.from_user_id ) as `from_user_name` " +
            "FROM `comment` AS c LEFT JOIN `like` AS l ON c.uuid =l.obj_id AND l.user_id = #{user} " +
            "WHERE c.obj_id = #{obj} ORDER BY c.create_time Desc")
    List<CommentLike> selectListByObjId(Map param);

}