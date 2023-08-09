import Product.BurgerQueen;

public class Main {
    public static void main(String[] args) {
        //testtest

        /*
        * 1. 상품 관련 객체 제작
        *   상위 클래스 - Product
        *   하위 클래스 - Hamburger, Drink, Side
        *   (-> 상위클래스 ->상속)
        *   -상품 데이터 관리 객체
        *
        *
        *
        * 프로그램 주요 로직 담당 객체
        * 출력 담당 클래스 ( static )
        *
        * 2. 입출력 유닛 제작
        *   1) 메인메뉴
        *       -1  메뉴 선택화면 이동
        *       -2  장바구니 이동
        *       -3  할인 정보 출력
        *       -4  종료
        *
        *
        *
        * */


        BurgerQueen burgerQueen = new BurgerQueen();
        burgerQueen.moveToMainMenu();
    }
}


/*
*
* */
