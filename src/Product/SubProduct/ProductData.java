package Product.SubProduct;

import Product.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProductData {

    private static Scanner sc = new Scanner(System.in);




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
            new Hamburger(1, "새우버거", 3500, 500, false,discountCost(),false),
            new Hamburger(2, "치킨버거", 4000, 600, false,discountCost(),false),
            new Side(3, "감자튀김", 1000, 300, false,discountCost(),false),
            new Side(4, "어니언링", 1000, 200, false,discountCost(),false),
            new Drink(5, "코카콜라", 1000, 300, false,discountCostPercent(),true),
            new Drink(6, "제로콜라", 1000, 0, false,discountCostPercent(),true),
            new Product(7, "케찹", 0, 100, true,0,true),
            new Product(8, "빨대", 0, 0, true,0,true))
            // 총 8개 객체
            // 상위클래스 - Product
            // 하위클래스 3종
    );

//    public static void addMenu(){
//        System.out.println("카테고리를 선택합니다.");
//        System.out.println("(1)_햄버거   (2)_사이드   (3)_음료   (4)_옵션");
//        String input = sc.nextLine();
//        switch (input){
//            case "1":
//                addHamburger();
//            default:
//                System.out.println("잘못입력했습니다.");
//
//        }
//
//
//    }
//    private static void addHamburger(){
//        System.out.println("이름");
//        String name = sc.nextLine();
//        System.out.println("가격");
//        String cost = sc.nextLine();
//        System.out.println("칼로리");
//        String kcal = sc.nextLine();
////        products = new ArrayList<>(Arrays.asList(new Hamburger(0,name,Integer.parseInt(cost),Integer.parseInt(kcal),false,discountCost(),false)));
//        products.add()
//
//
//
//
//    }



    private static int discountCost(){
        return 500;

    }
    private static int discountCostPercent(){
        return 10;

    }


    public int ArsSze(){
        //products 의 총 메뉴 갯수
        // 메뉴 마지막 숫자 + 1 > 종료키
        return products.size();
    }


    public Product findById(int id){
        //입력된 int 와 맞는 상품 매칭
        for (Product product : products){
            //Product 타입의 product로 products 순회
            if (product.getId() == id) return  product;
            //product의 필드의 ID 를 getId를 통해 가져와서 입력된 id와 매칭
        }
        return null;
    }

    // 카테고리별 분류 필요

    public static ArrayList<Hamburger> getHamburgers() {
        // getHambergur 메소드는 PrintUtil 클래스의 printHamburgers 메소드에서 사용
        // 외부 클래스에서 사용하기 위해 public 사용
        // 메뉴 저장 -> ArrayList<Product> ( Product 형의 ArrayList )
        // ArrayList 에서 Hamburger 생성자만 구분 필요
        // Hamburger extends Product ( 상속으로 Product 타입의 Hamburger 객체 생성 )
        ArrayList<Hamburger> hamburgers = new ArrayList<>();
        // Product 객체 중 Hamburger 객체만 모아서 새로운 ArrayList 생성
        for (Product product : products) { // 메뉴 정보가 포함된 products 객체 순회
            if (product instanceof Hamburger) {
                hamburgers.add((Hamburger) product);
            }
            //instanceof : 인스턴스 형이 맞는지 유무
            // Products 객체를 순회하는 product 의 자료가 Hamburger 의 인스턴스형이 맞는지 체크
            // true : 새로 생성한 hamburgers ArrayList에 add로 더한다.
            // product 는 기본적으로 Product 형의 자료이기에 Hamburger 로 형 변환 ( 다운캐스팅 ) 해준다.
        }
        return hamburgers; //<Hamburger>타입 의 객체가 저장된 ArrayList인 hamburgers 반환
    }//getHamburgers 종료

    // 위와 동일하게 Drink 와 Side 진행

    public static ArrayList<Side> getSides() {
        ArrayList<Side> sides = new ArrayList<>();
        for (Product product : products) {
            if (product instanceof Side) {
                sides.add((Side) product);
            }
        }
        return sides;
    }//getSides종료

    public static ArrayList<Drink> getDrinks() {
        ArrayList<Drink> drinks = new ArrayList<>();
        for (Product product : products) {
            if (product instanceof Drink) drinks.add((Drink) product);
        }return drinks;
    }//getDrinks 종료

    public static ArrayList<Product> getOption(){
        ArrayList<Product> option = new ArrayList<>();
        for (Product product : products){
            if (product.isOption()) option.add(product);
            // 옵션 카테고리는 별도의 클래스 를 만들어서 상속하지 않아서 Product 클래스의 객체
            // 옵션 식별을 위해 Product 생성자의 boolean isOption 이 true 인 값만 식별 후 ArrayList에 저장
            // 다른 카테고리와 다르게 옵션은 Product객체 그 자체라서 (업/다운캐스팅 X)
            // 그대로 새로 만든 ArrayList option 에 add 해준다.
        }
        return  option;
    } // getOption 종료
    public static ArrayList<Product> getDisconutInfo(){
        // 할인 정보 반환을 위한 메소드 생성
        // PrintUtil에서 사용하기 위해 public 사용
        ArrayList<Product> discount = new ArrayList<>();
        //Product 형의 ArrayList를 받기 위한 ArrayList 생성
        for (Product product : products){
            //Product 형의 ArrayList 순회
            if (product.getDiscountCost()!=0){
                // product 객체의 할인액 (getDiscountCost)이  0이 아닌 경우 출력
            discount.add(product);}
            // 조건에 맞는 자료를 새로 만든 ArrayList에 저장한다.
        }
        return discount;
        // 저장된 할인 가능 상품의 ArrayList를 반환
    }



}
