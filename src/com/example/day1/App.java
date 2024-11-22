package com.example.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final List<WiseSaying> wiseSayingList;
    private final Scanner scanner;
    private int lastId;

    public App() {
        this.scanner = new Scanner(System.in);
        this.lastId = 0;
        this.wiseSayingList = new ArrayList<>();
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
                addSay();
            }
            else if (cmd.equals("목록")) {
                showList();
            }
            else if (cmd.startsWith("삭제")) {
                int deleteId = Integer.parseInt(cmd.split("=")[1]);
                deleteSay(deleteId);
            }
        }
        scanner.close();
    }

    public void addSay() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        WiseSaying ws = addWiseSaying(content, author);

        System.out.printf("%d번 명언이 등록되었습니다.\n".formatted(ws.getId()));
    }

    public void showList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("---------------");
        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
            WiseSaying ws = wiseSayingList.get(i);
            System.out.println(ws.getId() + " / " + ws.getSay() + " / " + ws.getAuthor());
        }
    }

    public void deleteSay(int deleteId) {
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

    public WiseSaying addWiseSaying(String content, String author) {
        int id = ++lastId;
        WiseSaying ws = new WiseSaying(id, content, author);
        wiseSayingList.add(ws);

        return ws;
    }
}
