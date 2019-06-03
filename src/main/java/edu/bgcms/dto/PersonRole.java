package edu.bgcms.dto;

import edu.bgcms.model.shiro.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonRole extends Role {
    private String flag;
}
