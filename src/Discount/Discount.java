package Discount;

import Product.Product;

public class Discount {
    private int discountRate;
    private int discountFix;






    public int getDiscountRate() {
        return discountRate;
    }

    public Discount setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
        return this;
    }

    public int getDiscountFix() {
        return discountFix;
    }

    public Discount setDiscountFix(int discountFix) {
        this.discountFix = discountFix;
        return this;
    }
}
