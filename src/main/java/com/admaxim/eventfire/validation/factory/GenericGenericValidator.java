package com.admaxim.eventfire.validation.factory;

import com.admaxim.eventfire.validation.ValidationResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.IOException;


public class GenericGenericValidator implements IGenericValidator {

    private final JsonSchema schema;

    public GenericGenericValidator(String schemaResource) {

        try {
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonNode jsonNode = JsonLoader.fromResource(schemaResource);
            schema = factory.getJsonSchema(jsonNode);

        }catch (IOException | ProcessingException e) {
            throw new IllegalStateException
                    ("could not initialize validator due to previous exception", e);
        }
    }

    @Override
    public boolean isValid(String json) {
        try {
            return validate(json).isValid();
        }catch (IOException e) {
            return false;
        }

    }

    @Override
    public String ObjectToString(Object jsonObject) {
        String jsonString = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonString = mapper.writeValueAsString(jsonObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    @Override
    public ValidationResult validate(String json) throws IOException {
        JsonNode jsonNode = JsonLoader.fromString(json);
        return getValidationResult(jsonNode);
    }

    private final ValidationResult getValidationResult(JsonNode jsonNode) throws IOException {
        try {
            ProcessingReport processingReport = schema.validate(jsonNode);
            if (processingReport != null) {
                return new ValidationResult(processingReport.isSuccess(), processingReport.toString());
            } else {
                return new ValidationResult(false, null);
            }
        } catch (ProcessingException e) {
            throw new IOException(e.getMessage());
        }
    }
}
