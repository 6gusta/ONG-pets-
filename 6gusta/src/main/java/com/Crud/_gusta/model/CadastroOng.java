package com.Crud._gusta.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CadastroOng")
public class CadastroOng {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idong;
    private String nome;
    private String email;
    private String  senha;

    private String role;
}
