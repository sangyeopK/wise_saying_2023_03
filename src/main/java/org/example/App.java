package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    Scanner sc; // 스캐너 선언
    int num = 0; // 등록마다 카운트될거

    String add; // 배열 합쳐 출력할 거

    App(Scanner sc) {
        this.sc = sc;
    }

    void run() {

        ArrayList<WiseSaying> list = new ArrayList<WiseSaying>(); //배열선언
        System.out.println("== 명언 앱==");

        while (true) {
            System.out.println("명령)");
            String commend = sc.nextLine().trim();
            if (commend.equals("종료")) {
                break;
            } else if (commend.equals("등록")) {
                num++;
                System.out.println("명언을 입력하세요");
                String Word = sc.nextLine().trim();
                System.out.println("명언 : " + Word);
                System.out.println("작가를 입력하세요");
                String AutuorName = sc.nextLine().trim();
                System.out.println("작가 : " + AutuorName);
                int id = num;
                WiseSaying wiseSaying = new WiseSaying(id, Word, AutuorName);
                list.add(wiseSaying);
                System.out.println(num + "번 명언이 등록되었습니다");
            } else if (commend.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-------------");
                for (int i = 0; i < list.size(); i++) {
                    WiseSaying wiseSaying = list.get(i);
                    System.out.println("번호 : " + wiseSaying.getId() + " / 작가 : " + wiseSaying.getAuthorName() + " / 명언 : " + wiseSaying.getContent());
                }
                System.out.println("명언 수 : " + list.size());
            }
        }
    }
}


