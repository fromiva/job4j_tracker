package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (; index + 1 < products.length; index++) {
            products[index] = products[index + 1];
        }
        products[index] = null;
        return products;
    }
}
