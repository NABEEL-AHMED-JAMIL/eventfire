package com.admaxim.eventfire.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Partner {

    private final static Logger log = LoggerFactory.getLogger(Partner.class);

    protected static String partnerId;

    public static String getPartnerId() {
        log.info("get-ing partner-id");
        return partnerId;
    }
    public void setPartnerId(String partnerId) {
        log.info("set-ing partner-id" + partnerId);
        this.partnerId = partnerId;
    }


    @Override
    public String toString() { return "Partner{" + "partnerId='" + partnerId + '\'' + '}';}

}