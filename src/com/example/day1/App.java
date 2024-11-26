package com.example.day1;

import com.example.day1.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private final WiseSayingController wiseSayingController;

    public App() {
        this.scanner = new Scanner(System.in);
        this.wiseSayingController = new WiseSayingController(scanner);
    }

    public void run() {
        wiseSayingController.sampleData();

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            }
            else if (cmd.equals("등록")) {
                wiseSayingController.addSay();
            }
            else if (cmd.equals("목록")) {
                wiseSayingController.showList();
            }
            else if (cmd.startsWith("삭제")) {
                wiseSayingController.deleteSay(cmd);
            }
            else if (cmd.startsWith("수정")) {
                wiseSayingController.modifySay(cmd);
            }
        }
        scanner.close();
    }
}
