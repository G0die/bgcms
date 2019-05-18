package edu.bgcms.model.notice;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class Notice {
    private String uuid;

    private String title;

    private String bgUuid;

    private String content;

    private String creator;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createtime;

    private String attachmant;
}
