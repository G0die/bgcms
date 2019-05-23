package edu.bgcms.dao;

import edu.bgcms.dto.PermissionDto;
import edu.bgcms.model.shiro.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
//-----
    List<String> selectByUser(List<String> roles);

    @Select("SELECT rp.*,p.permission,p.url " +
            "FROM `role_permission` as rp  LEFT JOIN permission as p on rp.permission_id = p.id " +
            "WHERE rp.role_id = #{roleId} ")
    List<PermissionDto> selectByRole(String roleId);

    @Select("SELECT * from permission")
    List<Permission> getAllPermissionList();
}