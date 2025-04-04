import model.*;
import service.CartTotalCalculator;
import service.CheckoutService;

import java.time.LocalDate;

public class ECommerceApp {
    public static void main(String[] args) {
        Customer customer = new Customer("Mohamed Said Galhoum", 2000.0);

        Product cheese = new ExpirableProduct("Cheese", 100, 5, LocalDate.now().plusDays(10));
        Product tv = new ShippableProduct("TV", 500, 3, 10);
        Product mobile = new NonShippableProduct("Mobile", 300, 10);

        Cart cart = new Cart();
        cart.addProduct(cheese, 2);
        cart.addProduct(tv, 1);
        cart.addProduct(mobile, 1);

        CheckoutService checkoutService = new CheckoutService(new CartTotalCalculator());

        checkoutService.checkout(customer, cart);
    }
}
