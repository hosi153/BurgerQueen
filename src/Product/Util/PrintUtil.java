package Product.Util;

import Product.Cart.CartItem;
import Product.Product;
import Product.SubProduct.*;


import java.util.ArrayList;
import java.util.Scanner;



public class PrintUtil {


    static Scanner sc = new Scanner(System.in);

    public static String  printInitialView(){
        System.out.println("🍔BurgerQueen order Service");
        System.out.println("(1) 메뉴 선택");
        System.out.println("(2) 장바구니");
        System.out.println("(3) 할인 정보");
        System.out.println("(4) 프로그램 종료");


        return sc.nextLine();
    }

    public static int printMenu(ProductData product){
        System.out.println("-".repeat(40));
        System.out.println("[🔻] 메뉴");
        System.out.println("-".repeat(40));
        //카테고리별 상품 출력
        printProducts(product);
        System.out.println("-".repeat(40));
        System.out.print("메뉴 번호를 입력해주세요. : ");
        return Integer.parseInt(sc.nextLine());

    }
    /*
     *
     * ProductData 에서 정보 분류 후 정보 전햄
     *
     */

    private static void printProducts(ProductData product){

        printHamburgers(product);
        printDrink(product);
        printSide(product);
        printOption(product);
        System.out.printf("\n    (9) 주문 종료\n");
    }
    private static void printHamburgers(ProductData product){
        System.out.println("햄버거");
        for (Hamburger hamburger :
                product.getHamburgers()) {
            printEachMenu(hamburger);






            //출력
        }
    }
    private static void printDrink (ProductData product){
        System.out.println("음료");
        for(Drink drink : product.getDrink()){
            printEachMenu(drink);
        }

    }
    private static void printSide(ProductData product){
        System.out.println("사이드");
        for(Side side : product.getSide()){
            printEachMenu(side);

        }

    }
    private static void printOption(ProductData product){
        System.out.println("옵션");
        for (Product products :
                product.getOption()) {
            printEachMenu(products);


        }

    }

    public static void printEachMenu(Product product){
        System.out.printf("    (%d) %-5s %5dKcal %5d원\n",
                product.getId(),product.getName(),product.getKcal(),product.getCost());
    }

    public static String printCart(ArrayList<CartItem> items, int sumOfTotalPrice){
        //장바구니 상품, + 기능 출력

        System.out.println("장바구니");
        System.out.println("-".repeat(40));
        System.out.println("No 상품명 \t\t 단가\t\t수량\t금액");
        System.out.println("-".repeat(40));
        printCartItems(items);
        System.out.println("-".repeat(40));
        System.out.printf("합계 ㅣ %d원 \n",sumOfTotalPrice);
        System.out.println("(1) 홈으로 돌아가기");
        System.out.println("(2) 상품 삭제");
        System.out.println("(3) 장바구니 비우기");
        System.out.println("(4) 장바구니 상품 주문");
        System.out.println("(5) 프로그램 종료");


        return sc.nextLine();

    }

    private static void printCartItems(ArrayList<CartItem> items){
        //장바구니를 받아와서 상품 정보를 반복문으로 출력

        int number = 1;

        for(CartItem cartItem : items ){
            System.out.printf(
                    "%d %-8s %6d원 %6d %6d원\n"
                    ,number++,cartItem.getProductName(),cartItem.getCost(),cartItem.getCount(),cartItem.getTotalPrice());


        }
    }


}
