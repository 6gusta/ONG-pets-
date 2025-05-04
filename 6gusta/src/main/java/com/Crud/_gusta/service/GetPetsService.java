package com.Crud._gusta.service;


import com.Crud._gusta.model.CadastroOng;
import com.Crud._gusta.model.Model;
import com.Crud._gusta.repository.CadastroRepository;
import com.Crud._gusta.repository.OngCadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetPetsService {

    @Autowired
    CadastroRepository cadastroRepository;

    public Optional<Model> buscarpet(Long petId) {
        return cadastroRepository.findById(petId);
    }
    public List<Model> listarTodos() {
        return cadastroRepository.findAll();
    }



}
