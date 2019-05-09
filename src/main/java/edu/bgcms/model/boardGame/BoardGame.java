package edu.bgcms.model.boardGame;

import java.util.Date;

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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getMaxplayers() {
        return maxplayers;
    }

    public void setMaxplayers(Integer maxplayers) {
        this.maxplayers = maxplayers;
    }

    public String getBuytime() {
        return buytime;
    }

    public void setBuytime(String buytime) {
        this.buytime = buytime;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Date getApplicantiontime() {
        return applicantiontime;
    }

    public void setApplicantiontime(Date applicantiontime) {
        this.applicantiontime = applicantiontime;
    }

    public String getCurrentuser() {
        return currentuser;
    }

    public void setCurrentuser(String currentuser) {
        this.currentuser = currentuser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getLends() {
        return lends;
    }

    public void setLends(Integer lends) {
        this.lends = lends;
    }
}