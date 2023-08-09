package Product;

public class Product {


    //상품 식별 필드
    // private
    private int id;
    private String name;
    private  int cost;
    private int kcal;
    private boolean isOption;

    //할인 관련 필드
    private int discountCost; // 할인 금액 필드 ( 퍼센트 반영 유무 관계없이 입력)
    private boolean isPercent; // 퍼센트 적용 유무 필드 ( true - 할인 퍼센트에 맞게 계산 , 금액 표기에 % 표기 )
    private int realCost; // cost 에서 할인액이 반영된 실제 계산 금액



    // 생성자 생성
    //Product 타입 객체 생성
    // id , 이름, 칼로리, 가격, 옵션유무 단위 저장
    //
//    public Product(int id, String name,int cost,int kcal,boolean isOption){
//        this.id = id;
//        this.name = name;
//        this.cost=cost;
//        this.kcal=kcal;
//        this.isOption=isOption;
//    }

    public Product(int id, String name, int cost, int kcal, boolean isOption, int discountCost,  boolean isPercent) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.kcal = kcal;
        this.isOption = isOption;
        this.discountCost= discountCost;
        this.isPercent = isPercent;
//        this.realCost = (int)(cost - discountCost) ;x
        if (isPercent){this.realCost = cost - (cost*discountCost/100);}  // 퍼센트 적용시 할인률이 적용된 금액 반환
        else {this.realCost = cost - discountCost;}  //퍼센트 미적용시 cost에서 할인액 바로 차감 후 반환


    }

    public boolean getIsPercent(){
        return isPercent;
    }


    //식별 필드에 접근하기 위한 getter setter 작성

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getCost(){
        return cost;
    }
    public int getKcal(){
        return kcal;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Product setCost(int cost) {
        this.cost = cost;
        return this;
    }

    public Product setKcal(int kcal) {
        this.kcal = kcal;
        return this;
    }

    public boolean isOption(){
        return isOption;
    }









    public int getRealCost() {
        return realCost;
    }

    public Product setRealCost(int realCost) {
        this.realCost = realCost;
        return this;
    }

    public int getDiscountCost() {
        return discountCost;
    }




}
