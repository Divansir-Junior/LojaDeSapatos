package com.lojaSapatos.model;

import com.lojaSapatos.enums.ShoeColor;
import jakarta.persistence.*;

@Entity
@Table(name = "Shoe")
public class Shoe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 20)
    private String brand;

    @Column(nullable= false)
    private int size;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ShoeColor shoeColor;

    public Shoe() {
    }

    public Shoe(Long id, String name, String brand, int size) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.size = size;
    }

    public Shoe(String name, String brand, int size) {
        this.name = name;
        this.brand = brand;
        this.size = size;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ShoeColor getShoeColor() {
        return shoeColor;
    }

    public void setShoeColor(ShoeColor shoeColor) {
        this.shoeColor = shoeColor;
    }

    @Override
    public String toString() {
        return "Tênis encontrado : Sapato n | " +
                "NAME = \"" + name + "\" | " +
                "SIZE = \"" + size + "\" | " +
                "BRAND = \"" + brand + "\" | " +
                "COLOR = \"" + shoeColor + "\"\n" ;

    }
}


