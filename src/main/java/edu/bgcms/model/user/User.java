package edu.bgcms.model.user;

import java.util.Date;

public class User {
    private String uuid;

    private String account;

    private String pwd;

    private String username;

    private String gender;

    private String roler;

    private Double experience;

    private String phone;

    private String mail;

    private String college;

    private String major;

    private String year;

    private Date birthday;

    private String province;

    private String city;

    private String motto;

    private Integer messagenumeber;

    private Integer deny;

    private Integer showperson;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRoler() {
        return roler;
    }

    public void setRoler(String roler) {
        this.roler = roler;
    }

    public Double getExperience() {
        return experience;
    }

    public void setExperience(Double experience) {
        this.experience = experience;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public Integer getMessagenumeber() {
        return messagenumeber;
    }

    public void setMessagenumeber(Integer messagenumeber) {
        this.messagenumeber = messagenumeber;
    }

    public Integer getDeny() {
        return deny;
    }

    public void setDeny(Integer deny) {
        this.deny = deny;
    }

    public Integer getShowperson() {
        return showperson;
    }

    public void setShowperson(Integer showperson) {
        this.showperson = showperson;
    }
}