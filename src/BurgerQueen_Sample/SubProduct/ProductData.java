package BurgerQueen_Sample.SubProduct;

import BurgerQueen_Sample.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductData {



    private static final ArrayList<Product> products = new ArrayList<>(Arrays.asList(
            new Hamburger(1, "새우버거", 3500, 500, false),
            new Hamburger(2, "치킨버거", 4000, 600, false),
            new Side(3, "감자튀김", 1000, 300, false),
            new Side(4, "어니언링", 1000, 200, false),
            new Drink(5, "코카콜라", 1000, 300, false),
            new Drink(6, "제로콜라", 1000, 0, false),
            new Product(7, "케찹", 0, 100, true),
            new Product(8, "빨대", 0, 0, true))
    );

    public int ArsSze() {
        return products.size();
    }


    public Product findById(int id) {
        for (Product product :
                products) {
            if (product.getId() == id) return product;

        }
        return null;
    }


    public static ArrayList<Hamburger> getHamburgers() {
        ArrayList<Hamburger> hamburgers = new ArrayList<>();
        for (Product product : products) {  //Product 로 업캐스팅 된 상태
            if (product instanceof Hamburger) hamburgers.add((Hamburger) product);
        }
        return hamburgers;


    }

    public static ArrayList<Side> getSide() {
        ArrayList<Side> sides = new ArrayList<>();
        for (Product product : products) {  //Product 로 업캐스팅 된 상태
            if (product instanceof Side) sides.add((Side) product);
        }
        return sides;
    }

    public static ArrayList<Drink> getDrink() {
        ArrayList<Drink> drinks = new ArrayList<>();
        for (Product product : products) {  //Product 로 업캐스팅 된 상태
            if (product instanceof Drink)
                drinks.add((Drink) product);
        }
        return drinks;
    }

    public static ArrayList<Product> getOption() {
        ArrayList<Product> option = new ArrayList<>();
        for (Product product : products) {
            if (product.isOption()) option.add(product);
        }
        return option;
    }

}
/*
 *
 *      product instanceof Hamburger
 *               Product
 *                   \
 *              ... Hamburger ...
 *      햄버거 클래스의 상속 계층도상으로 햄버거 위에 프로덕트
 *      자기 자신, 상위 클래스 내용이 돌아오면 true
 *
 * */