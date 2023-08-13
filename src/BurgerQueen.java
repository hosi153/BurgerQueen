import Cart.Cart;
import Product.Product;
import Product.ProductData;
import Promotion.Promotion;
import Promotion.KidPromotion;
import Promotion.CozPromotion;
import Util.PrintUtil;

import java.util.Deque;
import java.util.Scanner;

public class BurgerQueen {

    static ProductData productData = new ProductData();
    static Scanner sc = new Scanner(System.in);
    static Promotion promotion;



    public static void moveToMainMenu(){
        int menu = PrintUtil.printMainMenu();

        switch (menu){
            case 1: //메뉴 선택
                selectMenu();
                break;
            case 2: // 장바구니
                cartMenu();
                break;

            case 3: //할인 정보
                showDiscount();
                break;


            case 4: //프로그램 종료
                System.out.println("매장을 종료합니다. 감사합니다.");
                System.exit(0);

            case 0:
                hiddenMenu();
                break;


            default:
                System.out.println("잘못된 입력입니다. ");
                moveToMainMenu();

        }

    }//moveToMainMenu 종료

    private static void hiddenMenu(){
        System.out.println("관리자 메뉴");
        int input = PrintUtil.hiddenMenu();
        switch (input){
            case 1:
               ProductData.menuPlus();
                moveToMainMenu();
               break;
            case 2:
                PrintUtil.discountChange();
                moveToMainMenu();
                break;
            case 3:
                moveToMainMenu();

        }


    }



    private static void showDiscount() {
        ProductData.discountInfo();
        System.out.println();
        moveToMainMenu();


    }


    private static void selectMenu(){
        int menu = PrintUtil.printMenu(productData);

        if ((ProductData.menuSize()+1) == menu){
            moveToMainMenu();
        }
        else {
            System.out.print("수량을 입력하세요 : ");
            int count = sc.nextInt(); //수량
            Product product = ProductData.findById(menu); //품목


            Cart.addCarts(product,count);
            System.out.printf("[🔔] %s를(을) 장바구니에 담았습니다.\n",
                    product.getName()+"*"+count);
        }
        selectMenu();
    } //selectMenu 종료

    private static void cartMenu(){
        PrintUtil.printCart();
        System.out.println("(1) 홈으로 돌아가기");
        System.out.println("(2) 상품 삭제");
        System.out.println("(3) 장바구니 비우기");
        System.out.println("(4) 장바구니 상품 주문");
        System.out.println("(5) 프로그램 종료");

        int menu = sc.nextInt();
        switch (menu){
            case 1: //홈으로 가기
                moveToMainMenu();
                break;
            case 2: //상품 삭제
                System.out.print("삭제할 상품의 번호를 입력하세요 : ");
                int num = sc.nextInt();
                Cart.cartDelete(num);
                cartMenu();
            case 3: //장바구니 비우기
                Cart.cartClear();
                cartMenu();
            case 4: //상품 주문
                selectPromotion();
                break;

            case 5://프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            default:
                System.out.println("잘못입력했습니다.");
                cartMenu();

        }


    }

    private static void selectPromotion() {
        System.out.println("프로모션 정보");
        System.out.println("(1) 코드스테이츠 수강생 프로모션");
        System.out.println("(2) 어린이 프로모션");
        System.out.println("(3) 선택 안함");
        System.out.print("프로모션 정보를 선택하세요 : ");
        int num = sc.nextInt();
        switch (num){
            case 1:
                promotion = new CozPromotion();
                promotion.promotion();
                break;
            case 2:
                promotion = new KidPromotion();
                promotion.promotion();
                break;
            case 3:
                System.out.println("선택 안함");
                break;
            default:
                System.out.println("다시 입력하세요");
                selectPromotion();
        }
        PrintUtil.printOrder();
        System.out.println("결제하시겠습니까?");

    }


}
