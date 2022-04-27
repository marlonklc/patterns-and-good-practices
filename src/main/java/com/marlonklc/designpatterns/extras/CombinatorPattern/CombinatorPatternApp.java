package com.marlonklc.designpatterns.extras.CombinatorPattern;

import static com.marlonklc.designpatterns.extras.CombinatorPattern.PersonValidator.isAddressAllowed;
import static com.marlonklc.designpatterns.extras.CombinatorPattern.PersonValidator.isAnAdult;
import static com.marlonklc.designpatterns.extras.CombinatorPattern.PersonValidator.isGenderDefined;
import static com.marlonklc.designpatterns.extras.CombinatorPattern.PersonValidator.nameContainsSurname;

public class CombinatorPatternApp {

    public static void main(String[] args) {
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

        ValidationResult result = nameContainsSurname()
            .and(isAnAdult())
            .and(isGenderDefined())
            .and(isAddressAllowed())
            .apply(person);

        System.out.println(result.getMessage());
    }
}
