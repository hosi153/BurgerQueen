import Cart.Cart;
import Product.Product;
import Product.ProductData;
import Promotion.Promotion;
import Promotion.KidPromotion;
import Promotion.CozPromotion;
import Util.FileUtil;
import Util.PrintUtil;

import java.util.Deque;
import java.util.Scanner;

public class BurgerQueen {

    static ProductData productData = new ProductData();
    static Scanner sc = new Scanner(System.in);
    static Promotion promotion;



    public static void moveToMainMenu(){ //메인 메뉴
        try {
            int selectMainMenu = PrintUtil.printMainMenu();
            switch (selectMainMenu){
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
                    orderPage();

                case 5:
                    System.out.println("매장을 종료합니다. 감사합니다.");
                    System.exit(0);
                case 0:
                    hiddenMenu();
                    break;
                default:
                    System.out.println("잘못된 입력입니다. ");
                    moveToMainMenu();
            }
        }
        catch (Exception e){
            System.out.println("잘못된 입력입니다. ");
            moveToMainMenu();
        }

    }//moveToMainMenu 종료

    private static void orderPage(){

        PrintUtil.printCart();

        System.out.println("-".repeat(50));
        System.out.println("(1) 주문하기");
        System.out.println("(2) 주문 기록 확인");
        System.out.println("(3) 홈으로 ");

        String input = sc.nextLine();
        switch (input){
            case "1":
                selectPromotion();
                break;
            case "2":
                FileUtil.orderList();
                moveToMainMenu();
                break;

            case "3"://홈으로 이동
                moveToMainMenu();
            default:
                System.out.println("잘못입력했습니다.");
                orderPage();
        }
    }


    private static void hiddenMenu(){ //관리자 메뉴
        System.out.println("관리자 메뉴");
        String selectHidden = PrintUtil.hiddenMenu();
        switch (selectHidden){
            case "1":
               ProductData.menuPlus();
                moveToMainMenu();
               break;
            case "2":
                PrintUtil.discountChange();
                moveToMainMenu();
                break;
            case "3":
                moveToMainMenu();
            default:
                System.out.println("잘못입력했습니다.");
                hiddenMenu();
        }
    }



    private static void showDiscount() { //할인 정보 표시
        ProductData.discountInfo();
        System.out.println();
        moveToMainMenu();
    }


    private static void selectMenu(){ //메뉴선택
        try {
            int menu = PrintUtil.printMenu(productData);

            if ((ProductData.menuSize()+1) == menu){
                moveToMainMenu();
            }
            else {
                System.out.print("수량을 입력하세요 : ");
                int count = sc.nextInt(); //수량
                if (count<1){
                    System.out.println("수량은 1 이상을 입력해주세요.");
                    selectMenu();
                }
                else {
                    Product product = ProductData.findById(menu); //품목


                    Cart.addCarts(product,count);
                    System.out.printf("[🔔] %s를(을) 장바구니에 담았습니다.\n",
                            product.getName()+"*"+count);

                }


            }
            selectMenu();

        }catch (Exception e){
            System.out.println("⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️");
            System.out.println("⚠️잘못된 주문정보입니다.⚠️");
            System.out.println("⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️");
            selectMenu();

        }

    } //selectMenu 종료





    private static void cartMenu(){ //장바구니 메뉴
        PrintUtil.printCart();
        System.out.println("(1) 홈으로 돌아가기");
        System.out.println("(2) 상품 삭제");
        System.out.println("(3) 장바구니 비우기");
        System.out.println("(4) 프로그램 종료");

        int selectCart = sc.nextInt();
        switch (selectCart){
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
            case 4://프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            default:
                System.out.println("잘못입력했습니다.");
                cartMenu();

        }


    }

    private static void selectPromotion() { //할인 선택
        if (Cart.carts.size() > 0) {
            System.out.println("프로모션 정보");
            System.out.println("(1) 코드스테이츠 수강생 프로모션");
            System.out.println("(2) 어린이 프로모션");
            System.out.println("(3) 선택 안함");
            System.out.print("프로모션 정보를 선택하세요 : ");
            int selectPromo = sc.nextInt();
            switch (selectPromo) {
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
            System.out.print("결제하시겠습니까? : ");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    FileUtil.saveToFile(Cart.carts);
                    System.out.println("주문이 완료되었습니다.");
                    Cart.cartClear();
                    moveToMainMenu();
                default:
                    System.out.println("주문이 취소되었습니다.");
                    Cart.cartDelete((Cart.carts.size()));
                    cartMenu();

            }

        }
        else {
            System.out.println();
            System.out.println("장바구니가 비어있습니다.");
            System.out.println();
            moveToMainMenu();
        }
    }



}
