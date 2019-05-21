package edu.bgcms.model.comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentLike extends Comment {
    private int likeFlag;
    private String toUserName;

    private String fromUserName;
}
