package view;

import controller.MenuController;

import java.util.Scanner;

public class Menu {

    private final MenuController controller = new MenuController();

    public void ShowMainMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================================================================================");
        System.out.println("  _   _   ______   _______             _____   _    _    ____    ______ \n" +
                " | \\ | | |  ____| |__   __|           / ____| | |  | |  / __ \\  |  ____|\n" +
                " |  \\| | | |__       | |     ______  | (___   | |__| | | |  | | | |__   \n" +
                " | . ` | |  __|      | |    |______|  \\___ \\  |  __  | | |  | | |  __|  \n" +
                " | |\\  | | |____     | |              ____) | | |  | | | |__| | | |____ \n" +
                " |_| \\_| |______|    |_|             |_____/  |_|  |_|  \\____/  |______");
        System.out.println("====================================================================================================");
        System.out.println("DIGITE SUA ESCOLHA:");
        System.out.println("ENTRAR");
        System.out.println("SAIR");
        System.out.print("👉 ");

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
