package com.lojaSapatos.interaction;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import com.lojaSapatos.enums.ShoeColor;
import com.lojaSapatos.model.Shoe;
import com.lojaSapatos.services.ShoeService;
import org.springframework.stereotype.Component;

@Component
public class InputHandler {

    private final Scanner sc = new Scanner(System.in);

    private final ShoeService shoeService;

    public InputHandler(ShoeService shoeService) {

        this.shoeService = shoeService;
    }

    public void saveShoe(){
        System.out.println("Digite o nome do tênis :");
        String name = sc.nextLine();

        System.out.println("Cor do sapato:");
        String colorInput = sc.nextLine().toUpperCase();
        ShoeColor shoeColor = ShoeColor.valueOf(colorInput);

        System.out.println("Marca do sapato :");
        String brand = sc.nextLine();

        System.out.println("Número do tênis : ");
        int size = Integer.parseInt(sc.nextLine());


        Shoe shoe = new Shoe(name, brand, size);
        shoe.setShoeColor(shoeColor);
        shoeService.saveShoe(shoe);

    }

    public boolean searchShoe() {
        System.out.println("Nome do tênis : ");
        String nameSearch = sc.nextLine().trim();

        Shoe res = shoeService.searchShoeByName(nameSearch);
        if (res != null) {
            System.out.println("Tênis encontrado : " + res);
            return true;
        }
        System.out.println("Nenhum tÊnis encontrado com esse nome");
        return false;
    }

    public void findAll() {
        List<Shoe> shoes = shoeService.listAll();
        if (shoes.isEmpty()) {
            System.out.println("Lista vazia");
        } else {
            System.out.println("Lista de tênis:");
            shoes.forEach(shoe -> System.out.println(shoe));
        }
    }

    public boolean deleteShoe() {
        try {
            Long id = sc.nextLong();
            sc.nextLine();

            shoeService.deleteShoe(id);
            System.out.println("Tênis deletado");
            return true;
        } catch (Exception e) {
            System.out.println("Erro" + e);
            sc.nextLine();
            return false;
        }
    }

    public boolean filterShoe() {
        System.out.println("Filtro de tÊnis : ");

        System.out.println("Nome : ");
        String filterName = sc.nextLine();

        System.out.println("Marca : ");
        String filterBrand = sc.nextLine();

        System.out.println("Tamanho : ");
        int filterSize = sc.nextInt();

        System.out.println("BUSCANDO TÊNIS ....");

        Optional<Shoe> filterResult = shoeService.filterShoe(filterName, filterBrand, filterSize);

        if (filterResult.isPresent()) {
            Shoe shoe = filterResult.get();
            System.out.println("✅ Tênis encontrado:");
            System.out.printf("  🆔 ID     : %d%n", shoe.getId());
            System.out.printf("  👟 Nome   : %s%n", shoe.getName());
            System.out.printf("  🏷️ Marca  : %s%n", shoe.getBrand());
            System.out.printf("  📏 Tamanho: %d%n", shoe.getSize());
            return true;
        } else {
            System.out.println("❌ Nenhum tênis encontrado com os critérios informados.");
            return false;
        }
    }

}
