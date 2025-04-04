package service;

import model.Shippable;

import java.util.List;

public class ShippingService {
    public void shipItems(List<Shippable> items) {
        System.out.println("** Shipment Notice **");
        double totalWeight = 0;
        for (Shippable item : items) {
            System.out.println(item.getName() + " - " + item.getWeight() + " kg");
            totalWeight += item.getWeight();
        }
        System.out.println("Total package weight: " + totalWeight + " kg");
    }
}
