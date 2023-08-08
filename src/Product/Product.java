package Product;

public class Product {


    //상품 식별 필드
    // private
    private int id;
    private String name;
    private  int cost;
    private int kcal;
    private boolean isOption;

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

    // 생성자 생성
    //Product 타입 객체 생성
    // id , 이름, 칼로리, 가격, 옵션유무 단위 저장
    //
    public Product(int id, String name,int cost,int kcal,boolean isOption){
        this.id = id;
        this.name = name;
        this.cost=cost;
        this.kcal=kcal;
        this.isOption=isOption;
    }
}
