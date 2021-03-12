package ru.job4j.oop;

import java.lang.String;
import java.lang.Math;

class LiquidationProduct extends Product {
    private String name;
    private Product product;

    public LiquidationProduct(String name, int price) {
        this.product = new Product(name, price);
    }

    public String label() {
        return product.label();
    }
}
