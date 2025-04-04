package model;

import java.time.Instant;
import java.time.LocalDate;

public class ExpirableProduct extends Product {
    private LocalDate expiryDate;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }
    @Override
    public boolean isAvailable() {
        return quantity > 0 && expiryDate.isAfter(LocalDate.now());
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}

