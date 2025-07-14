package com.lojaSapatos.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuView {

    public String showMainMenu() {
        Scanner scanner = new Scanner(System.in);

        String cyan = "\u001B[36m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String reset = "\u001B[0m";
        String red = "\u001B[31m";

        System.out.println(cyan + "====================================================================================================" + reset);
        System.out.println(green +
                "  _   _   ______   _______             _____   _    _    ____    ______ \n" +
                " | \\ | | |  ____| |__   __|           / ____| | |  | |  / __ \\  |  ____|\n" +
                " |  \\| | | |__       | |     ______  | (___   | |__| | | |  | | | |__   \n" +
                " | . ` | |  __|      | |    |______|  \\___ \\  |  __  | | |  | | |  __|  \n" +
                " | |\\  | | |____     | |              ____) | | |  | | | |__| | | |____ \n" +
                " |_| \\_| |______|    |_|             |_____/  |_|  |_|  \\____/  |______" + reset);
        System.out.println(cyan + "====================================================================================================" + reset);
        System.out.println(green + "LOGIN [0]" + reset);
        System.out.println(red + "EXIT [1]" + reset);
        System.out.print( yellow + "❱❱" + reset);

        return scanner.nextLine();
    }
}
