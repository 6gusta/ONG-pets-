package com.Crud._gusta.infrastructure.repository;

import com.Crud._gusta.domain.model.PetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CadastroRepository  extends JpaRepository<PetModel, Long> , JpaSpecificationExecutor<PetModel> {


    PetModel findByNome(String nome);

}
