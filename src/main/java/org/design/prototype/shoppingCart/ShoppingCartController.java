package org.design.prototype.shoppingCart;

public class ShoppingCartController {

    public static void main(String[] args) {
        ShoppingCart shoppingCart = createShoppingCart();
        addItemToCart(shoppingCart, "1");
        viewCart(shoppingCart);

        ShoppingCart shoppingCart2 = createShoppingCart();
        addItemToCart(shoppingCart2, "2");
        viewCart(shoppingCart2);
    }
    private static ShoppingCart createShoppingCart() {
        return new ShoppingCart();
    }
    private static void addItemToCart(ShoppingCart shoppingCart, String itemId) {
        Item item = getItemById(itemId);
        shoppingCart.addItem(item);
    }
    private static void viewCart(ShoppingCart shoppingCart) {
        System.out.println("Items in the cart:");
        for (Item item : shoppingCart.getItems()) {
            System.out.println(item.getId() + " : " +item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + shoppingCart.calculateTotal());
    }
    private static Item getItemById(String itemId) {
        // Logic to retrieve an item by ID from a database or another source
        // For simplicity, a placeholder method is used here
        return new Item(itemId, "Sample Item", 10.0);
    }
}
