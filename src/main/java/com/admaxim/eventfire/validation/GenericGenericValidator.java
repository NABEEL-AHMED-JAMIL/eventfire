package com.admaxim.eventfire.validation;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class GenericGenericValidator implements IGenericValidator {

    private final static Logger log = LoggerFactory.getLogger(GenericGenericValidator.class);
    private final JsonSchema jsonschema;

    public GenericGenericValidator(String schemaResource) {
        try {
            log.info("Init.....schema....");
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonNode jsonNode = JsonLoader.fromResource(schemaResource);
            this.jsonschema = factory.getJsonSchema(jsonNode);

        }catch (IOException | ProcessingException e) {
            throw new IllegalStateException("could not initialize validator due to previous exception", e);
        }
    }

    @Override public boolean isValid(String json) {
        try {
            return validate(json).isValid();
        }catch (IOException e) {
            log.error("Error :- " + e.getMessage() + " valid status :- " + "false");
            return false;
        }
    }

    @Override public ValidationResult validate(String json) throws IOException {
        JsonNode jsonNode = JsonLoader.fromString(json);
        return getValidationResult(jsonNode);
    }

    private final ValidationResult getValidationResult(JsonNode jsonNode) throws IOException {
        try {
            ProcessingReport processingReport = this.jsonschema.validate(jsonNode);
            if (processingReport.isSuccess()) {
                return new ValidationResult(processingReport.isSuccess(), processingReport.toString());
            } else {
                return new ValidationResult(processingReport.isSuccess(), processingReport.toString());
            }
        } catch (ProcessingException e) {
            log.error("Error :- " + e.getMessage());
            throw new IOException(e.getMessage());
        }
    }
}
