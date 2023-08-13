package Cart;

import Product.ProductData;
import Product.Product;

import java.util.ArrayList;

public class Cart {


    private int id;
    private String productName;
    private int cost;
    private int discount;
    private int realCost;
    private int count;
    private int price;

    public Cart(String productName, int cost, int count){
        this.productName = productName;
        this.cost = cost;
        this.count = count;
    }

    public Cart(int id , String productName, int cost, int discount, int count) {
        this.id = id;
        this.productName = productName;
        this.cost = cost;
        this.discount = discount;
        this.realCost = cost - discount;
        this.count = count;
        this.price = realCost * count;
    }


    public static ArrayList<Cart> carts = new ArrayList<>();
    public static void addCarts(Product product , int count){
        ProductData.discount();
        carts.add(
                new Cart(
                        product.getId(),
                        product.getName(),
                        product.getCost(),
                        product.isDiscount() ? product.getDiscount() : product.getDiscount()*product.getCost()/100,
                        count
                )
        );


    }




    public static int totalPrice(){
        int price = 0;
        for (Cart cart : carts){
            price+= cart.price;
        }
        return price;
    }

    public static void cartDelete(int num){
        carts.remove(num-1);
    }
    public static void cartClear(){
        carts.clear();
    }











    public String getProductName() {
        return productName;
    }

    public int getCost() {
        return cost;
    }

    public int getDiscount() {
        return discount;
    }

    public int getRealCost() {
        return realCost;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }


}
