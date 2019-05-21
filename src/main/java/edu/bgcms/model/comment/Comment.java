package edu.bgcms.model.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Comment {
    private String uuid;

    private String imgId;

    private String toUserId;

    private String fromUserId;

    private String objId;
//0表示无
    private String lastId;

    private Integer grade;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;

    private String content;
}