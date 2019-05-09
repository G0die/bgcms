package edu.bgcms.model.shiro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolePermission {
    private Integer id;

    private Integer roleId;

    private Integer permissionId;

}