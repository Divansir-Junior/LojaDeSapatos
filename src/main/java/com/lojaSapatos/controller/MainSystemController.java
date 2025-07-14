package com.lojaSapatos.controller;

import com.lojaSapatos.enums.ShoeColor;
import com.lojaSapatos.model.Shoe;
import com.lojaSapatos.services.ShoeService;
import com.lojaSapatos.util.LineMaker;
import com.lojaSapatos.view.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainSystemController {

    private final Menu menu;
    private final ShoeService shoeService;
    private final Scanner scanner = new Scanner(System.in);

    private  LineMaker lineMaker;

    public MainSystemController(Menu menu, ShoeService shoeService, LineMaker lineMaker) {
        this.menu = menu;
        this.shoeService = shoeService;
        this.lineMaker = lineMaker;
    }


    public void mainOptions(String choice) {
        switch (choice.toLowerCase()) {
            case "create shoe":
            case "1":
                createShoe();
                break;

            case "search shoe":
            case "2":
                searchShoe();
                System.out.println("🔍 Buscando sapato... (ainda não implementado)");
                break;

            case "delete shoe":
            case "3":
                System.out.println("🗑️ Deletando sapato... (ainda não implementado)");
                break;

            case "list all":
            case "4":
                System.out.println("📋 Listando todos os sapatos...");

                break;

            case "filter":
            case "5":
                System.out.println("🔎 Filtrando resultados... (ainda não implementado)");
                break;

            case "import doc":
            case "6":
                System.out.println("📥 Importando documento... (ainda não implementado)");
                break;

            case "export doc":
            case "7":
                System.out.println("📤 Exportando documento... (ainda não implementado)");
                break;

            case "8":
                menu.showMainMenu();
                System.out.println("Saindo");
                break;

            default:
                System.out.println("❌ Opção inválida. Tente novamente.");
                break;
        }
    }

    private void createShoe() {
        System.out.print("Nome do sapato: ");
        String name = scanner.nextLine();

        System.out.print("Tamanho do sapato: ");
        int size = Integer.parseInt(scanner.nextLine());

        Shoe shoe = new Shoe();
        shoe.setName(name);
        shoe.setSize(size);
        shoe.setBrand("Nike");
        shoe.setShoeColor(ShoeColor.BROWN);

        Shoe saved = shoeService.saveShoe(shoe);
        System.out.println("✅ Sapato criado com ID: " + saved.getId());
    }

    private void searchShoe() {
        System.out.println("Nome de busca :");
        String nameSearch = scanner.nextLine();

        Shoe res = shoeService.searchShoeByName(nameSearch);


        if (res != null) {
            System.out.println("✅ Tênis achado: " + res);

        }

        else {
            System.out.println("❌ Nenhum tênis encontrado com esse nome.");
        }
        System.out.println(lineMaker.makeLine());


    }

}
