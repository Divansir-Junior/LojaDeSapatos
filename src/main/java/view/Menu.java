package view;

import controller.MenuController;

import java.util.Scanner;

public class Menu {

    private final MenuController controller = new MenuController();

    public void ShowMainMenu() {
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
        System.out.println(yellow + "DIGITE SUA ESCOLHA:" + reset);
        System.out.println(green + "ENTRAR" + reset);
        System.out.println(red + "SAIR" + reset);
        System.out.print("👉 ");
        Scanner scanner = new Scanner(System.in);


        String escolha = scanner.nextLine().trim().toLowerCase();

        switch (escolha) {
            case "entrar":
                System.out.println(controller.enter());
                break;
            case "sair":
                System.out.println(controller.exit());
                break;
            default:
                System.out.println("❌ Opção inválida. Tente novamente.");
        }

        scanner.close();
    }
}
