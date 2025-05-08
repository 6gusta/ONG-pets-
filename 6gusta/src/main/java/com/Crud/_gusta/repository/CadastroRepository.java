package com.Crud._gusta.repository;

import com.Crud._gusta.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CadastroRepository  extends JpaRepository<Model, Long> , JpaSpecificationExecutor<Model> {


    Model findByNome(String nome);

}
