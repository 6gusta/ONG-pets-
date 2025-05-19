package com.Crud._gusta.repository;

import com.Crud._gusta.model.PetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CadastroRepository  extends JpaRepository<PetModel, Long> , JpaSpecificationExecutor<PetModel> {


    PetModel findByNome(String nome);

}
