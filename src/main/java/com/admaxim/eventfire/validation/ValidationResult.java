package com.admaxim.eventfire.validation;

public class ValidationResult {

    private final Boolean valid;
    private final String result;

    public ValidationResult(boolean valid, String result) {
        this.valid = valid;
        this.result = result;
    }

    public boolean isValid() {
        return valid;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() { return (new StringBuilder()).append("valid= ").append(valid).append("\n").append("result= ").append(result).toString(); }

}
