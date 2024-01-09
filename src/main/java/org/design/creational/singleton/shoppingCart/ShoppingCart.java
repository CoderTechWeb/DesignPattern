package org.design.creational.singleton.shoppingCart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {

    private static volatile ShoppingCart instance;

    private ShoppingCart() {
    }

    List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public static ShoppingCart getInstance() {
        if(instance == null) {
            synchronized (ShoppingCart.class) {
                if (instance == null) {
                    instance = new ShoppingCart();
                }
            }
        }
        return instance;
    }
}
