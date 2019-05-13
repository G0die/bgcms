package edu.bgcms.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Select;

@Getter
@Setter
public class AjaxMsg {
    private int status;
    private String msg;
    private Object date;
}
