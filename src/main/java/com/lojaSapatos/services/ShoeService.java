package com.lojaSapatos.services;
import com.lojaSapatos.repository.ShoeRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lojaSapatos.model.Shoe; // ou o caminho real da sua entidade
import java.util.Optional;
import java.util.List;

@Service

public class ShoeService {

   private final ShoeRepository shoeRepository;

    @Autowired
    public ShoeService(ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    public Shoe saveShoe(Shoe shoe) {
        return  shoeRepository.save(shoe);

    }

    public Shoe searchShoeByName(String name) {
        return shoeRepository.findByName(name);
    }

    public Shoe deleteShoe(Long id) {
        Optional<Shoe> shoeOptional = shoeRepository.findById(id);
        if (shoeOptional.isPresent()) {
            Shoe shoe = shoeOptional.get();
            shoeRepository.deleteById(id);
            return shoe;
        }
        throw new IllegalArgumentException("ID inválido");

    }

    public List<Shoe> listAll() {
        return shoeRepository.findAll();
    }

    public Optional<Shoe> filterShoe(String name, String brand, int size) {
        return shoeRepository.findByNameAndBrandAndSize(name, brand, size);
    }


}
