package com.Crud._gusta.service;


import com.Crud._gusta.model.InteressadosPet;
import com.Crud._gusta.repository.InteressadosOngRepository;
import org.springframework.stereotype.Service;

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
}
