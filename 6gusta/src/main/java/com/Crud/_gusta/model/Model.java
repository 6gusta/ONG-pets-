package com.Crud._gusta.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table( name = "Model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpet;
    private String nome;
    private String idade;
    private String sexo;
    private String Porte;
    private String cidade;
    private String Caracteristicas;
    private String descricao;
     private String fotoperfil ;



}
