package com.lojaSapatos;

import com.lojaSapatos.controller.MainSystemController;
import com.lojaSapatos.controller.MenuController;
import com.lojaSapatos.view.MainSystem;
import com.lojaSapatos.view.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        var context = SpringApplication.run(Main.class, args);

        Menu menu = context.getBean(Menu.class);
        MenuController menuController = context.getBean(MenuController.class);
        MainSystem mainSystem = context.getBean(MainSystem.class);
        MainSystemController systemController = context.getBean(MainSystemController.class);
        Scanner sc = new Scanner(System.in);


        String escolha = menu.ShowMainMenu();
        menuController.options(escolha);

        //Sai do programa
        if (menuController.isExit(escolha)) {
            System.out.println("Saindo do sistema...");
            return;
        }

        while (true) {
            mainSystem.showMainSystem(); // Exibe o menu
            String opcao = sc.nextLine().toLowerCase();

            if (opcao.equals("esc")) {
                System.out.println("Voltando ao menu principal...");
                break;
            }

            systemController.mainOptions(opcao);
        }
    }
}
