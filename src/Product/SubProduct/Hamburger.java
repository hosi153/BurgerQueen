package Product.SubProduct;

import Product.Product;

public class Hamburger extends Product {
    public Hamburger(int id, String name, int cost, int kcal, boolean isOption, int discountCost, boolean isPercent) {
        super(id, name, cost, kcal, isOption, discountCost, isPercent);
    }
}
