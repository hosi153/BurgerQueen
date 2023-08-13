package Product;

import Discount.Discount;
import Util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProductData {

    static Scanner sc = new Scanner(System.in);


    private static final ArrayList<Product> products = new ArrayList<>(Arrays.asList(
            new Hamburger(1, "새우버거", "햄버거", 3500, 500, false, 500, true),
            new Hamburger(2, "치킨버거", "햄버거", 4000, 600, false, 500, true),
            new Side(3, "감자튀김", "사이드", 1000, 300, false, 500, true),
            new Side(4, "어니언링", "사이드", 1000, 300, false, 500, true),
            new Drink(5, "코카콜라", "음료", 1000, 200, false, 10, false),
            new Drink(6, "제로콜라", "음료", 1000, 0, false, 10, false),
            new Product(7, "케찹", "옵션", 0, 100, true),
            new Product(8, "빨대", "옵션", 0, 0, true)
    ));


    public static void changeProductDiscount() {
        System.out.println("상품번호\t\t상품명\t\t할인금액");
        for (Product product : products) {
            if (product.isDiscount()) {
                System.out.println(product.getId()+"\t\t" + product.getName() + "\t\t" + product.getDiscount());
            }
        }
        System.out.print("변경할 상품을 고르시오 : ");
        int menu = sc.nextInt();
        System.out.print("할인 금액을 입력하시오 : ");
        int cost = sc.nextInt();

        for (Product product : products) {
            if (product.getId() == menu) {
                product.setDiscount(cost);
            }
        }

    }
    public static void changeProductDiscountRate() {
        System.out.println("상품번호\t\t상품명\t\t할인금액");
        for (Product product : products) {
            if (!product.isDiscount()) {
                System.out.println(product.getId()+"\t\t" + product.getName() + "\t\t" + product.getDiscount());
            }
        }
        System.out.print("변경할 상품을 고르시오 : ");
        int menu = sc.nextInt();
        System.out.print("할인 비율을 입력하시오 : ");
        int cost = sc.nextInt();

        for (Product product : products) {
            if (product.getId() == menu) {
                product.setDiscount(cost);
            }
        }

    }


    public static void menuPlus() {
        System.out.print("메뉴 이름 = ");
        String name = sc.next();
        System.out.println("카테고리 (1)햄버거   (2)사이드   (3)음료    (4)옵션");
        int category = sc.nextInt();
        System.out.print("가격 = ");
        int cost = sc.nextInt();
        System.out.print("칼로리 = ");
        int kcal = sc.nextInt();
        System.out.print("할인 = ");
        int discount = sc.nextInt();

        switch (category) {
            case 1:
                products.add(new Hamburger(products.size() + 1, name, "햄버거", cost, kcal, false, discount, true));
                break;
            case 2:
                products.add(new Side(products.size() + 1, name, "사이드", cost, kcal, false, discount, true));
                break;
            case 3:
                products.add(new Drink(products.size() + 1, name, "음료", cost, kcal, false, discount, true));
                break;
            case 4:
                products.add(new Product(products.size() + 1, name, "햄버거", cost, kcal, true));
                break;
            default:
                System.out.println("카테고리를 다시 확인하세요");

        }
    }


    public static void discountInfo() {
        System.out.println("상품 할인 정보");


        for (Product product : products) {
            if (!product.isOption()) {
                System.out.print(product.getName() + "\t");
                if (product.isDiscount()) {
                    System.out.println(product.getDiscount() + "원 할인");
                } else System.out.println(product.getDiscount() + "%% 할인");
            }
        }
    }


    public static int discount() {
        for (Product product : products) {
            if (product.getCategory().equals("햄버거")) {
                return 1000;
            } else if (product.getCategory().equals("음료")) {
                return 10;
            } else if (product.getCategory().equals("사이드")) {
                return 500;
            }
        }
        return 0;
    }

    public static int menuSize() {
        return products.size();
    }

    public static Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public static ArrayList<Hamburger> getHamburgers() {
        ArrayList<Hamburger> hamburgers = new ArrayList<>();
        for (Product product : products) {
            if (product instanceof Hamburger) {
                hamburgers.add((Hamburger) product);
            }
        }
        return hamburgers;
    }//getHamburgers 종료

    public static ArrayList<Side> getSide() {
        ArrayList<Side> sides = new ArrayList<>();
        for (Product product : products) {
            if (product instanceof Side) {
                sides.add((Side) product);
            }

        }
        return sides;
    }//getSide 종료

    public static ArrayList<Drink> getDrink() {
        ArrayList<Drink> drinks = new ArrayList<>();
        for (Product product : products) {
            if (product instanceof Drink) {
                drinks.add((Drink) product);
            }
        }
        return drinks;
    } //getDrink 종료

    public static ArrayList<Product> getOption() {
        ArrayList<Product> options = new ArrayList<>();
        for (Product product : products) {
            if (product.isOption()) {
                options.add(product);
            }
        }
        return options;
    }//getOption 종료


}
