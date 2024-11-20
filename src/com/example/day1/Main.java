package com.example.day1;

import java.util.Scanner;

class App {

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

                System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
                id++;
            }
            System.out.printf("입력된 명령어 : %s\n".formatted(cmd));
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
