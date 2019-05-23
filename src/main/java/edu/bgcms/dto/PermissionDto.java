package edu.bgcms.dto;

import edu.bgcms.model.shiro.RolePermission;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionDto extends RolePermission {
    private String permission;

    private String url;


}
