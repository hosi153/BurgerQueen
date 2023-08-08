package Product.Cart;

public class CartItem {
    //상품 고유 번호, 상품 이름, 가격, 수량, 금액(수량 * 가격)

    //필드 - private
    private final int productId;
    private final String productName;
    private final int cost;
    private final int count;
    private final int totalPrice;

    // 장바구니 구현을 위한 생성자 제작

    public CartItem (int productId, String productName, int cost, int count){
        this.productId = productId;
        this.productName=productName;
        this.cost=cost;
        this.count=count;
        this.totalPrice = cost*count; // 총 금액은 생성자로 입력받지 않고 자체 계산

    }


    //private 필드를 위한 getter 생성
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
