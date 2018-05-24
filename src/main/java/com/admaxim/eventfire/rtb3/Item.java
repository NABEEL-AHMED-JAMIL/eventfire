package com.admaxim.rtb.rtb3.pojo;

public class Item {

    private String id;
    private Integer qty = 1;
    private Float flr;
    private String flrcur = "USD";
    private Integer seq;
    private Pmp pmp;
    private Domain domain;
    private Ext ext;

    public Item() { }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Integer getQty() { return qty; }
    public void setQty(Integer qty) { this.qty = qty; }

    public Float getFlr() { return flr; }
    public void setFlr(Float flr) { this.flr = flr; }

    public String getFlrcur() { return flrcur; }
    public void setFlrcur(String flrcur) { this.flrcur = flrcur; }

    public Integer getSeq() { return seq; }
    public void setSeq(Integer seq) { this.seq = seq; }

    public Pmp getPmp() { return pmp; }
    public void setPmp(Pmp pmp) { this.pmp = pmp; }

    public Domain getDomain() { return domain; }
    public void setDomain(Domain domain) { this.domain = domain; }

    public Ext getExt() { return ext; }
    public void setExt(Ext ext) { this.ext = ext; }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' + ", qty=" + qty + ", flr=" + flr +
                ", flrcur='" + flrcur + '\'' + ", seq=" + seq + ", pmp=" + pmp +
                ", domain=" + domain + ", ext=" + ext +
                '}';
    }
}
