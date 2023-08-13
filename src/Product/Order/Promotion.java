package Product.Order;

import Product.Cart.CartItem;

import java.util.ArrayList;
import java.util.Arrays;

public class Promotion {

    private   int PROMOTION_TYPE;
    private String PROMOTION_NAME;

    public  Promotion(int PROMOTION_TYPE, String PROMOTION_NAME) {
        this.PROMOTION_TYPE = PROMOTION_TYPE;
        this.PROMOTION_NAME = PROMOTION_NAME;
    }

    public Promotion() {
    }

    public int getPROMOTION_TYPE() {
        return PROMOTION_TYPE;
    }

    public String getPROMOTION_NAME() {
        return PROMOTION_NAME;
    }

    private static final ArrayList<Promotion> promotions = new ArrayList<>(Arrays.asList(
            new CozPromotion(1,"[프로모션] 아이스크림"),
            new KidPromotion(2,"[프로모션] 장난감"),
            new Promotion()
    ));

    public static Promotion findPromo(int id){
        //입력된 int 와 맞는 상품 매칭
        for (Promotion promotion : promotions){
            //Promotion 타입의 promotion promotions 순회
            if (promotion.getPROMOTION_TYPE() == id) return  promotion;
            //promotion 필드의 PROMOTION_TYPE 를 getId를 통해 가져와서 입력된 id와 매칭
        }
        return new Promotion();
    }



//    public CartItem apply(){
//
//        return null;
//    }
}
