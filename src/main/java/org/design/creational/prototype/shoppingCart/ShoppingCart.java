package org.design.creational.prototype.shoppingCart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {

    public ShoppingCart() {
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
}
