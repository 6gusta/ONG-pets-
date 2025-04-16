package com.Crud._gusta.repository;

import com.Crud._gusta.model.CadastroOng;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OngCadastroRepository  extends JpaRepository<CadastroOng, Long> {

     CadastroOng findByNome(String nome);
}
