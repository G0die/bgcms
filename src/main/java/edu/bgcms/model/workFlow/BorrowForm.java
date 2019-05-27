package edu.bgcms.model.workFlow;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class BorrowForm {
    private String uuid;

    private String bgId;

    private String curUser;

    private String applicant;

    private Integer curStep;

    private Date createTime;

    private String remark;


}