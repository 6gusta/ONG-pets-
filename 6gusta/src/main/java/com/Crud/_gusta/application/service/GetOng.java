package com.Crud._gusta.application.service;


import com.Crud._gusta.domain.model.InteressadosPet;
import com.Crud._gusta.infrastructure.repository.InteressadosOngRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetOng {
    private final  InteressadosOngRepository interessadosOngRepository;


    public GetOng(InteressadosOngRepository interessadosOngRepository) {
        this.interessadosOngRepository = interessadosOngRepository;
    }

    public Optional<InteressadosPet> buscaONG(Long  idCadastrado) {

        Optional<InteressadosPet> interessadosPet = interessadosOngRepository.findById(idCadastrado);
        return interessadosPet;
    }

    public List<InteressadosPet> buscaONGs() {

        return interessadosOngRepository.findAll();
    }
}
