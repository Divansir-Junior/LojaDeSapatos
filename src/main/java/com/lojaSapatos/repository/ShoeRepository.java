package com.lojaSapatos.repository;

import com.lojaSapatos.model.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoeRepository  extends JpaRepository <Shoe,Long> {

    Shoe findByName(String name);
    Shoe filterShoe(String name,String brand,int size);


}
