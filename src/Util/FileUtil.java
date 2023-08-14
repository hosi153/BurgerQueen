package Util;

import Cart.Cart;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileUtil {

    private static LocalDateTime localDateTime = LocalDateTime.now();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH-mm-ss");
    private static StringBuffer stringBuffer = new StringBuffer();
    private static String PATH = "/Users/choihogyun/Documents/git/burgerqueen/src/OrderList/";
    private static String FILE_NAME;


    public static void orderList() {
        File dir = new File(PATH);
        String[] files = dir.list();
        System.out.println("[주문 기록]");
        System.out.println("-".repeat(50));
        for (int i = 0; i < files.length; i++) {
            System.out.printf("( %d )  %s\n", (i + 1), files[i]);
        }
        System.out.println("-".repeat(50));
        System.out.println();

        System.out.print("주문 기록 확인 = (주문 번호 입력 / 0 - 취소)");
        int num = new Scanner(System.in).nextInt();
        if (num != 0) orderRead(files, num - 1);


    }

    private static void orderRead(String[] files, int num) {
        try {
            System.out.println(PATH + files[num]);
            FileReader file = new FileReader(PATH + files[num]);

            int data = 0;

            while ((data = file.read()) != -1) {
                System.out.print((char) data);
            }
            file.close();

        } catch (Exception e) {
        }

        System.out.println();
        System.out.println();
        System.out.println();


    }


    public static StringBuffer saveToFile(ArrayList<Cart> carts) {



        try {
            FILE_NAME = "CHG.Ver_BurgerQueen_" + PrintUtil.orderNumber() + localDateTime.format(formatter) + ".txt";

            printFile(carts);
            FileWriter fileWriter = new FileWriter(PATH + FILE_NAME);
            fileWriter.write(stringBuffer.toString());
            fileWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return stringBuffer;


    }


    private static StringBuffer printFile(ArrayList<Cart> carts) {
        stringBuffer.append("주문 번호 : " + PrintUtil.orderNumber() + "\n")
                .append("-".repeat(40) + "\n")
                .append("[주문 상품]" + "\n")
                .append("상품명\t\t\t단가\t수량\t금액\n");
        for (Cart cart : carts) {
            stringBuffer.append(cart.getProductName() + "\t\t" + cart.getRealCost() + "\t" + cart.getCount() + "\t" + cart.getPrice() + "\n");
        }
        stringBuffer.append("-".repeat(40) + "\n")
                .append("결제 금액 : " + Cart.totalPrice() + "원");


        return stringBuffer;

    }//printFile 종료

}
