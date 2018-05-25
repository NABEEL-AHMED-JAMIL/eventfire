package com.admaxim.eventfire.validation;

import com.admaxim.eventfire.validation.factory.IGenericValidator;
import com.admaxim.eventfire.validation.factory.ValidatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class ValidatorService {

    private final static Logger log = LoggerFactory.getLogger(ValidatorService.class);

    private IGenericValidator iGenericValidator = null;
    private ValidationResult validationResult = null;
    private String json = null;

    public Boolean isResponseValidator(String request, InputType openRtbInputType) {
        this.iGenericValidator = ValidatorFactory.getValidator(openRtbInputType,  FireVersion.V1_0);
        // convert the request to string
        this.json = request;
        if(this.iGenericValidator.isValid(json)) {
            System.out.println(showValidationResult());
            return true;
        } else {
            System.out.println(showValidationResult());
            return false;
        }
    }

    // only show on console
    public String showValidationResult() {

        try {
            this.validationResult = iGenericValidator.validate(json);
        } catch (IOException e) {
            // if error show error message and out...with bool
            System.out.println("Error Message:- " + e.getMessage());
            return this.validationResult.getResult();
        }

        return validationResult.getResult();
    }

}
