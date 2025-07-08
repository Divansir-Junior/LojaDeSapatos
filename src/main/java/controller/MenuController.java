package controller;

public class MenuController {
    public void options(String choice) {
        switch (choice.toLowerCase()) {
            case "entrar":
                System.out.println("🔐 Você entrou no sistema!");
                break;
            case "sair":
                System.out.println("👋 Você saiu do sistema.");
                break;
            default:
                System.out.println("❌ Opção inválida. Tente novamente.");
        }
    }
}
