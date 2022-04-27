package com.marlonklc.designpatterns.extras.FluentInterface.domain;

public class Salesman {

    private String name;
    private String taxid;

    private Salesman(String name, String taxid) {
        this.name = name;
        this.taxid = taxid;
    }

    public static Salesman of(String name, String taxid) {
        return new Salesman(name, taxid);
    }

    public Sale sell() {
        return new Sale(this);
    }

    public String getName() {
        return name;
    }

    public String getTaxid() {
        return taxid;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "name='" + name + '\'' +
                ", taxid='" + taxid + '\'' +
                '}';
    }
}
