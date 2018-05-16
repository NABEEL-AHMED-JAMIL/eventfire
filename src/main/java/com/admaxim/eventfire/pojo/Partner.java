package com.admaxim.eventfire.pojo;

public class Partner {

    public static String partnerId;

    public static String getPartnerId() {    return partnerId; }
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    @Override
    public String toString() {
        return "Partner{" + "partnerId='" + partnerId + '\'' + '}';}
}