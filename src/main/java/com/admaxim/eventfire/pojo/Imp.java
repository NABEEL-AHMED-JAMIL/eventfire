package com.admaxim.eventfire.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.admaxim.eventfire.pojo.Partner.getPartnerId;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Imp {

    private final static Logger log = LoggerFactory.getLogger(Imp.class);

    private String id;
    private String name;
    private String xyz;

    public Imp() {
        log.info("Partner Id " + getPartnerId());
    }

    public String getId() {
        log.info("get-Imp--Id");
        return id;
    }
    public void setId(String id) {
        log.info("set-Imp--Id");
        this.id = id + "_" + getPartnerId();
    }

    public String getName() {
        log.info("get-Imp--name");
        return name;
    }
    public void setName(String name) {
        log.info("set-Imp--name");
        this.name = name;
    }

    public String getXyz() {
        log.info("get-Imp--xyz");
        return xyz;
    }
    public void setXyz(String xyz) {
        log.info("set-Imp--xyz");
        this.xyz = xyz;
    }


    @Override
    public String toString() {
        return "Imp{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", xyz='" + xyz + '\'' + '}';
    }

}
