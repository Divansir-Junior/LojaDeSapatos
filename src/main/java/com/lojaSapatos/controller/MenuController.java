package com.lojaSapatos.controller;

import com.lojaSapatos.view.Exit;
import com.lojaSapatos.view.MainSystemView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuController {

    private final Exit exit;
    private final MainSystemView mainSystemView;

    @Autowired
    public MenuController(Exit exit, MainSystemView mainSystemView) {
        this.exit = exit;
        this.mainSystemView = mainSystemView;
    }

    public void options(String choice) {
        switch (choice.toLowerCase()) {
            case "login":
            case "0":
                System.out.println("🔐 Você entrou no sistema!");
                mainSystemView.showMainSystem();
                break;
            case "exit":
            case "1":
                System.out.println("👋 Você saiu do sistema.");
                exit.exitMenu();
                break;
            default:
                System.out.println("❌ Opção inválida. Tente novamente.");
        }
    }

    public boolean isExit(String choice) {
        return choice.equalsIgnoreCase("exit") || choice.equals("1");
    }
}
