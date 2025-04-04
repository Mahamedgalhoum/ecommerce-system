package model;

public class NonShippableProduct extends Product {
    public NonShippableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isAvailable() {
        return false;
    }
}
