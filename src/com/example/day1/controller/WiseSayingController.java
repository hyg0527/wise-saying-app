package com.example.day1.controller;

import com.example.day1.entity.WiseSaying;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner scanner;
    private int lastId;

    public WiseSayingController() {
        this.scanner = new Scanner(System.in);
        this.lastId = 0;
    }

    public void showList(List<WiseSaying> list) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("---------------");
        for (int i = list.size() - 1; i >= 0; i--) {
            WiseSaying ws = list.get(i);
            System.out.println(ws.getId() + " / " + ws.getSay() + " / " + ws.getAuthor());
        }
    }

    public void addSay(List<WiseSaying> list) {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        WiseSaying ws = addWiseSaying(content, author, list);

        System.out.printf("%d번 명언이 등록되었습니다.\n".formatted(ws.getId()));
    }

    public WiseSaying addWiseSaying(String content, String author, List<WiseSaying> list) {
        int id = ++lastId;
        WiseSaying ws = new WiseSaying(id, content, author);
        list.add(ws);

        return ws;
    }

    public void deleteSay(List<WiseSaying> list, String cmd) {
        int deleteId = Integer.parseInt(cmd.split("=")[1]);
        WiseSaying target = findTarget(deleteId, list);

        if (target != null) {
            list.remove(target);
            System.out.println(deleteId + "번 명언이 삭제되었습니다.");
        }
        else {
            System.out.println(deleteId + "번 명언은 존재하지 않습니다.");
        }
    }


    public void modifySay(List<WiseSaying> list, String cmd) {
        int modifyId = Integer.parseInt(cmd.split("=")[1]);
        WiseSaying target = findTarget(modifyId, list);

        if (target != null) {
            System.out.printf("명언(기존) : %s\n", target.getSay());
            System.out.print("명언 : ");
            String content = scanner.nextLine();

            System.out.printf("작가(기존) : %s\n", target.getAuthor());
            System.out.print("작가 : ");
            String author = scanner.nextLine();

            target.setSay(content);
            target.setAuthor(author);

            System.out.printf("%d번 명언이 수정되었습니다.\n", target.getId());
        }
        else {
            System.out.println(modifyId + "번 명언은 존재하지 않습니다.");
        }

        scanner.close();
    }

    public WiseSaying findTarget(int id, List<WiseSaying> list) {
        WiseSaying target = null;

        for (WiseSaying ws : list) {
            if (ws.getId() == id) {
                target = ws;
                break;
            }
        }
        return target;
    }
}
