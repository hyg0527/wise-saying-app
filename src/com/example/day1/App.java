package com.example.day1;

import com.example.day1.controller.WiseSayingController;
import com.example.day1.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final List<WiseSaying> wiseSayingList;
    private final Scanner scanner;

    private final WiseSayingController wiseSayingController;

    public App() {
        this.scanner = new Scanner(System.in);
        this.wiseSayingList = new ArrayList<>();
        this.wiseSayingController = new WiseSayingController();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            }
            else if (cmd.equals("등록")) {
                wiseSayingController.addSay(wiseSayingList);
            }
            else if (cmd.equals("목록")) {
                wiseSayingController.showList(wiseSayingList);
            }
            else if (cmd.startsWith("삭제")) {
                wiseSayingController.deleteSay(wiseSayingList, cmd);
            }
            else if (cmd.startsWith("수정")) {
                wiseSayingController.modifySay(wiseSayingList, cmd);
            }
        }
        scanner.close();
    }
}
