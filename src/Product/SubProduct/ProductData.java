package Product.SubProduct;

import Product.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductData {



    // Product 타입의 ArrayList 생성
    // ArrayList<Product>
    // Product 타입 생성자
    // id, name, kcal,cost, isOption
    // 생성 방법 1
    // ArrayList<Product> products = new ArrayList<>();
    // product.acc(Product 타입 객체 )
    // 생성 방법 2
    // ArrayList<Product> products = new ArrayList<>(Arrays.asList(
    // 생성자, 생성자, 생성자 );
    //
    // 둘 다 ArrayList 에 저장

    private static final ArrayList<Product> products = new ArrayList<>(Arrays.asList(
            new Hamburger(1, "새우버거", 3500, 500, false),
            new Hamburger(2, "치킨버거", 4000, 600, false),
            new Side(3, "감자튀김", 1000, 300, false),
            new Side(4, "어니언링", 1000, 200, false),
            new Drink(5, "코카콜라", 1000, 300, false),
            new Drink(6, "제로콜라", 1000, 0, false),
            new Product(7, "케찹", 0, 100, true),
            new Product(8, "빨대", 0, 0, true))
            // 총 8개 객체
            // 상위클래스 - Product
            // 하위클래스 3종
    );


}
