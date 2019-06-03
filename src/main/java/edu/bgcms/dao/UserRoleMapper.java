package edu.bgcms.dao;

import edu.bgcms.model.shiro.UserRole;
import org.apache.ibatis.annotations.Select;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
    //---
    @Select("SELECT * from role where role != '管理员'")
    UserRole getAllRole();
}