package edu.bgcms.dao;

import edu.bgcms.model.shiro.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
//-----------------
    @Select("SELECT b.role FROM user_role as a LEFT JOIN role as b WHERE  a.role_id = b.id AND a.user_id = #{userId})")
    public List<String> selectByUser(String userId);

    @Select("SELECT * from role where role != '管理员'")
    List<Role> getAllRole();
}