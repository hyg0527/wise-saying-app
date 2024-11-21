package com.example.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    private List<WiseSaying> wiseSayingList = new ArrayList<WiseSaying>();

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

                System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
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
