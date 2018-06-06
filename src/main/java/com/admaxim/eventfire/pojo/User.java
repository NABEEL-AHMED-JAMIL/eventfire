package com.admaxim.eventfire.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.admaxim.eventfire.pojo.Partner.getPartnerId;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private final static Logger log = LoggerFactory.getLogger(User.class);

    private String userId;
    private String userName;
    private String phone;
    private Role role;
    private Video video;
    private Imp imp;

    public User() { log.info("Partner Id " + getPartnerId()); }

    public String getUserId() {
        log.info("get-User-id");
        return userId;
    }
    public void setUserId(String userId) {
        log.info("set-User-id");
        this.userId = userId + "_" + getPartnerId();

    }

    public String getUserName() {
        log.info("get-User-Name");
        return userName;
    }
    public void setUserName(String userName) {
        log.info("set-User-Name");
        this.userName = userName;
    }

    public String getPhone() {
        log.info("get-User-Phone");
        return phone;
    }
    public void setPhone(String phone) {
        log.info("set-User-Phone");
        this.phone = phone;
    }

    public Role getRole() {
        log.info("get-User-Role");
        return role;
    }
    public void setRole(Role role) {
        log.info("set-User-Role");
        this.role = role;
    }

    public Video getVideo() {
        log.info("get-model-Video");
        return video;
    }
    public void setVideo(Video video) {
        log.info("set-User-Video");
        this.video = video;
    }

    public Imp getImp() {
        log.info("get-User-imp");
        return imp;
    }
    public void setImp(Imp imp) {
        log.info("set-User-imp");
        this.imp = imp;
    }


    @Override
    public String toString() {
        return "User{" + "userId='" + userId + '\'' + ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' + ", role=" + role + ", video=" + video + ", imp=" + imp + '}';
    }

}
