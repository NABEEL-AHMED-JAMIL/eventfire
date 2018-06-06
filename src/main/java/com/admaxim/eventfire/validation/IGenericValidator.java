package com.admaxim.eventfire.validation;

import java.io.IOException;

/**
 * This interface provides JSON validation methods.
 */
public interface IGenericValidator {

    public boolean isValid(String json);

    public ValidationResult validate(String json) throws IOException;

}
