package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private String name;
    private String category;
    private double price;

    public void discount(double percent) {
        price = (price - ((percent * price) / 100));
    }
}