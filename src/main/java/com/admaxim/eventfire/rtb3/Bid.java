package com.admaxim.eventfire.rtb3;

public class Bid {

    private String id;
    private String item;
    private String deal;
    private Float price;
    private String cid;
    private String tactic;
    private String burl;
    private String lurl;
    private Domain domain;
    private Ext ext;

    public Bid() { }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }

    public String getDeal() { return deal; }
    public void setDeal(String deal) { this.deal = deal; }

    public Float getPrice() { return price; }
    public void setPrice(Float price) { this.price = price; }

    public String getCid() { return cid; }
    public void setCid(String cid) { this.cid = cid; }

    public String getTactic() { return tactic; }
    public void setTactic(String tactic) { this.tactic = tactic; }

    public String getBurl() { return burl; }
    public void setBurl(String burl) { this.burl = burl; }

    public String getLurl() { return lurl; }
    public void setLurl(String lurl) { this.lurl = lurl; }

    public Domain getDomain() { return domain; }
    public void setDomain(Domain domain) { this.domain = domain; }

    public Ext getExt() { return ext; }
    public void setExt(Ext ext) { this.ext = ext; }

    @Override
    public String toString() {
        return "Bid{" +
                "id='" + id + '\'' + ", item='" + item + '\'' +
                ", deal='" + deal + '\'' + ", price=" + price +
                ", cid='" + cid + '\'' + ", tactic='" + tactic + '\'' +
                ", burl='" + burl + '\'' + ", lurl='" + lurl + '\'' +
                ", domain=" + domain + ", ext=" + ext +
                '}';
    }
}
