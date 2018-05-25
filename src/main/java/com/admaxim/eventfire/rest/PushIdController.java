package com.admaxim.eventfire.rest;

import com.admaxim.eventfire.pojo.User;
import com.admaxim.eventfire.validation.InputType;
import com.admaxim.eventfire.validation.ValidatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/push/fire/")
public class PushIdController {

    private final static Logger log = LoggerFactory.getLogger(PushIdController.class);


    @RequestMapping(value = "/{partnerKey}", method = RequestMethod.POST)
    public ResponseEntity<String> get(@PathVariable(value = "partnerKey") String partnerKey, @RequestBody User user) {
          return new ResponseEntity<>(user.toString(), HttpStatus.OK);
    }

    @InitBinder(value = {"partnerKey"})
    public void initBinder(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(String.class, new PartnerFireId());
    }


}
