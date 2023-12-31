import Product.BurgerQueen;

public class Main {
    public static void main(String[] args) {

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
        *           1> 메뉴 선택
        *           2> 수량 선택
        *           3> 메인 메뉴로 이동
        *
        *       -2  장바구니 이동
        *
        *               - 상품명, 단가, 할인금액, 소비자가, 수량, 금액 확인 가능
        *               - Product 클래스 생성자에 퍼센트 반영 유무 필드 작성
         *              - 퍼센트 작성 필드 true = 할인율 반영된 할인액 표시
         *              - 퍼센트 작성 필드 false = 할인 액 표시
        *           1> 메인메뉴로 돌아가기
        *           2> 상품 개별 삭제 ( 장바구니의 넘버링 기준 )
        *           3> 장바구니 비우기
        *           4> 장바구니 상품 주문 ( 미구현 )
        *           5> 프로그램 종료
        *
        *       -3  할인 정보 출력
        *           1> 상품 할인 금액 확인
        *               - 정액 할인 / 정률 할인 구분
        *               - Product 클래스 생성자에 퍼센트 반영 유무 필드 작성
        *               - 퍼센트 작성 필드 true = 할인 % 표시
        *               - 퍼센트 작성 필드 false = 할인 액 표시
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
