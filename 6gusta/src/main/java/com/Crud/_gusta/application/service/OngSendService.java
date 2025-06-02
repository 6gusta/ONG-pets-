package com.Crud._gusta.application.service;


import com.Crud._gusta.exceptionsGenerics.CustomException;
import com.Crud._gusta.domain.model.CadastroOng;
import com.Crud._gusta.infrastructure.repository.OngCadastroRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OngSendService {

    private final OngCadastroRepository ongCadastroRepository;
    private static final Logger LOGGER = Logger.getLogger(OngSendService.class.getName());

    public OngSendService(OngCadastroRepository ongCadastroRepository) {
        this.ongCadastroRepository = ongCadastroRepository;
    }

    public CadastroOng SendService(String nome, String email, String senha) {
        try {


            CadastroOng cadastro = new CadastroOng();
            cadastro.setNome(nome);
            cadastro.setEmail(email);
            cadastro.setSenha(BCrypt.hashpw(senha, BCrypt.gensalt()));


            return ongCadastroRepository.save(cadastro);


        } catch (Exception e) {
           throw new CustomException(" ERRO AO SALVAR ONG CADASTRADA ", e, "SAVE_ERROR");



        }
    }

}
