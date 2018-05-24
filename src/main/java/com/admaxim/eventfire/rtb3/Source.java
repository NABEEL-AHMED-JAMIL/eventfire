package com.admaxim.rtb.rtb3.pojo;

public class Source {

    private Integer fd;
    private String tid;
    private String pchain;
    private Ext ext;

    public Source() { }

    public Integer getFd() { return fd; }
    public void setFd(Integer fd) { this.fd = fd; }

    public String getTid() { return tid; }
    public void setTid(String tid) { this.tid = tid; }

    public String getPchain() { return pchain; }
    public void setPchain(String pchain) { this.pchain = pchain; }

    public Ext getExt() { return ext; }
    public void setExt(Ext ext) { this.ext = ext; }

    @Override
    public String toString() {
        return "Source{" + "fd=" + fd + ", tid='" + tid + '\'' +
                ", pchain='" + pchain + '\'' + ", ext=" + ext + '}';
    }
}
