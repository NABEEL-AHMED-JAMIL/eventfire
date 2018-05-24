package com.admaxim.rtb.rtb3.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Seatbid {

    private String seat;
    @JsonProperty("package")
    private Integer package_ = 0;;
    private List<Bid> bids;
    private Ext ext;

    public Seatbid() { }

    public String getSeat() { return seat; }
    public void setSeat(String seat) { this.seat = seat; }

    public Integer getPackage_() { return package_; }
    public void setPackage_(Integer package_) { this.package_ = package_; }

    public List<Bid> getBids() { return bids; }
    public void setBids(List<Bid> bids) { this.bids = bids; }

    public Ext getExt() { return ext; }
    public void setExt(Ext ext) { this.ext = ext; }

    @Override
    public String toString() {
        return "Seatbid{" + "seat='" + seat + '\'' + ", package_=" + package_ +
                ", bids=" + bids + ", ext=" + ext + '}';
    }
}
