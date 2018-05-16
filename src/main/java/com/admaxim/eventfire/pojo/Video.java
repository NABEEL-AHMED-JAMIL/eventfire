package com.admaxim.eventfire.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.admaxim.eventfire.pojo.Partner.getPartnerId;


public class Video {

    private final static Logger log = LoggerFactory.getLogger(Video.class);

    private String videoId;
    private String h;
    private String w;


    public Video() {
        log.info("Video-----Constructor");
    }

    public String getVideoId() {
        log.info("get-Video-Id");
        return videoId;
    }

    public void setVideoId(String videoId) {
        log.info("set-Video-Id");
        this.videoId = videoId + "_" + getPartnerId()  ;
    }

    public String getH() {
        log.info("get-H");
        return h;
    }
    public void setH(String h) {
        log.info("set-H");
        this.h = h;
    }

    public String getW() {
        log.info("get-W");
        return w;
    }
    public void setW(String w) {
        log.info("set-W");
        this.w = w;
    }


    @Override
    public String toString() {
        return "Video{" +
                ", videoId='" + videoId + '\'' +
                ", h='" + h + '\'' +
                ", w='" + w + '\'' +
                '}';
    }
}
