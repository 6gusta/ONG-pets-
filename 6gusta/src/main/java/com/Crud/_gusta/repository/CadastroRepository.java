package com.Crud._gusta.repository;

import com.Crud._gusta.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository  extends JpaRepository<Model, Long> {


    Model findByNome(String nome);
}
