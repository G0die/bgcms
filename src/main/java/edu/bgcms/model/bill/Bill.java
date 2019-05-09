package edu.bgcms.model.bill;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bill {
    private String uuid;

    private String type;

    private String title;

    private String remark;

    private Double amount;

    private Double surplus;

    private String creator;

    private Date dotime;

    private Date creattime;

}