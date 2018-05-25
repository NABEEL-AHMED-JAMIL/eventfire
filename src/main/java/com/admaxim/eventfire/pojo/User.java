package com.admaxim.eventfire.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.admaxim.eventfire.pojo.Partner.getPartnerId;

public class User {

    private final static Logger log = LoggerFactory.getLogger(User.class);

    private String userId;
    private String userName;
    private String phone;
    private Role role;
    private Video video;

    public static Integer count = 0;

    public User() {
        log.info("===="+ (count++) +"====");
        log.info("Partner Id " + getPartnerId());
    }

    public String getUserId() {
        log.info("get-model-id");
        return userId;
    }
    public void setUserId(String userId) {
        log.info("set-model-id");
        this.userId = userId + "_" + getPartnerId();

    }

    public String getUserName() {
        log.info("get-model-Name");
        return userName;
    }
    public void setUserName(String userName) {
        log.info("set-model-Name");
        this.userName = userName;
    }

    public String getPhone() {
        log.info("get-model-Phone");
        return phone;
    }
    public void setPhone(String phone) {
        log.info("set-model-Phone");
        this.phone = phone;
    }

    public Role getRole() {
        log.info("get-model-Role");
        return role;
    }
    public void setRole(Role role) {
        log.info("set-model-Role");
        this.role = role;
    }

    public Video getVideo() {
        log.info("get-model-Video");
        return video;
    }
    public void setVideo(Video video) {
        log.info("set-model-Video");
        this.video = video;
    }


    @Override
    public String toString() {
        return "User{" +
                " userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", video=" + video +
                '}';
    }
}
