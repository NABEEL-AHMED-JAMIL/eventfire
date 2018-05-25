package com.admaxim.eventfire.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.admaxim.eventfire.pojo.Partner.getPartnerId;

public class Role {

    private final static Logger log = LoggerFactory.getLogger(Role.class);

    private String roleId;
    private String name;

    public Role() {
        log.info("Partner Id " + getPartnerId());
    }

    public String getRoleId() {
        log.info("get-Role--Id");
        return roleId;
    }
    public void setRoleId(String roleId) {
        log.info("set-Role--Id");
        this.roleId = roleId + "_" + getPartnerId() ;
    }

    public String getName() {
        log.info("get-Role--Name");
        return name;
    }
    public void setName(String name) {
        log.info("set-Role--Name");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                ", roleId='" + roleId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
