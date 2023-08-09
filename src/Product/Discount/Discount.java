package Product.Discount;

public class Discount {

    private String productName;
    private int discountCost;
    private double discountCostPercent;

    public Discount(String productName, int discountCost){
        this.productName = productName;
        this.discountCost = discountCost;
    }

    public Discount(String productName, double discountCostPercent){
        this.productName= productName;
        this.discountCostPercent = discountCostPercent;
    }

    public String getProductName() {
        return productName;
    }

    public int getDiscountCost() {
        return discountCost;
    }

    public double getDiscountCostPercent() {
        return discountCostPercent;
    }
}
