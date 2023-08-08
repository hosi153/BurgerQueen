package Product.Cart;

public class CartItem {


    //상품 고유번호, 상품 이름, 개당 단가, 수량, 금액 (단가 * 수량)

    private final int productId;
    private final String productName;
    private final int cost;
    private final int count;
    private final int totalPrice;

    public CartItem(int productId, String productName, int cost, int count) {
        this.productId = productId;
        this.productName = productName;
        this.cost = cost;
        this.count = count;
        this.totalPrice = cost * count;
    }


    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getCost() {
        return cost;
    }

    public int getCount() {
        return count;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
