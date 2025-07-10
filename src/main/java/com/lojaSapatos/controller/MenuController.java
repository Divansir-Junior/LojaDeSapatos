package com.lojaSapatos.controller;

import com.lojaSapatos.view.Exit;
import com.lojaSapatos.view.MainSystem;
import org.springframework.stereotype.Component;

@Component
public class MenuController {
    Exit exit = new Exit();
    MainSystem mainSystem = new MainSystem();

    public void options(String choice) {
        switch (choice.toLowerCase()) {
            case "login":
            case "0":
                System.out.println("🔐 Você entrou no sistema!");
                mainSystem.showMainSystem();
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
