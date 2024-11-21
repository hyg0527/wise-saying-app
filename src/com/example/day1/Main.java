package com.example.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    private final List<WiseSaying> wiseSayingList = new ArrayList<>();

    public void run() {
        System.out.println("== 명언 앱 ==");

        Scanner scanner = new Scanner(System.in);
        int id = 1;

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            }
            else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine();
                System.out.print("작가 : ");
                String author = scanner.nextLine();

                WiseSaying wiseSaying = new WiseSaying(id, content, author);
                wiseSayingList.add(wiseSaying);

                System.out.printf("%d번 명언이 등록되었습니다.\n".formatted(id));
                id++;
            }
            else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("---------------");
                for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
                    WiseSaying ws = wiseSayingList.get(i);
                    System.out.println(ws.getId() + " / " + ws.getSay() + " / " + ws.getAuthor());
                }
            }
            else if (cmd.startsWith("삭제")) {
                int deleteId = Integer.parseInt(cmd.split("=")[1]);
                WiseSaying target = null;
                for (WiseSaying ws : wiseSayingList) {
                    if (ws.getId() == deleteId) {
                        target = ws;
                        break;
                    }
                }

                if (target != null) {
                    wiseSayingList.remove(target);
                    System.out.println(deleteId + "번 명언이 삭제되었습니다.");
                }
                else {
                    System.out.println(deleteId + "번 명언은 존재하지 않습니다.");
                }
            }
        }
        scanner.close();
    }
}

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
