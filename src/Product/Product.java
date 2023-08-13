package Product;

public class Product {


    private int id;
    private String name;
    private String category;
    private int cost;
    private int kcal;
    private boolean isOption;
    private int discount;
    private boolean isDiscount;


    public Product(int id, String name, String category, int cost, int kcal, boolean isOption) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.cost = cost;
        this.kcal = kcal;
        this.isOption = isOption;
    }

    public Product(int id, String name, String category, int cost, int kcal, boolean isOption, int discount, boolean isDiscount) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.cost = cost;
        this.kcal = kcal;
        this.isOption = isOption;
        this.discount = discount;
        this.isDiscount = isDiscount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getCost() {
        return cost;
    }

    public int getKcal() {
        return kcal;
    }

    public boolean isOption() {
        return isOption;
    }

    public int getDiscount() {
        return discount;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public Product setDiscount(int discount) {
        this.discount = discount;
        return this;
    }
}
