package edu.bgcms.model.boardGame;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class BoardGame {
    private String uuid;

    private String name;

    private String type;

    private String information;

    private Integer maxplayers;

    private String buytime;

    private Double money;

    private String applicant;

    private Date applicantiontime;

    private String currentuser;

    private String status;

    private Integer views;

    private Integer lends;

}