package com.marlonklc.designpatterns.extras.FluentInterface.domain;

import java.math.BigDecimal;

public class Sale {

    private Salesman salesman;
    private Client client;
    private DiscountCoupon discountCoupon;
    private Products products;

    public Sale(Salesman salesman) {
        this.salesman = salesman;
        this.products = Products.of();
    }

    public Sale toClient(String clientName) {
        this.client = Client.of(clientName);
        return this;
    }

    public Sale withDiscount(Double value) {
        this.discountCoupon = DiscountCoupon.of(value);
        return this;
    }

    public Sale product(String productName, Double productValue) {
        Product product = new Product(productName, productValue);
        this.products.add(product);
        return this;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public Client getClient() {
        return client;
    }

    public DiscountCoupon getDiscountCoupon() {
        return discountCoupon;
    }

    public Products getProducts() {
        return products;
    }

    public Integer totalOfProducts() {
        return this.products.getProducts().size();
    }

    public Double totalValueOfSale() {
        return this.products.getProducts().stream()
            .map(Product::getValue)
            .reduce(0d, Double::sum);
    }

    public Double discountCoupon() {
        return this.discountCoupon.getValue();
    }

    public Double totalValueOfSaleMinusDiscount() {
        Double totalValue = totalValueOfSale();
        return totalValue - this.discountCoupon.getValue();
    }

    @Override
    public String toString() {
        return "Sale{" +
                "salesman=" + salesman +
                ", client=" + client +
                ", discountCoupon=" + discountCoupon +
                ", products=" + products +
                '}';
    }
}
