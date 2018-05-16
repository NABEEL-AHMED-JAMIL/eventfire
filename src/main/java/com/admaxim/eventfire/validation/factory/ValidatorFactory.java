package com.admaxim.eventfire.validation.factory;


import com.admaxim.eventfire.validation.FireVersion;
import com.admaxim.eventfire.validation.InputType;

/***************************************************************
 * This factory class provides access to validators for EventFire*
 * versions 1.0, 2.0                                			 *
 **************************************************************/
public final class ValidatorFactory {

    /**
     * An EventFire request v1.0 validator.
     */
    public static final IGenericValidator REQUEST_V1_0 = new GenericGenericValidator("/schemas/event_fire-request_v1-0.json");

    /**
     * An EventFire response v1.0 validator.
     */
    public static final IGenericValidator RESPONSE_V1_0 = new GenericGenericValidator("/schemas/event_fire-request_v1-0.json");

    /**
     * Returns an EventFire validator of a specific type and version.
     *
     * @param type
     *            the type
     * @param version
     *            the version
     * @return a specific EventFire validator or null if either type or version are null
     */
    public static IGenericValidator getValidator(InputType type, FireVersion version) {

        IGenericValidator validator = null;

        switch (version) {
            case V1_0:
                validator = InputType.REQUEST.equals(type) ? REQUEST_V1_0 : RESPONSE_V1_0;
                break;
        }

        return validator;
    }

}
