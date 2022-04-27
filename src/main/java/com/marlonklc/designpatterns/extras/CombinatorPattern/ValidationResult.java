package com.marlonklc.designpatterns.extras.CombinatorPattern;

public enum ValidationResult {

    NAME_NOT_CONTAINS_SURNAME("Person's name doesn't contains surname."),
    IS_NOT_AN_ADULT("Person must be of legal age."),
    GENDER_NOT_DEFINED("Person gender must be defined."),
    ADDRESS_NOT_ALLOWED("Person address not allowed."),
    OK("Person approved.")
    ;

    private String message;

    ValidationResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
