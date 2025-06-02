package com.Crud._gusta.application.service;


import com.Crud._gusta.domain.model.PetModel;
import com.Crud._gusta.infrastructure.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetPetsService {

    @Autowired
    CadastroRepository cadastroRepository;

    public Optional<PetModel> buscarpet(Long petId) {
        return cadastroRepository.findById(petId);
    }
    public List<PetModel> listarTodos() {
        return cadastroRepository.findAll();
    }



}
