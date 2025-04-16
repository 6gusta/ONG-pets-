package com.Crud._gusta.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="interessadosPet")
public class InteressadosPet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idCadastrado;
    private String nome;
    private String email;
    private String descricao;
    private String telefone;
}
