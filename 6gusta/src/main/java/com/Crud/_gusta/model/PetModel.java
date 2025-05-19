package com.Crud._gusta.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table( name = "PetModel")
public class PetModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpet;
    private String nome;
    private String idade;
    private String sexo;
    private String porte;
    private String cidade;
    private String estado;
    private String caracteristicas;
    private String descricao;

    @Lob
     private String fotoperfil ;



}
