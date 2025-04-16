package com.Crud._gusta.repository;

import com.Crud._gusta.model.InteressadosPet;
import com.Crud._gusta.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InteressadosOngRepository  extends JpaRepository<InteressadosPet, Long> {


    InteressadosPet findByNome(String nome);

}
