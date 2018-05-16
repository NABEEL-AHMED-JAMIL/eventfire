package com.admaxim.eventfire.validation.factory;

import com.admaxim.eventfire.validation.ValidationResult;

import java.io.IOException;

/**
 * This interface provides JSON validation methods.
 */
public interface IGenericValidator {

    /**
     * Validates JSON against a given specification
     *
     * @param json
     *            the JSON as a string
     * @return true if JSON is valid
     */
    public boolean isValid(String json);

    /**
     * Validates JSON against a given specification
     *
     * @param jsonObject
     *            the JSON as a object
     * @return true JSON as string
     */
    public String ObjectToString(Object jsonObject);

    /**
     * Validates JSON against a given specification
     *
     * @param json
     *            the JSON as a string
     * @return a validation result
     * @throws IOException
     *             an exception occurred while parsing or validating JSON
     */
    public ValidationResult validate(String json) throws IOException;

}
