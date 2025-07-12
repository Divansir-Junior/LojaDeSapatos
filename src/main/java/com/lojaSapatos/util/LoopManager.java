package com.lojaSapatos.util;

import com.lojaSapatos.controller.MainSystemController;
import com.lojaSapatos.controller.MenuController;
import com.lojaSapatos.view.MainSystem;
import com.lojaSapatos.view.Menu;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LoopManager {

    private final Menu menu;
    private final MenuController menuController;
    private final MainSystem mainSystem;
    private final MainSystemController systemController;
    private final ClearTerminal clearTerminal;

    public LoopManager(Menu menu,
                       MenuController menuController,
                       MainSystem mainSystem,
                       MainSystemController systemController) {
        this.menu = menu;
        this.menuController = menuController;
        this.mainSystem = mainSystem;
        this.systemController = systemController;
        this.clearTerminal = new ClearTerminal(); // can also be injected if preferred
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String state = "MAIN_MENU";

        while (true) {
            clearTerminal.clsTerminal();
            switch (state) {
                case "MAIN_MENU" -> {
                    String input = menu.showMainMenu();

                    if (menuController.isExit(input)) {
                        System.out.println("Exiting the system...");
                        return;
                    }

                    menuController.options(input);
                    state = "SYSTEM_MENU";
                }

                case "SYSTEM_MENU" -> {
                    mainSystem.showMainSystem();
                    String option = scanner.nextLine().toLowerCase();

                    if (option.equals("8")) {
                        state = "MAIN_MENU";
                    } else {
                        systemController.mainOptions(option);
                    }
                }
            }
        }
    }
}
