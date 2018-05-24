package com.admaxim.rtb.rtb3.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Request {

    private String id;
    private Integer test = 0;
    private Integer tmax;
    private Integer at = 0;
    private List<String> curs =  Arrays.asList("USD");
    private Integer wcurs;
    private List<String> seats;
    private Integer wseats = 0;
    private Source source;
    private Offer offer;
    private Domain domain;
    private Ext ext;

    public Request() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Integer getTest() { return test; }
    public void setTest(Integer test) { this.test = test; }

    public Integer getTmax() { return tmax; }
    public void setTmax(Integer tmax) { this.tmax = tmax; }

    public Integer getAt() { return at; }
    public void setAt(Integer at) { this.at = at; }

    public List<String> getCurs() { return curs; }
    public void setCurs(List<String> curs) { this.curs = curs; }

    public Integer getWcurs() { return wcurs; }
    public void setWcurs(Integer wcurs) { this.wcurs = wcurs; }

    public List<String> getSeats() { return seats; }
    public void setSeats(List<String> seats) { this.seats = seats; }

    public Integer getWseats() { return wseats; }
    public void setWseats(Integer wseats) { this.wseats = wseats; }

    public Source getSource() { return source; }
    public void setSource(Source source) { this.source = source; }

    public Offer getOffer() { return offer; }
    public void setOffer(Offer offer) { this.offer = offer; }

    public Domain getDomain() { return domain; }
    public void setDomain(Domain domain) { this.domain = domain; }

    public Ext getExt() { return ext; }
    public void setExt(Ext ext) { this.ext = ext; }


    @Override
    public String toString() {
        return "Request{" +
                "id='" + id + '\'' + ", test=" + test +
                ", tmax=" + tmax + ", at=" + at +
                ", curs=" + curs + ", wcurs=" + wcurs +
                ", seats=" + seats + ", wseats=" + wseats +
                ", source=" + source + ", offer=" + offer +
                ", domain=" + domain + ", ext=" + ext +
                '}';
    }
}
