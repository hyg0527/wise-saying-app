package com.example.day1.controller;

import com.example.day1.entity.WiseSaying;
import com.example.day1.service.WiseSayingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class WiseSayingController {
    private final WiseSayingService wiseSayingService;
    private final Scanner scanner;

    public WiseSayingController() {
        this.wiseSayingService = new WiseSayingService();
        this.scanner = new Scanner(System.in);
    }

    public void showList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("---------------");

        List<WiseSaying> wiseSayings = wiseSayingService.getWiseSayingList();
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying ws = wiseSayings.get(i);
            System.out.println(ws.getId() + " / " + ws.getSay() + " / " + ws.getAuthor());
        }
    }

    public void addSay() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        WiseSaying ws = wiseSayingService.addWiseSaying(content, author);

        System.out.printf("%d번 명언이 등록되었습니다.\n".formatted(ws.getId()));
    }

    public void deleteSay(String cmd) {
        int deleteId = Integer.parseInt(cmd.split("=")[1]);
        boolean removed = wiseSayingService.removeById(deleteId);

        if (removed) {
            System.out.println(deleteId + "번 명언이 삭제되었습니다.");
        }
        else {
            System.out.println(deleteId + "번 명언은 존재하지 않습니다.");
        }
    }


    public void modifySay(String cmd) {
        int modifyId = Integer.parseInt(cmd.split("=")[1]);

        Optional<WiseSaying> opWiseSaying = wiseSayingService.findById(modifyId);

        WiseSaying foundWiseSaying = opWiseSaying.get();

        if (opWiseSaying.isEmpty()) {
            System.out.println(modifyId + "번 명언은 존재하지 않습니다.");
            return;
        }
        else {
            System.out.printf("명언(기존) : %s\n", foundWiseSaying.getSay());
            System.out.print("명언 : ");
            String content = scanner.nextLine();

            System.out.printf("작가(기존) : %s\n", foundWiseSaying.getAuthor());
            System.out.print("작가 : ");
            String author = scanner.nextLine();

            wiseSayingService.modify(foundWiseSaying, content, author);

            System.out.printf("%d번 명언이 수정되었습니다.\n", modifyId);
        }

        scanner.close();
    }
}
