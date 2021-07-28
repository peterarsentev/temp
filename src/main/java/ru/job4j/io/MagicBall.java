package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

    public static String rand() {
        int answer = new Random().nextInt(3);
        String ans = switch (answer) {
            case 0 -> "Да.";
            case 1 -> "Нет.";
            default -> "Может быть.";
        };
        return ans;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
            String quest = input.nextLine();
            System.out.println("Ваш ответ на вопрос: " + quest + " " + rand());
            System.out.println("Хотите задать еще вопрос? да или нет");
            String q = input.nextLine();
            if ("нет".equals(q)) {
             break;
            }
        }

    }

}
