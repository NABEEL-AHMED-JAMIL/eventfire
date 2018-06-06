package com.admaxim.eventfire.rest;

import com.admaxim.eventfire.pojo.Partner;
import com.admaxim.eventfire.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/push/fire/")
public class PushIdController {

    private final static Logger log = LoggerFactory.getLogger(PushIdController.class);
    private static HashMap<String, String> count = new HashMap<>();

    @InitBinder(value = {"partnerKey"})
    public void initBinder(final WebDataBinder webdataBinder) {
        log.info("init-Binder-start-process");
        webdataBinder.registerCustomEditor(String.class, new PartnerFireId());
    }

    @RequestMapping(value = "/{partnerKey}", method = RequestMethod.POST)
    public ResponseEntity<User> getResponseWithPartnerId(
            @PathVariable(value = "partnerKey") String partnerKey, @RequestBody User user) {
        String responseMessage = user.toString();
        log.info("response-send " + responseMessage);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    private final class PartnerFireId extends PropertyEditorSupport {

        private Partner partner;

        public void setAsText(final String partnerKey) throws IllegalArgumentException {
            log.info("====================");
            log.info("====="+partnerKey+"======");
            log.info("====================");
            partner = new Partner();
            partner.setPartnerId(partnerKey);
        }
    }

}
