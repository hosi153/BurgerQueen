package Util;

import Cart.Cart;
import Product.Product;
import Product.ProductData;
import Product.Hamburger;
import Product.Drink;
import Product.Side;

import java.util.Scanner;

public class PrintUtil {

    private static Scanner sc = new Scanner(System.in);
    private static String input;
    ProductData productData = new ProductData();


    public static int printMainMenu() {
        System.out.println("🍔버거퀸 - CHG.Ver🍔");
        System.out.println("(1) 메뉴 선택");
        System.out.println("(2) 장바구니");
        System.out.println("(3) 할인 정보");
        System.out.println("(4) 상품 주문");
        System.out.println("(5) 프로그램 종료");

        return Integer.parseInt(input = sc.next());
    }

    //장바구니

    public static void printCart() {
        System.out.println("[🧺]장바구니");
        System.out.println("-".repeat(50));
        System.out.println("No\t\t상품명\t\t단가\t\t할인금액\t소비자가\t\t수량\t\t금액");
        printCartMenu();
        System.out.println("-".repeat(50));
        System.out.println("합계 : " + Cart.totalPrice() + "원");


    }
    public static int orderNumber(){
        int num = (int) (Math.random() * 100 + 1);
        return num;
    }


    public static void printOrder() {

        System.out.println("주문 번호 : " + orderNumber());
        System.out.println("-".repeat(45));
        System.out.println("[주문 상품]");
        System.out.println("\t 상품명 \t\t\t\t단가\t\t수량\t\t금액");
        orderList();
        System.out.println("-".repeat(45));
        System.out.println("결제 금액 : " + Cart.totalPrice() + "원");
    }

    private static void orderList() {
        for (Cart cart : Cart.carts) {
            System.out.printf("%10s\t\t\t%2d\t\t%2d\t\t%2d\n",
                    cart.getProductName(),
                    cart.getRealCost(),
                    cart.getCount(),
                    cart.getPrice()
            );
        }
    }


    private static void printCartMenu() {
        int number = 1;
        for (Cart cart : Cart.carts) {
            System.out.printf("%d\t\t%5s\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n",
                    number++,
                    cart.getProductName(),
                    cart.getCost(),
                    cart.getDiscount(),
                    cart.getRealCost(),
                    cart.getCount(),
                    cart.getPrice());
        }
    }


    // 메뉴 선택
    public static int printMenu(ProductData productData) {
        System.out.println("[🔻] 메뉴");
        System.out.println("-".repeat(50));
        printHamburger(productData);
        printSide(productData);
        printDrink(productData);
        printOption(productData);
        System.out.printf("\t(%s) 주문 종료\n", ProductData.menuSize() + 1);
        System.out.println("-".repeat(50));
        System.out.print("메뉴 번호를 입력해주세요. : ");

        return sc.nextInt();

    }

    private static void printMenu(Product product) {
        System.out.printf("\t(%d)\t\t%s\t\t%s kcal\t%s 원\n",
                product.getId(), product.getName(), product.getKcal(), product.getCost());
    }

    private static void printHamburger(ProductData productData) {
        System.out.println("🍔햄버거");
        for (Hamburger product : ProductData.getHamburgers()) {
            printMenu(product);
        }
        System.out.println();
    }

    private static void printSide(ProductData productData) {
        System.out.println("🍟사이드");
        for (Side product : ProductData.getSide()) {
            printMenu(product);
        }
        System.out.println();

    }

    private static void printDrink(ProductData productData) {
        System.out.println("🥤음료");
        for (Drink product : ProductData.getDrink()) {
            printMenu(product);
        }
        System.out.println();

    }

    private static void printOption(ProductData productData) {
        System.out.println("🥫옵션");
        for (Product product : ProductData.getOption()) {
            printMenu(product);
        }
        System.out.println();

    }

    public static String hiddenMenu(){
        System.out.println("(1) 메뉴 추가");
        System.out.println("(2) 할인 금액 변경");
        System.out.println("(3) 복귀");

        return sc.nextLine();

    }
    public static void discountChange(){
        String choice;
        System.out.println("변경할 할인을 고르시오");
        System.out.println("(1)정액 할인 변경 (2)할인 비율 변경");
        choice = sc.nextLine();
        switch (choice){
            case "1":
                ProductData.changeProductDiscount();
                break;
            case "2":
                ProductData.changeProductDiscountRate();
                break;
            default:
                System.out.println("잘 못 입력 했습니다.");
                discountChange();
        }


    }


}
