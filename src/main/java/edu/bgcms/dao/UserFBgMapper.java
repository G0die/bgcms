package edu.bgcms.dao;

import edu.bgcms.model.boardGame.UserFBg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserFBgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserFBg record);

    int insertSelective(UserFBg record);

    UserFBg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserFBg record);

    int updateByPrimaryKey(UserFBg record);
    //-------------

    @Select("SELECT user_uuid FROM `user_f_bg` where bg_uuid = #{bgId}")
    List<String> selectFollowNum(String bgId);
    @Delete("delete from `user_f_bg` where bg_uuid=#{bg} and user_uuid = #{user}")
    int deleteFollow(Map map);
}