package org.example;

import java.util.Scanner;

public class App {
    private final Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        int num = 1;
        System.out.println("== 명언 앱 ==");

        while (true) {
            String stop = sc.nextLine().trim();
            if(stop.equals("종료")){
                break;
            }
            System.out.printf("명언 : ");
            String word = sc.nextLine();
            System.out.println("명언 : " + word);

            System.out.printf("작가 : ");
            String name = sc.nextLine();
            System.out.println("작가 : " + name);
            System.out.println(num + "번 명언번호가 등록 되었습니다");
            num++;
        }
    }
}
