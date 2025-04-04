package model;

import java.util.Map;

public class Order {
    private Customer customer;
    private Map<Product, Integer> items;
    private double subtotal;
    private double shippingCost;
    private double totalAmount;
    private boolean isPaid;

    public Order(Customer customer, Map<Product, Integer> items, double subtotal, double shippingCost) {
        this.customer = customer;
        this.items = items;
        this.subtotal = subtotal;
        this.shippingCost = shippingCost;
        this.totalAmount = subtotal + shippingCost;
        this.isPaid = false;
    }


    public void processPayment() {
        if (customer.getBalance() < totalAmount) {
            throw new IllegalArgumentException("Insufficient balance for payment.");
        }
        customer.deductBalance(totalAmount);
        this.isPaid = true;
    }

    public void printOrderDetails() {
        System.out.println("** Order Details **");
        System.out.println("Customer: " + customer.getName());
        items.forEach((product, quantity) -> {
            System.out.println(product.getName() + " x " + quantity + " - " + (product.getPrice() * quantity));
        });
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shippingCost);
        System.out.println("Total: " + totalAmount);
    }

    public boolean isPaid() {
        return isPaid;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }
}
