package Product;

import Product.Cart.CartService;
import Product.SubProduct.ProductData;
import Product.Util.PrintUtil;

import java.util.Map;
import java.util.Scanner;

public class BurgerQueen {
    private ProductData productData;
    private CartService cartService;

    private Scanner sc = new Scanner(System.in);
    private String input;
    Product product;
    public BurgerQueen(){
        this.productData = new ProductData();
        this.cartService = new CartService();
    }

    public void moveToMainMenu(){
        // 기본 화면출력을 위한 메인 메뉴
        // 메뉴 입력을 받아야 한다.

        input = PrintUtil.printInitialView();
        // 입력을 받기 위한 최초 메뉴 출력
        // printInitialView 메소드의 return 값 이
        // nextLine 으로 String 값 반환
        // 반환된 입력값 (input)에 따른 메뉴 분기 설정

        switch (input){
            case"1": // 메뉴 선택화면으로 이동
                selectMenu();
                break;
            case"2": // 장바구니로 이동
                moveToCart();
                break;
            case"3": // 할인 정보 출력
                break;
            case"4": //서비스 종료
                System.out.println("서비스 종료");
                System.exit(0);

            default:
                System.out.println("잘못 입력했습니다.");
                moveToMainMenu();
        }
    } //moveToMainMenu() 종료


    public void selectMenu(){
        // 메뉴 선택 화면
        // 메뉴 목록 출력 화면부
        //
        // 메뉴 입력 화면부
        //      ㄴ   메뉴 종류 선택
        //      ㄴ   종료 메뉴 선택
        int menuNumber = PrintUtil.printMenu(productData);
        //public static int printMenu
        // printMenu에서 메뉴 표시 후 int 값 반환

        if (menuNumber==productData.ArsSze()+1) moveToMainMenu();
        //ArsSz = index기준이라 +1을 해주어야 9에 맞춤
        // 9 입력시 메인메뉴로 롤백

        else {

            System.out.print("수량을 입력해 주세요 = ");
            product = productData.findById(menuNumber);
            //장바구니에 상품 추가하기
            int count = sc.nextInt();
            // 장바구니에 상품 추가
            Map<String , Object > result = cartService.addToCart(product, count);



            //추가 성공 메시지 출력
            System.out.printf(
                    " %s를 장바구니에 담았습니다. \n", result.get("p_name")+"*"+result.get("p_count"));

            selectMenu();
        }
    }// selectMenu종료

    private void moveToCart(){

        //장바구니 상품 및 기능 출력 + 사용자 입력 받기
        //printCart 메소드로 메뉴 출력
        input = PrintUtil.printCart(cartService.getItem(), cartService.getSumOfTotalPrice());

        switch (input){
            case "1": // 홈으로 돌아가기
                moveToMainMenu();
            case "2": // 상품 삭제
                deleteCartItem();
                moveToCart();
            case "3": // 장바구니 비우기
                cartService.clearCart();
                moveToCart();
            case "4": // 장바구니 상품 주문

            case "5":  //프로그램 종료
                System.exit(0);
            default:
                System.out.println("다시 입력해 주세요");
                moveToCart();

        }



    }//moveToCart 종료


    private void deleteCartItem() {
        System.out.print("삭제할 상품의 번호를 입력해주세요 : ");
        int i = sc.nextInt();
        cartService.deleteItem(i);
    }







}
