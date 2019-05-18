package edu.bgcms.dao;

import edu.bgcms.model.comment.Comment;
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

    @Select("SELECT c.`uuid`, `content`, `img_id`, c.`obj_id`, `last_id`, `grade`, `create_time`, IFNULL(l.flag,0)" +
            "(SELECT username FROM `user` WHERE uuid = to_user_id  ) as`to_user_id`," +
            " (SELECT username FROM `user` WHERE uuid = from_user_id ) as `from_user_id` " +
            "FROM `comment` AS c LEFT JOIN `like` AS l ON c.uuid =l.obj_id  " +
            "WHERE c.obj_id = #{obj} AND l.user_id = #{user}")
    List<Comment> selectListByObjId(Map param);

}