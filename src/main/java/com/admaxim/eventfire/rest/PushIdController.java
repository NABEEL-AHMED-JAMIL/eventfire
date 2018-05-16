package com.admaxim.eventfire.rest;

import com.admaxim.eventfire.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/push/fire/")
public class PushIdController {

    private final static Logger log = LoggerFactory.getLogger(PushIdController.class);


    @RequestMapping(value = "/{partnerKey}", method = RequestMethod.POST)
    public String get(@PathVariable(value = "partnerKey") String partnerKey, @RequestBody User user) {
        return user.toString();
    }

    @InitBinder
    public void initBinder(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(String.class, new PartnerFireId());

    }


}
