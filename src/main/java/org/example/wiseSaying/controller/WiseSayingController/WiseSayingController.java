package org.example.wiseSaying.controller.WiseSayingController;

import org.example.ContainerSc;
import org.example.Rq;
import org.example.wiseSaying.entity.WiseSaying.WiseSaying;

import java.util.ArrayList;

public class WiseSayingController {
    int num = 0; // 등록마다 카운트될거
    ArrayList<WiseSaying> list = new ArrayList<WiseSaying>(); //list라는 배열선언

    public void add() {
        num++;
        System.out.println("명언을 입력하세요");
        String Word = ContainerSc.getScanner().nextLine().trim();
        System.out.println("명언 : " + Word);
        System.out.println("작가를 입력하세요");
        String autuorName = ContainerSc.getScanner().nextLine().trim();
        System.out.println("작가 : " + autuorName);
        int id = num;
        WiseSaying wiseSaying = new WiseSaying(id, Word, autuorName);
        list.add(wiseSaying);
        System.out.println(num + "번 명언이 등록되었습니다");
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(20));
        for (int i = list.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = list.get(i);
            System.out.println("번호 : " + wiseSaying.getId() + " / 작가 : " + wiseSaying.getAuthorName() + " / 명언 : " + wiseSaying.getContent());
        }
        System.out.println("명언 수 : " + list.size());
    }

    public void remove(Rq rq) {
        int id = rq.getIntParam("id", -1);
        if (id == -1) {
            System.out.println("정수를 입력하세요");
            return;
        }
        WiseSaying wiseSaying = finalByid(id);

        list.remove(wiseSaying);
        System.out.printf("%d번이 삭제 되었습니다\n", id);
    }

    private WiseSaying finalByid(int id) {
        for (WiseSaying wiseSaying : list) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }

    public void edit(Rq rq) {
        int id = rq.getIntParam("id", -1);
        if (id == -1) {
            System.out.println("정수를 입력하세요");
            return;
        }
        WiseSaying wiseSaying = finalByid(id);


        System.out.printf("기존명언 %s", wiseSaying.getContent());
        System.out.printf("수정할 명언");
        String content = ContainerSc.getScanner().nextLine().trim();

        System.out.printf("기존작가 %s", wiseSaying.getContent());
        System.out.printf("수정할 작가");
        String authorName = ContainerSc.getScanner().nextLine().trim();

        wiseSaying.setContent(content);
        wiseSaying.setAuthorName(authorName);

        System.out.printf("%d번이 수정 되었습니다\n", id);
    }
}
