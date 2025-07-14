package com.lojaSapatos.util;

import com.lojaSapatos.controller.MainSystemController;
import com.lojaSapatos.controller.MenuController;
import com.lojaSapatos.view.MainSystemView;
import com.lojaSapatos.view.MenuView;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LoopManager {

    private final MenuView menuView;
    private final MenuController menuController;
    private final MainSystemView mainSystemView;
    private final MainSystemController systemController;
    private final ClearTerminal clearTerminal;

    public LoopManager(MenuView menuView,
                       MenuController menuController,
                       MainSystemView mainSystemView,
                       MainSystemController systemController) {
        this.menuView = menuView;
        this.menuController = menuController;
        this.mainSystemView = mainSystemView;
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
                    String input = menuView.showMainMenu();

                    if (menuController.isExit(input)) {
                        System.out.println("Exiting the system...");
                        return;
                    }

                    menuController.options(input);
                    state = "SYSTEM_MENU";
                }

                case "SYSTEM_MENU" -> {
                    mainSystemView.showMainSystem();
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
