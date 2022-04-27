package com.marlonklc.designpatterns.extras.FluentInterface;

import com.marlonklc.designpatterns.extras.FluentInterface.domain.Sale;
import com.marlonklc.designpatterns.extras.FluentInterface.domain.Salesman;

public class FluentInterfaceApp {

    public static void main(String[] args) {
        Sale sale = Salesman.of("Heisenberg", "01234567890")
            .sell()
            .toClient("Bad man")
            .product("Flour", 15000.54)
            .product("Bluish stone", 50000.99)
            .withDiscount(500d);

        System.out.println("--- Sale #" + Math.round(Math.random() * 999999999));
        System.out.println("salesman: " + sale.getSalesman());
        System.out.println("client: " + sale.getClient());
        System.out.println("products: " + sale.getProducts());
        System.out.println("total of products: " + sale.totalOfProducts());
        System.out.println("sale total value: " + sale.totalValueOfSale());
        System.out.println("discount coupon: " + sale.discountCoupon());
        System.out.println("sale total value minus discount: " + sale.totalValueOfSaleMinusDiscount());
        System.out.println("--------------------------");
    }
}
