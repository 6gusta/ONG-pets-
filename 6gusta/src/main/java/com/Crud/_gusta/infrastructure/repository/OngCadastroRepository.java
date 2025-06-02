package com.Crud._gusta.infrastructure.repository;

import com.Crud._gusta.domain.model.CadastroOng;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OngCadastroRepository  extends JpaRepository<CadastroOng, Long> {

     CadastroOng findByNome(String nome);
}
