package org.example;

import java.util.Scanner;

public class App {
    private final Scanner sc;
    String name;
    String word;
    private String add;
    public String getAdd() {
        return add;
    }
    public void setAdd(String add) {
        this.add = add;
    }

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        int num = 0;
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.println("명령)");
            String commend = sc.nextLine().trim();
            if (commend.equals("종료")) {
                break;
            } else if (commend.equals("등록")) { // 여기서 등록하기
                num++;
                System.out.printf("명언 : ");
                word = sc.nextLine();
                this.word = word;
                System.out.println("명언 : " + word);

                System.out.printf("작가 : ");
                name = sc.nextLine();
                this.name = name;
                System.out.println("작가 : " + name);
                System.out.println(num + "번 명언번호가 등록 되었습니다");
                for(int i = 1; i<=num; i++){
                    if(i==i){
                        setAdd("/" + name + "/" + word);
                    }
                }
            }
            for (int i = 1; i <=num; i++) {
                    if (commend.equals("목록")) {
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println( i + "/" + getAdd());
                }
            }
        }
    }
}


