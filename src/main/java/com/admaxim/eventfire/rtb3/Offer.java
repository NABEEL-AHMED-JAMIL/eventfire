package com.admaxim.rtb.rtb3.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Offer {

    @JsonProperty("item")
    private List<Item> items;
    @JsonProperty("package")
    private Integer package_;
    private String dburl;
    private Ext ext;

    public Offer() { }

    public List<Item> getItems() { return items; }

    public void setItems(List<Item> items) { this.items = items; }
    public Integer getPackage_() { return package_; }

    public void setPackage_(Integer package_) { this.package_ = package_; }
    public String getDburl() { return dburl; }

    public void setDburl(String dburl) { this.dburl = dburl; }

    public Ext getExt() { return ext; }
    public void setExt(Ext ext) { this.ext = ext; }
}
