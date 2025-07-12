package com.lojaSapatos.controller;

import com.lojaSapatos.view.Menu;
import org.springframework.stereotype.Component;

@Component
public class MainSystemController {
    private final Menu menu;

    public MainSystemController(Menu menu) {
        this.menu = menu;
    }

    public void mainOptions(String choice) {
        switch (choice.toLowerCase()) {
            case "create shoe":
            case "1":
                System.out.println("👟 Criando sapato...");
                break;

            case "search shoe":
            case "2":
                System.out.println("🔍 Buscando sapato...");
                break;

            case "delete shoe":
            case "3":
                System.out.println("🗑️ Deletando sapato...");
                break;

            case "list all":
            case "4":
                System.out.println("📋 Listando todos os sapatos...");
                break;

            case "filter":
            case "5":
                System.out.println("🔎 Filtrando resultados...");
                break;

            case "import doc":
            case "6":
                System.out.println("📥 Importando documento...");
                break;

            case "export doc":
            case "7":
                System.out.println("📤 Exportando documento...");
                break;

            case "8":
                menu.ShowMainMenu();
                System.out.println("Saindo");
                break;

            default:
                System.out.println("❌ Opção inválida. Tente novamente.");
                break;
        }
    }
}
