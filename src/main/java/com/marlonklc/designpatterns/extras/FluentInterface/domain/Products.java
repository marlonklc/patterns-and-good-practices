package com.marlonklc.designpatterns.extras.FluentInterface.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Products {

    private List<Product> products;

    private Products() {
        this.products = new ArrayList<>();
    }

    public static Products of() {
        return new Products();
    }

    public void add(Product product) {
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public String toString() {
        return "Products{" +
                "products=" + products +
                '}';
    }
}
