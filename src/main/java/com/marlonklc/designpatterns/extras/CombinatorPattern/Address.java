package com.marlonklc.designpatterns.extras.CombinatorPattern;

import org.springframework.util.Assert;

public class Address {

    private String zipCode;
    private String streetName;
    private String number;

    private Address(String zipCode, String streetName, String number) {
        Assert.hasText(zipCode, "zipCode cannot be empty.");
        Assert.hasText(streetName, "streetName cannot be empty.");
        Assert.hasText(number, "number cannot be empty.");
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getNumber() {
        return number;
    }

    public static final class Builder {
        private String zipCode;
        private String streetName;
        private String number;

        private Builder() {
        }

        public static Builder of() {
            return new Builder();
        }

        public Builder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder streetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Address build() {
            return new Address(zipCode, streetName, number);
        }
    }
}
