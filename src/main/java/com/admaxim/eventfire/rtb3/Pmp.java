package com.admaxim.rtb.rtb3.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Pmp {

    @JsonProperty("private")
    private Integer private_;
    private List<Object> deals;
    private Ext ext;

    public Pmp() { }

    public Integer getPrivate_() { return private_; }
    public void setPrivate_(Integer private_) { this.private_ = private_; }

    public List<Object> getDeals() { return deals; }
    public void setDeals(List<Object> deals) { this.deals = deals; }

    public Ext getExt() { return ext; }
    public void setExt(Ext ext) { this.ext = ext; }


    @Override
    public String toString() {
        return "Pmp{" +
                "private_=" + private_ + ", deals=" + deals +
                ", ext=" + ext + '}';
    }
}
