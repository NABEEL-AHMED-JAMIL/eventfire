package com.admaxim.eventfire.rtb3;

import java.util.List;

public class Deal {

    private String id;
    private Integer qty;
    private Float flr;
    private String flrcur = "USD";
    private Integer at;
    private List<String> seat;
    private List<String> wadomain;
    private Ext ext;


    public Deal() { }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Integer getQty() { return qty; }
    public void setQty(Integer qty) { this.qty = qty; }

    public Float getFlr() { return flr; }
    public void setFlr(Float flr) { this.flr = flr; }

    public String getFlrcur() { return flrcur; }
    public void setFlrcur(String flrcur) { this.flrcur = flrcur; }

    public Integer getAt() { return at; }
    public void setAt(Integer at) { this.at = at; }

    public List<String> getSeat() { return seat; }
    public void setSeat(List<String> seat) { this.seat = seat; }

    public List<String> getWadomain() { return wadomain; }
    public void setWadomain(List<String> wadomain) { this.wadomain = wadomain; }

    public Ext getExt() { return ext; }
    public void setExt(Ext ext) { this.ext = ext; }

    @Override
    public String toString() {
        return "Deal{" +
                "id='" + id + '\'' + ", qty=" + qty + ", flr=" + flr +
                ", flrcur='" + flrcur + '\'' + ", at=" + at + ", seat=" + seat +
                ", wadomain=" + wadomain + ", ext=" + ext +
                '}';
    }

}
