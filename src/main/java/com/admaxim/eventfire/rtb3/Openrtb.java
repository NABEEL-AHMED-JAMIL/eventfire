package com.admaxim.rtb.rtb3.pojo;

public class Openrtb {

    private String ver;
    private String domainspec;
    private String domainver;
    private Request request;
    private Response response;
    private Ext ext;

    public Openrtb() { }

    public String getVer() { return ver; }
    public void setVer(String ver) { this.ver = ver; }

    public String getDomainspec() { return domainspec; }
    public void setDomainspec(String domainspec) { this.domainspec = domainspec; }

    public String getDomainver() { return domainver; }
    public void setDomainver(String domainver) { this.domainver = domainver; }

    public Request getRequest() { return request; }
    public void setRequest(Request request) { this.request = request; }

    public Response getResponse() { return response; }
    public void setResponse(Response response) { this.response = response; }

    public Ext getExt() { return ext; }
    public void setExt(Ext ext) { this.ext = ext; }

    @Override
    public String toString() {
        return "Openrtb{" +
                "ver='" + ver + '\'' + ", domainspec='" + domainspec + '\'' +
                ", domainver='" + domainver + '\'' + ", request=" + request +
                ", response=" + response + ", ext=" + ext +
                '}';
    }
}
