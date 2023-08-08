package Product.Util;

import Product.Product;
import Product.SubProduct.Drink;
import Product.SubProduct.Hamburger;
import Product.SubProduct.ProductData;
import Product.SubProduct.Side;

import java.util.Scanner;

public class PrintUtil {
    static Scanner sc = new Scanner(System.in);
    //스캐너를 필드로 생성


    public static String printInitialView(){
        System.out.println("🍔BurgerQueen Order Service");
        System.out.println("(1) 메뉴 선택");
        System.out.println("(2) 장바구니");
        System.out.println("(3) 할인 정보");
        System.out.println("(4) 프로그램 종료");

        return sc.nextLine();
    } //printInitialView() 종료


    public static int printMenu(ProductData product){
        // 메뉴 목록 출력
        // 입력된 Product 객체 목록 출력
        // 메뉴 목록 출력 후 메뉴 입력

        System.out.println("-".repeat(45));
        System.out.println("[🔻] 메뉴");
        System.out.println("-".repeat(45));
        //카테고리별 상품 정보 출력
        printProduct(product);

        System.out.println("-".repeat(45));
        System.out.print("메뉴 번호를 입력해주세요. = ");
        return Integer.parseInt(sc.nextLine()); // 메뉴 입력값 int형 반환
    } //printMenu 종료

    // 카테고리별 상품 정보 출력
    // 정보 저장 -> Product 클래스의 객체로 생성 ( ArrayList<Product> )
    // ArrayList 의 Product 객체를 카테고리별 분류
    // 분류된 Product 객체 출력

    private static void printProduct(ProductData product){
        // printProduct 메소드는 PrintUtil 클래스의 printMenu 메소드에서 사용됨
        // 외부에서 직접 사용하는 메소드가 아니라 private 형식으로 작성
        // 분류된 카테고리 정보 + 메뉴 출력
        // 햄버거
        // 햄버거 메뉴
        // 음료
        // 음료 메뉴
        // 사이드
        // 사이드 메뉴
        // 옵션
        // 옵션 메뉴
        printHamburgers(product);
        printDrink(product);
        printSide(product);
        printOption(product);
        System.out.printf("\n    (9) 주문 종료\n");

    }// printProduct 종료

    // 카테고리 구분 및 메뉴 출력

    private static void printHamburgers (ProductData productData){
        // printHamburgers 메소드는 PrintUtil 클래스의 printProduct 메소드에서 사용됨
        // 외부에서 직접 사용하는 메소드가 아니라 private 형식으로 작성
        System.out.println("🍔 햄버거");
        for (Hamburger hamburger : ProductData.getHamburgers()){
            // Hamburger 형 hamburger 변수로 리스트 순회
            // 리스트 = getHamburgers 메소드에서 만든 Hamburger 형 ArrayList
            // 출력
            printEachMenu(hamburger);
            // Hamburger 형 hamburger 변수로 순회하는 객체를 출력
            /*
            * printEachMenu(hamburger); 없이 셀프로 사용하는 경우
            * System.out.printf("    (%d) %-5s %5dKcal %5d원\\n\",",
                hamburger.getId(),hamburger.getName(),hamburger.getKcal(),hamburger.getCost());
            *
            * (위 내용이 카테고리별 제작)
            * */
        }
    }//printHamburgers 종료

    private static void printDrink (ProductData productData){
        System.out.println("🥤음료");
        for(Drink drink : ProductData.getDrinks()){
            printEachMenu(drink);

        }
    }//printDrink 종료

    private static void printSide (ProductData productData) {
        System.out.println("🍟사이드");
        for (Side side : ProductData.getSides()) {
            printEachMenu(side);
        }
    }//printSide 종료

    private static void printOption (ProductData productData){
        System.out.println("🥫옵션");
        for (Product product : productData.getOption()){
            printEachMenu(product);

        }
    }//printOption 종료

    //메뉴 출력용 메소드
    public  static  void  printEachMenu(Product product){
        // Product 객체를 받아서 getter 를 통해 정보 출력
        System.out.printf("   (%d) %-5s %5dKcal %5d원 \n ",
                product.getId(),product.getName(),product.getKcal(),product.getCost());
    }



} //class PrintUtil 종료
