package edu.bgcms.model.boardGame;

public class UserFBg {
    private Integer id;

    private String userUuid;

    private String bgUuid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getBgUuid() {
        return bgUuid;
    }

    public void setBgUuid(String bgUuid) {
        this.bgUuid = bgUuid;
    }
}