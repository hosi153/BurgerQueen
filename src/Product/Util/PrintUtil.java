package Product.Util;

import Product.Cart.CartItem;
import Product.Product;
import Product.SubProduct.Drink;
import Product.SubProduct.Hamburger;
import Product.SubProduct.ProductData;
import Product.SubProduct.Side;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintUtil {
    static Scanner sc = new Scanner(System.in);
    //스캐너를 필드로 생성


    public static String printInitialView() {
        System.out.println("🍔BurgerQueen Order Service");
        System.out.println("(1) 메뉴 선택");
        System.out.println("(2) 장바구니");
        System.out.println("(3) 할인 정보");
        System.out.println("(4) 프로그램 종료");

        return sc.nextLine();
    } //printInitialView() 종료


    public static int printMenu(ProductData product) {
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

    private static void printProduct(ProductData product) {
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
        printSide(product);
        printDrink(product);
        printOption(product);
        System.out.printf("\n    (9) 주문 종료\n");

    }// printProduct 종료

    // 카테고리 구분 및 메뉴 출력

    public static String printDiscount() {
        System.out.println("상품 할인 정보");
        for (Product product : ProductData.getDisconutInfo()) {

            System.out.printf("  %5s \t", product.getName());

            if (product.getIsPercent()) {
                System.out.printf("%d%%\t 할인 \n", product.getDiscountCost());
            } else {
                System.out.printf("%d원 할인 \n", product.getDiscountCost());
            }

        }
        System.out.println("(1) 홈으로 돌아가기");
        return sc.nextLine();
    }

    private static void printHamburgers(ProductData productData) {
        // printHamburgers 메소드는 PrintUtil 클래스의 printProduct 메소드에서 사용됨
        // 외부에서 직접 사용하는 메소드가 아니라 private 형식으로 작성
        System.out.println("🍔 햄버거");
        for (Hamburger hamburger : ProductData.getHamburgers()) {
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

    private static void printDrink(ProductData productData) {
        System.out.println("🥤음료");
        for (Drink drink : ProductData.getDrinks()) {
            printEachMenu(drink);

        }
    }//printDrink 종료

    private static void printSide(ProductData productData) {
        System.out.println("🍟사이드");
        for (Side side : ProductData.getSides()) {
            printEachMenu(side);
        }
    }//printSide 종료

    private static void printOption(ProductData productData) {
        System.out.println("🥫옵션");
        for (Product product : productData.getOption()) {
            printEachMenu(product);

        }
    }//printOption 종료

    //메뉴 출력용 메소드
    public static void printEachMenu(Product product) {
        // Product 객체를 받아서 getter 를 통해 정보 출력
        System.out.printf("   (%d) %-5s %5dKcal %5d원 \n",
                product.getId(), product.getName(), product.getKcal(), product.getCost());
    }//printEachMenu 종료


    public static String printCart(ArrayList<CartItem> items, int sumOfTotalPrice) { // CartItem이 담겨있는 ArrayList 사용, 전게 가격을 위한 int 사용
        // BurgerQueen 클래스에서 사용할 메소드로 public 선택
        //

        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(45));
        System.out.println("No  상품명\t\t단가\t\t할인금액\t소비자가\t  수량\t  금액");
        //장바구니 내부 메뉴 출력

        printCartItem(items);

        System.out.println("-".repeat(45));
        System.out.printf("합계 : %d 원\n", sumOfTotalPrice);

        System.out.println("(1) 홈으로 돌아가기");
        System.out.println("(2) 상품 삭제");
        System.out.println("(3) 장바구니 비우기");
        System.out.println("(4) 장바구니 상품 주문");
        System.out.println("(5) 프로그램 종료");

        return sc.nextLine();
        //장바구니를 보고 결정된 입력값을 반환
    } //printCart 종료

    private static void printCartItem(ArrayList<CartItem> items) {
        //장바구니 정보를 받아와서 상품 정보를 출력

        int number = 1;
        // 좌측 장바구니 넘버

        for (CartItem cartItem : items) {
            // CartItem 형의 cartItem 으로 items 순회
            System.out.printf("%d  %-8s %6d원 ",
                    number++,                   //번호
                    cartItem.getProductName(),  //이름
                    cartItem.getCost()         //단가
                    ); //순회하는 cartItem 필드 출력
            if (cartItem.isPercent()) {
                System.out.printf("%6d원", (cartItem.getDiscountCost() * cartItem.getCost() / 100));
            } else {
                System.out.printf("%6d원", cartItem.getDiscountCost());
            }
            System.out.printf(" %6d원 %6d %6d원\n",
                    cartItem.getRealCost(),     //소비자가
                    cartItem.getCount(),        //수량
                    cartItem.getTotalPrice()    //총액
                    ); //순회하는 cartItem 필드 출력
        }
    }//printCartItem종료


} //class PrintUtil 종료
