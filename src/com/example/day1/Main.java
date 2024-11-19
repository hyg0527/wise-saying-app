package com.example.day1;

import java.util.Scanner;

class App {

    public void run() {
        System.out.println("== 명언 앱 ==");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
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
