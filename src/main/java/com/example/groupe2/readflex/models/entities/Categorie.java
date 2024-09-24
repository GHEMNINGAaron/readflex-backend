package com.example.groupe2.readflex.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name = "categories")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name",nullable = false,unique = true)
    private String name;

    //@OneToMany(mappedBy = "categorie")  // Une catégorie peut avoir plusieurs films
    //private List<> films;
    public Categorie() {}

    public Categorie(String name) {
        this.name = name;
    }


    //TODO : ajouter la liste des films assosier????



}
