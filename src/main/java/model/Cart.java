package model;

import error.OutOfStockException;
import error.ProductExpiredException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        if (product instanceof ExpirableProduct) {
            ExpirableProduct expirableProduct = (ExpirableProduct) product;
            if (expirableProduct.getExpiryDate().isBefore(LocalDate.now())) {
                throw new ProductExpiredException("Product " + product.getName() + " is expired.");
            }
        }
        if (product.getQuantity() < quantity) {
            throw new OutOfStockException("Not enough stock for " + product.getName());
        }

        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        double shippingFees = 30.0;
        total += shippingFees;
        return total;
    }
    public Map<Product, Integer> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
