package Product.SubProduct;

import Product.Product;

public class Drink extends Product {
    //음료 메뉴 작성을 위한 class 생성
    // Product 클래스 상속
    // Product 타입의 음료 자료 생성

    public Drink(int id, String name, int cost, int kcal, boolean isOption){
        super(id,name,cost,kcal,isOption); //Product 메뉴의 생성자 상속
        //super로 Product 생성자 및 파리미터 그대로 사용
    }


}
