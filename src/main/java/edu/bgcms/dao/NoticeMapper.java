package edu.bgcms.dao;

import edu.bgcms.model.notice.Notice;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NoticeMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
    //----------------------
    @Select("SELECT * FROM notice WHERE " +
            "bg_uuid = '0' or " +
            "(bg_uuid = (SELECT bg_uuid FROM `user_f_bg` WHERE user_uuid = #{uuid}))")
    List<Notice> selectSeeList(String uuid);
}