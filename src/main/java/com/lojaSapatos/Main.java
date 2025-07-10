package com.lojaSapatos;

import com.lojaSapatos.controller.MenuController;
import com.lojaSapatos.view.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        var context = SpringApplication.run(Main.class, args);

        Menu menu = context.getBean(Menu.class);
        MenuController controller = context.getBean(MenuController.class);

        while (true) {
            String escolha = menu.ShowMainMenu();
            controller.options(escolha);

            if (controller.isExit(escolha)) {
                break;
            }
        }
    }
}



