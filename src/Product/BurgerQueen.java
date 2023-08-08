package Product;

import Product.Cart.CartService;
import Product.SubProduct.ProductData;
import Product.Util.PrintUtil;

import java.util.Map;
import java.util.Scanner;

public class BurgerQueen {
    private final CartService cartService;
    private final ProductData productdata;
    // 프로그램이 시작되면 -> 메인 화면이 보여야 한다.
    Product product;
    private Scanner sc = new Scanner(System.in);
    private String input;

    public BurgerQueen(){
        this.input = input;
        this.sc = new Scanner(System.in);
        this.productdata = new ProductData();
        this.cartService = new CartService();

    }

    public void moveToMainMenu(){
        //메인 화면이 출력되어야 한다. + 사용자로부터 입력을 받아야 한다.
         input = PrintUtil.printInitialView();

        //입력값에 따라 적절한 처리를 해야 한다.
        switch (input){
            case "1":
                selectMenu();
                //메뉴 선택 화면으로 이동
                break;
            case "2":
                //장바구니 이동
                moveToCart();
                break;
            case "3":
                //할인 정보 출력
                break;
            case "4":
                //종료
                System.exit(0);
            default:
                System.out.println("잘못 입력하셨습니다.");
                moveToMainMenu();

        }
    }

    public void selectMenu(){
        //메뉴 화면 출력 +         //입력 받기
        int menuNumber= PrintUtil.printMenu(productdata);

        //입력값 9인 경우 -> 메인화면으로 이동



        if(menuNumber==productdata.ArsSze()+1) moveToMainMenu();
            //그렇지 않은 경우 -> 상품을 선택
        else {
            System.out.print("수량을 입력해주세요 : ");
            // 수량 입력 필요

            product = productdata.findById(menuNumber);

            // 사용자가 입력한 번호가 가리키는 상품 검색

            int count = sc.nextInt();
            // 장바구니에 해당 상품을 추가
            Map<String , Object> result = cartService.addToCart(product, count);
            // 추가가 성공했다는 메세지 출력


            System.out.printf(
                    " %s를 장바구니에 담았습니다. \n", result.get("p_name")+"*"+result.get("p_count"));

            selectMenu();





        }

    }
    private int insertCount(){
        System.out.println("수량을 입력해주세요 : ");
        return Integer.parseInt(sc.nextLine());
    }
    private void moveToCart(){
        //장바구니 상품 및 기능 출력 + 사용자 입력 받기

        input = PrintUtil.printCart(cartService.getItems(),cartService.getSumOfTotalPrice());
        //사용자의 입력에 따라 분기

        switch ((input)){
            case"1":
                moveToMainMenu();
            case"2":
                //상품 하나를 삭제
                deleteCartItem();
                moveToCart();
            case "3":
                //장바구니 비우기
                cartService.clearCart();
                moveToCart();
            case"4":
                //장바구니 상품 주문
                moveToCart();
            case "5":
                //프로그램 종료
                System.exit(0);
            default:
                System.out.println("잘못 입력 했습니다.");
                moveToCart();
        }




    }

    private void deleteCartItem(){
        System.out.println("삭제할 상품의 번호를 입력해주세요 : ");
        cartService.deleteItem(Integer.parseInt(sc.next()));
    }




}
/*
*
* 장바구니 관련 필요 객체
*   - 장바구니 상품 정보 객체 -> CartItem
*   - 장바구니 기능 담당 객체 -> CartService
*   -
*
*
*
* */
