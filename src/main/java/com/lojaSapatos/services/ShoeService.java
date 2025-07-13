package com.lojaSapatos.services;



import com.lojaSapatos.repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lojaSapatos.model.Shoe; // ou o caminho real da sua entidade

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
}
