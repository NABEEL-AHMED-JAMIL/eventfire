package com.admaxim.eventfire.rest;

import com.admaxim.eventfire.pojo.Partner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyEditorSupport;

public class PartnerFireId extends PropertyEditorSupport {

    private final static Logger log = LoggerFactory.getLogger(PartnerFireId.class);

    private Partner partner;

    public void setAsText(final String partnerKey) throws IllegalArgumentException {
        log.info("====================");
        log.info("====="+partnerKey+"======");
        log.info("====================");
        partner = new Partner();
        partner.setPartnerId(partnerKey);
    }

}
