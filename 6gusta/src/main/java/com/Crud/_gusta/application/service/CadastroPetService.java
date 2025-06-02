package com.Crud._gusta.application.service;



import com.Crud._gusta.domain.model.PetModel;
import com.Crud._gusta.infrastructure.repository.CadastroRepository;
import com.Crud._gusta.infrastructure.repository.OngCadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class CadastroPetService {

    private static final Logger LOGGER = Logger.getLogger(CadastroPetService.class.getName());

    private final CadastroRepository  cadastroRepository;


    @Autowired
    public CadastroPetService(CadastroRepository cadastroRepository, OngCadastroRepository ongCadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }


    private PasswordEncoder passwordEncoder;

    public PetModel cadastropet(String nome , String idade, String sexo, String porte, String cidade, String Caracteristicas, String descricao, String fotoperfil , String estado) {




            PetModel cadastro = new PetModel();
            cadastro.setNome(nome);
            cadastro.setIdade(idade);
            cadastro.setSexo(sexo);
            cadastro.setPorte(porte);
            cadastro.setCidade(cidade);
            cadastro.setCaracteristicas(Caracteristicas);
            cadastro.setDescricao(descricao);
            cadastro.setFotoperfil(fotoperfil);
            cadastro.setEstado(estado);




            return cadastroRepository.save(cadastro);

    }







}


