package edu.bgcms.dao;

import edu.bgcms.model.shiro.RolePermission;
import org.apache.ibatis.annotations.Delete;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

    @Delete("delete from role_permission  WHERE role_id = #{id} ")
    int deleteByRoleId(Integer id);


}