package service;

import model.Cart;
import model.Product;

public class CartTotalCalculator {

    private static final double SHIPPING_FEE_PER_KG = 10.0;

    public double calculateSubtotal(Cart cart) {
        double subtotal = 0;
        for (Product product : cart.getItems().keySet()) {
            int quantity = cart.getItems().get(product);
            subtotal += product.getPrice() * quantity;
        }
        return subtotal;
    }

    public double calculateShippingCost(Cart cart) {
        double totalWeight = 0;
        for (Product product : cart.getItems().keySet()) {
            int quantity = cart.getItems().get(product);
            if (product instanceof model.Shippable) {
                totalWeight += ((model.Shippable) product).getWeight() * quantity;
            }
        }
        return totalWeight * SHIPPING_FEE_PER_KG;
    }

    public double calculateTotalAmount(Cart cart) {
        double subtotal = calculateSubtotal(cart);
        double shippingCost = calculateShippingCost(cart);
        return subtotal + shippingCost;
    }
}
