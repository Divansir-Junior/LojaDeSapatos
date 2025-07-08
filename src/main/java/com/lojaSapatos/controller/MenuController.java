package com.lojaSapatos.controller;

import org.springframework.stereotype.Component;

@Component
public class MenuController {

    public void options(String choice) {
        switch (choice.toLowerCase()) {
            case "entrar":
            case "0":
                System.out.println("🔐 Você entrou no sistema!");
                break;
            case "sair":
            case "1":
                System.out.println("👋 Você saiu do sistema.");
                break;
            default:
                System.out.println("❌ Opção inválida. Tente novamente.");
        }
    }

    public boolean isExit(String choice) {
        return choice.equalsIgnoreCase("sair") || choice.equals("1");
    }
}
