package Product.Cart;

import Product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CartService {
    private final ArrayList<CartItem> items = new ArrayList<>();
    //주문한 메뉴를 담기 위한 CartItem 타입의 ArrayList 생성
    // ArrayList 필드도 private 타입 생성

    public ArrayList<CartItem> getItem(){
        //private 형으로 생성된 ArrayList items 를 위한 getter 생성
        return items;

    }
    public int getSumOfTotalPrice(){
        // 총액 계산을 위한 메소드
        int sum = 0;
        // 총액을 넣기 위한 변수
        for(CartItem cartItem : items){
            // CartItem 형의 cartItem 으로 items 배열 순회
            sum += cartItem.getTotalPrice();
            //배열을 순회하면서 cartItem에 포함된 items 배열의 totalprice를 sum에 누적 합
        }
        return  sum; //반환
    }//getSumOfTotalPrice  종료

    public Map<String, Object> addToCart(Product product, int count){
        items.add( new CartItem( product.getId(),
                product.getName(),
                product.getCost(),
                (int) product.getDiscountCost(),
                product.getRealCost(),
                count,product.getIsPercent())
                );
        //CartItem 형 items 배열에 CartItem 객체 생성하기
        // Product 형 자료들을 저장

        Map<String, Object> result = new HashMap<>();
        //Hashmap 제작

        result.put( "p_name",items.get (items.size()-1 ).getProductName());
        //hashmap에 items 리스트의 내용 중, (items 의 크기 -1) = 인덱스상 마지막 추가된 자료의 상품명
        result.put("p_count",items.get(items.size()-1).getCount());
        //hashmap에 items 리스트의 내용 중, (items 의 크기 -1) = 인덱스상 마지막 추가된 자료의 갯수


        return result;
    } //addToCart 종료

    public void deleteItem(int number) {
        items.remove(number - 1);
        // 장바구니에 저장된 메뉴
        // = CartItem 타입의 Items ArrayList
        // ArrayList 내용 삭제 > 리스트명.remove(인덱스)
        // 인덱스 = 0 부터 시작
        // number -1 로 인덱스와 숫자 위치 맞춰줌
        } //deleteItem 종료

    public void clearCart(){
        items.clear();
    } //clearItem 종료

}//public class CartService 종료
