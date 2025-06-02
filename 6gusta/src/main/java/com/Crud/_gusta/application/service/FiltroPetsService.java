package com.Crud._gusta.application.service;


import com.Crud._gusta.domain.model.ModelSpecification;
import com.Crud._gusta.domain.model.PetModel;
import com.Crud._gusta.infrastructure.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiltroPetsService {
    @Autowired
    private CadastroRepository cadastro;

    public List<PetModel> filtrar(String porte, String cidade, String estado, String idade) {
        System.out.println(">>> filtros: idade='" + idade + "', porte='" + porte + "', cidade='" + cidade + "', estado='" + estado + "'");
        return cadastro.findAll(ModelSpecification.filter(porte, cidade, estado, idade));
    }
}
