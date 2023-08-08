package Product.Cart;

import Product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CartService {


    private final ArrayList<CartItem> items = new ArrayList<>();

    public ArrayList<CartItem>getItems(){
        return items;
    }

    public int getSumOfTotalPrice(){
        int sum = 0;
        for(CartItem cartItem : items){
            sum += cartItem.getTotalPrice();
        }
        return  sum;
    }


    //장바구니에 상품을 추가하는 메서드 -> addToCart();
    // 상품 * 수량
    // 성공적으로 상품이 추가되었다면, 추가된 상품의 정보를 burgeraueen쪽으로 돌려준다.
    // 출력 : burgerqueen에서
    //  반환타입, 파라미터를 명확하게
    // Map { p_name : 새우버거, p_count : 3 }


    public Map<String, Object > addToCart(Product product, int count){
        items.add(
                new CartItem(
                        product.getId(),
                        product.getName(),
                        product.getCost(),
                        count
                )
        );

        Map<String,Object> result = new HashMap<>();
        result.put("p_name",items.get(items.size()-1).getProductName());
        result.put("p_count",items.get(items.size()-1).getCount());

        return result;

    }
    //이름 수량


    public void deleteItem(int number){
        items.remove(number-1);

    }

    public void clearCart(){
        items.clear();
    }

}
