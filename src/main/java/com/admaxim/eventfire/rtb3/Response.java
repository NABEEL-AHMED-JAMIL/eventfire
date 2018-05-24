package com.admaxim.rtb.rtb3.pojo;

import java.util.List;

public class Response {

    private String id;
    private String bidid;
    private Integer nbr;
    private String cur;
    private String cdata;
    private List<Seatbid> seatbids;
    private Ext ext;


    public Response() { }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getBidid() { return bidid; }
    public void setBidid(String bidid) { this.bidid = bidid; }

    public Integer getNbr() { return nbr; }
    public void setNbr(Integer nbr) { this.nbr = nbr; }

    public String getCur() { return cur; }
    public void setCur(String cur) { this.cur = cur; }

    public String getCdata() { return cdata; }
    public void setCdata(String cdata) { this.cdata = cdata; }

    public List<Seatbid> getSeatbids() { return seatbids; }
    public void setSeatbids(List<Seatbid> seatbids) { this.seatbids = seatbids; }

    public Ext getExt() { return ext; }
    public void setExt(Ext ext) { this.ext = ext; }

    @Override
    public String toString() {
        return "Response{" +
                "id='" + id + '\'' + ", bidid='" + bidid + '\'' +
                ", nbr=" + nbr + ", cur='" + cur + '\'' + ", cdata='" + cdata + '\'' +
                ", seatbids=" + seatbids + ", ext=" + ext +
                '}';
    }
}
