package com.lojaSapatos.controller;

import com.lojaSapatos.enums.ShoeColor;
import com.lojaSapatos.model.Shoe;
import com.lojaSapatos.services.PdfService;
import com.lojaSapatos.services.ShoeService;
import com.lojaSapatos.util.LineMaker;
import com.lojaSapatos.view.MenuView;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class MainSystemController {

    private final MenuView menuView;
    private final ShoeService shoeService;
    private final Scanner scanner = new Scanner(System.in);
    private  PdfService pdfService ;
    private  LineMaker lineMaker;

    public MainSystemController(MenuView menuView, ShoeService shoeService, LineMaker lineMaker,PdfService pdfService) {
        this.menuView = menuView;
        this.shoeService = shoeService;
        this.lineMaker = lineMaker;
        this.pdfService = pdfService;
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
                break;

            case "delete shoe":
            case "3":
                System.out.println("Digite o ID PARA DELETAR:");
                deleteShoe();
                break;

            case "list all":
            case "4":
                System.out.println("📋 Listando todos os sapatos...");
                findAll();
                break;

            case "filter":
            case "5":
                filterShoe();
                break;

            case "import doc":
            case "6":
                System.out.println("📥 Importando documento... (ainda não implementado)");
                break;

            case "export doc":
            case "7":
                pdfService.createPDF("Relatorio.pdf","id:1");
                break;

            case "8":
                menuView.showMainMenu();
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

        System.out.println("Cor do sapato : ");
        String colorShoe  = scanner.nextLine();
        ShoeColor chosenColor = ShoeColor.valueOf(colorShoe.toUpperCase());

        System.out.println("Marca do tênis : ");
        String brand = scanner.nextLine();

        System.out.print("Tamanho do sapato: ");
        int size = Integer.parseInt(scanner.nextLine());

        Shoe shoe = new Shoe(name,brand,size);
        shoe.setShoeColor(chosenColor);

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

    private void findAll() {
        List<Shoe> sapatos = shoeService.listAll();

        if (sapatos.isEmpty()) {
            System.out.println("ERRO");
            System.out.println("📭 Nenhum sapato encontrado.");
        } else {
            System.out.println("📋 Lista de sapatos encontrados:");
            for (Shoe s : sapatos) {
                System.out.println(s); // usa o toString da entidade
            }
        }
    }

    private boolean deleteShoe() {
        Long id = scanner.nextLong();
        shoeService.deleteShoe(id);
        return true;
    }

    private void filterShoe() {
        System.out.println("\n📦 Filtro de Tênis");

        System.out.print("🔤 Nome: ");
        String name = scanner.nextLine().trim();

        System.out.print("🏷️ Marca: ");
        String brand = scanner.nextLine().trim();

        System.out.print("📏 Tamanho do tênis: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // limpar quebra de linha

        System.out.println("\n🔎 Buscando tênis com os critérios informados...\n");

        Optional<Shoe> resultado = shoeService.filterShoe(name, brand, size);

        resultado.ifPresentOrElse(shoe -> {
            System.out.println("✅ Tênis encontrado:");
            System.out.printf("  🆔 ID     : %d%n", shoe.getId());
            System.out.printf("  👟 Nome   : %s%n", shoe.getName());
            System.out.printf("  🏷️ Marca  : %s%n", shoe.getBrand());
            System.out.printf("  📏 Tamanho: %d%n", shoe.getSize());

        }, () -> {
            System.out.println("❌ Nenhum tênis encontrado com os critérios informados.");
        });
    }
}
