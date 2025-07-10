package com.lojaSapatos.controller;

import com.lojaSapatos.view.Exit;
import org.springframework.stereotype.Component;

@Component
public class MenuController {
    Exit exit = new Exit();

    public void options(String choice) {
        switch (choice.toLowerCase()) {
            case "login":
            case "0":
                System.out.println("🔐 Você entrou no sistema!");
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
