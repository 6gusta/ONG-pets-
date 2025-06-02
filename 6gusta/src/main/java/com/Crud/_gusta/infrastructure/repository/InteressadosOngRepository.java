package com.Crud._gusta.infrastructure.repository;

import com.Crud._gusta.domain.model.InteressadosPet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InteressadosOngRepository  extends JpaRepository<InteressadosPet, Long> {


    InteressadosPet findByNome(String nome);

}
