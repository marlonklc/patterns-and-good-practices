package com.marlonklc.designpatterns.extras.FluentInterface.domain;

public class DiscountCoupon {

    private Double value;

    private DiscountCoupon(Double value) {
        this.value = value;
    }

    public static DiscountCoupon of(Double value) {
        return new DiscountCoupon(value);
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "DiscountCoupon{" +
                "value=" + value +
                '}';
    }
}
