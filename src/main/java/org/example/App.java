package org.example;

import org.example.system.controller.SystemController.SystemController;
import org.example.wiseSaying.controller.WiseSayingController.WiseSayingController;
import org.example.wiseSaying.entity.WiseSaying.WiseSaying;

public class App {
    void run() {
        WiseSayingController WiseSayingController = new WiseSayingController();
        //변수 명으로 클래스 불러오기
        System.out.println("== 명언 앱==");

        while (true) {
            System.out.println("명령)");
            String commend = ContainerSc.getScanner().nextLine().trim();
            Rq rq = new Rq(commend);

            switch (rq.getActionCode()) {
                case "종료":
                    SystemController.exit();
                    return;
                case "등록":
                    WiseSayingController.add();
                    break;
                case "목록":
                    WiseSayingController.list();
                    break;
                case "삭제":
                    WiseSayingController.remove(rq);
                    break;
                case "수정":
                    WiseSayingController.edit(rq);
            }
        }
    }
}


