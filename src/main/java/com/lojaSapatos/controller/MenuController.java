package com.lojaSapatos.controller;

import com.lojaSapatos.view.MainSystemView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuController {

    private final MainSystemView mainSystemView;

    @Autowired
    public MenuController( MainSystemView mainSystemView) {
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
                break;
            default:
                System.out.println("❌ Opção inválida. Tente novamente.");
        }
    }

    public boolean isExit(String choice) {
        return choice.equalsIgnoreCase("exit") || choice.equals("1");
    }
}
