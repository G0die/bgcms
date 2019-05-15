package edu.bgcms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AjaxMsg {
    private int status;
    private String msg;
    private Object date;
}
