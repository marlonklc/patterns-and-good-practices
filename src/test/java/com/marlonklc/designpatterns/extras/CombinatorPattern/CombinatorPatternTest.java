package com.marlonklc.designpatterns.extras.CombinatorPattern;

import org.junit.jupiter.api.Test;

import static com.marlonklc.designpatterns.extras.CombinatorPattern.PersonValidator.isAddressAllowed;
import static com.marlonklc.designpatterns.extras.CombinatorPattern.PersonValidator.isAnAdult;
import static com.marlonklc.designpatterns.extras.CombinatorPattern.PersonValidator.isGenderDefined;
import static com.marlonklc.designpatterns.extras.CombinatorPattern.PersonValidator.nameContainsSurname;
import static com.marlonklc.designpatterns.extras.CombinatorPattern.ValidationResult.ADDRESS_NOT_ALLOWED;
import static com.marlonklc.designpatterns.extras.CombinatorPattern.ValidationResult.GENDER_NOT_DEFINED;
import static com.marlonklc.designpatterns.extras.CombinatorPattern.ValidationResult.IS_NOT_AN_ADULT;
import static com.marlonklc.designpatterns.extras.CombinatorPattern.ValidationResult.NAME_NOT_CONTAINS_SURNAME;
import static com.marlonklc.designpatterns.extras.CombinatorPattern.ValidationResult.OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombinatorPatternTest {

    @Test
    public void shouldReturnPersonApprovedWhenAllArgumentsAreOk() {
        Address address = Address.Builder.of()
            .zipCode("99999-000")
            .streetName("Aegon Targaryen")
            .number("AC 280")
            .build();
        Person person = Person.Builder.of()
            .name("Jon Snow")
            .age(25)
            .gender(Gender.MALE)
            .address(address)
            .build();

        ValidationResult result = executeValidation(person);

        assertEquals(OK, result);
    }

    @Test
    public void shouldReturnNameNotContainsSurnameWhenPersonNameDoesntHaveMoreThan1Word() {
        Address address = Address.Builder.of()
            .zipCode("99999-000")
            .streetName("Aegon Targaryen")
            .number("AC 280")
            .build();
        Person person = Person.Builder.of()
            .name("PersonWithoutSurname")
            .age(18)
            .gender(Gender.MALE)
            .address(address)
            .build();

        ValidationResult result = executeValidation(person);

        assertEquals(NAME_NOT_CONTAINS_SURNAME, result);
    }

    @Test
    public void shouldReturnPersonNameIsShortWhenNameHasNoMoreThan10Letters() {
        Address address = Address.Builder.of()
            .zipCode("99999-000")
            .streetName("Aegon Targaryen")
            .number("AC 280")
            .build();
        Person person = Person.Builder.of()
            .name("Jon Snow")
            .age(15)
            .gender(Gender.MALE)
            .address(address)
            .build();

        ValidationResult result = executeValidation(person);

        assertEquals(IS_NOT_AN_ADULT, result);
    }

    @Test
    public void shouldReturnPersonIsntAnAdultWhenAgeLessThanLegalAge() {
        Address address = Address.Builder.of()
            .zipCode("99999-000")
            .streetName("Aegon Targaryen")
            .number("AC 280")
            .build();
        Person person = Person.Builder.of()
            .name("Jon Snow")
            .age(15)
            .gender(Gender.MALE)
            .address(address)
            .build();

        ValidationResult result = executeValidation(person);

        assertEquals(IS_NOT_AN_ADULT, result);
    }

    @Test
    public void shouldReturnPersonGenderMustDefinedWhenGenderHasntBeenDefined() {
        Address address = Address.Builder.of()
            .zipCode("99999-000")
            .streetName("Aegon Targaryen")
            .number("AC 280")
            .build();
        Person person = Person.Builder.of()
            .name("Jon Snow")
            .age(18)
            .gender(null)
            .address(address)
            .build();

        ValidationResult result = executeValidation(person);

        assertEquals(GENDER_NOT_DEFINED, result);
    }

    @Test
    public void shouldReturnPersonAddressNotAllowedWhenAddressOnBlockedList() {
        Address addressNotAllowed = Address.Builder.of()
            .zipCode("88888-000")
            .streetName("Aegon Targaryen")
            .number("AC 280")
            .build();
        Person person = Person.Builder.of()
            .name("Jon Snow")
            .age(18)
            .gender(Gender.MALE)
            .address(addressNotAllowed)
            .build();

        ValidationResult result = executeValidation(person);

        assertEquals(ADDRESS_NOT_ALLOWED, result);
    }

    private ValidationResult executeValidation(Person person) {
        return nameContainsSurname()
            .and(isAnAdult())
            .and(isGenderDefined())
            .and(isAddressAllowed())
            .apply(person);
    }
}
