package Product.Order;

import Product.Cart.CartItem;

import java.util.ArrayList;

public class Order {

//    필드 : int orderId, ArrayList cartItems, int paymentPrice, Promotion promotion
//    void addPromotion() : 프로모션 사은품을 cartItems에 추가
//    int calculatePaymentPrice() : 최종 결제 금액 계산
//    int getOrderId() : orderId에 대한 Getter
//    int getPaymentPrice() : paymentPrice에 대한 Getter
//    ArrayList getCartItems() : cartItems에 대한 Getter




    private final   int orderId;
    private final ArrayList<CartItem> cartItems = new ArrayList<>();
    private final int paymentPrice;
    private final Promotion promotion;


    public Order(int orderId, int paymentPrice, Promotion promotion) {
        this.orderId = orderId;
        this.paymentPrice = paymentPrice;
        this.promotion = promotion;
    }

    public int getOrderId() {
        return orderId;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public int getPaymentPrice() {
        return paymentPrice;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void addPromotion(){

    }
//    public int calculatePaymentPrice(){
//
//    }

}
