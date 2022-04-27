package com.marlonklc.designpatterns.extras.CombinatorPattern;

import org.springframework.util.Assert;

public class Person {

    private String fullName;
    private Integer age;
    private Gender gender;
    private Address address;

    private Person(String fullName, Integer age, Gender gender, Address address) {
        Assert.hasText(fullName, "Name cannot me empty.");
        Assert.notNull(address, "Age must be defined.");
        Assert.notNull(address, "Gender must be defined.");
        Assert.notNull(address, "Address must be defined.");
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Address getAddress() {
        return address;
    }

    public static final class Builder {
        private String name;
        private Integer age;
        private Gender gender;
        private Address address;

        private Builder() {
        }

        public static Builder of() {
            return new Builder();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(name, age, gender, address);
        }
    }
}
