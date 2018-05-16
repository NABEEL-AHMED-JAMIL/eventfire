package com.admaxim.eventfire.rest;

import com.admaxim.eventfire.pojo.Partner;

import java.beans.PropertyEditorSupport;

public class PartnerFireId extends PropertyEditorSupport {

    private Partner partner;

    public void setAsText(final String partnerKey) throws IllegalArgumentException {
        partner = new Partner();
        partner.setPartnerId(partnerKey);
    }

}
