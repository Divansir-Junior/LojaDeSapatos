package com.lojaSapatos.application;

import com.lojaSapatos.application.view.Menu;
import com.lojaSapatos.application.controller.MenuController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Startup implements CommandLineRunner {

    private final Menu menu;
    private final MenuController controller;

    public Startup(Menu menu, MenuController controller) {
        this.menu = menu;
        this.controller = controller;
    }

    @Override
    public void run(String... args) {
        String escolha;

        do {
            escolha = menu.ShowMainMenu();
            controller.options(escolha);
        } while (!controller.isExit(escolha));
    }
}
