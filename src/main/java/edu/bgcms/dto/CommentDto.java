package edu.bgcms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CommentDto {
    private String uuid;

    private String imgId;

    private String toUserId;

    private String fromUserId;

    private String objId;

    private List<CommentDto> nextData;

    private Integer grade;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;

    private String content;
    private int likeFlag;
    private String toUserName;

    private String fromUserName;
}