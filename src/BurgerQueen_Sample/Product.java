package BurgerQueen_Sample;



public class Product {

    private int id; //식별 고유 번호
    private String name;
    private int cost;
    private int Kcal;
    private boolean isOption;

    public int getId() {
        return id;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public int getCost() {
        return cost;
    }

    public Product setCost(int cost) {
        this.cost = cost;
        return this;
    }

    public int getKcal() {
        return Kcal;
    }

    public Product setKcal(int kcal) {
        Kcal = kcal;
        return this;
    }

    public Product setOption(boolean option) {
        isOption = option;
        return this;
    }

    public Product(int id, String name, int cost, int kcal, boolean isOption) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        Kcal = kcal;
        this.isOption = isOption;
    }
    public boolean isOption() {
        return isOption;
    }



}


