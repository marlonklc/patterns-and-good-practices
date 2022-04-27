package com.marlonklc.designpatterns.extras.CombinatorPattern;

import java.util.function.Function;

import static com.marlonklc.designpatterns.extras.CombinatorPattern.ValidationResult.*;
import static java.util.Objects.nonNull;

public interface PersonValidator extends Function<Person, ValidationResult> {

    static PersonValidator nameContainsSurname() {
        return person -> person.getFullName().split(" ").length > 1 ? OK : NAME_NOT_CONTAINS_SURNAME;
    }

    static PersonValidator isAnAdult() {
        return person -> person.getAge() >= 18 ? OK : IS_NOT_AN_ADULT;
    }

    static PersonValidator isGenderDefined() {
        return person -> nonNull(person.getGender()) ? OK : GENDER_NOT_DEFINED;
    }

    static PersonValidator isAddressAllowed() {
        return person -> BlockedPersonService.getBlockedPersons().contains(person.getAddress().getZipCode()) ? ADDRESS_NOT_ALLOWED : OK;
    }

    default PersonValidator and(PersonValidator other) {
        return person -> {
            ValidationResult result = this.apply(person);
            return result.equals(OK) ? other.apply(person) : result;
        };
    }
}
