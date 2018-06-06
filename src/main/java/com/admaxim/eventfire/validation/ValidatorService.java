package com.admaxim.eventfire.validation;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class ValidatorService {

    private final static Logger log = LoggerFactory.getLogger(ValidatorService.class);

    private IGenericValidator iGenericValidator = null;
    private ValidationResult validationResult = null;
    private String jsonString, cacheKey;
    private Boolean decision = false;
    /*Time count var*/
    private Long before;

    /*
     * Note:- Cache the IGenericValidator to less the Exc time
     * MaxSize of Cache current 2 after Response Schemas impls then set size 4
     * */
    private Cache<String,IGenericValidator> rtbFactroyCache = CacheBuilder.newBuilder().
            maximumSize(2).expireAfterWrite(15, TimeUnit.MINUTES).build();

    /*
     * Note:- Each New Resource (RTB-Schemas) should be added here
     * */
    public static final IGenericValidator REQUEST_V1_0 =
            new GenericGenericValidator("/schemas/event_fire-request_v1-0.json");

    public static final IGenericValidator RESPONSE_V1_0 =
            new GenericGenericValidator("/schemas/event_fire-request_v1-0.json");

    /*
     * Note:- Need to impl the cache here to reduce process time
     * @Danger:- No-Need to call this method out side the class
     * */
    private IGenericValidator getValidator(InputType type, FireVersion version) {
        try {
            /*
             * Possible key
             * Reqeust_v1_0, Response_v1_0
             * */
            if (type != null && version != null) {
                cacheKey = type + "_" + version;
                this.iGenericValidator = rtbFactroyCache.get(type+"_"+version, () -> {
                    switch (version) {
                        case V1_0:
                            log.info("Cache-Key :- " + cacheKey);
                            this.iGenericValidator = InputType.REQUEST.equals(type) ? REQUEST_V1_0 : RESPONSE_V1_0;
                            break;
                    }
                    return iGenericValidator;
                });
            }
        }catch (Exception e) { log.info("Error-Getting Validator :- " + e.getMessage()); }

        return this.iGenericValidator;
    }



    public Boolean isResponseValidator(String request, InputType type) {

        this.iGenericValidator = getValidator(type,  FireVersion.V1_0);

        if(iGenericValidator != null) {
            log.info("Process Response Validator Start");
            before = System.currentTimeMillis();
            this.jsonString = request;
            // convert the request to string
            if(this.iGenericValidator.isValid(jsonString)) {
                log.info("result :-" + showValidationResult());
                decision = true;
            } else {
                log.info("result :-" + showValidationResult());
                decision = false;
            }
            log.info("Process Response Validator End.");
            log.info("Validation Time-Take ("+ (System.currentTimeMillis()-before) + ")ms.");
        }

        return decision;
    }

    // only show on console
    public String showValidationResult() {
        try {
            this.validationResult = iGenericValidator.validate(jsonString);
        } catch (IOException e) {
            // if error show error message
            log.error("Error Message:- " + e.getMessage());
            return this.validationResult.getResult();
        }

        return validationResult.getResult();
    }

}
