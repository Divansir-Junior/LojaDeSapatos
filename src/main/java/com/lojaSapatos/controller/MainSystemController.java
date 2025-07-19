package com.lojaSapatos.controller;

import com.lojaSapatos.services.PdfService;
import com.lojaSapatos.services.ShoeService;
import com.lojaSapatos.util.LineMaker;
import com.lojaSapatos.view.MenuView;
import org.springframework.stereotype.Component;
import java.util.Scanner;
import com.lojaSapatos.interaction.InputHandler;

@Component
public class MainSystemController {

    private final InputHandler inputHandler;
    private final MenuView menuView;
    private  PdfService pdfService ;
    private  LineMaker lineMaker;

    public MainSystemController(InputHandler inputHandler, MenuView menuView, LineMaker lineMaker, PdfService pdfService) {
        this.inputHandler = inputHandler;
        this.menuView = menuView;

        this.lineMaker = lineMaker;
        this.pdfService = pdfService;
    }

    public void mainOptions(String choice) {
        switch (choice.toLowerCase()) {
            case "create shoe":
            case "1":
                inputHandler.saveShoe();
                break;

            case "search shoe":
            case "2":
                inputHandler.searchShoe();
                break;

            case "delete shoe":
            case "3":
                System.out.println("Digite o ID PARA DELETAR:");
                inputHandler.deleteShoe();
                break;

            case "list all":
            case "4":
                System.out.println("📋 LISTAGEM ");
                lineMaker.makeLine();
                inputHandler.findAll();
                lineMaker.makeLine();
                break;

            case "filter":
            case "5":
                inputHandler.filterShoe();
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

}
